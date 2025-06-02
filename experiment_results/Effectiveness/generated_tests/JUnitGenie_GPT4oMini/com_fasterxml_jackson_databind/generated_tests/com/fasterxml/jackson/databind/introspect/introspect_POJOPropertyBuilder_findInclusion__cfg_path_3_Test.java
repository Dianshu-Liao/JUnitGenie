package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class introspect_POJOPropertyBuilder_findInclusion__cfg_path_3_Test {


    @Test(timeout = 4000)
    public void testFindInclusionWhenNoAnnotationIntrospector() {
        // Create instance with no AnnotationIntrospector
        POJOPropertyBuilder builder = new POJOPropertyBuilder(null, null, false, null);

        // Call the method under test
        JsonInclude.Value inclusionValue = builder.findInclusion();

        // Check that it returns the empty value as specified in the method
        assertNotNull(inclusionValue);
        assertEquals(JsonInclude.Value.empty(), inclusionValue);
    }


}
