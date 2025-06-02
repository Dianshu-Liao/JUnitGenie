package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.model.NodeIterator;

public class JDOMAttributeIterator_JDOMAttributeIterator_3_0_Test {

    private NodePointer parent;

    private QName name;

    private JDOMAttributeIterator iterator;

    @BeforeEach
    public void setUp() {
        // Mock the NodePointer and QName
        parent = mock(NodePointer.class);
        name = mock(QName.class);
    }

    @Test
    public void testJDOMAttributeIteratorWithElement() {
        // Setup
        Element element = new Element("testElement");
        Attribute attribute = new Attribute("testAttribute", "value");
        element.setAttribute(attribute);
        when(parent.getNode()).thenReturn(element);
        when(name.getName()).thenReturn("testAttribute");
        when(name.getPrefix()).thenReturn(null);
        // Create the iterator
        iterator = new JDOMAttributeIterator(parent, name);
        // Verify attributes are set correctly
        assertNotNull(iterator);
        assertEquals(1, iterator.getPosition());
        assertTrue(iterator.setPosition(1));
    }

    @Test
    public void testJDOMAttributeIteratorWithNamespace() {
        // Setup
        Element element = new Element("testElement");
        Namespace ns = Namespace.getNamespace("test", "http://test.namespace");
        Attribute attribute = new Attribute("testAttribute", "value", ns);
        element.setAttribute(attribute);
        when(parent.getNode()).thenReturn(element);
        when(name.getName()).thenReturn("testAttribute");
        when(name.getPrefix()).thenReturn("test");
        // Mock the NamespaceResolver
        when(parent.getNamespaceResolver().getNamespaceURI("test")).thenReturn("http://test.namespace");
        // Create the iterator
        iterator = new JDOMAttributeIterator(parent, name);
        // Verify attributes are set correctly
        assertNotNull(iterator);
        assertEquals(1, iterator.getPosition());
        assertTrue(iterator.setPosition(1));
    }

    @Test
    public void testJDOMAttributeIteratorWithNoAttributes() {
        // Setup
        Element element = new Element("testElement");
        when(parent.getNode()).thenReturn(element);
        when(name.getName()).thenReturn("nonExistentAttribute");
        when(name.getPrefix()).thenReturn(null);
        // Create the iterator
        iterator = new JDOMAttributeIterator(parent, name);
        // Verify no attributes found
        assertNotNull(iterator);
        assertEquals(0, iterator.getPosition());
        assertFalse(iterator.setPosition(1));
    }

    @Test
    public void testJDOMAttributeIteratorWithWildcard() {
        // Setup
        Element element = new Element("testElement");
        Attribute attr1 = new Attribute("attr1", "value1");
        Attribute attr2 = new Attribute("attr2", "value2");
        element.setAttribute(attr1);
        element.setAttribute(attr2);
        when(parent.getNode()).thenReturn(element);
        when(name.getName()).thenReturn("*");
        when(name.getPrefix()).thenReturn(null);
        // Create the iterator
        iterator = new JDOMAttributeIterator(parent, name);
        // Verify all attributes found
        assertNotNull(iterator);
        assertEquals(2, iterator.getPosition());
        assertTrue(iterator.setPosition(1));
        assertTrue(iterator.setPosition(2));
    }
}
