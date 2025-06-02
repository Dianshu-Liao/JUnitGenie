package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NodeList;
import static org.junit.Assert.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() throws Exception {
        // Create a mock Document and Element
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Create root element
        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);
        
        // Initialize the expected Element to test
        String expectedURI = "http://example.com/namespace"; // Example expected namespace URI
        Attr attr = document.createAttribute("xmlns");
        attr.setValue(expectedURI);
        rootElement.setAttributeNode(attr);
        
        // Call the focal method
        String namespaceURI = DOMNodePointer.getNamespaceURI(rootElement);
        
        // Validate the result
        assertEquals(expectedURI, namespaceURI);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() throws Exception {
        // Create a mock Document and Element node
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Create an element with a namespace
        String expectedPrefix = "ex";
        String expectedURI = "http://example.com/namespace"; // Example expected namespace URI
        Element element = document.createElementNS(expectedURI, expectedPrefix + ":element");
        document.appendChild(element);
        
        // Call the focal method
        String namespaceURI = DOMNodePointer.getNamespaceURI(element);
        
        // Validate the result
        assertEquals(expectedURI, namespaceURI);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNode() {
        // Call the focal method with null
        try {
            String namespaceURI = DOMNodePointer.getNamespaceURI((Node) null); // Cast to Node to resolve ambiguity
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException); // Expecting a NullPointerException
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithEmptyURI() throws Exception {
        // Create a mock Document and Element node with no namespace
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Create an element without a namespace
        Element element = document.createElement("element");
        document.appendChild(element);
        
        // Call the focal method
        String namespaceURI = DOMNodePointer.getNamespaceURI(element);
        
        // Validate the result
        assertNull(namespaceURI); // Expecting null since there's no namespace
    }

}