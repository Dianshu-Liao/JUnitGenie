package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class introspect_AnnotationMap_merge_AnnotationMap_AnnotationMap_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testMergeWithNonEmptyPrimaryAndEmptySecondary() {
        // Setup
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        primaryAnnotations.put(MyAnnotation.class, new MyAnnotationImpl());
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);
        AnnotationMap secondary = new AnnotationMap(); // Empty secondary

        // Execute
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify
        assertEquals(primary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithEmptyPrimaryAndNonEmptySecondary() {
        // Setup
        AnnotationMap primary = new AnnotationMap(); // Empty primary
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        secondaryAnnotations.put(MyAnnotation.class, new MyAnnotationImpl());
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Execute
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify
        assertEquals(secondary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithNonEmptyPrimaryAndNonEmptySecondary() {
        // Setup
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        primaryAnnotations.put(MyAnnotation.class, new MyAnnotationImpl());
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        secondaryAnnotations.put(MyOtherAnnotation.class, new MyOtherAnnotationImpl());
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Execute
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify
        assertEquals(primary, result); // Primary should override secondary
    }

    // Mock annotation classes for testing
    private @interface MyAnnotation {}
    private class MyAnnotationImpl implements MyAnnotation {
        public Class<? extends Annotation> annotationType() {
            return MyAnnotation.class;
        }
    }

    private @interface MyOtherAnnotation {}
    private class MyOtherAnnotationImpl implements MyOtherAnnotation {
        public Class<? extends Annotation> annotationType() {
            return MyOtherAnnotation.class;
        }
    }


}