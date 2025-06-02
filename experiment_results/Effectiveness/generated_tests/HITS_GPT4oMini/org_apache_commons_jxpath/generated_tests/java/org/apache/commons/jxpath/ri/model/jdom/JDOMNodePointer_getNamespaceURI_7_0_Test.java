package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Document;
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
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

public class JDOMNodePointer_getNamespaceURI_7_0_Test {

    private JDOMNodePointer pointer;

    @BeforeEach
    public void setUp() {
        // Initialize the JDOMNodePointer with a default Document or Element
        Element rootElement = new Element("root", Namespace.getNamespace("example", "http://example.com"));
        pointer = new JDOMNodePointer(rootElement, Locale.getDefault(), null);
    }

    @Test
    public void testGetNamespaceURI_WithXmlPrefix() {
        // Test for the XML namespace
        String result = pointer.getNamespaceURI("xml");
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test
    public void testGetNamespaceURI_WithExistingPrefix() {
        // Test for an existing custom namespace
        Namespace customNamespace = Namespace.getNamespace("example", "http://example.com");
        pointer = new JDOMNodePointer(new Element("root", customNamespace), Locale.getDefault(), null);
        String result = pointer.getNamespaceURI("example");
        assertEquals("http://example.com", result);
    }

    @Test
    public void testGetNamespaceURI_WithNonExistingPrefix() {
        // Test for a non-existing prefix
        String result = pointer.getNamespaceURI("nonexistent");
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithNullNode() {
        // Test for null node scenario
        pointer = new JDOMNodePointer(null, Locale.getDefault(), null);
        String result = pointer.getNamespaceURI("example");
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURI_WithDocumentNode() {
        // Test with a Document node
        Document document = new Document();
        Element rootElement = new Element("root", Namespace.getNamespace("example", "http://example.com"));
        document.setRootElement(rootElement);
        pointer = new JDOMNodePointer(document, Locale.getDefault(), null);
        String result = pointer.getNamespaceURI("example");
        assertEquals("http://example.com", result);
    }
}
