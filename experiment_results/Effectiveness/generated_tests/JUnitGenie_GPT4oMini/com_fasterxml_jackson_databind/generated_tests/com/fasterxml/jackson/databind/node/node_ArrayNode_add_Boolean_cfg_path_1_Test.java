package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_add_Boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddBooleanNotNull() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        Boolean input = true; // Test with a non-null Boolean value

        try {
            ArrayNode result = arrayNode.add(input);
            assertNotNull(result); // Ensure the result is not null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddBooleanNull() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        Boolean input = null; // Test with a null Boolean value

        try {
            ArrayNode result = arrayNode.add(input);
            assertNotNull(result); // Ensure the result is not null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}