package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI_withDocumentNode() {
        try {
            // Mocking a Document and Element setup
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument(); // Initialize your Document
            Element element = document.createElement("testElement");
            document.appendChild(element);
            String expectedURI = "http://example.com"; // Set expected URI properly

            // Here we can create a DOMNodePointer if needed but we are focusing on the static method
            String actualURI = DOMNodePointer.getNamespaceURI(document);
            assertEquals(expectedURI, actualURI);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_withElementNode() {
        try {
            // Mocking an Element setup
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument(); // Initialize your Document
            Element element = document.createElement("testElement");
            document.appendChild(element);
            element.setAttribute("xmlns", "http://example.com"); // Adding an attribute to simulate namespace

            String expectedURI = "http://example.com";
            String actualURI = DOMNodePointer.getNamespaceURI(element);
            assertEquals(expectedURI, actualURI);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_noNamespace() {
        try {
            // Mocking an Element without a namespace
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument(); // Initialize your Document
            Element element = document.createElement("testElement"); // Initialize your Element without a namespace

            String actualURI = DOMNodePointer.getNamespaceURI(element);
            assertEquals(null, actualURI);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }


}