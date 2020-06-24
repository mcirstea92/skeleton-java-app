package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    private static final String LARGEST = "which of the following numbers is the largest";
    private static final String IN_FIBONACCI = "number in the Fibonacci sequence";
    private static final String WHICH_ARE_PRIME = "which of the following numbers are primes";

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
                ints.add(Integer.parseInt(parsedStringNumber));
            }
            System.out.println("Largest number is " + Collections.max(ints));
            return "" + Collections.max(ints);
        }

        if (query.contains(WHICH_ARE_PRIME)) {
            String numbers = query.substring(WHICH_ARE_PRIME.length() + 1);
            System.out.println("Numbers are " + numbers);
            String[] parsedStringNumbers = numbers.split(",");
            List<Integer> results = new ArrayList<>();
            for (String parsedStringNumber : parsedStringNumbers) {
                if (MathUtils.isPrime(Integer.parseInt(parsedStringNumber))) {
                    results.add(Integer.parseInt(parsedStringNumber));
                }
            }
            return results.stream().
                    map(Object::toString).
                    collect(Collectors.joining(",")).toString();
        }

        return "";
    }
}
