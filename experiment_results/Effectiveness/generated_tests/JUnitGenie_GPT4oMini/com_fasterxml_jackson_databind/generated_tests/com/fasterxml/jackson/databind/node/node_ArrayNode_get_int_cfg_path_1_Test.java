package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class node_ArrayNode_get_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetWithValidIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(factory.numberNode(1));
        arrayNode.add(factory.numberNode(2));
        arrayNode.add(factory.numberNode(3));

        JsonNode result = arrayNode.get(1);
        assertNotNull(result);
        assertEquals(2, result.asInt());
    }

    @Test(timeout = 4000)
    public void testGetWithNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(factory.numberNode(1));
        arrayNode.add(factory.numberNode(2));
        arrayNode.add(factory.numberNode(3));

        JsonNode result = arrayNode.get(-1);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithIndexOutOfBounds() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        arrayNode.add(factory.numberNode(1));
        arrayNode.add(factory.numberNode(2));
        arrayNode.add(factory.numberNode(3));

        JsonNode result = arrayNode.get(5);
        assertNull(result);
    }


}