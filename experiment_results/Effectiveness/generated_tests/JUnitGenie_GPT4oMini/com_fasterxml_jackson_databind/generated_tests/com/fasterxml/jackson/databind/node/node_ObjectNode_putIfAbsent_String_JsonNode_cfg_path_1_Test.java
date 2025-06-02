package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class node_ObjectNode_putIfAbsent_String_JsonNode_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutIfAbsent_WithNullValue() {
        // Arrange
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";

        // Act
        JsonNode result = objectNode.putIfAbsent(propertyName, null);

        // Assert
        assertNotNull(result); // should return a non-null JsonNode
        assertNull(objectNode.get(propertyName)); // value should not be stored
    }

    @Test(timeout = 4000)
    public void testPutIfAbsent_WithValidValue() {
        // Arrange
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        JsonNode value = factory.textNode("testValue");

        // Act
        JsonNode result = objectNode.putIfAbsent(propertyName, value);

        // Assert
        assertNotNull(result); // should return the previous value or null
        assertNotNull(objectNode.get(propertyName)); // value should be stored
    }

}