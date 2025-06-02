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

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_17_Test {

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
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Node childNode = mock(Element.class);
        when(childNode.cloneNode(true)).thenReturn(childNode);
        NodeList mockNodeList = mock(NodeList.class);
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        when(mockNodeList.item(0)).thenReturn(childNode);
        
        Object value = childNode;
        domNodePointer.setValue(value);
        
        verify(mockNode).appendChild(childNode.cloneNode(true));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Document mockDocument = mock(Document.class);
        when(mockNode.getOwnerDocument()).thenReturn(mockDocument);
        when(mockDocument.createTextNode("Test String")).thenReturn(mock(Text.class));
        
        Object value = "Test String";
        domNodePointer.setValue(value);
        
        verify(mockNode).appendChild(any(Text.class));
    }


}