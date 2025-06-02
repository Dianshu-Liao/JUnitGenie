package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JXPath11CompatibleTypeConverter_convert_1_1_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    private static class TestNodeSet implements NodeSet {

        private final List<Object> values;

        public TestNodeSet(List<Object> values) {
            this.values = values;
        }

        @Override
        public List<Object> getValues() {
            return values;
        }

        @Override
        public List<Pointer> getPointers() {
            return Collections.emptyList();
        }

        @Override
        public List<Pointer> getNodes() {
            // Implement as needed for your tests
            return Collections.emptyList();
        }
    }

    @Test
    public void testConvert_WhenObjectIsNodeSetAndToTypeIsNodeSet_ShouldReturnObject() {
        NodeSet nodeSet = new TestNodeSet(Arrays.asList("value1", "value2"));
        assertSame(nodeSet, converter.convert(nodeSet, NodeSet.class));
    }

    @Test
    public void testConvert_WhenObjectIsNodeSetAndToTypeIsNotNodeSet_ShouldCallSuperConvert() {
        NodeSet nodeSet = new TestNodeSet(Arrays.asList("value1", "value2"));
        Object result = converter.convert(nodeSet, String.class);
        assertNotSame(nodeSet, result);
        // Additional assertions can be added based on expected behavior of super.convert
    }

    @Test
    public void testConvert_WhenObjectIsNotNodeSet_ShouldCallSuperConvert() {
        String nonNodeSetObject = "Not a NodeSet";
        Object result = converter.convert(nonNodeSetObject, String.class);
        assertNotSame(nonNodeSetObject, result);
        // Additional assertions can be added based on expected behavior of super.convert
    }

    @Test
    public void testConvert_WhenObjectIsNullAndToTypeIsPrimitive_ShouldReturnDefaultValue() {
        Object result = converter.convert(null, int.class);
        assertEquals(0, result);
    }
}
