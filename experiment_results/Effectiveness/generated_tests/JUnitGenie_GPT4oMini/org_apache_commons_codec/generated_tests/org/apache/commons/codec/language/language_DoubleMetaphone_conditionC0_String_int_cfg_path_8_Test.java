package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testConditionC0_ReturnsFalse() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "TESTSTRING";
        int index = 0; // index must be >= 0 to meet the constraints

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