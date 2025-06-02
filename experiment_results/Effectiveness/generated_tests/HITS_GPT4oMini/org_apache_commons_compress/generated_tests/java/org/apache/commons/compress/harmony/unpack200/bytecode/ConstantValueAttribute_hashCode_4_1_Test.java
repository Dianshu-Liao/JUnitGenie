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

public class ConstantValueAttribute_hashCode_4_1_Test {

    @Mock
    private ClassFileEntry mockEntry;

    private ConstantValueAttribute attribute;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        attribute = new ConstantValueAttribute(mockEntry);
    }

    @Test
    public void testHashCode_NullEntry() {
        ConstantValueAttribute attribute = new ConstantValueAttribute(null);
        int expectedHashCode = 31 * attribute.hashCode();
        assertEquals(expectedHashCode, attribute.hashCode());
    }

    @Test
    public void testHashCode_ValidEntry() {
        when(mockEntry.hashCode()).thenReturn(42);
        int expectedHashCode = 31 * attribute.hashCode() + 42;
        assertEquals(expectedHashCode, attribute.hashCode());
    }

    @Test
    public void testHashCode_ConsistentWithEqualObjects() {
        ConstantValueAttribute attribute1 = new ConstantValueAttribute(mockEntry);
        ConstantValueAttribute attribute2 = new ConstantValueAttribute(mockEntry);
        assertEquals(attribute1.hashCode(), attribute2.hashCode());
    }

    @Test
    public void testHashCode_DifferentEntries() {
        ClassFileEntry mockEntry1 = mock(ClassFileEntry.class);
        ClassFileEntry mockEntry2 = mock(ClassFileEntry.class);
        ConstantValueAttribute attribute1 = new ConstantValueAttribute(mockEntry1);
        ConstantValueAttribute attribute2 = new ConstantValueAttribute(mockEntry2);
        assertNotEquals(attribute1.hashCode(), attribute2.hashCode());
    }
}
