package org.apache.commons.collections4.iterators;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

class NodeListIterator_next_1_0_Test {

    private NodeList nodeList;

    private NodeListIterator nodeListIterator;

    @BeforeEach
    void setUp() {
        nodeList = mock(NodeList.class);
    }

    @Test
    void testNext_ReturnsNextNode_WhenMoreElementsExist() {
        Node node1 = mock(Node.class);
        Node node2 = mock(Node.class);
        when(nodeList.getLength()).thenReturn(2);
        when(nodeList.item(0)).thenReturn(node1);
        when(nodeList.item(1)).thenReturn(node2);
        nodeListIterator = new NodeListIterator(nodeList);
        assertEquals(node1, nodeListIterator.next());
        assertEquals(node2, nodeListIterator.next());
    }

    @Test
    void testNext_ThrowsNoSuchElementException_WhenNoMoreElements() {
        when(nodeList.getLength()).thenReturn(1);
        when(nodeList.item(0)).thenReturn(mock(Node.class));
        nodeListIterator = new NodeListIterator(nodeList);
        // consume the first element
        nodeListIterator.next();
        assertThrows(NoSuchElementException.class, () -> nodeListIterator.next());
    }

    @Test
    void testNext_ThrowsNoSuchElementException_WhenNodeListIsEmpty() {
        when(nodeList.getLength()).thenReturn(0);
        nodeListIterator = new NodeListIterator(nodeList);
        assertThrows(NoSuchElementException.class, () -> nodeListIterator.next());
    }

    @Test
    void testNext_ThrowsNoSuchElementException_WhenNodeListIsNull() {
        nodeListIterator = new NodeListIterator((NodeList) null);
        assertThrows(NoSuchElementException.class, () -> nodeListIterator.next());
    }
}
