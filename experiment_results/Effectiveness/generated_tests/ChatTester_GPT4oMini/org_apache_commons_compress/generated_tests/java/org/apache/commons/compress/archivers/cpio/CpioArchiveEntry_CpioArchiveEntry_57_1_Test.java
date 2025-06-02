package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Field;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

@ExtendWith(MockitoExtension.class)
public class CpioArchiveEntry_CpioArchiveEntry_57_1_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initial setup can be done here if needed
    }

    @Test
    public void testConstructorWithValidParameters() {
        short format = 1;
        String name = "testEntry";
        long size = 1024;
        entry = new CpioArchiveEntry(format, name, size);
        assertNotNull(entry);
        assertEquals(format, getPrivateField(entry, "fileFormat"));
        assertEquals(name, getPrivateField(entry, "name"));
        assertEquals(size, getPrivateField(entry, "fileSize"));
    }

    @Test
    public void testConstructorWithNegativeSize() {
        short format = 1;
        String name = "testEntry";
        long size = -1024;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry = new CpioArchiveEntry(format, name, size);
        });
        String expectedMessage = "Invalid entry size <-1024>";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testConstructorWithZeroSize() {
        short format = 1;
        String name = "testEntry";
        long size = 0;
        entry = new CpioArchiveEntry(format, name, size);
        assertNotNull(entry);
        assertEquals(format, getPrivateField(entry, "fileFormat"));
        assertEquals(name, getPrivateField(entry, "name"));
        assertEquals(size, getPrivateField(entry, "fileSize"));
    }

    @Test
    public void testConstructorWithLargeSize() {
        short format = 1;
        String name = "testEntry";
        // Larger than the maximum allowed size
        long size = 0xFFFFFFFFL + 1;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry = new CpioArchiveEntry(format, name, size);
        });
        String expectedMessage = "Invalid entry size <4294967296>";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private Object getPrivateField(CpioArchiveEntry entry, String fieldName) {
        try {
            Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(entry);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to access private field: " + fieldName);
            return null;
        }
    }
}
