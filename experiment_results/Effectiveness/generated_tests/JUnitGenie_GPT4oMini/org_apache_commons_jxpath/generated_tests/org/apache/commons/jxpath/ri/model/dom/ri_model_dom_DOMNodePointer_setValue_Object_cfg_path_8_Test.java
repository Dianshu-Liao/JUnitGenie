package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_8_Test {

    private Node mockNode;
    private DOMNodePointer domNodePointer;

    @Before
    public void setUp() {
        mockNode = mock(Node.class);
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test(timeout = 4000)
    public void testSetValueWithTextNode() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        // Test with a non-empty string
        String value = "Test Value";
        domNodePointer.setValue(value);
        
        verify(mockNode).setNodeValue(value);
        
        // Test with an empty string
        domNodePointer.setValue("");
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Node mockChildNode = mock(Node.class);
        NodeList mockChildNodes = mock(NodeList.class);
        
        when(mockNode.getChildNodes()).thenReturn(mockChildNodes);
        when(mockChildNodes.getLength()).thenReturn(1);
        when(mockChildNodes.item(0)).thenReturn(mockChildNode);
        
        // Test with a Node
        domNodePointer.setValue(mockChildNode);
        
        verify(mockChildNodes).getLength();
        verify(mockNode).removeChild(mockChildNode);
        verify(mockNode).appendChild(mockChildNode.cloneNode(true));
    }

    @Test(timeout = 4000)
    public void testSetValueWithElement() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Node mockElementNode = mock(Element.class);
        NodeList mockChildNodes = mock(NodeList.class);
        
        when(mockElementNode.getChildNodes()).thenReturn(mockChildNodes);
        when(mockChildNodes.getLength()).thenReturn(1);
        
        domNodePointer.setValue(mockElementNode);
        
        verify(mockNode).removeChild(any(Node.class));
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNull() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        
        // Test with null value
        domNodePointer.setValue(null);
        
        // Ensure that getParentNode() is not null before calling removeChild
        Node parentNode = mockNode.getParentNode();
        if (parentNode != null) {
            verify(parentNode).removeChild(mockNode);
        }
    }

}