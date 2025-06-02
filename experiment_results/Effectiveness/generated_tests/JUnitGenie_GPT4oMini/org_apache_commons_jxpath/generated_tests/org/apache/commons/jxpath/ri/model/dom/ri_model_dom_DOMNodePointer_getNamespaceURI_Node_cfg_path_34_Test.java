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

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_34_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithValidNode() {
        try {
            // Create a sample Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            // Create an element with a namespace
            Element element = document.createElementNS("http://example.com/ns", "ex:element");
            document.appendChild(element);
            
            // Test the getNamespaceURI method
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);
            assertEquals("http://example.com/ns", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNamespace() {
        try {
            // Create a sample Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            // Create an element without a namespace
            Element element = document.createElement("element");
            document.appendChild(element);
            
            // Test the getNamespaceURI method
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);
            assertEquals(null, namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        try {
            // Create a sample Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            // Create an element with a namespace
            Element element = document.createElementNS("http://example.com/ns", "ex:element");
            document.appendChild(element);
            
            // Test the getNamespaceURI method with Document node
            String namespaceURI = DOMNodePointer.getNamespaceURI(document);
            assertEquals("http://example.com/ns", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}