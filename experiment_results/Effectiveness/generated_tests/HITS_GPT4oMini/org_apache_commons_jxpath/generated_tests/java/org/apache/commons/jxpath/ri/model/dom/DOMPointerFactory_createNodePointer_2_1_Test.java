package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import org.w3c.dom.Node;

public class DOMPointerFactory_createNodePointer_2_1_Test {

    private final DOMPointerFactory factory = new DOMPointerFactory();

    @Test
    public void testCreateNodePointer_WithValidNode() throws Exception {
        // Arrange
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element element = document.createElement("testElement");
        QName qName = new QName("testElement");
        // Mocking a NodePointer
        NodePointer parentPointer = Mockito.mock(NodePointer.class);
        // Act
        NodePointer result = this.factory.createNodePointer(parentPointer, qName, element);
        // Assert
        assertNotNull(result, "Expected a non-null NodePointer for a valid Node.");
    }

    @Test
    public void testCreateNodePointer_WithNullBean() {
        // Arrange
        QName qName = new QName("testElement");
        // Mocking a NodePointer
        NodePointer parentPointer = Mockito.mock(NodePointer.class);
        // Act
        NodePointer result = this.factory.createNodePointer(parentPointer, qName, null);
        // Assert
        assertNull(result, "Expected a null NodePointer when bean is null.");
    }

    @Test
    public void testCreateNodePointer_WithNonNodeBean() {
        // Arrange
        QName qName = new QName("testElement");
        String nonNodeBean = "Not a Node";
        // Mocking a NodePointer
        NodePointer parentPointer = Mockito.mock(NodePointer.class);
        // Act
        NodePointer result = this.factory.createNodePointer(parentPointer, qName, nonNodeBean);
        // Assert
        assertNull(result, "Expected a null NodePointer when bean is not an instance of Node.");
    }
}
