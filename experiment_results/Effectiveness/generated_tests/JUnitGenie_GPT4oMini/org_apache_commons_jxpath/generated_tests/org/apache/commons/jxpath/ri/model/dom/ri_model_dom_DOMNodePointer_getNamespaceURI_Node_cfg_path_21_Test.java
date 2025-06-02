package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocumentWithElement("testPrefix", "testNamespace");
            String namespaceURI = DOMNodePointer.getNamespaceURI(document.getDocumentElement());
            assertEquals("testNamespace", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        try {
            // Create a mock Element
            Element element = createMockElement("testPrefix", "testNamespace");
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);
            assertEquals("testNamespace", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullURI() {
        try {
            // Create a mock Element with no namespace
            Element element = createMockElementWithNoNamespace();
            String namespaceURI = DOMNodePointer.getNamespaceURI(element);
            assertEquals(null, namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createMockDocumentWithElement(String prefix, String namespace) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS(namespace, prefix + ":root");
            document.appendChild(root);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Element createMockElement(String prefix, String namespace) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS(namespace, prefix + ":element");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Element createMockElementWithNoNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("element");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}