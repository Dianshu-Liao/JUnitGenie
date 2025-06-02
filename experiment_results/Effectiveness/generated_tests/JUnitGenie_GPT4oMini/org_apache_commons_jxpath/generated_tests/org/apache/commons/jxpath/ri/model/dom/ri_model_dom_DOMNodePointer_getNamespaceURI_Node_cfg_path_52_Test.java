package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertNull;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_52_Test {
    
    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullPrefix() {
        try {
            // Setup: create a mock element node without a prefix
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument(); // Initialize a DOM Document with a root element
            Element element = document.createElement("example");
            element.setAttribute("xmlns", "http://example.com");
            document.appendChild(element);

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);

            // Assert the result
            assertNull(result); // Since prefix is null, we expect the uri to be returned as null

        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}