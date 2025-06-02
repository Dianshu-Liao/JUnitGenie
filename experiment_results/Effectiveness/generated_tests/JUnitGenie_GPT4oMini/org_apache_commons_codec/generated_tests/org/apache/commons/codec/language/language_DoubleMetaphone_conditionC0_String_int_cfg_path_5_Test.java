package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testConditionC0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);

            // First invocation: should return false
            String value1 = "BACHER";
            int index1 = 2; // Set index such that the conditions yield false
            boolean result1 = (boolean) method.invoke(doubleMetaphone, value1, index1);
            assertFalse(result1);

            // Second invocation: should return true
            String value2 = "ACHIEVER";
            int index2 = 2; // Adjust index for conditions leading to true
            boolean result2 = (boolean) method.invoke(doubleMetaphone, value2, index2);
            assertTrue(result2);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception gracefully as per rule 4
        }
    }

}