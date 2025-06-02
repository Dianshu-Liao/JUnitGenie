package org.apache.commons.compress.archivers.cpio;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class CpioArchiveEntry_CpioArchiveEntry_58_1_Test {

    // Assuming FORMAT_NEW is defined as 0
    private static final short FORMAT_NEW = 0;

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new CpioArchiveEntry("testEntry");
    }

    @Test
    public void testCpioArchiveEntryWithName() {
        assertNotNull(entry);
        assertEquals("testEntry", invokePrivateField(entry, "name"));
        assertEquals(FORMAT_NEW, invokePrivateField(entry, "fileFormat"));
    }

    @Test
    public void testCpioArchiveEntryInitialization() {
        // Validate that the fields are initialized correctly
        assertEquals(0, invokePrivateField(entry, "headerSize"));
        assertEquals(0, invokePrivateField(entry, "alignmentBoundary"));
        assertEquals(0, invokePrivateField(entry, "chksum"));
        assertEquals(0, invokePrivateField(entry, "fileSize"));
        assertEquals(0, invokePrivateField(entry, "gid"));
        assertEquals(0, invokePrivateField(entry, "inode"));
        assertEquals(0, invokePrivateField(entry, "maj"));
        assertEquals(0, invokePrivateField(entry, "min"));
        assertEquals(0, invokePrivateField(entry, "mode"));
        assertEquals(0, invokePrivateField(entry, "mtime"));
        assertEquals(0, invokePrivateField(entry, "nlink"));
        assertEquals(0, invokePrivateField(entry, "rmaj"));
        assertEquals(0, invokePrivateField(entry, "rmin"));
        assertEquals(0, invokePrivateField(entry, "uid"));
    }

    private Object invokePrivateField(CpioArchiveEntry entry, String fieldName) {
        try {
            java.lang.reflect.Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(entry);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            // unreachable
            return null;
        }
    }
}
