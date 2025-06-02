package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
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
import org.w3c.dom.ProcessingInstruction;

@ExtendWith(MockitoExtension.class)
class DOMNodePointer_createChild_23_0_Test {

    private DOMNodePointer pointer;

    private Document document;

    private JXPathContext context;

    @BeforeEach
    void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        pointer = new DOMNodePointer(root, null);
        context = mock(JXPathContext.class);
        when(context.getNamespaceURI(anyString())).thenReturn(null);
    }

    @Test
    void testCreateChild() {
        QName childName = new QName("child");
        NodePointer childPointer = pointer.createChild(context, childName, 0, "childValue");
        assertNotNull(childPointer);
        assertEquals("child", childPointer.getName().getName());
        assertEquals(1, pointer.getLength());
        NodeList children = ((Node) pointer.getImmediateNode()).getChildNodes();
        assertEquals(1, children.getLength());
        assertEquals("childValue", children.item(0).getNodeValue());
    }

    @Test
    void testCreateMultipleChildren() {
        QName childName = new QName("child");
        pointer.createChild(context, childName, 0, "childValue1");
        pointer.createChild(context, childName, 1, "childValue2");
        NodeList children = ((Node) pointer.getImmediateNode()).getChildNodes();
        assertEquals(2, children.getLength());
        assertEquals("childValue1", children.item(0).getNodeValue());
        assertEquals("childValue2", children.item(1).getNodeValue());
    }

    @Test
    void testCreateChildWithNullValue() {
        QName childName = new QName("child");
        pointer.createChild(context, childName, 0, null);
        NodeList children = ((Node) pointer.getImmediateNode()).getChildNodes();
        assertEquals(0, children.getLength());
    }
}
