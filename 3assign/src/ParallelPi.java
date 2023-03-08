import java.lang.Runtime;
import java.util.*;

public class ParallelPi {
    public static void main(String[] args) {
        // number of digits to compute
        final int numOfDigits = 50;

        // get runtime instance
        Runtime runtime = Runtime.getRuntime();

        // start time
        long start = System.currentTimeMillis();

        // create queue
        TaskQueue taskQueue = new TaskQueue(numOfDigits);

        // create hash table
        ResultTable results = new ResultTable(numOfDigits);

        // number of worker threads = number of cores
        ArrayList workerThreads = new ArrayList<WorkerThread>();
        for (int i = 0; i < runtime.availableProcessors(); i++) {
            // create worker threads
            workerThreads.add(new WorkerThread(taskQueue, results));
        }

        // init counter for outputing loading symbols
        int x = 10;
        System.out.print("Loading");
        while (results.getSize() < numOfDigits) {
            // for every tenth digit computed ouput a period
            int digitsComputed = 0;
            if (results.getSize() >= x) {
                x += 10;
                System.out.print(".");
                System.out.flush();
            }
            
            // keep worker threads going
            for (int i = 0; i < workerThreads.size(); i++) {
                WorkerThread w = (WorkerThread) workerThreads.get(i);
                if (w.hasTask()) {
                    w.compute();
                } else {
                    if (!taskQueue.isEmpty()) {
                        w.getTask();
                    }
                }
            }
        }
        //end line after loading...
        System.out.print("."); // print for last set of ten
        System.out.println();
        
        // --- all digits computed, print results and exit ---
        long end = System.currentTimeMillis();
        // display computed value
        System.out.print("Computed Value of Pi: 3.");
        for (int i = 1; i <= numOfDigits; i++) {
            System.out.print(results.getValue(i));
        }
        System.out.println();
        // print total time
        System.out.println("Total Time (mS): " + (end - start));
    }
}
