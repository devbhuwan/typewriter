package com.developerbhuwan.typewriter.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * APIs for Creating Unmodifiable Collections :
 * - List.copyOf, Set.copyOf, and Map.copyOf
 * - Collectors.toUnmodifiableList, Collectors.toUnmodifiableSet, and Collectors.toUnmodifiableMap
 *
 * @author Bhuwan P. Upadhyay
 */
public class Feature3APIForUnmodifiableCollection {

    public static void main(String[] args) {
        usingCopyOf();
        usingStreamOfCollectors();
    }

    private static void usingCopyOf() {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Foo");
        List<String> immutableList = List.copyOf(mutableList);
        try {
            immutableList.add("Bar");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    }


    private static void usingStreamOfCollectors() {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Foo");
        List<String> immutableList = mutableList.stream().collect(Collectors.toUnmodifiableList());
        try {
            immutableList.add("Bar");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    }

}
