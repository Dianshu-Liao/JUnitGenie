package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;

public class X5455_ExtendedTimestamp_getCentralDirectoryLength_11_0_Test {

    private X5455_ExtendedTimestamp timestamp;

    @BeforeEach
    public void setUp() {
        timestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testGetCentralDirectoryLength_NoModifyTime() {
        // Given
        // No modify time present (default is false)
        // When
        ZipShort result = timestamp.getCentralDirectoryLength();
        // Then
        assertEquals(new ZipShort(1), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WithModifyTime() throws Exception {
        // Given
        // Use reflection to set the private field bit0_modifyTimePresent to true
        java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
        field.setAccessible(true);
        field.set(timestamp, true);
        // When
        ZipShort result = timestamp.getCentralDirectoryLength();
        // Then
        // 1 + 4 for modify time
        assertEquals(new ZipShort(5), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WithAllBits() throws Exception {
        // Given
        // Use reflection to set all time bits to true
        java.lang.reflect.Field modifyField = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
        modifyField.setAccessible(true);
        modifyField.set(timestamp, true);
        java.lang.reflect.Field accessField = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
        accessField.setAccessible(true);
        accessField.set(timestamp, true);
        java.lang.reflect.Field createField = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
        createField.setAccessible(true);
        createField.set(timestamp, true);
        // When
        ZipShort result = timestamp.getCentralDirectoryLength();
        // Then
        // 1 + 4 (modify) + 4 (access) + 4 (create)
        assertEquals(new ZipShort(13), result);
    }
}
