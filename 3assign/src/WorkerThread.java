/**
 * @author Carter Watson A02312565@usu.edu
 */
public class WorkerThread {
    private TaskQueue taskQueue;
    private ResultTable resultTable;
    private Task task = null;

    // constructor
    // TODO: pass queue and result table by reference
    public WorkerThread(TaskQueue q, ResultTable rt) {
        taskQueue = q;
        resultTable = rt; 
    }

    public void compute() {
        // compute
        int result = task.getResult();
        // add to hash table
        resultTable.insert(task.digitToCompute, result);
        // task is complete
        task = null;
    }
    
    public boolean hasTask() {
        return (task == null);
    }

    public void getTask() {
        task = taskQueue.pull();
    }
}
