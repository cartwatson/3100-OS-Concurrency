import java.util.*;

// FIFO Queue is a shared resource available to all worker threads,
    // it must be protected against race conditions.
    // Pass a reference to the queue via the worker thread's constructor
    // (not a global variable).
public class TaskQueue {
    List queue = Collections.synchronizedList(new LinkedList());

    public TaskQueue(int size) {
        // Create FIFO Queue
        // TODO: protect against race conditions
        // create array list so tasks can be randomized
        ArrayList tasks = new ArrayList<Task>();
        for (long i = 1; i <= size; i++) {
            tasks.add(new Task(i));
        }
        // randomize tasks
        java.util.Collections.shuffle(tasks);
        // loop through array and add to task queue
        for (Task t : tasks) {
            // fully populate with size tasks, each task should say what digit to compute
            queue.add(t);
        }
    }
}