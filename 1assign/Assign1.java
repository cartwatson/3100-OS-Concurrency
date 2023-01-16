import java.math;

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
                            message = "Factorial valid range is [1, 2147483647]";
                        }
                    }
                    catch(Exception e) {
                        message = "Factorial valid range is [1, 2147483647]";
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

    private static int fibonacci(int fib) {
        if (fib <= 1) {
            return 1;
        }
        return fibonacci(fib - 1) + fibonacci(fib - 2);
    }

    private static BigInteger factorial(BigInteger fac) {
        for (int i = 0; i <=)
    }

    private static BigDecimal calculateE(int iterations) {
        BigDecimal result = 0;
        for (int i = 0; i <= iterations; i++) {
            result += 1;
        }
        return result;
    }
}