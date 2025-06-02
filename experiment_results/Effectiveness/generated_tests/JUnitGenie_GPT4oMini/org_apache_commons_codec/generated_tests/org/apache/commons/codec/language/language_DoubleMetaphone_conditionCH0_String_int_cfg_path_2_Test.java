package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionCH0_String_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConditionCH0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
            method.setAccessible(true);

            // Test case where index is 0 and value contains "HARAC" or "HARIS"
            String value1 = "HARAC";
            int index1 = 0;
            boolean result1 = (boolean) method.invoke(doubleMetaphone, value1, index1);
            assertTrue(result1);

            // Test case where index is 0 and value contains "HOR", "HYM", "HIA", or "HEM"
            String value2 = "HORM";
            int index2 = 0;
            boolean result2 = (boolean) method.invoke(doubleMetaphone, value2, index2);
            assertTrue(result2);

            // Test case where index is 0 and value contains "CHORE"
            String value3 = "CHORE";
            int index3 = 0;
            boolean result3 = (boolean) method.invoke(doubleMetaphone, value3, index3);
            assertFalse(result3);

            // Test case where index is not 0
            String value4 = "SOMEVALUE";
            int index4 = 1;
            boolean result4 = (boolean) method.invoke(doubleMetaphone, value4, index4);
            assertFalse(result4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}