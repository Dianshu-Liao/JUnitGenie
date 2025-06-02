package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import java.lang.reflect.Method;
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
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

public class JDOMNodePointer_findEnclosingAttribute_25_1_Test {

    private JDOMNodePointer jdomNodePointer;

    @BeforeEach
    public void setUp() {
        // Initialize with a dummy node (can be any valid object)
        jdomNodePointer = new JDOMNodePointer(new Element("root"), Locale.getDefault());
    }

    @Test
    public void testFindEnclosingAttribute_WithAttributePresent() throws Exception {
        // Create a parent element with an attribute
        Element parent = new Element("parent");
        parent.setAttribute(new Attribute("lang", "en", Namespace.XML_NAMESPACE));
        ((Element) jdomNodePointer.getImmediateNode()).addContent(parent);
        // Use reflection to call the private method
        Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, parent, "lang", Namespace.XML_NAMESPACE);
        assertEquals("en", result);
    }

    @Test
    public void testFindEnclosingAttribute_WithAttributeNotPresent() throws Exception {
        // Create a parent element without the attribute
        Element parent = new Element("parent");
        ((Element) jdomNodePointer.getImmediateNode()).addContent(parent);
        // Use reflection to call the private method
        Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, parent, "lang", Namespace.XML_NAMESPACE);
        assertNull(result);
    }

    @Test
    public void testFindEnclosingAttribute_WithMultipleLevels() throws Exception {
        // Create a hierarchy of elements
        Element child = new Element("child");
        Element parent = new Element("parent");
        parent.setAttribute(new Attribute("lang", "fr", Namespace.XML_NAMESPACE));
        parent.addContent(child);
        ((Element) jdomNodePointer.getImmediateNode()).addContent(parent);
        // Use reflection to call the private method
        Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, child, "lang", Namespace.XML_NAMESPACE);
        assertEquals("fr", result);
    }

    @Test
    public void testFindEnclosingAttribute_WithNullNode() throws Exception {
        // Use reflection to call the private method
        Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, null, "lang", Namespace.XML_NAMESPACE);
        assertNull(result);
    }

    @Test
    public void testFindEnclosingAttribute_WithEmptyAttribute() throws Exception {
        // Create a parent element with an empty attribute
        Element parent = new Element("parent");
        parent.setAttribute(new Attribute("lang", "", Namespace.XML_NAMESPACE));
        ((Element) jdomNodePointer.getImmediateNode()).addContent(parent);
        // Use reflection to call the private method
        Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, parent, "lang", Namespace.XML_NAMESPACE);
        assertNull(result);
    }
}
