package com.fasterxml.jackson.databind.node;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;

public class node_TextNode_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        TextNode textNode = new TextNode("value");
        assertTrue(textNode.equals(textNode)); // Testing the case where 'o' is the same instance
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        TextNode textNode = new TextNode("value");
        assertFalse(textNode.equals(null)); // Testing the case where 'o' is null
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TextNode textNode = new TextNode("value");
        assertFalse(textNode.equals("string")); // Testing the case where 'o' is of a different type
    }

    @Test(timeout = 4000)
    public void testEquals_EqualValues() {
        TextNode textNode1 = new TextNode("value");
        TextNode textNode2 = new TextNode("value");
        assertTrue(textNode1.equals(textNode2)); // Testing the case where 'o' is an instance of TextNode with equal values
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValues() {
        TextNode textNode1 = new TextNode("value1");
        TextNode textNode2 = new TextNode("value2");
        assertFalse(textNode1.equals(textNode2)); // Testing the case where 'o' is an instance of TextNode with different values
    }

}