package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionL0_String_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testConditionL0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "TESTING";
        int index = 5; // index must be >= 0

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}