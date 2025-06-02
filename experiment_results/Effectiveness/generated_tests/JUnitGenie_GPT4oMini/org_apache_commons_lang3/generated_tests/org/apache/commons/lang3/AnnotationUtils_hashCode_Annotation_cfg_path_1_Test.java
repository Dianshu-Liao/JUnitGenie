package org.apache.commons.lang3;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class AnnotationUtils_hashCode_Annotation_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCode_withValidAnnotation() {
        // Create a mock annotation for testing
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        // Call the focal method
        int result = AnnotationUtils.hashCode(mockAnnotation);
        // Add assertions based on expected behavior
    }

    @Test(timeout = 4000)
    public void testHashCode_withNullValue() {
        // Create a mock annotation that returns null
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        try {
            // Call the focal method
            AnnotationUtils.hashCode(mockAnnotation);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (UncheckedException e) {
            // Handle the UncheckedException if thrown
            Throwable cause = e.getCause();
            if (cause instanceof IllegalStateException) {
                // Expected exception
            } else {
                fail("Unexpected exception type: " + cause);
            }
        }
    }

    @Test(timeout = 4000)
    public void testHashCode_withReflectiveOperationException() {
        // Create a mock annotation that will throw ReflectiveOperationException
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        try {
            // Call the focal method
            AnnotationUtils.hashCode(mockAnnotation);
            fail("Expected UncheckedException to be thrown");
        } catch (UncheckedException e) {
            // Expected exception
            Throwable cause = e.getCause();
            if (cause instanceof ReflectiveOperationException) {
                // Expected exception
            } else {
                fail("Unexpected exception type: " + cause);
            }
        }
    }

    // Dummy annotation for testing purposes
    private @interface TestAnnotation {
        String value() default "test";
    }

}