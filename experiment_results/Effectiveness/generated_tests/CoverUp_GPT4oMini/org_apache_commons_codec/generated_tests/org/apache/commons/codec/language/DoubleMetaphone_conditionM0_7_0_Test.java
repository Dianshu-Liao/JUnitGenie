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

class DoubleMetaphone_conditionM0_7_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test
    void testConditionM0_MFollowedByM_ReturnsTrue() throws Exception {
        String value = "SOMETHINGM";
        // 'M' is at index 8
        int index = 8;
        boolean result = invokeConditionM0(doubleMetaphone, value, index);
        assertTrue(result);
    }

    @Test
    void testConditionM0_UMBBeforeM_ReturnsTrue() throws Exception {
        String value = "SOMETHINGUMB";
        // 'M' is at index 8
        int index = 8;
        boolean result = invokeConditionM0(doubleMetaphone, value, index);
        assertTrue(result);
    }

    @Test
    void testConditionM0_NoM_ReturnsFalse() throws Exception {
        String value = "SOMETHING";
        // 'H' is at index 6
        int index = 6;
        boolean result = invokeConditionM0(doubleMetaphone, value, index);
        assertFalse(result);
    }

    @Test
    void testConditionM0_UMBNotFollowedByER_ReturnsFalse() throws Exception {
        String value = "SOMETHINGUMBXYZ";
        // 'M' is at index 8
        int index = 8;
        boolean result = invokeConditionM0(doubleMetaphone, value, index);
        assertFalse(result);
    }

    @Test
    void testConditionM0_EmptyString_ReturnsFalse() throws Exception {
        String value = "";
        // No valid index
        int index = 0;
        boolean result = invokeConditionM0(doubleMetaphone, value, index);
        assertFalse(result);
    }

    private boolean invokeConditionM0(DoubleMetaphone instance, String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(instance, value, index);
    }
}
