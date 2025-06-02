package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMNamespaceIterator;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;

class DOMNamespaceIterator_collectNamespaces_0_0_Test {

    private DOMNamespaceIterator iterator;

    private NodePointer parentNodePointer;

    private Document document;

    @BeforeEach
    void setUp() throws Exception {
        // Set up a sample XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        // Create an element with some attributes
        Element root = document.createElement("root");
        root.setAttribute("xmlns", "http://example.com");
        root.setAttribute("xmlns:ns", "http://namespace.com");
        document.appendChild(root);
        // Create a NodePointer for the root element
        parentNodePointer = new DOMNodePointer(root, null);
        // Create the DOMNamespaceIterator instance
        iterator = new DOMNamespaceIterator(parentNodePointer);
    }

    @Test
    void testCollectNamespaces() throws Exception {
        // Prepare the attributes list
        List<Attr> attributes = new ArrayList<>();
        // Use reflection to invoke the private method collectNamespaces
        Method method = DOMNamespaceIterator.class.getDeclaredMethod("collectNamespaces", List.class, Node.class);
        method.setAccessible(true);
        // Call the method with the root node
        method.invoke(iterator, attributes, document.getDocumentElement());
        // Assert that the attributes list contains the expected namespaces
        assertEquals(2, attributes.size());
        assertEquals("http://example.com", attributes.get(0).getValue());
        assertEquals("http://namespace.com", attributes.get(1).getValue());
    }

    @Test
    void testCollectNamespacesWithNoNamespaces() throws Exception {
        // Create an empty document
        Document emptyDocument = document.getImplementation().createDocument(null, "empty", null);
        NodePointer emptyNodePointer = new DOMNodePointer(emptyDocument.getDocumentElement(), null);
        DOMNamespaceIterator emptyIterator = new DOMNamespaceIterator(emptyNodePointer);
        // Prepare the attributes list
        List<Attr> attributes = new ArrayList<>();
        // Use reflection to invoke the private method collectNamespaces
        Method method = DOMNamespaceIterator.class.getDeclaredMethod("collectNamespaces", List.class, Node.class);
        method.setAccessible(true);
        // Call the method with the empty node
        method.invoke(emptyIterator, attributes, emptyDocument.getDocumentElement());
        // Assert that the attributes list is empty
        assertTrue(attributes.isEmpty());
    }

    @Test
    void testCollectNamespacesWithParentNode() throws Exception {
        // Create a parent node with a namespace
        Element parent = document.createElement("parent");
        parent.setAttribute("xmlns", "http://parent.com");
        document.appendChild(parent);
        parent.appendChild(document.getDocumentElement());
        // Create a NodePointer for the child element
        NodePointer childNodePointer = new DOMNodePointer(document.getDocumentElement(), null);
        DOMNamespaceIterator childIterator = new DOMNamespaceIterator(childNodePointer);
        // Prepare the attributes list
        List<Attr> attributes = new ArrayList<>();
        // Use reflection to invoke the private method collectNamespaces
        Method method = DOMNamespaceIterator.class.getDeclaredMethod("collectNamespaces", List.class, Node.class);
        method.setAccessible(true);
        // Call the method with the child node
        method.invoke(childIterator, attributes, document.getDocumentElement());
        // Assert that the attributes list contains the expected namespaces
        assertEquals(2, attributes.size());
        assertEquals("http://parent.com", attributes.get(0).getValue());
        assertEquals("http://example.com", attributes.get(1).getValue());
    }
}
