package org.apache.commons.jxpath;

import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;

class BasicNodeSet_getValues_5_0_Test {

    private BasicNodeSet basicNodeSet;

    private Pointer pointer1;

    private Pointer pointer2;

    @BeforeEach
    void setUp() {
        basicNodeSet = new BasicNodeSet();
        pointer1 = Mockito.mock(Pointer.class);
        pointer2 = Mockito.mock(Pointer.class);
        basicNodeSet.getPointers().add(pointer1);
        basicNodeSet.getPointers().add(pointer2);
    }

    @Test
    void testGetValuesFirstCall() {
        when(pointer1.getValue()).thenReturn("Value1");
        when(pointer2.getValue()).thenReturn("Value2");
        List values = basicNodeSet.getValues();
        assertEquals(2, values.size());
        assertEquals("Value1", values.get(0));
        assertEquals("Value2", values.get(1));
        // Ensure the same list is returned on subsequent calls
        assertSame(values, basicNodeSet.getValues());
    }

    @Test
    void testGetValuesWithNoPointers() {
        // Reinitialize with no pointers
        basicNodeSet = new BasicNodeSet();
        List values = basicNodeSet.getValues();
        assertEquals(0, values.size());
    }
}
