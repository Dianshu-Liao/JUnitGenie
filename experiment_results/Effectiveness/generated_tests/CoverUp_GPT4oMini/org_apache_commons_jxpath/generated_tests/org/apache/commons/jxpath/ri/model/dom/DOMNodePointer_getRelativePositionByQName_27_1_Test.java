package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.*;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.TypeUtils;

class DOMNodePointer_getRelativePositionByQName_27_1_Test {

    private DOMNodePointer domNodePointer;

    private Node mockNode;

    @BeforeEach
    void setUp() {
        // Create a mock Document and Node structure
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            // Create elements
            Element root = document.createElement("root");
            Element child1 = document.createElement("child");
            Element child2 = document.createElement("child");
            Element child3 = document.createElement("child");
            // Set attributes for QName matching
            child1.setAttribute("xmlns", "http://example.com");
            child2.setAttribute("xmlns", "http://example.com");
            child3.setAttribute("xmlns", "http://example.com");
            // Build the structure
            root.appendChild(child1);
            root.appendChild(child2);
            root.appendChild(child3);
            document.appendChild(root);
            // Set mockNode to child3
            mockNode = child3;
            // Instantiate DOMNodePointer
            domNodePointer = new DOMNodePointer(mockNode, Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetRelativePositionByQName_NoMatchingSibling() throws Exception {
        // Set mockNode to a child with no matching siblings
        Node child4 = Mockito.mock(Element.class);
        Mockito.when(mockNode.getPreviousSibling()).thenReturn(child4);
        Mockito.when(child4.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(child4.getNodeName()).thenReturn("differentChild");
        // Use reflection to invoke the private method
        int position = (int) invokePrivateMethod("getRelativePositionByQName");
        assertEquals(1, position);
    }

    @Test
    void testGetRelativePositionByQName_OneMatchingSibling() throws Exception {
        // Create a matching sibling
        Node child4 = Mockito.mock(Element.class);
        Mockito.when(mockNode.getPreviousSibling()).thenReturn(child4);
        Mockito.when(child4.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(child4.getNodeName()).thenReturn("child");
        // Use reflection to invoke the private method
        int position = (int) invokePrivateMethod("getRelativePositionByQName");
        assertEquals(2, position);
    }

    @Test
    void testGetRelativePositionByQName_MultipleMatchingSiblings() throws Exception {
        // Create multiple matching siblings
        Node child4 = Mockito.mock(Element.class);
        Node child5 = Mockito.mock(Element.class);
        Mockito.when(mockNode.getPreviousSibling()).thenReturn(child5);
        Mockito.when(child5.getPreviousSibling()).thenReturn(child4);
        Mockito.when(child4.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(child4.getNodeName()).thenReturn("child");
        Mockito.when(child5.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(child5.getNodeName()).thenReturn("child");
        // Use reflection to invoke the private method
        int position = (int) invokePrivateMethod("getRelativePositionByQName");
        assertEquals(3, position);
    }

    @Test
    void testGetRelativePositionByQName_OnlyTextNodes() throws Exception {
        // Create text nodes as siblings
        Node child4 = Mockito.mock(Text.class);
        Node child5 = Mockito.mock(Text.class);
        Mockito.when(mockNode.getPreviousSibling()).thenReturn(child5);
        Mockito.when(child5.getPreviousSibling()).thenReturn(child4);
        Mockito.when(child4.getNodeType()).thenReturn(Node.TEXT_NODE);
        Mockito.when(child5.getNodeType()).thenReturn(Node.TEXT_NODE);
        // Use reflection to invoke the private method
        int position = (int) invokePrivateMethod("getRelativePositionByQName");
        assertEquals(1, position);
    }

    // Helper method to invoke private methods using reflection
    private Object invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(domNodePointer);
    }
}
