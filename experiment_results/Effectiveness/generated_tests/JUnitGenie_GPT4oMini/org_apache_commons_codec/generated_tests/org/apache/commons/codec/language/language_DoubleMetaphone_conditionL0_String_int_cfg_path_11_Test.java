package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionL0_String_int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testConditionL0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "HELLO";
        int index = 2; // index should be 2 to satisfy the condition in the CFG path

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true based on the input conditions
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConditionL0False() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "WORLD";
        int index = 1; // index should be 1 to test the false condition

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertFalse(result); // Expecting false based on the input conditions
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}