package org.apache.commons.lang3;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_13_Test {

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

        // Assert the expected result (you may need to adjust this based on your actual expected value)
        assertEquals(0, result); // Replace 0 with the expected hash code value
    }

    @Test(timeout = 4000)
    public void testHashCode_withNullValue() {
        // Create a mock annotation that returns null for one of its methods
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }

            public String value() {
                return null; // This will trigger the IllegalStateException
            }
        };

        try {
            // Call the focal method
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (IllegalStateException e) {
            // Expected exception
            return;
        }
        // If we reach here, the exception was not thrown
        throw new AssertionError("Expected IllegalStateException was not thrown");
    }

    @Test(timeout = 4000)
    public void testHashCode_withReflectiveOperationException() {
        // Create a mock annotation that will throw a ReflectiveOperationException
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }

            public String value() throws ReflectiveOperationException {
                throw new ReflectiveOperationException("Reflection error");
            }
        };

        try {
            // Call the focal method
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (UncheckedException e) {
            // Expected exception
            Throwable cause = e.getCause();
            assertEquals("Reflection error", cause.getMessage());
            return;
        }
        // If we reach here, the exception was not thrown
        throw new AssertionError("Expected UncheckedException was not thrown");
    }

    // Dummy annotation for testing purposes
    private @interface TestAnnotation {
        String value() default "test";
    }

}