package org.apache.commons.codec.language;
import org.junit.Test;
import org.junit.Before;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class language_DoubleMetaphone_conditionC0_String_int_cfg_path_1_Test {
    private DoubleMetaphone doubleMetaphone;

    @Before
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test(timeout = 4000)
    public void testConditionC0() {
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
            method.setAccessible(true);
            
            // Test case where condition should be true
            String value1 = "CHIAACH"; // contains "CHIA" at index 0
            int index1 = 2; // index is valid
            boolean result1 = (boolean) method.invoke(doubleMetaphone, value1, index1);
            assertTrue(result1);

            // Test case where condition should be false due to vowel
            String value2 = "ACHIE"; // the character at `(index - 2)` is a vowel 'I'
            int index2 = 3; // index is valid
            boolean result2 = (boolean) method.invoke(doubleMetaphone, value2, index2);
            assertFalse(result2);

            // Test case where condition should be false (index <= 1)
            String value3 = "A"; // length less than index
            int index3 = 1; // index is invalid
            boolean result3 = (boolean) method.invoke(doubleMetaphone, value3, index3);
            assertFalse(result3);

            // Test case where condition evaluates to false for criteria not met
            String value4 = "ACHER"; // does not contain "ACH" at index 1
            int index4 = 1; // index is valid
            boolean result4 = (boolean) method.invoke(doubleMetaphone, value4, index4);
            assertFalse(result4);

            // Test case where condition should be true due to contains check
            String value5 = "BACHERMACHE"; // contains "BACHER" at index 0
            int index5 = 3; // index is valid
            boolean result5 = (boolean) method.invoke(doubleMetaphone, value5, index5);
            assertTrue(result5);
        
        } catch (Exception e) {
            fail("Exception thrown during reflection: " + e.getMessage());
        }
    }

}