package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.*;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.TypeUtils;

public class DOMNodePointer_getName_3_4_Test {

    private Node elementNode;

    private Node processingInstructionNode;

    private DOMNodePointer elementNodePointer;

    private DOMNodePointer processingInstructionNodePointer;

    @BeforeEach
    public void setUp() {
        // Mocking the Node interface for Element
        elementNode = Mockito.mock(Element.class);
        Mockito.when(elementNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(elementNode.getNodeName()).thenReturn("ns:localName");
        Mockito.when(elementNode.getPrefix()).thenReturn("ns");
        Mockito.when(elementNode.getLocalName()).thenReturn("localName");
        // Mocking the Node interface for ProcessingInstruction
        processingInstructionNode = Mockito.mock(ProcessingInstruction.class);
        Mockito.when(processingInstructionNode.getNodeType()).thenReturn(Node.PROCESSING_INSTRUCTION_NODE);
        Mockito.when(processingInstructionNode.getNodeName()).thenReturn("target");
        // Creating DOMNodePointer instances
        elementNodePointer = new DOMNodePointer(elementNode, Locale.ENGLISH);
        processingInstructionNodePointer = new DOMNodePointer(processingInstructionNode, Locale.ENGLISH);
    }

    @Test
    public void testGetNameForElementNode() {
        QName expectedQName = new QName("ns", "localName");
        QName actualQName = elementNodePointer.getName();
        assertEquals(expectedQName, actualQName);
    }

    @Test
    public void testGetNameForProcessingInstructionNode() {
        QName expectedQName = new QName(null, "target");
        QName actualQName = processingInstructionNodePointer.getName();
        assertEquals(expectedQName, actualQName);
    }
}
