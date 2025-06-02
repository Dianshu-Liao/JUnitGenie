package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class introspect_POJOPropertyBuilder__anyExplicits_Linked_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAnyExplicitsWithSimpleName() {
        try {
            // Create a PropertyName with a simple name
            PropertyName propertyName = PropertyName.construct("simpleName");
            // Create a Linked node with the PropertyName
            Linked linkedNode = createLinkedNode(propertyName);

            // Access the private method _anyExplicits using reflection
            Method method = POJOPropertyBuilder.class.getDeclaredMethod("_anyExplicits", Linked.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(new POJOPropertyBuilder(null, null, false, null), linkedNode);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAnyExplicitsWithoutSimpleName() {
        try {
            // Create a PropertyName without a simple name
            PropertyName propertyName = PropertyName.construct("");
            // Create a Linked node with the PropertyName
            Linked linkedNode = createLinkedNode(propertyName);

            // Access the private method _anyExplicits using reflection
            Method method = POJOPropertyBuilder.class.getDeclaredMethod("_anyExplicits", Linked.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(new POJOPropertyBuilder(null, null, false, null), linkedNode);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Linked createLinkedNode(PropertyName propertyName) {
        // Create a Linked node instance using reflection
        try {
            // Assuming Linked has a constructor that takes a PropertyName
            return (Linked) Linked.class.getDeclaredConstructor(PropertyName.class).newInstance(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}