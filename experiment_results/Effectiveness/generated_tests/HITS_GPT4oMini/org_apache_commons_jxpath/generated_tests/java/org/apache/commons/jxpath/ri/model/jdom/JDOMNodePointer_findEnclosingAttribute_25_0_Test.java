package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

public class JDOMNodePointer_findEnclosingAttribute_25_0_Test {

    private JDOMNodePointer pointer;

    @BeforeEach
    public void setUp() {
        // Setting up a default node for tests
        Element root = new Element("root");
        pointer = new JDOMNodePointer(root, null);
    }

    @Test
    public void testFindEnclosingAttribute_withExistingAttribute() {
        Element child = new Element("child");
        child.setAttribute(new Attribute("attr", "value", Namespace.NO_NAMESPACE));
        ((Element) pointer.getImmediateNode()).addContent(child);
        String result = JDOMNodePointer.findEnclosingAttribute(child, "attr", Namespace.NO_NAMESPACE);
        assertEquals("value", result);
    }

    @Test
    public void testFindEnclosingAttribute_withEmptyAttribute() {
        Element child = new Element("child");
        child.setAttribute(new Attribute("attr", "", Namespace.NO_NAMESPACE));
        ((Element) pointer.getImmediateNode()).addContent(child);
        String result = JDOMNodePointer.findEnclosingAttribute(child, "attr", Namespace.NO_NAMESPACE);
        assertEquals("", result);
    }

    @Test
    public void testFindEnclosingAttribute_withNonExistentAttribute() {
        Element child = new Element("child");
        ((Element) pointer.getImmediateNode()).addContent(child);
        String result = JDOMNodePointer.findEnclosingAttribute(child, "attr", Namespace.NO_NAMESPACE);
        assertNull(result);
    }

    @Test
    public void testFindEnclosingAttribute_withNestedElements() {
        Element child = new Element("child");
        child.setAttribute(new Attribute("attr", "value", Namespace.NO_NAMESPACE));
        Element grandChild = new Element("grandChild");
        grandChild.setAttribute(new Attribute("attr", "ignoredValue", Namespace.NO_NAMESPACE));
        child.addContent(grandChild);
        ((Element) pointer.getImmediateNode()).addContent(child);
        String result = JDOMNodePointer.findEnclosingAttribute(grandChild, "attr", Namespace.NO_NAMESPACE);
        assertEquals("value", result);
    }

    @Test
    public void testFindEnclosingAttribute_withDifferentNamespace() {
        Namespace ns = Namespace.getNamespace("test", "http://example.com/test");
        Element child = new Element("child");
        child.setAttribute(new Attribute("attr", "value", ns));
        ((Element) pointer.getImmediateNode()).addContent(child);
        String result = JDOMNodePointer.findEnclosingAttribute(child, "attr", Namespace.NO_NAMESPACE);
        assertNull(result);
    }

    @Test
    public void testFindEnclosingAttribute_withMultipleLevels() {
        Element parent = new Element("parent");
        Element child = new Element("child");
        child.setAttribute(new Attribute("attr", "value", Namespace.NO_NAMESPACE));
        Element grandChild = new Element("grandChild");
        parent.addContent(child);
        child.addContent(grandChild);
        ((Element) pointer.getImmediateNode()).addContent(parent);
        String result = JDOMNodePointer.findEnclosingAttribute(grandChild, "attr", Namespace.NO_NAMESPACE);
        assertEquals("value", result);
    }

    @Test
    public void testFindEnclosingAttribute_withNullNode() {
        String result = JDOMNodePointer.findEnclosingAttribute(null, "attr", Namespace.NO_NAMESPACE);
        assertNull(result);
    }
}
