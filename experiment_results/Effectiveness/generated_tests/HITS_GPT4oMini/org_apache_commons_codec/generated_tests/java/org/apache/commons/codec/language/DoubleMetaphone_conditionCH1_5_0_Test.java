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

public class DoubleMetaphone_conditionCH1_5_0_Test {

    private final DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

    private boolean invokeConditionCH1(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionCH1", String.class, int.class);
        // Make the private method accessible
        method.setAccessible(true);
        return (Boolean) method.invoke(doubleMetaphone, value, index);
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
        assertTrue(invokeConditionCH1("ORCHESTRATION", 3));
    }

    @Test
    public void testConditionCH1_WithARCHIT() throws Exception {
        assertTrue(invokeConditionCH1("ARCHITECTURE", 3));
    }

    @Test
    public void testConditionCH1_WithORCHID() throws Exception {
        assertTrue(invokeConditionCH1("ORCHID", 3));
    }

    @Test
    public void testConditionCH1_WithT() throws Exception {
        assertTrue(invokeConditionCH1("TESTING", 4));
    }

    @Test
    public void testConditionCH1_WithS() throws Exception {
        assertTrue(invokeConditionCH1("TESTS", 4));
    }

    @Test
    public void testConditionCH1_WithAAtStart() throws Exception {
        assertTrue(invokeConditionCH1("ALEX", 0));
    }

    @Test
    public void testConditionCH1_WithOAtEnd() throws Exception {
        assertTrue(invokeConditionCH1("BLOOM", 4));
    }

    @Test
    public void testConditionCH1_WithUAtEnd() throws Exception {
        assertTrue(invokeConditionCH1("MOUNTAIN", 4));
    }

    @Test
    public void testConditionCH1_WithEAtEnd() throws Exception {
        assertTrue(invokeConditionCH1("BEE", 2));
    }

    @Test
    public void testConditionCH1_WithNoConditionsMet() throws Exception {
        assertFalse(invokeConditionCH1("HELLO", 2));
    }

    @Test
    public void testConditionCH1_WithIndexOutOfBounds() throws Exception {
        assertFalse(invokeConditionCH1("TEST", 5));
    }
}
