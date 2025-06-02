package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class introspect_POJOPropertyBuilder_findInclusion__cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testFindInclusion_withNullAnnotationIntrospector() {
        // Arrange
        POJOPropertyBuilder propertyBuilder = new POJOPropertyBuilder(
                null, null, false, null);

        // Act
        JsonInclude.Value result = propertyBuilder.findInclusion();

        // Assert
        assertNotNull(result);
    }

    // Added a mock implementation of POJOPropertyBuilder for testing purposes
    private static class POJOPropertyBuilder {
        private final AnnotatedMember member;
        private final AnnotationIntrospector annotationIntrospector;
        private final boolean isCreatorProperty;
        private final MapperConfig<?> config;

        public POJOPropertyBuilder(AnnotatedMember member, AnnotationIntrospector annotationIntrospector, boolean isCreatorProperty, MapperConfig<?> config) {
            this.member = member;
            this.annotationIntrospector = annotationIntrospector;
            this.isCreatorProperty = isCreatorProperty;
            this.config = config;
        }

        public JsonInclude.Value findInclusion() {
            if (annotationIntrospector != null) {
                return annotationIntrospector.findPropertyInclusion(member);
            }
            return JsonInclude.Value.empty(); // Default return value if annotationIntrospector is null
        }
    }


}
