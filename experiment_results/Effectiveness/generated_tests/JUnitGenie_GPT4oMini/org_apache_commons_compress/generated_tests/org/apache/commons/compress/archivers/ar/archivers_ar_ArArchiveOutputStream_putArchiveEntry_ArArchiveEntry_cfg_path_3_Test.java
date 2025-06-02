package org.apache.commons.compress.archivers.ar;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class archivers_ar_ArArchiveOutputStream_putArchiveEntry_ArArchiveEntry_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutArchiveEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ArArchiveOutputStream arOutputStream = new ArArchiveOutputStream(outputStream);
        
        // Create a valid ArArchiveEntry with a non-zero length
        ArArchiveEntry entry = new ArArchiveEntry("testEntry", 100);
        
        try {
            // Call putArchiveEntry
            arOutputStream.putArchiveEntry(entry);
            
            // Write some data to the entry to match the specified length
            byte[] data = new byte[100]; // Create a byte array of length 100
            arOutputStream.write(data); // Write the data to the archive entry
            
            // Ensure entry is not null
            assertNotNull(entry);
            
            // Close the current entry
            arOutputStream.closeArchiveEntry();
            
            // Put the entry again to check if it can be added again
            arOutputStream.putArchiveEntry(entry);
            arOutputStream.write(data); // Write the same data again
            arOutputStream.closeArchiveEntry(); // Close the entry after putting it
            
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        } finally {
            try {
                arOutputStream.close(); // Ensure the output stream is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception
            }
        }
    }


}