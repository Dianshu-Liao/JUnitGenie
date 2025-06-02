package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_1_Test {
    
    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo_throwsIOException_whenNidIsNotKFolder() {
        try {
            // Arrange
            SevenZFile sevenZFile = new SevenZFile(new java.io.File("dummy.7z"));
            ByteBuffer header = ByteBuffer.allocate(10);
            // Use a public constructor or method to obtain SevenZArchiveEntry instead of ArchiveEntry
            Method statsMethod = SevenZFile.class.getDeclaredMethod("getArchiveEntry"); // Ensure this method exists
            SevenZArchiveEntry entry = (SevenZArchiveEntry) statsMethod.invoke(sevenZFile); // Corrected type

            // Simulate an incorrect nid value for kFolder 
            header.put(new byte[] { 0x0A });  // Some value other than expected kFolder

            // Act
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, SevenZArchiveEntry.class); // Ensure this method exists
            method.setAccessible(true); // Make the private method accessible
            method.invoke(sevenZFile, header, entry);
            
            // If no exception is thrown, the test should fail
            fail("Expected IOException not thrown");
        } catch (IOException e) {
            // The expected exception was thrown, this is fine.
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }


}