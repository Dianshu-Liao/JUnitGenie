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

public class JDOMNodePointer_isLanguage_23_0_Test {

    private JDOMNodePointer nodePointer;

    @BeforeEach
    public void setUp() {
        // Create a basic JDOM Element with a language attribute for testing
        Element element = new Element("testElement", Namespace.NO_NAMESPACE);
        nodePointer = new JDOMNodePointer(element, Locale.ENGLISH);
    }

    @Test
    public void testIsLanguage_WithNullLanguage() {
        // When current language is null, should call super.isLanguage(lang)
        assertFalse(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_WithMatchingLanguage() {
        // Simulate a scenario where the language is set to "en"
        ((Element) nodePointer.getImmediateNode()).setAttribute("lang", "en");
        assertTrue(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_WithPartialMatchingLanguage() {
        // Simulate a scenario where the language is set to "en-US"
        ((Element) nodePointer.getImmediateNode()).setAttribute("lang", "en-US");
        assertTrue(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_WithDifferentLanguage() {
        // Simulate a scenario where the language is set to "fr"
        ((Element) nodePointer.getImmediateNode()).setAttribute("lang", "fr");
        assertFalse(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_WithCaseInsensitiveMatching() {
        // Simulate a scenario where the language is set to "EN"
        ((Element) nodePointer.getImmediateNode()).setAttribute("lang", "EN");
        assertTrue(nodePointer.isLanguage("en"));
    }

    @Test
    public void testIsLanguage_WithNullCurrentLanguage() {
        // Simulate a scenario where the language attribute is not set
        ((Element) nodePointer.getImmediateNode()).setAttribute("lang", null);
        assertFalse(nodePointer.isLanguage("en"));
    }
}
