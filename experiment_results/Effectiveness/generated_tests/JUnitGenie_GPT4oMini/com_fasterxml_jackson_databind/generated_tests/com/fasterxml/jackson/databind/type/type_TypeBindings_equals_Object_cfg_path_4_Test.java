package com.fasterxml.jackson.databind.type;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Constructor;
import org.junit.Test;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class type_TypeBindings_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEqualsIdenticalObjects() {
        TypeBindings tb1 = createTypeBindings(new String[]{}, new JavaType[]{}, new String[]{});
        TypeBindings tb2 = tb1;

        assertTrue(tb1.equals(tb2));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentClasses() {
        TypeBindings tb1 = createTypeBindings(new String[]{}, new JavaType[]{}, new String[]{});
        Object differentObject = new Object();

        assertFalse(tb1.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentTypeBindings() {
        TypeBindings tb1 = createTypeBindings(new String[]{"type1"}, new JavaType[]{}, new String[]{});
        TypeBindings tb2 = createTypeBindings(new String[]{"type2"}, new JavaType[]{}, new String[]{});

        assertFalse(tb1.equals(tb2));
    }

    @Test(timeout = 4000)
    public void testEqualsSameTypeBindings() {
        TypeBindings tb1 = createTypeBindings(new String[]{"type1"}, new JavaType[]{}, new String[]{});
        TypeBindings tb2 = createTypeBindings(new String[]{"type1"}, new JavaType[]{}, new String[]{});

        assertTrue(tb1.equals(tb2));
    }

    private TypeBindings createTypeBindings(String[] types, JavaType[] javaTypes, String[] otherStrings) {
        try {
            Constructor<TypeBindings> constructor = TypeBindings.class.getDeclaredConstructor(String[].class, JavaType[].class, String[].class);
            constructor.setAccessible(true);
            return constructor.newInstance((Object) types, (Object) javaTypes, (Object) otherStrings);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}