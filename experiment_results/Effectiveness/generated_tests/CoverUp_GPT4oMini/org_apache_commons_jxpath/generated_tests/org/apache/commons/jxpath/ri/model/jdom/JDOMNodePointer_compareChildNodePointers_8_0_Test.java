package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.Text;
import java.util.Locale;
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
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JDOMNodePointer_compareChildNodePointers_8_0_Test {

    private JDOMNodePointer pointer;

    @BeforeEach
    public void setUp() {
        Element element = new Element("root");
        pointer = new JDOMNodePointer(element, Locale.getDefault());
    }

    @Test
    public void testCompareChildNodePointers_SameNode() {
        NodePointer pointer1 = new JDOMNodePointer(new Text("child1"), Locale.getDefault());
        // Same instance
        NodePointer pointer2 = pointer1;
        int result = pointer.compareChildNodePointers(pointer1, pointer2);
        assertEquals(0, result);
    }

    @Test
    public void testCompareChildNodePointers_AttributeVsElement() {
        NodePointer attrPointer = new JDOMNodePointer(new Attribute("attr", "value"), Locale.getDefault());
        NodePointer elemPointer = new JDOMNodePointer(new Element("child"), Locale.getDefault());
        int result1 = pointer.compareChildNodePointers(attrPointer, elemPointer);
        // Attribute should come before Element
        assertEquals(-1, result1);
        int result2 = pointer.compareChildNodePointers(elemPointer, attrPointer);
        // Element should come after Attribute
        assertEquals(1, result2);
    }

    @Test
    public void testCompareChildNodePointers_Attributes() {
        Element parent = new Element("parent");
        Attribute attr1 = new Attribute("attr1", "value1");
        Attribute attr2 = new Attribute("attr2", "value2");
        parent.setAttribute(attr1);
        parent.setAttribute(attr2);
        JDOMNodePointer parentPointer = new JDOMNodePointer(parent, Locale.getDefault());
        NodePointer pointer1 = new JDOMNodePointer(attr1, Locale.getDefault());
        NodePointer pointer2 = new JDOMNodePointer(attr2, Locale.getDefault());
        int result = parentPointer.compareChildNodePointers(pointer1, pointer2);
        // attr1 should come before attr2
        assertEquals(-1, result);
    }

    @Test
    public void testCompareChildNodePointers_ChildNodes() {
        Element parent = new Element("parent");
        Element child1 = new Element("child1");
        Element child2 = new Element("child2");
        parent.addContent(child1);
        parent.addContent(child2);
        JDOMNodePointer parentPointer = new JDOMNodePointer(parent, Locale.getDefault());
        NodePointer pointer1 = new JDOMNodePointer(child1, Locale.getDefault());
        NodePointer pointer2 = new JDOMNodePointer(child2, Locale.getDefault());
        int result = parentPointer.compareChildNodePointers(pointer1, pointer2);
        // child1 should come before child2
        assertEquals(-1, result);
    }

    @Test
    public void testCompareChildNodePointers_NonElementNode() {
        JDOMNodePointer nonElementPointer = new JDOMNodePointer(new Text("text"), Locale.getDefault());
        NodePointer pointer1 = new JDOMNodePointer(new Text("text1"), Locale.getDefault());
        NodePointer pointer2 = new JDOMNodePointer(new Text("text2"), Locale.getDefault());
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            nonElementPointer.compareChildNodePointers(pointer1, pointer2);
        });
        assertEquals("JXPath internal error: compareChildNodes called for " + nonElementPointer.getBaseValue(), exception.getMessage());
    }
}
