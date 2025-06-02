package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
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

public class DOMNodePointer_getDefaultNamespaceURI_11_0_Test {

    private Document document;

    private DOMNodePointer domNodePointer;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void testGetDefaultNamespaceURI_NoNamespace() {
        Element root = document.createElement("root");
        document.appendChild(root);
        domNodePointer = new DOMNodePointer(root, null);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNull(result, "Expected null for no namespace");
    }

    @Test
    public void testGetDefaultNamespaceURI_WithDefaultNamespace() {
        Element root = document.createElement("root");
        root.setAttribute("xmlns", "http://example.com/default");
        document.appendChild(root);
        domNodePointer = new DOMNodePointer(root, null);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/default", result, "Expected the default namespace URI");
    }

    @Test
    public void testGetDefaultNamespaceURI_WithParentNamespace() {
        Element root = document.createElement("root");
        root.setAttribute("xmlns", "http://example.com/default");
        document.appendChild(root);
        Element child = document.createElement("child");
        root.appendChild(child);
        domNodePointer = new DOMNodePointer(child, null);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/default", result, "Expected the default namespace URI from parent");
    }

    @Test
    public void testGetDefaultNamespaceURI_EmptyNamespace() {
        Element root = document.createElement("root");
        root.setAttribute("xmlns", "");
        document.appendChild(root);
        domNodePointer = new DOMNodePointer(root, null);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertNull(result, "Expected null for empty namespace");
    }

    @Test
    public void testGetDefaultNamespaceURI_NestedNamespaces() {
        Element root = document.createElement("root");
        root.setAttribute("xmlns", "http://example.com/default");
        document.appendChild(root);
        Element child = document.createElement("child");
        child.setAttribute("xmlns", "http://example.com/child");
        root.appendChild(child);
        domNodePointer = new DOMNodePointer(child, null);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/child", result, "Expected the child namespace URI");
    }

    @Test
    public void testGetDefaultNamespaceURI_MultipleLevels() {
        Element root = document.createElement("root");
        document.appendChild(root);
        Element child1 = document.createElement("child1");
        child1.setAttribute("xmlns", "http://example.com/child1");
        root.appendChild(child1);
        Element child2 = document.createElement("child2");
        root.appendChild(child2);
        domNodePointer = new DOMNodePointer(child2, null);
        String result = domNodePointer.getDefaultNamespaceURI();
        assertEquals("http://example.com/child1", result, "Expected the namespace URI from child1");
    }
}
