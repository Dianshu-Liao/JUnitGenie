package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class node_TreeTraversingParser_getLongValue__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetLongValue() {
        // Create a mock JsonNode that can be converted to long
        JsonNode mockNode = new IntNode(12345); // Use IntNode for integer values
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);

        try {
            long result = parser.getLongValue();
            assertEquals(12345L, result);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetLongValueThrowsException() {
        // Create a mock JsonNode that cannot be converted to long
        JsonNode mockNode = new DoubleNode(Double.POSITIVE_INFINITY); // Use DoubleNode for double values
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);

        try {
            parser.getLongValue();
        } catch (IOException e) {
            // Expected exception due to overflow
            assertEquals("Overflow when converting to long", e.getMessage());
        }
    }


}