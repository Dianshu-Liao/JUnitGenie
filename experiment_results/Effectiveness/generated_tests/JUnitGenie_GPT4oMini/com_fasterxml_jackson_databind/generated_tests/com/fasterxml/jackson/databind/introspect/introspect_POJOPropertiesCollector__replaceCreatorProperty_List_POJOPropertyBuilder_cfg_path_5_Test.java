package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class introspect_POJOPropertiesCollector__replaceCreatorProperty_List_POJOPropertyBuilder_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testReplaceCreatorProperty() {
        try {
            // Create instances of POJOPropertyBuilder
            POJOPropertyBuilder prop1 = new POJOPropertyBuilder(null, null, false, null);
            POJOPropertyBuilder prop2 = new POJOPropertyBuilder(null, null, false, null);
            POJOPropertyBuilder prop3 = new POJOPropertyBuilder(null, null, false, null);

            // Create a list of POJOPropertyBuilder
            List<POJOPropertyBuilder> creatorProperties = new ArrayList<>();
            creatorProperties.add(prop1);
            creatorProperties.add(prop2);

            // Create an instance of POJOPropertiesCollector using reflection
            Class<?> collectorClass = POJOPropertiesCollector.class;
            Constructor<?> constructor = collectorClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            POJOPropertiesCollector collector = (POJOPropertiesCollector) constructor.newInstance();

            // Invoke the protected method _replaceCreatorProperty using reflection
            Method method = collectorClass.getDeclaredMethod("_replaceCreatorProperty", List.class, POJOPropertyBuilder.class);
            method.setAccessible(true);

            // Test case where the property is replaced
            boolean result = (boolean) method.invoke(collector, creatorProperties, prop1);
            assertTrue(result);
            assertTrue(creatorProperties.get(0) == prop1);

            // Test case where the property is not replaced
            boolean result2 = (boolean) method.invoke(collector, creatorProperties, prop3);
            assertFalse(result2);
            assertTrue(creatorProperties.get(0) == prop1); // Ensure the first property is still prop1

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}