package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import org.w3c.dom.DOMImplementation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertNull;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullPrefix() {
        try {
            // Create a DocumentBuilder to create a sample Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create an Element with no prefix
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Call the focal method
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);

            // Assert that the namespace URI is null
            assertNull(namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}