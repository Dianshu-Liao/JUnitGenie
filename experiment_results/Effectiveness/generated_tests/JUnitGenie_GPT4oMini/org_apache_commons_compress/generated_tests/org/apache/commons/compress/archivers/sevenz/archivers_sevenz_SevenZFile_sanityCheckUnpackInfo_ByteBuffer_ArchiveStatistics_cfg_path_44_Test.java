package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_44_Test {
    
    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo_ExternalUnsupported() {
        try {
            // Prepare test data
            byte[] data = new byte[11];
            data[0] = 11; // The first byte that makes nid == 11
            data[1] = 0;  // The second byte that makes external == 0
            // Fill the rest with dummy data as needed
            ByteBuffer header = ByteBuffer.wrap(data);
            
            // Create an instance of ArchiveStatistics using reflection
            Class<?> archiveStatisticsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Constructor<?> constructor = archiveStatisticsClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object stats = constructor.newInstance();
            
            // Access the private method using reflection
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatisticsClass);
            method.setAccessible(true);
            
            // Call the method to check if it throws IOException for external != 0
            // We need to modify one byte in header to make `external != 0`
            header.put(1, (byte) 1); // Now external is 1
            
            // Create a temporary file to use with SevenZFile
            Path tempFile = Files.createTempFile("test", ".7z");
            try (InputStream inputStream = new ByteArrayInputStream(new byte[0]);
                 SeekableByteChannel channel = Files.newByteChannel(tempFile, StandardOpenOption.WRITE)) {
                channel.write(ByteBuffer.wrap(new byte[0])); // Write dummy data to the file
                channel.close(); // Close the channel to flush the data

                SevenZFile sevenZFile = new SevenZFile(tempFile.toFile()); // Use a valid constructor
                
                try {
                    method.invoke(sevenZFile, header, stats);
                    fail("Expected IOException for external unsupported");
                } catch (ReflectiveOperationException e) {
                    // Check if the cause is an IOException
                    if (e.getCause() instanceof IOException) {
                        // Expected exception
                    } else {
                        fail("Unexpected exception: " + e.getCause().getMessage());
                    }
                }
            } finally {
                Files.deleteIfExists(tempFile); // Clean up the temporary file
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}