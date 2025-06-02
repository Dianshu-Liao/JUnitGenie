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

public class DoubleMetaphone_conditionCH1_5_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test
    public void testConditionCH1_WithVAN() throws Exception {
        assertTrue(invokeConditionCH1("VAN", 0));
    }

    @Test
    public void testConditionCH1_WithVON() throws Exception {
        assertTrue(invokeConditionCH1("VON", 0));
    }

    @Test
    public void testConditionCH1_WithSCH() throws Exception {
        assertTrue(invokeConditionCH1("SCHOOL", 0));
    }

    @Test
    public void testConditionCH1_WithORCHES() throws Exception {
        assertTrue(invokeConditionCH1("ORCHESTRATE", 4));
    }

    @Test
    public void testConditionCH1_WithARCHIT() throws Exception {
        assertTrue(invokeConditionCH1("ARCHITECT", 4));
    }

    @Test
    public void testConditionCH1_WithORCHID() throws Exception {
        assertTrue(invokeConditionCH1("ORCHID", 4));
    }

    @Test
    public void testConditionCH1_WithT() throws Exception {
        assertTrue(invokeConditionCH1("TEST", 2));
    }

    @Test
    public void testConditionCH1_WithS() throws Exception {
        assertTrue(invokeConditionCH1("TESTS", 2));
    }

    @Test
    public void testConditionCH1_WithAAtStart() throws Exception {
        assertTrue(invokeConditionCH1("A", 0));
    }

    @Test
    public void testConditionCH1_WithOAtEnd() throws Exception {
        assertTrue(invokeConditionCH1("BO", 1));
    }

    @Test
    public void testConditionCH1_WithInvalidInput() throws Exception {
        assertFalse(invokeConditionCH1("XYZ", 1));
    }

    @Test
    public void testConditionCH1_WithEmptyString() throws Exception {
        assertFalse(invokeConditionCH1("", 0));
    }

    private boolean invokeConditionCH1(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(doubleMetaphone, value, index);
    }
}
