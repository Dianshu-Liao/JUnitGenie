package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() {
        try {
            // Mocking a Document and its Element
            Document mockDocument = mock(Document.class);
            Element mockElement = mock(Element.class);
            Attr mockAttr = mock(Attr.class);

            // Setting up the mock behavior
            when(mockDocument.getDocumentElement()).thenReturn(mockElement);
            when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
            when(mockElement.getAttributeNode("xmlns")).thenReturn(mockAttr);
            when(mockAttr.getValue()).thenReturn("http://www.example.com");

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(mockElement, (Locale) null); // Specify Locale to resolve ambiguity

            // Call the focal method
            String result = pointer.getDefaultNamespaceURI();

            // Validate the result
            assertEquals("http://www.example.com", result);
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() {
        try {
            // Mocking a Document with no namespace
            Document mockDocument = mock(Document.class);
            Element mockElement = mock(Element.class);

            // Setting up the mock behavior
            when(mockDocument.getDocumentElement()).thenReturn(mockElement);
            when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
            when(mockElement.getAttributeNode("xmlns")).thenReturn(null);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(mockElement, (Locale) null); // Specify Locale to resolve ambiguity

            // Call the focal method
            String result = pointer.getDefaultNamespaceURI();

            // Validate the result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullDocument() {
        try {
            // Create an instance of DOMNodePointer with null node
            DOMNodePointer pointer = new DOMNodePointer((Node) null, (Locale) null); // Specify Node and Locale to resolve ambiguity

            // Call the focal method
            String result = pointer.getDefaultNamespaceURI();

            // Validate the result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}