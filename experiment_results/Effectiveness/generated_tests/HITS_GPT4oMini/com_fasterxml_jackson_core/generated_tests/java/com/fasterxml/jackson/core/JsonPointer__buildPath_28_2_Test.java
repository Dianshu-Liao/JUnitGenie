package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.core.io.NumberInput;

@ExtendWith(MockitoExtension.class)
class JsonPointer__buildPath_28_2_Test {

    static class PointerParent {

        String fullPath;

        int fullPathOffset;

        String segment;

        PointerParent parent;

        PointerParent(String fullPath, int fullPathOffset, String segment, PointerParent parent) {
            this.fullPath = fullPath;
            this.fullPathOffset = fullPathOffset;
            this.segment = segment;
            this.parent = parent;
        }
    }

    @BeforeEach
    void setUp() {
        // No setup required for the mock as we are using a simple implementation of PointerParent
    }

    @Test
    void testBuildPathWithValidInputs() throws Exception {
        // Arrange
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "b";
        PointerParent parentMock = new PointerParent(fullPath, fullPathOffset, "a", null);
        // Act
        Method method = JsonPointer.class.getDeclaredMethod("_buildPath", String.class, int.class, String.class, PointerParent.class);
        method.setAccessible(true);
        JsonPointer result = (JsonPointer) method.invoke(null, fullPath, fullPathOffset, segment, parentMock);
        // Assert
        assertNotNull(result);
        assertEquals("b", result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithNullParent() throws Exception {
        // Arrange
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "b";
        // Act
        Method method = JsonPointer.class.getDeclaredMethod("_buildPath", String.class, int.class, String.class, PointerParent.class);
        method.setAccessible(true);
        JsonPointer result = (JsonPointer) method.invoke(null, fullPath, fullPathOffset, segment, null);
        // Assert
        assertNotNull(result);
        assertEquals("b", result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }
}
