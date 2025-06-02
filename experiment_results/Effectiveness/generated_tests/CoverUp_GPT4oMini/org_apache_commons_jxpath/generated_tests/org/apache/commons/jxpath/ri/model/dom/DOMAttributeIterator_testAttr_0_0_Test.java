package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributeIterator;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Attr;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

class DOMAttributeIterator_testAttr_0_0_Test {

    private DOMNodePointer parent;

    private QName name;

    private DOMAttributeIterator iterator;

    @BeforeEach
    void setUp() {
        parent = mock(DOMNodePointer.class);
        name = new QName("testPrefix", "testLocalName");
        iterator = new DOMAttributeIterator(parent, name);
    }

    @Test
    void testAttr_WithNamespacePrefix() {
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn("testPrefix");
        when(attr.getLocalName()).thenReturn("testLocalName");
        boolean result = invokeTestAttr(iterator, attr);
        assertTrue(result);
    }

    @Test
    void testAttr_WithNoNamespacePrefix() {
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn(null);
        when(attr.getLocalName()).thenReturn("testLocalName");
        boolean result = invokeTestAttr(iterator, attr);
        assertTrue(result);
    }

    @Test
    void testAttr_WithXmlnsPrefix() {
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn("xmlns");
        when(attr.getLocalName()).thenReturn("testLocalName");
        boolean result = invokeTestAttr(iterator, attr);
        assertFalse(result);
    }

    @Test
    void testAttr_WithXmlnsLocalName() {
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn(null);
        when(attr.getLocalName()).thenReturn("xmlns");
        boolean result = invokeTestAttr(iterator, attr);
        assertFalse(result);
    }

    @Test
    void testAttr_WithDifferentLocalName() {
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn("testPrefix");
        when(attr.getLocalName()).thenReturn("differentLocalName");
        boolean result = invokeTestAttr(iterator, attr);
        assertFalse(result);
    }

    @Test
    void testAttr_WithNullPrefixAndMatchingNamespace() {
        when(parent.getNamespaceURI("testPrefix")).thenReturn("testNamespace");
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn(null);
        when(attr.getLocalName()).thenReturn("testLocalName");
        boolean result = invokeTestAttr(iterator, attr);
        assertFalse(result);
    }

    private boolean invokeTestAttr(DOMAttributeIterator iterator, Attr attr) {
        try {
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
            method.setAccessible(true);
            return (Boolean) method.invoke(iterator, attr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
