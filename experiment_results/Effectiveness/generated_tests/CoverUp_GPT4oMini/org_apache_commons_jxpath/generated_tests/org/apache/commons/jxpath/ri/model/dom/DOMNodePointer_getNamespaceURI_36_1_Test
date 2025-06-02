package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
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

public class DOMNodePointer_getNamespaceURI_36_1_Test {

    private Document document;

    private Element rootElement;

    private Element childElement;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        // Create a root element with a namespace
        rootElement = document.createElementNS("http://example.com/ns", "ns:Root");
        document.appendChild(rootElement);
        // Create a child element with a namespace
        childElement = document.createElementNS("http://example.com/ns", "ns:Child");
        rootElement.appendChild(childElement);
    }

    @Test
    public void testGetNamespaceURIForElementWithNamespace() {
        String namespaceURI = DOMNodePointer.getNamespaceURI(childElement);
        assertEquals("http://example.com/ns", namespaceURI);
    }

    @Test
    public void testGetNamespaceURIForElementWithoutNamespace() {
        Element noNamespaceElement = document.createElement("NoNamespaceElement");
        rootElement.appendChild(noNamespaceElement);
        String namespaceURI = DOMNodePointer.getNamespaceURI(noNamespaceElement);
        assertNull(namespaceURI);
    }

    @Test
    public void testGetNamespaceURIForDocument() {
        String namespaceURI = DOMNodePointer.getNamespaceURI(document);
        assertEquals("http://example.com/ns", namespaceURI);
    }

    @Test
    public void testGetNamespaceURIForParentNamespace() {
        Element childWithParentNamespace = document.createElementNS("http://example.com/ns", "ns:ChildWithParent");
        rootElement.appendChild(childWithParentNamespace);
        String namespaceURI = DOMNodePointer.getNamespaceURI(childWithParentNamespace);
        assertEquals("http://example.com/ns", namespaceURI);
    }

    @Test
    public void testGetNamespaceURIForEmptyNamespace() {
        Element emptyNamespaceElement = document.createElement("EmptyNamespaceElement");
        emptyNamespaceElement.setAttribute("xmlns", "");
        rootElement.appendChild(emptyNamespaceElement);
        String namespaceURI = DOMNodePointer.getNamespaceURI(emptyNamespaceElement);
        assertNull(namespaceURI);
    }
}
