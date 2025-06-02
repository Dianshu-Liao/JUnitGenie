package org.apache.commons.jxpath;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class BasicNodeSet_getValues_5_1_Test {

    private BasicNodeSet basicNodeSet;

    @BeforeEach
    void setUp() {
        basicNodeSet = new BasicNodeSet();
    }

    @Test
    void testGetValuesReturnsEmptyListWhenNoPointers() {
        List<Object> values = basicNodeSet.getValues();
        assertNotNull(values);
        assertTrue(values.isEmpty());
    }

    @Test
    void testGetValuesReturnsCorrectValues() {
        // Arrange
        Pointer pointer1 = new Pointer("Value1");
        Pointer pointer2 = new Pointer("Value2");
        addPointer(pointer1);
        addPointer(pointer2);
        // Act
        List<Object> values = basicNodeSet.getValues();
        // Assert
        assertNotNull(values);
        assertEquals(2, values.size());
        assertTrue(values.contains("Value1"));
        assertTrue(values.contains("Value2"));
    }

    @Test
    void testGetValuesReturnsUnmodifiableList() {
        // Arrange
        Pointer pointer = new Pointer("Value");
        addPointer(pointer);
        // Act
        List<Object> values = basicNodeSet.getValues();
        // Assert
        assertThrows(UnsupportedOperationException.class, () -> values.add("NewValue"));
    }

    @Test
    void testGetValuesCachesValues() {
        // Arrange
        Pointer pointer = new Pointer("Value");
        addPointer(pointer);
        // Act
        List<Object> valuesFirstCall = basicNodeSet.getValues();
        List<Object> valuesSecondCall = basicNodeSet.getValues();
        // Assert
        assertSame(valuesFirstCall, valuesSecondCall);
    }

    private void addPointer(Pointer pointer) {
        try {
            Method method = BasicNodeSet.class.getDeclaredMethod("addPointer", Pointer.class);
            method.setAccessible(true);
            method.invoke(basicNodeSet, pointer);
        } catch (Exception e) {
            fail("Failed to add pointer for testing: " + e.getMessage());
        }
    }

    // Mock Pointer class for testing
    static class Pointer {

        private final String value;

        public Pointer(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
