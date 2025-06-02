package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.IOException;

public class node_TreeTraversingParser_getIntValue__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetIntValue() {
        // Setup
        JsonNode mockNode = new IntNode(42); // Use IntNode to create an integer node
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        
        // Ensure the parser is in a valid state
        try {
            // Act
            int result = parser.getIntValue();
            
            // Assert
            assertEquals(42, result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetIntValueThrowsIOException() {
        // Setup
        JsonNode mockNode = new IntNode(Integer.MAX_VALUE); // Use IntNode for maximum integer value
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);
        
        // Ensure the parser is in a valid state
        try {
            // Act
            parser.getIntValue();
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            // Assert that the exception is thrown as expected
        }
    }


}