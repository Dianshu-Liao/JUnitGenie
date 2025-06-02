package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_insert_int_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsertWithNonNullValue() {
        // Arrange
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        int index = 0;
        String value = "testValue";

        // Act
        arrayNode.insert(index, new TextNode(value));

        // Assert
        assertNotNull(arrayNode.get(index));
        assertNotNull(arrayNode.get(index).textValue());
    }


}