package org.apache.commons.jxpath.ri.model;

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
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class VariablePointer_equals_19_0_Test {

    @Test
    public void testEquals_SameObject() {
        VariablePointer vp = new VariablePointer(mock(Variables.class), new QName("testName"));
        assertTrue(vp.equals(vp), "An object should equal itself.");
    }

    @Test
    public void testEquals_NullObject() {
        VariablePointer vp = new VariablePointer(mock(Variables.class), new QName("testName"));
        assertFalse(vp.equals(null), "An object should not equal null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        VariablePointer vp = new VariablePointer(mock(Variables.class), new QName("testName"));
        Object differentObject = new Object();
        assertFalse(vp.equals(differentObject), "An object should not equal an instance of a different class.");
    }

    @Test
    public void testEquals_DifferentVariables() {
        Variables var1 = mock(Variables.class);
        Variables var2 = mock(Variables.class);
        QName name = new QName("testName");
        VariablePointer vp1 = new VariablePointer(var1, name);
        VariablePointer vp2 = new VariablePointer(var2, name);
        assertFalse(vp1.equals(vp2), "VariablePointers with different Variables should not be equal.");
    }

    @Test
    public void testEquals_DifferentNames() {
        Variables variables = mock(Variables.class);
        QName name1 = new QName("testName1");
        QName name2 = new QName("testName2");
        VariablePointer vp1 = new VariablePointer(variables, name1);
        VariablePointer vp2 = new VariablePointer(variables, name2);
        assertFalse(vp1.equals(vp2), "VariablePointers with different QName names should not be equal.");
    }

    @Test
    public void testEquals_SameVariablesAndNames() {
        Variables variables = mock(Variables.class);
        QName name = new QName("testName");
        VariablePointer vp1 = new VariablePointer(variables, name);
        VariablePointer vp2 = new VariablePointer(variables, name);
        assertTrue(vp1.equals(vp2), "VariablePointers with the same Variables and QName should be equal.");
    }
}
