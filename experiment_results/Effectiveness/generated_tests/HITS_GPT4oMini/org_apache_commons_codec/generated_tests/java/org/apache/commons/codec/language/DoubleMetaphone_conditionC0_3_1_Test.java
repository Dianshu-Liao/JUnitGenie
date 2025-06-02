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

public class DoubleMetaphone_conditionC0_3_1_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    private boolean callConditionC0(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(doubleMetaphone, value, index);
    }

    @Test
    public void testConditionC0_WithValidInput_CHIA() throws Exception {
        assertTrue(callConditionC0("CHIA", 1));
    }

    @Test
    public void testConditionC0_WithIndexLessThanOrEqualToOne() throws Exception {
        assertFalse(callConditionC0("A", 0));
        assertFalse(callConditionC0("A", 1));
    }

    @Test
    public void testConditionC0_WithVowelAtIndexMinusTwo() throws Exception {
        assertFalse(callConditionC0("BACH", 3));
    }

    @Test
    public void testConditionC0_WithNoACHAtIndexMinusOne() throws Exception {
        assertFalse(callConditionC0("BACHER", 3));
    }

    @Test
    public void testConditionC0_WithCharIAtIndexPlusTwo() throws Exception {
        assertFalse(callConditionC0("MACHIER", 3));
    }

    @Test
    public void testConditionC0_WithCharEAtIndexPlusTwo() throws Exception {
        assertFalse(callConditionC0("MACHIER", 3));
    }

    @Test
    public void testConditionC0_WithBACHERAtIndexMinusTwo() throws Exception {
        assertTrue(callConditionC0("BACHER", 3));
    }

    @Test
    public void testConditionC0_WithMACHERAtIndexMinusTwo() throws Exception {
        assertTrue(callConditionC0("MACHER", 3));
    }
}
