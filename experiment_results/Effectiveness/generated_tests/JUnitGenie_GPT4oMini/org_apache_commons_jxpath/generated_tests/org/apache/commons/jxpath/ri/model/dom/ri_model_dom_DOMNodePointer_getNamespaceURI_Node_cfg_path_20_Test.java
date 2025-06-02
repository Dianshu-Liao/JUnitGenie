package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocumentWithElement("testPrefix", "http://example.com");
            Node node = document;

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals("http://example.com", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        try {
            // Create a mock Element
            Element element = createMockElement("testPrefix", "http://example.com");

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);

            // Assert the expected result
            assertEquals("http://example.com", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullURI() {
        try {
            // Create a mock Element with no namespace
            Element element = createMockElementWithNoNamespace("testPrefix");

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);

            // Assert the expected result
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper methods to create mock Document and Element
    private Document createMockDocumentWithElement(String prefix, String uri) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS(uri, prefix + ":testElement");
            document.appendChild(element);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Element createMockElement(String prefix, String uri) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS(uri, prefix + ":testElement");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Element createMockElementWithNoNamespace(String prefix) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement(prefix + ":testElement");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}