package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import org.junit.Test;
import java.lang.annotation.Annotation;
import static org.junit.Assert.assertFalse;

public class introspect_JacksonAnnotationIntrospector_isAnnotationBundle_Annotation_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsAnnotationBundleWithNonExistentAnnotation() {
        // Arrange
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        Annotation nonExistentAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }
        };

        // Act
        boolean result = introspector.isAnnotationBundle(nonExistentAnnotation);

        // Assert
        assertFalse(result);
    }


}