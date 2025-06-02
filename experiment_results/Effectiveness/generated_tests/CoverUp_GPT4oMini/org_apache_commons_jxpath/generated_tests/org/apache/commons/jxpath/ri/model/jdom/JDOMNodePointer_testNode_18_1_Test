package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
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
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class JDOMNodePointer_testNode_18_1_Test {

    private JDOMNodePointer elementPointer;

    private JDOMNodePointer textPointer;

    private JDOMNodePointer processingInstructionPointer;

    @BeforeEach
    void setUp() {
        Element element = new Element("testElement", Namespace.NO_NAMESPACE);
        Text text = new Text("testText");
        ProcessingInstruction pi = new ProcessingInstruction("testPI", "data");
        elementPointer = new JDOMNodePointer(element, null);
        textPointer = new JDOMNodePointer(text, null);
        processingInstructionPointer = new JDOMNodePointer(pi, null);
    }

    @Test
    void testNode_withNodeNameTest_shouldReturnTrueForMatchingElement() {
        NodeTest test = new NodeNameTest(new QName(Namespace.NO_NAMESPACE.getURI(), "testElement"));
        assertTrue(elementPointer.testNode(test));
    }

    @Test
    void testNode_withNodeNameTest_shouldReturnFalseForNonMatchingElement() {
        NodeTest test = new NodeNameTest(new QName(Namespace.NO_NAMESPACE.getURI(), "nonMatchingElement"));
        assertFalse(elementPointer.testNode(test));
    }

    @Test
    void testNode_withNodeTypeTest_shouldReturnTrueForElementNode() {
        NodeTest test = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        assertTrue(elementPointer.testNode(test));
    }

    @Test
    void testNode_withNodeTypeTest_shouldReturnFalseForTextNode() {
        NodeTest test = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        assertFalse(textPointer.testNode(test));
    }

    @Test
    void testNode_withProcessingInstructionTest_shouldReturnTrueForMatchingPI() {
        NodeTest test = new ProcessingInstructionTest("testPI");
        assertTrue(processingInstructionPointer.testNode(test));
    }

    @Test
    void testNode_withProcessingInstructionTest_shouldReturnFalseForNonMatchingPI() {
        NodeTest test = new ProcessingInstructionTest("nonMatchingPI");
        assertFalse(processingInstructionPointer.testNode(test));
    }

    @Test
    void testNode_withNullTest_shouldReturnTrue() {
        assertTrue(elementPointer.testNode(null));
    }
}
