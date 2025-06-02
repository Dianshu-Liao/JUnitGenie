package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_DoubleMetaphone_conditionL0_String_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testConditionL0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);

            // Test case 1
            String value1 = "SOMESAMPLE"; // Testing with valid string input
            int index1 = 6; // Index satisfying the condition for the path
            boolean result1 = (Boolean) method.invoke(doubleMetaphone, value1, index1);
            assertTrue(result1);

            // Test case 2
            String value2 = "TESTING"; // Another valid string input
            int index2 = 5; // Another index that may lead to different branch
            boolean result2 = (Boolean) method.invoke(doubleMetaphone, value2, index2);
            assertFalse(result2);

            // Test case 3 - Edge case
            String value3 = "ILLO"; // Edge case with specific characters
            int index3 = 3; // This index should trigger a different branch
            boolean result3 = (Boolean) method.invoke(doubleMetaphone, value3, index3);
            assertTrue(result3);

            // Test case 4 - Invalid index
            String value4 = "EXAMPLE"; // Regular string input
            int index4 = -1; // Invalid index
            boolean result4 = (Boolean) method.invoke(doubleMetaphone, value4, index4);
            assertFalse(result4);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }

}