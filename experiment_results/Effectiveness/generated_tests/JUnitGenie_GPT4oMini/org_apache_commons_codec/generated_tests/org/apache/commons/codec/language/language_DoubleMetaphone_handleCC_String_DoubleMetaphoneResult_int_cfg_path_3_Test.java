package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleCC_String_DoubleMetaphoneResult_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHandleCC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Prepare the parameters
            String value = "AICU"; // 'A' at index 1, valid string
            // Create a new instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument to the constructor
            int index = 1; // index must be non-negative

            // Access the private method handleCC using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Check the result
            assertEquals(4, newIndex); // Expecting index to be incremented by 3
            assertEquals("X", result.toString()); // Expecting 'X' to be appended

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}