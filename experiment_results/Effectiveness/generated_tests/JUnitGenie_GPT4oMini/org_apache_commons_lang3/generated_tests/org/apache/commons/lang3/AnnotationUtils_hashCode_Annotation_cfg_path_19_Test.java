package org.apache.commons.lang3;
import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class AnnotationUtils_hashCode_Annotation_cfg_path_19_Test {

    // Define a mock annotation interface
    public @interface MyAnnotation {
        String value();
    }

    @Test(timeout = 4000)
    public void testHashCodeWithValidAnnotation() {
        // Create a mock annotation
        MyAnnotation mockAnnotation = new MyAnnotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MyAnnotation.class;
            }

            @Override
            public String value() {
                return "test"; // Return a non-null value
            }
        };

        try {
            int expectedHashCode = mockAnnotation.value().hashCode(); // Calculate expected hash code
            int result = AnnotationUtils.hashCode(mockAnnotation);
            assertEquals(expectedHashCode, result);
        } catch (UncheckedException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullValue() {
        // Create a mock annotation that returns null
        MyAnnotation mockAnnotation = new MyAnnotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MyAnnotation.class;
            }

            @Override
            public String value() {
                return null; // Return null to trigger IllegalStateException
            }
        };

        try {
            AnnotationUtils.hashCode(mockAnnotation);
        } catch (IllegalStateException e) {
            // Expected exception
            assertEquals("Annotation method value returned null", e.getMessage());
        } catch (UncheckedException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}