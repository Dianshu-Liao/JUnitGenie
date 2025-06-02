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

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test
    public void testConditionL0_WithValidILLO() throws Exception {
        assertTrue(invokeConditionL0("ILLO", 1));
    }

    @Test
    public void testConditionL0_WithValidILLA() throws Exception {
        assertTrue(invokeConditionL0("ILLA", 1));
    }

    @Test
    public void testConditionL0_WithValidAS() throws Exception {
        assertTrue(invokeConditionL0("ALIAS", 2));
    }

    @Test
    public void testConditionL0_WithValidOS() throws Exception {
        assertTrue(invokeConditionL0("BOS", 1));
    }

    @Test
    public void testConditionL0_WithValidA() throws Exception {
        assertTrue(invokeConditionL0("BA", 1));
    }

    @Test
    public void testConditionL0_WithValidO() throws Exception {
        assertTrue(invokeConditionL0("BO", 1));
    }

    @Test
    public void testConditionL0_WithInvalidCase() throws Exception {
        assertFalse(invokeConditionL0("HELLO", 1));
    }

    @Test
    public void testConditionL0_WithNullValue() throws Exception {
        assertThrows(NullPointerException.class, () -> invokeConditionL0(null, 1));
    }

    @Test
    public void testConditionL0_WithIndexOutOfBounds() throws Exception {
        assertFalse(invokeConditionL0("TEST", 10));
    }

    private boolean invokeConditionL0(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(doubleMetaphone, value, index);
    }
}
