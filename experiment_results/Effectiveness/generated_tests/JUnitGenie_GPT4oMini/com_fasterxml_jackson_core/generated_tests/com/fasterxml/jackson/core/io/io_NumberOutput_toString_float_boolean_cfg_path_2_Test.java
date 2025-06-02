package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_NumberOutput_toString_float_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringWithFastWriter() {
        float value = 123.45f;
        boolean useFastWriter = true;
        String expected = Float.toString(value); // Expected output when useFastWriter is true
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToStringWithoutFastWriter() {
        float value = 123.45f;
        boolean useFastWriter = false;
        String expected = Float.toString(value); // Expected output when useFastWriter is false
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual);
    }

}