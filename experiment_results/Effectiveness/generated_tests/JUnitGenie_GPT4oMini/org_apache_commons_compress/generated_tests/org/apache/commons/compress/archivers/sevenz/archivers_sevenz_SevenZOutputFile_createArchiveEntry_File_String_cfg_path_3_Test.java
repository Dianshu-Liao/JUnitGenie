package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZOutputFile_createArchiveEntry_File_String_cfg_path_3_Test {

    private File archiveFile;
    private SevenZOutputFile sevenZOutputFile;

    @Before
    public void setUp() throws IOException {
        archiveFile = new File("path/to/archive.7z");
        // Create the archive file if it does not exist
        if (!archiveFile.getParentFile().exists()) {
            archiveFile.getParentFile().mkdirs();
        }
        sevenZOutputFile = new SevenZOutputFile(archiveFile);
    }

    @After
    public void tearDown() throws IOException {
        if (sevenZOutputFile != null) {
            sevenZOutputFile.close();
        }
        // Optionally delete the archive file after tests
        if (archiveFile.exists()) {
            archiveFile.delete();
        }
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithDirectory() throws IOException {
        // Setup
        File inputFile = new File("path/to/directory"); // Ensure this path is a directory
        String entryName = "testEntry";

        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

        // Verify
        assertEquals(true, entry.isDirectory());
        assertEquals(entryName, entry.getName());
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithFile() throws IOException {
        // Setup
        File inputFile = new File("path/to/file.txt"); // Ensure this path is a file
        String entryName = "testFileEntry";

        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

        // Verify
        assertEquals(false, entry.isDirectory());
        assertEquals(entryName, entry.getName());
    }



}
