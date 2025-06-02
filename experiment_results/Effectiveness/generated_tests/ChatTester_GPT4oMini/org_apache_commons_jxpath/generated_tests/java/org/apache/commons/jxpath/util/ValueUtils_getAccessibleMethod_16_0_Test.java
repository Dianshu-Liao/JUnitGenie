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

    private static class TestClass {

        public void publicMethod() {
        }

        protected void protectedMethod() {
        }

        private void privateMethod() {
        }

        void packagePrivateMethod() {
        }
    }

    @Test
    public void testGetAccessibleMethod_NullMethod() {
        // Test with null method
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull(result);
    }

    @Test
    public void testGetAccessibleMethod_PublicMethod() throws NoSuchMethodException {
        // Test with a public method
        Method method = TestClass.class.getMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertSame(method, result);
    }

    @Test
    public void testGetAccessibleMethod_ProtectedMethod() throws NoSuchMethodException {
        // Test with a protected method
        Method method = TestClass.class.getDeclaredMethod("protectedMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result);
    }

    @Test
    public void testGetAccessibleMethod_PrivateMethod() throws NoSuchMethodException {
        // Test with a private method
        Method method = TestClass.class.getDeclaredMethod("privateMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result);
    }

    @Test
    public void testGetAccessibleMethod_PackagePrivateMethod() throws NoSuchMethodException {
        // Test with a package-private method
        Method method = TestClass.class.getDeclaredMethod("packagePrivateMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result);
    }

    @Test
    public void testGetAccessibleMethod_SuperclassPublicMethod() throws NoSuchMethodException {
        // Test with a method from a superclass that is public
        class SuperClass {

            public void superPublicMethod() {
            }
        }
        class SubClass extends SuperClass {
            // Inherits superPublicMethod
        }
        Method method = SubClass.class.getMethod("superPublicMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertSame(method, result);
    }

    @Test
    public void testGetAccessibleMethod_SuperclassProtectedMethod() throws NoSuchMethodException {
        // Test with a protected method from a superclass
        class SuperClass {

            protected void superProtectedMethod() {
            }
        }
        class SubClass extends SuperClass {
            // Inherits superProtectedMethod
        }
        Method method = SubClass.class.getDeclaredMethod("superProtectedMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result);
    }

    @Test
    public void testGetAccessibleMethod_SuperclassPrivateMethod() throws NoSuchMethodException {
        // Test with a private method from a superclass
        class SuperClass {

            private void superPrivateMethod() {
            }
        }
        class SubClass extends SuperClass {
            // Inherits superPrivateMethod
        }
        Method method = SubClass.class.getDeclaredMethod("superPrivateMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result);
    }
}
