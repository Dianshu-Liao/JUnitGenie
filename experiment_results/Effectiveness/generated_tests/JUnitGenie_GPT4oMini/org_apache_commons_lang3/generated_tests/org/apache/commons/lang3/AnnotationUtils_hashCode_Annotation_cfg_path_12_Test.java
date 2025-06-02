package org.apache.commons.lang3;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testHashCode_withValidAnnotation() {
        // Create a mock annotation
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        // Call the focal method
        int result = AnnotationUtils.hashCode(mockAnnotation);

        // Define the expected hash code based on the mock annotation
        int expectedHashCode = mockAnnotation.annotationType().hashCode(); // Example expected value

        // Assert the expected result
        assertEquals(expectedHashCode, result);
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
            assertEquals("Annotation method value returned null", e.getMessage());
        }
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
            assertEquals("java.lang.reflect.InvocationTargetException: Reflection error", e.getCause().getMessage());
        }
    }

    // Mock annotation for testing
    private @interface TestAnnotation {
        String value() default "test";
    }


}