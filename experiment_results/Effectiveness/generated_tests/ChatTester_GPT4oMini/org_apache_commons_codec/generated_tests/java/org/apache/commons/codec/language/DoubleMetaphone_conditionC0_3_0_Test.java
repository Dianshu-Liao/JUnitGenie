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
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        // Test cases
        // CHIA case
        assertTrue((Boolean) method.invoke(doubleMetaphone, "CHIA", 0));
        // Vowel at index -2
        assertFalse((Boolean) method.invoke(doubleMetaphone, "ACH", 1));
        // Not enough length
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACH", 1));
        // C not followed by I or E
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACHER", 3));
        // Valid case with "MACHER"
        assertTrue((Boolean) method.invoke(doubleMetaphone, "MACHER", 3));
        // Not a valid case
        assertFalse((Boolean) method.invoke(doubleMetaphone, "SACH", 1));
        // Edge case
        assertFalse((Boolean) method.invoke(doubleMetaphone, "ACH", 0));
        // Additional cases for boundary testing
        // Out of bounds
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACHER", 5));
        // Not followed by I or E
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACHER", 2));
    }
}
