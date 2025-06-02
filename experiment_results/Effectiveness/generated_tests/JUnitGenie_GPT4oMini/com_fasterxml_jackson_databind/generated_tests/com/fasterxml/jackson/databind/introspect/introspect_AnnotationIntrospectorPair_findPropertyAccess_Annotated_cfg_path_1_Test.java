package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class introspect_AnnotationIntrospectorPair_findPropertyAccess_Annotated_cfg_path_1_Test {

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
        public com.fasterxml.jackson.databind.JavaType getType() {
            return null; // Implement as needed for your test
        }

        @Override
        public java.lang.String getName() {
            return "testAnnotated"; // Implement as needed for your test
        }

        @Override
        public java.lang.Iterable annotations() {
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
    public void testFindPropertyAccess() {
        AnnotationIntrospector primary = new AnnotationIntrospector() {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated ann) {
                return JsonProperty.Access.READ_ONLY; // Simulate a return value
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() instead of VERSION_1
            }
        };

        AnnotationIntrospector secondary = new AnnotationIntrospector() {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated ann) {
                return null; // Simulate a return value
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() instead of VERSION_1
            }
        };

        AnnotationIntrospectorPair pair = new AnnotationIntrospectorPair(primary, secondary);
        TestAnnotated annotated = new TestAnnotated();

        JsonProperty.Access access = pair.findPropertyAccess(annotated);
        assertEquals(JsonProperty.Access.READ_ONLY, access);
    }

    @Test(timeout = 4000)
    public void testFindPropertyAccessWithSecondary() {
        AnnotationIntrospector primary = new AnnotationIntrospector() {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated ann) {
                return null; // Simulate a return value
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() instead of VERSION_1
            }
        };

        AnnotationIntrospector secondary = new AnnotationIntrospector() {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated ann) {
                return JsonProperty.Access.WRITE_ONLY; // Simulate a return value
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() instead of VERSION_1
            }
        };

        AnnotationIntrospectorPair pair = new AnnotationIntrospectorPair(primary, secondary);
        TestAnnotated annotated = new TestAnnotated();

        JsonProperty.Access access = pair.findPropertyAccess(annotated);
        assertEquals(JsonProperty.Access.WRITE_ONLY, access);
    }

    @Test(timeout = 4000)
    public void testFindPropertyAccessDefault() {
        AnnotationIntrospector primary = new AnnotationIntrospector() {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated ann) {
                return null; // Simulate a return value
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() instead of VERSION_1
            }
        };

        AnnotationIntrospector secondary = new AnnotationIntrospector() {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated ann) {
                return null; // Simulate a return value
            }

            @Override
            public Version version() {
                return Version.unknownVersion(); // Use unknownVersion() instead of VERSION_1
            }
        };

        AnnotationIntrospectorPair pair = new AnnotationIntrospectorPair(primary, secondary);
        TestAnnotated annotated = new TestAnnotated();

        JsonProperty.Access access = pair.findPropertyAccess(annotated);
        assertEquals(JsonProperty.Access.AUTO, access);
    }


}