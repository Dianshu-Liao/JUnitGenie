package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class introspect_POJOPropertyBuilder__anyExplicits_Linked_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAnyExplicits() {
        try {
            // Create an instance of PropertyName with a non-null, non-empty simple name
            PropertyName propertyName = new PropertyName("validName");

            // Create an instance of the Linked class using reflection
            Class<?> linkedClass = Class.forName("com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked");
            // Check if the constructor exists with the expected parameter type
            Object linkedInstance = linkedClass.getDeclaredConstructor(PropertyName.class).newInstance(propertyName);

            // Create an instance of POJOPropertyBuilder
            POJOPropertyBuilder builder = new POJOPropertyBuilder(null, null, false, null);

            // Access the private method _anyExplicits using reflection
            Method method = POJOPropertyBuilder.class.getDeclaredMethod("_anyExplicits", linkedClass);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(builder, linkedInstance);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}