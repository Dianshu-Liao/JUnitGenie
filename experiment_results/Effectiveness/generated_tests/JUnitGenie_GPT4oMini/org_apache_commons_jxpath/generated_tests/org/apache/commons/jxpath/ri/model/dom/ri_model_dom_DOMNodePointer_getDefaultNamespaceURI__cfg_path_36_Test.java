package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_36_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() {
        // Create a mock Document and Element to test
        Document mockDocument = createMockDocumentWithNamespace("http://example.com");
        DOMNodePointer nodePointer = new DOMNodePointer(mockDocument.getDocumentElement(), null);

        String result = null;
        try {
            result = nodePointer.getDefaultNamespaceURI();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertEquals("http://example.com", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() {
        // Create a mock Document and Element without a namespace
        Document mockDocument = createMockDocumentWithoutNamespace();
        DOMNodePointer nodePointer = new DOMNodePointer(mockDocument.getDocumentElement(), null);

        String result = null;
        try {
            result = nodePointer.getDefaultNamespaceURI();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertEquals(null, result);
    }

    private Document createMockDocumentWithNamespace(String namespace) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS(namespace, "root");
            document.appendChild(root);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Document createMockDocumentWithoutNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}