package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.Variables;
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

class VariablePointer_createPath_11_2_Test {

    private VariablePointer variablePointer;

    private JXPathContext context;

    private Variables variables;

    private QName name;

    @BeforeEach
    void setUp() {
        variables = new Variables() {

            @Override
            public Object getVariable(String name) {
                // Mock implementation
                return null;
            }

            @Override
            public void declareVariable(String name, Object value) {
                // Mock implementation
            }

            @Override
            public void undeclareVariable(String name) {
                // Mock implementation
            }

            @Override
            public boolean isDeclaredVariable(String name) {
                // Mock implementation
                return false;
            }
        };
        name = new QName("testVariable");
        variablePointer = new VariablePointer(variables, name);
        context = JXPathContext.newContext(variables);
    }

    @Test
    void testCreatePathWhenActualIsTrue() {
        variablePointer.setValue("testValue");
        NodePointer result = variablePointer.createPath(context, "newValue");
        assertEquals("newValue", result.getValue());
    }

    @Test
    void testCreatePathWhenActualIsFalse() {
        VariablePointer variablePointer = new VariablePointer(name);
        NodePointer result = variablePointer.createPath(context, "newValue");
        assertNotNull(result);
        assertThrows(JXPathException.class, variablePointer::getBaseValue);
    }

    @Test
    void testCreatePathWithNullValue() {
        variablePointer.setValue("testValue");
        NodePointer result = variablePointer.createPath(context, null);
        assertNull(result.getValue());
    }

    @Test
    void testCreatePathWithUndefinedVariable() {
        VariablePointer variablePointer = new VariablePointer(name);
        assertThrows(JXPathException.class, () -> {
            variablePointer.createPath(context, "newValue");
        });
    }

    @Test
    void testCreatePathWithDifferentContext() {
        VariablePointer variablePointer = new VariablePointer(name);
        variablePointer.createPath(context, "differentValue");
        assertThrows(JXPathException.class, variablePointer::getBaseValue);
    }

    @Test
    void testCreatePathPrivateMethodInvocation() throws Exception {
        Method method = VariablePointer.class.getDeclaredMethod("createPath", JXPathContext.class, Object.class);
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(variablePointer, context, "invokedValue");
        assertEquals("invokedValue", result.getValue());
    }
}
