package org.apache.commons.jxpath.ri.model.jdom;

import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;

public class JDOMAttributeIterator_JDOMAttributeIterator_3_1_Test {

    private NodePointer mockNodePointer;

    private QName mockQName;

    private Element mockElement;

    private Attribute mockAttribute;

    @BeforeEach
    public void setUp() {
        mockNodePointer = mock(NodePointer.class);
        mockQName = mock(QName.class);
        mockElement = mock(Element.class);
        mockAttribute = mock(Attribute.class);
    }

    @Test
    public void testConstructor_WithXmlPrefix() {
        when(mockNodePointer.getNode()).thenReturn(mockElement);
        when(mockQName.getPrefix()).thenReturn("xml");
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, mockQName);
        assertNotNull(iterator);
        // Verify that attributes list is empty or not initialized
        assertTrue(getAttributes(iterator).isEmpty());
    }

    @Test
    public void testConstructor_WithValidNamespace() {
        when(mockNodePointer.getNode()).thenReturn(mockElement);
        when(mockQName.getPrefix()).thenReturn("ns");
        when(mockNodePointer.getNamespaceResolver().getNamespaceURI("ns")).thenReturn("http://example.com/ns");
        when(mockQName.getName()).thenReturn("attrName");
        when(mockElement.getAttribute("attrName", Namespace.getNamespace("ns", "http://example.com/ns"))).thenReturn(mockAttribute);
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, mockQName);
        assertNotNull(iterator);
        assertEquals(1, getAttributes(iterator).size());
        assertEquals(mockAttribute, getAttributes(iterator).get(0));
    }

    @Test
    public void testConstructor_WithNoAttribute() {
        when(mockNodePointer.getNode()).thenReturn(mockElement);
        when(mockQName.getPrefix()).thenReturn("ns");
        when(mockNodePointer.getNamespaceResolver().getNamespaceURI("ns")).thenReturn("http://example.com/ns");
        when(mockQName.getName()).thenReturn("attrName");
        when(mockElement.getAttribute("attrName", Namespace.getNamespace("ns", "http://example.com/ns"))).thenReturn(null);
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, mockQName);
        assertNotNull(iterator);
        assertTrue(getAttributes(iterator).isEmpty());
    }

    @Test
    public void testConstructor_WithWildcard() {
        when(mockNodePointer.getNode()).thenReturn(mockElement);
        when(mockQName.getPrefix()).thenReturn(null);
        when(mockQName.getName()).thenReturn("*");
        List<Attribute> mockAttributesList = Collections.singletonList(mockAttribute);
        when(mockElement.getAttributes()).thenReturn(mockAttributesList);
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, mockQName);
        assertNotNull(iterator);
        assertEquals(1, getAttributes(iterator).size());
        assertEquals(mockAttribute, getAttributes(iterator).get(0));
    }

    @Test
    public void testConstructor_WithNullPrefixAndNoNamespace() {
        when(mockNodePointer.getNode()).thenReturn(mockElement);
        when(mockQName.getPrefix()).thenReturn(null);
        when(mockQName.getName()).thenReturn("attrName");
        when(mockElement.getAttribute("attrName", Namespace.NO_NAMESPACE)).thenReturn(null);
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, mockQName);
        assertNotNull(iterator);
        assertTrue(getAttributes(iterator).isEmpty());
    }

    @SuppressWarnings("unchecked")
    private List<Attribute> getAttributes(JDOMAttributeIterator iterator) {
        try {
            java.lang.reflect.Field field = JDOMAttributeIterator.class.getDeclaredField("attributes");
            field.setAccessible(true);
            return (List<Attribute>) field.get(iterator);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
