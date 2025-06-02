package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class reflect_TypeUtils_isAssignable_Type_GenericArrayType_Map_cfg_path_3_Test {



    @Test(timeout = 4000)
    public void testIsAssignableWithNullGenericArrayType() {
        try {
            Type type = String.class;
            GenericArrayType toGenericArrayType = null;
            Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();

            boolean result = invokeIsAssignable(type, toGenericArrayType, typeVarAssigns);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean invokeIsAssignable(Type type, GenericArrayType toGenericArrayType, Map<TypeVariable<?>, Type> typeVarAssigns) throws Exception {
        java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, GenericArrayType.class, Map.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, type, toGenericArrayType, typeVarAssigns);
    }


}
