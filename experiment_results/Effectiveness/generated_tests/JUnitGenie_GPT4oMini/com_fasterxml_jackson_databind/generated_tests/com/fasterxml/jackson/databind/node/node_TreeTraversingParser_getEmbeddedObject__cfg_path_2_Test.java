package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class node_TreeTraversingParser_getEmbeddedObject__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWhenNodeIsNotPojoAndNotBinary() {
        // Arrange
        JsonNode mockNode = mock(JsonNode.class);
        when(mockNode.isPojo()).thenReturn(false);
        when(mockNode.isBinary()).thenReturn(false);
        when(mockNode.getNodeType()).thenReturn(JsonNodeType.OBJECT); // Correctly stubbing getNodeType()

        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        parser._closed = false; // Ensure _closed is false

        // Act
        Object result = parser.getEmbeddedObject();

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWhenNodeIsBinary() {
        // Arrange
        BinaryNode mockNode = mock(BinaryNode.class); // Changed to BinaryNode
        when(mockNode.isPojo()).thenReturn(false);
        when(mockNode.isBinary()).thenReturn(true);
        when(mockNode.binaryValue()).thenReturn(new byte[]{1, 2, 3});
        when(mockNode.getNodeType()).thenReturn(JsonNodeType.BINARY); // Correctly stubbing getNodeType()

        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        parser._closed = false; // Ensure _closed is false

        // Act
        Object result = parser.getEmbeddedObject();

        // Assert
        assertNull(result); // Since we are not returning the binary value in this path
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWhenNodeIsPojo() {
        // Arrange
        POJONode mockNode = mock(POJONode.class); // Changed to POJONode
        Object mockPojo = new Object();
        when(mockNode.isPojo()).thenReturn(true);
        when(mockNode.getPojo()).thenReturn(mockPojo);
        when(mockNode.getNodeType()).thenReturn(JsonNodeType.OBJECT); // Correctly stubbing getNodeType()

        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        parser._closed = false; // Ensure _closed is false

        // Act
        Object result = parser.getEmbeddedObject();

        // Assert
        assertNull(result); // Since we are not returning the POJO value in this path
    }

}
