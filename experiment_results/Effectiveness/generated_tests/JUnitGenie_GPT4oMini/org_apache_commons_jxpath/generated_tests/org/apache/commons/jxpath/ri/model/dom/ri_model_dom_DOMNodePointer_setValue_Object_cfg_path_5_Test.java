package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_5_Test {
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
        Object value = "Test Value";
        domNodePointer.setValue(value);
        verify(mockNode).setNodeValue("Test Value");
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        Object value = "";
        domNodePointer.setValue(value);
        verify(mockNode).setNodeValue(""); // Corrected to setNodeValue for empty string
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        Node childNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(childNode.cloneNode(true)).thenReturn(childNode);
        when(childNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        NodeList mockNodeList = mock(NodeList.class);
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        when(mockNodeList.item(0)).thenReturn(childNode);
        
        domNodePointer.setValue(childNode);
        verify(mockNode).appendChild(childNode);
    }

    @Test(timeout = 4000)
    public void testSetValueWithDocument() {
        Document mockDocument = mock(Document.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        NodeList mockNodeList = mock(NodeList.class);
        when(mockDocument.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        
        domNodePointer.setValue(mockDocument);
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonStringAndNonNode() {
        Object value = 123; // Non-string and non-node value
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        domNodePointer.setValue(value);
        verify(mockNode).appendChild(any(Node.class));
    }

}