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

public class DoubleMetaphone_conditionL0_6_1_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    private boolean invokeConditionL0(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(doubleMetaphone, value, index);
    }

    @Test
    public void testConditionL0_withILLO_atIndex() throws Exception {
        assertTrue(invokeConditionL0("ILLO", 1));
    }

    @Test
    public void testConditionL0_withILLA_atIndex() throws Exception {
        assertTrue(invokeConditionL0("ILLA", 1));
    }

    @Test
    public void testConditionL0_withALLE_atIndex() throws Exception {
        assertTrue(invokeConditionL0("ALLE", 1));
    }

    @Test
    public void testConditionL0_withAS_atEnd() throws Exception {
        assertTrue(invokeConditionL0("TESTAS", 4));
    }

    @Test
    public void testConditionL0_withOS_atEnd() throws Exception {
        assertTrue(invokeConditionL0("TESTOS", 4));
    }

    @Test
    public void testConditionL0_withA_atEnd() throws Exception {
        assertTrue(invokeConditionL0("TESTA", 4));
    }

    @Test
    public void testConditionL0_withO_atEnd() throws Exception {
        assertTrue(invokeConditionL0("TESTO", 4));
    }

    @Test
    public void testConditionL0_withoutALLE() throws Exception {
        assertFalse(invokeConditionL0("TEST", 2));
    }

    @Test
    public void testConditionL0_withInvalidIndex() throws Exception {
        assertFalse(invokeConditionL0("TEST", -1));
        assertFalse(invokeConditionL0("TEST", 5));
    }

    @Test
    public void testConditionL0_withEmptyString() throws Exception {
        assertFalse(invokeConditionL0("", 0));
    }

    @Test
    public void testConditionL0_withNullValue() throws Exception {
        assertFalse(invokeConditionL0(null, 0));
    }
}
