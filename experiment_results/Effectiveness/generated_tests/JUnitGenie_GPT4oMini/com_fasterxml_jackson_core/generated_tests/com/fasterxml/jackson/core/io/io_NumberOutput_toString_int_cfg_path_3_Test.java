package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_NumberOutput_toString_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToString_NegativeValueBelowThreshold() {
        // Test case for v = -1, which should return "-1" from sSmallIntStrs2
        int v = -1;
        String expected = "-1";
        String actual = NumberOutput.toString(v);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_NegativeValueAboveThreshold() {
        // Test case for v = -10, which should return "-10" from sSmallIntStrs2
        int v = -10;
        String expected = "-10";
        String actual = NumberOutput.toString(v);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_Zero() {
        // Test case for v = 0, which should return "0" from sSmallIntStrs
        int v = 0;
        String expected = "0";
        String actual = NumberOutput.toString(v);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_PositiveValueBelowThreshold() {
        // Test case for v = 5, which should return "5" from sSmallIntStrs
        int v = 5;
        String expected = "5";
        String actual = NumberOutput.toString(v);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToString_PositiveValueAboveThreshold() {
        // Test case for v = 15, which should return "15" from Integer.toString
        int v = 15;
        String expected = "15";
        String actual = NumberOutput.toString(v);
        assertEquals(expected, actual);
    }

}