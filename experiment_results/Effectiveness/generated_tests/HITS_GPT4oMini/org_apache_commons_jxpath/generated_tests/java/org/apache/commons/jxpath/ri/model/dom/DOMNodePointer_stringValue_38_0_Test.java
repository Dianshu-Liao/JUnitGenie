package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_stringValue_38_0_Test {

    private DOMNodePointer createNodePointer(Node node) {
        return new DOMNodePointer(node, null);
    }

    @Test
    public void testStringValue_TextNode() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Text textNode = doc.createTextNode("Hello, World!");
        NodePointer pointer = createNodePointer(textNode);
        String result = pointer.getValue().toString();
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testStringValue_CommentNode() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Node commentNode = doc.createComment("This is a comment");
        NodePointer pointer = createNodePointer(commentNode);
        String result = pointer.getValue().toString();
        assertEquals("", result);
    }

    @Test
    public void testStringValue_CDATASectionNode() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Node cdataNode = doc.createCDATASection("This is CDATA");
        NodePointer pointer = createNodePointer(cdataNode);
        String result = pointer.getValue().toString();
        assertEquals("This is CDATA", result);
    }

    @Test
    public void testStringValue_ProcessingInstructionNode() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Node piNode = doc.createProcessingInstruction("target", "data");
        NodePointer pointer = createNodePointer(piNode);
        String result = pointer.getValue().toString();
        assertEquals("data", result);
    }

    @Test
    public void testStringValue_EmptyNode() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Node emptyElement = doc.createElement("empty");
        NodePointer pointer = createNodePointer(emptyElement);
        String result = pointer.getValue().toString();
        assertEquals("", result);
    }

    @Test
    public void testStringValue_NestedNodes() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("root");
        Text textNode1 = doc.createTextNode("Hello ");
        Text textNode2 = doc.createTextNode("World!");
        root.appendChild(textNode1);
        root.appendChild(textNode2);
        NodePointer pointer = createNodePointer(root);
        String result = pointer.getValue().toString();
        assertEquals("Hello World!", result);
    }

    @Test
    public void testStringValue_TrimWhitespace() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("root");
        root.setAttribute("xml:space", "preserve");
        Text textNode = doc.createTextNode("   Hello   ");
        root.appendChild(textNode);
        NodePointer pointer = createNodePointer(root);
        String result = pointer.getValue().toString();
        assertEquals("   Hello   ", result);
    }

    @Test
    public void testStringValue_TrimWhitespaceWithoutPreserve() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("root");
        Text textNode = doc.createTextNode("   Hello   ");
        root.appendChild(textNode);
        NodePointer pointer = createNodePointer(root);
        String result = pointer.getValue().toString();
        assertEquals("Hello", result);
    }
}
