package org.apache.commons.compress.archivers.cpio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

class CpioArchiveEntry_CpioArchiveEntry_55_0_Test {

    @Test
    void testCpioArchiveEntryRegularFile() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 1, tempFile, "testFile", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testFile", entry.getName());
        assertEquals(Files.size(tempFile), entry.getSize());
        assertTrue(Files.isRegularFile(tempFile));
        Files.delete(tempFile);
    }

    @Test
    void testCpioArchiveEntryDirectory() throws IOException {
        Path tempDir = Files.createTempDirectory("testDir");
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 1, tempDir, "testDir", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testDir", entry.getName());
        assertTrue(Files.isDirectory(tempDir));
        Files.delete(tempDir);
    }

    @Test
    void testCpioArchiveEntryInvalidPath() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CpioArchiveEntry entry = new CpioArchiveEntry((short) 1, Paths.get("invalidPath"), "invalidFile", LinkOption.NOFOLLOW_LINKS);
        });
        String expectedMessage = "Cannot determine type of file invalidPath";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
