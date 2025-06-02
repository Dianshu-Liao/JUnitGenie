package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_ArrayNode_add_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddWithNonNullValue() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        String value = "testValue";
        
        // Execute the focal method
        arrayNode.add(value); // Correct the method call, return type is void
        
        // Verify the result
        assertEquals(value, arrayNode.get(0).textValue()); // Get the TextNode from arrayNode
    }

    @Test(timeout = 4000)
    public void testAddWithNullValue() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        String value = null;

        // Execute the focal method
        arrayNode.add(value); // Correct the method call, return type is void

        // Verify the result
        assertEquals(NullNode.instance, arrayNode.get(0)); // Check if first element is NullNode
    }


}