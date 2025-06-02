package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Element;
import org.jdom.Namespace;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

public class JDOMNodePointer_getNamespaceURI_4_0_Test {

    private JDOMNodePointer pointerWithNoNamespace;

    private JDOMNodePointer pointerWithEmptyNamespace;

    private JDOMNodePointer pointerWithValidNamespace;

    @BeforeEach
    public void setUp() {
        // Set up an Element without a namespace
        Element elementWithoutNamespace = new Element("testElement");
        pointerWithNoNamespace = new JDOMNodePointer(elementWithoutNamespace, Locale.getDefault());
        // Set up an Element with an empty namespace
        Element elementWithEmptyNamespace = new Element("testElement", Namespace.NO_NAMESPACE);
        pointerWithEmptyNamespace = new JDOMNodePointer(elementWithEmptyNamespace, Locale.getDefault());
        // Set up an Element with a valid namespace
        Namespace namespace = Namespace.getNamespace("http://www.example.com");
        Element elementWithValidNamespace = new Element("testElement", namespace);
        pointerWithValidNamespace = new JDOMNodePointer(elementWithValidNamespace, Locale.getDefault());
    }

    @Test
    public void testGetNamespaceURI_NoNamespace() {
        assertNull(pointerWithNoNamespace.getNamespaceURI(), "Expected null namespace URI for element without namespace");
    }

    @Test
    public void testGetNamespaceURI_EmptyNamespace() {
        assertNull(pointerWithEmptyNamespace.getNamespaceURI(), "Expected null namespace URI for element with empty namespace");
    }

    @Test
    public void testGetNamespaceURI_ValidNamespace() {
        assertEquals("http://www.example.com", pointerWithValidNamespace.getNamespaceURI(), "Expected valid namespace URI for element with defined namespace");
    }
}
