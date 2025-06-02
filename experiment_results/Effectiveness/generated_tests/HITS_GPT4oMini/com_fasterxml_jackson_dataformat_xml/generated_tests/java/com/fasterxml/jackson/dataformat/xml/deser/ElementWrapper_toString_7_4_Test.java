package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ElementWrapper_toString_7_4_Test {

    private ElementWrapper rootWrapper;

    private ElementWrapper childWrapperWithName;

    private ElementWrapper childWrapperWithoutName;

    @BeforeEach
    void setUp() throws Exception {
        Constructor<ElementWrapper> constructor = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
        constructor.setAccessible(true);
        rootWrapper = constructor.newInstance(null, "rootName", "rootNamespace");
        childWrapperWithName = constructor.newInstance(rootWrapper, "childName", "childNamespace");
        childWrapperWithoutName = constructor.newInstance(rootWrapper, null, "childNamespace");
    }

    @Test
    void testToString_RootWrapper() {
        // Test case for the root wrapper
        assertEquals("Wrapper: ROOT, matching: rootName", rootWrapper.toString());
    }

    @Test
    void testToString_ChildWrapperWithName() {
        // Test case for a child wrapper with a name
        assertEquals("Wrapper: branch, matching: childName", childWrapperWithName.toString());
    }

    @Test
    void testToString_ChildWrapperWithoutName() {
        // Test case for a child wrapper without a name
        assertEquals("Wrapper: empty", childWrapperWithoutName.toString());
    }
}
