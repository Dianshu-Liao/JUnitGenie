package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class util_StdDateFormat_pad3_StringBuffer_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPad3() {
        try {
            // Prepare the input parameters
            StringBuffer buffer = new StringBuffer();
            int value = 150; // This will lead to h = 1, which means '1' will be appended

            // Access the private static method pad3 using reflection
            Method method = StdDateFormat.class.getDeclaredMethod("pad3", StringBuffer.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method
            method.invoke(null, buffer, value);

            // Verify the output
            assertEquals("1" + "50", buffer.toString()); // Expecting '150' to be padded as '150'

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}