package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JXPath11CompatibleTypeConverter_convert_1_0_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    @Test
    public void testConvert_NodeSetToNodeSet() {
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        assertSame(nodeSet, converter.convert(nodeSet, NodeSet.class));
    }

    @Test
    public void testConvert_NodeSetToObject() {
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        assertSame(nodeSet, converter.convert(nodeSet, Object.class));
    }

    @Test
    public void testConvert_NullToPrimitive() {
        assertThrows(NullPointerException.class, () -> {
            converter.convert(null, int.class);
        });
    }

    @Test
    public void testConvert_NullToObject() {
        assertNull(converter.convert(null, Object.class));
    }

    @Test
    public void testConvert_ObjectToObject() {
        String str = "test";
        assertSame(str, converter.convert(str, Object.class));
    }

    @Test
    public void testConvert_IncompatibleType() {
        assertThrows(JXPathTypeConversionException.class, () -> {
            converter.convert("test", Integer.class);
        });
    }

    @Test
    public void testConvert_NodeSetToString() {
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        when(nodeSet.toString()).thenReturn("Mocked NodeSet");
        assertEquals("Mocked NodeSet", converter.convert(nodeSet, String.class));
    }

    @Test
    public void testConvert_ValidConversion() {
        String str = "123";
        Integer expected = 123;
        assertEquals(expected, converter.convert(str, Integer.class));
    }

    @Test
    public void testConvert_UnsupportedConversion() {
        assertThrows(JXPathTypeConversionException.class, () -> {
            converter.convert(new Object(), Boolean.class);
        });
    }
}
