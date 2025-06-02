package org.apache.commons.compress.archivers.ar;

import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import org.apache.commons.compress.archivers.ArchiveOutputStream;

class ArArchiveOutputStream_putArchiveEntry_7_0_Test {

    private ArArchiveOutputStream arOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        arOutputStream = new ArArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    void testPutArchiveEntryFirstEntry() throws IOException {
        ArArchiveEntry entry = new ArArchiveEntry("testFile.txt", 100);
        arOutputStream.putArchiveEntry(entry);
        assertNotNull(entry);
    }

    @Test
    void testPutArchiveEntrySubsequentEntryLengthMismatch() throws IOException, NoSuchFieldException, IllegalAccessException {
        ArArchiveEntry firstEntry = new ArArchiveEntry("firstFile.txt", 100);
        arOutputStream.putArchiveEntry(firstEntry);
        ArArchiveEntry secondEntry = new ArArchiveEntry("secondFile.txt", 200);
        // Using reflection to set entryOffset
        Field entryOffsetField = ArArchiveOutputStream.class.getDeclaredField("entryOffset");
        entryOffsetField.setAccessible(true);
        entryOffsetField.set(arOutputStream, 150L);
        IOException exception = assertThrows(IOException.class, () -> {
            arOutputStream.putArchiveEntry(secondEntry);
        });
        assertEquals("Length does not match entry (100 != 150)", exception.getMessage());
    }

    @Test
    void testPutArchiveEntrySubsequentEntryClosePrevious() throws IOException {
        ArArchiveEntry firstEntry = new ArArchiveEntry("firstFile.txt", 100);
        arOutputStream.putArchiveEntry(firstEntry);
        arOutputStream.closeArchiveEntry();
        ArArchiveEntry secondEntry = new ArArchiveEntry("secondFile.txt", 100);
        arOutputStream.putArchiveEntry(secondEntry);
        assertNotNull(secondEntry);
    }

    @Test
    void testPutArchiveEntryWithPreviousEntryOpen() throws IOException, NoSuchFieldException, IllegalAccessException {
        ArArchiveEntry firstEntry = new ArArchiveEntry("firstFile.txt", 100);
        arOutputStream.putArchiveEntry(firstEntry);
        // Using reflection to check prevEntryOpen
        Field prevEntryOpenField = ArArchiveOutputStream.class.getDeclaredField("prevEntryOpen");
        prevEntryOpenField.setAccessible(true);
        assertTrue((Boolean) prevEntryOpenField.get(arOutputStream));
        ArArchiveEntry secondEntry = new ArArchiveEntry("secondFile.txt", 100);
        arOutputStream.putArchiveEntry(secondEntry);
        // Should still be open
        assertTrue((Boolean) prevEntryOpenField.get(arOutputStream));
    }

    @Test
    void testPutArchiveEntryWithClosedPreviousEntry() throws IOException {
        ArArchiveEntry firstEntry = new ArArchiveEntry("firstFile.txt", 100);
        arOutputStream.putArchiveEntry(firstEntry);
        arOutputStream.closeArchiveEntry();
        ArArchiveEntry secondEntry = new ArArchiveEntry("secondFile.txt", 100);
        arOutputStream.putArchiveEntry(secondEntry);
        assertNotNull(secondEntry);
    }
}
