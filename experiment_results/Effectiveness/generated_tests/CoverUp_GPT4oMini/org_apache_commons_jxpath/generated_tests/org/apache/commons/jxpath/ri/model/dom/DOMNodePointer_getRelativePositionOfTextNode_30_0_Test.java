package org.apache.commons.jxpath.ri.model.dom;

import java.util.Locale;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_getRelativePositionOfTextNode_30_0_Test {

    private Node textNode;

    private Node siblingTextNode1;

    private Node siblingTextNode2;

    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() {
        // Create mock nodes
        textNode = mock(Text.class);
        siblingTextNode1 = mock(Text.class);
        siblingTextNode2 = mock(Text.class);
        // Set up mock behavior
        when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(siblingTextNode1.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(siblingTextNode2.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(siblingTextNode1.getPreviousSibling()).thenReturn(siblingTextNode2);
        when(siblingTextNode2.getPreviousSibling()).thenReturn(null);
        when(textNode.getPreviousSibling()).thenReturn(siblingTextNode1);
        // Initialize DOMNodePointer
        domNodePointer = new DOMNodePointer(textNode, Locale.getDefault());
    }

    @Test
    public void testGetRelativePositionOfTextNode_withTwoSiblingTextNodes() throws Exception {
        // Invoke the private method using reflection
        int position = (int) invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(3, position);
    }

    @Test
    public void testGetRelativePositionOfTextNode_withNoSiblingTextNodes() throws Exception {
        // Set up the mock to return null for previous sibling
        when(textNode.getPreviousSibling()).thenReturn(null);
        // Invoke the private method using reflection
        int position = (int) invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(1, position);
    }

    @Test
    public void testGetRelativePositionOfTextNode_withMixedSiblings() throws Exception {
        Node siblingElement = mock(Node.class);
        when(siblingElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(siblingElement.getPreviousSibling()).thenReturn(siblingTextNode1);
        when(siblingTextNode1.getPreviousSibling()).thenReturn(null);
        when(textNode.getPreviousSibling()).thenReturn(siblingElement);
        // Invoke the private method using reflection
        int position = (int) invokePrivateMethod("getRelativePositionOfTextNode");
        assertEquals(1, position);
    }

    private Object invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(domNodePointer);
    }
}
