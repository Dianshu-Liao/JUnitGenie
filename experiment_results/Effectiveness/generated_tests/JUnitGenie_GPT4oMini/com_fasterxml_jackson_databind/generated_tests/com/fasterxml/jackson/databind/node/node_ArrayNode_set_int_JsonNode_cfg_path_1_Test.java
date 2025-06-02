package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ArrayNode_set_int_JsonNode_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetWithIndexOutOfBounds() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        // Initialize _children to ensure size() returns 0
        // This is necessary to meet the constraints for the test
        arrayNode.add(factory.nullNode()); // Adding a node to make size() return 1

        int index = 1; // Out of bounds index
        JsonNode value = factory.nullNode(); // Value to set

        // Act & Assert
        try {
            arrayNode.set(index, value);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Illegal index 1, array size 1", e.getMessage());
        }
    }

}