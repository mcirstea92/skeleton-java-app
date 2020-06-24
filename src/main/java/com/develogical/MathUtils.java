package com.develogical;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathUtils {

    public static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public static String printListWithCommas(Collection collection) {
        return collection.stream().
                map(Object::toString).
                collect(Collectors.joining(",")).toString();
    }

    public static boolean isBothSquareAndCube(int number) {
        return isSquare(number) && isCube(number);
    }

    private static boolean isSquare(int x) {
        // finding the square root of given number
        double sq = Math.sqrt(x);

        /* Math.floor() returns closest integer value, for
         * example Math.floor of 984.1 is 984, so if the value
         * of sq is non integer than the below expression would
         * be non-zero.
         */
        return ((sq - Math.floor(sq)) == 0);
    }

    private static boolean isCube(int x) {
        int n = (int) Math.round(Math.pow(x, 1.0 / 3.0));
        if ((x == n * n * n)) {
            System.out.print("Number is a cube." + x);
            return true;
        } else {
            System.out.print("Number is not a cube." + x);
            return false;
        }
    }
}
