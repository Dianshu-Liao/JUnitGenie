package com.fasterxml.jackson.dataformat.xml.deser;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ElementWrapper_isMatching_2_0_Test {

    private ElementWrapper elementWrapperWithName;

    private ElementWrapper elementWrapperWithoutName;

    @BeforeEach
    void setUp() {
        // Using reflection to create instances of ElementWrapper
        try {
            java.lang.reflect.Constructor<ElementWrapper> constructorWithName = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
            constructorWithName.setAccessible(true);
            elementWrapperWithName = constructorWithName.newInstance(null, "testName", "testNamespace");
            java.lang.reflect.Constructor<ElementWrapper> constructorWithoutName = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class);
            constructorWithoutName.setAccessible(true);
            elementWrapperWithoutName = constructorWithoutName.newInstance(null);
        } catch (Exception e) {
            fail("Failed to create ElementWrapper instances: " + e.getMessage());
        }
    }

    @Test
    void testIsMatchingWithName() {
        assertTrue(elementWrapperWithName.isMatching(), "Expected isMatching() to return true when _wrapperName is not null");
    }

    @Test
    void testIsMatchingWithoutName() {
        assertFalse(elementWrapperWithoutName.isMatching(), "Expected isMatching() to return false when _wrapperName is null");
    }
}
