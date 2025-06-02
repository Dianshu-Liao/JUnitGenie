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

public class DoubleMetaphone_conditionCH1_5_0_Test {

    @Test
    public void testConditionCH1() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        // Access the private method using reflection
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
        method.setAccessible(true);
        // Test cases for conditionCH1
        // Test contains value "VAN "
        assertTrue((Boolean) method.invoke(doubleMetaphone, "VAN ", 0));
        // Test contains value "VON "
        assertTrue((Boolean) method.invoke(doubleMetaphone, "VON ", 0));
        // Test contains "SCH"
        assertTrue((Boolean) method.invoke(doubleMetaphone, "SCHOLAR", 3));
        // Test contains "ORCHES"
        assertTrue((Boolean) method.invoke(doubleMetaphone, "ORCHESTRATION", 4));
        // Test contains "ARCHIT"
        assertTrue((Boolean) method.invoke(doubleMetaphone, "ARCHITECT", 2));
        // Test contains "ORCHID"
        assertTrue((Boolean) method.invoke(doubleMetaphone, "ORCHID", 3));
        // Test contains "T" at index + 2
        assertTrue((Boolean) method.invoke(doubleMetaphone, "TEST", 2));
        // Test contains "S" at index + 2
        assertTrue((Boolean) method.invoke(doubleMetaphone, "SAND", 1));
        // Test index == 0 with vowel
        assertTrue((Boolean) method.invoke(doubleMetaphone, "ALEX", 0));
        // Test index + 1 == value.length() - 1 with vowel
        assertTrue((Boolean) method.invoke(doubleMetaphone, "BOB", 1));
        // Additional test cases for false conditions
        // Test with no matching condition
        assertFalse((Boolean) method.invoke(doubleMetaphone, "XYZ", 1));
        // Test with no matching conditions
        assertFalse((Boolean) method.invoke(doubleMetaphone, "CDEFG", 2));
        // Test with no matching conditions
        assertFalse((Boolean) method.invoke(doubleMetaphone, "ABCDE", 1));
    }
}
