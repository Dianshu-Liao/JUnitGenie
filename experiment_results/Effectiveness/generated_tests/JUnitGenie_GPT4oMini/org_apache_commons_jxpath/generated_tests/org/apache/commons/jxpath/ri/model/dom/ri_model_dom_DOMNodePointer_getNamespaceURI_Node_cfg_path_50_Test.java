package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static org.mockito.Mockito.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertNull;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_50_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI_WithNullPrefix() {
        try {
            // Create a real Document and Element instead of mocking them
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Ensure that Element has no prefix and the necessary attributes
            // No need to mock getNamespaceURI, it will return null by default for a new element
            // Simulate getPrefix() returning null
            DOMNodePointer nodePointer = mock(DOMNodePointer.class);
            when(nodePointer.getPrefix(element)).thenReturn(null);

            // Call the focal method
            String uri = nodePointer.getNamespaceURI(element); // Call the method on the mock

            // Verify that the return value is null
            assertNull(uri);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }


}