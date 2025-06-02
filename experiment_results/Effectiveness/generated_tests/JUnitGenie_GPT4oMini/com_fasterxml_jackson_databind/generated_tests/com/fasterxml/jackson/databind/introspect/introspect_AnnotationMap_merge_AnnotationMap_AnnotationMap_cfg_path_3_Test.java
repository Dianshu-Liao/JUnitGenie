package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class introspect_AnnotationMap_merge_AnnotationMap_AnnotationMap_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMergeWithBothAnnotations() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotation() {
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotation() {
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Merge the two AnnotationMaps
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify that the result contains the primary annotation
        assertEquals(primaryAnnotation, result._annotations.get(TestAnnotation.class));
    }

    @Test(timeout = 4000)
    public void testMergeWithNullPrimary() {
        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotation() {
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Merge with null primary
        AnnotationMap result = AnnotationMap.merge(null, secondary);

        // Verify that the result is the same as secondary
        assertEquals(secondary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithNullSecondary() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotation() {
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Merge with null secondary
        AnnotationMap result = AnnotationMap.merge(primary, null);

        // Verify that the result is the same as primary
        assertEquals(primary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithEmptyPrimary() {
        // Prepare primary AnnotationMap with no annotations
        AnnotationMap primary = new AnnotationMap(new HashMap<>());

        // Prepare secondary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> secondaryAnnotations = new HashMap<>();
        Annotation secondaryAnnotation = new TestAnnotation() {
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };
        secondaryAnnotations.put(TestAnnotation.class, secondaryAnnotation);
        AnnotationMap secondary = new AnnotationMap(secondaryAnnotations);

        // Merge the two AnnotationMaps
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify that the result is the same as secondary
        assertEquals(secondary, result);
    }

    @Test(timeout = 4000)
    public void testMergeWithEmptySecondary() {
        // Prepare primary AnnotationMap with some annotations
        HashMap<Class<?>, Annotation> primaryAnnotations = new HashMap<>();
        Annotation primaryAnnotation = new TestAnnotation() {
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };
        primaryAnnotations.put(TestAnnotation.class, primaryAnnotation);
        AnnotationMap primary = new AnnotationMap(primaryAnnotations);

        // Prepare secondary AnnotationMap with no annotations
        AnnotationMap secondary = new AnnotationMap(new HashMap<>());

        // Merge the two AnnotationMaps
        AnnotationMap result = AnnotationMap.merge(primary, secondary);

        // Verify that the result is the same as primary
        assertEquals(primary, result);
    }

    // Dummy annotation for testing purposes
    private @interface TestAnnotation {}

}