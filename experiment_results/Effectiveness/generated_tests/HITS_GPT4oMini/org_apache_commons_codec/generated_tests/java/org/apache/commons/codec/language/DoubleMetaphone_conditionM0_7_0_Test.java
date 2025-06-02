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

class DoubleMetaphone_conditionM0_7_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    // Public method to expose the private conditionM0 for testing
    public boolean testConditionM0(String value, int index) {
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
            // Make the private method accessible
            method.setAccessible(true);
            return (boolean) method.invoke(doubleMetaphone, value, index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testConditionM0WithMFollowing() {
        // M follows U
        assertTrue(testConditionM0("UMBER", 2));
    }

    @Test
    void testConditionM0WithUMBPreceding() {
        // UMB at start
        assertTrue(testConditionM0("UMB", 0));
    }

    @Test
    void testConditionM0WithERFollowing() {
        // ER follows M
        assertTrue(testConditionM0("NUMBER", 2));
    }

    @Test
    void testConditionM0WithoutM() {
        // No M following
        assertFalse(testConditionM0("TEST", 1));
    }

    @Test
    void testConditionM0WithInvalidIndex() {
        // Out of bounds index
        assertFalse(testConditionM0("TEST", 3));
    }
}
