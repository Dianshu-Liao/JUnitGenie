package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.w3c.dom.Node;

public class DOMPointerFactory_createNodePointer_1_0_Test {

    private final DOMPointerFactory factory = new DOMPointerFactory();

    @Test
    public void testCreateNodePointer_WithValidNode() {
        // Arrange
        Document document = createSampleDocument();
        QName qName = new QName("sampleNode");
        Locale locale = Locale.getDefault();
        // Act
        NodePointer result = factory.createNodePointer(qName, document.getDocumentElement(), locale);
        // Assert
        assertNotNull(result, "Expected a non-null NodePointer for a valid Node.");
    }

    @Test
    public void testCreateNodePointer_WithNullNode() {
        // Arrange
        QName qName = new QName("sampleNode");
        Locale locale = Locale.getDefault();
        // Act
        NodePointer result = factory.createNodePointer(qName, null, locale);
        // Assert
        assertNull(result, "Expected a null NodePointer for a null Node.");
    }

    @Test
    public void testCreateNodePointer_WithNonNodeObject() {
        // Arrange
        QName qName = new QName("sampleNode");
        Locale locale = Locale.getDefault();
        String nonNodeObject = "This is not a Node";
        // Act
        NodePointer result = factory.createNodePointer(qName, nonNodeObject, locale);
        // Assert
        assertNull(result, "Expected a null NodePointer for a non-Node object.");
    }

    private Document createSampleDocument() {
        try {
            javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            return document;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create sample document", e);
        }
    }
}
