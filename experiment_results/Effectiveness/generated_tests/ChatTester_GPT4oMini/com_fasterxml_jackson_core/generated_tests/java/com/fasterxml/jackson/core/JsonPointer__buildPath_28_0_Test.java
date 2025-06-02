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

public class JsonPointer__buildPath_28_0_Test {

    private static class PointerParent {

        String segment;

        int fullPathOffset;

        PointerParent parent;

        PointerParent(String segment, int fullPathOffset, PointerParent parent) {
            this.segment = segment;
            this.fullPathOffset = fullPathOffset;
            this.parent = parent;
        }
    }

    @Test
    public void testBuildPathWithSingleSegment() throws Exception {
        String fullPath = "/a/b/c";
        int fullPathOffset = 0;
        String segment = "a";
        PointerParent parent = null;
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        // Assuming _asString is accessible for testing
        assertEquals(fullPath, result._asString);
        assertEquals(segment, result.getMatchingProperty());
    }

    @Test
    public void testBuildPathWithMultipleSegments() throws Exception {
        String fullPath = "/a/b/c";
        PointerParent parent = new PointerParent("b", 2, new PointerParent("a", 0, null));
        JsonPointer result = invokeBuildPath(fullPath, 0, "c", parent);
        assertNotNull(result);
        // Assuming _asString is accessible for testing
        assertEquals(fullPath, result._asString);
        assertEquals("c", result.getMatchingProperty());
    }

    @Test
    public void testBuildPathWithNullParent() throws Exception {
        String fullPath = "/a";
        int fullPathOffset = 0;
        String segment = "a";
        PointerParent parent = null;
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        assertNotNull(result);
        // Assuming _asString is accessible for testing
        assertEquals(fullPath, result._asString);
        assertEquals(segment, result.getMatchingProperty());
    }

    @Test
    public void testBuildPathWithComplexParentChain() throws Exception {
        String fullPath = "/a/b/c/d";
        PointerParent parent = new PointerParent("d", 5, new PointerParent("c", 3, new PointerParent("b", 1, new PointerParent("a", 0, null))));
        JsonPointer result = invokeBuildPath(fullPath, 0, "e", parent);
        assertNotNull(result);
        // Assuming _asString is accessible for testing
        assertEquals(fullPath, result._asString);
        assertEquals("e", result.getMatchingProperty());
    }

    private JsonPointer invokeBuildPath(String fullPath, int fullPathOffset, String segment, PointerParent parent) throws Exception {
        Method method = JsonPointer.class.getDeclaredMethod("_buildPath", String.class, int.class, String.class, PointerParent.class);
        method.setAccessible(true);
        return (JsonPointer) method.invoke(null, fullPath, fullPathOffset, segment, parent);
    }
}
