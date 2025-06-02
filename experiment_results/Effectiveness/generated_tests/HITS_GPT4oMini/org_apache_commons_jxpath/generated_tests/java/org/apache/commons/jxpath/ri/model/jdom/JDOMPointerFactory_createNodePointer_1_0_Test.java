package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.jdom.Document;
import org.jdom.Element;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class JDOMPointerFactory_createNodePointer_1_0_Test {

    private final JDOMPointerFactory factory = new JDOMPointerFactory();

    @Test
    public void testCreateNodePointerWithDocument() {
        // Arrange
        Document document = new Document();
        QName qName = new QName("root");
        // Act
        NodePointer nodePointer = factory.createNodePointer(qName, document, Locale.getDefault());
        // Assert
        assertNotNull(nodePointer, "NodePointer should not be null for Document");
    }

    @Test
    public void testCreateNodePointerWithElement() {
        // Arrange
        Element element = new Element("child");
        QName qName = new QName("child");
        // Act
        NodePointer nodePointer = factory.createNodePointer(qName, element, Locale.getDefault());
        // Assert
        assertNotNull(nodePointer, "NodePointer should not be null for Element");
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        // Arrange
        QName qName = new QName("nullBean");
        // Act
        NodePointer nodePointer = factory.createNodePointer(qName, null, Locale.getDefault());
        // Assert
        assertNull(nodePointer, "NodePointer should be null for null bean");
    }

    @Test
    public void testCreateNodePointerWithUnsupportedType() {
        // Arrange
        QName qName = new QName("unsupported");
        String unsupportedType = "This is a string, not a Document or Element";
        // Act
        NodePointer nodePointer = factory.createNodePointer(qName, unsupportedType, Locale.getDefault());
        // Assert
        assertNull(nodePointer, "NodePointer should be null for unsupported type");
    }
}
