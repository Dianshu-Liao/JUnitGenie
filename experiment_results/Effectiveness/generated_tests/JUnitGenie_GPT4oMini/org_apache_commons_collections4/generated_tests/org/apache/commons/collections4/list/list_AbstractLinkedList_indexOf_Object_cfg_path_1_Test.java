package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class list_AbstractLinkedList_indexOf_Object_cfg_path_1_Test extends AbstractLinkedList<Object> {

    private Node header; // Declare header node

    public list_AbstractLinkedList_indexOf_Object_cfg_path_1_Test() {
        super(); // Call the protected constructor using reflection if needed
        header = new Node(null); // Initialize header node
        header.next = header; // Point header to itself to form an empty circular linked list
    }

    @Override
    protected boolean isEqualValue(Object value1, Object value2) {
        return value1.equals(value2);
    }

    @Test(timeout = 4000)
    public void testIndexOfFound() {
        // Setup
        Object valueToFind = "testValue";
        Node node = new Node(valueToFind); // Create a valid Node instance
        header.next = node; // Link the node to the list
        node.next = header; // Point back to header to form a circular linked list

        // Execute
        int index = indexOf(valueToFind);

        // Verify
        assertEquals(0, index); // The value should be found at index 0
    }

    @Test(timeout = 4000)
    public void testIndexOfNotFound() {
        // Setup
        Object valueToFind = "nonExistentValue";

        // Execute
        int index = indexOf(valueToFind);

        // Verify
        assertEquals(-1, index); // The value should not be found, using -1 as the not found indicator
    }

    @Test(timeout = 4000)
    public void testIndexOfMultipleNodes() {
        // Setup
        Object valueToFind = "secondValue";
        Node firstNode = new Node("firstValue");
        Node secondNode = new Node(valueToFind);
        header.next = firstNode; // Link the first node
        firstNode.next = secondNode; // Link the second node
        secondNode.next = header; // Point back to header to form a circular linked list

        // Execute
        int index = indexOf(valueToFind);

        // Verify
        assertEquals(1, index); // The value should be found at index 1
    }

    // Node class for testing purposes
    private class Node extends AbstractLinkedList.Node {
        private Object value;

        public Node(Object value) {
            super();
            this.value = value;
        }

        @Override
        public Object getValue() {
            return value;
        }
    }

}