// Test method
package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Node;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DOMNodePointer_getNamespaceURI_4_0_Test {

    private DOMNodePointer domNodePointer;

    private Node mockNode;

    @BeforeEach
    public void setUp() {
        mockNode = mock(Node.class);
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
    }

    @Test
    public void testGetNamespaceURI() throws Exception {
        // Arrange
        String expectedNamespaceURI = "http://example.com/namespace";
        when(mockNode.getNamespaceURI()).thenReturn(expectedNamespaceURI);
        // Act
        String actualNamespaceURI = invokeGetNamespaceURI(domNodePointer);
        // Assert
        assertEquals(expectedNamespaceURI, actualNamespaceURI);
    }

    @Test
    public void testGetNamespaceURIWithNull() throws Exception {
        // Arrange
        when(mockNode.getNamespaceURI()).thenReturn(null);
        // Act
        String actualNamespaceURI = invokeGetNamespaceURI(domNodePointer);
        // Assert
        assertNull(actualNamespaceURI);
    }

    private String invokeGetNamespaceURI(DOMNodePointer domNodePointer) throws Exception {
        // Fixed Line: Replaced 'var' with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("getNamespaceURI");
        method.setAccessible(true);
        return (String) method.invoke(domNodePointer);
    }
}
