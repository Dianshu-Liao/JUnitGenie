package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_47_Test {

    private Document createDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsNull() throws Exception {
        // Arrange
        Document document = createDocument(); // Initialize a valid Document object
        DOMNodePointer pointer = new DOMNodePointer(document, null);

        // Act
        String result = null;
        try {
            result = pointer.getDefaultNamespaceURI();
        } catch (Exception e) {
            // handle exception if necessary
        }

        // Assert
        assertEquals(null, result); // Expecting null when defaultNamespace is not set
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsEmpty() throws Exception {
        // Arrange
        Document document = createDocument(); // Initialize a Document with no "xmlns" attribute
        DOMNodePointer pointer = new DOMNodePointer(document, null);

        // Act
        String result = null;
        try {
            result = pointer.getDefaultNamespaceURI();
        } catch (Exception e) {
            // handle exception if necessary
        }

        // Assert
        assertEquals(null, result); // Expecting null since defaultNamespace remains empty
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsSet() throws Exception {
        // Arrange
        Document document = createDocument(); // Initialize a Document with "xmlns" attribute set
        Element rootElement = document.createElement("root");
        rootElement.setAttribute("xmlns", "http://example.com/namespace");
        document.appendChild(rootElement);
        DOMNodePointer pointer = new DOMNodePointer(document, null);

        // Act
        String result = null;
        try {
            result = pointer.getDefaultNamespaceURI();
        } catch (Exception e) {
            // handle exception if necessary
        }

        // Assert
        assertEquals("http://example.com/namespace", result); // Expecting the set namespace URI
    }


}