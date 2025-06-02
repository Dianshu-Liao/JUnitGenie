package org.apache.commons.compress.archivers.zip;

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
    public void testIsDirectory_WhenDirFlagIsTrueAndNotLink_ShouldReturnTrue() throws Exception {
        // Set dirFlag to true
        setPrivateField(asiExtraField, "dirFlag", true);
        // Set link to an empty string (not a link)
        setPrivateField(asiExtraField, "link", "");
        // Invoke isDirectory
        boolean result = invokeIsDirectory(asiExtraField);
        assertTrue(result);
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsTrueAndIsLink_ShouldReturnFalse() throws Exception {
        // Set dirFlag to true
        setPrivateField(asiExtraField, "dirFlag", true);
        // Set link to a non-empty string (indicating a link)
        setPrivateField(asiExtraField, "link", "someLink");
        // Invoke isDirectory
        boolean result = invokeIsDirectory(asiExtraField);
        assertFalse(result);
    }

    @Test
    public void testIsDirectory_WhenDirFlagIsFalse_ShouldReturnFalse() throws Exception {
        // Set dirFlag to false
        setPrivateField(asiExtraField, "dirFlag", false);
        // Set link to an empty string (not a link)
        setPrivateField(asiExtraField, "link", "");
        // Invoke isDirectory
        boolean result = invokeIsDirectory(asiExtraField);
        assertFalse(result);
    }

    private boolean invokeIsDirectory(AsiExtraField asiExtraField) throws Exception {
        Method method = AsiExtraField.class.getDeclaredMethod("isDirectory");
        method.setAccessible(true);
        return (boolean) method.invoke(asiExtraField);
    }

    private void setPrivateField(AsiExtraField asiExtraField, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = AsiExtraField.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(asiExtraField, value);
    }
}
