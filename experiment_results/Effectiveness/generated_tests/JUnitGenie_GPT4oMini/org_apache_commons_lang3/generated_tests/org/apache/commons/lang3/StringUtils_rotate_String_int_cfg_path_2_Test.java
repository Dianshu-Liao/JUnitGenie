package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rotate_String_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRotateWithValidInputs() {
        String input = "abcdef";
        int shift = 2;
        String expected = "efabcd";
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRotateWithShiftEqualToStringLength() {
        String input = "abcdef";
        int shift = 6; // Simple case where shift equals string length
        String expected = "abcdef";
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRotateWithZeroShift() {
        String input = "abcdef";
        int shift = 0; // No shift
        String expected = "abcdef";
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRotateWithEmptyString() {
        String input = "";
        int shift = 3;
        String expected = ""; // Rotating an empty string should give an empty string
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRotateWithNullString() {
        String input = null;
        int shift = 3;
        String expected = null; // Rotating null should return null
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }
    
    @Test(timeout = 4000)
    public void testRotateWithNegativeShift() {
        String input = "abcdef";
        int shift = -2; // Negative shift
        String expected = "cdefab"; // Equivalent to rotating right by 2
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRotateWithLargeShift() {
        String input = "abcdef";
        int shift = 100; // Large shift
        String expected = "efabcd"; // Equivalent to rotating by 4
        String result = StringUtils.rotate(input, shift);
        assertEquals(expected, result);
    }

}