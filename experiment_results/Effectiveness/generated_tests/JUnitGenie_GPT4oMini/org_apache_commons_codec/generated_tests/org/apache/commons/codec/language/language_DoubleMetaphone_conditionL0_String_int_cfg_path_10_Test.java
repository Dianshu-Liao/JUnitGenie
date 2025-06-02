package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionL0_String_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testConditionL0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "SOMETHINGILLO";
        int index = value.length() - 3; // This should satisfy the first condition

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true based on the input
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}