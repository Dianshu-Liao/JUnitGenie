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

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocumentWithNamespace("http://example.com/ns");
            Node node = document.getDocumentElement(); // Get the root element

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals("http://example.com/ns", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createMockDocumentWithNamespace(String namespaceURI) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create an element with the specified namespace
            Element rootElement = document.createElementNS(namespaceURI, "root");
            document.appendChild(rootElement);

            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle exception appropriately
        }
    }

}