package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ArrayNode_set_int_JsonNode_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetWithValidIndexAndNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(NullNode.getInstance()); // Initialize with one element

        // Set index 0 to null (should convert to NullNode)
        JsonNode result = arrayNode.set(0, NullNode.getInstance());
        assertNotNull(result);
        assertTrue(result.isNull());
    }

    @Test(timeout = 4000)
    public void testSetWithValidIndexAndNonNullValue() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(NullNode.getInstance()); // Initialize with one element

        // Create a concrete JsonNode implementation
        JsonNode value = factory.objectNode().put("key", "value");

        // Set index 0 to a non-null value
        JsonNode result = arrayNode.set(0, value);
        assertNotNull(result);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testSetWithInvalidIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(NullNode.getInstance()); // Initialize with one element

        try {
            // Attempt to set at an invalid index
            arrayNode.set(1, NullNode.getInstance());
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Illegal index 1, array size 1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetWithNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(NullNode.getInstance()); // Initialize with one element

        try {
            // Attempt to set at a negative index
            arrayNode.set(-1, NullNode.getInstance());
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Illegal index -1, array size 1", e.getMessage());
        }
    }


}