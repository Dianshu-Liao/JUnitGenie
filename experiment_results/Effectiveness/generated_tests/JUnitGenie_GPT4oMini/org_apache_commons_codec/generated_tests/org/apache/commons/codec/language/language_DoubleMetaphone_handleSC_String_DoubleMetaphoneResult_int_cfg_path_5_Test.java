package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testHandleSC() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer argument
        String value = "SCHOOL"; // This should lead to 'H' at index + 2
        int index = 0; // Starting index

        try {
            // Accessing the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Check the result
            assertEquals(3, newIndex); // Expecting index + 3
            assertEquals("X", result.getPrimary()); // Expecting 'X' to be appended
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}