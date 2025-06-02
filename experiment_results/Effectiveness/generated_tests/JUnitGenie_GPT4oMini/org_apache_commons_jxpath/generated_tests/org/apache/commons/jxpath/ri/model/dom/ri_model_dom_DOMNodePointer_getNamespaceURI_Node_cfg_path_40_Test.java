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

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            root.setAttribute("xmlns:prefix", "http://example.com");
            document.appendChild(root);

            // Test the focal method
            String namespaceURI = DOMNodePointer.getNamespaceURI(root);
            assertEquals("http://example.com", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}