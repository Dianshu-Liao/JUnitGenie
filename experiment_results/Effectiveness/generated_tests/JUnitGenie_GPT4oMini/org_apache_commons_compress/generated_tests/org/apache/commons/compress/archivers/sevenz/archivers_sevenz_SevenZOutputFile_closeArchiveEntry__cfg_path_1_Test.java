package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class archivers_sevenz_SevenZOutputFile_closeArchiveEntry__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCloseArchiveEntry_EmptyFileBytesWritten() {
        try {
            // Setup
            File testFile = new File("test.7z");
            SevenZOutputFile outputFile = new SevenZOutputFile(testFile);
            
            // Create an entry before writing
            SevenZArchiveEntry entry = new SevenZArchiveEntry();
            outputFile.putArchiveEntry(entry); // add an entry to the list
            
            // Execute the focal method
            outputFile.closeArchiveEntry();
            
            // Verify the expected outcomes
            assert !entry.hasStream(); // entry should not have a stream
            assert entry.getSize() == 0L; // entry size should be 0
            assert entry.getCompressedSize() == 0L; // compressed size should be 0
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException from closeArchiveEntry
        }
    }
    
    @Test(timeout = 4000)
    public void testCloseArchiveEntry_NonEmptyFileBytesWritten() {
        try {
            // Setup
            File testFile = new File("test.7z");
            SevenZOutputFile outputFile = new SevenZOutputFile(testFile);
            
            // Create an entry before writing
            SevenZArchiveEntry entry = new SevenZArchiveEntry();
            outputFile.putArchiveEntry(entry); // add an entry to the list
            
            // Setting up the internal state for the test
            byte[] data = new byte[10]; // simulate some bytes written
            outputFile.write(data);
            
            // Execute the focal method
            outputFile.closeArchiveEntry();
            
            // Verify the expected outcomes
            assert entry.hasStream(); // entry should have a stream
            assert entry.getSize() == data.length; // entry size should match data length
            assert entry.getCompressedSize() == data.length; // compressed size should match
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException from closeArchiveEntry
        }
    }

}