package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleH_String_DoubleMetaphoneResult_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHandleH() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Create an instance of DoubleMetaphoneResult using the constructor of DoubleMetaphone
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Pass an integer argument to the constructor
            // Prepare the parameters for the handleH method
            String value = "bHc"; // 'H' is between two consonants
            int index = 1; // Index of 'H'

            // Access the private method handleH using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleH", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Assert the expected index after handling 'H'
            assertEquals(3, newIndex); // Expecting index to be incremented by 2

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}