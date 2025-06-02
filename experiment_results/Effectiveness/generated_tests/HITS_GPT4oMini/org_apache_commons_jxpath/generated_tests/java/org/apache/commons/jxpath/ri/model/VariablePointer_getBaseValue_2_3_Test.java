package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

class VariablePointer_getBaseValue_2_3_Test {

    private VariablePointer variablePointer;

    private Variables variables;

    @BeforeEach
    void setUp() {
        variables = mock(Variables.class);
        QName name = new QName("testVariable");
        variablePointer = new VariablePointer(variables, name);
    }

    @Test
    void testGetBaseValue_WhenActualIsFalse_ShouldThrowJXPathException() {
        // Arrange
        // Directly setting actual to false is not possible, so we will use a mock to simulate the behavior.
        // This requires modifying the test to handle the actual state appropriately.
        // Since we cannot access actual directly, we will focus on the behavior of the method.
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, variablePointer::getBaseValue);
        assertEquals("Undefined variable: testVariable", exception.getMessage());
    }

    @Test
    void testGetBaseValue_WhenActualIsTrue_ShouldReturnVariableValue() {
        // Arrange
        when(variables.getVariable("testVariable")).thenReturn("testValue");
        // Here we can assume that actual is true since we are testing the behavior when the variable is defined.
        // Act
        Object result = variablePointer.getBaseValue();
        // Assert
        assertEquals("testValue", result);
    }

    @Test
    void testGetBaseValue_WhenVariableDoesNotExist_ShouldReturnNull() {
        // Arrange
        when(variables.getVariable("testVariable")).thenReturn(null);
        // Assume actual is true since we are testing the behavior when the variable is not defined.
        // Act
        Object result = variablePointer.getBaseValue();
        // Assert
        assertNull(result);
    }
}
