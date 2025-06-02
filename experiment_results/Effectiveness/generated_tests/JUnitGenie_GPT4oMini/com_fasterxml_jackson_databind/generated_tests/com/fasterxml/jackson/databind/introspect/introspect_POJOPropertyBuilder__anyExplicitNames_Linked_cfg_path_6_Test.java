package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class introspect_POJOPropertyBuilder__anyExplicitNames_Linked_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAnyExplicitNamesWithNullLinked() {
        POJOPropertyBuilder builder = new POJOPropertyBuilder(null, null, false, null);
        
        try {
            // Accessing the private method _anyExplicitNames using reflection
            Method method = POJOPropertyBuilder.class.getDeclaredMethod("_anyExplicitNames", Linked.class);
            method.setAccessible(true);
            
            // Creating a null Linked instance to pass to the method
            Linked linked = null;
            
            // Invoking the method and asserting the result
            boolean result = (Boolean) method.invoke(builder, linked);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}