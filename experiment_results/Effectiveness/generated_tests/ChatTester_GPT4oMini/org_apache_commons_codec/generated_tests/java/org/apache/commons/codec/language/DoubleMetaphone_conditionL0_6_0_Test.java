package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class DoubleMetaphone_conditionL0_6_0_Test {

    private DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

    @Test
    public void testConditionL0_withValidInput1() throws Exception {
        String value = "ALLO";
        // "ALLO" has "ALLE" at index 0-3
        int index = 2;
        boolean result = invokeConditionL0(value, index);
        assertTrue(result);
    }

    @Test
    public void testConditionL0_withValidInput2() throws Exception {
        String value = "ALLO";
        // "ALLO" has "ALLE" at index 0-3
        int index = 3;
        boolean result = invokeConditionL0(value, index);
        assertFalse(result);
    }

    @Test
    public void testConditionL0_withInvalidInput() throws Exception {
        String value = "TEST";
        // "TEST" does not meet the criteria for "ALLE"
        int index = 2;
        boolean result = invokeConditionL0(value, index);
        assertFalse(result);
    }

    @Test
    public void testConditionL0_withEndingAs() throws Exception {
        String value = "BAS";
        // "BAS" ends with "AS"
        int index = 1;
        boolean result = invokeConditionL0(value, index);
        assertTrue(result);
    }

    @Test
    public void testConditionL0_withEndingOs() throws Exception {
        String value = "COS";
        // "COS" ends with "OS"
        int index = 1;
        boolean result = invokeConditionL0(value, index);
        assertTrue(result);
    }

    @Test
    public void testConditionL0_withEdgeCase() throws Exception {
        String value = "ILLO";
        // "ILLO" has "ILLE" at index 0-3
        int index = 1;
        boolean result = invokeConditionL0(value, index);
        assertFalse(result);
    }

    @Test
    public void testConditionL0_withShortString() throws Exception {
        String value = "A";
        // Single character string
        int index = 0;
        boolean result = invokeConditionL0(value, index);
        assertFalse(result);
    }

    private boolean invokeConditionL0(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(doubleMetaphone, value, index);
    }
}
