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

    private Method conditionL0Method;

    @BeforeEach
    public void setUp() throws Exception {
        doubleMetaphone = new DoubleMetaphone();
        conditionL0Method = DoubleMetaphone.class.getDeclaredMethod("conditionL0", String.class, int.class);
        // Make the private method accessible
        conditionL0Method.setAccessible(true);
    }

    @Test
    public void testConditionL0_WhenIndexIsThirdLastAndContainsILLO_ShouldReturnTrue() throws Exception {
        String value = "HELLOILLO";
        int index = value.length() - 3;
        assertTrue((Boolean) conditionL0Method.invoke(doubleMetaphone, value, index));
    }

    @Test
    public void testConditionL0_WhenIndexIsThirdLastAndContainsILLA_ShouldReturnTrue() throws Exception {
        String value = "HELLOILLA";
        int index = value.length() - 3;
        assertTrue((Boolean) conditionL0Method.invoke(doubleMetaphone, value, index));
    }

    @Test
    public void testConditionL0_WhenIndexIsThirdLastAndContainsALLE_ShouldReturnTrue() throws Exception {
        String value = "HELLOALLE";
        int index = value.length() - 3;
        assertTrue((Boolean) conditionL0Method.invoke(doubleMetaphone, value, index));
    }

    @Test
    public void testConditionL0_WhenIndexIsThirdLastAndDoesNotContainPatterns_ShouldReturnFalse() throws Exception {
        String value = "HELLOXYZ";
        int index = value.length() - 3;
        assertFalse((Boolean) conditionL0Method.invoke(doubleMetaphone, value, index));
    }

    @Test
    public void testConditionL0_WhenIndexIsNotThirdLast_ShouldReturnFalse() throws Exception {
        String value = "HELLOILLO";
        int index = value.length() - 4;
        assertFalse((Boolean) conditionL0Method.invoke(doubleMetaphone, value, index));
    }

    @Test
    public void testConditionL0_WhenIndexIsOutOfBounds_ShouldReturnFalse() throws Exception {
        String value = "HELLO";
        int index = value.length() - 1;
        assertFalse((Boolean) conditionL0Method.invoke(doubleMetaphone, value, index));
    }
}
