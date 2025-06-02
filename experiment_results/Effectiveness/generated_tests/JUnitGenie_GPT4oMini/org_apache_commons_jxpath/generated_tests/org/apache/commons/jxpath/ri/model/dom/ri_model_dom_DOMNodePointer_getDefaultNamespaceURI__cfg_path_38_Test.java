package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_38_Test {

    private Document createDocumentWithNamespace(String namespaceURI) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElementNS(namespaceURI, "root");
        document.appendChild(root);
        return document;
    }

    private Document createDocumentWithoutNamespace() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        return document;
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() throws Exception {
        // Setup
        Document document = createDocumentWithNamespace("http://example.com/namespace");
        Node node = document.getDocumentElement();
        DOMNodePointer pointer = new DOMNodePointer(node, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNotNull(result);
        assertEquals("http://example.com/namespace", result); // Replace with the expected namespace URI
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() throws Exception {
        // Setup
        Document document = createDocumentWithoutNamespace();
        Node node = document.getDocumentElement();
        DOMNodePointer pointer = new DOMNodePointer(node, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullNode() {
        // Setup
        Node nullNode = null;
        DOMNodePointer pointer = new DOMNodePointer(nullNode, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithParentNode() throws Exception {
        // Setup
        Document document = createDocumentWithNamespace("http://example.com/parentNamespace");
        Node node = document.getDocumentElement().getParentNode();
        DOMNodePointer pointer = new DOMNodePointer(node, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNotNull(result);
        assertEquals("http://example.com/parentNamespace", result); // Replace with the expected parent namespace URI
    }


}