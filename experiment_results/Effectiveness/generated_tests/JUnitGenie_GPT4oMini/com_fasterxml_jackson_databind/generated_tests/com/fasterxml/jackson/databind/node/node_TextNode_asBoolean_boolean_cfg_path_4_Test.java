package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_TextNode_asBoolean_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAsBooleanWithNullValue() {
        // Arrange
        TextNode textNode = new TextNode(null);
        boolean defaultValue = true;

        // Act
        boolean result = textNode.asBoolean(defaultValue);

        // Assert
        assertEquals(defaultValue, result);
    }

}