package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleH_String_DoubleMetaphoneResult_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testHandleH() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Create an instance of DoubleMetaphoneResult using the constructor of DoubleMetaphone
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument to the constructor
            // Prepare the input parameters
            String value = "AHOHA"; // 'H' is between vowels 'A' and 'O'
            int index = 0;

            // Access the private method handleH using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleH", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert the expected index after handling 'H'
            assertEquals(2, newIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}