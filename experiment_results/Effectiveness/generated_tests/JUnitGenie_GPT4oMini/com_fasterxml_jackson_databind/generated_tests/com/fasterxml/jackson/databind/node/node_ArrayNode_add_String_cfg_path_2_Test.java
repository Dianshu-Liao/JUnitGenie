package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_add_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddNonNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        String valueToAdd = "testValue";

        // Act
        TextNode resultNode = new TextNode(valueToAdd);
        arrayNode.add(resultNode);

        // Assert
        assertNotNull(resultNode);
    }

    @Test(timeout = 4000)
    public void testAddNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        String valueToAdd = null;

        // Act
        TextNode resultNode = new TextNode(valueToAdd);
        arrayNode.add(resultNode);

        // Assert
        assertNotNull(resultNode); // Ensure that the method does not throw an exception
    }

}