package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class node_TextNode_valueOf_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testValueOf_NullInput() {
        try {
            TextNode result = TextNode.valueOf(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}