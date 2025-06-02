package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testOutputInt_NegativeValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = -123456;

        int result = NumberOutput.outputInt(value, buffer, offset);
        
        // Expected output: "-123456" in the buffer
        char[] expected = {'-', '1', '2', '3', '4', '5', '6'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputInt_MinValue() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = Integer.MIN_VALUE;

        int result = NumberOutput.outputInt(value, buffer, offset);
        
        // Expected output based on the special case handling for Integer.MIN_VALUE
        char[] expected = {'-','2','1','4','7','4','8','3','6','4','8'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputInt_Zero() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 0;

        int result = NumberOutput.outputInt(value, buffer, offset);
        
        // Expected output: "0" in the buffer
        char[] expected = {'0'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputInt_AboveMillion() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 1000001;

        int result = NumberOutput.outputInt(value, buffer, offset);
        
        // Expected output: "1000001" in the buffer
        char[] expected = {'1', '0', '0', '0', '0', '0', '0', '1'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

    @Test(timeout = 4000)
    public void testOutputInt_Billion() {
        char[] buffer = new char[20];
        int offset = 0;
        int value = 2000000000;

        int result = NumberOutput.outputInt(value, buffer, offset);
        
        // Expected output: "2" followed by "000000000" in the buffer
        char[] expected = {'2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, java.util.Arrays.copyOf(buffer, result));
    }

}