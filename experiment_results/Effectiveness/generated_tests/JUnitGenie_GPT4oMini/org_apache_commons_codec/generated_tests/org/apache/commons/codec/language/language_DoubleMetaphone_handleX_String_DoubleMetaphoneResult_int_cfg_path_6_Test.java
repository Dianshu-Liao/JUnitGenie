package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleX_String_DoubleMetaphoneResult_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testHandleX() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Prepare the parameters for the method
            String value = "example";
            // Create a new instance of DoubleMetaphoneResult using the DoubleMetaphone instance
            DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument
            int index = 1; // index is not 0 to follow the CFG path

            // Access the private method handleX using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert the expected outcome
            assertEquals(2, newIndex); // Expecting index to be incremented by 1

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}