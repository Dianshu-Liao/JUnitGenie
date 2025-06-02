package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
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

public class DOMNodePointer_setValue_21_0_Test {

    @Mock
    private Node mockNode;

    @Mock
    private Document mockDocument;

    @Mock
    private Element mockElement;

    @Mock
    private NodeList mockNodeList;

    @Mock
    private Node mockChildNode;

    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test
    public void testSetValue_TextNode_NonEmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(TypeUtils.convert("Test", String.class)).thenReturn("Test");
        domNodePointer.setValue("Test");
        verify(mockNode).setNodeValue("Test");
    }

    @Test
    public void testSetValue_TextNode_EmptyString() {
        when(mockNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(TypeUtils.convert("", String.class)).thenReturn("");
        domNodePointer.setValue("");
        verify(mockNode.getParentNode()).removeChild(mockNode);
    }

    @Test
    public void testSetValue_ElementNode() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(0);
        when(mockChildNode.cloneNode(true)).thenReturn(mockChildNode);
        when(mockNode.appendChild(mockChildNode)).thenReturn(mockChildNode);
        domNodePointer.setValue(mockChildNode);
        verify(mockNode).appendChild(mockChildNode);
    }

    @Test
    public void testSetValue_DocumentNode() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(0);
        when(mockDocument.getChildNodes()).thenReturn(mockNodeList);
        when(mockNode.appendChild(any(Node.class))).thenReturn(mockChildNode);
        when(mockChildNode.cloneNode(true)).thenReturn(mockChildNode);
        domNodePointer.setValue(mockDocument);
        verify(mockNode).appendChild(mockChildNode);
    }

    @Test
    public void testSetValue_NonNodeValue() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getChildNodes()).thenReturn(mockNodeList);
        when(mockNodeList.getLength()).thenReturn(0);
        when(TypeUtils.convert("Non-empty string", String.class)).thenReturn("Non-empty string");
        domNodePointer.setValue("Non-empty string");
        verify(mockNode).appendChild(any(Node.class));
    }
}
