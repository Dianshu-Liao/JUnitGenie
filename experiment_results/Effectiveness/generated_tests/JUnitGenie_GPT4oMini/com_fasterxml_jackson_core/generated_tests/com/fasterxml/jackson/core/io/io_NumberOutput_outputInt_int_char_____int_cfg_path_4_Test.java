package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testOutputIntWithValueLessThanMillion() {
        int v = 999; // Test value less than 1000
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        int result = NumberOutput.outputInt(v, b, off);

        // Expected output in char array
        char[] expected = {'9', '9', '9'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(b, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithValueEqualToMillion() {
        int v = 1000000; // Test value equal to MILLION
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        int result = NumberOutput.outputInt(v, b, off);

        // Expected output in char array
        char[] expected = {'1', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(b, result));
    }

    @Test(timeout = 4000)
    public void testOutputIntWithValueGreaterThanMillion() {
        int v = 1000001; // Test value greater than MILLION
        char[] b = new char[10]; // Buffer for output
        int off = 0; // Starting offset

        int result = NumberOutput.outputInt(v, b, off);

        // Expected output in char array
        char[] expected = {'1', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(b, result));
    }

}