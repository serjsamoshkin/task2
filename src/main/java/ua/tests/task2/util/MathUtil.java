package ua.tests.task2.util;

/**
 * Contains math functions for Game
 */
public class MathUtil {

    /**
     * Get random value in min/max diapason.
     * @param min
     * @param max
     * @param includeMaxBound true - max diapason value is include
     * @return
     */
    public static int rand(int min, int max, boolean includeMaxBound){
        if (includeMaxBound)
            max++;

        return (int)(Math.random()*(max - min) + min);

    }

    public static int rand(int min, int max){


        return rand(min, max, false);

    }

}
