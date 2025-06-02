package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo() {
        try {
            // Prepare the ByteBuffer with the required bytes
            byte[] data = new byte[12];
            data[0] = 11; // First byte for getUnsignedByte
            data[1] = 0;  // Second byte for getUnsignedByte
            // Fill the rest of the data as needed for the test
            for (int i = 2; i < data.length; i++) {
                data[i] = 0;
            }

            ByteBuffer header = ByteBuffer.wrap(data);
            Object stats = createArchiveStatistics();

            // Access the private method using reflection
            Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, Object.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(new SevenZFile(new File("dummy.7z")), header, stats);

        } catch (IOException e) {
            fail("IOException was thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

    private Object createArchiveStatistics() {
        // Create an instance of ArchiveStatistics using reflection
        try {
            Class<?> archiveStatsClass = Class.forName("org.apache.commons.compress.archivers.sevenz.SevenZFile$ArchiveStatistics");
            return archiveStatsClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            fail("Failed to create ArchiveStatistics instance: " + e.getMessage());
            return null; // This will never be reached due to fail
        }
    }

}