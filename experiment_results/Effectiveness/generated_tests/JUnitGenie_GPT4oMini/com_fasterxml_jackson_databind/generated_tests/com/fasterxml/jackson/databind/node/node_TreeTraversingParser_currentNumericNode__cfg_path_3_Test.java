package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.core.JsonParseException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class node_TreeTraversingParser_currentNumericNode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCurrentNumericNodeThrowsExceptionWhenNodeIsNull() {
        try {
            // Create a TreeTraversingParser instance with a null JsonNode
            TreeTraversingParser parser = new TreeTraversingParser(null);
            // Access the protected method using reflection
            Method method = TreeTraversingParser.class.getDeclaredMethod("currentNumericNode");
            method.setAccessible(true);
            // Invoke the method, expecting an exception
            method.invoke(parser);
            fail("Expected JsonParseException to be thrown"); // Updated exception type
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof JsonParseException); // Updated exception type
            assertEquals("Current token (null) not numeric, cannot use numeric value accessors", e.getCause().getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCurrentNumericNodeThrowsExceptionWhenNodeIsNotNumber() {
        try {
            // Create a JsonNode that is not a number (e.g., a string)
            JsonNode nonNumericNode = new com.fasterxml.jackson.databind.node.TextNode("not a number");
            TreeTraversingParser parser = new TreeTraversingParser(nonNumericNode);
            // Access the protected method using reflection
            Method method = TreeTraversingParser.class.getDeclaredMethod("currentNumericNode");
            method.setAccessible(true);
            // Invoke the method, expecting an exception
            method.invoke(parser);
            fail("Expected JsonParseException to be thrown"); // Updated exception type
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof JsonParseException); // Updated exception type
            assertTrue(e.getCause().getMessage().contains("not numeric"));
        }
    }

    @Test(timeout = 4000)
    public void testCurrentNumericNodeReturnsNodeWhenNodeIsNumber() {
        try {
            // Create a JsonNode that is a number
            JsonNode numericNode = new com.fasterxml.jackson.databind.node.IntNode(42);
            TreeTraversingParser parser = new TreeTraversingParser(numericNode);
            // Access the protected method using reflection
            Method method = TreeTraversingParser.class.getDeclaredMethod("currentNumericNode");
            method.setAccessible(true);
            // Invoke the method and assert the returned node
            JsonNode result = (JsonNode) method.invoke(parser);
            assertEquals(numericNode, result);
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
    }


}