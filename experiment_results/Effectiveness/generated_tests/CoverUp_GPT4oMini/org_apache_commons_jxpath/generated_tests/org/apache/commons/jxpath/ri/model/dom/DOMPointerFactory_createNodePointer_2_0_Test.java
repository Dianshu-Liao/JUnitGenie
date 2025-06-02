package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.dom.DOMPointerFactory;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DOMPointerFactory_createNodePointer_2_0_Test {

    @Test
    public void testCreateNodePointerWithValidNode() throws Exception {
        // Arrange
        DOMPointerFactory factory = new DOMPointerFactory();
        // Assuming null parent for simplicity
        NodePointer parent = null;
        QName name = new QName("testNode");
        // Creating a sample Node (Element)
        DocumentBuilderFactory factoryDB = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoryDB.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element element = doc.createElement("testElement");
        // Act
        NodePointer result = factory.createNodePointer(parent, name, element);
        // Assert
        assertNotNull(result);
        assert (result instanceof DOMNodePointer);
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        // Arrange
        DOMPointerFactory factory = new DOMPointerFactory();
        // Assuming null parent for simplicity
        NodePointer parent = null;
        QName name = new QName("testNode");
        // Act
        NodePointer result = factory.createNodePointer(parent, name, null);
        // Assert
        assertNull(result);
    }

    @Test
    public void testCreateNodePointerWithNonNodeBean() {
        // Arrange
        DOMPointerFactory factory = new DOMPointerFactory();
        // Assuming null parent for simplicity
        NodePointer parent = null;
        QName name = new QName("testNode");
        // Act
        NodePointer result = factory.createNodePointer(parent, name, "NotANode");
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetOrder() {
        // Arrange
        DOMPointerFactory factory = new DOMPointerFactory();
        // Act
        int order = factory.getOrder();
        // Assert
        assertEquals(DOMPointerFactory.DOM_POINTER_FACTORY_ORDER, order);
    }
}
