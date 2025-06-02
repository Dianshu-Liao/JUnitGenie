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

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_15_Test {

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
        NodeList mockNodeList = mock(NodeList.class);
        
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        when(mockNodeList.item(0)).thenReturn(mockChildNode);
        
        // Test with a Node
        domNodePointer.setValue(mockChildNode);
        
        verify(mockNode).removeChild(mockChildNode);
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test(timeout = 4000)
    public void testSetValueWithString() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        // Test with a valid string
        String value = "Another Test Value";
        Text mockTextNode = mock(Text.class);
        when(mockNode.getOwnerDocument().createTextNode(value)).thenReturn(mockTextNode);
        
        domNodePointer.setValue(value);
        
        verify(mockNode).appendChild(mockTextNode);
    }


}