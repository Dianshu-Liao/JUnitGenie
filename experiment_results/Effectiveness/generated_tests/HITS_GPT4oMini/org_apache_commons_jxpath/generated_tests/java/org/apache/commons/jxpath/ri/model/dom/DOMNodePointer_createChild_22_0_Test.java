package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_createChild_22_0_Test {

    private DOMNodePointer domNodePointer;

    private Document document;

    private JXPathContext context;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        domNodePointer = new DOMNodePointer(root, null);
        context = mock(JXPathContext.class);
    }

    @Test
    public void testCreateChild_Success() {
        QName childName = new QName("child");
        when(context.getNamespaceURI(null)).thenReturn(null);
        when(context.getNamespaceURI("")).thenReturn(null);
        when(context.getNamespaceURI("child")).thenReturn(null);
        when(context.getNamespaceURI("prefix")).thenReturn(null);
        Node childNode = (Node) domNodePointer.createChild(context, childName, 0).getImmediateNode();
        assertNotNull(childNode);
        assertEquals("child", childNode.getNodeName());
    }

    @Test
    public void testCreateChild_WholeCollection() {
        QName childName = new QName("child");
        when(context.getNamespaceURI(null)).thenReturn(null);
        when(context.getNamespaceURI("")).thenReturn(null);
        when(context.getNamespaceURI("child")).thenReturn(null);
        when(context.getNamespaceURI("prefix")).thenReturn(null);
        Node childNode = (Node) domNodePointer.createChild(context, childName, -1).getImmediateNode();
        assertNotNull(childNode);
        assertEquals("child", childNode.getNodeName());
    }
}
