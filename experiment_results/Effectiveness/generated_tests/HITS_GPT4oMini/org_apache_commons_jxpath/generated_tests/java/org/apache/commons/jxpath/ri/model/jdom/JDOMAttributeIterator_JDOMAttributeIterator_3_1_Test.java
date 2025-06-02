package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JDOMAttributeIterator_JDOMAttributeIterator_3_1_Test {

    private NodePointer mockNodePointer;

    private Element mockElement;

    @BeforeEach
    public void setUp() {
        mockNodePointer = Mockito.mock(NodePointer.class);
        mockElement = Mockito.mock(Element.class);
    }

    @Test
    public void testJDOMAttributeIterator_WithElementNode() throws Exception {
        QName qName = new QName("attrName");
        Mockito.when(mockNodePointer.getNode()).thenReturn(mockElement);
        Mockito.when(mockNodePointer.getNamespaceResolver()).thenReturn(Mockito.mock(NamespaceResolver.class));
        Mockito.when(mockElement.getAttribute("attrName", Namespace.NO_NAMESPACE)).thenReturn(new Attribute("attrName", "value"));
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, qName);
        // Access the private attributes field using reflection
        List<Attribute> attributes = getAttributes(iterator);
        assertEquals(1, attributes.size());
        Attribute attr = attributes.get(0);
        assertEquals("attrName", attr.getName());
        assertEquals("value", attr.getValue());
    }

    @Test
    public void testJDOMAttributeIterator_WithNullElementNode() throws Exception {
        QName qName = new QName("attrName");
        Mockito.when(mockNodePointer.getNode()).thenReturn(null);
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(mockNodePointer, qName);
        // Access the private attributes field using reflection
        List<Attribute> attributes = getAttributes(iterator);
        assertEquals(0, attributes.size());
    }

    // Helper method to access private attributes field
    private List<Attribute> getAttributes(JDOMAttributeIterator iterator) throws Exception {
        Field attributesField = JDOMAttributeIterator.class.getDeclaredField("attributes");
        attributesField.setAccessible(true);
        return (List<Attribute>) attributesField.get(iterator);
    }
}
