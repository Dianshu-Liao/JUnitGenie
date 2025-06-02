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

class JsonPointer__buildPath_28_3_Test {

    private JsonPointer jsonPointer;

    @BeforeEach
    void setUp() {
        jsonPointer = new JsonPointer();
    }

    @Test
    void testBuildPathWithSingleSegment() throws Exception {
        String fullPath = "/foo";
        int fullPathOffset = 0;
        String segment = "foo";
        PointerParent parent = null;
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals("foo", result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithMultipleSegments() throws Exception {
        String fullPath = "/foo/bar";
        int fullPathOffset = 0;
        String segment = "bar";
        PointerParent parent = new PointerParent(fullPath, fullPathOffset, "foo", null);
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals("bar", result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
        assertEquals("foo", result._nextSegment.getMatchingProperty());
    }

    @Test
    void testBuildPathWithNullSegment() throws Exception {
        String fullPath = "/foo";
        int fullPathOffset = 0;
        String segment = null;
        PointerParent parent = null;
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertNull(result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    @Test
    void testBuildPathWithEmptyParent() throws Exception {
        String fullPath = "/foo";
        int fullPathOffset = 0;
        String segment = "foo";
        PointerParent parent = new PointerParent(fullPath, fullPathOffset, segment, null);
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        assertEquals("foo", result.getMatchingProperty());
        assertEquals(-1, result.getMatchingIndex());
    }

    private JsonPointer invokeBuildPath(String fullPath, int fullPathOffset, String segment, PointerParent parent) throws Exception {
        Method method = JsonPointer.class.getDeclaredMethod("_buildPath", String.class, int.class, String.class, PointerParent.class);
        method.setAccessible(true);
        return (JsonPointer) method.invoke(null, fullPath, fullPathOffset, segment, parent);
    }

    private static class PointerParent {

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
}
