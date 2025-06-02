package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class introspect_BasicBeanDescription_findAnyGetter__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testFindAnyGetterWhenPropCollectorIsNull() {
        try {
            // Create an instance of BasicBeanDescription with a null POJOPropertiesCollector
            BasicBeanDescription beanDescription = createBeanDescriptionWithNullCollector();
            // Call the findAnyGetter method
            AnnotatedMember result = beanDescription.findAnyGetter();
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    private BasicBeanDescription createBeanDescriptionWithNullCollector() throws Exception {
        // Use reflection to access the protected constructor
        java.lang.reflect.Constructor<BasicBeanDescription> constructor = BasicBeanDescription.class.getDeclaredConstructor(Class.class, POJOPropertiesCollector.class);
        constructor.setAccessible(true);
        // Pass a valid class and a null POJOPropertiesCollector
        return constructor.newInstance(Object.class, (POJOPropertiesCollector) null);
    }


}