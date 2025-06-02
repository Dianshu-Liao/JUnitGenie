package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
import org.w3c.dom.NodeList;

public class DOMNodePointer_getName_3_0_Test {

    private DOMNodePointer elementNodePointer;

    private DOMNodePointer processingInstructionPointer;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        // Create an Element node
        Element element = document.createElement("testElement");
        elementNodePointer = new DOMNodePointer(element, null);
        // Create a Processing Instruction node
        ProcessingInstruction processingInstruction = document.createProcessingInstruction("target", "data");
        processingInstructionPointer = new DOMNodePointer(processingInstruction, null);
    }

    @Test
    public void testGetName_ElementNode() {
        QName name = elementNodePointer.getName();
        assertEquals("testElement", name.getName());
        // Removed the assertion for getNamespaceURI since it doesn't exist
    }

    @Test
    public void testGetName_ProcessingInstructionNode() {
        QName name = processingInstructionPointer.getName();
        assertEquals("target", name.getName());
        // Removed the assertion for getNamespaceURI since it doesn't exist
    }

    @Test
    public void testGetName_NullNode() {
        DOMNodePointer nullNodePointer = new DOMNodePointer((Node) null, null);
        QName name = nullNodePointer.getName();
        assertNull(name.getName());
        // Removed the assertion for getNamespaceURI since it doesn't exist
    }
}
