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

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocumentWithNamespace("http://example.com/ns", "prefix");
            Node node = document;

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals("http://example.com/ns", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        try {
            // Create a mock Element with a namespace
            Element element = createMockElementWithNamespace("http://example.com/ns", "prefix");
            Node node = element;

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals("http://example.com/ns", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNoNamespace() {
        try {
            // Create a mock Element without a namespace
            Element element = createMockElementWithoutNamespace();
            Node node = element;

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createMockDocumentWithNamespace(String namespaceURI, String prefix) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS(namespaceURI, prefix + ":root");
            document.appendChild(root);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Element createMockElementWithNamespace(String namespaceURI, String prefix) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS(namespaceURI, prefix + ":element");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Element createMockElementWithoutNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("element");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}