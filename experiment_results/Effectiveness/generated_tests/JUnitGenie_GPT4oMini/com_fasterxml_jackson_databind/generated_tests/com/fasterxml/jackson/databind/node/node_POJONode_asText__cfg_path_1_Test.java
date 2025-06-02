package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_POJONode_asText__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAsTextWithNonNullValue() {
        // Arrange
        Object testValue = "Test String";
        POJONode pojoNode = new POJONode(testValue);

        // Act
        String result = pojoNode.asText();

        // Assert
        assertEquals("Test String", result);
    }

    @Test(timeout = 4000)
    public void testAsTextWithNullValue() {
        // Arrange
        POJONode pojoNode = new POJONode(null);

        // Act
        String result = pojoNode.asText();

        // Assert
        assertEquals("null", result);
    }

}