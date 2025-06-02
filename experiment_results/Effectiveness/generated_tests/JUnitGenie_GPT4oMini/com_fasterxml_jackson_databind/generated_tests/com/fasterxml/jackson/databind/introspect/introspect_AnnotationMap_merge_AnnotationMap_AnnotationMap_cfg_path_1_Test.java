package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class introspect_AnnotationMap_merge_AnnotationMap_AnnotationMap_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMergeWithNonEmptyPrimaryAndSecondary() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotationImpl(); // Use implementation instead of abstract
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotationImpl(); // Use implementation instead of abstract
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Call the merge method
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result._annotations.size());
        assertTrue(result._annotations.containsKey(TestAnnotation.class));
        assertEquals(primaryAnnotation, result._annotations.get(TestAnnotation.class));
    }

    @Test(timeout = 4000)
    public void testMergeWithEmptyPrimary() {
        // Prepare primary AnnotationMap as empty
        AnnotationMap primary = new AnnotationMap(new HashMap<>());

        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotationImpl(); // Use implementation instead of abstract
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Call the merge method
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result._annotations.size());
        assertTrue(result._annotations.containsKey(TestAnnotation.class));
        assertEquals(secondaryAnnotation, result._annotations.get(TestAnnotation.class));
    }

    @Test(timeout = 4000)
    public void testMergeWithEmptySecondary() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotationImpl(); // Use implementation instead of abstract
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Prepare secondary AnnotationMap as empty
        AnnotationMap secondary = new AnnotationMap(new HashMap<>());

        // Call the merge method
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result._annotations.size());
        assertTrue(result._annotations.containsKey(TestAnnotation.class));
        assertEquals(primaryAnnotation, result._annotations.get(TestAnnotation.class));
    }

    @Test(timeout = 4000)
    public void testMergeWithBothEmpty() {
        // Prepare both primary and secondary AnnotationMap as empty
        AnnotationMap primary = new AnnotationMap(new HashMap<>());
        AnnotationMap secondary = new AnnotationMap(new HashMap<>());

        // Call the merge method
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Validate the result
        assertNotNull(result);
        assertTrue(result._annotations.isEmpty());
    }

    // Dummy annotation for testing purposes
    private @interface TestAnnotation {}

    // Implementation of the TestAnnotation for instantiation
    private static class TestAnnotationImpl implements TestAnnotation {
        public Class<? extends Annotation> annotationType() {
            return TestAnnotation.class;
        }
        public boolean equals(Object obj) {
            return this == obj;
        }
        public int hashCode() {
            return System.identityHashCode(this);
        }
        public String toString() {
            return "@" + TestAnnotation.class.getName();
        }
    }

}