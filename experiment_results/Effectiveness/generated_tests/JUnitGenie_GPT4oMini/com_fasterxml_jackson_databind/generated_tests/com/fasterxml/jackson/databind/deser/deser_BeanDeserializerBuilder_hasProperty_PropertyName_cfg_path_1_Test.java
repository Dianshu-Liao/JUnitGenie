package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_BeanDeserializerBuilder_hasProperty_PropertyName_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasPropertyReturnsFalseForNonExistingProperty() {
        // Arrange
        BeanDeserializerBuilder builder = new BeanDeserializerBuilder(null, null);
        PropertyName nonExistingProperty = new PropertyName("nonExistingProperty");

        // Act
        boolean result = false;
        try {
            result = builder.hasProperty(nonExistingProperty);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace(); // Print stack trace for debugging
        }

        // Assert
        assertFalse(result);
    }


}