package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class PropertyName_internSimpleName__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInternSimpleName_EmptySimpleName() {
        // Arrange
        PropertyName propertyName = new PropertyName(""); // _simpleName is empty

        // Act
        PropertyName result = propertyName.internSimpleName();

        // Assert
        assertSame(propertyName, result); // Should return 'this' since _simpleName is empty
    }

}