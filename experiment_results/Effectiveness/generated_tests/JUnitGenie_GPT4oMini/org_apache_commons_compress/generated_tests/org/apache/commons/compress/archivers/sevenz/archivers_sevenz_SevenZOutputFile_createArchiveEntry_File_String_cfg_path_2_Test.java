package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZOutputFile_createArchiveEntry_File_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateArchiveEntryWithValidInput() throws IOException {
        SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("test.7z"));
        File inputFile = new File("inputDir"); // Assuming this is a valid directory
        String entryName = "entryName";

        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

        assertEquals(entryName, entry.getName());
        assertEquals(true, entry.isDirectory());
        
        sevenZOutputFile.close(); // Close the output file after use
    }

    @Test(timeout = 4000)
    public void testCreateArchiveEntryHandlesIOException() throws IOException {
        SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("test.7z"));
        File inputFile = new File("invalidPath"); // This should trigger an IOException
        String entryName = "entryName";

        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);

        // Check if the last modified date is set to the current date
        Date expectedDate = new Date(inputFile.lastModified());
        assertEquals(expectedDate, entry.getLastModifiedDate());
        
        sevenZOutputFile.close(); // Close the output file after use
    }


}