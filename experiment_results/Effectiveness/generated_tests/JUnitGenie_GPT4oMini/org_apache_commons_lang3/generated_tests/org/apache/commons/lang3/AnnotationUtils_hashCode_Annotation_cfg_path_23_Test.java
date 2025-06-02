package org.apache.commons.lang3;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testHashCode_withValidAnnotation() throws Exception {
        // Create a mock annotation
        MyAnnotation mockAnnotation = new MyAnnotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MyAnnotation.class;
            }

            @Override
            public String value() {
                return "test";  // Non-null value
            }
        };

        // Execute the focal method
        int result = AnnotationUtils.hashCode(mockAnnotation);

        // Expected hash value for the mock annotation
        int expectedHashValue = mockAnnotation.value().hashCode();
        
        // Assertions
        assertEquals(expectedHashValue, result);
    }

    @Test(timeout = 4000)
    public void testHashCode_withNullValue() {
        // Create a mock annotation that returns null for its method
        MyAnnotation mockAnnotation = new MyAnnotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MyAnnotation.class;
            }

            @Override
            public String value() {
                return null;  // Causes IllegalStateException
            }
        };

        try {
            AnnotationUtils.hashCode(mockAnnotation);
            // If no exception is thrown, the test fails
            assert false;
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (UncheckedException e) {
            // Also acceptable since it wraps the real exception
        }
    }

    @Test(timeout = 4000)
    public void testHashCode_withReflectiveOperationException() {
        // Create a mock annotation
        MyAnnotation mockAnnotation = new MyAnnotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MyAnnotation.class;
            }

            @Override
            public String value() {
                throw new UncheckedException(new ReflectiveOperationException("Reflection error"));  // Causes UncheckedException
            }
        };

        try {
            AnnotationUtils.hashCode(mockAnnotation);
            // If no exception is thrown, the test fails
            assert false;
        } catch (UncheckedException e) {
            // Expected exception wrapping ReflectiveOperationException
        }
    }

    // Mock annotation for testing
    private @interface MyAnnotation {
        String value();
    }


}