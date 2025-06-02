package org.apache.commons.jxpath.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_getAccessibleMethod_16_0_Test {

    // Test case for when the method is null
    @Test
    public void testGetAccessibleMethod_NullMethod() {
        assertNull(ValueUtils.getAccessibleMethod(null), "Expected null for null method");
    }

    // Test case for non-public method
    @Test
    public void testGetAccessibleMethod_NonPublicMethod() throws NoSuchMethodException {
        Method nonPublicMethod = TestClass.class.getDeclaredMethod("nonPublicMethod");
        assertNull(ValueUtils.getAccessibleMethod(nonPublicMethod), "Expected null for non-public method");
    }

    // Test case for public method in a public class
    @Test
    public void testGetAccessibleMethod_PublicMethodInPublicClass() throws NoSuchMethodException {
        Method publicMethod = TestClass.class.getMethod("publicMethod");
        assertEquals(publicMethod, ValueUtils.getAccessibleMethod(publicMethod), "Expected the same public method");
    }

    // Test case for public method in a non-public class
    @Test
    public void testGetAccessibleMethod_PublicMethodInNonPublicClass() throws NoSuchMethodException {
        Method publicMethod = NonPublicTestClass.class.getMethod("publicMethod");
        assertEquals(publicMethod, ValueUtils.getAccessibleMethod(publicMethod), "Expected the same public method");
    }

    // Test case for method in superclass
    @Test
    public void testGetAccessibleMethod_MethodInSuperclass() throws NoSuchMethodException {
        Method methodInSuperClass = SubTestClass.class.getMethod("methodInSuperClass");
        assertEquals(methodInSuperClass, ValueUtils.getAccessibleMethod(methodInSuperClass), "Expected the same method from superclass");
    }

    // Test case for method in interface
    @Test
    public void testGetAccessibleMethod_MethodInInterface() throws NoSuchMethodException {
        Method methodInInterface = TestInterface.class.getMethod("interfaceMethod");
        assertEquals(methodInInterface, ValueUtils.getAccessibleMethod(methodInInterface), "Expected the same method from interface");
    }

    // Test class for testing purposes
    public static class TestClass {

        public void publicMethod() {
        }

        private void nonPublicMethod() {
        }
    }

    // Non-public class for testing
    private static class NonPublicTestClass {

        public void publicMethod() {
        }
    }

    // Subclass for testing method inheritance
    public static class SubTestClass extends TestClass {

        public void methodInSuperClass() {
        }
    }

    // Interface for testing method accessibility
    public interface TestInterface {

        void interfaceMethod();
    }
}
