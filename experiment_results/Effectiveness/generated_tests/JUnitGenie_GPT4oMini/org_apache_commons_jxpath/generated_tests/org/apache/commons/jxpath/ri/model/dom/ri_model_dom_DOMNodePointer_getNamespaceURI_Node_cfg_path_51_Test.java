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
import static org.junit.Assert.assertNull;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_51_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullPrefix() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocument();
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);

            // Assert that the result is null since getPrefix() should return null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createMockDocument() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument(); // Create and return a new Document object
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }

}