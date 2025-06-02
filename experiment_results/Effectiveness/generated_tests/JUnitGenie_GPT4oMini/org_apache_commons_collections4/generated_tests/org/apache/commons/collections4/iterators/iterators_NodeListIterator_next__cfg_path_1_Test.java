package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.NodeListIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class iterators_NodeListIterator_next__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementException() {
        // Arrange
        NodeList nodeList = new MockNodeList(); // Use a mock NodeList to simulate an empty list
        NodeListIterator iterator = new NodeListIterator(nodeList);

        // Act & Assert
        try {
            iterator.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("underlying nodeList has no more elements", e.getMessage());
        }
    }

    // Mock implementation of NodeList for testing purposes
    private static class MockNodeList implements NodeList {
        @Override
        public Node item(int index) {
            return null; // No items in the mock NodeList
        }

        @Override
        public int getLength() {
            return 0; // Length is zero to simulate an empty NodeList
        }
    }

}