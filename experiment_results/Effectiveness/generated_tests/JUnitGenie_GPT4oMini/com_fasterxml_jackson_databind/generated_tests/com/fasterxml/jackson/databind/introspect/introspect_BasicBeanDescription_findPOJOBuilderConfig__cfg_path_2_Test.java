package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class introspect_BasicBeanDescription_findPOJOBuilderConfig__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFindPOJOBuilderConfig_WhenAnnotationIntrospectorIsNull() {
        BasicBeanDescription beanDescription = new BasicBeanDescription(null, null, null, null) {
            // Anonymous subclass to bypass the protected constructor
        };
        
        // Directly set _annotationIntrospector to null using reflection
        try {
            java.lang.reflect.Field field = BasicBeanDescription.class.getDeclaredField("_annotationIntrospector");
            field.setAccessible(true);
            field.set(beanDescription, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        // Test for handling when _annotationIntrospector is null
        assertNull(beanDescription.findPOJOBuilderConfig());
    }


}