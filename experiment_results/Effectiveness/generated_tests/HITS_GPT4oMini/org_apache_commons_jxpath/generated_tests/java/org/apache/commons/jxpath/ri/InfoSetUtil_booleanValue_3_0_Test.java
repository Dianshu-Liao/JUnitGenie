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
    public void testBooleanValue_WithPositiveNumber() {
        assertTrue(InfoSetUtil.booleanValue(1));
    }

    @Test
    public void testBooleanValue_WithNegativeNumber() {
        assertTrue(InfoSetUtil.booleanValue(-1));
    }

    @Test
    public void testBooleanValue_WithZero() {
        assertFalse(InfoSetUtil.booleanValue(0));
    }

    @Test
    public void testBooleanValue_WithNegativeZero() {
        assertFalse(InfoSetUtil.booleanValue(-0.0));
    }

    @Test
    public void testBooleanValue_WithNaN() {
        assertFalse(InfoSetUtil.booleanValue(Double.NaN));
    }

    @Test
    public void testBooleanValue_WithPositiveDouble() {
        assertTrue(InfoSetUtil.booleanValue(2.5));
    }

    @Test
    public void testBooleanValue_WithNegativeDouble() {
        assertTrue(InfoSetUtil.booleanValue(-2.5));
    }

    @Test
    public void testBooleanValue_WithNull() {
        assertFalse(InfoSetUtil.booleanValue(null));
    }

    @Test
    public void testBooleanValue_WithBooleanTrue() {
        assertTrue(InfoSetUtil.booleanValue(Boolean.TRUE));
    }

    @Test
    public void testBooleanValue_WithBooleanFalse() {
        assertFalse(InfoSetUtil.booleanValue(Boolean.FALSE));
    }

    @Test
    public void testBooleanValue_WithString() {
        assertTrue(InfoSetUtil.booleanValue("Non-empty string"));
        assertFalse(InfoSetUtil.booleanValue(""));
    }
}
