package com.fasterxml.jackson.databind.node;
import static org.junit.Assert.*;
import org.junit.Test;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class node_ArrayNode_insert_int_JsonNode_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullValue() {
        // Create an ArrayNode instance
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        
        // Try inserting null value at index 0
        try {
            arrayNode.insert(0, NullNode.getInstance()); // Use NullNode.getInstance() instead of null
            assertEquals(1, arrayNode.size());
            assertTrue(arrayNode.get(0) instanceof NullNode);
        } catch (Exception e) {
            fail("Insert operation threw an exception: " + e.getMessage());
        }
    }
    

}
