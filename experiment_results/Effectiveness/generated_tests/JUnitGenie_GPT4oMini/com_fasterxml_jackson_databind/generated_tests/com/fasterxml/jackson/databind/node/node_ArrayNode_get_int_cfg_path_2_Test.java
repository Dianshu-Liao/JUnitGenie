package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class node_ArrayNode_get_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetWithNegativeIndex() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        
        // Test for negative index
        JsonNode result = arrayNode.get(-1);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithIndexGreaterThanSize() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ArrayNode arrayNode = new ArrayNode(factory);
        
        // Add some elements to the ArrayNode
        arrayNode.add(factory.numberNode(1));
        arrayNode.add(factory.numberNode(2));
        
        // Test for index greater than size
        JsonNode result = arrayNode.get(3);
        assertNull(result);
    }

}