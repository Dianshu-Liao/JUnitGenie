package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionCH0_String_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConditionCH0() {
        try {
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
            method.setAccessible(true);

            // Test case where index is 0 and value does not contain "CHORE"
            String value1 = "HARAC";
            int index1 = 0;
            boolean result1 = (Boolean) method.invoke(doubleMetaphone, value1, index1);
            assertFalse(result1); // Expected to return false

            // Test case where index is 0 and value contains "CHORE"
            String value2 = "CHORE";
            int index2 = 0;
            boolean result2 = (Boolean) method.invoke(doubleMetaphone, value2, index2);
            assertFalse(result2); // Expected to return false

            // Test case where index is not 0
            String value3 = "SOMEVALUE";
            int index3 = 1;
            boolean result3 = (Boolean) method.invoke(doubleMetaphone, value3, index3);
            assertFalse(result3); // Expected to return false

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}