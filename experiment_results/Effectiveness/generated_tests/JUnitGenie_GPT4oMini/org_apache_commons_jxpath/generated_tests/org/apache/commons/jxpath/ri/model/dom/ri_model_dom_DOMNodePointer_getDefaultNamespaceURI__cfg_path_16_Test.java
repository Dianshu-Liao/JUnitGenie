package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_16_Test {
    private DOMNodePointer nodePointer;
    private Document document;

    @Before
    public void setUp() throws Exception {
        // Initialize the document and the required nodes as per the test case
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument(); // Create a new Document instance
        nodePointer = new DOMNodePointer(document, null); // Assuming Locale and String are null for this test
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsNull() {
        // Invoke the method and check the return value
        String result = nodePointer.getDefaultNamespaceURI();
        
        // Assert that the result is null, as defaultNamespace is not set
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenNamespaceExists() {
        // Create an element with xmlns attribute
        Element rootElement = document.createElement("root");
        rootElement.setAttribute("xmlns", "http://example.com/namespace");
        document.appendChild(rootElement);
        
        nodePointer = new DOMNodePointer(rootElement, null); // Resetting pointer to the new root element

        // Invoke the method
        String result = nodePointer.getDefaultNamespaceURI();
        
        // Assert that the result is the expected namespace
        assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenNoNamespaceIsFound() {
        // Create an element without xmlns attribute
        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);
        
        nodePointer = new DOMNodePointer(rootElement, null); // Resetting pointer to the new root element

        // Invoke the method
        String result = nodePointer.getDefaultNamespaceURI();
        
        // Assert that the result is null as no namespace was found
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenParentHasNamespace() {
        // Create a parent element with an xmlns attribute and a child without it
        Element parentElement = document.createElement("parent");
        parentElement.setAttribute("xmlns", "http://example.com/parentnamespace");
        document.appendChild(parentElement);
        
        Element childElement = document.createElement("child");
        parentElement.appendChild(childElement);

        nodePointer = new DOMNodePointer(childElement, null); // Pointing to child element

        // Invoke the method
        String result = nodePointer.getDefaultNamespaceURI();
        
        // Assert that the result is the parent's namespace
        assertEquals("http://example.com/parentnamespace", result);
    }

}