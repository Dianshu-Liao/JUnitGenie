package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConditionC0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "BACHER";
        int index = 3; // Valid index for the test case

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true based on the input conditions
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}