package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.*;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class DOMNodePointer_getDefaultNamespaceURI_11_0_Test {

    @Mock
    private Node mockNode;

    @Mock
    private Document mockDocument;

    @Mock
    private Element mockElement;

    @Mock
    private Attr mockAttr;

    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDefaultNamespaceURI_DocumentElement() {
        when(mockNode instanceof Document).thenReturn(true);
        when(mockDocument.getDocumentElement()).thenReturn(mockElement);
        when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockElement.getAttributeNode("xmlns")).thenReturn(mockAttr);
        when(mockAttr.getValue()).thenReturn("http://example.com/namespace");
        domNodePointer = new DOMNodePointer(mockDocument, Locale.ENGLISH);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/namespace", result);
    }

    @Test
    public void testGetDefaultNamespaceURI_ElementWithNamespace() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getParentNode()).thenReturn(null);
        when(mockNode instanceof Element).thenReturn(true);
        when(((Element) mockNode).getAttributeNode("xmlns")).thenReturn(mockAttr);
        when(mockAttr.getValue()).thenReturn("http://example.com/namespace");
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/namespace", result);
    }

    @Test
    public void testGetDefaultNamespaceURI_NoNamespace() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getParentNode()).thenReturn(null);
        when(mockNode instanceof Element).thenReturn(true);
        when(((Element) mockNode).getAttributeNode("xmlns")).thenReturn(null);
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNull(result);
    }

    @Test
    public void testGetDefaultNamespaceURI_EmptyNamespace() {
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getParentNode()).thenReturn(null);
        when(mockNode instanceof Element).thenReturn(true);
        when(((Element) mockNode).getAttributeNode("xmlns")).thenReturn(mockAttr);
        when(mockAttr.getValue()).thenReturn("");
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNull(result);
    }

    @Test
    public void testGetDefaultNamespaceURI_ParentNodeWithNamespace() {
        Node parentNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getParentNode()).thenReturn(parentNode);
        when(parentNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(parentNode instanceof Element).thenReturn(true);
        when(((Element) parentNode).getAttributeNode("xmlns")).thenReturn(mockAttr);
        when(mockAttr.getValue()).thenReturn("http://example.com/namespace");
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/namespace", result);
    }

    @Test
    public void testGetDefaultNamespaceURI_ParentNodeWithoutNamespace() {
        Node parentNode = mock(Node.class);
        when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockNode.getParentNode()).thenReturn(parentNode);
        when(parentNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(parentNode instanceof Element).thenReturn(true);
        when(((Element) parentNode).getAttributeNode("xmlns")).thenReturn(null);
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNull(result);
    }
}
