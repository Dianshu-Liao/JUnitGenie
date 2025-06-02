package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class node_TreeTraversingParser_currentNumericNode__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCurrentNumericNodeThrowsExceptionWhenCurrentNodeIsNull() {
        // Arrange
        ObjectNode mockNode = null; // Simulating a null current node
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);

        // Act
        try {
            Method method = TreeTraversingParser.class.getDeclaredMethod("currentNumericNode");
            method.setAccessible(true);
            method.invoke(parser);
            fail("Expected an exception to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception for null node
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCurrentNumericNodeThrowsExceptionWhenCurrentNodeIsNotNumeric() {
        // Arrange
        ObjectNode mockNode = new ObjectNode(null); // Simulating a non-numeric current node
        TreeTraversingParser parser = new TreeTraversingParser(mockNode);

        // Act
        try {
            Method method = TreeTraversingParser.class.getDeclaredMethod("currentNumericNode");
            method.setAccessible(true);
            method.invoke(parser);
            fail("Expected an exception to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception for non-numeric node
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }


}