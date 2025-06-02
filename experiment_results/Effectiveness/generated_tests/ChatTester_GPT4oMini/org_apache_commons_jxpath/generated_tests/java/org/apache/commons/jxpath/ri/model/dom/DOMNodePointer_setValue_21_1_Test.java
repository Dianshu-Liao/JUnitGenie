package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.TypeUtils;

public class DOMNodePointer_setValue_21_1_Test {

    @Mock
    private Node mockNode;

    @Mock
    private Node mockChildNode;

    @Mock
    private Document mockDocument;

    @InjectMocks
    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockNode.getOwnerDocument()).thenReturn(mockDocument);
    }

    @Test
    public void testSetValueWithTextNode() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mockChildNode);
        domNodePointer.setValue("New Value");
        verify(mockNode).setNodeValue("New Value");
    }

    @Test
    public void testSetValueWithEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getParentNode()).thenReturn(mockChildNode);
        domNodePointer.setValue("");
        verify(mockChildNode).removeChild(mockNode);
    }

    @Test
    public void testSetValueWithCDATASectionNode() {
        when(mockNode.getNodeType()).thenReturn(Node.CDATA_SECTION_NODE);
        when(mockNode.getParentNode()).thenReturn(mockChildNode);
        domNodePointer.setValue("New CDATA Value");
        verify(mockNode).setNodeValue("New CDATA Value");
    }

    @Test
    public void testSetValueWithNode() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockChildNode.getChildNodes()).thenReturn(mock(NodeList.class));
        when(mockChildNode.getChildNodes().getLength()).thenReturn(1);
        when(mockChildNode.getChildNodes().item(0)).thenReturn(mockChildNode);
        when(mockNode.getOwnerDocument()).thenReturn(mockDocument);
        Node mockNewNode = mock(Element.class);
        when(mockNewNode.getChildNodes()).thenReturn(mock(NodeList.class));
        when(mockNewNode.getChildNodes().getLength()).thenReturn(0);
        domNodePointer.setValue(mockNewNode);
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test
    public void testSetValueWithString() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        domNodePointer.setValue("Some String");
        verify(mockDocument).createTextNode("Some String");
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test
    public void testSetValueWithNullValue() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        domNodePointer.setValue(null);
        verify(mockDocument, never()).createTextNode(anyString());
        verify(mockNode, never()).appendChild(any(Node.class));
    }

    @Test
    public void testSetValueWithNonNodeValue() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        domNodePointer.setValue("Another String");
        verify(mockDocument).createTextNode("Another String");
        verify(mockNode).appendChild(any(Node.class));
    }

    @Test
    public void testSetValueWithNodeIncludingChildren() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Node mockNewNodeWithChildren = mock(Element.class);
        NodeList mockChildNodeList = mock(NodeList.class);
        when(mockNewNodeWithChildren.getChildNodes()).thenReturn(mockChildNodeList);
        when(mockChildNodeList.getLength()).thenReturn(2);
        when(mockChildNodeList.item(0)).thenReturn(mockChildNode);
        when(mockChildNodeList.item(1)).thenReturn(mockChildNode);
        domNodePointer.setValue(mockNewNodeWithChildren);
        verify(mockNode, times(2)).appendChild(any(Node.class));
    }
}
