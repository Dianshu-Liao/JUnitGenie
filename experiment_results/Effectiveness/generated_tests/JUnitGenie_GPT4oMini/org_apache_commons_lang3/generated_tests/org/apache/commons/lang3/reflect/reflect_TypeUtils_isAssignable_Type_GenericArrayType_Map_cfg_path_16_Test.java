package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class reflect_TypeUtils_isAssignable_Type_GenericArrayType_Map_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testIsAssignableWithNonNullParameters() {
        try {
            // Prepare test parameters
            Type type = String.class; // Example type
            
            // Create a GenericArrayType for String[]
            GenericArrayType toGenericArrayType = new GenericArrayType() {
                @Override
                public Type getGenericComponentType() {
                    return String.class;
                }
            };
            
            Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();

            // Access the private static method using reflection
            java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, GenericArrayType.class, Map.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(null, type, toGenericArrayType, typeVarAssigns);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}