package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyMetadata.MergeInfo;
import com.fasterxml.jackson.annotation.Nulls;
import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyMetadata_withRequired_Boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithRequired() {
        // Arrange
        Boolean requiredValue = true; // This should not be null to satisfy the parameter constraint.
        String description = "Test Description";
        Integer index = 1;
        String defaultValue = "Default Value";
        MergeInfo mergeInfo = null; // Assuming a null should work for our test case.
        Nulls valueNulls = Nulls.DEFAULT; // Use any valid Nulls instance.
        Nulls contentNulls = Nulls.DEFAULT; // Use any valid Nulls instance.

        PropertyMetadata propertyMetadata = new PropertyMetadata(requiredValue, description, index, defaultValue, mergeInfo, valueNulls, contentNulls);

        // Act
        PropertyMetadata result = propertyMetadata.withRequired(requiredValue);

        // Assert
        assertNotNull(result);
        assertEquals(requiredValue, result._required); // Checking if _required is set correctly
        assertEquals(description, result._description); // Checking if _description is set correctly
        assertEquals(index, result._index); // Checking if _index is set correctly
        assertEquals(defaultValue, result._defaultValue); // Checking if _defaultValue is set correctly
        assertEquals(mergeInfo, result._mergeInfo); // Checking if _mergeInfo is set correctly
        assertEquals(valueNulls, result._valueNulls); // Checking if _valueNulls is set correctly
        assertEquals(contentNulls, result._contentNulls); // Checking if _contentNulls is set correctly
    }

    @Test(timeout = 4000)
    public void testWithRequired_NullCase() {
        // Arrange
        Boolean requiredValue = null;
        String description = "Another Description";
        Integer index = 2;
        String defaultValue = "Another Default";
        MergeInfo mergeInfo = null; // using null for this case as well.
        Nulls valueNulls = Nulls.DEFAULT;
        Nulls contentNulls = Nulls.DEFAULT;

        PropertyMetadata propertyMetadata = new PropertyMetadata(requiredValue, description, index, defaultValue, mergeInfo, valueNulls, contentNulls);

        // Act
        PropertyMetadata result = propertyMetadata.withRequired(requiredValue);

        // Assert
        assertNotNull(result);
        // Asserting that returned instance is the same since required is null and _required is also null
        assertSame(propertyMetadata, result);
    }

}