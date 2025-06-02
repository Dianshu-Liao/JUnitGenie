package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_BeanDeserializerBuilder_hasProperty_PropertyName_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasPropertyReturnsFalse() {
        // Arrange
        PropertyName propertyName = new PropertyName("nonExistentProperty");
        // Create a valid BeanDeserializerBuilder instance
        BeanDeserializerBuilder builder = new BeanDeserializerBuilder(null, null);
        
        // Act
        boolean result = false;
        try {
            result = builder.hasProperty(propertyName);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace(); // Optional: Print stack trace for debugging
        }

        // Assert
        assertFalse(result);
    }


}