package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleZ_String_DoubleMetaphoneResult_int_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHandleZ() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            String value = "Zhang"; // Test input string
            int index = 0; // Starting index
            boolean slavoGermanic = false; // Test boolean parameter

            // Create an instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument

            // Access the private method handleZ using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
            method.setAccessible(true); // Make the private method accessible

            // Call the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);

            // Verify the result
            assertEquals(1, newIndex); // Expected index after processing "Zhang"
            assertEquals("J", result.toString()); // Expected result after processing

        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that may occur
        }
    }

}