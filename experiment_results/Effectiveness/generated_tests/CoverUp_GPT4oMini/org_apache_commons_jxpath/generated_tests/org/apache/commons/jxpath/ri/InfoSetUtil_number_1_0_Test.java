package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.VariablePointer;

class InfoSetUtil_number_1_0_Test {

    private static final Double ZERO = Double.valueOf(0);

    private static final Double ONE = Double.valueOf(1);

    private static final Double NOT_A_NUMBER = Double.valueOf(Double.NaN);

    @Test
    void testNumberWithNumber() {
        assertEquals(5, InfoSetUtil.number(5));
        assertEquals(3.14, InfoSetUtil.number(3.14));
    }

    @Test
    void testNumberWithBoolean() {
        assertEquals(ONE, InfoSetUtil.number(true));
        assertEquals(ZERO, InfoSetUtil.number(false));
    }

    @Test
    void testNumberWithString() {
        assertEquals(42, InfoSetUtil.number("42"));
        assertEquals(3.14, InfoSetUtil.number("3.14"));
        assertEquals(NOT_A_NUMBER, InfoSetUtil.number("not a number"));
    }

    @Test
    void testNumberWithEvalContext() {
        EvalContext ctx = mock(EvalContext.class);
        Pointer ptr = mock(Pointer.class);
        when(ctx.getSingleNodePointer()).thenReturn(ptr);
        when(ptr.getValue()).thenReturn(10);
        assertEquals(10, InfoSetUtil.number(ctx));
    }

    @Test
    void testNumberWithNodePointer() {
        NodePointer nodePointer = mock(NodePointer.class);
        when(nodePointer.getValue()).thenReturn(20);
        assertEquals(20, InfoSetUtil.number(nodePointer));
    }

    @Test
    void testNumberWithNull() {
        assertEquals(NOT_A_NUMBER, InfoSetUtil.number(null));
    }

    @Test
    void testNumberWithOtherObject() {
        assertEquals(NOT_A_NUMBER, InfoSetUtil.number(new Object()));
    }
}
