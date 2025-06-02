package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import org.w3c.dom.ProcessingInstruction;

class DOMNodePointer_createChild_22_2_Test {

    private DOMNodePointer domNodePointer;

    private Document document;

    private Element rootElement;

    @BeforeEach
    void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        rootElement = document.createElement("root");
        document.appendChild(rootElement);
        domNodePointer = new DOMNodePointer(rootElement, null);
    }

    @Test
    void testCreateChild_Success() {
        JXPathContext context = mock(JXPathContext.class);
        QName name = new QName("child");
        int index = 0;
        // Mock the behavior of the abstract factory
        when(context.getNamespaceURI(anyString())).thenReturn(null);
        when(domNodePointer.createChild(eq(context), eq(name), eq(index))).thenCallRealMethod();
        // Invoke the method
        assertDoesNotThrow(() -> {
            domNodePointer.createChild(context, name, index);
        });
        // Verify the child has been created
        assertEquals(1, rootElement.getChildNodes().getLength());
        assertEquals("child", rootElement.getChildNodes().item(0).getNodeName());
    }

    @Test
    void testCreateChild_FactoryFailure() {
        JXPathContext context = mock(JXPathContext.class);
        QName name = new QName("child");
        int index = 0;
        // Mock the failure of the factory
        when(context.getNamespaceURI(anyString())).thenReturn(null);
        doThrow(new JXPathAbstractFactoryException("Factory error")).when(domNodePointer).createChild(eq(context), eq(name), eq(index));
        // Invoke the method and verify exception
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            domNodePointer.createChild(context, name, index);
        });
        assertEquals("Factory could not create a child node for path: " + domNodePointer.asPath() + "/" + name + "[1]", exception.getMessage());
    }

    @Test
    void testCreateChild_WholeCollection() {
        JXPathContext context = mock(JXPathContext.class);
        QName name = new QName("child");
        // WHOLE_COLLECTION is assumed to be -1
        int index = -1;
        // Mock the behavior of the abstract factory
        when(context.getNamespaceURI(anyString())).thenReturn(null);
        when(domNodePointer.createChild(eq(context), eq(name), eq(0))).thenCallRealMethod();
        // Invoke the method
        assertDoesNotThrow(() -> {
            domNodePointer.createChild(context, name, index);
        });
        // Verify the child has been created
        assertEquals(1, rootElement.getChildNodes().getLength());
        assertEquals("child", rootElement.getChildNodes().item(0).getNodeName());
    }
}
