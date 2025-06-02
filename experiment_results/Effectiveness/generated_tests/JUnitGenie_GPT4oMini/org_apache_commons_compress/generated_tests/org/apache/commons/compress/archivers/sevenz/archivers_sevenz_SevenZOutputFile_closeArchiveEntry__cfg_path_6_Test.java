package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.io.output.CountingOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZOutputFile_closeArchiveEntry__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCloseArchiveEntry() {
        // Setup
        File testFile = new File("test.7z");
        SevenZOutputFile sevenZOutputFile = null;
        try {
            sevenZOutputFile = new SevenZOutputFile(testFile);
            
            // Prepare the necessary state
            CountingOutputStream countingOutputStream = new CountingOutputStream(new ByteArrayOutputStream());
            
            // Use reflection to access private fields for testing purposes
            java.lang.reflect.Field currentOutputStreamField = SevenZOutputFile.class.getDeclaredField("currentOutputStream");
            currentOutputStreamField.setAccessible(true);
            currentOutputStreamField.set(sevenZOutputFile, countingOutputStream);
            
            java.lang.reflect.Field fileBytesWrittenField = SevenZOutputFile.class.getDeclaredField("fileBytesWritten");
            fileBytesWrittenField.setAccessible(true);
            fileBytesWrittenField.set(sevenZOutputFile, 100L); // Simulate bytes written
            
            java.lang.reflect.Field numNonEmptyStreamsField = SevenZOutputFile.class.getDeclaredField("numNonEmptyStreams");
            numNonEmptyStreamsField.setAccessible(true);
            numNonEmptyStreamsField.set(sevenZOutputFile, 0); // Initial state
            
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            List<SevenZArchiveEntry> files = (List<SevenZArchiveEntry>) filesField.get(sevenZOutputFile);
            SevenZArchiveEntry entry = new SevenZArchiveEntry();
            entry.setSize(100L); // Set size for the entry
            files.add(entry); // Add an entry to the list
            
            java.lang.reflect.Field crc32Field = SevenZOutputFile.class.getDeclaredField("crc32");
            crc32Field.setAccessible(true);
            CRC32 crc32 = (CRC32) crc32Field.get(sevenZOutputFile);
            crc32.update(new byte[100]); // Update CRC with dummy data
            
            java.lang.reflect.Field compressedCrc32Field = SevenZOutputFile.class.getDeclaredField("compressedCrc32");
            compressedCrc32Field.setAccessible(true);
            CRC32 compressedCrc32 = (CRC32) compressedCrc32Field.get(sevenZOutputFile);
            compressedCrc32.update(new byte[100]); // Update compressed CRC with dummy data

            // Execute the method under test
            sevenZOutputFile.closeArchiveEntry();

            // Verify the state after execution
            assertEquals(true, entry.hasStream());
            assertEquals(100L, entry.getSize());
            assertEquals(100L, entry.getCompressedSize());
            assertEquals(crc32.getValue(), entry.getCrcValue());
            assertEquals(compressedCrc32.getValue(), entry.getCompressedCrcValue());
            
            assertEquals(1, numNonEmptyStreamsField.get(sevenZOutputFile)); // Accessing via reflection
            assertEquals(0L, fileBytesWrittenField.get(sevenZOutputFile)); // Accessing via reflection
            
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (sevenZOutputFile != null) {
                try {
                    sevenZOutputFile.close(); // Ensure the output file is closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}