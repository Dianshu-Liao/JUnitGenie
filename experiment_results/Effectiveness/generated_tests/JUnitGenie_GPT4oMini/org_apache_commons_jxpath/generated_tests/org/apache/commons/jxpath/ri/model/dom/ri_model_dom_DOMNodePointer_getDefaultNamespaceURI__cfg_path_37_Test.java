package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_37_Test {

    private Document createMockDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullDefaultNamespace() {
        try {
            // Create a mock Document and Element
            Document mockDocument = createMockDocument();
            Element mockElement = mockDocument.createElement("root");
            mockDocument.appendChild(mockElement);
            Node mockNode = mockDocument;

            // Instantiate DOMNodePointer with the mock Node
            DOMNodePointer pointer = new DOMNodePointer(mockNode, null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert that the result is null since no xmlns attribute is set
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithEmptyNamespace() {
        try {
            // Create a mock Document and Element with xmlns attribute
            Document mockDocument = createMockDocument();
            Element mockElement = mockDocument.createElement("root");
            mockElement.setAttribute("xmlns", "");
            mockDocument.appendChild(mockElement);
            Node mockNode = mockDocument;

            // Instantiate DOMNodePointer with the mock Node
            DOMNodePointer pointer = new DOMNodePointer(mockNode, null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert that the result is null since the xmlns attribute is empty
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithValidNamespace() {
        try {
            // Create a mock Document and Element with a valid xmlns attribute
            Document mockDocument = createMockDocument();
            Element mockElement = mockDocument.createElement("root");
            mockElement.setAttribute("xmlns", "http://example.com");
            mockDocument.appendChild(mockElement);
            Node mockNode = mockDocument;

            // Instantiate DOMNodePointer with the mock Node
            DOMNodePointer pointer = new DOMNodePointer(mockNode, null);

            // Call the method under test
            String result = pointer.getDefaultNamespaceURI();

            // Assert that the result matches the expected namespace URI
            assertEquals("http://example.com", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}