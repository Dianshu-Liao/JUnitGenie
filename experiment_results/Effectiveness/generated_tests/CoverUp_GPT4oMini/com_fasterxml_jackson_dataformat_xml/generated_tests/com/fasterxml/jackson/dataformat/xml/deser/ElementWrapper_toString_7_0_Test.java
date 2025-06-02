package com.fasterxml.jackson.dataformat.xml.deser;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ElementWrapper_toString_7_0_Test {

    private ElementWrapper rootWrapper;

    private ElementWrapper childWrapperWithName;

    private ElementWrapper childWrapperWithoutName;

    @BeforeEach
    void setUp() {
        rootWrapper = ElementWrapper.matchingWrapper(null, "root", "namespace");
        childWrapperWithName = ElementWrapper.matchingWrapper(rootWrapper, "child", "namespace");
        childWrapperWithoutName = rootWrapper.intermediateWrapper();
    }

    @Test
    void testToString_RootWrapper() {
        String expected = "Wrapper: ROOT, matching: root";
        String actual = rootWrapper.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToString_ChildWrapperWithName() {
        String expected = "Wrapper: branch, matching: child";
        String actual = childWrapperWithName.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToString_ChildWrapperWithoutName() {
        String expected = "Wrapper: empty";
        String actual = childWrapperWithoutName.toString();
        assertEquals(expected, actual);
    }
}
