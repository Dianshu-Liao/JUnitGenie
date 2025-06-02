package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo_validInputs() {
        try {
            SevenZFile sevenZFile = new SevenZFile(new File("dummy.7z"));
            ByteBuffer header = ByteBuffer.allocateDirect(16);
            header.put((byte) 11); // Setting first byte to 11 as required.
            header.flip();
            
            // Creating instance of ArchiveStatistics using reflection
            Class<?> archiveStatisticsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Object stats = archiveStatisticsClass.getDeclaredConstructor().newInstance();
            
            // Set dummy values to stats if necessary
            archiveStatisticsClass.getDeclaredField("numberOfOutStreams").set(stats, 5);
            archiveStatisticsClass.getDeclaredField("numberOfInStreams").set(stats, 6);
            archiveStatisticsClass.getDeclaredField("numberOfPackedStreams").set(stats, 3);
            
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatisticsClass);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, stats);
            
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo_invalidNID() {
        try {
            SevenZFile sevenZFile = new SevenZFile(new File("dummy.7z"));
            ByteBuffer header = ByteBuffer.allocateDirect(16);
            header.put((byte) 12); // Setting first byte to an invalid value
            header.flip();

            Class<?> archiveStatisticsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Object stats = archiveStatisticsClass.getDeclaredConstructor().newInstance();

            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatisticsClass);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, stats);
            fail("Expected IOException due to invalid NID was not thrown.");
        } catch (IOException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IOException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo_notEnoughPackedStreams() {
        try {
            SevenZFile sevenZFile = new SevenZFile(new File("dummy.7z"));
            ByteBuffer header = ByteBuffer.allocateDirect(16);
            header.put((byte) 11); // Correct NID
            header.flip();

            Class<?> archiveStatisticsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Object stats = archiveStatisticsClass.getDeclaredConstructor().newInstance();
            
            // Setting the stats such that packed streams < numberOfFolders
            archiveStatisticsClass.getDeclaredField("numberOfFolders").set(stats, 5);
            archiveStatisticsClass.getDeclaredField("numberOfOutStreams").set(stats, 2); // less than numberOfFolders to trigger the condition
            archiveStatisticsClass.getDeclaredField("numberOfInStreams").set(stats, 6);
            archiveStatisticsClass.getDeclaredField("numberOfPackedStreams").set(stats, 3);
            
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatisticsClass);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, stats);
            fail("Expected IOException due to not enough packed streams was not thrown.");
        } catch (IOException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IOException, but got: " + e.getMessage());
        }
    }


}