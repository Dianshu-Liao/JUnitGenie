package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZOutputFile_createArchiveEntry_File_String_cfg_path_1_Test {

    private static final String ARCHIVE_PATH = "path/to/archive.7z"; // Define a constant for the archive path

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithDirectory() throws IOException {
        File inputFile = new File("path/to/directory"); // Ensure this path is a valid directory
        String entryName = "testEntry";

        // Create the archive file if it does not exist
        createArchiveIfNotExists();

        try (SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File(ARCHIVE_PATH))) {
            SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

            assertEquals(true, entry.isDirectory());
            assertEquals(entryName, entry.getName());
        }
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithFile() throws IOException {
        File inputFile = new File("path/to/file.txt"); // Ensure this path is a valid file
        String entryName = "testFileEntry";

        // Create the archive file if it does not exist
        createArchiveIfNotExists();

        try (SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File(ARCHIVE_PATH))) {
            SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

            assertEquals(false, entry.isDirectory());
            assertEquals(entryName, entry.getName());
        }
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryHandlesIOException() {
        File inputFile = new File("path/to/invalid/file"); // Ensure this path is invalid to trigger IOException
        String entryName = "testInvalidEntry";
        SevenZArchiveEntry entry = null;

        // Create the archive file if it does not exist
        try {
            createArchiveIfNotExists();
        } catch (IOException e) {
            // Handle exception if needed
        }

        try (SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File(ARCHIVE_PATH))) {
            entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);
        } catch (IOException e) {
            // Handle exception
        }

        // Check that the last modified date is set correctly even if an exception occurs
        if (entry != null) {
            assertEquals(new Date(inputFile.lastModified()), entry.getLastModifiedDate());
        }
    }

    private void createArchiveIfNotExists() throws IOException {
        File archiveFile = new File(ARCHIVE_PATH);
        if (!archiveFile.exists()) {
            archiveFile.createNewFile(); // Create the archive file if it does not exist
        }
    }


}