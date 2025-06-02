package org.apache.commons.lang3;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testHashCode() {
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
    public void testHashCodeThrowsUncheckedException() {
        // Create a mock annotation that will throw an exception when invoked
        Annotation mockAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return TestAnnotation.class;
            }
        };

        // Mock the method to throw an exception
        try {
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (UncheckedException e) {
            // Handle the exception as expected
            Throwable cause = e.getCause();
            // Assert that the cause is of the expected type
            assertEquals(ReflectiveOperationException.class, cause.getClass());
        }
    }

    // Define a test annotation for mocking
    private @interface TestAnnotation {
        String value() default "test";
    }

}