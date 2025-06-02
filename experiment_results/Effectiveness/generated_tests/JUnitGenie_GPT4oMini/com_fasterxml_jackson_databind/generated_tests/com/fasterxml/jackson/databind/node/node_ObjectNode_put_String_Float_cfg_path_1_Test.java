package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class node_ObjectNode_put_String_Float_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutWithValidFloat() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        Float value = 5.0f;

        // Act
        ObjectNode result = null;
        try {
            result = objectNode.put(propertyName, value);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
        assertNotNull(result.get(propertyName));
        assertTrue(result.get(propertyName) instanceof NumericNode);
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = "testProperty";
        Float value = null;

        // Act
        ObjectNode result = null;
        try {
            result = objectNode.put(propertyName, value);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
        assertNotNull(result.get(propertyName));
        assertTrue(result.get(propertyName).isNull());
    }

    @Test(timeout = 4000)
    public void testPutWithEmptyPropertyName() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = ""; // Invalid property name
        Float value = 5.0f;

        // Act
        ObjectNode result = null;
        try {
            result = objectNode.put(propertyName, value);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
        assertNotNull(result.get(propertyName)); // Should still be present but empty
    }

    @Test(timeout = 4000)
    public void testPutWithNullPropertyName() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectNode objectNode = new ObjectNode(factory);
        String propertyName = null; // Invalid property name
        Float value = 5.0f;

        // Act
        ObjectNode result = null;
        try {
            result = objectNode.put(propertyName, value);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
        assertNotNull(result.get(propertyName)); // Should still be present but null
    }


}