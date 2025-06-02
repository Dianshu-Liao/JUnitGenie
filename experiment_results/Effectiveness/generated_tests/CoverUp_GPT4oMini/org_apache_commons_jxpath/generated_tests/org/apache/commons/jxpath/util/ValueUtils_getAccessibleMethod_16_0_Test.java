package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ValueUtils;
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

class ValueUtils_getAccessibleMethod_16_0_Test {

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

    private static class SubClass extends TestClass {

        public void overriddenPublicMethod() {
        }

        protected void overriddenProtectedMethod() {
        }
    }

    @Test
    void testGetAccessibleMethod_PublicMethod() throws NoSuchMethodException {
        Method method = TestClass.class.getMethod("publicMethod");
        Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
        assertNotNull(accessibleMethod);
        assertEquals("publicMethod", accessibleMethod.getName());
    }

    @Test
    void testGetAccessibleMethod_ProtectedMethod() throws NoSuchMethodException {
        Method method = TestClass.class.getDeclaredMethod("protectedMethod");
        Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
        assertNull(accessibleMethod);
    }

    @Test
    void testGetAccessibleMethod_PrivateMethod() throws NoSuchMethodException {
        Method method = TestClass.class.getDeclaredMethod("privateMethod");
        Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
        assertNull(accessibleMethod);
    }

    @Test
    void testGetAccessibleMethod_PackagePrivateMethod() throws NoSuchMethodException {
        Method method = TestClass.class.getDeclaredMethod("packagePrivateMethod");
        Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
        assertNull(accessibleMethod);
    }

    @Test
    void testGetAccessibleMethod_FromSubclass() throws NoSuchMethodException {
        Method method = SubClass.class.getMethod("overriddenPublicMethod");
        Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
        assertNotNull(accessibleMethod);
        assertEquals("overriddenPublicMethod", accessibleMethod.getName());
    }

    @Test
    void testGetAccessibleMethod_WithNullMethod() {
        Method accessibleMethod = ValueUtils.getAccessibleMethod(null);
        assertNull(accessibleMethod);
    }

    @Test
    void testGetAccessibleMethod_NonPublicMethodInSuperclass() throws NoSuchMethodException {
        Method method = SubClass.class.getDeclaredMethod("overriddenProtectedMethod");
        Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
        assertNull(accessibleMethod);
    }
}
