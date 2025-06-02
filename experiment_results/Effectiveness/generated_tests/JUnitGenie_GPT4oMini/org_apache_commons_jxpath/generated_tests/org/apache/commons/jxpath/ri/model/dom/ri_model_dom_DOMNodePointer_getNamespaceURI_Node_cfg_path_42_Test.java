package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_42_Test {
    
    private Element mockElementNode; // Changed from Node to Element
    private Document mockDocumentNode;

    @Before
    public void setUp() {
        // Set up a mock Document to return a mock Element as its document element
        mockDocumentNode = mock(Document.class);
        mockElementNode = mock(Element.class);
        when(mockDocumentNode.getDocumentElement()).thenReturn(mockElementNode);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_whenNodeIsDocument_returnsElementNamespaceURI() {
        // Given
        when(mockElementNode.getNamespaceURI()).thenReturn("http://example.com/namespace");
        
        // When
        String result = DOMNodePointer.getNamespaceURI(mockDocumentNode);
        
        // Then
        Assert.assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_whenNamespaceURIIsNullAndPrefixIsNotNull() {
        // Given
        String prefix = "examplePrefix";
        when(mockElementNode.getNamespaceURI()).thenReturn(null);
        when(DOMNodePointer.getPrefix(mockElementNode)).thenReturn(prefix);
        when(mockElementNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        
        // Mocking the attribute node
        Attr mockAttr = mock(Attr.class);
        when(mockElementNode.getAttributeNode("xmlns:" + prefix)).thenReturn(mockAttr);
        when(mockAttr.getValue()).thenReturn("http://example.com/namespace");

        // When
        String result = DOMNodePointer.getNamespaceURI(mockElementNode);

        // Then
        Assert.assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_whenNamespaceURIIsNullAndPrefixIsNull() {
        // Given
        when(mockElementNode.getNamespaceURI()).thenReturn(null);
        when(DOMNodePointer.getPrefix(mockElementNode)).thenReturn(null);
        
        // When
        String result = DOMNodePointer.getNamespaceURI(mockElementNode);
        
        // Then
        Assert.assertNull(result);
    }


}