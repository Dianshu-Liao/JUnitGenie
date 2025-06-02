package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class introspect_AnnotationMap_merge_AnnotationMap_AnnotationMap_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testMergeWithBothAnnotations() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotationImpl("Primary");
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotationImpl("Secondary");
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Merge the two AnnotationMaps
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify that the result contains the primary annotation
        assertEquals("Primary", result._annotations.get(TestAnnotation.class).toString());
    }

    @Test(timeout = 4000)
    public void testMergeWithPrimaryNull() {
        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotationImpl("Secondary");
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Merge with primary as null
        AnnotationMap result = AnnotationMap.merge(null, secondary);

        // Verify that the result is the secondary AnnotationMap
        assertEquals("Secondary", result._annotations.get(TestAnnotation.class).toString());
    }

    @Test(timeout = 4000)
    public void testMergeWithSecondaryNull() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotationImpl("Primary");
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Merge with secondary as null
        AnnotationMap result = AnnotationMap.merge(primary, null);

        // Verify that the result is the primary AnnotationMap
        assertEquals("Primary", result._annotations.get(TestAnnotation.class).toString());
    }

    @Test(timeout = 4000)
    public void testMergeWithBothEmpty() {
        // Prepare two empty AnnotationMaps
        AnnotationMap primary = new AnnotationMap(new HashMap<>());
        AnnotationMap secondary = new AnnotationMap(new HashMap<>());

        // Merge the two empty AnnotationMaps
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify that the result is an empty AnnotationMap
        assertTrue(result._annotations.isEmpty());
    }

    // Dummy annotation for testing purposes
    private @interface TestAnnotation {
        String value();
    }

    // Implementation of the TestAnnotation for instantiation
    private static class TestAnnotationImpl implements TestAnnotation {
        private final String value;

        public TestAnnotationImpl(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return TestAnnotation.class;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}