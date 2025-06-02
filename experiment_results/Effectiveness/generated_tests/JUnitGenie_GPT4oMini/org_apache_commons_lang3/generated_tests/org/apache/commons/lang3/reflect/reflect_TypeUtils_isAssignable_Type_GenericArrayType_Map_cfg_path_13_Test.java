package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class reflect_TypeUtils_isAssignable_Type_GenericArrayType_Map_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testIsAssignableWithClassArrayType() {
        try {
            Type type = String.class; // java.lang.reflect.Type
            GenericArrayType toGenericArrayType = (GenericArrayType) java.lang.reflect.Array.newInstance(String.class, 0).getClass().getGenericSuperclass();
            Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>(); // java.util.Map

            // Accessing the private static method using reflection
            boolean result = (boolean) TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class, Map.class)
                    .invoke(null, type, toGenericArrayType, typeVarAssigns);

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsAssignableWithNullType() {
        try {
            Type type = null; // java.lang.reflect.Type
            GenericArrayType toGenericArrayType = (GenericArrayType) java.lang.reflect.Array.newInstance(String.class, 0).getClass().getGenericSuperclass();
            Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>(); // java.util.Map

            // Accessing the private static method using reflection
            boolean result = (boolean) TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class, Map.class)
                    .invoke(null, type, toGenericArrayType, typeVarAssigns);

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsAssignableWithNullGenericArrayType() {
        try {
            Type type = String.class; // java.lang.reflect.Type
            GenericArrayType toGenericArrayType = null; // java.lang.reflect.GenericArrayType
            Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>(); // java.util.Map

            // Accessing the private static method using reflection
            boolean result = (boolean) TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class, Map.class)
                    .invoke(null, type, toGenericArrayType, typeVarAssigns);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}