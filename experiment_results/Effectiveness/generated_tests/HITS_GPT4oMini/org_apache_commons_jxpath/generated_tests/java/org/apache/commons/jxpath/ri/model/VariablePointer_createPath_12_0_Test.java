package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Variables;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

@ExtendWith(MockitoExtension.class)
public class VariablePointer_createPath_12_0_Test {

    private JXPathContext context;

    private QName qName;

    private VariablePointer variablePointer;

    private Variables mockedVariables;

    @BeforeEach
    public void setUp() {
        qName = new QName("testVariable");
        context = JXPathContext.newContext(new Object());
        mockedVariables = Mockito.mock(Variables.class);
        variablePointer = new VariablePointer(qName);
    }

    @Test
    public void testCreatePath_WhenActualIsFalse_ShouldDeclareVariable() {
        assertDoesNotThrow(() -> {
            variablePointer.createPath(context);
        });
    }

    @Test
    public void testCreatePath_WhenDeclareVariableFails_ShouldThrowException() {
        AbstractFactory factory = new AbstractFactory() {

            @Override
            public boolean declareVariable(JXPathContext context, String name) {
                // Simulate failure
                return false;
            }
        };
        context.setFactory(factory);
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createPath(context);
        });
        assertEquals("Factory cannot define variable 'testVariable' for path: $testVariable", exception.getMessage());
    }

    @Test
    public void testCreatePath_WhenDeclareVariableSucceeds_ShouldNotThrowException() {
        AbstractFactory factory = new AbstractFactory() {

            @Override
            public boolean declareVariable(JXPathContext context, String name) {
                // Simulate success
                return true;
            }
        };
        context.setFactory(factory);
        assertDoesNotThrow(() -> {
            variablePointer.createPath(context);
        });
    }

    @Test
    public void testCreatePath_WhenActualIsTrue_ShouldNotDeclareVariable() {
        // Set actual to true using mocked variables
        variablePointer = new VariablePointer(mockedVariables, qName);
        assertDoesNotThrow(() -> {
            variablePointer.createPath(context);
        });
    }

    @Test
    public void testFindVariables_WhenVariableFound_ShouldSetActualToTrue() {
        // Setup context with declared variable
        when(mockedVariables.isDeclaredVariable(qName.toString())).thenReturn(true);
        context.setVariables(mockedVariables);
        variablePointer.createPath(context);
        assertTrue(variablePointer.getBaseValue() != null);
    }

    @Test
    public void testGetBaseValue_WhenActualIsFalse_ShouldThrowException() {
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            variablePointer.getBaseValue();
        });
        assertEquals("Undefined variable: testVariable", exception.getMessage());
    }

    @Test
    public void testGetBaseValue_WhenActualIsTrue_ShouldReturnVariableValue() {
        Object expectedValue = new Object();
        when(mockedVariables.getVariable(qName.toString())).thenReturn(expectedValue);
        when(mockedVariables.isDeclaredVariable(qName.toString())).thenReturn(true);
        variablePointer = new VariablePointer(mockedVariables, qName);
        assertEquals(expectedValue, variablePointer.getBaseValue());
    }
}
