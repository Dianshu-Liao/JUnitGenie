package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionCH0_String_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConditionCH0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
            method.setAccessible(true);

            // Test case where index is 0 and value contains "HARAC" or "HARIS"
            assertTrue((Boolean) method.invoke(doubleMetaphone, "HARAC test", 0));
            assertTrue((Boolean) method.invoke(doubleMetaphone, "HARIS example", 0));

            // Test case where index is 0 and value contains "HOR", "HYM", "HIA", or "HEM"
            assertTrue((Boolean) method.invoke(doubleMetaphone, "HOR test", 0));
            assertTrue((Boolean) method.invoke(doubleMetaphone, "HYM example", 0));

            // Test case where index is 0 and value contains "CHORE"
            assertFalse((Boolean) method.invoke(doubleMetaphone, "CHORE test", 0));

            // Test case where index is not 0
            assertFalse((Boolean) method.invoke(doubleMetaphone, "HARAC test", 1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}