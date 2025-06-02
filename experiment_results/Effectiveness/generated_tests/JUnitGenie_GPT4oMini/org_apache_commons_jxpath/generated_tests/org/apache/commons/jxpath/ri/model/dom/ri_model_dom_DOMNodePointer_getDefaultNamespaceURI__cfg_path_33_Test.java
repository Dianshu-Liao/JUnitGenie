package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_33_Test {

    private Document createDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() {
        try {
            // Create a mock Element node with an "xmlns" attribute
            Document document = createDocument(); // Initialize a Document object
            Element element = document.createElement("testElement");
            element.setAttribute("xmlns", "http://example.com/namespace");
            document.appendChild(element);

            // Create a DOMNodePointer instance
            DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), (Locale) null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertEquals("http://example.com/namespace", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() {
        try {
            // Create a mock Element node without an "xmlns" attribute
            Document document = createDocument(); // Initialize a Document object
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Create a DOMNodePointer instance
            DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), (Locale) null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullNode() {
        try {
            // Create a DOMNodePointer instance with a null node
            DOMNodePointer pointer = new DOMNodePointer((Node) null, (Locale) null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}