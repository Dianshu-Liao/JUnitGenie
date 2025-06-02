package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsNull() throws Exception {
        // Setup
        Node mockNode = createMockNodeWithNoNamespace();
        DOMNodePointer domNodePointer = new DOMNodePointer(mockNode, null);

        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsEmpty() throws Exception {
        // Setup
        Node mockNode = createMockNodeWithEmptyNamespace();
        DOMNodePointer domNodePointer = new DOMNodePointer(mockNode, null);

        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();

        // Verify
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsPresent() throws Exception {
        // Setup
        Node mockNode = createMockNodeWithNamespace("http://example.com/namespace");
        DOMNodePointer domNodePointer = new DOMNodePointer(mockNode, null);

        // Execute
        String result = domNodePointer.getDefaultNamespaceURI();

        // Verify
        assertEquals("http://example.com/namespace", result);
    }

    private Node createMockNodeWithNoNamespace() throws Exception {
        // Create a mock Node that simulates a Document without a namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        return document;
    }

    private Node createMockNodeWithEmptyNamespace() throws Exception {
        // Create a mock Node that simulates a Document with an empty namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("root");
        document.appendChild(element);
        return document;
    }

    private Node createMockNodeWithNamespace(String namespace) throws Exception {
        // Create a mock Node that simulates a Document with a specific namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("root");
        Attr attr = document.createAttribute("xmlns");
        attr.setValue(namespace);
        element.setAttributeNode(attr);
        document.appendChild(element);
        return document;
    }


}