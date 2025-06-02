package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class language_DoubleMetaphone_conditionCH1_String_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testConditionCH1() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "VANITY";
        int index = 3;

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}