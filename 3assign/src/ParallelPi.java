import java.lang.Runtime;

public class ParallelPi {
    public static void main(String[] args) {
        // number of digits to compute
        final int numOfTasks = 1000;

        // start time
        long start = System.currentTimeMillis()

        // create queue
        TaskQueue taskQueue = new TaskQueue(numOfTasks);

        // create hash table
        ResultTable results = new ResultTable(numOfTasks);

        // number of worker threads = number of cores
        for (int i = 0; i < runtime.availableProcessors(); i++) {
            // create worker threads
            ArrayList workerThreads = new WorkerThread(taskQueue, results);
        }

        // init counter for outputing loading symbols
        int x = 10;
        while (results.size() < 1000) {
            // for every tenth digit computed ouput a period
            System.out.println("Loading");
            int digitsComputed = 0;
            if (results.size() >= x) {
                x += 10;
                System.out.print(".");
                System.out.flush();
            }
            
            // keep worker threads going
            for (WorkerThread w : workerThreads) {
                if (w.hasTask()) {
                    w.compute();
                } else {
                    if (!queue.isEmpty()) {
                        w.getTask()
                    }
                }
            }
        }
        //end line after loading...
        System.out.println();
        
        // --- all digits computed, print results and exit ---
        long end = System.currentTimeMillis()
        // display computed value
        System.out.print("Computed Value of Pi: 3.");
        for (long i = 1; i <= 1000; i++) {
            System.out.print(results.getValue(i));
        }
        System.out.println();
        // print total time
        System.out.println("Total Time (S): " + ((end - start) * 1000));
        exit();
    }
}

main();
