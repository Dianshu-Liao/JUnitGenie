package org.apache.commons.compress.archivers.tar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.Test;

public class archivers_tar_TarArchiveInputStream_readSparse_byte_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadSparse_WhenSparseInputStreamsIsNull_ShouldReadFromOriginalStream() {
        // Prepare inputs
        byte[] buf = new byte[10];
        int offset = 0;
        int numToRead = 10;
        
        try {
            // Create TarArchiveInputStream with null sparseInputStreams
            TarArchiveInputStream tarStream = new TarArchiveInputStream(new ByteArrayInputStream(new byte[20]));
            
            // Use reflection to access the private readSparse method
            Method method = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            method.setAccessible(true);
            
            // Execute the method
            int bytesRead = (int) method.invoke(tarStream, buf, offset, numToRead);
            
            // Validate the output
            assertTrue(bytesRead > 0 && bytesRead <= numToRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadSparse_WhenCurrentSparseInputStreamIndexIsOutOfBounds_ShouldReturnMinusOne() {
        // Prepare inputs
        byte[] buf = new byte[10];
        int offset = 0;
        int numToRead = 10;

        try {
            // Create a list of InputStreams for sparseInputStreams
            List<InputStream> sparseInputStreams = new ArrayList<>();
            sparseInputStreams.add(new ByteArrayInputStream(new byte[5])); // Stream with 5 bytes
            
            // Create an instance of TarArchiveInputStream
            TarArchiveInputStream tarStream = new TarArchiveInputStream(new ByteArrayInputStream(new byte[20]));
            
            // Use reflection to access the private fields
            java.lang.reflect.Field sparseInputStreamsField = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
            sparseInputStreamsField.setAccessible(true);
            sparseInputStreamsField.set(tarStream, sparseInputStreams);
            
            java.lang.reflect.Field indexField = TarArchiveInputStream.class.getDeclaredField("currentSparseInputStreamIndex");
            indexField.setAccessible(true);
            indexField.set(tarStream, 1); // Set index to out of bounds
            
            // Use reflection to access the private readSparse method
            Method method = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            method.setAccessible(true);

            // Execute the method
            int bytesRead = (int) method.invoke(tarStream, buf, offset, numToRead);
            
            // Validate that it returns -1 for out of bounds
            assertEquals(-1, bytesRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testReadSparse_ValidRead_ShouldReturnCorrectNumberOfBytes() {
        // Prepare inputs
        byte[] buf = new byte[10];
        int offset = 0;
        int numToRead = 10;
        
        try {
            // Create a list of InputStreams for sparseInputStreams
            List<InputStream> sparseInputStreams = new ArrayList<>();
            sparseInputStreams.add(new ByteArrayInputStream(new byte[10])); // Stream with exactly 10 bytes

            // Create an instance of TarArchiveInputStream
            TarArchiveInputStream tarStream = new TarArchiveInputStream(new ByteArrayInputStream(new byte[20]));
            
            // Use reflection to access the private fields
            java.lang.reflect.Field sparseInputStreamsField = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
            sparseInputStreamsField.setAccessible(true);
            sparseInputStreamsField.set(tarStream, sparseInputStreams);
            
            // Use reflection to access the private readSparse method
            Method method = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            method.setAccessible(true);

            // Execute the method
            int bytesRead = (int) method.invoke(tarStream, buf, offset, numToRead);
            
            // Validate the output
            assertEquals(10, bytesRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}