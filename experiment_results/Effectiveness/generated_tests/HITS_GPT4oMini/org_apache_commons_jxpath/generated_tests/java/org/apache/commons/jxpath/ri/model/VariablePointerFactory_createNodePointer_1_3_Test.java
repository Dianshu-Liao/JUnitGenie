package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class VariablePointerFactory_createNodePointer_1_3_Test {

    private VariablePointerFactory variablePointerFactory;

    @BeforeEach
    void setUp() {
        variablePointerFactory = new VariablePointerFactory();
    }

    @Test
    void testCreateNodePointer_WithDeclaredVariable() {
        // Arrange
        QName name = new QName("testVar");
        VariableContextWrapper contextWrapper = new VariableContextWrapper(createVariableContextWithVariable(name));
        Locale locale = Locale.getDefault();
        // Act
        NodePointer result = variablePointerFactory.createNodePointer(name, contextWrapper, locale);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
        assertEquals(name.toString(), ((VariablePointer) result).getName());
    }

    @Test
    void testCreateNodePointer_WithUndeclaredVariable() {
        // Arrange
        QName name = new QName("undeclaredVar");
        VariableContextWrapper contextWrapper = new VariableContextWrapper(createVariableContextWithoutVariable());
        Locale locale = Locale.getDefault();
        // Act
        NodePointer result = variablePointerFactory.createNodePointer(name, contextWrapper, locale);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
        assertEquals(name.toString(), ((VariablePointer) result).getName());
    }

    @Test
    void testCreateNodePointer_WithNullObject() {
        // Arrange
        QName name = new QName("testVar");
        Object object = null;
        Locale locale = Locale.getDefault();
        // Act
        NodePointer result = variablePointerFactory.createNodePointer(name, object, locale);
        // Assert
        assertNull(result);
    }

    @Test
    void testCreateNodePointer_WithNonVariableContextWrapper() {
        // Arrange
        QName name = new QName("testVar");
        // Not a VariableContextWrapper
        Object object = new Object();
        Locale locale = Locale.getDefault();
        // Act
        NodePointer result = variablePointerFactory.createNodePointer(name, object, locale);
        // Assert
        assertNull(result);
    }

    private JXPathContext createVariableContextWithVariable(QName variableName) {
        JXPathContext context = JXPathContext.newContext(new Object());
        Variables variables = context.getVariables();
        variables.declareVariable(variableName.toString(), new Object());
        return context;
    }

    private JXPathContext createVariableContextWithoutVariable() {
        return JXPathContext.newContext(new Object());
    }

    // Stub class for VariableContextWrapper
    private static class VariableContextWrapper {

        private final JXPathContext context;

        public VariableContextWrapper(JXPathContext context) {
            this.context = context;
        }
    }
}
