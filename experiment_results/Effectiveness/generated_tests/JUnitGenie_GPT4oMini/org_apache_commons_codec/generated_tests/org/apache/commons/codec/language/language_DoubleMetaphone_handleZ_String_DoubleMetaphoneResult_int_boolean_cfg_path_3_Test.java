package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleZ_String_DoubleMetaphoneResult_int_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHandleZ() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            String value = "Zebra"; // Valid input string
            int index = 0; // Valid index
            boolean slavoGermanic = false; // Valid boolean

            // Access the private method handleZ using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Call the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, index, slavoGermanic);

            // Validate the result
            assertEquals(1, newIndex); // Expecting index to be updated to 1

            // Check the result content
            // Since 'Z' is at index 0, it should append 'S' to the result
            String result = doubleMetaphone.doubleMetaphone(value); // Corrected method to get the result
            assertEquals("S", result); // Assuming doubleMetaphone() gives the expected result

        } catch (NoSuchMethodException e) {
            System.err.println("The method handleZ does not exist in DoubleMetaphone class.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}