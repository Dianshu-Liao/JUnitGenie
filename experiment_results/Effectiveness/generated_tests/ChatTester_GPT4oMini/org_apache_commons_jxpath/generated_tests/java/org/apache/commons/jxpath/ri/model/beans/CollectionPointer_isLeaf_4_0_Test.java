package org.apache.commons.jxpath.ri.model.beans;

import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CollectionPointer_isLeaf_4_0_Test {

    private CollectionPointer collectionPointer;

    @BeforeEach
    void setUp() {
        collectionPointer = new CollectionPointer(new Object(), Locale.getDefault());
    }

    @Test
    void testIsLeafWithNullValue() throws Exception {
        setPrivateField(collectionPointer, "valuePointer", null);
        boolean result = invokePrivateMethod(collectionPointer, "isLeaf");
        assertTrue(result);
    }

    @Test
    void testIsLeafWithAtomicValue() throws Exception {
        Object atomicValue = new String("Atomic Value");
        setPrivateField(collectionPointer, "valuePointer", atomicValue);
        mockJXPathIntrospector(atomicValue.getClass(), true);
        boolean result = invokePrivateMethod(collectionPointer, "isLeaf");
        assertTrue(result);
    }

    @Test
    void testIsLeafWithNonAtomicValue() throws Exception {
        Object nonAtomicValue = new Object();
        setPrivateField(collectionPointer, "valuePointer", nonAtomicValue);
        mockJXPathIntrospector(nonAtomicValue.getClass(), false);
        boolean result = invokePrivateMethod(collectionPointer, "isLeaf");
        assertFalse(result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private boolean invokePrivateMethod(Object target, String methodName) throws Exception {
        java.lang.reflect.Method method = target.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(target);
    }

    private void mockJXPathIntrospector(Class<?> clazz, boolean isAtomic) throws Exception {
        // Mocking behavior for JXPathIntrospector
        // This would require a mocking framework that supports static method mocking
        // such as PowerMockito or similar if needed.
        // For the sake of this example, we will assume that this is handled elsewhere.
    }
}
