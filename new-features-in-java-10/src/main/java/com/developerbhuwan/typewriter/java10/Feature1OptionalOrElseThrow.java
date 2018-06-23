package com.developerbhuwan.typewriter.java10;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional.orElseThrow() Method
 *
 * @author Bhuwan P. Upadhyay
 */
public class Feature1OptionalOrElseThrow {

    public static void main(String[] args) {
        Foo foo = null;
        try {
            Foo myFoo = Optional.ofNullable(foo).orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.print("Exception caught: " + e.getMessage());
        }
    }

    private static class Foo {

    }


}
