package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_TextNode_asBoolean_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAsBooleanWithNullValue() {
        TextNode textNode = new TextNode(null);
        boolean result = textNode.asBoolean(true);
        assertEquals(true, result); // should return defaultValue
    }

    @Test(timeout = 4000)
    public void testAsBooleanWithTrueValue() {
        TextNode textNode = new TextNode(" true ");
        boolean result = textNode.asBoolean(false);
        assertEquals(true, result); // should return true
    }

    @Test(timeout = 4000)
    public void testAsBooleanWithFalseValue() {
        TextNode textNode = new TextNode(" false ");
        boolean result = textNode.asBoolean(true);
        assertEquals(false, result); // should return false
    }

    @Test(timeout = 4000)
    public void testAsBooleanWithEmptyValue() {
        TextNode textNode = new TextNode("");
        boolean result = textNode.asBoolean(true);
        assertEquals(true, result); // should return defaultValue
    }

}