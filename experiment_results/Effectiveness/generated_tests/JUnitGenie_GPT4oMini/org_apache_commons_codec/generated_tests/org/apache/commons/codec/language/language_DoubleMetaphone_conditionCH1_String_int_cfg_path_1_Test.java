package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionCH1_String_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConditionCH1() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

            // Access the private method conditionCH1 using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
            method.setAccessible(true);

            // Define test parameters
            String value = "VAN ";
            int index = 2;

            // Invoke the method and capture the result
            boolean result = (boolean) method.invoke(doubleMetaphone, value, index);

            // Assert the expected outcome
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}