package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_getNamespaceURI_36_0_Test {

    private DocumentBuilderFactory factory;

    private DocumentBuilder builder;

    private Document document;

    @BeforeEach
    public void setUp() throws Exception {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void testGetNamespaceURI_EmptyNamespace() {
        Element element = document.createElement("testElement");
        document.appendChild(element);
        String uri = DOMNodePointer.getNamespaceURI(element);
        assertNull(uri, "Namespace URI should be null for an element with no namespace.");
    }

    @Test
    public void testGetNamespaceURI_WithNamespace() {
        Element element = document.createElementNS("http://example.com/ns", "testElement");
        document.appendChild(element);
        String uri = DOMNodePointer.getNamespaceURI(element);
        assertEquals("http://example.com/ns", uri, "Namespace URI should match the defined namespace.");
    }

    @Test
    public void testGetNamespaceURI_WithDefaultNamespace() {
        Element root = document.createElementNS("http://example.com/ns", "root");
        document.appendChild(root);
        Element child = document.createElement("child");
        root.appendChild(child);
        String uri = DOMNodePointer.getNamespaceURI(child);
        assertEquals("http://example.com/ns", uri, "Namespace URI should inherit the default namespace from the parent.");
    }

    @Test
    public void testGetNamespaceURI_WithPrefixNamespace() {
        Element root = document.createElementNS("http://example.com/ns", "ns:root");
        document.appendChild(root);
        Element child = document.createElement("ns:child");
        root.appendChild(child);
        String uri = DOMNodePointer.getNamespaceURI(child);
        assertEquals("http://example.com/ns", uri, "Namespace URI should match the prefix namespace.");
    }

    @Test
    public void testGetNamespaceURI_WithInheritedNamespace() {
        Element root = document.createElementNS("http://example.com/ns", "root");
        document.appendChild(root);
        Element child = document.createElement("child");
        root.appendChild(child);
        Element grandChild = document.createElement("grandChild");
        child.appendChild(grandChild);
        String uri = DOMNodePointer.getNamespaceURI(grandChild);
        assertEquals("http://example.com/ns", uri, "Namespace URI should inherit from the ancestor.");
    }

    @Test
    public void testGetNamespaceURI_WithNamespaceDeclaration() {
        Element root = document.createElement("root");
        root.setAttribute("xmlns:ns", "http://example.com/ns");
        document.appendChild(root);
        Element child = document.createElement("ns:child");
        root.appendChild(child);
        String uri = DOMNodePointer.getNamespaceURI(child);
        assertEquals("http://example.com/ns", uri, "Namespace URI should match the declared namespace.");
    }

    @Test
    public void testGetNamespaceURI_WithEmptyStringNamespace() {
        Element root = document.createElementNS("http://example.com/ns", "root");
        document.appendChild(root);
        Element child = document.createElement("child");
        child.setAttribute("xmlns", "");
        root.appendChild(child);
        String uri = DOMNodePointer.getNamespaceURI(child);
        assertNull(uri, "Namespace URI should be null for an empty string namespace.");
    }
}
