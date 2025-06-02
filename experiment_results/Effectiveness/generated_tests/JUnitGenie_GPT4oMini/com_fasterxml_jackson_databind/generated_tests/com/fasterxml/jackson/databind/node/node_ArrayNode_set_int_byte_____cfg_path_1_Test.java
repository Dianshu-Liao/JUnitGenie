package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.BinaryNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_set_int_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetMethodWithNonNullByteArray() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        int index = 0;
        byte[] value = new byte[]{1, 2, 3};

        // Act
        BinaryNode result = null;
        try {
            // Corrected the type casting to ArrayNode
            result = (BinaryNode) arrayNode.set(index, new BinaryNode(value));
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testSetMethodWithNullByteArray() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        int index = 0;
        byte[] value = null;

        // Act
        BinaryNode result = null;
        try {
            // Corrected the type casting to BinaryNode
            result = (BinaryNode) arrayNode.set(index, value != null ? new BinaryNode(value) : null);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

}