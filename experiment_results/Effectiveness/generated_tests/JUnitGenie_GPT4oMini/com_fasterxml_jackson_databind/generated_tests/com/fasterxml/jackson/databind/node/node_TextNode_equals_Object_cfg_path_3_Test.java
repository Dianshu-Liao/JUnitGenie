package com.fasterxml.jackson.databind.node;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.node.TextNode;

public class node_TextNode_equals_Object_cfg_path_3_Test {

    @org.junit.Test
    public void testEquals_NullObject() {
        TextNode textNode = new TextNode("test");
        Object nullObject = null;

        boolean result = textNode.equals(nullObject);

        assertFalse(result);
    }

    @org.junit.Test
    public void testEquals_SameInstance() {
        TextNode textNode = new TextNode("test");

        boolean result = textNode.equals(textNode);

        assertTrue(result);
    }

    @org.junit.Test
    public void testEquals_DifferentObjectType() {
        TextNode textNode = new TextNode("test");
        Object differentTypeObject = new Object();

        boolean result = textNode.equals(differentTypeObject);

        assertFalse(result);
    }
    
    @org.junit.Test
    public void testEquals_EqualTextNode() {
        TextNode textNode1 = new TextNode("test");
        TextNode textNode2 = new TextNode("test");

        boolean result = textNode1.equals(textNode2);

        assertTrue(result);
    }
    
    @org.junit.Test
    public void testEquals_NotequalTextNode() {
        TextNode textNode1 = new TextNode("test1");
        TextNode textNode2 = new TextNode("test2");

        boolean result = textNode1.equals(textNode2);

        assertFalse(result);
    }

}