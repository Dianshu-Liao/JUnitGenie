package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleD_String_DoubleMetaphoneResult_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHandleD() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Prepare the parameters for the method
            String value = "DAGGER"; // This should satisfy the first call to contains
            // Create an instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument
            int index = 0; // Starting index

            // Access the private method handleD using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Verify the result
            assertEquals(2, newIndex); // Expecting index to be updated to 2
            assertEquals("TK", result.toString()); // Expecting result to contain "TK"

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}