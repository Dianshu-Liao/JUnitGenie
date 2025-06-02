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

public class DOMNodePointer_getDefaultNamespaceURI_11_0_Test {

    private DOMNodePointer pointer;

    @BeforeEach
    public void setUp() throws Exception {
        // Creating a sample XML Document for testing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        // Creating a root element with a default namespace
        Element root = document.createElementNS("http://example.com/default", "root");
        document.appendChild(root);
        // Setting up the DOMNodePointer with the document element
        // Adjusted constructor
        pointer = new DOMNodePointer(document, null, null);
    }

    @Test
    public void testGetDefaultNamespaceURI_NoNamespace() {
        // Create a new document without a default namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            // Adjusted constructor
            pointer = new DOMNodePointer(document, null, null);
            // Assert that the default namespace URI is null
            assertNull(pointer.getDefaultNamespaceURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDefaultNamespaceURI_WithNamespace() {
        // Create a new document with a default namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS("http://example.com/default", "root");
            document.appendChild(root);
            // Adjusted constructor
            pointer = new DOMNodePointer(document, null, null);
            // Assert that the default namespace URI is as expected
            assertEquals("http://example.com/default", pointer.getDefaultNamespaceURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDefaultNamespaceURI_WithParentNamespace() {
        // Create a new document with a root and a child element with a namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            // Creating a child element with a namespace
            Element child = document.createElementNS("http://example.com/child", "child");
            root.appendChild(child);
            // Adjusted constructor
            pointer = new DOMNodePointer(document, null, null);
            // Assert that the default namespace URI is null
            assertNull(pointer.getDefaultNamespaceURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
