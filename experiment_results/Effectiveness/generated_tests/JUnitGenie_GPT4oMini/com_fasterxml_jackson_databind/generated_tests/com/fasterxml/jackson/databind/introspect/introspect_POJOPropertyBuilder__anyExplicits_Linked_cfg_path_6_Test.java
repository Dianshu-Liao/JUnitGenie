package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class introspect_POJOPropertyBuilder__anyExplicits_Linked_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAnyExplicitsWithNullLinked() {
        try {
            // Create an instance of POJOPropertyBuilder
            POJOPropertyBuilder builder = new POJOPropertyBuilder(null, null, false, null);
            
            // Access the private method _anyExplicits using reflection
            Method method = POJOPropertyBuilder.class.getDeclaredMethod("_anyExplicits", Linked.class);
            method.setAccessible(true);
            
            // Call the method with a null Linked parameter
            boolean result = (Boolean) method.invoke(builder, (Linked) null);
            
            // Assert that the result is false
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}