package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_50_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() {
        try {
            // Initialize a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create a mock Element node with an "xmlns" attribute
            Element element = document.createElement("testElement");
            element.setAttribute("xmlns", "http://example.com/namespace");
            document.appendChild(element);

            // Create a DOMNodePointer instance with the mock Document
            DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertEquals("http://example.com/namespace", result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() {
        try {
            // Initialize a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create a mock Element node without an "xmlns" attribute
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Create a DOMNodePointer instance with the mock Document
            DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}