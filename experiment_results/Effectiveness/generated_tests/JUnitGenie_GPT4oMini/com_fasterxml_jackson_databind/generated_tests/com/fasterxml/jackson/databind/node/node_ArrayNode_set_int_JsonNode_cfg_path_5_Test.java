package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ArrayNode_set_int_JsonNode_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSet_withValidIndexAndNonNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        JsonNode value = factory.objectNode();
        arrayNode.add(value); // Add an initial value to ensure there's an element at index 0

        JsonNode result = arrayNode.set(0, value);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testSet_withValidIndexAndNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(factory.objectNode()); // Add an initial value

        JsonNode result = arrayNode.set(0, NullNode.getInstance()); // Use NullNode instead of null
        assertNotNull(result);
        assertTrue(result.isNull()); // Verify that it has been set to a NullNode
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_withInvalidIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        // No values added, size is 0

        arrayNode.set(1, factory.objectNode()); // This should throw an exception
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_withNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(factory.objectNode()); // Add an initial value

        arrayNode.set(-1, factory.objectNode()); // This should throw an exception
    }


}