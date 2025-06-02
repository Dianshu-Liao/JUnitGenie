package org.apache.commons.compress.archivers.zip;

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
    public void testIsDirectory_WhenDirFlagIsTrueAndLinkIsEmpty_ShouldReturnTrue() {
        asiExtraField.setDirectory(true);
        // Ensure the link is empty (default state)
        assertTrue(asiExtraField.isDirectory(), "Expected isDirectory to return true when dirFlag is true and link is empty.");
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsTrueAndLinkIsNotEmpty_ShouldReturnFalse() {
        asiExtraField.setDirectory(true);
        asiExtraField.setLinkedFile("someLink");
        assertFalse(asiExtraField.isDirectory(), "Expected isDirectory to return false when dirFlag is true and link is not empty.");
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsFalse_ShouldReturnFalse() {
        asiExtraField.setDirectory(false);
        // Ensure the link is empty (default state)
        assertFalse(asiExtraField.isDirectory(), "Expected isDirectory to return false when dirFlag is false.");
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsFalseAndLinkIsNotEmpty_ShouldReturnFalse() {
        asiExtraField.setDirectory(false);
        asiExtraField.setLinkedFile("someLink");
        assertFalse(asiExtraField.isDirectory(), "Expected isDirectory to return false when dirFlag is false and link is not empty.");
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsTrueAndLinkIsSetThenCleared_ShouldReturnTrue() {
        asiExtraField.setDirectory(true);
        asiExtraField.setLinkedFile("someLink");
        // Clearing the link
        asiExtraField.setLinkedFile("");
        assertTrue(asiExtraField.isDirectory(), "Expected isDirectory to return true when dirFlag is true and link is cleared.");
    }
}
