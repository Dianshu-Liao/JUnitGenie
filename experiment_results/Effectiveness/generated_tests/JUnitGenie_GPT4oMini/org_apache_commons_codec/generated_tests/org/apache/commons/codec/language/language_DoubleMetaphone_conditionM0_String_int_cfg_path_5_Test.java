package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionM0_String_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testConditionM0() {
        try {
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
            method.setAccessible(true);

            // Test case where value is "M" at index 0
            String value = "M";
            int index = 0;
            boolean result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true since charAt(value, index + 1) would be out of bounds

            // Test case where value is "MUMB" at index 0
            value = "MUMB";
            index = 0;
            result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true since charAt(value, index + 1) is 'U' and contains(value, index - 1, 3, "UMB") is true

            // Test case where value is "MOTHER" at index 0
            value = "MOTHER";
            index = 0;
            result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true since charAt(value, index + 1) is 'O' and contains(value, index + 2, 2, "ER") is true

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}