package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_NumberOutput_toString_float_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringWithUseFastWriterFalse() {
        float testValue = 123.45f; // Example float value
        boolean useFastWriter = false;

        // Expected output when useFastWriter is false
        String expectedOutput = Float.toString(testValue);
        
        // Call the focal method
        String result = NumberOutput.toString(testValue, useFastWriter);
        
        // Assert the result
        assertEquals(expectedOutput, result);
    }

}