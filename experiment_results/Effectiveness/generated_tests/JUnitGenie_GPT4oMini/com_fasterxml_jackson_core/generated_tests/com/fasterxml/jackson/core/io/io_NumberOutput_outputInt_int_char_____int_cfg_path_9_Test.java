package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testOutputIntWithNegativeValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = -1000; // A valid negative multiple of 1000

        int result = NumberOutput.outputInt(value, buffer, offset);
        char[] expected = {'-', '1', '0', '0', '0'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithPositiveValueLessThanMillion() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 999; // A valid positive value less than a million

        int result = NumberOutput.outputInt(value, buffer, offset);
        char[] expected = {'9', '9', '9'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithValueInBillions() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 2000000000; // A valid positive value in billions

        int result = NumberOutput.outputInt(value, buffer, offset);
        char[] expected = {'2', '0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithZero() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 0; // Testing with zero

        int result = NumberOutput.outputInt(value, buffer, offset);
        char[] expected = {'0'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithIntegerMinValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = Integer.MIN_VALUE; // Testing with Integer.MIN_VALUE

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            char[] expected = {'-','2','1','4','7','4','8','3','6','4','8'};
            assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}