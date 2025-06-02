package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JXPath11CompatibleTypeConverter_canConvert_0_1_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    @Test
    public void testCanConvert_NullObject() {
        // Test case where the object is null
        assertTrue(converter.canConvert(null, String.class), "Expected canConvert to return true for null object.");
    }

    @Test
    public void testCanConvert_NodeSetToNodeSet() {
        // Test case where the object is an instance of NodeSet and toType is NodeSet
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, NodeSet.class), "Expected canConvert to return true for NodeSet to NodeSet.");
    }

    @Test
    public void testCanConvert_NodeSetToOtherType() {
        // Test case where the object is an instance of NodeSet and toType is a different class
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        assertFalse(converter.canConvert(nodeSet, Integer.class), "Expected canConvert to return false for NodeSet to Integer.");
    }

    @Test
    public void testCanConvert_NonNodeSetObject() {
        // Test case where the object is not a NodeSet
        String str = "test";
        assertFalse(converter.canConvert(str, NodeSet.class), "Expected canConvert to return false for String to NodeSet.");
    }

    @Test
    public void testCanConvert_NullToAnyType() {
        // Test case where the object is null and toType is any class
        assertTrue(converter.canConvert(null, Integer.class), "Expected canConvert to return true for null object to Integer.");
        assertTrue(converter.canConvert(null, Boolean.class), "Expected canConvert to return true for null object to Boolean.");
        assertTrue(converter.canConvert(null, Object.class), "Expected canConvert to return true for null object to Object.");
    }
}
