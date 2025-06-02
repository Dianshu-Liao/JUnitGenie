package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_NumberOutput_outputInt_int_char_____int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testOutputInt() {
        int v = -999999; // This will trigger the negative case
        char[] b = new char[20]; // Sufficient size for the output
        int off = 0;

        try {
            int result = NumberOutput.outputInt(v, b, off);
            char[] expectedOutput = {'-', '9', '9', '9', '9', '9', '9'};
            assertArrayEquals(expectedOutput, b);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}