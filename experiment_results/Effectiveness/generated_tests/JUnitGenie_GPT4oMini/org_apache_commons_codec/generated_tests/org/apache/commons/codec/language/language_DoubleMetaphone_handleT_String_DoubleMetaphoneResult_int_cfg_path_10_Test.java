package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleT_String_DoubleMetaphoneResult_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testHandleT() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0); // Corrected instantiation with an integer argument
        String value = "TION"; // This should trigger the first condition in handleT
        int index = 0;

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleT", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);
            int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);

            // Validate the result
            assertEquals(3, newIndex); // Expecting index to be incremented by 3
            // Check if 'X' was appended to the result
            assertEquals('X', result.getPrimary());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}