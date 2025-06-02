package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class language_DoubleMetaphone_conditionCH1_String_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConditionCH1() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

            // Use reflection to access the private method conditionCH1
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
            method.setAccessible(true);

            // Test case: value contains "VAN " for the first condition
            String value = "VAN ABC";
            int index = 0;
            boolean result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);

            // Test case: value contains "SCH" for the second condition
            value = "SCHOOL";
            index = 0;
            result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);
            
            // Test case: value contains "ORCHID" for the third condition
            value = "ORCHID";
            index = 6;
            result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(result);
            
            // Test case: value does not satisfy conditions
            value = "EXAMPLE";
            index = 0;
            result = (Boolean) method.invoke(doubleMetaphone, value, index);
            assertTrue(!result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}