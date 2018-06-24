package com.developerbhuwan.typewriter.java10;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * LocalVariableTypeInterface
 *
 * @author Bhuwan P. Upadhyay
 */
public class Feature1LocalVariableTypeInterface {

    public static void main(String[] args) {
        new Feature1LocalVariableTypeInterface().demo();
    }

    private void demo() {

        var list = new ArrayList<String>();
        list.add("Foo");
        list.add("Bar");

        var value = list.stream().collect(Collectors.joining(","));

        System.out.println("Value :" + value);

    }

}
