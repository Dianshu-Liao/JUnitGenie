package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(MockitoExtension.class)
public class DOMNodePointer_getRelativePositionOfTextNode_30_0_Test {

    private DOMNodePointer domNodePointer;

    @Mock
    private Node mockNode;

    @BeforeEach
    public void setUp() {
        // Initialize DOMNodePointer with the required parameters
        domNodePointer = new DOMNodePointer(mockNode, Locale.getDefault());
    }

    private int invokeGetRelativePositionOfTextNode() throws Exception {
        Method method = DOMNodePointer.class.getDeclaredMethod("getRelativePositionOfTextNode");
        method.setAccessible(true);
        return (int) method.invoke(domNodePointer);
    }

    @Test
    public void testGetRelativePositionOfTextNode_OneTextNodeBefore() throws Exception {
        Text textNode = mock(Text.class);
        when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(textNode).thenReturn(null);
        int result = invokeGetRelativePositionOfTextNode();
        assertEquals(1, result);
    }

    @Test
    public void testGetRelativePositionOfTextNode_MultipleTextNodesBefore() throws Exception {
        Text textNode1 = mock(Text.class);
        Text textNode2 = mock(Text.class);
        when(textNode1.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(textNode2.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(textNode1).thenReturn(textNode2).thenReturn(null);
        int result = invokeGetRelativePositionOfTextNode();
        assertEquals(2, result);
    }

    @Test
    public void testGetRelativePositionOfTextNode_CDataSectionBefore() throws Exception {
        Node cdataNode = mock(Node.class);
        when(cdataNode.getNodeType()).thenReturn(Node.CDATA_SECTION_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(cdataNode).thenReturn(null);
        int result = invokeGetRelativePositionOfTextNode();
        assertEquals(1, result);
    }

    @Test
    public void testGetRelativePositionOfTextNode_MixedNodesBefore() throws Exception {
        Text textNode = mock(Text.class);
        Node commentNode = mock(Node.class);
        when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(commentNode.getNodeType()).thenReturn(Node.COMMENT_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(textNode).thenReturn(commentNode).thenReturn(null);
        int result = invokeGetRelativePositionOfTextNode();
        assertEquals(1, result);
    }

    @Test
    public void testGetRelativePositionOfTextNode_NoTextNodesBefore() throws Exception {
        Node commentNode = mock(Node.class);
        when(commentNode.getNodeType()).thenReturn(Node.COMMENT_NODE);
        when(mockNode.getPreviousSibling()).thenReturn(commentNode).thenReturn(null);
        int result = invokeGetRelativePositionOfTextNode();
        assertEquals(0, result);
    }

    @Test
    public void testGetRelativePositionOfTextNode_EmptyNodeList() throws Exception {
        when(mockNode.getPreviousSibling()).thenReturn(null);
        int result = invokeGetRelativePositionOfTextNode();
        assertEquals(0, result);
    }
}
