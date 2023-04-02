import java.util.ArrayList;

public class SchedulerRR extends SchedulerBase implements Scheduler {
    // class variables
    private Platform platform;
    private int timeQuantum;
    private ArrayList<Process> processes = new ArrayList<Process>();

    // constructor
    public SchedulerRR(Platform platform, int timeQuantum) {
        this.platform = platform;
        this.timeQuantum = timeQuantum;
    }

    // methods
    public void notifyNewProcess(Process p) {
        // add process to end of list
        processes.add(p);
    }

    public Process update(Process cpu) {
        Process next = null;

        // start of program, throw out first process
        if (cpu == null) {
            next = processes.get(0);
            contextSwitches++; // increment context switch
            platform.log(" Scheduled: " + next.getName());
            return next;
        }

        // burst complete
        if (cpu.isBurstComplete()) {
            platform.log(" Process " + cpu.getName() + " burst complete");

            // take completed burst process off queue
            Process temp = processes.remove(0);
            contextSwitches++; // increment context switch
            
            // execution is compelete
            if (cpu.isExecutionComplete()) { platform.log(" Process " + cpu.getName() + " execution complete"); }
            // only re-add process to queue if process is not completed
            else { processes.add(temp); }
            
            if (!processes.isEmpty()) {
                // grab next process
                next = processes.get(0);
                contextSwitches++; // increment context switch

                // log schedule
                platform.log(" Scheduled: " + next.getName());
            }

            // move to next process
            return next;
        }
        // burst not complete
        else {
            // if time quantum is up
            if (cpu.getElapsedBurst() % timeQuantum == 0) {
                platform.log(" Time Quantum complete for process " + cpu.getName());

                // take completed burst process off queue
                Process temp = processes.remove(0);
                contextSwitches++; // increment context switch

                // re-add because it's not done
                processes.add(temp);

                next = processes.get(0);
                contextSwitches++;
                platform.log(" Scheduled: " + next.getName());
                return next;
            }
        }

        return cpu;
    }
}
