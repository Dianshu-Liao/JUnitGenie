package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Locale;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMNodePointer_getName_3_1_Test {

    private Element elementNode;

    private ProcessingInstruction processingInstructionNode;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        // Create an element node for testing
        elementNode = document.createElement("testElement");
        elementNode.setPrefix("testPrefix");
        document.appendChild(elementNode);
        // Create a processing instruction node for testing
        processingInstructionNode = document.createProcessingInstruction("testTarget", "testData");
        document.appendChild(processingInstructionNode);
    }

    @Test
    public void testGetNameForElementNode() {
        DOMNodePointer domNodePointer = new DOMNodePointer(elementNode, null);
        QName name = domNodePointer.getName();
        assertEquals("testElement", name.getName());
        // Changed to getPrefix() if available
        assertEquals("testPrefix", name.getPrefix());
    }

    @Test
    public void testGetNameForProcessingInstructionNode() {
        DOMNodePointer domNodePointer = new DOMNodePointer(processingInstructionNode, null);
        QName name = domNodePointer.getName();
        assertEquals("testTarget", name.getName());
        // Assuming no namespace for processing instruction
        assertNull(name.getPrefix());
    }

    @Test
    public void testGetNameForElementNodeWithoutPrefix() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element elementNodeWithoutPrefix = document.createElement("testElement");
        document.appendChild(elementNodeWithoutPrefix);
        DOMNodePointer domNodePointer = new DOMNodePointer(elementNodeWithoutPrefix, null);
        QName name = domNodePointer.getName();
        assertEquals("testElement", name.getName());
        // Assuming no prefix
        assertNull(name.getPrefix());
    }
}
