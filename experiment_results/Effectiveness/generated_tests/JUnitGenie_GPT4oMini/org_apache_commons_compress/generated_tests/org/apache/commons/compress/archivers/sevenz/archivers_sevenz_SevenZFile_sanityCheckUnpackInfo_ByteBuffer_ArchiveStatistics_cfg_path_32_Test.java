package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_32_Test {
    
    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo() {
        try {
            // Create a ByteBuffer instance with the necessary initial data
            byte[] data = new byte[] { 11, 0 }; // First byte for getUnsignedByte must be 11
            ByteBuffer header = ByteBuffer.wrap(data);
    
            // Use reflection to instantiate the private ArchiveStatistics
            Class<?> archiveStatsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Constructor<?> constructor = archiveStatsClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object stats = constructor.newInstance();
    
            SevenZFile sevenZFile = new SevenZFile((java.io.File) null); // Simplified constructor usage

            // Call the private method using reflection
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatsClass);
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(sevenZFile, header, stats);
        } catch (IOException e) {
            fail("IOException thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfoNegativeUnpackSize() {
        try {
            // Create a ByteBuffer with data that will lead to a negative unpackSize scenario
            byte[] data = new byte[] { 11, 12, 0 }; // Adjust as necessary to simulate the scenario
            ByteBuffer header = ByteBuffer.wrap(data);
    
            // Create an instance of ArchiveStatistics using reflection
            Class<?> archiveStatsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Constructor<?> constructor = archiveStatsClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object stats = constructor.newInstance();
    
            SevenZFile sevenZFile = new SevenZFile((java.io.File) null); // Simplified constructor usage

            // Call the private method using reflection
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatsClass);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(sevenZFile, header, stats);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}