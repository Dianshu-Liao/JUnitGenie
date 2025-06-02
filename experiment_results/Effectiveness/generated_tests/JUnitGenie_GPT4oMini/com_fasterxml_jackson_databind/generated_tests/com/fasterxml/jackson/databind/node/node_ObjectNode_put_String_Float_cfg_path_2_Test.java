package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ObjectNode_put_String_Float_cfg_path_2_Test {

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
    }

}