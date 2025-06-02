package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURI() {
        try {
            // Setup the mock objects
            Document mockDocument = mock(Document.class);
            Element mockElement = mock(Element.class);
            Attr mockAttr = mock(Attr.class);
            
            // Set up the hierarchy: Document -> Element
            when(mockDocument.getDocumentElement()).thenReturn(mockElement);
            when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
            when(mockElement.getAttributeNode("xmlns")).thenReturn(mockAttr);
            when(mockAttr.getValue()).thenReturn("http://example.com/ns");

            // Instantiate DOMNodePointer with the mock Document as node
            DOMNodePointer nodePointer = new DOMNodePointer(mockDocument, null);

            // Call the method under test
            String result = nodePointer.getDefaultNamespaceURI();

            // Validate the result
            assert "http://example.com/ns".equals(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURI_NoNamespace() {
        try {
            // Setup the mock object
            Document mockDocument = mock(Document.class);
            Element mockElement = mock(Element.class);
            
            // Set up the hierarchy: Document -> Element
            when(mockDocument.getDocumentElement()).thenReturn(mockElement);
            when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
            when(mockElement.getAttributeNode("xmlns")).thenReturn(null);

            // Instantiate DOMNodePointer with the mock Document as node
            DOMNodePointer nodePointer = new DOMNodePointer(mockDocument, null);

            // Call the method under test
            String result = nodePointer.getDefaultNamespaceURI();

            // Validate the result for no namespace case
            assert result == null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURI_EmptyNamespace() {
        try {
            // Setup the mock objects
            Document mockDocument = mock(Document.class);
            Element mockElement = mock(Element.class);
            Attr mockAttr = mock(Attr.class);
            
            // Set up the hierarchy: Document -> Element
            when(mockDocument.getDocumentElement()).thenReturn(mockElement);
            when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
            when(mockElement.getAttributeNode("xmlns")).thenReturn(mockAttr);
            when(mockAttr.getValue()).thenReturn("");

            // Instantiate DOMNodePointer with the mock Document as node
            DOMNodePointer nodePointer = new DOMNodePointer(mockDocument, null);

            // Call the method under test
            String result = nodePointer.getDefaultNamespaceURI();

            // Validate the result for empty namespace case
            assert result == null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}