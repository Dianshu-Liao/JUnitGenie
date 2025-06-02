package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Locale;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

public class DOMNodePointer_getRelativePositionByQName_27_0_Test {

    private Document document;

    private Element rootElement;

    private Element childElement1;

    private Element childElement2;

    private Element childElement3;

    private DOMNodePointer nodePointer;

    @BeforeEach
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        rootElement = document.createElement("root");
        document.appendChild(rootElement);
        childElement1 = document.createElement("child");
        rootElement.appendChild(childElement1);
        childElement2 = document.createElement("child");
        rootElement.appendChild(childElement2);
        childElement3 = document.createElement("child");
        rootElement.appendChild(childElement3);
        // Set the nodePointer to childElement3
        nodePointer = new DOMNodePointer(childElement3, null);
    }

    @Test
    public void testGetRelativePositionByQName_WithMatchingQName() throws Exception {
        // Simulate the scenario where childElement2 has the same QName
        Element newChildElement2 = document.createElement("child");
        rootElement.replaceChild(newChildElement2, childElement2);
        int position = invokeGetRelativePositionByQName(nodePointer);
        assertEquals(2, position, "The relative position should be 2 for matching QName.");
    }

    @Test
    public void testGetRelativePositionByQName_WithDifferentQName() throws Exception {
        // Change the name of childElement2 to something else
        Element newChildElement2 = document.createElement("differentChild");
        rootElement.replaceChild(newChildElement2, childElement2);
        int position = invokeGetRelativePositionByQName(nodePointer);
        assertEquals(1, position, "The relative position should be 1 for non-matching QName.");
    }

    @Test
    public void testGetRelativePositionByQName_WithNoPreviousSibling() throws Exception {
        // Set nodePointer to rootElement
        nodePointer = new DOMNodePointer(rootElement, null);
        int position = invokeGetRelativePositionByQName(nodePointer);
        assertEquals(1, position, "The relative position should be 1 when there are no previous siblings.");
    }

    private int invokeGetRelativePositionByQName(DOMNodePointer nodePointer) throws Exception {
        Method method = DOMNodePointer.class.getDeclaredMethod("getRelativePositionByQName");
        method.setAccessible(true);
        return (int) method.invoke(nodePointer);
    }
}
