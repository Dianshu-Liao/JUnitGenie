package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyMetadata;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class PropertyMetadata_withRequired_Boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNotNullAndEqualsRequired() {
        // Arrange
        Boolean requiredValue = Boolean.TRUE;
        PropertyMetadata propertyMetadata = new PropertyMetadata(requiredValue, "description", 1, "defaultValue", null, null, null);
        
        // Act
        PropertyMetadata result = propertyMetadata.withRequired(requiredValue);
        
        // Assert
        assertSame(propertyMetadata, result);
    }

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNotNullAndNotEqualsRequired() {
        // Arrange
        Boolean requiredValue = Boolean.TRUE;
        PropertyMetadata propertyMetadata = new PropertyMetadata(Boolean.FALSE, "description", 1, "defaultValue", null, null, null);
        
        // Act
        PropertyMetadata result = propertyMetadata.withRequired(requiredValue);
        
        // Assert
        // Here we would need to create a new PropertyMetadata instance with the expected values
        PropertyMetadata expected = new PropertyMetadata(requiredValue, "description", 1, "defaultValue", null, null, null);
        assertSame(expected, result);
    }

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNullAndRequiredIsNull() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(null, "description", 1, "defaultValue", null, null, null);
        
        // Act
        PropertyMetadata result = propertyMetadata.withRequired(null);
        
        // Assert
        assertSame(propertyMetadata, result);
    }

}