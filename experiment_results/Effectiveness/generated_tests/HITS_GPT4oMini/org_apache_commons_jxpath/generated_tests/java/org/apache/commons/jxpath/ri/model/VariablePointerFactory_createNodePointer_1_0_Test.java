package org.apache.commons.jxpath.ri.model;

import java.util.Locale;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VariablePointerFactory_createNodePointer_1_0_Test {

    private VariablePointerFactory factory;

    private JXPathContext context;

    // Mock class for VariableContextWrapper
    private static class VariableContextWrapper {

        private final JXPathContext context;

        public VariableContextWrapper(JXPathContext context) {
            this.context = context;
        }

        public JXPathContext getContext() {
            return context;
        }
    }

    @BeforeEach
    public void setUp() {
        factory = new VariablePointerFactory();
        context = mock(JXPathContext.class);
    }

    @Test
    public void testCreateNodePointerWithDeclaredVariable() {
        QName qName = new QName("testVar");
        Variables variables = mock(Variables.class);
        when(variables.isDeclaredVariable("testVar")).thenReturn(true);
        when(context.getVariables()).thenReturn(variables);
        // No parent context
        when(context.getParentContext()).thenReturn(null);
        VariableContextWrapper wrapper = new VariableContextWrapper(context);
        assertNotNull(factory.createNodePointer(qName, wrapper, Locale.ENGLISH));
    }

    @Test
    public void testCreateNodePointerWithUndeclaredVariable() {
        QName qName = new QName("testVar");
        Variables variables = mock(Variables.class);
        when(variables.isDeclaredVariable("testVar")).thenReturn(false);
        when(context.getVariables()).thenReturn(variables);
        // No parent context
        when(context.getParentContext()).thenReturn(null);
        VariableContextWrapper wrapper = new VariableContextWrapper(context);
        assertNotNull(factory.createNodePointer(qName, wrapper, Locale.ENGLISH));
    }
}
