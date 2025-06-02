package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class DOMNamespaceIterator_getNodePointer_1_0_Test {

    private DOMNamespaceIterator iterator;

    private NodePointer parentNodePointer;

    private List<Attr> attributes;

    @BeforeEach
    public void setUp() {
        // Mock the NodePointer
        parentNodePointer = mock(NodePointer.class);
        // Create a mock Document and Element
        Document mockDocument = mock(Document.class);
        Element mockElement = mock(Element.class);
        when(parentNodePointer.getNode()).thenReturn(mockElement);
        // Prepare attributes
        attributes = new ArrayList<>();
        Attr mockAttr1 = mock(Attr.class);
        when(mockAttr1.getPrefix()).thenReturn("xmlns");
        when(mockAttr1.getValue()).thenReturn("http://example.com/ns1");
        attributes.add(mockAttr1);
        Attr mockAttr2 = mock(Attr.class);
        when(mockAttr2.getPrefix()).thenReturn("xmlns");
        when(mockAttr2.getValue()).thenReturn("http://example.com/ns2");
        attributes.add(mockAttr2);
        // Initialize the iterator
        iterator = new DOMNamespaceIterator(parentNodePointer);
        // Set initial position
        iterator.setPosition(1);
    }

    @Test
    public void testGetNodePointerWhenPositionIsZero() {
        // Reset position to 0
        iterator.setPosition(0);
        NodePointer result = iterator.getNodePointer();
        assertNotNull(result, "Expected a non-null NodePointer");
    }

    @Test
    public void testGetNodePointerWithValidPosition() {
        NodePointer result = iterator.getNodePointer();
        assertNotNull(result, "Expected a non-null NodePointer");
        assertEquals("http://example.com/ns1", result.getValue(), "Expected value to match the attribute value");
    }

    @Test
    public void testGetNodePointerWithEmptyAttributes() {
        // Clear attributes
        attributes.clear();
        // Reinitialize iterator
        iterator = new DOMNamespaceIterator(parentNodePointer);
        // Set position
        iterator.setPosition(1);
        NodePointer result = iterator.getNodePointer();
        assertNull(result, "Expected a null NodePointer when attributes are empty");
    }

    @Test
    public void testGetNodePointerWithInvalidPosition() {
        // Set to an invalid position
        iterator.setPosition(3);
        NodePointer result = iterator.getNodePointer();
        assertNull(result, "Expected a null NodePointer when position is invalid");
    }

    @Test
    public void testGetNodePointerForNamespacePrefix() {
        // Set to first attribute
        iterator.setPosition(1);
        NodePointer result = iterator.getNodePointer();
        assertNotNull(result, "Expected a non-null NodePointer");
        assertEquals("http://example.com/ns1", result.getValue(), "Expected value to match the first attribute value");
    }

    @Test
    public void testGetNodePointerForSecondNamespace() {
        // Set to second attribute
        iterator.setPosition(2);
        NodePointer result = iterator.getNodePointer();
        assertNotNull(result, "Expected a non-null NodePointer");
        assertEquals("http://example.com/ns2", result.getValue(), "Expected value to match the second attribute value");
    }
}
