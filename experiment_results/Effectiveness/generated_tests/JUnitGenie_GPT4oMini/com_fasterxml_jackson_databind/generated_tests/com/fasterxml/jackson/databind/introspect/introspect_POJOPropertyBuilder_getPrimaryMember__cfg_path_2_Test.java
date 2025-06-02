package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class introspect_POJOPropertyBuilder_getPrimaryMember__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetPrimaryMember_WithMutator() {
        // Arrange
        MapperConfig config = null; // Initialize with a valid MapperConfig instance
        AnnotationIntrospector annotationIntrospector = null; // Initialize with a valid AnnotationIntrospector instance
        PropertyName propertyName = null; // Initialize with a valid PropertyName instance
        POJOPropertyBuilder builder = new POJOPropertyBuilder(config, annotationIntrospector, false, propertyName);

        // Act
        AnnotatedMember result = builder.getPrimaryMember();

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetPrimaryMember_WithSetterlessProperty() {
        // Arrange
        MapperConfig config = null; // Initialize with a valid MapperConfig instance
        AnnotationIntrospector annotationIntrospector = null; // Initialize with a valid AnnotationIntrospector instance
        PropertyName propertyName = null; // Initialize with a valid PropertyName instance
        POJOPropertyBuilder builder = new POJOPropertyBuilder(config, annotationIntrospector, false, propertyName);

        // Simulate the condition where getMutator() returns null
        // This may require mocking or a specific setup depending on the implementation of getMutator()

        // Act
        AnnotatedMember result = builder.getPrimaryMember();

        // Assert
        assertNotNull(result);
    }

}