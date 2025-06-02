package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConditionC0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "BACHER";
        int index = 3;

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConditionC0WithNonMatchingCriteria() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "TEST";
        int index = 2;

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConditionC0WithIndexOutOfBounds() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "A";
        int index = 1; // Out of bounds

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}