package cz.osu;

public class TimeIt {

    public static void measureTime(Runnable codeBlock) {
        long startTime = System.nanoTime();

        try {
            codeBlock.run();
        }

        finally {
            long endTime = System.nanoTime();
            System.out.println("The action took " + (endTime - startTime) / 1.0e6 + " ms.");
        }
    }
}
