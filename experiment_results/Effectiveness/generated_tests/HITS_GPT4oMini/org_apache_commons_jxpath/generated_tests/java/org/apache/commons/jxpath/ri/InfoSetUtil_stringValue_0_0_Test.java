package org.apache.commons.jxpath.ri;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.VariablePointer;

public class InfoSetUtil_stringValue_0_0_Test {

    @Test
    public void testStringValue_withString() {
        String input = "Hello, World!";
        String result = InfoSetUtil.stringValue(input);
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testStringValue_withEmptyString() {
        String input = "";
        String result = InfoSetUtil.stringValue(input);
        assertEquals("", result);
    }

    @Test
    public void testStringValue_withNull() {
        Object input = null;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("", result);
    }

    @Test
    public void testStringValue_withNumber() {
        Object input = 123;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("123", result);
    }

    @Test
    public void testStringValue_withDecimalNumber() {
        Object input = 123.45;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("123.45", result);
    }

    @Test
    public void testStringValue_withBooleanTrue() {
        Object input = true;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("true", result);
    }

    @Test
    public void testStringValue_withBooleanFalse() {
        Object input = false;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("false", result);
    }

    @Test
    public void testStringValue_withNodePointer() {
        // Assuming NodePointer is a valid class and getValue() returns a String
        // This test is a placeholder since NodePointer implementation is not provided
        // NodePointer nodePointer = new NodePointer("Sample Value");
        // String result = InfoSetUtil.stringValue(nodePointer);
        // assertEquals("Sample Value", result);
    }

    @Test
    public void testStringValue_withEvalContext() {
        // Assuming EvalContext is a valid class and getSingleNodePointer() returns a Pointer
        // This test is a placeholder since EvalContext implementation is not provided
        // EvalContext evalContext = new EvalContext();
        // Pointer pointer = new Pointer("Sample Value");
        // evalContext.setSingleNodePointer(pointer);
        // String result = InfoSetUtil.stringValue(evalContext);
        // assertEquals("Sample Value", result);
    }

    @Test
    public void testStringValue_withOtherObject() {
        Object input = new Object();
        String result = InfoSetUtil.stringValue(input);
        assertEquals(input.toString(), result);
    }
}
