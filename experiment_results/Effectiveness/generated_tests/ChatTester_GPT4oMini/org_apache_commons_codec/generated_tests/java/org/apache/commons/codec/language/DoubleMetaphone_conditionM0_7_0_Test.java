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

public class DoubleMetaphone_conditionM0_7_0_Test {

    private DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

    @Test
    public void testConditionM0_WithNextCharM_ReturnsTrue() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "AM", 0);
        assertTrue(result);
    }

    @Test
    public void testConditionM0_WithUMB_ReturnsTrue() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "DUMBER", 2);
        assertTrue(result);
    }

    @Test
    public void testConditionM0_WithNoConditionsMet_ReturnsFalse() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "TEST", 0);
        assertFalse(result);
    }

    @Test
    public void testConditionM0_WithEmptyString_ReturnsFalse() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "", 0);
        assertFalse(result);
    }

    @Test
    public void testConditionM0_WithIndexOutOfBounds_ReturnsFalse() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "A", 0);
        assertFalse(result);
    }

    @Test
    public void testConditionM0_WithIndexAtEnd_ReturnsFalse() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "AM", 1);
        assertFalse(result);
    }

    @Test
    public void testConditionM0_WithIndexAtSecondLast_ReturnsTrue() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionM0", String.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(doubleMetaphone, "TUMBER", 3);
        assertTrue(result);
    }
}
