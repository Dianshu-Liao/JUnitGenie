package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.annotation.Nulls;
import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyMetadata_withRequired_Boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNotNullAndEqualsRequired() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(true, "description", 1, "default", null, Nulls.DEFAULT, Nulls.DEFAULT);
        Boolean input = true; // This should equal _required

        // Act
        PropertyMetadata result = propertyMetadata.withRequired(input);

        // Assert
        assertSame(propertyMetadata, result);
    }

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNotNullAndDoesNotEqualRequired() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(true, "description", 1, "default", null, Nulls.DEFAULT, Nulls.DEFAULT);
        Boolean input = false; // This does not equal _required

        // Act
        PropertyMetadata result = propertyMetadata.withRequired(input);

        // Assert
        assertNotSame(propertyMetadata, result);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNullAndRequiredIsNull() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(null, "description", 1, "default", null, Nulls.DEFAULT, Nulls.DEFAULT);
        Boolean input = null; // This should not change the state

        // Act
        PropertyMetadata result = propertyMetadata.withRequired(input);

        // Assert
        assertSame(propertyMetadata, result);
    }

    @Test(timeout = 4000)
    public void testWithRequiredWhenBooleanIsNullAndRequiredIsNotNull() {
        // Arrange
        PropertyMetadata propertyMetadata = new PropertyMetadata(true, "description", 1, "default", null, Nulls.DEFAULT, Nulls.DEFAULT);
        Boolean input = null; // This should not change the state

        // Act
        PropertyMetadata result = propertyMetadata.withRequired(input);

        // Assert
        assertNotSame(propertyMetadata, result);
        assertNotNull(result);
    }

}