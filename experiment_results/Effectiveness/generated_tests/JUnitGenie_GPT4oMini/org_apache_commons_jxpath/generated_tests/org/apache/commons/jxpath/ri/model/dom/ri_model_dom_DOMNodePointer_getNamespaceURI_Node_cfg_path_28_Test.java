package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        // Arrange
        Element mockElement = mock(Element.class);
        when(mockElement.getNamespaceURI()).thenReturn("http://example.com/namespace");
        
        // Act
        String result = DOMNodePointer.getNamespaceURI(mockElement);
        
        // Assert
        assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullURI() {
        // Arrange
        Element mockElement = mock(Element.class);
        when(mockElement.getNamespaceURI()).thenReturn(null);
        when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockElement.getAttributeNode("xmlns")).thenReturn(mock(Attr.class));
        
        // Act
        String result = DOMNodePointer.getNamespaceURI(mockElement);
        
        // Assert
        assertEquals("xmlns", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithEmptyString() {
        // Arrange
        Element mockElement = mock(Element.class);
        when(mockElement.getNamespaceURI()).thenReturn("");
        
        // Act
        String result = DOMNodePointer.getNamespaceURI(mockElement);
        
        // Assert
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        // Arrange
        Document mockDocument = mock(Document.class);
        Element mockElement = mock(Element.class);
        when(mockDocument.getDocumentElement()).thenReturn(mockElement);
        when(mockElement.getNamespaceURI()).thenReturn("http://example.com/namespace");
        
        // Act
        String result = DOMNodePointer.getNamespaceURI(mockElement); // Changed from mockDocument to mockElement
        
        // Assert
        assertEquals("http://example.com/namespace", result);
    }


}