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

class JsonPointer__buildPath_28_4_Test {

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
        PointerParent parent = new PointerParent(null, fullPath, fullPathOffset, segment);
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
        PointerParent parent = new PointerParent(new PointerParent(null, fullPath, fullPathOffset, "a"), fullPath, fullPathOffset, segment);
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals(segment, result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
        assertEquals("a", result._nextSegment.getMatchingProperty());
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

    @Test
    void testBuildPathWithEmptySegment() throws Exception {
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "";
        PointerParent parent = new PointerParent(null, fullPath, fullPathOffset, "a");
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

    // Mock class to simulate PointerParent
    static class PointerParent {

        public final PointerParent parent;

        public final String fullPath;

        public final int fullPathOffset;

        public final String segment;

        public PointerParent(PointerParent parent, String fullPath, int fullPathOffset, String segment) {
            this.parent = parent;
            this.fullPath = fullPath;
            this.fullPathOffset = fullPathOffset;
            this.segment = segment;
        }
    }
}
