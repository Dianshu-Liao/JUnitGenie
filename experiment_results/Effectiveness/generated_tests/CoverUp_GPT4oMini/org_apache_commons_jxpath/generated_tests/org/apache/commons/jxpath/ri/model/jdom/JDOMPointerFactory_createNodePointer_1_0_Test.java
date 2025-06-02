package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Document;
import org.jdom.Element;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class JDOMPointerFactory_createNodePointer_1_0_Test {

    private JDOMPointerFactory jdomPointerFactory;

    @BeforeEach
    public void setUp() {
        jdomPointerFactory = new JDOMPointerFactory();
    }

    @Test
    public void testCreateNodePointerWithDocument() {
        Document document = new Document();
        QName qName = new QName("root");
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = jdomPointerFactory.createNodePointer(qName, document, locale);
        assertNotNull(nodePointer, "NodePointer should not be null for Document instance");
    }

    @Test
    public void testCreateNodePointerWithElement() {
        Element element = new Element("testElement");
        QName qName = new QName("testElement");
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = jdomPointerFactory.createNodePointer(qName, element, locale);
        assertNotNull(nodePointer, "NodePointer should not be null for Element instance");
    }

    @Test
    public void testCreateNodePointerWithNull() {
        QName qName = new QName("testElement");
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = jdomPointerFactory.createNodePointer(qName, null, locale);
        assertNull(nodePointer, "NodePointer should be null for null bean");
    }

    @Test
    public void testCreateNodePointerWithUnsupportedType() {
        QName qName = new QName("testElement");
        Locale locale = Locale.ENGLISH;
        Object unsupportedObject = new Object();
        NodePointer nodePointer = jdomPointerFactory.createNodePointer(qName, unsupportedObject, locale);
        assertNull(nodePointer, "NodePointer should be null for unsupported object type");
    }
}
