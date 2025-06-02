package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class node_ArrayNode_get_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetWithNegativeIndex() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        
        // Act
        JsonNode result = arrayNode.get(-1);
        
        // Assert
        assertNull(result);
    }


}