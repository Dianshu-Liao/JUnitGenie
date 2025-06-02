package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ArrayNode_insert_int_Long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidLong() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        Long valueToInsert = 10L;
        int index = 0;

        ArrayNode result = arrayNode.insert(index, valueToInsert);
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof NumericNode);
        assertEquals(10L, result.get(0).asLong());
    }

    @Test(timeout = 4000)
    public void testInsertWithNullLong() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        Long valueToInsert = null;
        int index = 0;

        ArrayNode result = arrayNode.insert(index, valueToInsert);
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof NullNode);
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        Long valueToInsert = 10L;
        int index = -1;

        try {
            arrayNode.insert(index, valueToInsert);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Test passes
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexGreaterThanSize() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        Long valueToInsert = 10L;
        int index = 1; // index greater than current size (0)

        try {
            arrayNode.insert(index, valueToInsert);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Test passes
        }
    }

}