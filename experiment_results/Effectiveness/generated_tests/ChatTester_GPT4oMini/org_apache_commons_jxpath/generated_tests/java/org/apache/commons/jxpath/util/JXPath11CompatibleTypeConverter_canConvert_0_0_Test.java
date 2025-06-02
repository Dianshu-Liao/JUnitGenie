package org.apache.commons.jxpath.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.NodeSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JXPath11CompatibleTypeConverter_canConvert_0_0_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    @Test
    void testCanConvertWithNodeSet() {
        // Create a mock for NodeSet instead of instantiating it directly
        NodeSet nodeSet = mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, NodeSet.class), "Should return true for NodeSet to NodeSet conversion");
    }

    @Test
    void testCanConvertWithDifferentType() {
        // Create a mock for NodeSet instead of instantiating it directly
        NodeSet nodeSet = mock(NodeSet.class);
        assertFalse(converter.canConvert(nodeSet, String.class), "Should return false for NodeSet to String conversion");
    }

    @Test
    void testCanConvertWithNullObject() {
        assertFalse(converter.canConvert(null, Object.class), "Should return false for null object");
    }

    @Test
    void testCanConvertWithNonNodeSetObject() {
        String nonNodeSetObject = "Not a NodeSet";
        assertFalse(converter.canConvert(nonNodeSetObject, NodeSet.class), "Should return false for non-NodeSet to NodeSet conversion");
    }

    @Test
    void testCanConvertWithSuperclass() {
        Object someObject = new Object();
        assertFalse(converter.canConvert(someObject, NodeSet.class), "Should return false for Object to NodeSet conversion");
    }
}
