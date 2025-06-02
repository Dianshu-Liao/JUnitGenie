package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class introspect_AnnotationIntrospectorPair_hasCreatorAnnotation_Annotated_cfg_path_2_Test {

    private static class TestAnnotated extends Annotated {
        @Override
        public java.lang.reflect.AnnotatedElement getAnnotated() {
            return null; // Implement as needed for your test
        }

        @Override
        public boolean hasOneOf(java.lang.Class[] classes) {
            return false; // Implement as needed for your test
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            return false; // Implement as needed for your test
        }

        @Override
        public JavaType getType() {
            return null; // Implement as needed for your test
        }

        @Override
        public java.lang.String getName() {
            return "TestAnnotated"; // Implement as needed for your test
        }

        @Override
        public Iterable annotations() {
            return null; // Implement as needed for your test
        }

        @Override
        public java.lang.annotation.Annotation getAnnotation(java.lang.Class cls) {
            return null; // Implement as needed for your test
        }

        @Override
        public java.lang.String toString() {
            return "TestAnnotated"; // Implement as needed for your test
        }

        @Override
        public int getModifiers() {
            return 0; // Implement as needed for your test
        }

        @Override
        public java.lang.Class getRawType() {
            return null; // Implement as needed for your test
        }

        @Override
        public boolean hasAnnotation(java.lang.Class cls) {
            return false; // Implement as needed for your test
        }

        @Override
        public int hashCode() {
            return 0; // Implement as needed for your test
        }
    }

    @Test(timeout = 4000)
    public void testHasCreatorAnnotationReturnsFalse() {
        AnnotationIntrospector primary = new AnnotationIntrospector() {
            @Override
            public boolean hasCreatorAnnotation(Annotated a) {
                return false; // Simulate behavior for the test
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() as a default implementation
            }
        };

        AnnotationIntrospector secondary = new AnnotationIntrospector() {
            @Override
            public boolean hasCreatorAnnotation(Annotated a) {
                return false; // Simulate behavior for the test
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() as a default implementation
            }
        };

        AnnotationIntrospectorPair pair = new AnnotationIntrospectorPair(primary, secondary);
        TestAnnotated annotated = new TestAnnotated();

        try {
            boolean result = pair.hasCreatorAnnotation(annotated);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }
    }

}