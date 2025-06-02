package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class VariablePointer_equals_19_1_Test {

    private Variables variables;

    private QName name;

    private VariablePointer variablePointer1;

    private VariablePointer variablePointer2;

    private VariablePointer variablePointer3;

    @BeforeEach
    void setUp() {
        // Using a mock for Variables since it is abstract
        variables = Mockito.mock(Variables.class);
        name = new QName("testName");
        variablePointer1 = new VariablePointer(variables, name);
        variablePointer2 = new VariablePointer(variables, name);
        variablePointer3 = new VariablePointer(Mockito.mock(Variables.class), new QName("anotherName"));
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(variablePointer1.equals(variablePointer1));
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(variablePointer1.equals(new Object()));
    }

    @Test
    void testEquals_DifferentVariables() {
        assertFalse(variablePointer1.equals(variablePointer3));
    }

    @Test
    void testEquals_SameVariablesAndName() {
        assertTrue(variablePointer1.equals(variablePointer2));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(variablePointer1.equals(null));
    }

    @Test
    void testEquals_DifferentNames() {
        variablePointer2 = new VariablePointer(variables, new QName("differentName"));
        assertFalse(variablePointer1.equals(variablePointer2));
    }
}
