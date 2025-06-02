package org.apache.commons.compress.harmony.unpack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.lang3.StringUtils;

class AttributeLayout_getValue_0_0_Test {

    @Mock
    private SegmentConstantPool mockPool;

    @InjectMocks
    private AttributeLayout attributeLayout;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetValue_RULayout() throws Exception {
        String layout = "RU";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.UTF_8, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.UTF_8, longIndex);
    }

    @Test
    void testGetValue_RSLayout() throws Exception {
        String layout = "RS";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.SIGNATURE, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.SIGNATURE, longIndex);
    }

    @Test
    void testGetValue_KSLayout() throws Exception {
        String layout = "KS";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.CP_STRING, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.CP_STRING, longIndex);
    }

    @Test
    void testGetValue_KILayout() throws Exception {
        String layout = "KI";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.CP_INT, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.CP_INT, longIndex);
    }

    @Test
    void testGetValue_KFLayout() throws Exception {
        String layout = "KF";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.CP_FLOAT, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.CP_FLOAT, longIndex);
    }

    @Test
    void testGetValue_KJLayout() throws Exception {
        String layout = "KJ";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.CP_LONG, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.CP_LONG, longIndex);
    }

    @Test
    void testGetValue_KDLayout() throws Exception {
        String layout = "KD";
        long longIndex = 1;
        ClassFileEntry mockEntry = mock(ClassFileEntry.class);
        when(mockPool.getValue(SegmentConstantPool.CP_DOUBLE, longIndex)).thenReturn(mockEntry);
        ClassFileEntry result = invokeGetValue(layout, longIndex);
        assertEquals(mockEntry, result);
        verify(mockPool).getValue(SegmentConstantPool.CP_DOUBLE, longIndex);
    }

    @Test
    void testGetValue_UnknownLayout() {
        String layout = "Unknown";
        long longIndex = 1;
        Exception exception = assertThrows(Pack200Exception.class, () -> {
            invokeGetValue(layout, longIndex);
        });
        assertEquals("Unknown layout encoding: Unknown", exception.getMessage());
    }

    private ClassFileEntry invokeGetValue(String layout, long longIndex) throws Exception {
        java.lang.reflect.Method method = AttributeLayout.class.getDeclaredMethod("getValue", String.class, long.class, SegmentConstantPool.class);
        method.setAccessible(true);
        return (ClassFileEntry) method.invoke(null, layout, longIndex, mockPool);
    }
}
