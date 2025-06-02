package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class type_TypeBindings_isEmpty__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsEmpty() {
        try {
            // Using reflection to access the private constructor
            java.lang.reflect.Constructor<TypeBindings> constructor = TypeBindings.class.getDeclaredConstructor(String[].class, JavaType[].class, String[].class);
            constructor.setAccessible(true);
            
            // Create an instance of TypeBindings with an empty JavaType array
            TypeBindings typeBindings = constructor.newInstance(new String[]{}, new JavaType[]{}, new String[]{});
            
            // Assert that isEmpty() returns true
            assertTrue(typeBindings.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}