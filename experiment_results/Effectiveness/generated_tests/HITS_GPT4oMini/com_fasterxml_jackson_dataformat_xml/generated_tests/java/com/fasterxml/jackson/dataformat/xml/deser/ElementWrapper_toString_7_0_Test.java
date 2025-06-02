package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class ElementWrapper_toString_7_0_Test {

    private ElementWrapper createElementWrapper(ElementWrapper parent, String localName, String namespace) throws Exception {
        Constructor<ElementWrapper> constructor = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
        // Bypass the private access modifier
        constructor.setAccessible(true);
        return constructor.newInstance(parent, localName, namespace);
    }

    @Test
    public void testToString_RootWrapper() throws Exception {
        // Arrange: Create an ElementWrapper instance with null parent
        ElementWrapper wrapper = createElementWrapper(null, "testWrapper", "testNamespace");
        // Act: Call the toString method
        String result = wrapper.toString();
        // Assert: Verify the expected output for root wrapper
        assertEquals("Wrapper: ROOT, matching: testWrapper", result);
    }

    @Test
    public void testToString_NullWrapperName() throws Exception {
        // Arrange: Create an ElementWrapper instance with null parent and null wrapper name
        ElementWrapper wrapper = createElementWrapper(null, null, "testNamespace");
        // Act: Call the toString method
        String result = wrapper.toString();
        // Assert: Verify the expected output for empty wrapper name
        assertEquals("Wrapper: empty", result);
    }

    @Test
    public void testToString_BranchWrapper() throws Exception {
        // Arrange: Create a parent ElementWrapper
        ElementWrapper parentWrapper = createElementWrapper(null, "parentWrapper", "parentNamespace");
        // Create an ElementWrapper instance with a non-null parent
        ElementWrapper wrapper = createElementWrapper(parentWrapper, "childWrapper", "childNamespace");
        // Act: Call the toString method
        String result = wrapper.toString();
        // Assert: Verify the expected output for branch wrapper
        assertEquals("Wrapper: branch, matching: childWrapper", result);
    }
}
