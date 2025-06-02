package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHandleSC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            String value = "HOO"; // Example input that meets the constraints
            int index = 0; // Valid index

            // Create an instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument

            // Access the private method handleSC using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Validate the result
            assertEquals(3, newIndex); // Expecting index + 3
            // Further assertions can be made on the result object if needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}