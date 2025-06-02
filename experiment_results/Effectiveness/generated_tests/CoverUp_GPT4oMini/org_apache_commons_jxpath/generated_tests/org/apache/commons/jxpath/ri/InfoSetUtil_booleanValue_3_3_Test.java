package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InfoSetUtil_booleanValue_3_3_Test {

    @Test
    public void testBooleanValueWithNumber() {
        assertTrue(InfoSetUtil.booleanValue(1));
        assertTrue(InfoSetUtil.booleanValue(1.0));
        assertFalse(InfoSetUtil.booleanValue(0));
        assertFalse(InfoSetUtil.booleanValue(-0.0));
        assertFalse(InfoSetUtil.booleanValue(Double.NaN));
    }

    @Test
    public void testBooleanValueWithBoolean() {
        assertTrue(InfoSetUtil.booleanValue(true));
        assertFalse(InfoSetUtil.booleanValue(false));
    }

    @Test
    public void testBooleanValueWithEvalContext() {
        EvalContext ctxMock = mock(EvalContext.class);
        Pointer ptrMock = mock(Pointer.class);
        when(ctxMock.getSingleNodePointer()).thenReturn(ptrMock);
        assertTrue(InfoSetUtil.booleanValue(ctxMock));
        when(ctxMock.getSingleNodePointer()).thenReturn(null);
        assertFalse(InfoSetUtil.booleanValue(ctxMock));
    }

    @Test
    public void testBooleanValueWithString() {
        assertTrue(InfoSetUtil.booleanValue("Non-empty string"));
        assertFalse(InfoSetUtil.booleanValue(""));
    }

    @Test
    public void testBooleanValueWithNodePointer() throws Exception {
        NodePointer nodePointerMock = mock(NodePointer.class);
        when(nodePointerMock.isActual()).thenReturn(true);
        assertTrue(InfoSetUtil.booleanValue(nodePointerMock));
        when(nodePointerMock.isActual()).thenReturn(false);
        assertFalse(InfoSetUtil.booleanValue(nodePointerMock));
        VariablePointer variablePointerMock = mock(VariablePointer.class);
        when(variablePointerMock.getNode()).thenReturn("Some Node");
        assertTrue(InfoSetUtil.booleanValue(variablePointerMock));
    }

    @Test
    public void testBooleanValueWithNull() {
        assertFalse(InfoSetUtil.booleanValue(null));
    }
}
