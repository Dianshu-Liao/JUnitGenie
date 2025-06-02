package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JXPath11CompatibleTypeConverter_canConvert_0_2_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    private static class TestNodeSet implements NodeSet {

        @Override
        public List<Object> getValues() {
            return Collections.emptyList();
        }

        @Override
        public List<Pointer> getPointers() {
            return Collections.emptyList();
        }

        @Override
        public List<Pointer> getNodes() {
            return Collections.emptyList();
        }
    }

    @Test
    public void testCanConvert_WithNodeSetToNodeSet() {
        NodeSet nodeSet = new TestNodeSet();
        assertTrue(converter.canConvert(nodeSet, NodeSet.class));
    }

    @Test
    public void testCanConvert_WithNodeSetToObject() {
        NodeSet nodeSet = new TestNodeSet();
        assertFalse(converter.canConvert(nodeSet, Object.class));
    }

    @Test
    public void testCanConvert_WithNullObject() {
        assertTrue(converter.canConvert(null, String.class));
    }

    @Test
    public void testCanConvert_WithStringToString() {
        assertTrue(converter.canConvert("test", String.class));
    }

    @Test
    public void testCanConvert_WithIntegerToString() {
        assertTrue(converter.canConvert(123, String.class));
    }

    @Test
    public void testCanConvert_WithBooleanToNumber() {
        assertTrue(converter.canConvert(true, Number.class));
    }

    @Test
    public void testCanConvert_WithNumberToBoolean() {
        assertTrue(converter.canConvert(123, Boolean.class));
    }

    @Test
    public void testCanConvert_WithArrayToArray() {
        Integer[] intArray = new Integer[] { 1, 2, 3 };
        assertTrue(converter.canConvert(intArray, Integer[].class));
    }

    @Test
    public void testCanConvert_WithCollectionToArray() {
        assertTrue(converter.canConvert(java.util.Arrays.asList(1, 2, 3), Integer[].class));
    }

    @Test
    public void testCanConvert_WithCollectionToCollection() {
        assertTrue(converter.canConvert(java.util.Arrays.asList(1, 2, 3), java.util.List.class));
    }
}
