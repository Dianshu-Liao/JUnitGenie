package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributeIterator;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.w3c.dom.Node;

class DOMAttributeIterator_DOMAttributeIterator_5_0_Test {

    @Mock
    private NodePointer parent;

    @Mock
    private Element element;

    @Mock
    private NamedNodeMap namedNodeMap;

    private DOMAttributeIterator iterator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConstructorWithSpecificAttribute() {
        QName qName = new QName("testAttribute");
        when(parent.getNode()).thenReturn(element);
        when(element.getNodeType()).thenReturn(org.w3c.dom.Node.ELEMENT_NODE);
        when(element.getAttributeNode("testAttribute")).thenReturn(mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, qName);
        assertNotNull(iterator);
    }

    @Test
    void testConstructorWithWildcardAttribute() {
        QName qName = new QName("*");
        when(parent.getNode()).thenReturn(element);
        when(element.getNodeType()).thenReturn(org.w3c.dom.Node.ELEMENT_NODE);
        when(element.getAttributes()).thenReturn(namedNodeMap);
        when(namedNodeMap.getLength()).thenReturn(2);
        when(namedNodeMap.item(0)).thenReturn(mock(Attr.class));
        when(namedNodeMap.item(1)).thenReturn(mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, qName);
        assertNotNull(iterator);
    }

    @Test
    void testGetNodePointerWhenPositionIsZero() {
        QName qName = new QName("testAttribute");
        when(parent.getNode()).thenReturn(element);
        when(element.getNodeType()).thenReturn(org.w3c.dom.Node.ELEMENT_NODE);
        when(element.getAttributeNode("testAttribute")).thenReturn(mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, qName);
        iterator.setPosition(1);
        assertNotNull(iterator.getNodePointer());
    }

    @Test
    void testGetNodePointerWhenPositionIsOutOfBounds() {
        QName qName = new QName("testAttribute");
        when(parent.getNode()).thenReturn(element);
        when(element.getNodeType()).thenReturn(org.w3c.dom.Node.ELEMENT_NODE);
        when(element.getAttributeNode("testAttribute")).thenReturn(mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, qName);
        // Out of bounds
        iterator.setPosition(2);
        assertNull(iterator.getNodePointer());
    }

    @Test
    void testSetPosition() {
        QName qName = new QName("testAttribute");
        when(parent.getNode()).thenReturn(element);
        when(element.getNodeType()).thenReturn(org.w3c.dom.Node.ELEMENT_NODE);
        when(element.getAttributeNode("testAttribute")).thenReturn(mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, qName);
        iterator.setPosition(1);
        assertEquals(1, iterator.getPosition());
        assertTrue(iterator.setPosition(1));
        // Invalid
        assertFalse(iterator.setPosition(0));
        // Invalid
        assertFalse(iterator.setPosition(2));
    }

    // Reflection test to invoke private methods
    @Test
    void testPrivateMethods() throws Exception {
        QName qName = new QName("testAttribute");
        when(parent.getNode()).thenReturn(element);
        when(element.getNodeType()).thenReturn(org.w3c.dom.Node.ELEMENT_NODE);
        when(element.getAttributeNode("testAttribute")).thenReturn(mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, qName);
        Method testAttrMethod = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
        testAttrMethod.setAccessible(true);
        Attr attr = mock(Attr.class);
        when(attr.getLocalName()).thenReturn("testAttribute");
        boolean result = (boolean) testAttrMethod.invoke(iterator, attr);
        assertTrue(result);
    }
}
