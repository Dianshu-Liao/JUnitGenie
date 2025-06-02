package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_41_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithValidNode() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocument();
            Element element = document.createElement("testElement");
            element.setAttribute("xmlns:testPrefix", "http://example.com/test");

            // Append the element to the document
            document.appendChild(element);

            // Call the focal method
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);

            // Assert the expected namespace URI
            assertEquals("http://example.com/test", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createMockDocument() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument(); // Create a new empty Document
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }

}