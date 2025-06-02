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

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithValidDocument() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocumentWithNamespace("http://example.com/ns");
            Node node = document.getDocumentElement();

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals("http://example.com/ns", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNamespace() {
        try {
            // Create a mock Document and Element without a namespace
            Document document = createMockDocumentWithoutNamespace();
            Node node = document.getDocumentElement();

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
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