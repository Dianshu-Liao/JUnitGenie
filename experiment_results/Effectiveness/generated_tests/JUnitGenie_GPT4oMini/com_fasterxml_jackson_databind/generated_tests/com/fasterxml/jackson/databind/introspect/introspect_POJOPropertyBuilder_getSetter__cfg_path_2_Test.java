package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.*;

public class introspect_POJOPropertyBuilder_getSetter__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetSetterWithNonNullSetters() {
        // Arrange
        PropertyName propertyName = new PropertyName("testProperty");
        MapperConfig mapperConfig = null; // Mock or appropriate instantiation
        AnnotationIntrospector annotationIntrospector = null; // Mock or appropriate instantiation
        POJOPropertyBuilder builder = new POJOPropertyBuilder(mapperConfig, annotationIntrospector, true, propertyName);

        // Simulate the condition where _setters is not null
        // Here, you would need to use reflection or a setup method to add a setter to _setters

        // Act
        AnnotatedMethod result = builder.getSetter();

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetSetterWithNullSetters() {
        // Arrange
        PropertyName propertyName = new PropertyName("testProperty");
        MapperConfig mapperConfig = null; // Mock or appropriate instantiation
        AnnotationIntrospector annotationIntrospector = null; // Mock or appropriate instantiation
        POJOPropertyBuilder builder = new POJOPropertyBuilder(mapperConfig, annotationIntrospector, true, propertyName);

        // Simulate the condition where _setters is null
        // Here you would need to set the _setters to null using reflection

        // Act
        AnnotatedMethod result = builder.getSetter();

        // Assert
        assertNull(result);
    }

}