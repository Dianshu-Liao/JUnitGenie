package org.apache.commons.jxpath.ri.model.dom;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI_NonNullURI() {
        try {
            // Create a sample DOM Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            // Create an element with a namespace
            Element element = doc.createElementNS("http://example.com/ns", "ns:element");
            doc.appendChild(element);
            
            // Test the getNamespaceURI method
            String uri = DOMNodePointer.getNamespaceURI(element);
            assertEquals("http://example.com/ns", uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_NullURI() {
        try {
            // Create a sample DOM Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            // Create an element without a namespace
            Element element = doc.createElement("element");
            doc.appendChild(element);

            // Test the getNamespaceURI method
            String uri = DOMNodePointer.getNamespaceURI(element);
            assertEquals(null, uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Additional test methods can be added to cover more cases as needed

}