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

    private JDOMNodePointer pointer;

    @BeforeEach
    public void setUp() {
        // Set up a default Element with a namespace for testing
        Element element = new Element("testElement", Namespace.getNamespace("http://example.com"));
        pointer = new JDOMNodePointer(element, Locale.getDefault());
    }

    @Test
    public void testGetNamespaceURI_WithNamespace() {
        String expectedNamespaceURI = "http://example.com";
        String actualNamespaceURI = pointer.getNamespaceURI();
        assertEquals(expectedNamespaceURI, actualNamespaceURI, "Namespace URI should match the expected value.");
    }

    @Test
    public void testGetNamespaceURI_WithoutNamespace() {
        // Test with an element that has no namespace
        Element elementWithoutNamespace = new Element("testElement");
        pointer = new JDOMNodePointer(elementWithoutNamespace, Locale.getDefault());
        String actualNamespaceURI = pointer.getNamespaceURI();
        assertEquals(null, actualNamespaceURI, "Namespace URI should be null for an element without a namespace.");
    }

    @Test
    public void testGetNamespaceURI_WithEmptyNamespace() {
        // Test with an element that has an empty namespace
        Element elementWithEmptyNamespace = new Element("testElement", Namespace.NO_NAMESPACE);
        pointer = new JDOMNodePointer(elementWithEmptyNamespace, Locale.getDefault());
        String actualNamespaceURI = pointer.getNamespaceURI();
        assertEquals(null, actualNamespaceURI, "Namespace URI should be null for an element with an empty namespace.");
    }

    @Test
    public void testGetNamespaceURI_WithXMLNamespace() {
        // Test with an element that uses the XML namespace
        Element elementWithXMLNamespace = new Element("testElement", Namespace.XML_NAMESPACE);
        pointer = new JDOMNodePointer(elementWithXMLNamespace, Locale.getDefault());
        String actualNamespaceURI = pointer.getNamespaceURI();
        assertEquals(Namespace.XML_NAMESPACE.getURI(), actualNamespaceURI, "Namespace URI should match the XML namespace URI.");
    }
}
