package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_ObjectNode_withArray_String_cfg_path_3_Test {
    private ObjectNode objectNode;

    @Before
    public void setUp() {
        objectNode = new ObjectNode(JsonNodeFactory.instance);
    }

    @Test(timeout = 4000)
    public void testWithArray_CreatesNewArrayNode() {
        String propertyName = "testArray";
        ArrayNode result = objectNode.withArray(propertyName);
        
        assertNotNull(result);
        assertTrue(result instanceof ArrayNode);
        assertEquals(result, objectNode.get(propertyName));
    }

    @Test(timeout = 4000)
    public void testWithArray_ReturnsExistingArrayNode() {
        String propertyName = "existingArray";
        ArrayNode existingArray = objectNode.arrayNode();
        objectNode.set(propertyName, existingArray);
        
        ArrayNode result = objectNode.withArray(propertyName);
        
        assertSame(existingArray, result);
    }

    @Test(timeout = 4000)
    public void testWithArray_ThrowsExceptionForNonArrayNode() {
        String propertyName = "nonArrayNode";
        objectNode.put(propertyName, "notAnArray");
        
        try {
            objectNode.withArray(propertyName);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Property 'nonArrayNode' has value that is not of type `ArrayNode` (but `java.lang.String`)", e.getMessage());
        }
    }

}