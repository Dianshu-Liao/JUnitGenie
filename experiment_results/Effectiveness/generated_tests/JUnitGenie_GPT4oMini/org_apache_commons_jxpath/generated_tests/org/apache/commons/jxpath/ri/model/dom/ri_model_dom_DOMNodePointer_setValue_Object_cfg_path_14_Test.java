package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_14_Test {

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

        try {
            domNodePointer.setValue(value);
            verify(mockNode).setNodeValue("Test Value");
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        Object value = "";

        try {
            domNodePointer.setValue(value);
            verify(mockNode.getParentNode()).removeChild(mockNode);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        Node childNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(childNode.cloneNode(true)).thenReturn(childNode);
        when(childNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mock(NodeList.class));
        when(mockNode.getChildNodes().getLength()).thenReturn(1);
        when(mockNode.getChildNodes().item(0)).thenReturn(childNode);

        try {
            domNodePointer.setValue(childNode);
            verify(mockNode).appendChild(childNode.cloneNode(true));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithString() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Object value = "Another Test Value";

        try {
            domNodePointer.setValue(value);
            verify(mockNode).appendChild(any(Node.class));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}