package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testOutputIntWithBillion() {
        int v = 2000000000; // A value greater than BILLION
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0; // Starting offset

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expectedOutput = "2".toCharArray(); // Expected output for billion
            assertArrayEquals(expectedOutput, new String(b, off, result - off).toCharArray());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputIntWithNegativeValue() {
        int v = -500; // A negative value
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0; // Starting offset

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expectedOutput = "-500".toCharArray(); // Expected output for negative value
            assertArrayEquals(expectedOutput, new String(b, off, result - off).toCharArray());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputIntWithSmallValue() {
        int v = 5; // A small positive value
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0; // Starting offset

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expectedOutput = "5".toCharArray(); // Expected output for small value
            assertArrayEquals(expectedOutput, new String(b, off, result - off).toCharArray());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testOutputIntWithMillion() {
        int v = 1000000; // A value equal to MILLION
        char[] b = new char[20]; // Sufficient length to hold the output
        int off = 0; // Starting offset

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expectedOutput = "1000000".toCharArray(); // Expected output for million
            assertArrayEquals(expectedOutput, new String(b, off, result - off).toCharArray());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}