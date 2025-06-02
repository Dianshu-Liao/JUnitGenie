package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionL0_String_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testConditionL0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);

            // Test case where index == value.length() - 3 and contains returns true
            String value1 = "HELLO";
            int index1 = value1.length() - 3; // index = 2
            boolean result1 = (Boolean) method.invoke(doubleMetaphone, value1, index1);
            assertTrue(result1);

            // Test case where index != value.length() - 3
            String value2 = "WORLD";
            int index2 = 1; // index = 1
            boolean result2 = (Boolean) method.invoke(doubleMetaphone, value2, index2);
            assertFalse(result2);

            // Test case where index == value.length() - 3 and contains returns false
            String value3 = "TEST";
            int index3 = value3.length() - 3; // index = 1
            boolean result3 = (Boolean) method.invoke(doubleMetaphone, value3, index3);
            assertFalse(result3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}