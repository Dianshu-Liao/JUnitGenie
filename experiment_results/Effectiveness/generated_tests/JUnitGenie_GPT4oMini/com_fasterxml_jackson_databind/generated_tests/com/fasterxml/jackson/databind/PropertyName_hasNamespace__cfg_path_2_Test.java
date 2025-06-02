package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class PropertyName_hasNamespace__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasNamespaceWhenNamespaceIsNull() {
        // Create an instance of PropertyName with a null namespace
        PropertyName propertyName = new PropertyName((String) null);
        
        // Verify that hasNamespace() returns false
        try {
            boolean result = propertyName.hasNamespace();
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}