package cz.osu;

import cz.osu.algorithms.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Fibonacci Number(20) = " + new FibonacciSequence().getFibonacciNumber(20));
        System.out.println("Factorial Number(5) = " + new FactorialNumber().getFactorialNumber(5));
    }
}
