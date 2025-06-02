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

class DoubleMetaphone_conditionC0_3_0_Test {

    @Test
    void testConditionC0() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        // Use reflection to access the private method
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        // Test cases
        assertTrue((Boolean) method.invoke(doubleMetaphone, "CHIA", 2));
        assertFalse((Boolean) method.invoke(doubleMetaphone, "ACH", 2));
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACHER", 2));
        assertTrue((Boolean) method.invoke(doubleMetaphone, "MACHER", 2));
        assertFalse((Boolean) method.invoke(doubleMetaphone, "SOMEOTHER", 3));
    }
}
