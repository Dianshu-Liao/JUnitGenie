package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PropertyName_internSimpleName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInternSimpleName_whenSimpleNameIsNotEmpty() {
        // Arrange
        String simpleName = "example";
        String namespace = "namespace";
        PropertyName propertyName = new PropertyName(simpleName, namespace);
        
        // Act
        PropertyName result = propertyName.internSimpleName();
        
        // Assert
        assertEquals(propertyName, result);
    }

    @Test(timeout = 4000)
    public void testInternSimpleName_whenSimpleNameIsEmpty() {
        // Arrange
        String simpleName = "";
        String namespace = "namespace";
        PropertyName propertyName = new PropertyName(simpleName, namespace);
        
        // Act
        PropertyName result = propertyName.internSimpleName();
        
        // Assert
        assertEquals(propertyName, result);
    }

    @Test(timeout = 4000)
    public void testInternSimpleName_whenInternedNameIsDifferent() {
        // Arrange
        String simpleName = "example";
        String namespace = "namespace";
        PropertyName propertyName = new PropertyName(simpleName, namespace);
        
        // Act
        PropertyName result = propertyName.internSimpleName();
        
        // Assert
        assertEquals(new PropertyName("interned_example", namespace), result);
    }


}