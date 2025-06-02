package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_ObjectNode_path_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPathReturnsMissingNodeWhenPropertyNotFound() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        
        // Act
        JsonNode result = objectNode.path("nonExistentProperty");
        
        // Assert
        assertEquals(MissingNode.getInstance(), result);
    }

    @Test(timeout = 4000)
    public void testPathReturnsChildNodeWhenPropertyFound() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        JsonNode childNode = factory.objectNode().put("key", "value");
        objectNode.put("existingProperty", childNode);
        
        // Act
        JsonNode result = objectNode.path("existingProperty");
        
        // Assert
        assertEquals(childNode, result);
    }

}