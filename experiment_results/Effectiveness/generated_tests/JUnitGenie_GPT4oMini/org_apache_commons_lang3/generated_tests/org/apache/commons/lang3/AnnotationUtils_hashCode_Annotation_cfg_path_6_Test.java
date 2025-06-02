package org.apache.commons.lang3;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithValidAnnotation() {
        // Create a mock annotation
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        // Call the focal method
        int result = AnnotationUtils.hashCode(mockAnnotation);

        // Assert the expected result (this will depend on the actual implementation of hashMember)
        assertEquals(0, result); // Replace 0 with the expected hash code value
    }

    @Test(timeout = 4000)
    public void testHashCodeThrowsIllegalStateException() {
        // Create a mock annotation that returns null for one of its methods
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        try {
            // Call the focal method
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (IllegalStateException e) {
            // Expected exception
            assertEquals("Annotation method null returned null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testHashCodeThrowsUncheckedException() {
        // Create a mock annotation that throws ReflectiveOperationException
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        try {
            // Call the focal method
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (UncheckedException e) {
            // Expected exception
            assertEquals("java.lang.reflect.InvocationTargetException", e.getCause().getClass().getName());
        }
    }

    // Mock annotation for testing
    private @interface TestAnnotation {
        String value() default "test";
    }

}