package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.Variables;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class VariablePointer_hashCode_18_1_Test {

    private Variables variables;

    private QName qName;

    private VariablePointer variablePointer;

    @BeforeEach
    public void setUp() {
        // Use a mock instead of instantiating Variables
        variables = mock(Variables.class);
        qName = new QName("testName");
        variablePointer = new VariablePointer(variables, qName);
    }

    @Test
    public void testHashCodeWhenActualIsTrue() {
        // Set the actual variable to true
        setActual(true);
        // Calculate expected hash code
        int expectedHashCode = System.identityHashCode(variables) + qName.hashCode() + variablePointer.getIndex();
        // Assert hash code
        assertEquals(expectedHashCode, variablePointer.hashCode());
    }

    @Test
    public void testHashCodeWhenActualIsFalse() {
        // Set the actual variable to false
        setActual(false);
        // Calculate expected hash code
        int expectedHashCode = 0 + qName.hashCode() + variablePointer.getIndex();
        // Assert hash code
        assertEquals(expectedHashCode, variablePointer.hashCode());
    }

    @Test
    public void testGetBaseValueWhenActualIsFalse() {
        setActual(false);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            variablePointer.getBaseValue();
        });
        assertEquals("Undefined variable: testName", exception.getMessage());
    }

    private void setActual(boolean actual) {
        try {
            java.lang.reflect.Field actualField = VariablePointer.class.getDeclaredField("actual");
            actualField.setAccessible(true);
            actualField.set(variablePointer, actual);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
