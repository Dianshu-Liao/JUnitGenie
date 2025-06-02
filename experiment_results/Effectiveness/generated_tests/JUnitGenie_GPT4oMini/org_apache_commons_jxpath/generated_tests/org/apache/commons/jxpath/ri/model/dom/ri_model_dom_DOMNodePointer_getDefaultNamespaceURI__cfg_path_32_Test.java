package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_32_Test {

    private Document createDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() throws Exception {
        // Setup a mock Node (Element) with an xmlns attribute
        Document document = createDocument(); // Create a Document instance
        Element element = document.createElement("testElement");
        element.setAttribute("xmlns", "http://example.com/namespace");
        document.appendChild(element);
        
        // Create a DOMNodePointer instance
        DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), (Locale) null);
        
        // Execute the method under test
        String result = pointer.getDefaultNamespaceURI();
        
        // Verify the result
        assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() throws Exception {
        // Setup a mock Node (Element) without an xmlns attribute
        Document document = createDocument(); // Create a Document instance
        Element element = document.createElement("testElement");
        document.appendChild(element);
        
        // Create a DOMNodePointer instance
        DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), (Locale) null);
        
        // Execute the method under test
        String result = pointer.getDefaultNamespaceURI();
        
        // Verify the result
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullNode() {
        // Create a DOMNodePointer instance with a null node
        DOMNodePointer pointer = new DOMNodePointer((Node) null, (Locale) null);
        
        // Execute the method under test
        String result = pointer.getDefaultNamespaceURI();
        
        // Verify the result
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithEmptyNamespace() throws Exception {
        // Setup a mock Node (Element) with an empty xmlns attribute
        Document document = createDocument(); // Create a Document instance
        Element element = document.createElement("testElement");
        element.setAttribute("xmlns", "");
        document.appendChild(element);
        
        // Create a DOMNodePointer instance
        DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), (Locale) null);
        
        // Execute the method under test
        String result = pointer.getDefaultNamespaceURI();
        
        // Verify the result
        assertNull(result);
    }

}