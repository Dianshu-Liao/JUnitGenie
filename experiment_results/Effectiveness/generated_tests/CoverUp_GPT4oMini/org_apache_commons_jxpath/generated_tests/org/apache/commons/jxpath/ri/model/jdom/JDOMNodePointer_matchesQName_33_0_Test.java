package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Element;
import org.jdom.Namespace;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import java.util.Locale;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

    private JDOMNodePointer nodePointer;

    @BeforeEach
    public void setUp() {
        Element element = new Element("testElement");
        nodePointer = new JDOMNodePointer(element, Locale.ENGLISH);
    }

    @Test
    public void testMatchesQName_SameNamespaceAndName() throws Exception {
        Element testElement = new Element("testElement", Namespace.NO_NAMESPACE);
        assertTrue(invokeMatchesQName(testElement));
    }

    @Test
    public void testMatchesQName_DifferentName() throws Exception {
        Element testElement = new Element("differentElement", Namespace.NO_NAMESPACE);
        assertFalse(invokeMatchesQName(testElement));
    }

    @Test
    public void testMatchesQName_DifferentNamespace() throws Exception {
        Element testElement = new Element("testElement", Namespace.getNamespace("http://different/namespace"));
        assertFalse(invokeMatchesQName(testElement));
    }

    @Test
    public void testMatchesQName_NullNamespace() throws Exception {
        Element testElement = new Element("testElement", Namespace.NO_NAMESPACE);
        assertTrue(invokeMatchesQName(testElement));
    }

    private boolean invokeMatchesQName(Element element) throws Exception {
        Method method = JDOMNodePointer.class.getDeclaredMethod("matchesQName", Element.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(nodePointer, element);
    }
}
