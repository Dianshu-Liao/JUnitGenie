package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionCH0_String_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConditionCH0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
            method.setAccessible(true);

            // Test case where index is 0 and value meets the conditions
            boolean result1 = (boolean) method.invoke(doubleMetaphone, "HARAC", 0);
            assertFalse(result1); // Expected to return false due to "CHORE" being present

            // Test case where index is 0 and value does not meet the conditions
            boolean result2 = (boolean) method.invoke(doubleMetaphone, "SOMEVALUE", 0);
            assertTrue(result2); // Expected to return true as it does not contain "CHORE"

            // Test case where index is not 0
            boolean result3 = (boolean) method.invoke(doubleMetaphone, "HARAC", 1);
            assertFalse(result3); // Expected to return false as index is not 0

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}