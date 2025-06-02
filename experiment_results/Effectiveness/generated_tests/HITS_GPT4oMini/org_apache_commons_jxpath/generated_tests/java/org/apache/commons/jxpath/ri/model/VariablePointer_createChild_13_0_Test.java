package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.Variables;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class VariablePointer_createChild_13_0_Test {

    private Variables variables;

    private JXPathContext context;

    private QName qName;

    private VariablePointer variablePointer;

    @BeforeEach
    public void setUp() {
        variables = mock(Variables.class);
        qName = new QName("testVariable");
        context = mock(JXPathContext.class);
        variablePointer = new VariablePointer(variables, qName);
    }

    @Test
    public void testCreateChildWithValidIndex() {
        Object collection = new Object();
        when(variables.getVariable(qName.toString())).thenReturn(collection);
        AbstractFactory factory = mock(AbstractFactory.class);
        when(factory.createObject(eq(context), any(), eq(collection), eq(qName.toString()), anyInt())).thenReturn(true);
        // Directly use the factory mock in the context if applicable
        NodePointer child = variablePointer.createChild(context, qName, 0);
        assertNotNull(child);
        assertEquals(variablePointer, child);
    }

    @Test
    public void testCreateChildWithInvalidIndex() {
        Object collection = new Object();
        when(variables.getVariable(qName.toString())).thenReturn(collection);
        AbstractFactory factory = mock(AbstractFactory.class);
        when(factory.createObject(eq(context), any(), eq(collection), eq(qName.toString()), anyInt())).thenReturn(false);
        // Directly use the factory mock in the context if applicable
        assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createChild(context, qName, 1);
        });
    }

    @Test
    public void testCreateChildWhenNotActual() {
        VariablePointer notActualPointer = new VariablePointer(qName);
        assertEquals(notActualPointer, notActualPointer.createChild(context, qName, 0));
    }

    @Test
    public void testCreateChildWithWholeCollection() {
        Object collection = new Object();
        when(variables.getVariable(qName.toString())).thenReturn(collection);
        AbstractFactory factory = mock(AbstractFactory.class);
        when(factory.createObject(eq(context), any(), eq(collection), eq(qName.toString()), eq(VariablePointer.WHOLE_COLLECTION))).thenReturn(true);
        NodePointer child = variablePointer.createChild(context, qName, VariablePointer.WHOLE_COLLECTION);
        assertNotNull(child);
        assertEquals(variablePointer, child);
    }

    @Test
    public void testCreateChildWithNullCollection() {
        when(variables.getVariable(qName.toString())).thenReturn(null);
        assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createChild(context, qName, 0);
        });
    }

    @Test
    public void testCreateChildWithNegativeIndex() {
        assertThrows(JXPathInvalidAccessException.class, () -> {
            variablePointer.createChild(context, qName, -1);
        });
    }
}
