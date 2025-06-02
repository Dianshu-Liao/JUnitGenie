package com.fasterxml.jackson.databind.node;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;

public class node_TextNode_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        TextNode textNode = new TextNode("value");
        assertTrue(textNode.equals(textNode));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        TextNode textNode = new TextNode("value");
        assertFalse(textNode.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TextNode textNode = new TextNode("value");
        assertFalse(textNode.equals("string"));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValue() {
        TextNode textNode1 = new TextNode("value");
        TextNode textNode2 = new TextNode("value");
        assertTrue(textNode1.equals(textNode2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValue() {
        TextNode textNode1 = new TextNode("value1");
        TextNode textNode2 = new TextNode("value2");
        assertFalse(textNode1.equals(textNode2));
    }

}