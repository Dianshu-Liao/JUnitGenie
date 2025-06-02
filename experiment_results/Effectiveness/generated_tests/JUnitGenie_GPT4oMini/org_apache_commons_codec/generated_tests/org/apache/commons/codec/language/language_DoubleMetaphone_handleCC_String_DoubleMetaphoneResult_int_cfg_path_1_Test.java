package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleCC_String_DoubleMetaphoneResult_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHandleCC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Create an instance of DoubleMetaphoneResult with an integer parameter
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Assuming 0 is a valid initial value

            // Prepare the parameters for the private method
            String value = "bellocchio"; // This should trigger the first branch
            int index = 1;

            // Access the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Check the result
            assertEquals(4, newIndex); // Expecting index to be incremented by 3
            assertEquals("KS", result.toString()); // Expecting "KS" to be appended

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}