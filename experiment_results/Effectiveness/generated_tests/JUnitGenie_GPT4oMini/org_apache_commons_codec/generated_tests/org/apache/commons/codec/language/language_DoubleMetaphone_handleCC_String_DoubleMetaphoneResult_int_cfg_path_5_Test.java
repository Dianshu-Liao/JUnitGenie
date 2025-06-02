package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleCC_String_DoubleMetaphoneResult_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testHandleCC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Prepare the parameters for the method
            String value = "bellocchio"; // This should trigger the first branch
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer argument
            int index = 1; // This should satisfy the condition for index

            // Access the private method handleCC using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Check the result
            assertEquals(4, newIndex); // Expecting index to be incremented by 3
            assertEquals("KS", result.toString()); // Expecting result to contain "KS"

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}