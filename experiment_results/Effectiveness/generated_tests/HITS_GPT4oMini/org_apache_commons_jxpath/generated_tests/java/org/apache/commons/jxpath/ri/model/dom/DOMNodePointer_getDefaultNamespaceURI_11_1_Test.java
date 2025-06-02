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

public class DOMNodePointer_getDefaultNamespaceURI_11_1_Test {

    private DOMNodePointer domNodePointer;

    private Document document;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void testGetDefaultNamespaceURI_NullDefaultNamespace_DocumentNode() {
        // Setup: Create a document with a root element without a namespace
        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);
        // Pass root element
        domNodePointer = new DOMNodePointer(rootElement, Locale.getDefault());
        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();
        // Verify
        assertNull(result, "Expected null for default namespace URI when none is set.");
    }

    @Test
    public void testGetDefaultNamespaceURI_NullDefaultNamespace_ParentWithNamespace() {
        // Setup: Create a document with a root element and a namespace
        Element rootElement = document.createElement("root");
        rootElement.setAttribute("xmlns", "http://example.com/ns");
        document.appendChild(rootElement);
        // Pass root element
        domNodePointer = new DOMNodePointer(rootElement, Locale.getDefault());
        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();
        // Verify
        assertEquals("http://example.com/ns", result, "Expected the correct default namespace URI from the root element.");
    }

    @Test
    public void testGetDefaultNamespaceURI_NullDefaultNamespace_ParentWithoutNamespace() {
        // Setup: Create a document with a nested structure
        Element rootElement = document.createElement("root");
        Element childElement = document.createElement("child");
        rootElement.appendChild(childElement);
        document.appendChild(rootElement);
        // Pass root element
        domNodePointer = new DOMNodePointer(rootElement, Locale.getDefault());
        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();
        // Verify
        assertNull(result, "Expected null for default namespace URI when none is set.");
    }

    @Test
    public void testGetDefaultNamespaceURI_SetDefaultNamespace() {
        // Setup: Create a document with a root element and a namespace
        Element rootElement = document.createElement("root");
        rootElement.setAttribute("xmlns", "http://example.com/ns");
        document.appendChild(rootElement);
        // Pass root element
        domNodePointer = new DOMNodePointer(rootElement, Locale.getDefault());
        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();
        // Verify
        assertEquals("http://example.com/ns", result, "Expected the correct default namespace URI from the root element.");
    }

    @Test
    public void testGetDefaultNamespaceURI_DeepHierarchy() {
        // Setup: Create a document with a deep hierarchy of elements
        Element rootElement = document.createElement("root");
        Element childElement = document.createElement("child");
        childElement.setAttribute("xmlns", "http://example.com/ns");
        rootElement.appendChild(childElement);
        document.appendChild(rootElement);
        // Pass child element
        domNodePointer = new DOMNodePointer(childElement, Locale.getDefault());
        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();
    }
}
