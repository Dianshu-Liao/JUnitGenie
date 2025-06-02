package org.apache.commons.jxpath.ri.model.jdom;

import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class JDOMNodePointer_getRelativePositionOfPI_36_1_Test {

    private JDOMNodePointer pointer;

    private Element parentElement;

    private ProcessingInstruction processingInstruction;

    @BeforeEach
    public void setUp() {
        parentElement = new Element("parent");
        processingInstruction = new ProcessingInstruction("target", "data");
        parentElement.addContent(processingInstruction);
        pointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
    }

    @Test
    public void testGetRelativePositionOfPI_WhenParentIsNull() throws Exception {
        // Create a ProcessingInstruction with no parent
        ProcessingInstruction piWithoutParent = new ProcessingInstruction("target", "data");
        JDOMNodePointer pointerWithoutParent = new JDOMNodePointer(piWithoutParent, Locale.getDefault());
        // Use reflection to call the private method
        int position = (int) getPrivateMethod(pointerWithoutParent, "getRelativePositionOfPI");
        assertEquals(1, position);
    }

    @Test
    public void testGetRelativePositionOfPI_WhenNoMatchingPI() throws Exception {
        // Add another ProcessingInstruction to the parent
        ProcessingInstruction piOther = new ProcessingInstruction("other", "data");
        parentElement.addContent(piOther);
        pointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
        // Use reflection to call the private method
        int position = (int) getPrivateMethod(pointer, "getRelativePositionOfPI");
        // Since the target does not match
        assertEquals(1, position);
    }

    @Test
    public void testGetRelativePositionOfPI_WhenMultipleMatchingPI() throws Exception {
        // Add two matching ProcessingInstructions to the parent
        ProcessingInstruction pi1 = new ProcessingInstruction("target", "data1");
        ProcessingInstruction pi2 = new ProcessingInstruction("target", "data2");
        parentElement.addContent(pi1);
        parentElement.addContent(pi2);
        pointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
        // Use reflection to call the private method
        int position = (int) getPrivateMethod(pointer, "getRelativePositionOfPI");
        // There are two matching PIs before the current one
        assertEquals(2, position);
    }

    @Test
    public void testGetRelativePositionOfPI_WhenNodeIsFirst() throws Exception {
        // Add a ProcessingInstruction before the current one
        ProcessingInstruction piBefore = new ProcessingInstruction("target", "data");
        parentElement.addContent(0, piBefore);
        pointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
        // Use reflection to call the private method
        int position = (int) getPrivateMethod(pointer, "getRelativePositionOfPI");
        // The current one is the first matching PI
        assertEquals(1, position);
    }

    @Test
    public void testGetRelativePositionOfPI_WhenNodeIsLast() throws Exception {
        // Add a ProcessingInstruction after the current one
        ProcessingInstruction piAfter = new ProcessingInstruction("target", "data");
        parentElement.addContent(piAfter);
        pointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
        // Use reflection to call the private method
        int position = (int) getPrivateMethod(pointer, "getRelativePositionOfPI");
        // The current one is the first matching PI
        assertEquals(1, position);
    }

    private Object getPrivateMethod(JDOMNodePointer pointer, String methodName) throws Exception {
        java.lang.reflect.Method method = JDOMNodePointer.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(pointer);
    }
}
