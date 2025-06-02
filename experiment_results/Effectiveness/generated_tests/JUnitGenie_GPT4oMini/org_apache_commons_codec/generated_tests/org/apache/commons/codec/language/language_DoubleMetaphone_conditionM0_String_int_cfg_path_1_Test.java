package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_conditionM0_String_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConditionM0() {
        try {
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
            method.setAccessible(true);

            // Test case satisfying the condition to return true
            String value1 = "MUMB"; // ASCII M = 77 at index 0
            int index1 = 0; // valid index
            boolean result1 = (Boolean) method.invoke(doubleMetaphone, value1, index1);
            assertEquals(true, result1);

            // Test case satisfying the condition to return false
            String value2 = "UMB"; // No M following the index
            int index2 = 1; // valid index
            boolean result2 = (Boolean) method.invoke(doubleMetaphone, value2, index2);
            assertEquals(false, result2);

        } catch (Exception e) {
            e.printStackTrace(); // Handle exception by printing the stack trace
        }
    }

}