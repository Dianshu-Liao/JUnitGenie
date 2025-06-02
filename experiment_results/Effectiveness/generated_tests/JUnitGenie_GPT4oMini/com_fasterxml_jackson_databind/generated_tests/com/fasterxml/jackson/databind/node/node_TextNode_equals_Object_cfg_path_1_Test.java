package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class node_TextNode_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        TextNode node = new TextNode("value");
        assertTrue(node.equals(node)); // Testing the case where `o` is `this`
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TextNode node = new TextNode("value");
        assertTrue(!node.equals(null)); // Testing the case where `o` is `null`
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TextNode node = new TextNode("value");
        Object other = new Object();
        assertTrue(!node.equals(other)); // Testing the case where `o` is neither `null` nor instance of TextNode
    }

    @Test(timeout = 4000)
    public void testEquals_EqualValue() {
        TextNode node1 = new TextNode("value");
        TextNode node2 = new TextNode("value");
        assertTrue(node1.equals(node2)); // Testing equals for TextNodes with the same value
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValue() {
        TextNode node1 = new TextNode("value1");
        TextNode node2 = new TextNode("value2");
        assertTrue(!node1.equals(node2)); // Testing equals for TextNodes with different values
    }

}