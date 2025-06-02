package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_1_Test {

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
        
        Object value = "Test Value";
        domNodePointer.setValue(value);
        
        verify(mockNode).setNodeValue("Test Value");
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mock(Node.class));
        
        Object value = "";
        domNodePointer.setValue(value);
        
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        Node childNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mock(NodeList.class));
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        Object value = childNode;
        domNodePointer.setValue(value);
        
        verify(mockNode).appendChild(childNode.cloneNode(true));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonNodeValue() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mock(NodeList.class));
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        Object value = "Another Test Value";
        domNodePointer.setValue(value);
        
        Text textNode = mock(Text.class);
        when(mockNode.getOwnerDocument().createTextNode("Another Test Value")).thenReturn(textNode);
        verify(mockNode).appendChild(textNode);
    }

}