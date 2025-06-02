package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class node_ArrayNode_addRawValue_RawValue_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddRawValueWithNull() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        RawValue rawValue = null;

        try {
            ArrayNode result = arrayNode.addRawValue(rawValue);
            assertNotNull(result); // Expecting a non-null result even when rawValue is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddRawValueWithValidRawValue() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        RawValue rawValue = new RawValue("test");

        try {
            ArrayNode result = arrayNode.addRawValue(rawValue);
            assertNotNull(result); // Expecting a non-null result when a valid RawValue is added
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}