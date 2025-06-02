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

public class InfoSetUtil_booleanValue_3_0_Test {

    @Test
    public void testBooleanValue_Number_NonZero() {
        assertTrue(InfoSetUtil.booleanValue(5));
    }

    @Test
    public void testBooleanValue_Number_Zero() {
        assertFalse(InfoSetUtil.booleanValue(0));
    }

    @Test
    public void testBooleanValue_Number_NegativeZero() {
        assertFalse(InfoSetUtil.booleanValue(-0.0));
    }

    @Test
    public void testBooleanValue_Number_NaN() {
        assertFalse(InfoSetUtil.booleanValue(Double.NaN));
    }

    @Test
    public void testBooleanValue_Boolean_True() {
        assertTrue(InfoSetUtil.booleanValue(Boolean.TRUE));
    }

    @Test
    public void testBooleanValue_Boolean_False() {
        assertFalse(InfoSetUtil.booleanValue(Boolean.FALSE));
    }

    @Test
    public void testBooleanValue_EvalContext() {
        EvalContext ctx = Mockito.mock(EvalContext.class);
        Pointer pointer = Mockito.mock(Pointer.class);
        Mockito.when(ctx.getSingleNodePointer()).thenReturn(pointer);
        Mockito.when(pointer.getNode()).thenReturn(1);
        assertTrue(InfoSetUtil.booleanValue(ctx));
    }

    @Test
    public void testBooleanValue_String_NonEmpty() {
        assertTrue(InfoSetUtil.booleanValue("Hello"));
    }

    @Test
    public void testBooleanValue_String_Empty() {
        assertFalse(InfoSetUtil.booleanValue(""));
    }

    @Test
    public void testBooleanValue_NodePointer() {
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        Mockito.when(nodePointer.getValuePointer()).thenReturn(nodePointer);
        Mockito.when(nodePointer.isActual()).thenReturn(true);
        assertTrue(InfoSetUtil.booleanValue(nodePointer));
    }

    @Test
    public void testBooleanValue_VariablePointer() {
        VariablePointer variablePointer = Mockito.mock(VariablePointer.class);
        Mockito.when(variablePointer.getNode()).thenReturn(1);
        assertTrue(InfoSetUtil.booleanValue(variablePointer));
    }

    @Test
    public void testBooleanValue_Null() {
        assertFalse(InfoSetUtil.booleanValue(null));
    }

    @Test
    public void testBooleanValue_OtherObject() {
        assertTrue(InfoSetUtil.booleanValue(new Object()));
    }

    @Test
    public void testBooleanValue_NodePointer_NotActual() {
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        Mockito.when(nodePointer.getValuePointer()).thenReturn(nodePointer);
        Mockito.when(nodePointer.isActual()).thenReturn(false);
        assertFalse(InfoSetUtil.booleanValue(nodePointer));
    }
}
