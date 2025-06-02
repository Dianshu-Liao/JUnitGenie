package org.apache.commons.compress.archivers.ar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import org.apache.commons.compress.archivers.ArchiveOutputStream;

public class ArArchiveOutputStream_putArchiveEntry_7_0_Test {

    private ArArchiveOutputStream arOutputStream;

    @BeforeEach
    public void setUp() {
        arOutputStream = new ArArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    public void testPutArchiveEntryFirstEntry() throws IOException {
        ArArchiveEntry entry = new ArArchiveEntry("testfile.txt", 100);
        arOutputStream.putArchiveEntry(entry);
        // No exception should be thrown
    }

    @Test
    public void testPutArchiveEntrySubsequentEntryLengthMismatch() {
        ArArchiveEntry firstEntry = new ArArchiveEntry("file1.txt", 100);
        ArArchiveEntry secondEntry = new ArArchiveEntry("file2.txt", 200);
        try {
            arOutputStream.putArchiveEntry(firstEntry);
            arOutputStream.putArchiveEntry(secondEntry);
            fail("Expected IOException due to length mismatch");
        } catch (IOException e) {
            assertEquals("Length does not match entry (100 != 0", e.getMessage());
        }
    }

    @Test
    public void testPutArchiveEntrySubsequentEntryNoPreviousEntryOpen() throws IOException {
        ArArchiveEntry entry = new ArArchiveEntry("testfile.txt", 100);
        arOutputStream.putArchiveEntry(entry);
        // Close the first entry
        arOutputStream.closeArchiveEntry();
        // Now put a new entry
        ArArchiveEntry newEntry = new ArArchiveEntry("newfile.txt", 100);
        arOutputStream.putArchiveEntry(newEntry);
        // No exception should be thrown
    }

    @Test
    public void testPutArchiveEntryWhenPreviousEntryIsOpen() throws IOException {
        ArArchiveEntry entry = new ArArchiveEntry("testfile.txt", 100);
        arOutputStream.putArchiveEntry(entry);
        // Attempting to put another entry without closing the previous one
        assertThrows(IOException.class, () -> {
            ArArchiveEntry newEntry = new ArArchiveEntry("anotherfile.txt", 50);
            arOutputStream.putArchiveEntry(newEntry);
        });
    }

    @Test
    public void testPutArchiveEntryWithLongFileModeError() {
        arOutputStream.setLongFileMode(ArArchiveOutputStream.LONGFILE_ERROR);
        ArArchiveEntry longEntry = new ArArchiveEntry("thisfilenameiswaytoolong.txt", 100);
        assertThrows(IOException.class, () -> {
            arOutputStream.putArchiveEntry(longEntry);
        });
    }

    @Test
    public void testPutArchiveEntryWithLongFileModeBsd() {
        arOutputStream.setLongFileMode(ArArchiveOutputStream.LONGFILE_BSD);
        ArArchiveEntry longEntry = new ArArchiveEntry("thisfilenameiswaytoolong.txt", 100);
        assertDoesNotThrow(() -> {
            arOutputStream.putArchiveEntry(longEntry);
        });
    }

    @Test
    public void testPutArchiveEntryHandlesMultipleEntries() throws IOException {
        ArArchiveEntry firstEntry = new ArArchiveEntry("file1.txt", 100);
        ArArchiveEntry secondEntry = new ArArchiveEntry("file2.txt", 100);
        arOutputStream.putArchiveEntry(firstEntry);
        // Close first entry
        arOutputStream.closeArchiveEntry();
        arOutputStream.putArchiveEntry(secondEntry);
        // Close second entry
        arOutputStream.closeArchiveEntry();
        // No exceptions should be thrown
    }
}
