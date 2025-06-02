package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class harmony_pack200_NewAttribute_addContext_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAddContext_Field() {
        // Arrange
        NewAttribute newAttribute = new NewAttribute("test", "test", 0);
        
        // Act
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_FIELD);
        
        // Assert
        // Use a public method to check the contextField value instead of accessing it directly
        assertTrue("contextField should be true", newAttribute.isContextField());
    }


}