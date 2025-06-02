package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testHandleSC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer argument

            // Prepare the parameters
            String value = "HOOH"; // This string has 'H' at index 0
            int index = 0; // Valid index

            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Validate the result
            assertEquals(3, newIndex); // Expecting index to be 3 after processing
            // Check the appended result
            assertEquals("X", result.getPrimary()); // Expecting "X" to be appended

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}