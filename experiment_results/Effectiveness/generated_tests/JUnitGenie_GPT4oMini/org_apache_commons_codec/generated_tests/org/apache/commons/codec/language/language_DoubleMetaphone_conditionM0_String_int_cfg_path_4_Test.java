package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionM0_String_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConditionM0() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String value = "MUMBERR"; // value must be non-null and length > index
        int index = 0; // index must be >= 0 and < value.length()

        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result); // Expecting true based on the conditions set
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}