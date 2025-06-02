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
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_30_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementHavingPrefix() throws Exception {
        // Create a mock Document and Element
        Document document = createMockDocumentWithElement("prefix", "http://example.com");
        Node elementNode = document.getDocumentElement();

        // Call the focal method
        String namespaceURI = DOMNodePointer.getNamespaceURI(elementNode);

        // Assert the expected namespace URI
        assertEquals("http://example.com", namespaceURI);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementWithoutPrefix() throws Exception {
        // Create a mock Document and Element without prefix
        Document document = createMockDocumentWithoutElementPrefix();
        Node elementNode = document.getDocumentElement();

        // Call the focal method
        String namespaceURI = DOMNodePointer.getNamespaceURI(elementNode);

        // Assert the expected namespace URI
        assertEquals(null, namespaceURI);
    }

    private Document createMockDocumentWithElement(String prefix, String uri) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        // Create an element with a prefix and namespace URI
        Element element = document.createElementNS(uri, prefix + ":element");
        document.appendChild(element);
        return document;
    }

    private Document createMockDocumentWithoutElementPrefix() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        // Create an element without a prefix
        Element element = document.createElementNS("http://example.com", "element");
        document.appendChild(element);
        return document;
    }

}