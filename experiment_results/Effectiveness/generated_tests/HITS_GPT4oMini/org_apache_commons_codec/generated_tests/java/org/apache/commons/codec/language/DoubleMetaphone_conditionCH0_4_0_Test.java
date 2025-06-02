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

public class DoubleMetaphone_conditionCH0_4_0_Test {

    private final DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

    private boolean invokeConditionCH0(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(doubleMetaphone, value, index);
    }

    @Test
    public void testConditionCH0_WithHaracAtStart() throws Exception {
        assertTrue(invokeConditionCH0("HARAC", 0));
    }

    @Test
    public void testConditionCH0_WithHarIsAtStart() throws Exception {
        assertTrue(invokeConditionCH0("HARIS", 0));
    }

    @Test
    public void testConditionCH0_WithHorAtStart() throws Exception {
        assertTrue(invokeConditionCH0("HOR", 0));
    }

    @Test
    public void testConditionCH0_WithHymAtStart() throws Exception {
        assertTrue(invokeConditionCH0("HYM", 0));
    }

    @Test
    public void testConditionCH0_WithHiaAtStart() throws Exception {
        assertTrue(invokeConditionCH0("HIA", 0));
    }

    @Test
    public void testConditionCH0_WithHemAtStart() throws Exception {
        assertTrue(invokeConditionCH0("HEM", 0));
    }

    @Test
    public void testConditionCH0_WithChoreAtStart() throws Exception {
        assertFalse(invokeConditionCH0("CHORE", 0));
    }

    @Test
    public void testConditionCH0_WithNonMatchingString() throws Exception {
        assertFalse(invokeConditionCH0("TEST", 0));
    }

    @Test
    public void testConditionCH0_WithIndexNotZero() throws Exception {
        assertFalse(invokeConditionCH0("HARAC", 1));
    }

    @Test
    public void testConditionCH0_WithEmptyString() throws Exception {
        assertFalse(invokeConditionCH0("", 0));
    }

    @Test
    public void testConditionCH0_WithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeConditionCH0(null, 0);
        });
    }
}
