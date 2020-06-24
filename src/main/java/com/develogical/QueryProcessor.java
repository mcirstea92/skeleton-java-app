package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }

        if (query.contains("what is") && query.contains("plus")) {
            int first = Integer.parseInt(query.substring(8, query.indexOf("plus") - 1));
            int second = Integer.parseInt(query.substring(query.indexOf("plus") + 5));
            return "" + (first + second);
        }

        return "";
    }
}
