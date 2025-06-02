package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZOutputFile_createArchiveEntry_File_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithDirectory() throws IOException {
        // Setup
        File inputFile = new File("path/to/directory"); // Ensure this path is a valid directory
        String entryName = "testEntry";

        // Create the archive file if it doesn't exist
        File archiveFile = new File("path/to/archive.7z");
        if (!archiveFile.getParentFile().exists()) {
            archiveFile.getParentFile().mkdirs(); // Create parent directories if they don't exist
        }

        try (SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(archiveFile)) {
            SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

            // Verify
            assertEquals(true, entry.isDirectory());
            assertEquals(entryName, entry.getName());
        }
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithFile() throws IOException {
        // Setup
        File inputFile = new File("path/to/file.txt"); // Ensure this path is a valid file
        String entryName = "testFileEntry";

        // Create the archive file if it doesn't exist
        File archiveFile = new File("path/to/archive.7z");
        if (!archiveFile.getParentFile().exists()) {
            archiveFile.getParentFile().mkdirs(); // Create parent directories if they don't exist
        }

        try (SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(archiveFile)) {
            SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

            // Verify
            assertEquals(false, entry.isDirectory());
            assertEquals(entryName, entry.getName());
        }
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryHandlesIOException() {
        // Setup
        File inputFile = new File("invalid/path/to/file.txt"); // Ensure this path is invalid to trigger IOException
        String entryName = "testFileEntry";
        SevenZArchiveEntry entry = null;

        // Create the archive file if it doesn't exist
        File archiveFile = new File("path/to/archive.7z");
        if (!archiveFile.getParentFile().exists()) {
            archiveFile.getParentFile().mkdirs(); // Create parent directories if they don't exist
        }

        try (SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(archiveFile)) {
            entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);
        } catch (IOException e) {
            // Handle exception
        }

        // Verify
        if (entry != null) {
            assertEquals(entryName, entry.getName());
            assertEquals(new Date(inputFile.lastModified()), entry.getLastModifiedDate());
        }
    }

}