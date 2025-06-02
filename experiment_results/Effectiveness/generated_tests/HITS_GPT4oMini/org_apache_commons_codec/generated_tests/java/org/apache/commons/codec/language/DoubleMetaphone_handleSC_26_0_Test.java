package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class DoubleMetaphone_handleSC_26_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphone.DoubleMetaphoneResult result;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = doubleMetaphone.new DoubleMetaphoneResult(4);
    }

    @Test
    public void testHandleSCWithHAtIndex() {
        invokeHandleSC("SCHOOL", result, 0);
        assertEquals("SK", result.getPrimary());
    }

    @Test
    public void testHandleSCWithVowel() {
        invokeHandleSC("SIEH", result, 0);
        assertEquals("S", result.getPrimary());
    }

    @Test
    public void testHandleSCWithNoH() {
        invokeHandleSC("SCHOOL", result, 0);
        assertEquals("SK", result.getPrimary());
    }

    @Test
    public void testHandleSCAtStartWithConsonant() {
        invokeHandleSC("SCHADE", result, 0);
        assertEquals("SK", result.getPrimary());
    }

    private void invokeHandleSC(String value, DoubleMetaphone.DoubleMetaphoneResult result, int index) {
        try {
            java.lang.reflect.Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
            method.setAccessible(true);
            method.invoke(doubleMetaphone, value, result, index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
