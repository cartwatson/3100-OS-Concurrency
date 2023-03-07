public class Task {
    public long digitToCompute;
    public int result;

    // constructor
    public Task(long digit) {
        digitToCompute = digit;
    }

    // computation method
    public int getResult() {
        // actually compute using that one method
        this.result = Bpp.getDecimal(digitToCompute);
        // return and assign result
        return this.result;
    }
}
