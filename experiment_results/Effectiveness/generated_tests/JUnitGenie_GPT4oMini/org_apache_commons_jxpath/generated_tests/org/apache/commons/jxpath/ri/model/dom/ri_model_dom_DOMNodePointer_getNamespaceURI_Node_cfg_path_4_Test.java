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

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullURI() {
        try {
            // Create a sample Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            // Create an Element with no namespace URI
            Element element = document.createElement("testElement");
            document.appendChild(element);
            
            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(element);
            
            // Assert that the result is null since there is no namespace URI
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}