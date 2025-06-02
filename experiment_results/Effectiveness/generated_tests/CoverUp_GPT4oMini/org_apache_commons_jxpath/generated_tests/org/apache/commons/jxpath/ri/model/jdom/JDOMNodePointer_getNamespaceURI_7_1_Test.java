package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Locale;
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
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JDOMNodePointer_getNamespaceURI_7_1_Test {

    private JDOMNodePointer pointerWithDocument;

    private JDOMNodePointer pointerWithElement;

    private JDOMNodePointer pointerWithNull;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a namespace
        Namespace ns = Namespace.getNamespace("example", "http://example.com");
        // Create a document with a root element
        Element rootElement = new Element("root", ns);
        Document document = new Document(rootElement);
        // Initialize pointers using reflection to avoid constructor ambiguity
        Constructor<JDOMNodePointer> constructorWithDocument = JDOMNodePointer.class.getDeclaredConstructor(Object.class, Locale.class);
        constructorWithDocument.setAccessible(true);
        pointerWithDocument = constructorWithDocument.newInstance(document, Locale.getDefault());
        Constructor<JDOMNodePointer> constructorWithElement = JDOMNodePointer.class.getDeclaredConstructor(Object.class, Locale.class);
        constructorWithElement.setAccessible(true);
        pointerWithElement = constructorWithElement.newInstance(rootElement, Locale.getDefault());
        Constructor<JDOMNodePointer> constructorWithNull = JDOMNodePointer.class.getDeclaredConstructor(Object.class, Locale.class);
        constructorWithNull.setAccessible(true);
        pointerWithNull = constructorWithNull.newInstance(null, Locale.getDefault());
    }

    @Test
    public void testGetNamespaceURIWithXmlPrefix() {
        String result = pointerWithElement.getNamespaceURI("xml");
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test
    public void testGetNamespaceURIWithExistingNamespace() {
        Namespace ns = Namespace.getNamespace("example", "http://example.com");
        Element element = (Element) pointerWithElement.getImmediateNode();
        element.addNamespaceDeclaration(ns);
        String result = pointerWithElement.getNamespaceURI("example");
        assertEquals("http://example.com", result);
    }

    @Test
    public void testGetNamespaceURIWithNonExistingNamespace() {
        String result = pointerWithElement.getNamespaceURI("nonexistent");
        assertNull(result);
    }

    @Test
    public void testGetNamespaceURIWithDocument() {
        String result = pointerWithDocument.getNamespaceURI("xml");
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test
    public void testGetNamespaceURIWithNullNode() {
        String result = pointerWithNull.getNamespaceURI("xml");
        assertNull(result);
    }
}
