package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Node;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DOMNodePointer_getRelativePositionOfTextNode_30_0_Test {

    private DOMNodePointer domNodePointer;

    private Node mockNode;

    @BeforeEach
    public void setUp() {
        mockNode = mock(Node.class);
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
    }

    @Test
    public void testGetRelativePositionOfTextNode_NoPreviousSiblings() throws Exception {
        when(mockNode.getPreviousSibling()).thenReturn(null);
        int position = invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(1, position);
    }

    @Test
    public void testGetRelativePositionOfTextNode_OneTextNode() throws Exception {
        Node textNode = mock(Node.class);
        when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(textNode);
        int position = invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(2, position);
    }

    @Test
    public void testGetRelativePositionOfTextNode_MixedNodes() throws Exception {
        Node cdataNode = mock(Node.class);
        when(cdataNode.getNodeType()).thenReturn(Node.CDATA_SECTION_NODE);
        Node textNode = mock(Node.class);
        when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        Node nonTextNode = mock(Node.class);
        when(nonTextNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(nonTextNode);
        when(nonTextNode.getPreviousSibling()).thenReturn(textNode);
        when(textNode.getPreviousSibling()).thenReturn(cdataNode);
        when(cdataNode.getPreviousSibling()).thenReturn(null);
        int position = invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(3, position);
    }

    @Test
    public void testGetRelativePositionOfTextNode_OnlyCDATA() throws Exception {
        Node cdataNode = mock(Node.class);
        when(cdataNode.getNodeType()).thenReturn(Node.CDATA_SECTION_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(cdataNode);
        when(cdataNode.getPreviousSibling()).thenReturn(null);
        int position = invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(2, position);
    }

    @Test
    public void testGetRelativePositionOfTextNode_OnlyTextAndCDATA() throws Exception {
        Node textNode = mock(Node.class);
        when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        Node cdataNode = mock(Node.class);
        when(cdataNode.getNodeType()).thenReturn(Node.CDATA_SECTION_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(textNode);
        when(textNode.getPreviousSibling()).thenReturn(cdataNode);
        when(cdataNode.getPreviousSibling()).thenReturn(null);
        int position = invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(3, position);
    }

    private int invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (int) method.invoke(domNodePointer);
    }
}
