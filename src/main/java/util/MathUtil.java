package util;

public class MathUtil {

    public static int rand(int min, int max, boolean includeMaxBound){
        if (includeMaxBound)
            max++;

        return (int)(Math.random()*(max - min) + min);

    }

    public static int rand(int min, int max){


        return rand(min, max, false);

    }

}
