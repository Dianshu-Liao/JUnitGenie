package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo() {
        try {
            // Prepare the ByteBuffer with the required conditions
            ByteBuffer header = ByteBuffer.allocate(10);
            header.put(0, (byte) 11); // This will satisfy the getUnsignedByte condition
            header.putLong(1, 1L); // numFolders
            header.put(9, (byte) 0); // external = 0

            // Create an instance of ArchiveStatistics using reflection
            Class<?> archiveStatsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            Object stats = archiveStatsClass.getDeclaredConstructor().newInstance();

            // Create an instance of SevenZFile using reflection
            SevenZFile sevenZFile = new SevenZFile(new java.io.File("dummy.7z"));

            // Access the private method using reflection
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, archiveStatsClass);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(sevenZFile, header, stats);
        } catch (IOException e) {
            fail("IOException was thrown: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("No such method exception was thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }


}