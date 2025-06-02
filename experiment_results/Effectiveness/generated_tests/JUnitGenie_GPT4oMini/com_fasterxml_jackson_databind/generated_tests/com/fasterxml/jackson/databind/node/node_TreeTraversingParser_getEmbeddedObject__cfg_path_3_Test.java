package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.node.BinaryNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class node_TreeTraversingParser_getEmbeddedObject__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWithPojoNode() {
        // Setup
        JsonNode mockNode = new POJONode(new Object()); // Create a mock POJO node
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        parser._closed = false; // Set _closed to false to satisfy the condition

        // Execute
        Object result = null;
        try {
            result = parser.getEmbeddedObject();
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Verify
        assertNotNull(result); // Expecting a non-null result since we have a POJO node
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWithNullNode() {
        // Setup
        TreeTraversingParser parser = new TreeTraversingParser(null);
        parser._closed = false; // Set _closed to false to satisfy the condition

        // Execute
        Object result = null;
        try {
            result = parser.getEmbeddedObject();
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Verify
        assertNull(result); // Expecting a null result since the node is null
    }

    @Test(timeout = 4000)
    public void testGetEmbeddedObjectWithBinaryNode() {
        // Setup
        JsonNode mockNode = new BinaryNode(new byte[]{1, 2, 3}); // Create a mock Binary node
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        parser._closed = false; // Set _closed to false to satisfy the condition

        // Execute
        Object result = null;
        try {
            result = parser.getEmbeddedObject();
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Verify
        assertNotNull(result); // Expecting a non-null result since we have a Binary node
    }

}