package cz.osu.algorithms;

public class FactorialNumber {
    public int getFactorialNumber(int number) {
        return internalFactorialNumber(number);
    }

    private int internalFactorialNumber(int number) {
        if (number < 2) {
            return 1;
        }

        else {
            return number * internalFactorialNumber(number - 1);
        }

        // 1 line algorithm of factorial number
        // return (number > 1) ? number * internalFactorialNumber(number - 1) : 1;
    }
}
