package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_22_Test {

    private Node mockNode;
    private DOMNodePointer domNodePointer;

    @Before
    public void setUp() {
        mockNode = mock(Node.class);
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonEmptyString() {
        String value = "Test Value";
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        domNodePointer.setValue(value);
        
        verify(mockNode).setNodeValue(value);
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        String value = "";
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mock(Node.class));
        
        domNodePointer.setValue(value);
        
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        Node valueNode = mock(Element.class);
        NodeList mockChildNodes = mock(NodeList.class);
        when(mockChildNodes.getLength()).thenReturn(1);
        when(mockChildNodes.item(0)).thenReturn(mock(Node.class));
        when(valueNode.getChildNodes()).thenReturn(mockChildNodes);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class)); // Ensure owner document is set
        
        domNodePointer.setValue(valueNode);
        
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNull() {
        domNodePointer.setValue(null);
        
        // No specific behavior to verify, but we ensure it doesn't throw an exception
    }


}