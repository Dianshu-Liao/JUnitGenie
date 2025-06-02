package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Element;
import org.jdom.Namespace;
import java.util.Locale;
import java.lang.reflect.Method;
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

public class JDOMNodePointer_matchesQName_33_0_Test {

    private static class TestableJDOMNodePointer extends JDOMNodePointer {

        public TestableJDOMNodePointer(Object node, Locale locale) {
            super(node, locale);
        }

        public boolean testMatchesQName(Element element) {
            try {
                Method method = JDOMNodePointer.class.getDeclaredMethod("matchesQName", Element.class);
                method.setAccessible(true);
                return (Boolean) method.invoke(this, element);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private TestableJDOMNodePointer pointer;

    @BeforeEach
    public void setUp() {
        Element element = new Element("testElement", Namespace.getNamespace("http://example.com"));
        pointer = new TestableJDOMNodePointer(element, Locale.getDefault());
    }

    @Test
    public void testMatchesQName_SameNameAndNamespace() {
        Element testElement = new Element("testElement", Namespace.getNamespace("http://example.com"));
        assertTrue(pointer.testMatchesQName(testElement), "Expected to match the same name and namespace.");
    }

    @Test
    public void testMatchesQName_DifferentName() {
        Element testElement = new Element("differentElement", Namespace.getNamespace("http://example.com"));
        assertFalse(pointer.testMatchesQName(testElement), "Expected not to match due to different name.");
    }

    @Test
    public void testMatchesQName_DifferentNamespace() {
        Element testElement = new Element("testElement", Namespace.getNamespace("http://another-example.com"));
        assertFalse(pointer.testMatchesQName(testElement), "Expected not to match due to different namespace.");
    }

    @Test
    public void testMatchesQName_NullNamespace() {
        Element testElement = new Element("testElement");
        pointer = new TestableJDOMNodePointer(new Element("testElement", Namespace.getNamespace("http://example.com")), Locale.getDefault());
        assertFalse(pointer.testMatchesQName(testElement), "Expected not to match due to null namespace in element.");
    }

    @Test
    public void testMatchesQName_EmptyNamespace() {
        Element testElement = new Element("testElement", Namespace.NO_NAMESPACE);
        pointer = new TestableJDOMNodePointer(new Element("testElement", Namespace.getNamespace("http://example.com")), Locale.getDefault());
        assertFalse(pointer.testMatchesQName(testElement), "Expected not to match due to empty namespace.");
    }
}
