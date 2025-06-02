package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Element;
import org.jdom.Namespace;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

public class JDOMNodePointer_getNamespaceURI_5_0_Test {

    @Test
    public void testGetNamespaceURI_WithElementWithNamespace() {
        // Arrange
        Namespace namespace = Namespace.getNamespace("example", "http://example.com");
        Element element = new Element("testElement", namespace);
        // Using null for Locale
        JDOMNodePointer pointer = new JDOMNodePointer(element, null);
        // Act
        String result = pointer.getNamespaceURI();
        // Assert
        assertEquals("http://example.com", result);
    }

    @Test
    public void testGetNamespaceURI_WithElementWithoutNamespace() {
        // Arrange
        Element element = new Element("testElement");
        // Using null for Locale
        JDOMNodePointer pointer = new JDOMNodePointer(element, null);
        // Act
        String result = pointer.getNamespaceURI();
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithElementWithEmptyNamespace() {
        // Arrange
        Element element = new Element("testElement", Namespace.NO_NAMESPACE);
        // Using null for Locale
        JDOMNodePointer pointer = new JDOMNodePointer(element, null);
        // Act
        String result = pointer.getNamespaceURI();
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithNonElementObject() {
        // Arrange
        String nonElementObject = "Not an Element";
        // Using null for Locale
        JDOMNodePointer pointer = new JDOMNodePointer(nonElementObject, null);
        // Act
        String result = pointer.getNamespaceURI();
        // Assert
        assertNull(result);
    }
}
