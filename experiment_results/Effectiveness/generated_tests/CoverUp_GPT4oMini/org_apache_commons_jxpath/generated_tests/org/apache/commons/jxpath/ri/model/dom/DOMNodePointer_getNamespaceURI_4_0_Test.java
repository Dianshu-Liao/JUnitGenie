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

class DOMNodePointer_getNamespaceURI_4_0_Test {

    private Document document;

    private DOMNodePointer elementPointer;

    private DOMNodePointer documentPointer;

    @BeforeEach
    void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        Element rootElement = document.createElementNS("http://example.com/ns", "root");
        document.appendChild(rootElement);
        Element childElement = document.createElementNS("http://example.com/ns", "child");
        rootElement.appendChild(childElement);
        elementPointer = new DOMNodePointer(childElement, null);
        documentPointer = new DOMNodePointer(document, null);
    }

    @Test
    void testGetNamespaceURI_ElementWithNamespace() {
        String expectedNamespaceURI = "http://example.com/ns";
        String actualNamespaceURI = elementPointer.getNamespaceURI();
        assertEquals(expectedNamespaceURI, actualNamespaceURI);
    }

    @Test
    void testGetNamespaceURI_DocumentElement() {
        String expectedNamespaceURI = "http://example.com/ns";
        String actualNamespaceURI = documentPointer.getNamespaceURI();
        assertEquals(expectedNamespaceURI, actualNamespaceURI);
    }

    @Test
    void testGetNamespaceURI_NoNamespace() throws Exception {
        Element noNamespaceElement = document.createElement("noNamespace");
        document.getDocumentElement().appendChild(noNamespaceElement);
        DOMNodePointer noNamespacePointer = new DOMNodePointer(noNamespaceElement, null);
        String actualNamespaceURI = noNamespacePointer.getNamespaceURI();
        assertNull(actualNamespaceURI);
    }

    @Test
    void testGetNamespaceURI_EmptyNamespace() throws Exception {
        Element emptyNamespaceElement = document.createElementNS("", "emptyNamespace");
        document.getDocumentElement().appendChild(emptyNamespaceElement);
        DOMNodePointer emptyNamespacePointer = new DOMNodePointer(emptyNamespaceElement, null);
        String actualNamespaceURI = emptyNamespacePointer.getNamespaceURI();
        assertNull(actualNamespaceURI);
    }
}
