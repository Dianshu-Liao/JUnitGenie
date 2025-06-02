package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ArrayNode_set_int_JsonNode_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSetWithValidIndexAndNonNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        JsonNode value = factory.objectNode().put("key", "value");

        arrayNode.add(value); // Add an initial value
        JsonNode result = arrayNode.set(0, value); // Set the value at index 0

        assertEquals(value, result);
        assertEquals(1, arrayNode.size());
    }

    @Test(timeout = 4000)
    public void testSetWithNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(factory.objectNode().put("key", "value")); // Add an initial value

        // Explicitly call set(int, JsonNode) to avoid ambiguity
        JsonNode result = arrayNode.set(0, factory.nullNode()); // Set the value at index 0 to null

        assertNotNull(result);
        assertEquals(1, arrayNode.size());
        assertTrue(arrayNode.get(0).isNull());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);

        arrayNode.set(-1, factory.nullNode()); // Attempt to set a value at a negative index
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithIndexGreaterThanSize() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);

        arrayNode.set(1, factory.nullNode()); // Attempt to set a value at an index greater than size
    }


}