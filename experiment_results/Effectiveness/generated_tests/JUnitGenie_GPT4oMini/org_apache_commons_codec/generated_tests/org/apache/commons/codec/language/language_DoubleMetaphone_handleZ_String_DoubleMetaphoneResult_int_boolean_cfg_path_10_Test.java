package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleZ_String_DoubleMetaphoneResult_int_boolean_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testHandleZ() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Create an instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument to the constructor
            String value = "Zebra"; // Non-null string with length > 0
            int index = 0; // Valid index
            boolean slavoGermanic = false; // Boolean parameter

            // Access the private method handleZ using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class, boolean.class);
            method.setAccessible(true);

            // Call the method with parameters that satisfy the constraints
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);

            // Validate the result
            assertEquals(1, newIndex); // Expecting index to be updated to 1

            // Check the result content
            // Since the character at index 0 is 'Z', it should append 'S' to the result
            assertEquals("S", result.toString()); // Validate the appended result

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}