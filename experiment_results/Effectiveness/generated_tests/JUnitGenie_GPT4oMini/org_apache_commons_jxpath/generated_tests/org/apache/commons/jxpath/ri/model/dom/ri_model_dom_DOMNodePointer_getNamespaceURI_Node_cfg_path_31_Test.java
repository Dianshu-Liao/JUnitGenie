package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI_withElementNode() {
        try {
            // Arrange
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS("http://example.com/ns", "prefix:localName");
            document.appendChild(element);

            // Act
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);

            // Assert
            assertEquals("http://example.com/ns", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_withDocumentNode() {
        try {
            // Arrange
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS("http://example.com/ns", "prefix:localName");
            document.appendChild(element);

            // Act
            String namespaceURI = DOMNodePointer.getNamespaceURI(document);

            // Assert
            assertEquals("http://example.com/ns", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_noNamespace() {
        try {
            // Arrange
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("localName");
            document.appendChild(element);

            // Act
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);

            // Assert
            assertEquals(null, namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}