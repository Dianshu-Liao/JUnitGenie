package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_ObjectNode_put_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        String value = null;

        // Act
        ObjectNode result = objectNode.put(propertyName, value);

        // Assert
        assertEquals(NullNode.getInstance(), result.get(propertyName));
    }

    @Test(timeout = 4000)
    public void testPutWithNonNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        String value = "testValue";

        // Act
        ObjectNode result = objectNode.put(propertyName, value);

        // Assert
        assertEquals(value, result.get(propertyName).asText());
    }

}