package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

class VariablePointer_createChild_13_0_Test {

    private VariablePointer variablePointer;

    private JXPathContext context;

    private QName name;

    private Variables variables;

    @BeforeEach
    void setUp() {
        name = new QName("testVariable");
        variables = mock(Variables.class);
        variablePointer = new VariablePointer(variables, name);
        context = mock(JXPathContext.class);
    }

    @Test
    void testCreateChild_Success() {
        Object collection = new Object();
        when(variables.getVariable(name.toString())).thenReturn(collection);
        when(context.getVariables()).thenReturn(variables);
        NodePointer child = variablePointer.createChild(context, name, 0);
        assertNotNull(child);
        assertEquals(variablePointer, child);
    }

    @Test
    void testCreateChild_ActualFalse() {
        VariablePointer nonActualVariablePointer = new VariablePointer(name);
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            nonActualVariablePointer.createChild(context, name, 1);
        });
        assertEquals("Factory could not create object path: " + nonActualVariablePointer.asPath(), exception.getMessage());
    }

    @Test
    void testCreateChild_IndexOutOfBounds() {
        Object collection = new Object();
        when(variables.getVariable(name.toString())).thenReturn(collection);
        when(context.getVariables()).thenReturn(variables);
        // Simulating the behavior of createCollection
        when(variables.getVariable(name.toString())).thenReturn(null);
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createChild(context, name, 5);
        });
        assertTrue(exception.getMessage().contains("Factory did not assign a collection to variable"));
    }

    @Test
    void testCreateChild_NegativeIndex() {
        JXPathInvalidAccessException exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            variablePointer.createChild(context, name, -1);
        });
        assertEquals("Index is less than 1: " + variablePointer.asPath(), exception.getMessage());
    }

    @Test
    void testCreateChild_FactoryFailure() {
        Object collection = new Object();
        when(variables.getVariable(name.toString())).thenReturn(collection);
        when(context.getVariables()).thenReturn(variables);
        AbstractFactory factory = mock(AbstractFactory.class);
        when(factory.createObject(context, variablePointer, collection, name.toString(), 0)).thenReturn(false);
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createChild(context, name, 0);
        });
        assertEquals("Factory could not create object path: " + variablePointer.asPath(), exception.getMessage());
    }
}
