package org.apache.commons.jxpath.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.NodeSet;

public class JXPath11CompatibleTypeConverter_convert_1_0_Test {

    private JXPath11CompatibleTypeConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new JXPath11CompatibleTypeConverter();
    }

    @Test
    public void testConvert_WithNodeSetAndMatchingType() {
        // Arrange
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        // Act
        Object result = converter.convert(nodeSet, NodeSet.class);
        // Assert
        assertSame(nodeSet, result);
    }

    @Test
    public void testConvert_WithNodeSetAndNonMatchingType() {
        // Arrange
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        // Act
        Object result = converter.convert(nodeSet, String.class);
        // Assert
        // Assuming super.convert handles this case differently
        assertNotSame(nodeSet, result);
        // Assuming super.convert returns null for this case
        assertNull(result);
    }

    @Test
    public void testConvert_WithNonNodeSet() {
        // Arrange
        String nonNodeSetObject = "Not a NodeSet";
        // Act
        Object result = converter.convert(nonNodeSetObject, String.class);
        // Assert
        // Assuming super.convert handles this case differently
        assertNotSame(nonNodeSetObject, result);
        // Assuming super.convert returns null for this case
        assertNull(result);
    }

    // Assuming NodeSet class exists
    public static class NodeSet {
        // NodeSet implementation
    }
}
