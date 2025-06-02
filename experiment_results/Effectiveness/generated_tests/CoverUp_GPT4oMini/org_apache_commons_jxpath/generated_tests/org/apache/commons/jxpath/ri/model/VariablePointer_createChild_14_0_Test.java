package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.JXPathException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class VariablePointer_createChild_14_0_Test {

    private VariablePointer variablePointer;

    private Variables variables;

    private QName qName;

    private JXPathContext context;

    @BeforeEach
    void setUp() {
        variables = Mockito.mock(Variables.class);
        qName = new QName("testVariable");
        variablePointer = new VariablePointer(variables, qName);
        context = JXPathContext.newContext(variables);
    }

    @Test
    void testCreateChildValid() {
        Object value = "childValue";
        int index = 0;
        // Create a child node
        NodePointer child = variablePointer.createChild(context, qName, index, value);
        assertNotNull(child);
        assertTrue(child instanceof VariablePointer);
    }

    @Test
    void testCreateChildWithNullCollection() {
        int index = 0;
        // Expecting an exception since the collection is not initialized
        assertThrows(JXPathException.class, () -> {
            variablePointer.createChild(context, qName, index, null);
        });
    }

    @Test
    void testCreateChildWithInvalidIndex() {
        Object value = "childValue";
        int index = -1;
        // Expecting an exception due to invalid index
        assertThrows(JXPathException.class, () -> {
            variablePointer.createChild(context, qName, index, value);
        });
    }

    @Test
    void testCreateChildWithOutOfBoundsIndex() {
        Object value = "childValue";
        // Assuming the collection has less than 6 elements
        int index = 5;
        // Expecting an exception due to index out of bounds
        assertThrows(JXPathException.class, () -> {
            variablePointer.createChild(context, qName, index, value);
        });
    }

    @Test
    void testCreateChildWithValidCollection() throws Exception {
        // Initialize collection in variables
        Object[] mockCollection = new Object[10];
        when(variables.getVariable("testVariable")).thenReturn(mockCollection);
        Object value = "childValue";
        int index = 2;
        // Create a child node
        NodePointer child = variablePointer.createChild(context, qName, index, value);
        // Verify the value was set correctly
        Method getBaseValueMethod = VariablePointer.class.getDeclaredMethod("getBaseValue");
        getBaseValueMethod.setAccessible(true);
        Object collection = getBaseValueMethod.invoke(variablePointer);
        assertTrue(collection instanceof Object[]);
        assertEquals(value, ((Object[]) collection)[index]);
    }
}
