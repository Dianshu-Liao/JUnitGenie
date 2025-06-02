package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionCH0_String_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testConditionCH0_indexNotZero() {
        try {
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, "testValue", 1);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}