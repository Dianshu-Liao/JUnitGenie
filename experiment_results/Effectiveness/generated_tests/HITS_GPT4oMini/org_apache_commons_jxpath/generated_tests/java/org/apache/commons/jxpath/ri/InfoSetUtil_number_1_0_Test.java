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

public class InfoSetUtil_number_1_0_Test {

    @Test
    public void testNumberWithInteger() {
        assertEquals(5, InfoSetUtil.number(5));
    }

    @Test
    public void testNumberWithDouble() {
        assertEquals(5.5, InfoSetUtil.number(5.5));
    }

    @Test
    public void testNumberWithBooleanTrue() {
        // Testing the behavior instead of accessing ONE directly
        assertEquals(1.0, InfoSetUtil.number(true));
    }

    @Test
    public void testNumberWithBooleanFalse() {
        // Testing the behavior instead of accessing ZERO directly
        assertEquals(0.0, InfoSetUtil.number(false));
    }

    @Test
    public void testNumberWithStringRepresentingInteger() {
        assertEquals(10, InfoSetUtil.number("10"));
    }

    @Test
    public void testNumberWithStringRepresentingDouble() {
        assertEquals(3.14, InfoSetUtil.number("3.14"));
    }

    @Test
    public void testNumberWithInvalidString() {
        // Testing the behavior instead of accessing NOT_A_NUMBER directly
        assertEquals(Double.NaN, InfoSetUtil.number("invalid"));
    }

    @Test
    public void testNumberWithNull() {
        // Testing the behavior instead of accessing NOT_A_NUMBER directly
        assertEquals(Double.NaN, InfoSetUtil.number(null));
    }

    @Test
    public void testNumberWithEvalContext() {
        EvalContext ctx = Mockito.mock(EvalContext.class);
        Pointer pointer = Mockito.mock(Pointer.class);
        Mockito.when(pointer.getValue()).thenReturn(42);
        Mockito.when(ctx.getSingleNodePointer()).thenReturn(pointer);
        assertEquals(42, InfoSetUtil.number(ctx));
    }

    @Test
    public void testNumberWithNodePointer() {
        NodePointer np = Mockito.mock(NodePointer.class);
        Mockito.when(np.getValue()).thenReturn(7.5);
        assertEquals(7.5, InfoSetUtil.number(np));
    }

    @Test
    public void testNumberWithObject() {
        Object obj = new Object() {

            @Override
            public String toString() {
                return "20";
            }
        };
        assertEquals(20, InfoSetUtil.number(obj));
    }
}
