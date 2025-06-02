package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class JXPath11CompatibleTypeConverter_canConvert_0_4_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    private static class MockNodeSet implements NodeSet {

        private final List<Object> values;

        public MockNodeSet(List<Object> values) {
            this.values = values;
        }

        @Override
        public List<Object> getValues() {
            return values;
        }

        @Override
        public List<Object> getPointers() {
            // Mock implementation
            return new ArrayList<>(values.size());
        }

        @Override
        public List<?> getNodes() {
            // Implementing the abstract method
            return new ArrayList<>(values);
        }
    }

    @Test
    void testCanConvertWithNodeSet() {
        NodeSet nodeSet = new MockNodeSet(java.util.Arrays.asList("value1", "value2"));
        assertTrue(converter.canConvert(nodeSet, NodeSet.class), "Should be able to convert NodeSet to NodeSet");
        assertFalse(converter.canConvert(nodeSet, String.class), "Should not be able to convert NodeSet to String");
    }

    @Test
    void testCanConvertWithNullObject() {
        assertTrue(converter.canConvert(null, String.class), "Should be able to convert null to any type");
    }

    @Test
    void testCanConvertWithNonNodeSet() {
        String str = "test";
        assertTrue(converter.canConvert(str, String.class), "Should be able to convert String to String");
        assertFalse(converter.canConvert(str, NodeSet.class), "Should not be able to convert String to NodeSet");
    }

    @Test
    void testCanConvertWithDifferentTypes() {
        Integer integer = 5;
        assertTrue(converter.canConvert(integer, Number.class), "Should be able to convert Integer to Number");
        assertFalse(converter.canConvert(integer, String.class), "Should not be able to convert Integer to String");
    }

    @Test
    void testCanConvertWithEmptyNodeSet() {
        NodeSet emptyNodeSet = new MockNodeSet(java.util.Collections.emptyList());
        assertTrue(converter.canConvert(emptyNodeSet, NodeSet.class), "Should be able to convert empty NodeSet to NodeSet");
        assertFalse(converter.canConvert(emptyNodeSet, String.class), "Should not be able to convert empty NodeSet to String");
    }

    @Test
    void testCanConvertWithMixedTypes() {
        NodeSet mixedNodeSet = new MockNodeSet(java.util.Arrays.asList(1, "string", 3.14));
        assertTrue(converter.canConvert(mixedNodeSet, Object.class), "Should be able to convert NodeSet to Object");
        assertFalse(converter.canConvert(mixedNodeSet, Integer.class), "Should not be able to convert mixed NodeSet to Integer");
    }
}
