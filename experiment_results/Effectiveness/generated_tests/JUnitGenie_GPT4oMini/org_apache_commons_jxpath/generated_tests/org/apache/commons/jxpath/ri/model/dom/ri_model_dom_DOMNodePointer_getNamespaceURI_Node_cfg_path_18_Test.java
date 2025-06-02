package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Attr;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument(); // Create a new Document
            String result = DOMNodePointer.getNamespaceURI(doc); // Changed Node to String
            // Add assertions based on the expected namespace URI for a Document Node
            assertEquals("expectedNamespaceURI", result);
        } catch (Exception e) {
            // Handle exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element element = doc.createElement("testElement"); // Create a new Element
            String result = DOMNodePointer.getNamespaceURI(element); // Changed Node to String
            assertEquals("expectedNamespaceURI", result);
        } catch (Exception e) {
            // Handle exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithoutNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element element = doc.createElement("testElement"); // Create a new Element
            String result = DOMNodePointer.getNamespaceURI(element); // Changed Node to String
            assertNull(result);
        } catch (Exception e) {
            // Handle exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithParentNodeContainingNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Node parent = doc.createElement("parentElement"); // Create a new parent Element
            Node child = doc.createElement("childElement"); // Create a new child Element
            parent.appendChild(child); // Ensure child is part of the parent's hierarchy

            String result = DOMNodePointer.getNamespaceURI(child); // Changed Node to String
            assertEquals("expectedNamespaceURIFromParent", result);
        } catch (Exception e) {
            // Handle exception as needed
        }
    }

}