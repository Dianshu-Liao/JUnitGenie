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

public class JDOMNodePointer_getNamespaceURI_5_2_Test {

    @Test
    public void testGetNamespaceURI_WithElementWithNamespace() throws Exception {
        // Arrange
        Namespace ns = Namespace.getNamespace("example", "http://www.example.com");
        Element element = new Element("testElement", ns);
        // Act
        String result = invokeGetNamespaceURI(element);
        // Assert
        assertEquals("http://www.example.com", result);
    }

    @Test
    public void testGetNamespaceURI_WithElementWithoutNamespace() throws Exception {
        // Arrange
        Element element = new Element("testElement");
        // Act
        String result = invokeGetNamespaceURI(element);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithNonElementNode() throws Exception {
        // Arrange
        Object nonElementNode = new Object();
        // Act
        String result = invokeGetNamespaceURI(nonElementNode);
        // Assert
        assertNull(result);
    }

    private String invokeGetNamespaceURI(Object node) throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = JDOMNodePointer.class.getDeclaredMethod("getNamespaceURI", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(null, node);
    }
}
