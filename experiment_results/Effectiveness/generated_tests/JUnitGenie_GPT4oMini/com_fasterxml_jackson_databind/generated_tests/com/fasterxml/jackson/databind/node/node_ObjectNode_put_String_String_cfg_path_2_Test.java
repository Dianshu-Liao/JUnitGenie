package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ObjectNode_put_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutWithNonNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        String value = "testValue";

        // Act
        objectNode.put(propertyName, value); // No need to cast to TextNode

        // Assert
        assertNotNull(objectNode.get(propertyName));
        assertNotNull(objectNode.get(propertyName).asText()); // Ensure it's not null and is a TextNode
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";

        // Act
        objectNode.put(propertyName, (String) null); // Specify null as a String

        // Assert
        assertNotNull(objectNode.get(propertyName)); // Should be nullNode
    }


}