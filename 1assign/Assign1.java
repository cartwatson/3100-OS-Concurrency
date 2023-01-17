import java.math.BigInteger;
import java.math.MathContext;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Carter Watson A02312565@usu.edu
 * Satisfies requirements for assign1 of CS3100
*/
public class Assign1 {
    public static void main(String[] args) {
        int length = args.length;

        // Covers cases with no or invalid number of params
        if (length == 0 || length % 2 != 0) {
            System.out.println("--- Assign 1 Help ---\n  -fib [n] : Compute the Fibonacci of [n]; valid range [0, 40]\n  -fac [n] : Compute the factorial of [n]; valid range, [0, 2147483647]\n  -e [n] : Compute the value of 'e' using [n] iterations; valid range [1, 2147483647]");
            return;
        }

        // iterate through parameters
        for (int i = 0; i < length; i++) {
            String message = "";
            // figure out how param should be used
            switch (args[i]) {
                case "-fib":
                    // make sure postceding argument is an int
                    try {
                        int n = Integer.parseInt(args[i + 1]);
                        // make sure value is in valid range
                        if (n >= 0 && n <= 40) {
                            message = "Fibonacci of " + args[i + 1] + " is " + fibonacci(n);
                        } else {
                            message = "Fibonacci valid range is [0, 40]";
                        }
                    }
                    catch(Exception e) {
                        message = "Fibonacci valid range is [0, 40]";
                    }
                    break;
                case "-fac":
                    // make sure postceding argument is an int
                    try {
                        int n = Integer.parseInt(args[i + 1]);
                        // make sure value is in valid range
                        if (n >= 0 && n <= 2147483647) {
                            message = "Factorial of " + args[i + 1] + " is " + factorial(n);
                        } else {
                            message = "Factorial valid range is [0, 2147483647]";
                        }
                    }
                    catch(Exception e) {
                        message = "Factorial valid range is [0, 2147483647]";
                    }
                    break;
                case "-e":
                    // make sure postceding argument is an int
                    try {
                        int n = Integer.parseInt(args[i + 1]);
                        // make sure value is in valid range
                        if (n >= 1 && n <= 2147483647) {
                            message = "Value of e using " + args[i + 1] + " is " + calculateE(n);
                        } else {
                            message = "Valid e iterations range is [1, 2147483647]";
                        }
                    }
                    catch(Exception e) {
                        message = "Valid e iterations range is [1, 2147483647]";
                    }
                    break;
                default:
                    try {
                        // if arg[i] is number, ignore it
                        int n = Integer.parseInt(args[i]);
                    }
                    catch (Exception e) {
                        // if not a number, it is an unknown argument
                        if (args[i].charAt(0) == '-') {
                            message = "Unknown command line argument: " + args[i];
                        }
                    }
                    break;
            }
            // print message
            System.out.println(message);
        }
    }

    /**
     * @author Carter Watson A02312565@usu.edu
     * @param fib value in the fibonacci sequence
     * @return value of fib in the fibonacci sequence
     */
    private static int fibonacci(int fib) {
        if (fib <= 1) {
            return 1;
        }
        return fibonacci(fib - 1) + fibonacci(fib - 2);
    }

    /**
     * @author Carter Watson A02312565@usu.edu
     * @param fac number to compute the factorial of
     * @return computed factorial of fac
     */
    private static BigInteger factorial(int fac) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i < fac; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * @author Carter Watson A02312565@usu.edu
     * @param iterations how many iterations should be applied to computing e
     * @return computed value of e
     */
    private static BigDecimal calculateE(int iterations) {
        // init result, turn iterations into BigDecimal for calculations
        BigDecimal result = new BigDecimal("1");
        BigDecimal two = new BigDecimal("2");
        // calculate e^iterations
        for (int i = 1; i < iterations; i++) {
            // // DEBUG \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/
            // System.out.println(i);
            // System.out.println(two.pow(i));
            // System.out.println(factorialEHelper(i));
            // System.out.println(two.pow(i).divide(factorialEHelper(i), 16, RoundingMode.HALF_DOWN));
            // // System.out.println(result);
            // System.out.println("----");
            // // DEBUG /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\
            result = result.add(two.pow(i).divide(factorialEHelper(i), 16, RoundingMode.HALF_DOWN));
        }
        // convert from e^2
        return result.sqrt(new MathContext(16));
    }

    /**
     * @desc computes factorial returning a BigDecimal
     * @author Carter Watson A02312565@usu.edu
     * @param fac number to compute the factorial of
     * @return computed factorial of fac
     */
    private static BigDecimal factorialEHelper(int fac) {
        if (fac == 1) {
            return new BigDecimal(1);
        }
        return new BigDecimal(fac).multiply(factorialEHelper(--fac));
    }
}