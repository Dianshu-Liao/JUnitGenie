package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURI() {
        try {
            // Setup a Document node with a root element having an xmlns attribute
            Document document = createDocumentWithNamespace("http://example.com");
            DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), Locale.getDefault());

            // Test
            String namespaceURI = pointer.getDefaultNamespaceURI();

            // Verification
            assertEquals("http://example.com", namespaceURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURI_NoNamespace() {
        try {
            // Setup a Document node without an xmlns attribute
            Document document = createDocumentWithoutNamespace();
            DOMNodePointer pointer = new DOMNodePointer(document.getDocumentElement(), Locale.getDefault());

            // Test
            String namespaceURI = pointer.getDefaultNamespaceURI();

            // Verification
            assertEquals(null, namespaceURI); // Should return null as per the focal method logic
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Document createDocumentWithNamespace(String namespace) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElementNS(namespace, "root");
        document.appendChild(root);
        return document;
    }

    private Document createDocumentWithoutNamespace() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        return document;
    }

}