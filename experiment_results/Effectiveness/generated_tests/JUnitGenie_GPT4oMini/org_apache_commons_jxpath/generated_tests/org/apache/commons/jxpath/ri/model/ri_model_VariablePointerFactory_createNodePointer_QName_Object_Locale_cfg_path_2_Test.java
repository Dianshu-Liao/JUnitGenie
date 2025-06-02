package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Locale;

public class ri_model_VariablePointerFactory_createNodePointer_QName_Object_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateNodePointerWithDeclaredVariable() {
        VariablePointerFactory factory = new VariablePointerFactory();
        QName name = new QName("testVariable");
        JXPathContext varCtx = JXPathContext.newContext(new Object()); // Create a context with a valid object
        Locale locale = Locale.getDefault();

        // Mock the behavior of the context to return a declared variable
        Variables vars = mock(Variables.class); // Create a mock for Variables
        when(varCtx.getVariables()).thenReturn(vars); // Return the mock when getVariables is called
        when(vars.isDeclaredVariable(name.toString())).thenReturn(true);

        NodePointer result = null;
        try {
            result = factory.createNodePointer(name, varCtx, locale); // Use varCtx directly instead of contextWrapper
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
    }

    @Test(timeout = 4000)
    public void testCreateNodePointerWithUndeclaredVariable() {
        VariablePointerFactory factory = new VariablePointerFactory();
        QName name = new QName("undeclaredVariable");
        JXPathContext varCtx = JXPathContext.newContext(new Object()); // Create a context with a valid object
        Locale locale = Locale.getDefault();

        // Mock the behavior of the context to return an undeclared variable
        Variables vars = mock(Variables.class); // Create a mock for Variables
        when(varCtx.getVariables()).thenReturn(vars); // Return the mock when getVariables is called
        when(vars.isDeclaredVariable(name.toString())).thenReturn(false);

        NodePointer result = null;
        try {
            result = factory.createNodePointer(name, varCtx, locale); // Use varCtx directly instead of contextWrapper
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
    }

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNullObject() {
        VariablePointerFactory factory = new VariablePointerFactory();
        QName name = new QName("testVariable");
        Locale locale = Locale.getDefault();

        NodePointer result = null;
        try {
            result = factory.createNodePointer(name, null, locale);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        assertNull(result);
    }

}