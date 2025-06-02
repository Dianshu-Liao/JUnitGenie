package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_NewAttribute_addContext_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddContextClass() {
        NewAttribute newAttribute = new NewAttribute("test", "test", 0);
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_CLASS);
        // Use a getter method to access contextClass
        assertTrue(newAttribute.isContextClass());
    }

    @Test(timeout = 4000)
    public void testAddContextMethod() {
        NewAttribute newAttribute = new NewAttribute("test", "test", 0);
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_METHOD);
        // Use a getter method to access contextMethod
        assertTrue(newAttribute.isContextMethod());
    }

    @Test(timeout = 4000)
    public void testAddContextField() {
        NewAttribute newAttribute = new NewAttribute("test", "test", 0);
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_FIELD);
        // Use a getter method to access contextField
        assertTrue(newAttribute.isContextField());
    }

    @Test(timeout = 4000)
    public void testAddContextCode() {
        NewAttribute newAttribute = new NewAttribute("test", "test", 0);
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_CODE);
        // Use a getter method to access contextCode
        assertTrue(newAttribute.isContextCode());
    }


}