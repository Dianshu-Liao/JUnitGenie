package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NewAttribute_resolve_10_0_Test {

    private NewAttribute newAttribute;

    private ClassConstantPool mockPool;

    private ClassFileEntry mockClassFileEntry;

    @BeforeEach
    void setUp() {
        CPUTF8 attributeName = new CPUTF8("TestAttribute");
        newAttribute = new NewAttribute(attributeName, 0);
        mockPool = Mockito.mock(ClassConstantPool.class);
        mockClassFileEntry = Mockito.mock(ClassFileEntry.class);
    }

    @Test
    void testResolveWithClassFileEntry() throws Exception {
        // Add a ClassFileEntry to the body
        List<Object> bodyField = (List<Object>) getPrivateField(newAttribute, "body");
        bodyField.add(mockClassFileEntry);
        // Invoke the resolve method
        invokePrivateMethod(newAttribute, "resolve", ClassConstantPool.class, mockPool);
        // Verify that the resolve method of ClassFileEntry was called
        verify(mockClassFileEntry, times(1)).resolve(mockPool);
        // Verify that the pool was set correctly
        ClassConstantPool actualPool = (ClassConstantPool) getPrivateField(newAttribute, "pool");
        assertSame(mockPool, actualPool);
    }

    @Test
    void testResolveWithNonClassFileEntry() throws Exception {
        // Add a non-ClassFileEntry object to the body
        List<Object> bodyField = (List<Object>) getPrivateField(newAttribute, "body");
        bodyField.add(new Object());
        // Invoke the resolve method
        invokePrivateMethod(newAttribute, "resolve", ClassConstantPool.class, mockPool);
        // Verify that the resolve method of ClassFileEntry was not called
        verify(mockClassFileEntry, never()).resolve(any());
        // Verify that the pool was set correctly
        ClassConstantPool actualPool = (ClassConstantPool) getPrivateField(newAttribute, "pool");
        assertSame(mockPool, actualPool);
    }

    @Test
    void testResolveWithMultipleClassFileEntries() throws Exception {
        // Add multiple ClassFileEntry objects to the body
        List<Object> bodyField = (List<Object>) getPrivateField(newAttribute, "body");
        ClassFileEntry anotherMockClassFileEntry = Mockito.mock(ClassFileEntry.class);
        bodyField.add(mockClassFileEntry);
        bodyField.add(anotherMockClassFileEntry);
        // Invoke the resolve method
        invokePrivateMethod(newAttribute, "resolve", ClassConstantPool.class, mockPool);
        // Verify that the resolve method of both ClassFileEntries was called
        verify(mockClassFileEntry, times(1)).resolve(mockPool);
        verify(anotherMockClassFileEntry, times(1)).resolve(mockPool);
        // Verify that the pool was set correctly
        ClassConstantPool actualPool = (ClassConstantPool) getPrivateField(newAttribute, "pool");
        assertSame(mockPool, actualPool);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    private void invokePrivateMethod(Object obj, String methodName, Class<?> paramType, Object paramValue) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName, paramType);
        method.setAccessible(true);
        method.invoke(obj, paramValue);
    }
}
