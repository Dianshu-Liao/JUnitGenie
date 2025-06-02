package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.DataOutputStream;
import java.io.IOException;

class NewAttribute_getNestedClassFileEntries_7_0_Test {

    private NewAttribute newAttribute;

    @BeforeEach
    void setUp() {
        CPUTF8 attributeName = new CPUTF8("TestAttribute");
        newAttribute = new NewAttribute(attributeName, 0);
    }

    @Test
    void testGetNestedClassFileEntries_EmptyBody() throws Exception {
        ClassFileEntry[] expected = new ClassFileEntry[1];
        expected[0] = newAttribute.getAttributeName();
        ClassFileEntry[] actual = invokeGetNestedClassFileEntries(newAttribute);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetNestedClassFileEntries_WithClassFileEntry() throws Exception {
        // Use mock instead of instantiation
        ClassFileEntry classFileEntry = mock(ClassFileEntry.class);
        // Use reflection to add entry to body
        addBodyEntry(newAttribute, classFileEntry);
        ClassFileEntry[] expected = new ClassFileEntry[2];
        expected[0] = newAttribute.getAttributeName();
        expected[1] = classFileEntry;
        ClassFileEntry[] actual = invokeGetNestedClassFileEntries(newAttribute);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetNestedClassFileEntries_WithMultipleClassFileEntries() throws Exception {
        // Use mock instead of instantiation
        ClassFileEntry classFileEntry1 = mock(ClassFileEntry.class);
        // Use mock instead of instantiation
        ClassFileEntry classFileEntry2 = mock(ClassFileEntry.class);
        // Use reflection to add entry to body
        addBodyEntry(newAttribute, classFileEntry1);
        // Use reflection to add entry to body
        addBodyEntry(newAttribute, classFileEntry2);
        ClassFileEntry[] expected = new ClassFileEntry[3];
        expected[0] = newAttribute.getAttributeName();
        expected[1] = classFileEntry1;
        expected[2] = classFileEntry2;
        ClassFileEntry[] actual = invokeGetNestedClassFileEntries(newAttribute);
        assertArrayEquals(expected, actual);
    }

    private ClassFileEntry[] invokeGetNestedClassFileEntries(NewAttribute attribute) throws Exception {
        Method method = NewAttribute.class.getDeclaredMethod("getNestedClassFileEntries");
        method.setAccessible(true);
        return (ClassFileEntry[]) method.invoke(attribute);
    }

    private void addBodyEntry(NewAttribute attribute, ClassFileEntry entry) throws Exception {
        Method method = NewAttribute.class.getDeclaredMethod("addBodyEntry", Object.class);
        method.setAccessible(true);
        method.invoke(attribute, entry);
    }
}
