package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class VariablePointer_createChild_14_0_Test {

    private VariablePointer variablePointer;

    private JXPathContext context;

    private QName qName;

    @BeforeEach
    public void setUp() {
        qName = new QName("testVariable");
        variablePointer = new VariablePointer(qName);
        context = JXPathContext.newContext(new Object());
    }

    @Test
    public void testCreateChildWithValidParameters() {
        Object value = "childValue";
        int index = 0;
        NodePointer childPointer = variablePointer.createChild(context, qName, index, value);
        assertNotNull(childPointer, "Child pointer should not be null");
        assertEquals(index, childPointer.getIndex(), "Child pointer index should match the specified index");
    }

    @Test
    public void testCreateChildWithIndexGreaterThanLength() {
        Object value = "newValue";
        // Assuming length is less than 5
        int index = 5;
        NodePointer childPointer = variablePointer.createChild(context, qName, index, value);
        assertNotNull(childPointer, "Child pointer should not be null");
        assertEquals(index, childPointer.getIndex(), "Child pointer index should match the specified index");
    }

    @Test
    public void testCreateChildWithNegativeIndex() {
        Object value = "childValue";
        int index = -1;
        assertThrows(JXPathInvalidAccessException.class, () -> {
            variablePointer.createChild(context, qName, index, value);
        }, "Expected JXPathInvalidAccessException for negative index");
    }

    @Test
    public void testCreateChildWithNullValue() {
        Object value = null;
        int index = 0;
        NodePointer childPointer = variablePointer.createChild(context, qName, index, value);
        assertNotNull(childPointer, "Child pointer should not be null");
        assertEquals(index, childPointer.getIndex(), "Child pointer index should match the specified index");
    }

    @Test
    public void testCreateChildWithMultipleCalls() {
        Object value1 = "firstValue";
        Object value2 = "secondValue";
        int index1 = 0;
        int index2 = 1;
        NodePointer childPointer1 = variablePointer.createChild(context, qName, index1, value1);
        NodePointer childPointer2 = variablePointer.createChild(context, qName, index2, value2);
        assertNotNull(childPointer1, "First child pointer should not be null");
        assertNotNull(childPointer2, "Second child pointer should not be null");
        assertEquals(index1, childPointer1.getIndex(), "First child pointer index should match the specified index");
        assertEquals(index2, childPointer2.getIndex(), "Second child pointer index should match the specified index");
    }
}
