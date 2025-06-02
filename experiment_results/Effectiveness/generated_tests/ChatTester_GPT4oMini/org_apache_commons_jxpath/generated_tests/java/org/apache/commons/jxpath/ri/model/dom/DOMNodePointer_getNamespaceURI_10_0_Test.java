package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DOMNodePointer_getNamespaceURI_10_0_Test {

    private DOMNodePointer domNodePointer;

    private Document document;

    private Element rootElement;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        rootElement = document.createElement("root");
        document.appendChild(rootElement);
        Node mockNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.DOCUMENT_NODE);
        domNodePointer = new DOMNodePointer(mockNode, Locale.getDefault());
    }

    @Test
    public void testGetNamespaceURI_WithNullPrefix() {
        // Fixed the ambiguous reference
        String result = domNodePointer.getNamespaceURI((String) null);
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithEmptyPrefix() {
        String result = domNodePointer.getNamespaceURI("");
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithXmlPrefix() {
        String result = domNodePointer.getNamespaceURI("xml");
        assertEquals(DOMNodePointer.XML_NAMESPACE_URI, result);
    }

    @Test
    public void testGetNamespaceURI_WithXmlnsPrefix() {
        String result = domNodePointer.getNamespaceURI("xmlns");
        assertEquals(DOMNodePointer.XMLNS_NAMESPACE_URI, result);
    }

    @Test
    public void testGetNamespaceURI_WithValidCustomPrefix() {
        String prefix = "customPrefix";
        String expectedNamespace = "http://example.com/custom";
        rootElement.setAttribute("xmlns:" + prefix, expectedNamespace);
        String result = domNodePointer.getNamespaceURI(prefix);
        assertEquals(expectedNamespace, result);
    }

    @Test
    public void testGetNamespaceURI_WithUnknownPrefix() {
        String result = domNodePointer.getNamespaceURI("unknownPrefix");
        assertEquals(DOMNodePointer.UNKNOWN_NAMESPACE, result);
    }

    @Test
    public void testGetNamespaceURI_WithEmptyNamespace() {
        String prefix = "emptyPrefix";
        rootElement.setAttribute("xmlns:" + prefix, "");
        String result = domNodePointer.getNamespaceURI(prefix);
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithNullNamespace() {
        String prefix = "nullPrefix";
        rootElement.setAttribute("xmlns:" + prefix, "null");
        String result = domNodePointer.getNamespaceURI(prefix);
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithParentNode() {
        String prefix = "parentPrefix";
        String expectedNamespace = "http://example.com/parent";
        Element parentElement = document.createElement("parent");
        parentElement.setAttribute("xmlns:" + prefix, expectedNamespace);
        rootElement.appendChild(parentElement);
        String result = domNodePointer.getNamespaceURI(prefix);
        assertEquals(expectedNamespace, result);
    }

    @Test
    public void testGetNamespaceURI_WithMultipleLevels() {
        String prefix = "nestedPrefix";
        String expectedNamespace = "http://example.com/nested";
        Element parentElement = document.createElement("parent");
        parentElement.setAttribute("xmlns:" + prefix, expectedNamespace);
        rootElement.appendChild(parentElement);
        Element childElement = document.createElement("child");
        rootElement.appendChild(childElement);
        String result = domNodePointer.getNamespaceURI(prefix);
        assertEquals(expectedNamespace, result);
    }
}
