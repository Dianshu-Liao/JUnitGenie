package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DOMPointerFactory_createNodePointer_2_0_Test {

    private final DOMPointerFactory factory = new DOMPointerFactory();

    @Test
    public void testCreateNodePointer_WithNodeInstance_ShouldReturnDOMNodePointer() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("testElement");
        QName qName = new QName("testElement");
        // Assuming null for simplicity
        NodePointer parentPointer = null;
        // Act
        NodePointer result = this.factory.createNodePointer(parentPointer, qName, element);
        // Assert
        assertNotNull(result, "Expected a DOMNodePointer instance to be returned.");
    }

    @Test
    public void testCreateNodePointer_WithNonNodeInstance_ShouldReturnNull() {
        // Arrange
        QName qName = new QName("testElement");
        // Assuming null for simplicity
        NodePointer parentPointer = null;
        String nonNodeBean = "Not a Node";
        // Act
        NodePointer result = this.factory.createNodePointer(parentPointer, qName, nonNodeBean);
        // Assert
        assertNull(result, "Expected null to be returned for a non-Node instance.");
    }

    @Test
    public void testCreateNodePointer_WithNullBean_ShouldReturnNull() {
        // Arrange
        QName qName = new QName("testElement");
        // Assuming null for simplicity
        NodePointer parentPointer = null;
        // Act
        NodePointer result = this.factory.createNodePointer(parentPointer, qName, null);
        // Assert
        assertNull(result, "Expected null to be returned when bean is null.");
    }
}
