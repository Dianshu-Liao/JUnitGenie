package org.apache.commons.codec.language;

import org.apache.commons.codec.language.DoubleMetaphone;
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

public class DoubleMetaphone_conditionCH0_4_0_Test {

    @Test
    public void testConditionCH0_ValidCases() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        // Test cases that should return true
        assertTrue(invokeConditionCH0(doubleMetaphone, "HARAC", 0));
        assertTrue(invokeConditionCH0(doubleMetaphone, "HARIS", 0));
        assertTrue(invokeConditionCH0(doubleMetaphone, "HORMAN", 0));
        assertTrue(invokeConditionCH0(doubleMetaphone, "HYM", 0));
        assertTrue(invokeConditionCH0(doubleMetaphone, "HIA", 0));
        assertTrue(invokeConditionCH0(doubleMetaphone, "HEM", 0));
    }

    @Test
    public void testConditionCH0_InvalidCases() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        // Test cases that should return false
        // index != 0
        assertFalse(invokeConditionCH0(doubleMetaphone, "NOTHARAC", 1));
        // contains "CHORE"
        assertFalse(invokeConditionCH0(doubleMetaphone, "CHORE", 0));
        // does not match valid cases
        assertFalse(invokeConditionCH0(doubleMetaphone, "SOMEOTHER", 0));
    }

    private boolean invokeConditionCH0(DoubleMetaphone instance, String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(instance, value, index);
    }
}
