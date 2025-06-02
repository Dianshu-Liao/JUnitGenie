package com.fasterxml.jackson.core;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test1");
        com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer charsToNameCanonicalizer0 = com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.createRoot();
        int int2 = charsToNameCanonicalizer0.calcHash("");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        int int3 = charsToNameCanonicalizer0.bucketCount();
    }
}

