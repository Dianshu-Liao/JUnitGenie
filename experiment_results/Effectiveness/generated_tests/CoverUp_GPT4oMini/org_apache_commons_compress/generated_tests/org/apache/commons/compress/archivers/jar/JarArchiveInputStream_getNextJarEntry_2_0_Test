package org.apache.commons.compress.archivers.jar;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class JarArchiveInputStream_getNextJarEntry_2_0_Test {

    private JarArchiveInputStream jarArchiveInputStream;

    @BeforeEach
    void setUp() {
        // Initialize the JarArchiveInputStream with an empty input stream
        jarArchiveInputStream = new JarArchiveInputStream(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    void testGetNextJarEntryReturnsNullWhenNoEntries() throws IOException {
        // When there are no entries, the method should return null
        JarArchiveEntry entry = jarArchiveInputStream.getNextJarEntry();
        assertNull(entry, "Expected null when there are no entries");
    }

    @Test
    void testGetNextJarEntryReturnsEntry() throws IOException {
        // Create a zip entry and write it to the input stream
        byte[] zipData = createZipWithSingleEntry("test.txt", "Hello, World!");
        jarArchiveInputStream = new JarArchiveInputStream(new ByteArrayInputStream(zipData));
        // Get the next jar entry
        JarArchiveEntry entry = jarArchiveInputStream.getNextJarEntry();
        assertNotNull(entry, "Expected a JarArchiveEntry to be returned");
        assertEquals("test.txt", entry.getName(), "Entry name should match");
    }

    @Test
    void testGetNextJarEntryHandlesMultipleEntries() throws IOException {
        // Create a zip with multiple entries
        byte[] zipData = createZipWithMultipleEntries(new String[][] { { "file1.txt", "Content for file 1" }, { "file2.txt", "Content for file 2" } });
        jarArchiveInputStream = new JarArchiveInputStream(new ByteArrayInputStream(zipData));
        // Get the first entry
        JarArchiveEntry entry1 = jarArchiveInputStream.getNextJarEntry();
        assertNotNull(entry1, "Expected first JarArchiveEntry to be returned");
        assertEquals("file1.txt", entry1.getName(), "First entry name should match");
        // Get the second entry
        JarArchiveEntry entry2 = jarArchiveInputStream.getNextJarEntry();
        assertNotNull(entry2, "Expected second JarArchiveEntry to be returned");
        assertEquals("file2.txt", entry2.getName(), "Second entry name should match");
        // No more entries should return null
        JarArchiveEntry entry3 = jarArchiveInputStream.getNextJarEntry();
        assertNull(entry3, "Expected null when no more entries");
    }

    private byte[] createZipWithSingleEntry(String fileName, String content) throws IOException {
        // Create a zip with a single entry for testing
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(byteArrayOutputStream)) {
            ZipArchiveEntry entry = new ZipArchiveEntry(fileName);
            zipOutputStream.putArchiveEntry(entry);
            zipOutputStream.write(content.getBytes());
            zipOutputStream.closeArchiveEntry();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] createZipWithMultipleEntries(String[][] entries) throws IOException {
        // Create a zip with multiple entries for testing
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(byteArrayOutputStream)) {
            for (String[] entry : entries) {
                ZipArchiveEntry zipEntry = new ZipArchiveEntry(entry[0]);
                zipOutputStream.putArchiveEntry(zipEntry);
                zipOutputStream.write(entry[1].getBytes());
                zipOutputStream.closeArchiveEntry();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
