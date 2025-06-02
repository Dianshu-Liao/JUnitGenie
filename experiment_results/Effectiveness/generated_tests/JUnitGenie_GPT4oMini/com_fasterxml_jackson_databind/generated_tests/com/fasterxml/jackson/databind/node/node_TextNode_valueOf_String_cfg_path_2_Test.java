package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_TextNode_valueOf_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValueOf_EmptyString() {
        try {
            TextNode result = TextNode.valueOf("");
            assertEquals(TextNode.EMPTY_STRING_NODE, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_NonEmptyString() {
        try {
            String input = "Hello, World!";
            TextNode result = TextNode.valueOf(input);
            TextNode expected = new TextNode(input);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_Null() {
        try {
            TextNode result = TextNode.valueOf(null);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}