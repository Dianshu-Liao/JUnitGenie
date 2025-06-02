package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.core.io.NumberInput;

class JsonPointer__buildPath_28_2_Test {

    private JsonPointer jsonPointer;

    @BeforeEach
    void setUp() {
        jsonPointer = new JsonPointer();
    }

    @Test
    void testBuildPathWithSingleSegment() throws Exception {
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "a";
        PointerParent parent = new PointerParent(fullPath, fullPathOffset, null, segment);
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals(segment, result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithMultipleSegments() throws Exception {
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "b";
        PointerParent parent = new PointerParent(fullPath, fullPathOffset, new PointerParent(fullPath, fullPathOffset, null, "a"), segment);
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals(segment, result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithNullParent() throws Exception {
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "c";
        PointerParent parent = null;
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals(segment, result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
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

        PointerParent parent;

        String segment;

        PointerParent(String fullPath, int fullPathOffset, PointerParent parent, String segment) {
            this.fullPath = fullPath;
            this.fullPathOffset = fullPathOffset;
            this.parent = parent;
            this.segment = segment;
        }
    }
}
