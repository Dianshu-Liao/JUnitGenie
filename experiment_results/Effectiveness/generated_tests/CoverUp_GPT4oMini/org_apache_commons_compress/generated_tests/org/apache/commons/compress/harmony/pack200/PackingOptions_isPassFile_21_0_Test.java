package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.objectweb.asm.Attribute;

class PackingOptions_isPassFile_21_0_Test {

    private PackingOptions packingOptions;

    @BeforeEach
    void setUp() {
        packingOptions = new PackingOptions();
    }

    @Test
    void testIsPassFile_ReturnsTrue_WhenFileIsInPassFiles() {
        // Arrange
        invokeAddPassFile("testFile.class");
        // Act
        boolean result = packingOptions.isPassFile("testFile.class");
        // Assert
        assertTrue(result);
    }

    @Test
    void testIsPassFile_ReturnsTrue_WhenDirectoryIsInPassFiles() {
        // Arrange
        invokeAddPassFile("testDir/");
        // Act
        boolean result = packingOptions.isPassFile("testDir/testFile.class");
        // Assert
        assertTrue(result);
    }

    @Test
    void testIsPassFile_ReturnsFalse_WhenFileIsNotInPassFiles() {
        // Arrange
        invokeAddPassFile("anotherFile.class");
        // Act
        boolean result = packingOptions.isPassFile("testFile.class");
        // Assert
        assertFalse(result);
    }

    @Test
    void testIsPassFile_ReturnsFalse_WhenFileIsNotInPassFilesAndNotMatching() {
        // Arrange
        invokeAddPassFile("testDir/");
        // Act
        boolean result = packingOptions.isPassFile("otherDir/testFile.class");
        // Assert
        assertFalse(result);
    }

    private void invokeAddPassFile(String fileName) {
        try {
            Method method = PackingOptions.class.getDeclaredMethod("addPassFile", String.class);
            method.setAccessible(true);
            method.invoke(packingOptions, fileName);
        } catch (Exception e) {
            fail("Failed to invoke addPassFile method: " + e.getMessage());
        }
    }
}
