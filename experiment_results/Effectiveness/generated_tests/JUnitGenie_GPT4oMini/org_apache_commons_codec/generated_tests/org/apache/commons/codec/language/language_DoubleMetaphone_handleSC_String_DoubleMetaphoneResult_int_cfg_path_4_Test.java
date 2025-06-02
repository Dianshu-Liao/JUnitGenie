package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class language_DoubleMetaphone_handleSC_String_DoubleMetaphoneResult_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHandleSC() {
        try {
            // Create an instance of DoubleMetaphone
            DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
            // Create an instance of DoubleMetaphoneResult with an initial capacity
            DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(2); // Assuming 2 is a valid initial capacity

            // Access the private method handleSC using reflection
            Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);

            // Test case 1: Valid input that triggers the first condition
            String value1 = "SCHOOL";
            int index1 = 0;
            int returnValue1 = (int) method.invoke(doubleMetaphone, value1, result, index1);
            assertEquals(3, returnValue1);
            // Check the result
            assertEquals("X", result.getPrimary());
            assertEquals("", result.getAlternate());

            // Reset result for the next test
            result = doubleMetaphone.new DoubleMetaphoneResult(2); // Reset with initial capacity

            // Test case 2: Valid input that triggers the second condition
            String value2 = "SENIOR";
            int index2 = 0;
            int returnValue2 = (int) method.invoke(doubleMetaphone, value2, result, index2);
            assertEquals(3, returnValue2);
            // Check the result
            assertEquals("SK", result.getPrimary());
            assertEquals("", result.getAlternate());

            // Reset result for the next test
            result = doubleMetaphone.new DoubleMetaphoneResult(2); // Reset with initial capacity

            // Test case 3: Valid input that triggers the else condition
            String value3 = "SOME";
            int index3 = 0;
            int returnValue3 = (int) method.invoke(doubleMetaphone, value3, result, index3);
            assertEquals(3, returnValue3);
            // Check the result
            assertEquals("SK", result.getPrimary());
            assertEquals("", result.getAlternate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}