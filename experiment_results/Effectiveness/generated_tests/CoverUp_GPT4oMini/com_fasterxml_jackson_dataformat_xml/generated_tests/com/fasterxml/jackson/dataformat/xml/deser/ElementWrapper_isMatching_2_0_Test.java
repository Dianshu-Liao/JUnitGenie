package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ElementWrapper_isMatching_2_0_Test {

    private ElementWrapper wrapperWithName;

    private ElementWrapper wrapperWithoutName;

    @BeforeEach
    void setUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Using reflection to access the private constructor
        Constructor<ElementWrapper> constructorWithName = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
        constructorWithName.setAccessible(true);
        wrapperWithName = constructorWithName.newInstance(null, "testName", "testNamespace");
        Constructor<ElementWrapper> constructorWithoutName = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class);
        constructorWithoutName.setAccessible(true);
        wrapperWithoutName = constructorWithoutName.newInstance(null);
    }

    @Test
    void testIsMatchingWithWrapperName() {
        assertTrue(wrapperWithName.isMatching(), "Expected isMatching() to return true when _wrapperName is not null");
    }

    @Test
    void testIsMatchingWithoutWrapperName() {
        assertFalse(wrapperWithoutName.isMatching(), "Expected isMatching() to return false when _wrapperName is null");
    }
}
