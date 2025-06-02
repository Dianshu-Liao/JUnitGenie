package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testConditionC0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "CHIA";
        int index = 0; // index must be >= 0 to satisfy the constraints

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}