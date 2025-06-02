package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_17_Test {

    private DOMNodePointer domNodePointer;
    private Node mockNode;

    @Before
    public void setUp() {
        // Create a mock Node (element) to be used in the test
        mockNode = mock(Element.class);
        
        // Initialize the DOMNodePointer with the mock Node and a default Locale
        domNodePointer = new DOMNodePointer(mockNode, Locale.getDefault());
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDefaultNamespaceIsNull() {
        // Set up the mock behavior
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(((Element) mockNode).getAttributeNode("xmlns")).thenReturn(null);
        when(mockNode.getParentNode()).thenReturn(null); // No parent to traverse
        
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenDocument() {
        // Set up a mock Document node and its behavior
        Document mockDocument = mock(Document.class);
        Element mockElement = mock(Element.class);
        Node mockParentNode = mock(Element.class); // Change to Element to avoid ClassCastException
        
        when(mockNode.getNodeType()).thenReturn(Node.DOCUMENT_NODE);
        when(mockDocument.getDocumentElement()).thenReturn(mockElement);
        when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockElement.getAttributeNode("xmlns")).thenReturn(null);
        when(mockElement.getParentNode()).thenReturn(mockParentNode);
        when(mockParentNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(((Element) mockParentNode).getAttributeNode("xmlns")).thenReturn(mock(Attr.class)); // Simulating presence of attribute
        when(((Attr) ((Element) mockParentNode).getAttributeNode("xmlns")).getValue()).thenReturn("http://example.com");
        
        // Assign the mock Document to the node
        domNodePointer = new DOMNodePointer(mockParentNode, Locale.getDefault()); // Use a valid constructor
        
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNotNull(result);
        assertEquals("http://example.com", result);
    }
    
    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenEmptyNamespace() {
        // Set up the mock behavior
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(((Element) mockNode).getAttributeNode("xmlns")).thenReturn(null);
        when(mockNode.getParentNode()).thenReturn(null); // No parent
        
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("", result);
    }

}