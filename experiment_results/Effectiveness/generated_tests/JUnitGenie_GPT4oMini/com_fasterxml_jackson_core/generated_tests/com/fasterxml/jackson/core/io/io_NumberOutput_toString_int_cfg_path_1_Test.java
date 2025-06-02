package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_NumberOutput_toString_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToString_withSmallPositiveValue() {
        // Test with a small positive value
        int input = 5;
        String expected = "5";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToString_withSmallNegativeValue() {
        // Test with a small negative value
        int input = -5;
        String expected = "5"; // Assuming sSmallIntStrs2[-(-5)-1] returns "5"
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToString_withLargeValue() {
        // Test with a large value
        int input = 100;
        String expected = "100";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

}