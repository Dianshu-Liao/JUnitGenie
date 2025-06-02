package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class node_DoubleNode_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        DoubleNode node = new DoubleNode(5.0);
        assertTrue(node.equals(node));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        DoubleNode node = new DoubleNode(5.0);
        assertFalse(node.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DoubleNode node = new DoubleNode(5.0);
        assertFalse(node.equals("Not a DoubleNode"));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualValues() {
        DoubleNode node1 = new DoubleNode(5.0);
        DoubleNode node2 = new DoubleNode(5.0);
        assertTrue(node1.equals(node2));
    }

    @Test(timeout = 4000)
    public void testEquals_NaNValues() {
        DoubleNode node1 = new DoubleNode(Double.NaN);
        DoubleNode node2 = new DoubleNode(Double.NaN);
        assertFalse(node1.equals(node2)); // NaN should not be equal to NaN
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValues() {
        DoubleNode node1 = new DoubleNode(5.0);
        DoubleNode node2 = new DoubleNode(10.0);
        assertFalse(node1.equals(node2));
    }

}