package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Namespace;

public class JDOMNodePointer_testNode_19_0_Test {

    @Test
    public void testNode_WithNullTest_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        Object node = new Element("testElement");
        assertTrue(JDOMNodePointer.testNode(pointer, node, null));
    }

    @Test
    public void testNode_WithNodeNameTest_MatchingElement_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        QName qname = new QName("testElement");
        NodeNameTest test = new NodeNameTest(qname);
        Object node = new Element("testElement");
        assertTrue(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeNameTest_NonMatchingElement_ReturnsFalse() {
        // Not used in this case
        NodePointer pointer = null;
        QName qname = new QName("testElement");
        NodeNameTest test = new NodeNameTest(qname);
        Object node = new Element("differentElement");
        assertFalse(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeTypeTest_NodeTypeNode_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        NodeTypeTest test = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        Object node = new Element("testElement");
        assertTrue(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeTypeTest_NodeTypeText_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        NodeTypeTest test = new NodeTypeTest(Compiler.NODE_TYPE_TEXT);
        Object node = new Text("test text");
        assertTrue(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeTypeTest_NonMatchingNodeType_ReturnsFalse() {
        // Not used in this case
        NodePointer pointer = null;
        NodeTypeTest test = new NodeTypeTest(Compiler.NODE_TYPE_COMMENT);
        Object node = new Text("test text");
        assertFalse(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithProcessingInstructionTest_MatchingPI_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        ProcessingInstructionTest test = new ProcessingInstructionTest("testPI");
        Object node = new ProcessingInstruction("testPI", "data");
        assertTrue(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithProcessingInstructionTest_NonMatchingPI_ReturnsFalse() {
        // Not used in this case
        NodePointer pointer = null;
        ProcessingInstructionTest test = new ProcessingInstructionTest("testPI");
        Object node = new ProcessingInstruction("differentPI", "data");
        assertFalse(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeNameTest_Wildcard_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        QName qname = new QName("*");
        NodeNameTest test = new NodeNameTest(qname);
        Object node = new Element("testElement");
        assertTrue(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeTypeTest_NodeTypeComment_ReturnsTrue() {
        // Not used in this case
        NodePointer pointer = null;
        NodeTypeTest test = new NodeTypeTest(Compiler.NODE_TYPE_COMMENT);
        Object node = new Comment("test comment");
        assertTrue(JDOMNodePointer.testNode(pointer, node, test));
    }

    @Test
    public void testNode_WithNodeTypeTest_NonMatchingNodeTypeComment_ReturnsFalse() {
        // Not used in this case
        NodePointer pointer = null;
        NodeTypeTest test = new NodeTypeTest(Compiler.NODE_TYPE_COMMENT);
        Object node = new Element("testElement");
        assertFalse(JDOMNodePointer.testNode(pointer, node, test));
    }
}
