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

class JsonPointer__buildPath_28_1_Test {

    private JsonPointer jsonPointer;

    @BeforeEach
    void setUp() {
        jsonPointer = new JsonPointer();
    }

    @Test
    void testBuildPathWithValidInputs() throws Exception {
        // Arrange
        String fullPath = "/some/path";
        int fullPathOffset = 0;
        String segment = "segment";
        PointerParent parent = new PointerParent(null, fullPath, fullPathOffset, segment);
        // Act
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        // Assert
        assertNotNull(result);
    }

    @Test
    void testBuildPathWithNullParent() throws Exception {
        // Arrange
        String fullPath = "/some/path";
        int fullPathOffset = 0;
        String segment = "segment";
        PointerParent parent = null;
        // Act
        JsonPointer result = invokeBuildPath(fullPath, fullPathOffset, segment, parent);
        // Assert
        assertNotNull(result);
    }

    private JsonPointer invokeBuildPath(String fullPath, int fullPathOffset, String segment, PointerParent parent) throws Exception {
        Method method = JsonPointer.class.getDeclaredMethod("_buildPath", String.class, int.class, String.class, PointerParent.class);
        method.setAccessible(true);
        return (JsonPointer) method.invoke(null, fullPath, fullPathOffset, segment, parent);
    }

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
