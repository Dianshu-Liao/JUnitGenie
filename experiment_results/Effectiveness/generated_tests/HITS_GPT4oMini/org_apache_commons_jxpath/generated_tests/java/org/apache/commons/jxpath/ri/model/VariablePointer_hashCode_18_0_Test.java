package org.apache.commons.jxpath.ri.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.Variables;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

@ExtendWith(MockitoExtension.class)
public class VariablePointer_hashCode_18_0_Test {

    private VariablePointer variablePointer;

    private QName qName;

    @Mock
    private Variables variables;

    @BeforeEach
    public void setUp() throws Exception {
        qName = new QName("testPrefix", "testName");
        variablePointer = new VariablePointer(variables, qName);
        setField(variablePointer, "actual", false);
        setField(variablePointer, "index", 0);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    public void testHashCodeWhenActualIsTrue() throws Exception {
        setField(variablePointer, "actual", true);
        int expectedHashCode = System.identityHashCode(variables) + qName.hashCode() + 5;
        setField(variablePointer, "index", 5);
        assertEquals(expectedHashCode, variablePointer.hashCode());
    }

    @Test
    public void testHashCodeWhenActualIsFalse() throws Exception {
        setField(variablePointer, "actual", false);
        int expectedHashCode = 0 + qName.hashCode() + 5;
        setField(variablePointer, "index", 5);
        assertEquals(expectedHashCode, variablePointer.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentIndex() throws Exception {
        setField(variablePointer, "actual", true);
        setField(variablePointer, "index", 10);
        int expectedHashCode = System.identityHashCode(variables) + qName.hashCode() + 10;
        assertEquals(expectedHashCode, variablePointer.hashCode());
    }

    @Test
    public void testHashCodeWithNullVariables() throws Exception {
        VariablePointer variablePointerWithNullVars = new VariablePointer(null, qName);
        setField(variablePointerWithNullVars, "actual", true);
        setField(variablePointerWithNullVars, "index", 5);
        int expectedHashCode = System.identityHashCode(null) + qName.hashCode() + 5;
        assertEquals(expectedHashCode, variablePointerWithNullVars.hashCode());
    }
}
