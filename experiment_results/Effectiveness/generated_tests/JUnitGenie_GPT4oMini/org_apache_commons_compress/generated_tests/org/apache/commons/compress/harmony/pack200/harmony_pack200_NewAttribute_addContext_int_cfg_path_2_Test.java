package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class harmony_pack200_NewAttribute_addContext_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddContext_ClassContext() {
        // Arrange
        NewAttribute newAttribute = new NewAttribute("className", "signature", 0);
        
        // Act
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_CLASS);

        // Assert
        assertTrue("contextClass should be true when CONTEXT_CLASS is passed", newAttribute.isContextClass());
    }

    @Test(timeout = 4000)
    public void testAddContext_MethodContext() {
        // Arrange
        NewAttribute newAttribute = new NewAttribute("className", "signature", 0);
        
        // Act
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_METHOD);

        // Assert
        assertTrue("contextMethod should be true when CONTEXT_METHOD is passed", newAttribute.isContextMethod());
    }

    @Test(timeout = 4000)
    public void testAddContext_FieldContext() {
        // Arrange
        NewAttribute newAttribute = new NewAttribute("className", "signature", 0);
        
        // Act
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_FIELD);

        // Assert
        assertTrue("contextField should be true when CONTEXT_FIELD is passed", newAttribute.isContextField());
    }

    @Test(timeout = 4000)
    public void testAddContext_CodeContext() {
        // Arrange
        NewAttribute newAttribute = new NewAttribute("className", "signature", 0);
        
        // Act
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_CODE);

        // Assert
        assertTrue("contextCode should be true when CONTEXT_CODE is passed", newAttribute.isContextCode());
    }


}