package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class introspect_POJOPropertyBuilder_getSetter__cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetSetterWhenSettersIsNull() {
        // Arrange
        POJOPropertyBuilder propertyBuilder = new POJOPropertyBuilder(
            null, // MapperConfig
            null, // AnnotationIntrospector
            false, // boolean
            null // PropertyName
        );

        // Act
        AnnotatedMethod result = propertyBuilder.getSetter();

        // Assert
        assertNull(result);
    }

}