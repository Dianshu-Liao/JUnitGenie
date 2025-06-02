package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class node_ObjectNode_path_String_cfg_path_1_Test {

    private ObjectNode objectNode;

    @Before
    public void setUp() {
        JsonNodeFactory factory = new JsonNodeFactory(false);
        Map<String, JsonNode> children = new HashMap<>();
        objectNode = new ObjectNode(factory, children);
    }

    @Test(timeout = 4000)
    public void testPathWhenPropertyExists() {
        // Setting up the test scenario with a property name that exists
        JsonNode childNode = new ObjectNode(JsonNodeFactory.instance);
        objectNode._children.put("existingProperty", childNode);

        JsonNode result = objectNode.path("existingProperty");
        assertEquals(childNode, result);
    }

    @Test(timeout = 4000)
    public void testPathWhenPropertyDoesNotExist() {
        // Testing behavior for a property name that does not exist
        JsonNode result = objectNode.path("nonExistingProperty");
        assertEquals(MissingNode.getInstance(), result);
    }

    @Test(timeout = 4000)
    public void testPathReturnsMissingNode() {
        // Testing the return of MissingNode when no properties are present
        objectNode._children.clear(); // Ensure no children are present
        JsonNode result = objectNode.path("anotherNonExistingProperty");
        assertEquals(MissingNode.getInstance(), result);
    }

}