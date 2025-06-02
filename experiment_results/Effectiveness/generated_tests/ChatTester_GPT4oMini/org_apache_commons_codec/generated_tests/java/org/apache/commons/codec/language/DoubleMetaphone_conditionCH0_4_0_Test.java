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

    private DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

    @Test
    public void testConditionCH0_IndexNotZero() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "HARAC", 1));
    }

    @Test
    public void testConditionCH0_ContainsHARAC() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(doubleMetaphone, "HARAC", 0));
    }

    @Test
    public void testConditionCH0_ContainsHARIS() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(doubleMetaphone, "HARIS", 0));
    }

    @Test
    public void testConditionCH0_ContainsHOR() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "HOR", 0));
    }

    @Test
    public void testConditionCH0_ContainsHYM() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "HYM", 0));
    }

    @Test
    public void testConditionCH0_ContainsHIA() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "HIA", 0));
    }

    @Test
    public void testConditionCH0_ContainsHEM() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "HEM", 0));
    }

    @Test
    public void testConditionCH0_ContainsCHORE() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "CHORE", 0));
    }

    @Test
    public void testConditionCH0_NotContainsCHORE() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH0", String.class, int.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(doubleMetaphone, "HARAC", 0));
    }
}
