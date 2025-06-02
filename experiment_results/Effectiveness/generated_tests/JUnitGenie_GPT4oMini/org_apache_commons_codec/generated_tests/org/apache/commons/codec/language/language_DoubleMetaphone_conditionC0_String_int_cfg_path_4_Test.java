package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConditionC0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);

            // Test case where the method should return true
            String value1 = "CHIA";
            int index1 = 3;
            boolean result1 = (boolean) method.invoke(doubleMetaphone, value1, index1);
            assertTrue(result1);

            // Test case where the method should return false due to index <= 1
            String value2 = "ACH";
            int index2 = 1;
            boolean result2 = (boolean) method.invoke(doubleMetaphone, value2, index2);
            assertFalse(result2);

            // Test case where the method should return false due to isVowel check
            String value3 = "BACH";
            int index3 = 3; // 'C' is at index 3, 'A' is at index 1
            boolean result3 = (boolean) method.invoke(doubleMetaphone, value3, index3);
            assertFalse(result3);

            // Test case where the method should return false due to contains check
            String value4 = "BACHER";
            int index4 = 4; // 'H' is at index 4
            boolean result4 = (boolean) method.invoke(doubleMetaphone, value4, index4);
            assertFalse(result4);

            // Test case where the method should return true due to contains check
            String value5 = "MACHER";
            int index5 = 4; // 'H' is at index 4
            boolean result5 = (boolean) method.invoke(doubleMetaphone, value5, index5);
            assertTrue(result5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}