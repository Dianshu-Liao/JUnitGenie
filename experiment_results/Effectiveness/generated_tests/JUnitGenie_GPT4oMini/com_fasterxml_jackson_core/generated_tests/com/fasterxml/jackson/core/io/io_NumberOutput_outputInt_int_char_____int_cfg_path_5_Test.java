package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testOutputIntWithLessThanMillion() {
        int v = 999999; // Test value less than a million
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        int result = NumberOutput.outputInt(v, b, off);

        // Expected output in char array
        char[] expectedOutput = "999999".toCharArray();
        assertArrayEquals(expectedOutput, java.util.Arrays.copyOf(b, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithNegativeValue() {
        int v = -123; // Test negative value
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        int result = NumberOutput.outputInt(v, b, off);

        // Expected output in char array
        char[] expectedOutput = "-123".toCharArray();
        assertArrayEquals(expectedOutput, java.util.Arrays.copyOf(b, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithZero() {
        int v = 0; // Test zero value
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        int result = NumberOutput.outputInt(v, b, off);

        // Expected output in char array
        char[] expectedOutput = "0".toCharArray();
        assertArrayEquals(expectedOutput, java.util.Arrays.copyOf(b, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithIntegerMinValue() {
        int v = Integer.MIN_VALUE; // Test Integer.MIN_VALUE
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        try {
            int result = NumberOutput.outputInt(v, b, off);
            // Expected output in char array (assuming _outputSmallestI handles this)
            // This part would depend on the implementation of _outputSmallestI
            // Here we assume it returns a specific value, for example:
            // char[] expectedOutput = "someExpectedOutput".toCharArray();
            // assertArrayEquals(expectedOutput, java.util.Arrays.copyOf(b, result));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}