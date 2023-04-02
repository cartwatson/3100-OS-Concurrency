import java.util.ArrayList;

public class SchedulerSJF extends SchedulerBase implements Scheduler {
    // class variables
    private Platform platform;
    private ArrayList<Process> processes = new ArrayList<Process>();

    // constructor
    public SchedulerSJF(Platform platform) {
        this.platform = platform;
    }

    // methods
    public void notifyNewProcess(Process p) {
        // first element, add
        if (processes.isEmpty()) { processes.add(p); return; }
        
        // find process' place in queue
        for (int i = 0; i < processes.size(); i++) {
            // if total time of current element is less than total time of incoming process
            if (processes.get(i).getTotalTime() > p.getTotalTime()) { processes.add(i, p); return; }
        }

        // proccess total time is larger than all current processes, add as final element
        processes.add(p);
        return;
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
            Process curr = processes.remove(0);
            contextSwitches++; // increment context switch
            
            // execution is compelete
            if (cpu.isExecutionComplete()) { platform.log(" Process " + cpu.getName() + " execution complete"); }
            // only re-add process to queue if process is not completed
            else { processes.add(curr); }
            
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

        // process not complete, return keep working on it
        return cpu;
    }
}
