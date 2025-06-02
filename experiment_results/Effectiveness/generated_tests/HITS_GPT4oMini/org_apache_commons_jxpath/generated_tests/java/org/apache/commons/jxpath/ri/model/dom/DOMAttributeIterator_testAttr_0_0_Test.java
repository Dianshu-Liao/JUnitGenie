package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DOMAttributeIterator_testAttr_0_0_Test {

    private NodePointer parent;

    private QName name;

    private DOMAttributeIterator iterator;

    @BeforeEach
    public void setUp() {
        parent = mock(NodePointer.class);
        name = new QName("testPrefix", "testName");
        iterator = new DOMAttributeIterator(parent, name);
    }

    @Test
    public void testAttr_WithValidAttr_ShouldReturnTrue() {
        Attr attr = mock(Attr.class);
        when(attr.getLocalName()).thenReturn("testName");
        when(attr.getPrefix()).thenReturn("testPrefix");
        when(parent.getNamespaceURI("testPrefix")).thenReturn("namespaceURI");
        // Simulate the behavior of the iterator
        // Assuming we have a public method that utilizes testAttr
        // Replace with actual public method
        boolean result = iterator.getNodePointer().equals(attr);
        assertTrue(result);
    }

    @Test
    public void testAttr_WithWildcardName_ShouldReturnTrue() {
        name = new QName("*", "testName");
        iterator = new DOMAttributeIterator(parent, name);
        Attr attr = mock(Attr.class);
        when(attr.getLocalName()).thenReturn("testName");
        when(attr.getPrefix()).thenReturn("testPrefix");
        when(parent.getNamespaceURI("testPrefix")).thenReturn("namespaceURI");
        // Replace with actual public method
        boolean result = iterator.getNodePointer().equals(attr);
        assertTrue(result);
    }

    @Test
    public void testAttr_WithDifferentLocalName_ShouldReturnFalse() {
        Attr attr = mock(Attr.class);
        when(attr.getLocalName()).thenReturn("differentName");
        when(attr.getPrefix()).thenReturn("testPrefix");
        // Replace with actual public method
        boolean result = iterator.getNodePointer().equals(attr);
        assertFalse(result);
    }

    @Test
    public void testAttr_WithNullPrefixAndLocalNameIsXmlns_ShouldReturnFalse() {
        Attr attr = mock(Attr.class);
        when(attr.getLocalName()).thenReturn("xmlns");
        when(attr.getPrefix()).thenReturn(null);
        // Replace with actual public method
        boolean result = iterator.getNodePointer().equals(attr);
        assertFalse(result);
    }
}
