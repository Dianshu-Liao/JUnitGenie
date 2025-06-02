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

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_9_Test {

    private DOMNodePointer domNodePointer;
    private Node mockNode;

    @Before
    public void setUp() {
        // Create a mock Node object
        mockNode = mock(Node.class);
        // Initialize DOMNodePointer with the mock Node
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test(timeout = 4000)
    public void testSetValueWithTextNode() {
        // Setup the mock behavior for a TEXT_NODE
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getOwnerDocument()).thenReturn(mock(Document.class));
        
        // Test with a non-empty string
        String value = "Test Value";
        domNodePointer.setValue(value);
        
        // Verify that the node's value is set correctly
        verify(mockNode).setNodeValue(value);
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        // Setup the mock behavior for a TEXT_NODE
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mock(Node.class));
        
        // Test with an empty string
        String value = "";
        domNodePointer.setValue(value);
        
        // Verify that the node is removed from its parent
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        // Setup the mock behavior for a non-text node
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Node childNode = mock(Node.class);
        NodeList mockNodeList = mock(NodeList.class);
        
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        when(mockNodeList.item(0)).thenReturn(childNode);
        
        // Test with a Node
        domNodePointer.setValue(childNode);
        
        // Verify that the child node is appended
        verify(mockNode).appendChild(childNode.cloneNode(true));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonNodeValue() {
        // Setup the mock behavior for a non-text node
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Document mockDocument = mock(Document.class);
        when(mockNode.getOwnerDocument()).thenReturn(mockDocument);
        
        // Test with a non-node value
        String value = "Another Test Value";
        domNodePointer.setValue(value);
        
        // Verify that a text node is created and appended
        Text mockTextNode = mock(Text.class);
        when(mockDocument.createTextNode(value)).thenReturn(mockTextNode);
        verify(mockDocument).createTextNode(value);
        verify(mockNode).appendChild(mockTextNode);
    }


}