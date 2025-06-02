package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.jdom.Attribute;
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
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;

public class JDOMNodePointer_testNode_18_0_Test {

    private JDOMNodePointer elementPointer;

    private JDOMNodePointer textPointer;

    private JDOMNodePointer commentPointer;

    private JDOMNodePointer processingInstructionPointer;

    @BeforeEach
    public void setUp() {
        Element element = new Element("testElement");
        elementPointer = new JDOMNodePointer(element, null);
        Text textNode = new Text("testText");
        textPointer = new JDOMNodePointer(textNode, null);
        ProcessingInstruction pi = new ProcessingInstruction("testPI", "data");
        processingInstructionPointer = new JDOMNodePointer(pi, null);
        // Creating a comment node
        org.jdom.Comment comment = new org.jdom.Comment("testComment");
        commentPointer = new JDOMNodePointer(comment, null);
    }

    @Test
    public void testNode_withNodeNameTest_matching() {
        NodeTest test = new NodeNameTest(new QName(null, "testElement"));
        assertTrue(elementPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeNameTest_nonMatching() {
        NodeTest test = new NodeNameTest(new QName(null, "nonMatchingElement"));
        assertFalse(elementPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeTypeTest_element() {
        NodeTest test = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        assertTrue(elementPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeTypeTest_text() {
        NodeTest test = new NodeTypeTest(Compiler.NODE_TYPE_TEXT);
        assertTrue(textPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeTypeTest_comment() {
        NodeTest test = new NodeTypeTest(Compiler.NODE_TYPE_COMMENT);
        assertTrue(commentPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeTypeTest_processingInstruction() {
        NodeTest test = new ProcessingInstructionTest("testPI");
        assertTrue(processingInstructionPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeTypeTest_nonMatching() {
        NodeTest test = new NodeTypeTest(Compiler.NODE_TYPE_COMMENT);
        assertFalse(textPointer.testNode(test));
    }

    @Test
    public void testNode_withNullNodeTest() {
        NodeTest test = null;
        assertTrue(elementPointer.testNode(test));
    }

    @Test
    public void testNode_withNodeNameTest_wildcard() {
        NodeTest test = new NodeNameTest(new QName(null, "*"));
        assertTrue(elementPointer.testNode(test));
    }
}
