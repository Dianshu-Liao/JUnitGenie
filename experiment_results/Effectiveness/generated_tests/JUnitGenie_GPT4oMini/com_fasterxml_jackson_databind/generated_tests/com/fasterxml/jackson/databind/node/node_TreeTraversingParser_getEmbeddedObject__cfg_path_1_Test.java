package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class node_TreeTraversingParser_getEmbeddedObject__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWithBinaryNode() {
        // Setup
        JsonNode mockNode = new BinaryNode(new byte[]{1, 2, 3}); // Create a BinaryNode
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        // Set the _closed field to false using reflection
        setClosedField(parser, false);

        // Execute
        Object result = parser.getEmbeddedObject();

        // Verify
        assertNotNull(result);
        assertTrue(result instanceof byte[]);
        assertArrayEquals(new byte[]{1, 2, 3}, (byte[]) result);
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWithPojoNode() {
        // Setup
        JsonNode mockNode = new POJONode(new Object()); // Create a POJONode
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        // Set the _closed field to false using reflection
        setClosedField(parser, false);

        // Execute
        Object result = parser.getEmbeddedObject();

        // Verify
        assertNotNull(result);
        assertTrue(result instanceof Object);
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWithNullNode() {
        // Setup
        JsonNode mockNode = null; // Create a null JsonNode
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        // Set the _closed field to false using reflection
        setClosedField(parser, false);

        // Execute
        Object result = parser.getEmbeddedObject();

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWhenClosed() {
        // Setup
        JsonNode mockNode = new BinaryNode(new byte[]{1, 2, 3}); // Create a BinaryNode
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        // Set the _closed field to true using reflection
        setClosedField(parser, true);

        // Execute
        Object result = parser.getEmbeddedObject();

        // Verify
        assertNull(result);
    }

    private void setClosedField(TreeTraversingParser parser, boolean value) {
        try {
            java.lang.reflect.Field field = TreeTraversingParser.class.getDeclaredField("_closed");
            field.setAccessible(true);
            field.set(parser, value);
        } catch (Exception e) {
            fail("Failed to set _closed field: " + e.getMessage());
        }
    }

}