package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.Annotated;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.annotation.Annotation;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.core.Version;

public class introspect_AnnotationIntrospectorPair_findViews_Annotated_cfg_path_1_Test {

    private static class TestAnnotated extends Annotated {
        @Override
        public java.lang.reflect.AnnotatedElement getAnnotated() {
            return null; // Implement as needed for your tests
        }

        @Override
        public boolean hasOneOf(Class<? extends Annotation>[] classes) {
            return false; // Implement as needed for your tests
        }

        @Override
        public boolean equals(Object obj) {
            return false; // Implement as needed for your tests
        }

        @Override
        public JavaType getType() {
            return null; // Implement as needed for your tests
        }

        @Override
        public String getName() {
            return "TestAnnotated"; // Implement as needed for your tests
        }

        @Override
        public Iterable<Annotation> annotations() {
            return null; // Implement as needed for your tests
        }

        @Override
        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return null; // Implement as needed for your tests
        }

        @Override
        public String toString() {
            return "TestAnnotated"; // Implement as needed for your tests
        }

        @Override
        public int getModifiers() {
            return 0; // Implement as needed for your tests
        }

        @Override
        public Class<?> getRawType() {
            return null; // Implement as needed for your tests
        }

        @Override
        public boolean hasAnnotation(Class<?> cls) {
            return false; // Implement as needed for your tests
        }

        @Override
        public int hashCode() {
            return 0; // Implement as needed for your tests
        }
    }

    @Test(timeout = 4000)
    public void testFindViews() {
        AnnotationIntrospector primary = new AnnotationIntrospector() {
            @Override
            public Class<?>[] findViews(Annotated a) {
                return new Class<?>[]{String.class}; // Mock return value
            }

            @Override
            public Version version() {
                return new Version(2, 19, 0, null, null, null); // Correct return type
            }
        };

        AnnotationIntrospector secondary = new AnnotationIntrospector() {
            @Override
            public Class<?>[] findViews(Annotated a) {
                return null; // Simulate secondary returning null
            }

            @Override
            public Version version() {
                return new Version(2, 19, 0, null, null, null); // Correct return type
            }
        };

        AnnotationIntrospectorPair pair = new AnnotationIntrospectorPair(primary, secondary);
        TestAnnotated annotated = new TestAnnotated();

        Class<?>[] result = pair.findViews(annotated);
        Class<?>[] expected = new Class<?>[]{String.class};

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testFindViewsWithNullResultFromPrimary() {
        AnnotationIntrospector primary = new AnnotationIntrospector() {
            @Override
            public Class<?>[] findViews(Annotated a) {
                return null; // Simulate primary returning null
            }

            @Override
            public Version version() {
                return new Version(2, 19, 0, null, null, null); // Correct return type
            }
        };

        AnnotationIntrospector secondary = new AnnotationIntrospector() {
            @Override
            public Class<?>[] findViews(Annotated a) {
                return new Class<?>[]{Integer.class}; // Mock return value
            }

            @Override
            public Version version() {
                return new Version(2, 19, 0, null, null, null); // Correct return type
            }
        };

        AnnotationIntrospectorPair pair = new AnnotationIntrospectorPair(primary, secondary);
        TestAnnotated annotated = new TestAnnotated();

        Class<?>[] result = pair.findViews(annotated);
        Class<?>[] expected = new Class<?>[]{Integer.class};

        assertArrayEquals(expected, result);
    }

}