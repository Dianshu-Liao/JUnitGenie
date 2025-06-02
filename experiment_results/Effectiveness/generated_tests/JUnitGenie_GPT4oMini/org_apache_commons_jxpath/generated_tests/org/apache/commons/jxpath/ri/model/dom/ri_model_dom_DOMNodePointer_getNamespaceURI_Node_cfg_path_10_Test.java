package org.apache.commons.jxpath.ri.model.dom;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocument() {
        try {
            // Create a sample Document with an Element
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS("http://www.example.com", "ex:element");
            document.appendChild(element);
        
            String uri = DOMNodePointer.getNamespaceURI(document);
            assertEquals("http://www.example.com", uri);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementWithNoNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("element");
            document.appendChild(element);
        
            String uri = DOMNodePointer.getNamespaceURI(element);
            assertNull(uri);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementWithEmptyNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS("", "element");
            document.appendChild(element);
        
            String uri = DOMNodePointer.getNamespaceURI(element);
            assertNull(uri);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        }
    }

    // Additional tests can be added to verify different scenarios and edge cases

}