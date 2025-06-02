package org.apache.commons.lang3.reflect;
import org.junit.Test;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class reflect_TypeUtils_isAssignable_Type_GenericArrayType_Map_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testIsAssignableWithValidParameters() {
        try {
            // Prepare test parameters
            Type type = String.class; // Change to String.class for the method
            GenericArrayType toGenericArrayType = getArrayType(String.class); // Use the custom method to get GenericArrayType
            Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>(); // An empty map for type variable assignments

            // Access the private static method using reflection
            Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class, Map.class);
            method.setAccessible(true); // Make the private method accessible
            boolean result = (Boolean) method.invoke(null, type, toGenericArrayType, typeVarAssigns);

            // Assert the expected result
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Added a method to create a GenericArrayType for the test
    private static GenericArrayType getArrayType(Class<?> componentType) {
        return new GenericArrayTypeImpl(componentType);
    }

    // A simple implementation of GenericArrayType for testing purposes
    private static class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type componentType) {
            this.componentType = componentType;
        }

        @Override
        public Type getGenericComponentType() {
            return componentType;
        }

        @Override
        public String toString() {
            return componentType.getTypeName() + "[]";
        }
    }


}