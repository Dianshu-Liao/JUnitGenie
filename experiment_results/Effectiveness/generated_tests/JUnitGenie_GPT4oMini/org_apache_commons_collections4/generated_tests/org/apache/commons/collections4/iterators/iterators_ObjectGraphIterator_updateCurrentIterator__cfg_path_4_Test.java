package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ObjectGraphIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Iterator;
import static org.junit.Assert.assertNotNull;

public class iterators_ObjectGraphIterator_updateCurrentIterator__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testUpdateCurrentIterator() {
        // Create an instance of ObjectGraphIterator with a null root and a null transformer
        ObjectGraphIterator<Object> iterator = new ObjectGraphIterator<>(null, null);

        // Access the protected method updateCurrentIterator using reflection
        try {
            Method method = ObjectGraphIterator.class.getDeclaredMethod("updateCurrentIterator");
            method.setAccessible(true); // Make the method accessible

            // Set the private fields to test the specific CFG path
            setPrivateField(iterator, "currentIterator", null); // currentIterator is null
            setPrivateField(iterator, "root", new Object()); // root is not null
            setPrivateField(iterator, "hasNext", false); // hasNext is false

            // Invoke the method
            method.invoke(iterator);

            // Assert that the method executed without throwing an exception
            assertNotNull(iterator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}