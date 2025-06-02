package org.apache.commons.jxpath.ri.model.dom;
import static org.junit.Assert.assertEquals;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_46_Test {

    private DOMNodePointer pointer;
    private Document document;

    @Before
    public void setUp() throws Exception {
        // Prepare a context with a Document and a namespace
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        document = dBuilder.newDocument();

        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);
        
        // Add xmlns attribute to the root element to simulate a namespace
        Attr xmlnsAttr = document.createAttribute("xmlns");
        xmlnsAttr.setValue("http://example.com/namespace");
        rootElement.setAttributeNode(xmlnsAttr);

        // Create the DOMNodePointer with our document's root
        pointer = new DOMNodePointer(document.getDocumentElement(), null);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURI() {
        // Test to check if the default namespace URI is retrieved correctly
        String result = pointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURINoNamespace() {
        // Remove the xmlns attribute to test the case where no namespace exists
        document.getDocumentElement().removeAttribute("xmlns");
        
        String result = pointer.getDefaultNamespaceURI();
        assertEquals(null, result);
    }

}