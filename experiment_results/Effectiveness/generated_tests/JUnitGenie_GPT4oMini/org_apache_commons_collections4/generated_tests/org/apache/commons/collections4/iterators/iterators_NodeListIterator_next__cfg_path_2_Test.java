package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.NodeListIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class iterators_NodeListIterator_next__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementException() {
        // Arrange
        NodeList nodeList = new MockNodeList(new Node[0]); // Mocking an empty NodeList
        NodeListIterator iterator = new NodeListIterator(nodeList);

        // Act & Assert
        try {
            iterator.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("underlying nodeList has no more elements", e.getMessage());
        }
    }

    // Mock class to simulate NodeList behavior
    private static class MockNodeList implements NodeList {
        private final Node[] nodes;

        public MockNodeList(Node[] nodes) {
            this.nodes = nodes;
        }

        @Override
        public Node item(int index) {
            return (index >= 0 && index < nodes.length) ? nodes[index] : null;
        }

        @Override
        public int getLength() {
            return nodes.length;
        }
    }

}