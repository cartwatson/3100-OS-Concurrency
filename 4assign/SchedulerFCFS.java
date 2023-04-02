import java.util.ArrayList;

public class SchedulerFCFS extends SchedulerBase implements Scheduler {
    // class variables
    Platform platform;
    private ArrayList<Process> processes = new ArrayList<Process>();

    // constructor
    public SchedulerFCFS(Platform platform) {
        this.platform = platform;
    }

    // methods
    // The simulator platform invokes this whenever a new process arrives and is available to be scheduled.
    public void notifyNewProcess(Process p) {
        // add process to end of list
        processes.add(p);
    }

    // The simulator platform invokes this each time increment.  The scheduler should update the scheduling when this method is called
    // The cpu parameter is the currently running process on that cpu.  If no process is running on that cpu, cpu is null.
    // The return value is the process that should be (or continue to be) scheduled.
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

        return cpu;
    }
}
