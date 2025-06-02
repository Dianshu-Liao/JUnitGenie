package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyMetadata;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class PropertyMetadata_withRequired_Boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithRequiredWhenBIsNullAndRequiredIsNull() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(null, "description", 1, "defaultValue", null, null, null);
        // Act
        PropertyMetadata result = propertyMetadata.withRequired(null);
        // Assert
        assertSame(propertyMetadata, result);
    }

    @Test(timeout = 4000)
    public void testWithRequiredWhenBIsNotNullAndRequiredIsEqual() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(Boolean.TRUE, "description", 1, "defaultValue", null, null, null);
        // Act
        PropertyMetadata result = propertyMetadata.withRequired(Boolean.TRUE);
        // Assert
        assertSame(propertyMetadata, result);
    }

}