package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.AsiExtraField;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.SHORT;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public class AsiExtraField_isDirectory_11_0_Test {

    private AsiExtraField asiExtraField;

    @BeforeEach
    public void setUp() {
        asiExtraField = new AsiExtraField();
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsTrueAndNotALink_ShouldReturnTrue() throws Exception {
        // Arrange
        asiExtraField.setDirectory(true);
        // Ensure it's not a link
        setLink("");
        // Act
        boolean result = invokeIsDirectory();
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsTrueAndIsALink_ShouldReturnFalse() throws Exception {
        // Arrange
        asiExtraField.setDirectory(true);
        // Set a link
        setLink("someLink");
        // Act
        boolean result = invokeIsDirectory();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsFalse_ShouldReturnFalse() throws Exception {
        // Arrange
        asiExtraField.setDirectory(false);
        // Ensure it's not a link
        setLink("");
        // Act
        boolean result = invokeIsDirectory();
        // Assert
        assertFalse(result);
    }

    private void setLink(String link) throws Exception {
        Method setLinkedFileMethod = AsiExtraField.class.getDeclaredMethod("setLinkedFile", String.class);
        setLinkedFileMethod.setAccessible(true);
        setLinkedFileMethod.invoke(asiExtraField, link);
    }

    private boolean invokeIsDirectory() throws Exception {
        Method isDirectoryMethod = AsiExtraField.class.getDeclaredMethod("isDirectory");
        isDirectoryMethod.setAccessible(true);
        return (boolean) isDirectoryMethod.invoke(asiExtraField);
    }
}
