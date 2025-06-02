package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testOutputIntWithNegativeValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = -1000000000; // This will trigger the billion handling

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            char[] expected = {'-', '1', '0', '0', '0', '0', '0', '0', '0', '0'};
            assertArrayEquals(expected, buffer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputIntWithPositiveValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 123456789; // A positive value to test

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            char[] expected = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            assertArrayEquals(expected, buffer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputIntWithZero() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 0; // Testing zero value

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            char[] expected = {'0'};
            assertArrayEquals(expected, buffer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputIntWithSmallestInteger() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = Integer.MIN_VALUE; // This will trigger the special case

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            // Expected output depends on the implementation of _outputSmallestI
            // Assuming it returns a specific character representation
            char[] expected = {'-','2','1','4','7','4','8','3','6','4','8'};
            assertArrayEquals(expected, buffer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}