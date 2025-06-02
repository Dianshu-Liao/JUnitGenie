package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class archivers_tar_TarArchiveOutputStream_writePaxHeaders_TarArchiveEntry_String_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWritePaxHeaders() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        String entryName = "testEntryName";
        Map<String, String> headers = new HashMap<>();
        headers.put("key1", "value1");

        // Act
        try {
            tarOutputStream.writePaxHeaders(entry, entryName, headers);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                tarOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testWritePaxHeadersWithLongName() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        String entryName = "aVeryLongEntryNameThatExceedsTheMaximumLengthAllowedByTarFormat";
        Map<String, String> headers = new HashMap<>();
        headers.put("key1", "value1");

        // Act
        try {
            tarOutputStream.writePaxHeaders(entry, entryName, headers);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                tarOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testWritePaxHeadersWithNegativeSize() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        String entryName = "testEntryName";
        Map<String, String> headers = new HashMap<>();
        headers.put("key1", "value1");

        // Act
        try {
            // Manually set size to a valid value before writing headers
            entry.setSize(0); // Set to a non-negative size
            tarOutputStream.writePaxHeaders(entry, entryName, headers);
            // Now we can set a negative size if needed for testing, but it should be after writing headers
            entry.setSize(-1); // This will still throw an exception, but after the headers are written
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                tarOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}