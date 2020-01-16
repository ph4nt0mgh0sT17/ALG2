package cz.osu.algorithms;

public class FibonacciSequence {
    public int getFibonacciNumber(int number) {
        return internalFibonacciNumber(number);
    }

    private int internalFibonacciNumber(int number) {
        // return (number > 1) ? internalFibonacciNumber(number - 1) + internalFibonacciNumber(number - 2) : number;

        if (number < 2) {
            return number;
        }

        else {
            return internalFibonacciNumber(number - 1) + internalFibonacciNumber(number - 2);
        }
    }
}
