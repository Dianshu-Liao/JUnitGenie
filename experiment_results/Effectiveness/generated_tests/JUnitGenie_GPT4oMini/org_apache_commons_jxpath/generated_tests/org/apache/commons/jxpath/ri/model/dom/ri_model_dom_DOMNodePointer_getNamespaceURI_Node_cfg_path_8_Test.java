package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithValidNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS("http://example.com/ns", "ns:root");
            document.appendChild(root);
            Attr attr = document.createAttribute("xmlns:ns");
            attr.setValue("http://example.com/ns");
            root.setAttributeNode(attr);

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(root);

            // Assert the expected result
            assertEquals("http://example.com/ns", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullURI() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(root);

            // Assert the expected result
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}