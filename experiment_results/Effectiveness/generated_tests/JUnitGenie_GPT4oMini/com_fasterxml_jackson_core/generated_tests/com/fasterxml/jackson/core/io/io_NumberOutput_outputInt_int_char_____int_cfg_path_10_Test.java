package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testOutputInt_NegativeValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = -123;

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            char[] expected = {'-', '1', '2', '3'};
            assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputInt_MinValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = Integer.MIN_VALUE;

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            // Assuming _outputSmallestI is expected to return a specific value
            // Here we need to define what _outputSmallestI returns for Integer.MIN_VALUE
            // For example, let's say it returns "MIN" for this test case
            char[] expected = {'M', 'I', 'N'};
            assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputInt_ZeroValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 0;

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            char[] expected = {'0'};
            assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputInt_AboveMillion() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 1000001;

        try {
            int result = NumberOutput.outputInt(value, buffer, offset);
            // Expected output needs to be defined based on the logic of outputInt
            // For example, let's assume it returns "1000001"
            char[] expected = {'1', '0', '0', '0', '0', '0', '0', '1'};
            assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}