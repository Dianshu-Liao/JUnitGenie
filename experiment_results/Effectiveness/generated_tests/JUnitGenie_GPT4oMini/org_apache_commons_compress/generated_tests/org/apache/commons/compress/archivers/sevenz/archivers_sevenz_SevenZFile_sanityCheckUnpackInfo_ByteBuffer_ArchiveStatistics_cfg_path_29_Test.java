package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo() {
        SevenZFile sevenZFile = null;
        try {
            sevenZFile = new SevenZFile(new File("dummy.7z"));
            Object stats = getArchiveStatisticsInstance();

            ByteBuffer header = ByteBuffer.allocate(5);
            header.put(0, (byte) 11); // Expected from the first call to getUnsignedByte
            header.put(1, (byte) 0);  // Expected from the second call to getUnsignedByte
            header.put(2, (byte) 12); // Expected from the third call to getUnsignedByte
            header.put(3, (byte) 9);  // Not equal to 10 (to satisfy the condition)
            header.put(4, (byte) 0);  // Expected from the fifth call to getUnsignedByte

            // Prepare a try-catch block to handle potential IllegalAccessException, NoSuchMethodException, and InvocationTargetException
            try {
                // Accessing the private method via reflection
                java.lang.reflect.Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, stats.getClass());
                method.setAccessible(true);
                method.invoke(sevenZFile, header, stats);
            } catch (IllegalAccessException | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
                fail("Unexpected exception occurred: " + e.getMessage());
            }
        } catch (IOException e) {
            fail("IOException occurred while creating SevenZFile: " + e.getMessage());
        } finally {
            if (sevenZFile != null) {
                try {
                    sevenZFile.close();
                } catch (IOException e) {
                    fail("IOException occurred while closing SevenZFile: " + e.getMessage());
                }
            }
        }
    }

    private Object getArchiveStatisticsInstance() {
        // Use reflection to create an instance of the private ArchiveStatistics class.
        try {
            java.lang.reflect.Constructor<?> constructor = SevenZFile.class.getDeclaredClasses()[0].getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ArchiveStatistics instance", e);
        }
    }

}