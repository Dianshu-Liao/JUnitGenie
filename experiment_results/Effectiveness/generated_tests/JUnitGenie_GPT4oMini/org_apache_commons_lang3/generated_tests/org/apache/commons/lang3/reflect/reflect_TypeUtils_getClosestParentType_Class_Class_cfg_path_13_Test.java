package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class reflect_TypeUtils_getClosestParentType_Class_Class_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithValidInterface() {
        try {
            Class<?> cls = MyClass.class; // MyClass implements MyInterface
            Class<?> superClass = MyInterface.class;
            Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class); // Change Type to Method
            method.setAccessible(true);
            Type closestType = (Type) method.invoke(null, cls, superClass);
            assertNotNull(closestType);
            assertTrue(closestType instanceof ParameterizedType);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithUnexpectedType() {
        try {
            Class<?> cls = MyClass.class; // MyClass implements MyInterface
            Class<?> superClass = AnotherInterface.class; // Not implemented by MyClass
            Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class); // Change Type to Method
            method.setAccessible(true);
            Type closestType = (Type) method.invoke(null, cls, superClass);
            assertNull(closestType);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetClosestParentTypeWithIllegalStateException() {
        try {
            Class<?> cls = InvalidClass.class; // InvalidClass does not implement any interfaces
            Class<?> superClass = MyInterface.class;
            Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class); // Change Type to Method
            method.setAccessible(true);
            method.invoke(null, cls, superClass);
            fail("Expected IllegalStateException was not thrown.");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    // Dummy classes for testing
    interface MyInterface {}
    interface AnotherInterface {}
    class MyClass implements MyInterface {}
    class InvalidClass {}


}