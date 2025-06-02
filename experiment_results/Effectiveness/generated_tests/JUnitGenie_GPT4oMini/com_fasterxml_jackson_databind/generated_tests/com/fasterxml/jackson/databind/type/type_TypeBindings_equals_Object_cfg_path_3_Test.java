package com.fasterxml.jackson.databind.type;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import java.lang.reflect.Constructor;

public class type_TypeBindings_equals_Object_cfg_path_3_Test {

    private TypeBindings createTypeBindings(String[] names, JavaType[] types, String[] parameters) throws Exception {
        Constructor<TypeBindings> constructor = TypeBindings.class.getDeclaredConstructor(String[].class, JavaType[].class, String[].class);
        constructor.setAccessible(true);
        return constructor.newInstance(names, types, parameters);
    }

    @Test(timeout = 4000)
    public void testEqualsSameInstance() throws Exception {
        JavaType[] types = new JavaType[] {  };
        TypeBindings typeBindings = createTypeBindings(new String[]{"type1"}, types, new String[]{"param1"});
        
        // Test equals with the same instance
        assertTrue(typeBindings.equals(typeBindings));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentClass() throws Exception {
        JavaType[] types1 = new JavaType[] {  };
        TypeBindings typeBindings1 = createTypeBindings(new String[]{"type1"}, types1, new String[]{"param1"});
        Object anotherObject = new Object(); // Object of different class
        
        // Test equals with an object of a different class
        assertFalse(typeBindings1.equals(anotherObject));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentHashCode() throws Exception {
        JavaType[] types1 = new JavaType[] {  };
        JavaType[] types2 = new JavaType[] {  };
        TypeBindings typeBindings1 = createTypeBindings(new String[]{"type1"}, types1, new String[]{"param1"});
        TypeBindings typeBindings2 = createTypeBindings(new String[]{"type2"}, types2, new String[]{"param2"});

        // Test equals with different hash codes
        assertFalse(typeBindings1.equals(typeBindings2));
    }

    @Test(timeout = 4000)
    public void testEqualsSameHashCodeDifferentTypes() throws Exception {
        // This scenario can be extended based on the possibility of having same hashCode for different Types (depends on hash function).
        JavaType[] types1 = new JavaType[] {  };
        TypeBindings typeBindings1 = createTypeBindings(new String[]{"type1"}, types1, new String[]{"param1"});
        TypeBindings typeBindings2 = createTypeBindings(new String[]{"type1"}, types1, new String[]{"param1"});
        
        // Test equals with same types
        assertTrue(typeBindings1.equals(typeBindings2));
    }


}