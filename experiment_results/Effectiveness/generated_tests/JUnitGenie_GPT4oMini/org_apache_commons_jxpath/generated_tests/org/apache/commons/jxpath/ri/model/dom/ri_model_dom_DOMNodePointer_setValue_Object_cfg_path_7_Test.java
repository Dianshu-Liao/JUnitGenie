package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_7_Test {

    private Node mockNode;
    private DOMNodePointer domNodePointer;

    @Before
    public void setUp() {
        mockNode = mock(Node.class);
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        // Arrange
        Node childNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mock(NodeList.class));
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        when(childNode.cloneNode(true)).thenReturn(childNode);
        
        // Act
        domNodePointer.setValue(childNode);
        
        // Assert
        verify(mockNode).appendChild(childNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithString() {
        // Arrange
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        // Act
        domNodePointer.setValue("Test String");
        
        // Assert
        verify(mockNode).setNodeValue("Test String");
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        // Arrange
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mock(Node.class));
        
        // Act
        domNodePointer.setValue("");
        
        // Assert
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNullString() {
        // Arrange
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mock(Node.class));
        
        // Act
        domNodePointer.setValue(null);
        
        // Assert
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

}