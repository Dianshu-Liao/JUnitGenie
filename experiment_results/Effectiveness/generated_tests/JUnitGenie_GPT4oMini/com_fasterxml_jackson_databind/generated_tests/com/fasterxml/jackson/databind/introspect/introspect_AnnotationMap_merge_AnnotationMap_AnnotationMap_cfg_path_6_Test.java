package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class introspect_AnnotationMap_merge_AnnotationMap_AnnotationMap_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testMergeWithPrimaryNull() {
        AnnotationMap primary = null;
        AnnotationMap secondary = new AnnotationMap(new HashMap<Class<?>, Annotation>());
        AnnotationMap result = AnnotationMap.merge(primary, secondary);
        assertEquals(secondary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithSecondaryNull() {
        AnnotationMap primary = new AnnotationMap(new HashMap<Class<?>, Annotation>());
        AnnotationMap secondary = null;
        AnnotationMap result = AnnotationMap.merge(primary, secondary);
        assertEquals(primary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithBothAnnotations() {
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        
        // Add some mock annotations to primary
        Annotation primaryAnnotation = new MockAnnotation(); // Assume MockAnnotation implements Annotation
        primaryAnnotations.put(MockAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);
        
        // Add some mock annotations to secondary
        Annotation secondaryAnnotation = new MockAnnotation(); // Assume MockAnnotation implements Annotation
        secondaryAnnotations.put(MockAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);
        
        AnnotationMap result = AnnotationMap.merge(primary, secondary);
        
        // Check that the primary annotation overrides the secondary
        assertEquals(primaryAnnotation, result._annotations.get(MockAnnotation.class));
    }

    // MockAnnotation class definition for testing purposes
    private static class MockAnnotation implements Annotation {
        @Override
        public Class<? extends Annotation> annotationType() {
            return MockAnnotation.class;
        }
    }

}