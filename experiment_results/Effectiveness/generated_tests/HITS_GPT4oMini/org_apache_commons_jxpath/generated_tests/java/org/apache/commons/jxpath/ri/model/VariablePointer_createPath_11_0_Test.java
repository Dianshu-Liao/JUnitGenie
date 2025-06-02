package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
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

@ExtendWith(MockitoExtension.class)
public class VariablePointer_createPath_11_0_Test {

    private JXPathContext context;

    @Mock
    private Variables variables;

    private QName qName;

    private VariablePointer variablePointer;

    @BeforeEach
    public void setUp() {
        qName = new QName("testVariable");
        variablePointer = new VariablePointer(variables, qName);
        context = JXPathContext.newContext(variables);
    }

    @Test
    public void testCreatePathWhenActualIsTrue() {
        variablePointer.setValue("testValue");
        NodePointer result = variablePointer.createPath(context, "newValue");
        assertEquals("newValue", result.getBaseValue());
    }

    @Test
    public void testCreatePathWhenActualIsFalse() {
        variablePointer = new VariablePointer(qName);
        NodePointer result = variablePointer.createPath(context, "testValue");
        assertEquals("testValue", result.getBaseValue());
    }

    @Test
    public void testCreatePathSetsValueCorrectly() {
        variablePointer.setValue("testValue");
        NodePointer result = variablePointer.createPath(context, "testValue");
        assertEquals("testValue", result.getBaseValue());
        verify(variables).declareVariable(qName.toString(), "testValue");
    }

    @Test
    public void testCreatePathThrowsExceptionWhenVariableIsUndefined() {
        variablePointer = new VariablePointer(qName);
        assertThrows(JXPathException.class, () -> {
            variablePointer.createPath(context, "testValue");
        });
    }

    @Test
    public void testCreatePathWithNullValue() {
        NodePointer result = variablePointer.createPath(context, null);
        assertNull(result.getBaseValue());
    }

    @Test
    public void testCreatePathWithEmptyString() {
        NodePointer result = variablePointer.createPath(context, "");
        assertEquals("", result.getBaseValue());
    }
}
