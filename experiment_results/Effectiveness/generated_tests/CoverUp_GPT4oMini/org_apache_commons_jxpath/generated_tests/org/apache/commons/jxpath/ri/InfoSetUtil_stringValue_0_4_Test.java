package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class InfoSetUtil_stringValue_0_4_Test {

    @Test
    public void testStringValueWithString() {
        String input = "Hello";
        String result = InfoSetUtil.stringValue(input);
        assertEquals("Hello", result);
    }

    @Test
    public void testStringValueWithInteger() {
        Integer input = 5;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("5", result);
    }

    @Test
    public void testStringValueWithDouble() {
        Double input = 5.5;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("5.5", result);
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
        NodePointer mockNodePointer = mock(NodePointer.class);
        when(mockNodePointer.getValue()).thenReturn("NodeValue");
        String result = InfoSetUtil.stringValue(mockNodePointer);
        assertEquals("NodeValue", result);
    }

    @Test
    public void testStringValueWithEvalContext() {
        EvalContext mockEvalContext = mock(EvalContext.class);
        Pointer mockPointer = mock(Pointer.class);
        when(mockEvalContext.getSingleNodePointer()).thenReturn(mockPointer);
        when(mockPointer.getValue()).thenReturn("EvalValue");
        String result = InfoSetUtil.stringValue(mockEvalContext);
        assertEquals("EvalValue", result);
    }

    @Test
    public void testStringValueWithOtherObject() {
        Object input = new Object();
        String result = InfoSetUtil.stringValue(input);
        assertEquals(input.toString(), result);
    }
}
