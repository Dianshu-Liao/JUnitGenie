package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class introspect_POJOPropertyBuilder_getPrimaryMember__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetPrimaryMember_whenForSerializationIsFalse() {
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
    public void testGetPrimaryMember_whenMutatorIsNull() {
        // Arrange
        MapperConfig config = null; // Initialize with a valid MapperConfig instance
        AnnotationIntrospector annotationIntrospector = null; // Initialize with a valid AnnotationIntrospector instance
        PropertyName propertyName = null; // Initialize with a valid PropertyName instance
        POJOPropertyBuilder builder = new POJOPropertyBuilder(config, annotationIntrospector, false, propertyName);

        // Mock the getMutator method to return null
        // This requires a mocking framework like Mockito to be set up
        // For example: Mockito.when(builder.getMutator()).thenReturn(null);

        // Act
        AnnotatedMember result = builder.getPrimaryMember();

        // Assert
        assertNotNull(result);
    }

}