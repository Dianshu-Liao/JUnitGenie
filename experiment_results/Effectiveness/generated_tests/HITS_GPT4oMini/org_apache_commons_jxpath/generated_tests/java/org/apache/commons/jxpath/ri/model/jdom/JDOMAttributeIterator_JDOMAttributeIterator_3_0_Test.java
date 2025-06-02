package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.jxpath.ri.model.NodeIterator;

public class JDOMAttributeIterator_JDOMAttributeIterator_3_0_Test {

    private NodePointer nodePointer;

    private QName qName;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a sample XML for testing
        String xml = "<root xmlns:ns='http://example.com/ns'><element ns:attr='value' attr='value2'/></root>";
        SAXBuilder saxBuilder = new SAXBuilder();
        Element rootElement = saxBuilder.build(new StringReader(xml)).getRootElement();
        nodePointer = Mockito.mock(NodePointer.class);
        when(nodePointer.getNode()).thenReturn(rootElement);
        NamespaceResolver resolver = new NamespaceResolver();
        when(nodePointer.getNamespaceResolver()).thenReturn(resolver);
        qName = new QName("attr");
    }

    private List<Attribute> getAttributes(JDOMAttributeIterator iterator) throws Exception {
        Field attributesField = JDOMAttributeIterator.class.getDeclaredField("attributes");
        attributesField.setAccessible(true);
        return (List<Attribute>) attributesField.get(iterator);
    }

    @Test
    public void testJDOMAttributeIterator_WithSingleAttribute() throws Exception {
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(nodePointer, qName);
        List<Attribute> attributes = getAttributes(iterator);
        assertEquals(1, attributes.size());
        assertEquals("value2", attributes.get(0).getValue());
    }

    @Test
    public void testJDOMAttributeIterator_WithNamespaceAttribute() throws Exception {
        QName nsQName = new QName("ns", "attr");
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(nodePointer, nsQName);
        List<Attribute> attributes = getAttributes(iterator);
        assertEquals(1, attributes.size());
        assertEquals("value", attributes.get(0).getValue());
    }

    @Test
    public void testJDOMAttributeIterator_WithNoMatchingAttribute() throws Exception {
        QName nonExistentQName = new QName("nonExistentAttr");
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(nodePointer, nonExistentQName);
        List<Attribute> attributes = getAttributes(iterator);
        assertTrue(attributes.isEmpty());
    }

    @Test
    public void testJDOMAttributeIterator_WithWildcard() throws Exception {
        QName wildcardQName = new QName("*");
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(nodePointer, wildcardQName);
        List<Attribute> attributes = getAttributes(iterator);
        // there are two attributes in the element
        assertEquals(2, attributes.size());
    }

    @Test
    public void testJDOMAttributeIterator_WithNullPrefix() throws Exception {
        QName nullPrefixQName = new QName(null, "attr");
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(nodePointer, nullPrefixQName);
        List<Attribute> attributes = getAttributes(iterator);
        assertEquals(1, attributes.size());
        assertEquals("value2", attributes.get(0).getValue());
    }
}
