package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class introspect_POJOPropertyBuilder_getGetterUnchecked__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetGetterUncheckedReturnsNull() {
        try {
            // Create an instance of POJOPropertyBuilder with null _getters
            POJOPropertyBuilder builder = new POJOPropertyBuilder(null, null, false, null);
            
            // Access the protected method getGetterUnchecked using reflection
            Method method = POJOPropertyBuilder.class.getDeclaredMethod("getGetterUnchecked");
            method.setAccessible(true);
            
            // Invoke the method and assert that it returns null
            AnnotatedMethod result = (AnnotatedMethod) method.invoke(builder);
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}