package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Attr;
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
import org.w3c.dom.Comment;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_getNamespaceURI_4_0_Test {

    private DocumentBuilderFactory factory;

    private DocumentBuilder builder;

    private Document document;

    private DOMNodePointer nodePointer;

    @BeforeEach
    public void setUp() throws Exception {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void testGetNamespaceURI_ElementWithNamespace() {
        Element element = document.createElementNS("http://example.com/ns", "ns:element");
        document.appendChild(element);
        nodePointer = new DOMNodePointer(element, null);
        String namespaceURI = nodePointer.getNamespaceURI();
        assertEquals("http://example.com/ns", namespaceURI);
    }

    @Test
    public void testGetNamespaceURI_ElementWithoutNamespace() {
        Element element = document.createElement("element");
        document.appendChild(element);
        nodePointer = new DOMNodePointer(element, null);
        String namespaceURI = nodePointer.getNamespaceURI();
        assertEquals(null, namespaceURI);
    }

    @Test
    public void testGetNamespaceURI_DocumentRootElement() {
        Element rootElement = document.createElementNS("http://example.com/ns", "ns:root");
        document.appendChild(rootElement);
        nodePointer = new DOMNodePointer(document, null);
        String namespaceURI = nodePointer.getNamespaceURI();
        assertEquals("http://example.com/ns", namespaceURI);
    }

    @Test
    public void testGetNamespaceURI_ElementWithDefaultNamespace() {
        Element element = document.createElement("element");
        element.setAttribute("xmlns", "http://example.com/default");
        document.appendChild(element);
        nodePointer = new DOMNodePointer(element, null);
        String namespaceURI = nodePointer.getNamespaceURI();
        assertEquals("http://example.com/default", namespaceURI);
    }

    @Test
    public void testGetNamespaceURI_ElementWithPrefixNamespace() {
        Element element = document.createElementNS("http://example.com/ns", "ns:element");
        Attr attr = document.createAttribute("xmlns:ns");
        attr.setValue("http://example.com/ns");
        element.setAttributeNode(attr);
        document.appendChild(element);
        nodePointer = new DOMNodePointer(element, null);
        String namespaceURI = nodePointer.getNamespaceURI();
        assertEquals("http://example.com/ns", namespaceURI);
    }

    @Test
    public void testGetNamespaceURI_NestedElementWithNamespace() {
        Element parent = document.createElementNS("http://example.com/ns", "ns:parent");
        Element child = document.createElementNS("http://example.com/ns", "ns:child");
        parent.appendChild(child);
        document.appendChild(parent);
        nodePointer = new DOMNodePointer(child, null);
        String namespaceURI = nodePointer.getNamespaceURI();
        assertEquals("http://example.com/ns", namespaceURI);
    }
}
