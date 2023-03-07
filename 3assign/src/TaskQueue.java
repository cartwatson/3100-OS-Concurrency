import java.util.*;

// FIFO Queue is a shared resource available to all worker threads,
    // it must be protected against race conditions.
    // Pass a reference to the queue via the worker thread's constructor
    // (not a global variable).
public class TaskQueue {
    linkedlist queue;

    public TaskQueue() {
        // Create FIFO Queue
        // TODO: protect against race conditions
        // create array list so tasks can be randomized
        ArrayList tasks = new ArrayList<Task>();
        for (long i = 1; i <= 1000; i++) {
            tasks.add(new Task(i));
        }
        // randomize tasks
        java.util.Collections.shuffle(tasks);
        // loop through array and add to task queue
        for (Task t : tasks) {
            // fully populate with 1000 tasks, each task should say what digit to compute
            queue.add(t);
        }
    }
}