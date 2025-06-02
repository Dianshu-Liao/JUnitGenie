package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_addRawValue_RawValue_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddRawValue_withValidRawValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(true);
        ArrayNode arrayNode = new ArrayNode(factory);
        RawValue rawValue = new RawValue("test");

        // Act
        ArrayNode result = null;
        try {
            result = arrayNode.addRawValue(rawValue);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAddRawValue_withNullRawValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(true);
        ArrayNode arrayNode = new ArrayNode(factory);

        // Act
        ArrayNode result = null;
        try {
            result = arrayNode.addRawValue(null);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

}