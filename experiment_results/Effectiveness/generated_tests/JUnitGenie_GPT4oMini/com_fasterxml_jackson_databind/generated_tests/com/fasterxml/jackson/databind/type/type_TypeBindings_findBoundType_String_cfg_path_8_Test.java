package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class type_TypeBindings_findBoundType_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testFindBoundTypeReturnsNullForNonMatchingName() {
        // Using reflection to access the private constructor
        try {
            // Create an instance of TypeBindings using reflection
            java.lang.reflect.Constructor<TypeBindings> constructor = TypeBindings.class
                    .getDeclaredConstructor(String[].class, JavaType[].class, String[].class);
            constructor.setAccessible(true); // Enable access to the private constructor

            // Instantiate TypeBindings with empty _names and _types
            TypeBindings typeBindings = constructor.newInstance(new String[]{}, new JavaType[]{}, new String[]{});

            // Call findBoundType with a name that doesn't exist
            JavaType result = typeBindings.findBoundType("nonExistingName");

            // Assert that the result is null
            assertNull("Expected findBoundType to return null for non-existing name", result);
        } catch (Exception e) {
            // Handle the exception that may arise from reflection or instantiation
            e.printStackTrace();
        }
    }

}