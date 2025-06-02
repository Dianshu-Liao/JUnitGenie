package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static org.junit.Assert.assertNull;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI_withElementHavingNoNamespace() {
        try {
            // Create a new Document
            Document doc = createDocumentWithElement("root", null);
            // Call the focal method with the root element as parameter
            String result = DOMNodePointer.getNamespaceURI(doc.getDocumentElement());
            // Assert that the result is null since there is no namespace
            assertNull(result);
        } catch (Exception e) {
            // Handle any exceptions that might have occurred
            e.printStackTrace();
        }
    }

    private Document createDocumentWithElement(String elementName, String namespaceURI) {
        // Method to create a Document and populate it with an Element
        // This method should be implemented to return a Document with a specified element 
        // and the namespace URI could be set dynamically.
        // For testing purpose, we assume a suitable Document is returned.
        // Here is a simple implementation using a DocumentBuilderFactory
        try {
            javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element element = doc.createElementNS(namespaceURI, elementName);
            doc.appendChild(element);
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }

    // Additional test cases can go here

}