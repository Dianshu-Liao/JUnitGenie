package org.apache.commons.jxpath.ri.model.dom;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_getNamespaceURI_10_0_Test {

    private Document document;

    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        // Create a sample XML structure
        Element root = document.createElement("root");
        document.appendChild(root);
        Element child = document.createElement("child");
        child.setAttribute("xmlns:test", "http://example.com/test");
        root.appendChild(child);
        domNodePointer = new DOMNodePointer(root, null);
    }

    @Test
    public void testGetNamespaceURIWithNullPrefix() {
        String namespaceURI = domNodePointer.getNamespaceURI((String) null);
        assertEquals(domNodePointer.getDefaultNamespaceURI(), namespaceURI);
    }

    @Test
    public void testGetNamespaceURIWithEmptyPrefix() {
        String namespaceURI = domNodePointer.getNamespaceURI("");
        assertEquals(domNodePointer.getDefaultNamespaceURI(), namespaceURI);
    }

    @Test
    public void testGetNamespaceURIWithXmlPrefix() {
        String namespaceURI = domNodePointer.getNamespaceURI("xml");
        assertEquals(DOMNodePointer.XML_NAMESPACE_URI, namespaceURI);
    }

    @Test
    public void testGetNamespaceURIWithXmlnsPrefix() {
        String namespaceURI = domNodePointer.getNamespaceURI("xmlns");
        assertEquals(DOMNodePointer.XMLNS_NAMESPACE_URI, namespaceURI);
    }

    @Test
    public void testGetNamespaceURIWithCustomPrefix() {
        String namespaceURI = domNodePointer.getNamespaceURI("test");
        assertEquals("http://example.com/test", namespaceURI);
    }

    @Test
    public void testGetNamespaceURIWithUnknownPrefix() {
        String namespaceURI = domNodePointer.getNamespaceURI("unknown");
        assertNull(namespaceURI);
    }

    @Test
    public void testGetNamespaceURICaching() {
        // First call to cache the namespace
        String namespaceURIFirstCall = domNodePointer.getNamespaceURI("test");
        // Second call should return the cached value
        String namespaceURISecondCall = domNodePointer.getNamespaceURI("test");
        assertEquals(namespaceURIFirstCall, namespaceURISecondCall);
    }

    @Test
    public void testGetNamespaceURIWithParentNode() throws Exception {
        // Create a new child element with a namespace
        Element childWithNamespace = document.createElement("childWithNamespace");
        childWithNamespace.setAttribute("xmlns:test", "http://example.com/parent");
        document.getDocumentElement().appendChild(childWithNamespace);
        // Create a new DOMNodePointer for the child with namespace
        DOMNodePointer childPointer = new DOMNodePointer(childWithNamespace, null);
        String namespaceURI = childPointer.getNamespaceURI("test");
        assertEquals("http://example.com/parent", namespaceURI);
    }
}
