package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ConstantValueAttribute_hashCode_4_0_Test {

    @Test
    public void testHashCode_NullEntry() {
        ConstantValueAttribute attribute = new ConstantValueAttribute(null);
        int expectedHashCode = 31 * attribute.hashCode();
        assertEquals(expectedHashCode, attribute.hashCode());
    }

    @Test
    public void testHashCode_ValidEntry() {
        ClassFileEntry mockEntry = Mockito.mock(ClassFileEntry.class);
        when(mockEntry.hashCode()).thenReturn(42);
        ConstantValueAttribute attribute = new ConstantValueAttribute(mockEntry);
        int expectedHashCode = 31 * attribute.hashCode() + mockEntry.hashCode();
        assertEquals(expectedHashCode, attribute.hashCode());
    }

    @Test
    public void testHashCode_EqualEntries() {
        ClassFileEntry mockEntry = Mockito.mock(ClassFileEntry.class);
        when(mockEntry.hashCode()).thenReturn(42);
        ConstantValueAttribute attribute1 = new ConstantValueAttribute(mockEntry);
        ConstantValueAttribute attribute2 = new ConstantValueAttribute(mockEntry);
        assertEquals(attribute1.hashCode(), attribute2.hashCode());
    }

    @Test
    public void testHashCode_DifferentEntries() {
        ClassFileEntry mockEntry1 = Mockito.mock(ClassFileEntry.class);
        ClassFileEntry mockEntry2 = Mockito.mock(ClassFileEntry.class);
        when(mockEntry1.hashCode()).thenReturn(42);
        when(mockEntry2.hashCode()).thenReturn(43);
        ConstantValueAttribute attribute1 = new ConstantValueAttribute(mockEntry1);
        ConstantValueAttribute attribute2 = new ConstantValueAttribute(mockEntry2);
        assertNotEquals(attribute1.hashCode(), attribute2.hashCode());
    }
}
