package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.TypeUtils;

class DOMNodePointer_getNamespaceURI_36_0_Test {

    @Test
    void testGetNamespaceURI_DocumentNode() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);
        // Act
        String result = DOMNodePointer.getNamespaceURI(document);
        // Assert
        assertNull(result);
    }

    @Test
    void testGetNamespaceURI_ElementNodeWithNamespace() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElementNS("http://example.com/ns", "example:element");
        document.appendChild(element);
        // Act
        String result = DOMNodePointer.getNamespaceURI(element);
        // Assert
        assertEquals("http://example.com/ns", result);
    }

    @Test
    void testGetNamespaceURI_ElementNodeWithoutNamespace() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("element");
        document.appendChild(element);
        // Act
        String result = DOMNodePointer.getNamespaceURI(element);
        // Assert
        assertNull(result);
    }

    @Test
    void testGetNamespaceURI_ElementNodeWithInheritedNamespace() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element parentElement = document.createElementNS("http://example.com/ns", "example:parent");
        document.appendChild(parentElement);
        Element childElement = document.createElement("child");
        parentElement.appendChild(childElement);
        childElement.setAttribute("xmlns", "http://example.com/ns");
        // Act
        String result = DOMNodePointer.getNamespaceURI(childElement);
        // Assert
        assertEquals("http://example.com/ns", result);
    }

    @Test
    void testGetNamespaceURI_EmptyNamespace() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("element");
        document.appendChild(element);
        element.setAttribute("xmlns", "");
        // Act
        String result = DOMNodePointer.getNamespaceURI(element);
        // Assert
        assertNull(result);
    }

    @Test
    void testGetNamespaceURI_ElementWithNamespaceAttribute() throws Exception {
        // Arrange
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element parentElement = document.createElementNS("http://example.com/ns", "example:parent");
        document.appendChild(parentElement);
        Element childElement = document.createElement("child");
        parentElement.appendChild(childElement);
        childElement.setAttribute("xmlns:example", "http://example.com/ns");
        // Act
        String result = DOMNodePointer.getNamespaceURI(childElement);
        // Assert
        assertEquals("http://example.com/ns", result);
    }
}
