package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.util.JXPath11CompatibleTypeConverter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class JXPath11CompatibleTypeConverter_canConvert_0_0_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    @Test
    void testCanConvertWithNodeSetAndMatchingType() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, NodeSet.class));
    }

    @Test
    void testCanConvertWithNodeSetAndNonMatchingType() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertFalse(converter.canConvert(nodeSet, String.class));
    }

    @Test
    void testCanConvertWithNullObject() {
        assertFalse(converter.canConvert(null, String.class));
    }

    @Test
    void testCanConvertWithNonNodeSetObject() {
        String str = "test";
        assertFalse(converter.canConvert(str, NodeSet.class));
    }

    @Test
    void testCanConvertWithNonNodeSetAndMatchingType() {
        String str = "test";
        assertTrue(converter.canConvert(str, Object.class));
    }

    @Test
    void testCanConvertWithNonNodeSetAndNonMatchingType() {
        String str = "test";
        assertFalse(converter.canConvert(str, Integer.class));
    }

    @Test
    void testCanConvertWithNodeSetAndCompatibleType() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, Serializable.class));
    }

    @Test
    void testCanConvertWithNodeSetAndIncompatibleType() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertFalse(converter.canConvert(nodeSet, Double.class));
    }

    @Test
    void testCanConvertWithEmptyNodeSet() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, Collection.class));
    }

    @Test
    void testCanConvertWithNodeSetAsArray() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, NodeSet[].class));
    }

    @Test
    void testCanConvertWithNodeSetAsCollection() {
        NodeSet nodeSet = mock(NodeSet.class);
        assertTrue(converter.canConvert(nodeSet, List.class));
    }

    // Reflection test for private method in superclass if necessary
    @Test
    void testPrivateMethodInSuperClass() throws Exception {
        Method method = BasicTypeConverter.class.getDeclaredMethod("canConvert", Object.class, Class.class);
        method.setAccessible(true);
        assertNotNull(method);
    }
}
