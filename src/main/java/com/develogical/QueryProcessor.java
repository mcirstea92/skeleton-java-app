package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.develogical.MathUtils.printListWithCommas;

public class QueryProcessor {

    private static final String LARGEST = "which of the following numbers is the largest";
    private static final String WHICH_ARE_PRIME = "which of the following numbers are primes";
    private static final String WHICH_IS_SQUARE_AND_CUBE = "which of the following numbers is both a square and a cube";

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }

        if (query.contains("what is") && query.contains("plus")) {
            int first = Integer.parseInt(query.substring(8, query.indexOf("plus") - 1));
            int second = Integer.parseInt(query.substring(query.indexOf("plus") + 5));
            return "" + (first + second);
        }

        if (query.contains(LARGEST)) {
            String numbers = query.substring(LARGEST.length() + 1);
            System.out.println("Numbers are " + numbers);
            String[] parsedStringNumbers = numbers.split(",");
            List<Integer> ints = new ArrayList<>();
            for (String parsedStringNumber : parsedStringNumbers) {
                ints.add(Integer.parseInt(removeWhitespaces(parsedStringNumber)));
            }
            System.out.println("Largest number is " + Collections.max(ints));
            return "" + Collections.max(ints);
        }

        if (query.toLowerCase().contains(WHICH_ARE_PRIME)) {
            String numbers = query.substring(WHICH_ARE_PRIME.length() + 1);
            System.out.println("Numbers are " + numbers);
            String[] parsedStringNumbers = numbers.split(",");
            List<Integer> results = new ArrayList<>();
            for (String parsedStringNumber : parsedStringNumbers) {
                if (MathUtils.isPrime(Integer.parseInt(removeWhitespaces(parsedStringNumber)))) {
                    results.add(Integer.parseInt(removeWhitespaces(parsedStringNumber)));
                }
            }
            return printListWithCommas(results);
        }

        if (query.toLowerCase().contains(WHICH_IS_SQUARE_AND_CUBE)) {
            String numbers = query.substring(WHICH_IS_SQUARE_AND_CUBE.length() + 1);
            System.out.println("Numbers are " + numbers);
            String[] parsedStringNumbers = numbers.split(",");
            List<Integer> results = new ArrayList<>();
            for (String parsedStringNumber : parsedStringNumbers) {
                if (MathUtils.isBothSquareAndCube(Integer.parseInt(removeWhitespaces(parsedStringNumber)))) {
                    results.add(Integer.parseInt(removeWhitespaces(parsedStringNumber)));
                }
            }
            return printListWithCommas(results);
        }

        return "";
    }


    private String removeWhitespaces(String string) {
        return string.replaceAll("\\s+", "");
    }
}
