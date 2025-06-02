package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleD_String_DoubleMetaphoneResult_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHandleD() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Create an instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument
            // Define the input parameters
            String value = "DAG";
            int index = 0;

            // Access the private method handleD using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Verify the result
            assertEquals(2, newIndex);
            assertEquals('T', result.getPrimary()); // Check if 'T' was appended
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}