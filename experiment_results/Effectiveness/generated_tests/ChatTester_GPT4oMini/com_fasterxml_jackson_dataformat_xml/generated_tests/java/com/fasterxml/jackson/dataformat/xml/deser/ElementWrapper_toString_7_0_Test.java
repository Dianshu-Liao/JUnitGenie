package com.fasterxml.jackson.dataformat.xml.deser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ElementWrapper_toString_7_0_Test {

    private ElementWrapper rootWrapper;

    private ElementWrapper emptyNameWrapper;

    private ElementWrapper branchWrapper;

    @BeforeEach
    void setUp() throws Exception {
        rootWrapper = createElementWrapper(null, "rootElement", "namespace");
        emptyNameWrapper = createElementWrapper(rootWrapper, null, "namespace");
        branchWrapper = createElementWrapper(rootWrapper, "childElement", "namespace");
    }

    private ElementWrapper createElementWrapper(ElementWrapper parent, String name, String namespace) throws Exception {
        Constructor<ElementWrapper> constructor = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
        constructor.setAccessible(true);
        return constructor.newInstance(parent, name, namespace);
    }

    @Test
    void testToString_RootWrapper() {
        String result = rootWrapper.toString();
        assertEquals("Wrapper: ROOT, matching: rootElement", result);
    }

    @Test
    void testToString_EmptyNameWrapper() {
        String result = emptyNameWrapper.toString();
        assertEquals("Wrapper: empty", result);
    }

    @Test
    void testToString_BranchWrapper() {
        String result = branchWrapper.toString();
        assertEquals("Wrapper: branch, matching: childElement", result);
    }

    @Test
    void testToString_NullParent() throws Exception {
        ElementWrapper nullParentWrapper = createElementWrapper(null, "testElement", "namespace");
        String result = nullParentWrapper.toString();
        assertEquals("Wrapper: ROOT, matching: testElement", result);
    }

    @Test
    void testToString_NullName() throws Exception {
        ElementWrapper nullNameWrapper = createElementWrapper(rootWrapper, null, "namespace");
        String result = nullNameWrapper.toString();
        assertEquals("Wrapper: empty", result);
    }
}
