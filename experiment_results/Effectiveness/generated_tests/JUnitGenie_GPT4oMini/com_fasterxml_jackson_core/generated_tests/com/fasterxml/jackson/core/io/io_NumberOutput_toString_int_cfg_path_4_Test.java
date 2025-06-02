package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_NumberOutput_toString_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToString_NegativeValue() {
        // Test case for a negative value that is within the range of sSmallIntStrs2
        int input = -1;
        String expected = "-1";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_NegativeValueOutOfRange() {
        // Test case for a negative value that is out of the range of sSmallIntStrs2
        int input = -11; // This should return the string representation of the integer
        String expected = "-11";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_Zero() {
        // Test case for zero
        int input = 0;
        String expected = "0";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_PositiveValue() {
        // Test case for a positive value within the range of sSmallIntStrs
        int input = 5;
        String expected = "5";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_PositiveValueOutOfRange() {
        // Test case for a positive value that is out of the range of sSmallIntStrs
        int input = 11; // This should return the string representation of the integer
        String expected = "11";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

}