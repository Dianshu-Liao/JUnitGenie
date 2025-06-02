package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_createChild_23_0_Test {

    private DOMNodePointer domNodePointer;

    private Document document;

    private JXPathContext context;

    private Element root;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a new Document for testing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        // Create a root element
        root = document.createElement("root");
        document.appendChild(root);
        // Initialize DOMNodePointer with the root element
        domNodePointer = new DOMNodePointer(root, null);
        context = mock(JXPathContext.class);
    }

    @Test
    public void testCreateChild() {
        QName childQName = new QName("child");
        Object childValue = document.createElement("childElement");
        NodePointer childPointer = domNodePointer.createChild(context, childQName, 0, childValue);
        // Verify that the child was added to the root
        assertNotNull(childPointer);
        assertEquals("childElement", root.getFirstChild().getNodeName());
    }

    @Test
    public void testCreateChildWithValue() {
        QName childQName = new QName("child");
        String childValue = "Child text";
        NodePointer childPointer = domNodePointer.createChild(context, childQName, 0, childValue);
        // Verify that the child was added with the correct value
        assertNotNull(childPointer);
        assertEquals(childValue, root.getFirstChild().getNodeValue());
    }

    @Test
    public void testCreateChildWithNullValue() {
        QName childQName = new QName("child");
        NodePointer childPointer = domNodePointer.createChild(context, childQName, 0, null);
        // Verify that the child was added with no value
        assertNotNull(childPointer);
        assertNull(root.getFirstChild());
    }

    @Test
    public void testCreateChildWithIndex() {
        QName childQName1 = new QName("child1");
        QName childQName2 = new QName("child2");
        Object childValue1 = document.createElement("childElement1");
        Object childValue2 = document.createElement("childElement2");
        domNodePointer.createChild(context, childQName1, 0, childValue1);
        NodePointer childPointer2 = domNodePointer.createChild(context, childQName2, 1, childValue2);
        // Verify that the second child was added at the correct index
        assertNotNull(childPointer2);
        assertEquals("childElement2", root.getChildNodes().item(1).getNodeName());
    }

    @Test
    public void testCreateChildWithInvalidIndex() {
        QName childQName = new QName("child");
        Object childValue = document.createElement("childElement");
        // Attempt to create a child with an invalid index
        Exception exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            domNodePointer.createChild(context, childQName, -1, childValue);
        });
        String expectedMessage = "Factory could not create a child node for path: /child[-1]";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
