package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

class JDOMPointerFactory_createNodePointer_2_0_Test {

    private JDOMPointerFactory jdomPointerFactory;

    @BeforeEach
    void setUp() {
        jdomPointerFactory = new JDOMPointerFactory();
    }

    @Test
    void testCreateNodePointerWithDocument() {
        Document document = new Document();
        QName qName = new QName("root");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = jdomPointerFactory.createNodePointer(parent, qName, document);
        assertNotNull(result, "NodePointer should not be null for Document");
    }

    @Test
    void testCreateNodePointerWithElement() {
        Element element = new Element("child");
        QName qName = new QName("child");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = jdomPointerFactory.createNodePointer(parent, qName, element);
        assertNotNull(result, "NodePointer should not be null for Element");
    }

    @Test
    void testCreateNodePointerWithNullBean() {
        QName qName = new QName("nullBean");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = jdomPointerFactory.createNodePointer(parent, qName, null);
        assertNull(result, "NodePointer should be null for null bean");
    }

    @Test
    void testCreateNodePointerWithUnsupportedBean() {
        QName qName = new QName("unsupported");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        // An unsupported type
        Object unsupportedBean = new Object();
        NodePointer result = jdomPointerFactory.createNodePointer(parent, qName, unsupportedBean);
        assertNull(result, "NodePointer should be null for unsupported bean type");
    }
}
