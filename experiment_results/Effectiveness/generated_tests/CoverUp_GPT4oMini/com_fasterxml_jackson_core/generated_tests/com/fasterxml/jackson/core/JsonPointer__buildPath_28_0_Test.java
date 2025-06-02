package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.core.io.NumberInput;

class JsonPointer__buildPath_28_0_Test {

    @Test
    void testBuildPathWithNonNullParent() throws Exception {
        // Arrange
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "b";
        PointerParent parent = new PointerParent("/a", 0, "a", null);
        // Act
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        // Assert
        assertNotNull(result);
        assertEquals("b", result.getMatchingProperty());
        assertEquals(0, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithNullParent() throws Exception {
        // Arrange
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "c";
        PointerParent parent = null;
        // Act
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        // Assert
        assertNotNull(result);
        assertEquals("c", result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithMultipleParents() throws Exception {
        // Arrange
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "b";
        PointerParent parent = new PointerParent("/a", 0, "a", new PointerParent("/b", 1, "b", null));
        // Act
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        // Assert
        assertNotNull(result);
        assertEquals("b", result.getMatchingProperty());
        assertNotNull(result._nextSegment);
        assertEquals("a", result._nextSegment.getMatchingProperty());
    }

    private JsonPointer invokeBuildPath(String fullPath, int fullPathOffset, String segment, PointerParent parent) throws Exception {
        Method method = JsonPointer.class.getDeclaredMethod("_buildPath", String.class, int.class, String.class, PointerParent.class);
        method.setAccessible(true);
        return (JsonPointer) method.invoke(null, fullPath, fullPathOffset, segment, parent);
    }

    // Mocked PointerParent class for testing
    static class PointerParent {

        String fullPath;

        int fullPathOffset;

        String segment;

        PointerParent parent;

        public PointerParent(String fullPath, int fullPathOffset, String segment, PointerParent parent) {
            this.fullPath = fullPath;
            this.fullPathOffset = fullPathOffset;
            this.segment = segment;
            this.parent = parent;
        }
    }
}
