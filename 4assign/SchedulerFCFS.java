

public class SchedulerFCFS implements Scheduler {
    // class variables
    private int contextSwitches;

    // constructor
    public SchedulerFCFS(Platform platform) {

    }

    // methods
    public int getNumberOfContextSwitches() {
        return contextSwitches;
    }

    public void notifyNewProcess(Process process) {
        // TODO: implement
    }

    public Process update(Process process) {
        // TODO: implement
    }
}
