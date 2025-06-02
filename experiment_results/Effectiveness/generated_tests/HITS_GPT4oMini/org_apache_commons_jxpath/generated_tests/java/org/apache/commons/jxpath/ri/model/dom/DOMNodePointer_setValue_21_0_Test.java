package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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

public class DOMNodePointer_setValue_21_0_Test {

    private Document document;

    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        domNodePointer = new DOMNodePointer(root, Locale.getDefault(), null);
    }

    @Test
    public void testSetValue_WithTextNode() {
        Node textNode = document.createTextNode("Initial Text");
        ((Node) domNodePointer.getNode()).appendChild(textNode);
        domNodePointer.setValue("Updated Text");
        assertEquals("Updated Text", ((Node) domNodePointer.getNode()).getFirstChild().getNodeValue());
    }

    @Test
    public void testSetValue_WithEmptyString() {
        Node textNode = document.createTextNode("Initial Text");
        ((Node) domNodePointer.getNode()).appendChild(textNode);
        domNodePointer.setValue("");
        assertNull(((Node) domNodePointer.getNode()).getFirstChild());
        assertEquals(0, ((Node) domNodePointer.getNode()).getChildNodes().getLength());
    }

    @Test
    public void testSetValue_WithNull() {
        Node textNode = document.createTextNode("Initial Text");
        ((Node) domNodePointer.getNode()).appendChild(textNode);
        domNodePointer.setValue(null);
        assertNull(((Node) domNodePointer.getNode()).getFirstChild());
        assertEquals(0, ((Node) domNodePointer.getNode()).getChildNodes().getLength());
    }
}
