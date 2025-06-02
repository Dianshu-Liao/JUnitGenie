package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NewAttribute_resolve_10_2_Test {

    private NewAttribute newAttribute;

    private ClassConstantPool classConstantPool;

    private CPUTF8 cpuTF8;

    @BeforeEach
    void setUp() {
        cpuTF8 = new CPUTF8("TestAttribute");
        newAttribute = new NewAttribute(cpuTF8, 0);
        classConstantPool = mock(ClassConstantPool.class);
    }

//    @Test
//    void testResolveWithClassFileEntry() throws Exception {
//        ClassFileEntry classFileEntry = mock(ClassFileEntry.class);
//        addBodyElement(newAttribute, classFileEntry);
//        // Invoke the private method using reflection
//        Method resolveMethod = NewAttribute.class.getDeclaredMethod("resolve", ClassConstantPool.class);
//        resolveMethod.setAccessible(true);
//        resolveMethod.invoke(newAttribute, classConstantPool);
//        // Verify that resolve was called on the ClassFileEntry
//        verify(classFileEntry).resolve(classConstantPool);
//    }

    @Test
    void testResolveWithNoClassFileEntry() throws Exception {
        // No ClassFileEntry added to body
        assertTrue(getBody(newAttribute).isEmpty());
        // Invoke the private method using reflection
        Method resolveMethod = NewAttribute.class.getDeclaredMethod("resolve", ClassConstantPool.class);
        resolveMethod.setAccessible(true);
        resolveMethod.invoke(newAttribute, classConstantPool);
        // Verify that resolve was not called on any ClassFileEntry
        // Since there are no ClassFileEntry instances, we cannot verify calls
        // But we can check that the pool is set correctly
        Field poolField = NewAttribute.class.getDeclaredField("pool");
        poolField.setAccessible(true);
        assertEquals(classConstantPool, poolField.get(newAttribute));
    }

    @Test
    void testGetLayoutIndex() {
        assertEquals(0, newAttribute.getLayoutIndex());
    }

    @Test
    void testGetLength() {
        assertEquals(0, newAttribute.getLength());
    }

    @Test
    void testGetNestedClassFileEntries() throws Exception {
        ClassFileEntry classFileEntry = mock(ClassFileEntry.class);
        addBodyElement(newAttribute, classFileEntry);
        ClassFileEntry[] nestedEntries = newAttribute.getNestedClassFileEntries();
        assertEquals(2, nestedEntries.length);
        assertEquals(cpuTF8, nestedEntries[0]);
        assertEquals(classFileEntry, nestedEntries[1]);
    }

    @SuppressWarnings("unchecked")
    private void addBodyElement(NewAttribute newAttribute, Object element) throws Exception {
        Field bodyField = NewAttribute.class.getDeclaredField("body");
        bodyField.setAccessible(true);
        List<Object> bodyList = (List<Object>) bodyField.get(newAttribute);
        bodyList.add(element);
    }

    @SuppressWarnings("unchecked")
    private List<Object> getBody(NewAttribute newAttribute) throws Exception {
        Field bodyField = NewAttribute.class.getDeclaredField("body");
        bodyField.setAccessible(true);
        return (List<Object>) bodyField.get(newAttribute);
    }
}
