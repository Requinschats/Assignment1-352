import java.io.*;
import java.util.Arrays;

public class FibonacciCalculators {
    public class Pair {
        public int i;
        public int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        Pair() {
            this.i = 0;
            this.j = 0;
        }

        public int sum() {
            return i + j;
        }

        @Override
        public String toString() {
            return "K is: " + i + "(K-1) is: " + j;
        }
    }

    public int binaryFib(int k) {
        if (k == 0) {
            return 1;
        } else if (k == 1) {
            return 1;
        } else {
            return binaryFib(k - 1) + binaryFib(k - 2);
        }
    }

    public Pair linearFibonacci(int k) {
        if (k == 1) {
            return new Pair(k, 0);
        } else {
            Pair pair = linearFibonacci(k - 1);
            return new Pair(pair.sum(), pair.i);
        }
    }

    public int tailRecursiveFibonnaci(int fPosition, int k, int kMinus1){
        if (fPosition == 0)
            return k;
        if (fPosition == 1)
            return kMinus1;
        return tailRecursiveFibonnaci(fPosition - 1, kMinus1, k + kMinus1);
    }
    public static void main(String[] args) {

        PrintWriter writer = null;
        FibonacciCalculators fibonacciCalculators = new FibonacciCalculators();
        try {
            writer = new PrintWriter(new FileWriter("FibonacciCalculatorsRuntime.txt"));
            for (int k = 1; k < 100; k += 5) {
                if (k < 50) {
                    long startTimeB = System.currentTimeMillis();
                    fibonacciCalculators.binaryFib(k);
                    long endTimeB = System.currentTimeMillis();
                    writer.println("BINARY: At input size " + k + "the runtime was " + (endTimeB - startTimeB) + " milliseconds");
                }
                long startTimeL = System.currentTimeMillis();
                fibonacciCalculators.linearFibonacci(k);
                long endTimeL = System.currentTimeMillis();
                writer.println("LINEAR: At input size " + k + "the runtime was " + (endTimeL - startTimeL) + " milliseconds");

                long startTimeT = System.currentTimeMillis();
                fibonacciCalculators.tailRecursiveFibonnaci(8, 0 , 1);
                long endTimeT = System.currentTimeMillis();
                writer.println("TAIL_R: At input size " + k + "the runtime was " + (endTimeT - startTimeT) + " milliseconds");
                writer.println();
            }
        } catch (Exception e) {
            System.out.print(Arrays.toString(e.getStackTrace()));
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
