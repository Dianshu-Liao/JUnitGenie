package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class node_POJONode_asText__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAsTextWithNullValue() {
        POJONode node = new POJONode(null);
        String result = null;
        try {
            result = node.asText();
            assertEquals("null", result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testAsTextWithNonNullValue() {
        Object mockValue = new Object() {
            @Override
            public String toString() {
                return "mockValue";
            }
        };
        POJONode node = new POJONode(mockValue);
        String result = null;
        try {
            result = node.asText();
            assertEquals("mockValue", result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        }
    }

}