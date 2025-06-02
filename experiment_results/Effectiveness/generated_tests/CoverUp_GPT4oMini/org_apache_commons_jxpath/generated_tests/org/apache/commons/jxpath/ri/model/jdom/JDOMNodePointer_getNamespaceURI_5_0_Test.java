package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

class JDOMNodePointer_getNamespaceURI_5_0_Test {

    private JDOMNodePointer createJDOMNodePointer(Object node) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<JDOMNodePointer> constructor = JDOMNodePointer.class.getDeclaredConstructor(Object.class, Locale.class);
        constructor.setAccessible(true);
        return constructor.newInstance(node, null);
    }

    @Test
    void testGetNamespaceURI_WithElementWithNamespace() throws Exception {
        Namespace namespace = Namespace.getNamespace("http://example.com");
        Element element = new Element("testElement", namespace);
        JDOMNodePointer pointer = createJDOMNodePointer(element);
        String result = pointer.getNamespaceURI();
        assertEquals("http://example.com", result);
    }

    @Test
    void testGetNamespaceURI_WithElementWithoutNamespace() throws Exception {
        Element element = new Element("testElement");
        JDOMNodePointer pointer = createJDOMNodePointer(element);
        String result = pointer.getNamespaceURI();
        assertNull(result);
    }

    @Test
    void testGetNamespaceURI_WithEmptyNamespace() throws Exception {
        Element element = new Element("testElement", Namespace.NO_NAMESPACE);
        JDOMNodePointer pointer = createJDOMNodePointer(element);
        String result = pointer.getNamespaceURI();
        assertNull(result);
    }

    @Test
    void testGetNamespaceURI_WithNonElementObject() throws Exception {
        String nonElementObject = "Not an Element";
        JDOMNodePointer pointer = createJDOMNodePointer(nonElementObject);
        String result = pointer.getNamespaceURI();
        assertNull(result);
    }

    @Test
    void testGetNamespaceURI_WithNull() throws Exception {
        JDOMNodePointer pointer = createJDOMNodePointer(null);
        String result = pointer.getNamespaceURI();
        assertNull(result);
    }
}
