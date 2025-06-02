package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_DoubleMetaphone_conditionL0_String_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConditionL0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "HELLO";
        int index = 2; // index should be 2 to satisfy the condition in the method

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true based on the input conditions
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}