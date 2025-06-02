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
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_39_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementHavingNamespace() {
        try {
            // Create a DocumentBuilder to build a sample XML Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create an element with a namespace
            Element element = document.createElementNS("http://example.com/ns", "ex:element");
            document.appendChild(element);

            // Call the focal method
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);

            // Assert the expected namespace URI
            assertEquals("http://example.com/ns", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementWithoutNamespace() {
        try {
            // Create a DocumentBuilder to build a sample XML Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create an element without a namespace
            Element element = document.createElement("element");
            document.appendChild(element);

            // Call the focal method
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);

            // Assert the expected namespace URI is null
            assertEquals(null, namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocument() {
        try {
            // Create a DocumentBuilder to build a sample XML Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create an element and append it to the document
            Element element = document.createElement("element");
            document.appendChild(element);

            // Call the focal method with the Document
            String namespaceURI = DOMNodePointer.getNamespaceURI(document);

            // Assert the expected namespace URI is null
            assertEquals(null, namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}