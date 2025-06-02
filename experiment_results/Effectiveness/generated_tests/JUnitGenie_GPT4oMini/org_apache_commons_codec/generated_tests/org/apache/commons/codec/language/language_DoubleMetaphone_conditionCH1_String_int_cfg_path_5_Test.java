package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionCH1_String_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testConditionCH1() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "VAN SCHORCHES";
        int index = 5; // A valid index for the test case

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}