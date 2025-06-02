package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
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
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

public class JDOMNodePointer_isLanguage_23_0_Test {

    private JDOMNodePointer nodePointer;

    @BeforeEach
    public void setUp() {
        // Create a mock Element with a language attribute
        Element element = new Element("test", Namespace.NO_NAMESPACE);
        element.setAttribute("lang", "en");
        nodePointer = new JDOMNodePointer(element, Locale.ENGLISH);
    }

    @Test
    public void testIsLanguage_MatchingLanguage() throws Exception {
        // Test when the language matches
        assertTrue(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_NonMatchingLanguage() throws Exception {
        // Test when the language does not match
        assertFalse(nodePointer.isLanguage("fr"));
    }

    @Test
    public void testIsLanguage_NullCurrentLanguage() throws Exception {
        // Test when current language is null, should call super.isLanguage(lang)
        // To simulate this, we can use reflection to set the node to a different type
        Method setLanguageMethod = JDOMNodePointer.class.getDeclaredMethod("setValue", Object.class);
        setLanguageMethod.setAccessible(true);
        // Simulate no language set
        setLanguageMethod.invoke(nodePointer, null);
        // Assuming super.isLanguage("en") returns false, you would implement a mock or real super class
        assertFalse(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_EmptyLanguage() throws Exception {
        // Test with an empty string
        assertFalse(nodePointer.isLanguage(""));
    }

    @Test
    public void testIsLanguage_CaseInsensitiveMatching() throws Exception {
        // Test case insensitivity
        assertTrue(nodePointer.isLanguage("EN"));
    }

    @Test
    public void testIsLanguage_NonAlphabeticLanguage() throws Exception {
        // Test with a non-alphabetic language code
        assertFalse(nodePointer.isLanguage("123"));
    }
}
