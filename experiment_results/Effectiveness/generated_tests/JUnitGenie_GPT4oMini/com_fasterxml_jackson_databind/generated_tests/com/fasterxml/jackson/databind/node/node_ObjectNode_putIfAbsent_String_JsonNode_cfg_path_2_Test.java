package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_ObjectNode_putIfAbsent_String_JsonNode_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutIfAbsentWithNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";

        // Act
        JsonNode result = objectNode.putIfAbsent(propertyName, null);

        // Assert
        assertEquals(NullNode.getInstance(), result);
    }

    @Test(timeout = 4000)
    public void testPutIfAbsentWithNonNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        JsonNode value = factory.objectNode().put("key", "value");

        // Act
        JsonNode result = objectNode.putIfAbsent(propertyName, value);

        // Assert
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPutIfAbsentWithExistingProperty() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        JsonNode value1 = factory.objectNode().put("key1", "value1");
        JsonNode value2 = factory.objectNode().put("key2", "value2");
        objectNode.putIfAbsent(propertyName, value1);

        // Act
        JsonNode result = objectNode.putIfAbsent(propertyName, value2);

        // Assert
        assertEquals(value1, result);
    }

}