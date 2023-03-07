import java.util.*;


// This hash table must be protected against race conditions.
// This is a shared resource available to all worker threads,
    // it must be protected against race conditions.
    // Pass a reference to the hashtable via the worker thread's constructor
        // (not a global variable).
public class ResultTable {
    public HashMap results;
    // constuctor
    public ResultTable() {
        // Use a Java HashMap as the underlying data structure.
            // Use aggregation, rather than inheritance.
        results = new HashMap(1000);
    }

    public void put(Task t) {
        // key = digit position
        // val = computed pi digit
        results.put(t.digitToCompute, t.result);
    }
}
