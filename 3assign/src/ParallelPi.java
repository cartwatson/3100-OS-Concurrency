import java.lang.Runtime;

public class ParallelPi {
    public static void main(String[] args) {
        // start time
        long start = System.currentTimeMillis()

        // create queue
        TaskQueue taskQueue = new TaskQueue();

        // create hash table
        ResultTable results = new ResultTable();

        // number of worker threads = number of cores
        for (int i = 0; i < runtime.availableProcessors(); i++) {
            // create worker threads

        }

        while (!taskQueue.isEmpty() ) {// && worker threads are done
            // for every tenth digit computed ouput a period
            System.out.println("Loading: ");
            int digitsComputed = 0;
            if (digitsComputed % 10 == 0) {
                System.out.print(".");
                System.out.flush()
            }
            System.out.println();

            // keep worker threads going
            
        }
        
        // all digits have been computed
        long end = System.currentTimeMillis()
        // TODO: display computed value
        System.out.println("Computed Value of Pi: " + 123);
        System.out.println("Total Time (S): " + ((end - start) * 1000));
        exit();
    }
}

main();
