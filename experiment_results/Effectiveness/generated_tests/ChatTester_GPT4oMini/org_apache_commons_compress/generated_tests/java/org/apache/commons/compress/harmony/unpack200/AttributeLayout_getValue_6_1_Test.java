package org.apache.commons.compress.harmony.unpack200;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.lang3.StringUtils;

class AttributeLayout_getValue_6_1_Test {

    private AttributeLayout attributeLayout;

    private SegmentConstantPool mockPool;

    @BeforeEach
    void setUp() throws Pack200Exception {
        attributeLayout = new AttributeLayout("testName", AttributeLayout.CONTEXT_CLASS, "testLayout", 0);
        mockPool = mock(SegmentConstantPool.class);
    }

    @Test
    void testGetValue_ValidLongIndex() throws Pack200Exception {
        long longIndex = 1L;
        // Mocking ClassFileEntry
        ClassFileEntry expectedEntry = mock(ClassFileEntry.class);
        // Adjusted method call
        when(mockPool.getValue(anyInt(), eq(longIndex))).thenReturn(expectedEntry);
        ClassFileEntry result = attributeLayout.getValue(longIndex, mockPool);
        assertNotNull(result);
        assertEquals(expectedEntry, result);
        // Adjusted method call
        verify(mockPool).getValue(anyInt(), eq(longIndex));
    }

    @Test
    void testGetValue_InvalidLongIndex() {
        long longIndex = -1L;
        Pack200Exception thrown = assertThrows(Pack200Exception.class, () -> {
            attributeLayout.getValue(longIndex, mockPool);
        });
        assertEquals("Invalid long index", thrown.getMessage());
    }

    @Test
    void testGetValue_NullPool() {
        long longIndex = 1L;
        Pack200Exception thrown = assertThrows(Pack200Exception.class, () -> {
            attributeLayout.getValue(longIndex, null);
        });
        assertEquals("Pool cannot be null", thrown.getMessage());
    }
}
