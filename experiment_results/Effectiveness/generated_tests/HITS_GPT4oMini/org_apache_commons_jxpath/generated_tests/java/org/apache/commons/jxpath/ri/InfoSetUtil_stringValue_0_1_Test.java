package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.VariablePointer;

public class InfoSetUtil_stringValue_0_1_Test {

    @Test
    public void testStringValueWithString() {
        String input = "Hello, World!";
        String result = InfoSetUtil.stringValue(input);
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testStringValueWithInteger() {
        Integer input = 42;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("42", result);
    }

    @Test
    public void testStringValueWithDouble() {
        Double input = 42.5;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("42.5", result);
    }

    @Test
    public void testStringValueWithBooleanTrue() {
        Boolean input = true;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("true", result);
    }

    @Test
    public void testStringValueWithBooleanFalse() {
        Boolean input = false;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("false", result);
    }

    @Test
    public void testStringValueWithNull() {
        Object input = null;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("", result);
    }

    @Test
    public void testStringValueWithNodePointer() {
        NodePointer input = Mockito.mock(NodePointer.class);
        when(input.getValue()).thenReturn("NodePointer Value");
        String result = InfoSetUtil.stringValue(input);
        assertEquals("NodePointer Value", result);
    }

    @Test
    public void testStringValueWithEvalContext() {
        Pointer mockPointer = Mockito.mock(Pointer.class);
        when(mockPointer.getValue()).thenReturn("EvalContext Value");
        EvalContext input = Mockito.mock(EvalContext.class);
        when(input.getSingleNodePointer()).thenReturn(mockPointer);
        String result = InfoSetUtil.stringValue(input);
        assertEquals("EvalContext Value", result);
    }

    @Test
    public void testStringValueWithOtherObject() {
        Object input = new Object();
        String result = InfoSetUtil.stringValue(input);
        assertEquals(input.toString(), result);
    }
}
