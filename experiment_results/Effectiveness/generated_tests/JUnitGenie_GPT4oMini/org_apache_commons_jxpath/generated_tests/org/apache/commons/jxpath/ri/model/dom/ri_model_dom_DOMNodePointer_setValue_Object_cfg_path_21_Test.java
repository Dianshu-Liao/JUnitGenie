package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_21_Test {

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
        Node valueNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        NodeList mockNodeList = mock(NodeList.class);
        when(valueNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(1);
        when(mockNodeList.item(0)).thenReturn(mock(Node.class));

        // Act
        domNodePointer.setValue(valueNode);

        // Assert
        verify(mockNode).appendChild(any(Node.class));
    }

}