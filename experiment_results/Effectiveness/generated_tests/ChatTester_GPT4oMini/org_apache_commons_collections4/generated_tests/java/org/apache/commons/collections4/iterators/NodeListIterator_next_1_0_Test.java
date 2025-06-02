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

    private NodeList nodeListMock;

    private NodeListIterator nodeListIterator;

    private Node nodeMock1;

    private Node nodeMock2;

    @BeforeEach
    void setUp() {
        nodeListMock = mock(NodeList.class);
        nodeMock1 = mock(Node.class);
        nodeMock2 = mock(Node.class);
    }

    @Test
    void testNext_WhenNodeListHasElements_ReturnsNextNode() {
        when(nodeListMock.getLength()).thenReturn(2);
        when(nodeListMock.item(0)).thenReturn(nodeMock1);
        when(nodeListMock.item(1)).thenReturn(nodeMock2);
        nodeListIterator = new NodeListIterator(nodeListMock);
        Node result1 = nodeListIterator.next();
        assertEquals(nodeMock1, result1);
        Node result2 = nodeListIterator.next();
        assertEquals(nodeMock2, result2);
    }

    @Test
    void testNext_WhenNodeListIsEmpty_ThrowsNoSuchElementException() {
        when(nodeListMock.getLength()).thenReturn(0);
        nodeListIterator = new NodeListIterator(nodeListMock);
        assertThrows(NoSuchElementException.class, () -> nodeListIterator.next());
    }

    @Test
    void testNext_WhenAllNodesHaveBeenIterated_ThrowsNoSuchElementException() {
        when(nodeListMock.getLength()).thenReturn(2);
        when(nodeListMock.item(0)).thenReturn(nodeMock1);
        when(nodeListMock.item(1)).thenReturn(nodeMock2);
        nodeListIterator = new NodeListIterator(nodeListMock);
        // First call
        nodeListIterator.next();
        // Second call
        nodeListIterator.next();
        assertThrows(NoSuchElementException.class, () -> nodeListIterator.next());
    }

    @Test
    void testNext_WhenNodeListIsNull_ThrowsNoSuchElementException() {
        nodeListIterator = new NodeListIterator((NodeList) null);
        assertThrows(NoSuchElementException.class, () -> nodeListIterator.next());
    }
}
