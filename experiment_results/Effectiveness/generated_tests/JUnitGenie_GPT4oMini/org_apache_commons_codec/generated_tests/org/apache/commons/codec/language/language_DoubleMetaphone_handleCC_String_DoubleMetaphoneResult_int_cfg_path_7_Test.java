package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleCC_String_DoubleMetaphoneResult_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testHandleCC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Prepare the parameters for the handleCC method
            String value = "bellocchio"; // This should lead to appending 'KS'
            // Create a new instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument
            int index = 1;

            // Access the private method handleCC using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Verify the result
            assertEquals(4, newIndex); // index should be updated to 4
            assertEquals("KS", result.toString()); // result should contain 'KS'

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}