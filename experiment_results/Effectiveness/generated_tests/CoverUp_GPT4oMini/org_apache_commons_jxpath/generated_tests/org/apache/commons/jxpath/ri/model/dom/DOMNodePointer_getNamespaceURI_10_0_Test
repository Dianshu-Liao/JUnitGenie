package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

class DOMNodePointer_getNamespaceURI_10_0_Test {

    private DOMNodePointer domNodePointer;

    private Document document;

    @BeforeEach
    void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        // Create an element with namespaces
        Element root = document.createElementNS("http://example.com/ns", "ns:root");
        root.setAttribute("xmlns:ns", "http://example.com/ns");
        root.setAttribute("xmlns:xml", "http://www.w3.org/XML/1998/namespace");
        document.appendChild(root);
        // Initialize DOMNodePointer
        domNodePointer = new DOMNodePointer(document, null);
    }

    @Test
    void testGetNamespaceURIWithNullPrefix() {
        String result = invokeGetNamespaceURI(null);
        assertEquals(domNodePointer.getDefaultNamespaceURI(), result);
    }

    @Test
    void testGetNamespaceURIWithEmptyPrefix() {
        String result = invokeGetNamespaceURI("");
        assertEquals(domNodePointer.getDefaultNamespaceURI(), result);
    }

    @Test
    void testGetNamespaceURIWithXmlPrefix() {
        String result = invokeGetNamespaceURI("xml");
        assertEquals(DOMNodePointer.XML_NAMESPACE_URI, result);
    }

    @Test
    void testGetNamespaceURIWithXmlnsPrefix() {
        String result = invokeGetNamespaceURI("xmlns");
        assertEquals(DOMNodePointer.XMLNS_NAMESPACE_URI, result);
    }

    @Test
    void testGetNamespaceURIWithCustomPrefix() {
        String result = invokeGetNamespaceURI("ns");
        assertEquals("http://example.com/ns", result);
    }

    @Test
    void testGetNamespaceURIWithUnknownPrefix() {
        String result = invokeGetNamespaceURI("unknown");
        assertNull(result);
    }

    @Test
    void testGetNamespaceURICaching() {
        // Call the method twice with the same prefix to test caching
        String resultFirstCall = invokeGetNamespaceURI("ns");
        String resultSecondCall = invokeGetNamespaceURI("ns");
        assertEquals(resultFirstCall, resultSecondCall);
    }

    private String invokeGetNamespaceURI(String prefix) {
        try {
            Method method = DOMNodePointer.class.getDeclaredMethod("getNamespaceURI", String.class);
            method.setAccessible(true);
            return (String) method.invoke(domNodePointer, prefix);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
