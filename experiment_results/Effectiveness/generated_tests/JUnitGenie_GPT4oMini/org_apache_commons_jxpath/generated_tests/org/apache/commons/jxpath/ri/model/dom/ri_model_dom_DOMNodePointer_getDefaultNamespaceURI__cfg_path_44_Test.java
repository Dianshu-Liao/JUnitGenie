package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_44_Test {

    private Document createDocumentWithNamespace(String namespace) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("root");
        if (namespace != null) {
            rootElement.setAttribute("xmlns", namespace);
        }
        document.appendChild(rootElement);
        return document;
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() throws Exception {
        // Setup
        Document document = createDocumentWithNamespace("http://example.com/namespace");
        DOMNodePointer pointer = new DOMNodePointer(document, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() throws Exception {
        // Setup
        Document document = createDocumentWithNamespace(null);
        DOMNodePointer pointer = new DOMNodePointer(document, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullNode() {
        // Setup
        DOMNodePointer pointer = new DOMNodePointer((NodePointer) null, null); // Cast to NodePointer to resolve ambiguity

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithEmptyNamespace() throws Exception {
        // Setup
        Document document = createDocumentWithNamespace("");
        DOMNodePointer pointer = new DOMNodePointer(document, null);

        // Execute
        String result = pointer.getDefaultNamespaceURI();

        // Verify
        assertNull(result);
    }


}