package org.apache.commons.collections4.iterators;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Objects;

class NodeListIterator_next_1_0_Test {

    private NodeList nodeList;

    private NodeListIterator nodeListIterator;

    private Node node1;

    private Node node2;

    @BeforeEach
    void setUp() {
        node1 = mock(Node.class);
        node2 = mock(Node.class);
        nodeList = mock(NodeList.class);
        when(nodeList.getLength()).thenReturn(2);
        when(nodeList.item(0)).thenReturn(node1);
        when(nodeList.item(1)).thenReturn(node2);
        nodeListIterator = new NodeListIterator(nodeList);
    }

    @Test
    void testNext_ValidCall() {
        assertEquals(node1, nodeListIterator.next());
        assertEquals(node2, nodeListIterator.next());
    }

    @Test
    void testNext_NoMoreElements() {
        // consume first element
        nodeListIterator.next();
        // consume second element
        nodeListIterator.next();
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            // should throw exception
            nodeListIterator.next();
        });
        assertEquals("underlying nodeList has no more elements", exception.getMessage());
    }

    @Test
    void testNext_EmptyNodeList() {
        NodeList emptyNodeList = mock(NodeList.class);
        when(emptyNodeList.getLength()).thenReturn(0);
        NodeListIterator emptyIterator = new NodeListIterator(emptyNodeList);
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            // should throw exception
            emptyIterator.next();
        });
        assertEquals("underlying nodeList has no more elements", exception.getMessage());
    }

    @Test
    void testNext_NullNodeList() {
        NodeListIterator nullIterator = new NodeListIterator((NodeList) null);
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            // should throw exception
            nullIterator.next();
        });
        assertEquals("underlying nodeList has no more elements", exception.getMessage());
    }
}
