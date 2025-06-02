package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class node_TextNode_valueOf_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValueOf_NonEmptyString() {
        String input = "Hello, World!";
        TextNode result = null;
        try {
            result = TextNode.valueOf(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testValueOf_EmptyString() {
        String input = "";
        TextNode result = null;
        try {
            result = TextNode.valueOf(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertNotNull(result);
        // Assuming EMPTY_STRING_NODE is a static field in TextNode class
        assertEquals(TextNode.EMPTY_STRING_NODE, result);
    }

    @Test(timeout = 4000)
    public void testValueOf_Null() {
        String input = null;
        TextNode result = null;
        try {
            result = TextNode.valueOf(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertNull(result);
    }


}