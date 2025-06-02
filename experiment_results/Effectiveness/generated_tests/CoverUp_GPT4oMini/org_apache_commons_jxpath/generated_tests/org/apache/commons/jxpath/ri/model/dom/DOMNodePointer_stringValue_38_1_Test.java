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

class DOMNodePointer_stringValue_38_1_Test {

    private DOMNodePointer domNodePointer;

    @BeforeEach
    void setUp() {
        // Create a mock Node object
        Node mockNode = Mockito.mock(Node.class);
        domNodePointer = new DOMNodePointer(mockNode, Locale.ENGLISH);
    }

    @Test
    void testStringValueWithCommentNode() {
        Node commentNode = Mockito.mock(Comment.class);
        Mockito.when(commentNode.getNodeType()).thenReturn(Node.COMMENT_NODE);
        String result = invokeStringValue(commentNode);
        assertEquals("", result);
    }

    @Test
    void testStringValueWithTextNode() {
        Node textNode = Mockito.mock(Text.class);
        Mockito.when(textNode.getNodeType()).thenReturn(Node.TEXT_NODE);
        Mockito.when(textNode.getNodeValue()).thenReturn("  Hello World  ");
        Mockito.when(domNodePointer.findEnclosingAttribute(textNode, "xml:space")).thenReturn("default");
        String result = invokeStringValue(textNode);
        assertEquals("Hello World", result);
    }

    @Test
    void testStringValueWithCDataSectionNode() {
        Node cdataNode = Mockito.mock(CDATASection.class);
        Mockito.when(cdataNode.getNodeType()).thenReturn(Node.CDATA_SECTION_NODE);
        Mockito.when(cdataNode.getNodeValue()).thenReturn("Sample CDATA");
        String result = invokeStringValue(cdataNode);
        assertEquals("Sample CDATA", result);
    }

    @Test
    void testStringValueWithProcessingInstructionNode() {
        ProcessingInstruction piNode = Mockito.mock(ProcessingInstruction.class);
        Mockito.when(piNode.getNodeType()).thenReturn(Node.PROCESSING_INSTRUCTION_NODE);
        Mockito.when(piNode.getData()).thenReturn("Sample Processing Instruction");
        String result = invokeStringValue(piNode);
        assertEquals("Sample Processing Instruction", result);
    }

    @Test
    void testStringValueWithChildNodes() {
        Node parentNode = Mockito.mock(Element.class);
        Node childNode1 = Mockito.mock(Text.class);
        Node childNode2 = Mockito.mock(Text.class);
        Mockito.when(parentNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(parentNode.getChildNodes()).thenReturn(createNodeList(childNode1, childNode2));
        Mockito.when(childNode1.getNodeType()).thenReturn(Node.TEXT_NODE);
        Mockito.when(childNode1.getNodeValue()).thenReturn("Child 1");
        Mockito.when(childNode2.getNodeType()).thenReturn(Node.TEXT_NODE);
        Mockito.when(childNode2.getNodeValue()).thenReturn("Child 2");
        String result = invokeStringValue(parentNode);
        assertEquals("Child 1Child 2", result);
    }

    private NodeList createNodeList(Node... nodes) {
        NodeList nodeList = Mockito.mock(NodeList.class);
        Mockito.when(nodeList.getLength()).thenReturn(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            final int index = i;
            Mockito.when(nodeList.item(i)).thenAnswer(invocation -> nodes[index]);
        }
        return nodeList;
    }

    private String invokeStringValue(Node node) {
        try {
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            return (String) method.invoke(domNodePointer, node);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
