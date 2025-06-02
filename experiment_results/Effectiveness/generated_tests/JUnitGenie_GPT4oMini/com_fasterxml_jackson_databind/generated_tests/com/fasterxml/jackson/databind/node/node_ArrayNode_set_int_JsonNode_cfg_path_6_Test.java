package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ArrayNode_set_int_JsonNode_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSetWithNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        JsonNode value = null; // This will trigger the nullNode() call

        // Set a value at index 0
        JsonNode result = arrayNode.set(0, value);
        assertEquals(NullNode.getInstance(), result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        JsonNode value = new NullNode(); // Using a valid JsonNode

        // This should throw an IndexOutOfBoundsException
        arrayNode.set(-1, value);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithIndexGreaterThanSize() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        JsonNode value = new NullNode(); // Using a valid JsonNode

        // This should throw an IndexOutOfBoundsException
        arrayNode.set(1, value);
    }

    @Test(timeout = 4000)
    public void testSetWithValidIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        JsonNode value = new NullNode(); // Using a valid JsonNode

        // Add an initial value to the array
        arrayNode.add(value);

        // Set a new value at index 0
        JsonNode newValue = new NullNode(); // Using a valid JsonNode
        JsonNode result = arrayNode.set(0, newValue);
        assertEquals(newValue, result);
        assertEquals(newValue, arrayNode.get(0));
    }

}