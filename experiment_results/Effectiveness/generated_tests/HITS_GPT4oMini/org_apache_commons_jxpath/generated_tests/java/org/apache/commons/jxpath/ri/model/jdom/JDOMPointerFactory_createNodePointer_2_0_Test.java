package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.jdom.Document;
import org.jdom.Element;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class JDOMPointerFactory_createNodePointer_2_0_Test {

    private final JDOMPointerFactory factory = new JDOMPointerFactory();

    @Test
    public void testCreateNodePointerWithDocument() {
        Document document = new Document();
        QName qName = new QName("testDocument");
        // Assuming a null parent for simplicity
        NodePointer parentPointer = null;
        NodePointer result = factory.createNodePointer(parentPointer, qName, document);
        assertNotNull(result, "Expected a non-null NodePointer for Document");
        assertTrue(result instanceof JDOMNodePointer, "Expected result to be an instance of JDOMNodePointer");
    }

    @Test
    public void testCreateNodePointerWithElement() {
        Element element = new Element("testElement");
        QName qName = new QName("testElement");
        // Assuming a null parent for simplicity
        NodePointer parentPointer = null;
        NodePointer result = factory.createNodePointer(parentPointer, qName, element);
        assertNotNull(result, "Expected a non-null NodePointer for Element");
        assertTrue(result instanceof JDOMNodePointer, "Expected result to be an instance of JDOMNodePointer");
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        QName qName = new QName("testNull");
        // Assuming a null parent for simplicity
        NodePointer parentPointer = null;
        NodePointer result = factory.createNodePointer(parentPointer, qName, null);
        assertNull(result, "Expected a null NodePointer for null bean");
    }

    @Test
    public void testCreateNodePointerWithUnsupportedType() {
        QName qName = new QName("testUnsupported");
        // Assuming a null parent for simplicity
        NodePointer parentPointer = null;
        // An unsupported type
        Object unsupportedBean = new Object();
        NodePointer result = factory.createNodePointer(parentPointer, qName, unsupportedBean);
        assertNull(result, "Expected a null NodePointer for unsupported bean type");
    }
}
