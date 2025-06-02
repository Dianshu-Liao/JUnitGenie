package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testOutputInt_NegativeValue() {
        int v = -1000000000; // A negative value that will trigger the special case for BILLION
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0;

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expected = {'-', '1', '0', '0', '0', '0', '0', '0', '0', '0'};
            assertArrayEquals(expected, b);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputInt_ZeroValue() {
        int v = 0; // Testing with zero
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0;

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expected = {'0'};
            assertArrayEquals(expected, b);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputInt_PositiveValue() {
        int v = 123456789; // A positive value
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0;

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expected = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            assertArrayEquals(expected, b);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputInt_MinValue() {
        int v = Integer.MIN_VALUE; // Testing the minimum integer value
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0;

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expected = {'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8', '0'};
            assertArrayEquals(expected, b);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}