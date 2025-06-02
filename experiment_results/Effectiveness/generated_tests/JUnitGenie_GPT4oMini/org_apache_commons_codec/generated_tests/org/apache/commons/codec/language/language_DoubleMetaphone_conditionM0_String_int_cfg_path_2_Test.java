package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_DoubleMetaphone_conditionM0_String_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConditionM0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

        String value = "MAMB"; // example string where charAt(0) == 'M' and index is 0
        int index = 0;

        try {
            // Accessing the private method using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
            method.setAccessible(true);
            
            // Invoke the method and assert the expected outcome
            boolean result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

}