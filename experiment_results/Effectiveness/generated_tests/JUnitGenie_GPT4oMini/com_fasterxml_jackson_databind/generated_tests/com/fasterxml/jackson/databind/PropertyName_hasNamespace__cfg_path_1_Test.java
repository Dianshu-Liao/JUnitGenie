package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class PropertyName_hasNamespace__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasNamespaceWhenNamespaceIsNull() {
        // Arrange
        PropertyName propertyName = new PropertyName("testName");
        // The _namespace is not set, so it should be null
        // This is done by not using the constructor that sets _namespace

        // Act
        boolean result = propertyName.hasNamespace();

        // Assert
        assertFalse(result);
    }

}