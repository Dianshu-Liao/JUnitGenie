package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class type_SimpleType__buildSuperClass_Class_TypeBindings_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testBuildSuperClass() {
        try {
            // Prepare the inputs for the focal method
            Class<?> superClass = String.class; // Passing a non-null class that is not Object.class
            TypeBindings typeBindings = TypeBindings.create(superClass, new JavaType[0]); // Use the public method to create TypeBindings with an empty array

            // Access the focal method via reflection
            Method method = SimpleType.class.getDeclaredMethod("_buildSuperClass", Class.class, TypeBindings.class);
            method.setAccessible(true); // Make the private method accessible

            // Invoke the focal method
            JavaType result = (JavaType) method.invoke(null, superClass, typeBindings);

            // Verify the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            // Handle exception for the test case
            e.printStackTrace();
        }
    }

}