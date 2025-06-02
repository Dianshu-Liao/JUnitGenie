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

public class InfoSetUtil_number_1_0_Test {

    @Test
    public void testNumberWithNumber() {
        assertEquals(5, InfoSetUtil.number(5));
        assertEquals(3.14, InfoSetUtil.number(3.14));
    }

    @Test
    public void testNumberWithBooleanTrue() {
        assertEquals(1, InfoSetUtil.number(true));
    }

    @Test
    public void testNumberWithBooleanFalse() {
        assertEquals(0, InfoSetUtil.number(false));
    }

    @Test
    public void testNumberWithStringValid() {
        assertEquals(2.5, InfoSetUtil.number("2.5"));
    }

    @Test
    public void testNumberWithStringInvalid() {
        assertEquals(Double.NaN, InfoSetUtil.number("invalid"));
    }

    @Test
    public void testNumberWithEvalContextNullPointer() {
        EvalContext ctx = Mockito.mock(EvalContext.class);
        Mockito.when(ctx.getSingleNodePointer()).thenReturn(null);
        assertEquals(Double.NaN, InfoSetUtil.number(ctx));
    }

    @Test
    public void testNumberWithEvalContextValidPointer() {
        EvalContext ctx = Mockito.mock(EvalContext.class);
        NodePointer pointer = Mockito.mock(NodePointer.class);
        Mockito.when(ctx.getSingleNodePointer()).thenReturn(pointer);
        Mockito.when(pointer.getValue()).thenReturn(10);
        assertEquals(10, InfoSetUtil.number(ctx));
    }

    @Test
    public void testNumberWithNodePointer() {
        NodePointer pointer = Mockito.mock(NodePointer.class);
        Mockito.when(pointer.getValue()).thenReturn(15);
        assertEquals(15, InfoSetUtil.number(pointer));
    }

    @Test
    public void testNumberWithOtherObject() {
        Object obj = new Object();
        assertEquals(Double.NaN, InfoSetUtil.number(obj));
    }
}
