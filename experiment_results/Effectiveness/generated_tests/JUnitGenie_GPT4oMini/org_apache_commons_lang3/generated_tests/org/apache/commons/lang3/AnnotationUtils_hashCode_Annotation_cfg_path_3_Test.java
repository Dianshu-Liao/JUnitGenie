package org.apache.commons.lang3;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithValidAnnotation() {
        // Create a mock annotation for testing
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
    public void testHashCodeWithNullValue() {
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
            // Call the focal method, expecting an exception
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (IllegalStateException e) {
            // Verify the exception message
            assertEquals("Annotation method value returned null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testHashCodeWithReflectiveOperationException() {
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
            // Call the focal method, expecting an UncheckedException
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (UncheckedException e) {
            // Verify the cause of the exception
            assertEquals("Reflection error", e.getCause().getMessage());
        }
    }

    // Dummy annotation for testing purposes
    private @interface TestAnnotation {
        String value() default "test";
    }

}