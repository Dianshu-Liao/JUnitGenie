package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_19_Test {

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

        // Ensure that the parent node is not null before calling removeChild
        Node parentNode = mockNode.getParentNode();
        if (parentNode != null) {
            verify(parentNode).removeChild(mockNode);
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Node childNode = mock(Node.class);
        when(childNode.cloneNode(true)).thenReturn(childNode);
        NodeList mockNodeList = mock(NodeList.class);
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        when(mockNodeList.item(0)).thenReturn(childNode);

        domNodePointer.setValue(childNode);

        verify(mockNode).appendChild(childNode.cloneNode(true));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Object value = "Another Test Value";

        domNodePointer.setValue(value);

        Node textNode = mock(Node.class);
        Document mockDocument = mock(Document.class);
        when(mockNode.getOwnerDocument()).thenReturn(mockDocument);
        when(mockDocument.createTextNode("Another Test Value")).thenReturn((org.w3c.dom.Text) textNode);
        verify(mockNode).appendChild(textNode);
    }


}