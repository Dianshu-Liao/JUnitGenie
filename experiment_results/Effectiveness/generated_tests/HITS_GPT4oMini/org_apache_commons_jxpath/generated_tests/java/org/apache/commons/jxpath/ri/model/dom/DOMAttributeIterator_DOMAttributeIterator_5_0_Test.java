package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
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

public class DOMAttributeIterator_DOMAttributeIterator_5_0_Test {

    private NodePointer parent;

    private QName name;

    private DOMAttributeIterator iterator;

    @BeforeEach
    public void setUp() {
        parent = Mockito.mock(NodePointer.class);
        name = new QName("testAttribute");
        iterator = new DOMAttributeIterator(parent, name);
    }

    @Test
    public void testConstructorWithSpecificAttribute() {
        Element element = Mockito.mock(Element.class);
        Attr attr = Mockito.mock(Attr.class);
        Mockito.when(attr.getName()).thenReturn("testAttribute");
        Mockito.when(parent.getNode()).thenReturn(element);
        Mockito.when(element.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(element.getAttributeNode(name.getName())).thenReturn(attr);
        iterator = new DOMAttributeIterator(parent, name);
        assertEquals(1, iterator.getPosition());
        assertNotNull(iterator.getNodePointer());
    }

    @Test
    public void testConstructorWithWildcardAttribute() {
        name = new QName("*");
        iterator = new DOMAttributeIterator(parent, name);
        Element element = Mockito.mock(Element.class);
        NamedNodeMap namedNodeMap = Mockito.mock(NamedNodeMap.class);
        Mockito.when(parent.getNode()).thenReturn(element);
        Mockito.when(element.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(element.getAttributes()).thenReturn(namedNodeMap);
        Mockito.when(namedNodeMap.getLength()).thenReturn(2);
        Mockito.when(namedNodeMap.item(0)).thenReturn(Mockito.mock(Attr.class));
        Mockito.when(namedNodeMap.item(1)).thenReturn(Mockito.mock(Attr.class));
        iterator = new DOMAttributeIterator(parent, name);
        assertTrue(iterator.getPosition() > 0);
        assertNotNull(iterator.getNodePointer());
    }

    @Test
    public void testConstructorWithNoAttributes() {
        Element element = Mockito.mock(Element.class);
        Mockito.when(parent.getNode()).thenReturn(element);
        Mockito.when(element.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(element.getAttributes()).thenReturn(Mockito.mock(NamedNodeMap.class));
        Mockito.when(element.getAttributes().getLength()).thenReturn(0);
        iterator = new DOMAttributeIterator(parent, name);
        assertEquals(0, iterator.getPosition());
        assertNull(iterator.getNodePointer());
    }

    @Test
    public void testSetPositionValid() {
        name = new QName("*");
        iterator = new DOMAttributeIterator(parent, name);
        assertTrue(iterator.setPosition(1));
        assertEquals(1, iterator.getPosition());
    }

    @Test
    public void testSetPositionInvalid() {
        name = new QName("*");
        iterator = new DOMAttributeIterator(parent, name);
        assertFalse(iterator.setPosition(0));
        // Assuming only one attribute exists
        assertFalse(iterator.setPosition(2));
    }

    @Test
    public void testGetNodePointer() {
        name = new QName("testAttribute");
        Element element = Mockito.mock(Element.class);
        Attr attr = Mockito.mock(Attr.class);
        Mockito.when(attr.getName()).thenReturn("testAttribute");
        Mockito.when(parent.getNode()).thenReturn(element);
        Mockito.when(element.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(element.getAttributeNode(name.getName())).thenReturn(attr);
        iterator = new DOMAttributeIterator(parent, name);
        assertNotNull(iterator.getNodePointer());
    }
}
