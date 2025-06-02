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

public class InfoSetUtil_booleanValue_3_2_Test {

    @Test
    public void testBooleanValue_WithNonZeroNumber() {
        assertTrue(InfoSetUtil.booleanValue(1));
        assertTrue(InfoSetUtil.booleanValue(-1));
        assertTrue(InfoSetUtil.booleanValue(3.14));
    }

    @Test
    public void testBooleanValue_WithZeroNumber() {
        assertFalse(InfoSetUtil.booleanValue(0));
        assertFalse(InfoSetUtil.booleanValue(-0.0));
    }

    @Test
    public void testBooleanValue_WithNaN() {
        assertFalse(InfoSetUtil.booleanValue(Double.NaN));
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
    public void testBooleanValue_WithNonEmptyString() {
        assertTrue(InfoSetUtil.booleanValue("Hello"));
    }

    @Test
    public void testBooleanValue_WithEmptyString() {
        assertFalse(InfoSetUtil.booleanValue(""));
    }
}
