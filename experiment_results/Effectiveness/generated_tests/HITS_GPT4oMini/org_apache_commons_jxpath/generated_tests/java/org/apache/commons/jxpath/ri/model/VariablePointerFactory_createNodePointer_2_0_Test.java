package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VariablePointerFactory_createNodePointer_2_0_Test {

    private VariablePointerFactory variablePointerFactory;

    @BeforeEach
    public void setUp() {
        variablePointerFactory = new VariablePointerFactory();
    }

    @Test
    public void testCreateNodePointer_WithDeclaredVariable() {
        QName name = new QName("variableName");
        Object object = createVariableContextWrapperWithVariable(name);
        NodePointer result = variablePointerFactory.createNodePointer(null, name, object);
        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
        assertEquals(name.getName(), ((VariablePointer) result).getName());
    }

    @Test
    public void testCreateNodePointer_WithUndeclaredVariable() {
        QName name = new QName("undeclaredVariable");
        Object object = createVariableContextWrapperWithoutVariable();
        NodePointer result = variablePointerFactory.createNodePointer(null, name, object);
        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
        assertEquals(name.getName(), ((VariablePointer) result).getName());
    }

    @Test
    public void testCreateNodePointer_WithNullObject() {
        QName name = new QName("anyVariable");
        Object object = null;
        NodePointer result = variablePointerFactory.createNodePointer(null, name, object);
        assertNull(result);
    }

    @Test
    public void testCreateNodePointer_WithNonVariableContextWrapper() {
        QName name = new QName("variableName");
        Object object = new Object();
        NodePointer result = variablePointerFactory.createNodePointer(null, name, object);
        assertNull(result);
    }

    private Object createVariableContextWrapperWithVariable(QName name) {
        JXPathContext context = JXPathContext.newContext(new Object());
        context.getVariables().declareVariable(name.getName(), new Object());
        VariableContextWrapper mockWrapper = new VariableContextWrapper(context);
        return mockWrapper;
    }

    private Object createVariableContextWrapperWithoutVariable() {
        JXPathContext context = JXPathContext.newContext(new Object());
        VariableContextWrapper mockWrapper = new VariableContextWrapper(context);
        return mockWrapper;
    }

    // Mock implementation of VariableContextWrapper
    private static class VariableContextWrapper {

        private final JXPathContext context;

        public VariableContextWrapper(JXPathContext context) {
            this.context = context;
        }
    }
}
