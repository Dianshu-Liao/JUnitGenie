package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarArchiveEntry_getFile__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetFileWhenFileIsNull() {
        TarArchiveEntry entry = new TarArchiveEntry((File) null);
        // The file should be null, so getFile() should return null
        assertNull(entry.getFile());
    }

    @Test(timeout = 4000)
    public void testGetFileWhenFileIsNotNull() throws IOException {
        // Create a temporary file for testing
        Path path = Files.createTempFile("testFile", ".txt");
        TarArchiveEntry entry = new TarArchiveEntry(path.toFile());
        // The file should not be null, so getFile() should return a File object
        File file = entry.getFile();
        assertNotNull(file);
        // Additional assertions can be made here to check the properties of the file if needed

        // Clean up the temporary file after the test
        Files.deleteIfExists(path);
    }

}