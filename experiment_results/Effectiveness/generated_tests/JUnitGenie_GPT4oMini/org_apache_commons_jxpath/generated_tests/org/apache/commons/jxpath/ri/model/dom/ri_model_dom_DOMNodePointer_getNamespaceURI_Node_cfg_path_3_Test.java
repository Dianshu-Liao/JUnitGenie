package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementHavingNoNamespace() {
        try {
            // Create a mock Element with no namespace
            Document document = createMockDocument();
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);

            // Assert that the result is null since there is no namespace
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementHavingNamespace() {
        try {
            // Create a mock Document and Element with a namespace
            Document document = createMockDocument();
            Element element = document.createElementNS("http://example.com/ns", "testElement");
            document.appendChild(element);

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);

            // Assert that the result matches the expected namespace URI
            assertEquals("http://example.com/ns", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createMockDocument() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // In case of an error, return null
        }
    }

}