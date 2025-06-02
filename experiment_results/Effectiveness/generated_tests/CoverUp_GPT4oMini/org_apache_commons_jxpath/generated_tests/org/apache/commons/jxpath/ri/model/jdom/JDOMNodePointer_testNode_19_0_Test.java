package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Element;
import org.jdom.Namespace;
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
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.Attribute;
import org.jdom.Document;

class JDOMNodePointer_testNode_19_0_Test {

    @Test
    void testNode_WithNullTest_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Element("test"), null);
        assertTrue(JDOMNodePointer.testNode(pointer, new Element("test"), null));
    }

    @Test
    void testNode_WithNodeNameTest_MatchingElement_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Element("test"), null);
        NodeNameTest test = new NodeNameTest(new QName("test"));
        assertTrue(JDOMNodePointer.testNode(pointer, new Element("test"), test));
    }

    @Test
    void testNode_WithNodeNameTest_NonMatchingElement_ReturnsFalse() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Element("test"), null);
        NodeNameTest test = new NodeNameTest(new QName("test2"));
        assertFalse(JDOMNodePointer.testNode(pointer, new Element("test"), test));
    }

    @Test
    void testNode_WithNodeTypeTest_Node_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Element("test"), null);
        // NODE_TYPE_NODE
        NodeTypeTest test = new NodeTypeTest(1);
        assertTrue(JDOMNodePointer.testNode(pointer, new Element("test"), test));
    }

    @Test
    void testNode_WithNodeTypeTest_Text_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Text("text"), null);
        // NODE_TYPE_TEXT
        NodeTypeTest test = new NodeTypeTest(3);
        assertTrue(JDOMNodePointer.testNode(pointer, new Text("text"), test));
    }

    @Test
    void testNode_WithNodeTypeTest_Comment_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Comment("comment"), null);
        // NODE_TYPE_COMMENT
        NodeTypeTest test = new NodeTypeTest(8);
        assertTrue(JDOMNodePointer.testNode(pointer, new Comment("comment"), test));
    }

    @Test
    void testNode_WithNodeTypeTest_ProcessingInstruction_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new ProcessingInstruction("target", "data"), null);
        // NODE_TYPE_PI
        NodeTypeTest test = new NodeTypeTest(7);
        assertTrue(JDOMNodePointer.testNode(pointer, new ProcessingInstruction("target", "data"), test));
    }

    @Test
    void testNode_WithProcessingInstructionTest_MatchingTarget_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new ProcessingInstruction("target", "data"), null);
        ProcessingInstructionTest test = new ProcessingInstructionTest("target");
        assertTrue(JDOMNodePointer.testNode(pointer, new ProcessingInstruction("target", "data"), test));
    }

    @Test
    void testNode_WithProcessingInstructionTest_NonMatchingTarget_ReturnsFalse() {
        JDOMNodePointer pointer = new JDOMNodePointer(new ProcessingInstruction("target", "data"), null);
        ProcessingInstructionTest test = new ProcessingInstructionTest("nonMatching");
        assertFalse(JDOMNodePointer.testNode(pointer, new ProcessingInstruction("target", "data"), test));
    }

    @Test
    void testNode_WithNodeNameTest_Wildcard_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Element("test"), null);
        NodeNameTest test = new NodeNameTest(new QName("*"));
        assertTrue(JDOMNodePointer.testNode(pointer, new Element("test"), test));
    }

    @Test
    void testNode_WithNodeNameTest_NullNamespace_ReturnsTrue() {
        JDOMNodePointer pointer = new JDOMNodePointer(new Element("test", Namespace.NO_NAMESPACE), null);
        NodeNameTest test = new NodeNameTest(new QName("test", null));
        assertTrue(JDOMNodePointer.testNode(pointer, new Element("test", Namespace.NO_NAMESPACE), test));
    }
}
