package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testOutputInt_SmallestInt() {
        int v = Integer.MIN_VALUE; // This will trigger the special case
        char[] b = new char[12]; // Ensure the array is large enough
        int off = 0;

        try {
            int result = NumberOutput.outputInt(v, b, off);
            assertEquals(0, result); // Expecting the offset to remain 0 since it should call _outputSmallestI
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}