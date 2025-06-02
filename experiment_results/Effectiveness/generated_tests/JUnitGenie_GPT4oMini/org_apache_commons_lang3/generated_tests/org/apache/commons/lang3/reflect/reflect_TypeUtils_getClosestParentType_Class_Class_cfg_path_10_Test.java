package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.lang.Class;
import static org.junit.Assert.*;

public class reflect_TypeUtils_getClosestParentType_Class_Class_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithValidInterface() {
        try {
            Class<?> cls = MyClass.class; // MyClass implements MyInterface
            Class<?> superClass = MyInterface.class;
            Type result = (Type) TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class)
                                           .invoke(null, cls, superClass);
            assertNotNull(result);
            assertTrue(result instanceof Class<?>);
            assertEquals(MyInterface.class, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithInvalidType() {
        try {
            Class<?> cls = MyClass.class; // MyClass does not implement any interface
            Class<?> superClass = InvalidInterface.class; // InvalidInterface is not implemented
            Type result = (Type) TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class)
                                           .invoke(null, cls, superClass);
            assertNull(result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithUnexpectedGenericType() {
        try {
            Class<?> cls = MyClass.class; // MyClass implements MyGenericInterface
            Class<?> superClass = MyGenericInterface.class;
            Type result = (Type) TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class)
                                           .invoke(null, cls, superClass);
            assertNotNull(result);
            assertTrue(result instanceof ParameterizedType);
        } catch (IllegalStateException e) {
            // Expected exception for unexpected generic interface type
            assertTrue(e.getMessage().contains("Unexpected generic interface type found"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Dummy classes for testing
    interface MyInterface {}
    interface MyGenericInterface<T> {}
    class MyClass implements MyInterface, MyGenericInterface<String> {}
    interface InvalidInterface {}

}