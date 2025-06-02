package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.Variables;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;

class VariablePointer_createPath_12_4_Test {

    private VariablePointer variablePointer;

    private JXPathContext context;

    private Variables variables;

    private QName name;

    @BeforeEach
    void setUp() {
        name = new QName("testVariable");
        variables = new Variables() {

            @Override
            public void declareVariable(String name, Object value) {
                // Simulate successful variable declaration
            }

            @Override
            public Object getVariable(String name) {
                // Simulate getting a variable value
                return "testValue";
            }

            @Override
            public boolean isDeclaredVariable(String name) {
                // Simulate that the variable is declared
                return true;
            }

            @Override
            public void undeclareVariable(String name) {
                // Simulate undeclaring a variable
            }
        };
        context = JXPathContext.newContext(variables);
        variablePointer = new VariablePointer(variables, name);
    }

    @Test
    void testCreatePath_whenActualIsFalse_shouldDeclareVariable() {
        // Act
        NodePointer result = variablePointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertTrue(getActualState(variablePointer));
    }

    @Test
    void testCreatePath_whenVariableCannotBeDeclared_shouldThrowException() {
        // Arrange
        VariablePointer variablePointer = new VariablePointer(variables, name) {

            @Override
            protected AbstractFactory getAbstractFactory(JXPathContext context) {
                return new AbstractFactory() {

                    @Override
                    public boolean declareVariable(JXPathContext context, String name) {
                        // Simulate failure to declare variable
                        return false;
                    }
                };
            }
        };
        // Act & Assert
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createPath(context);
        });
        assertEquals("Factory cannot define variable 'testVariable' for path: $testVariable", exception.getMessage());
    }

    @Test
    void testCreatePath_whenActualIsTrue_shouldNotDeclareVariable() {
        // Arrange
        // Make it actual
        variablePointer.createPath(context);
        // Act
        NodePointer result = variablePointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertTrue(getActualState(variablePointer));
    }

    private boolean getActualState(VariablePointer variablePointer) {
        try {
            java.lang.reflect.Field field = VariablePointer.class.getDeclaredField("actual");
            field.setAccessible(true);
            return field.getBoolean(variablePointer);
        } catch (Exception e) {
            fail("Failed to access the 'actual' field via reflection");
            // This line will never be reached
            return false;
        }
    }
}
