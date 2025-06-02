package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_insert_int_Boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithBooleanValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        int index = 0;
        Boolean value = true;

        // Act
        ArrayNode result = null;
        try {
            result = arrayNode.insert(index, value);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        int index = 0;
        Boolean value = null;

        // Act
        ArrayNode result = null;
        try {
            result = arrayNode.insert(index, value);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

}