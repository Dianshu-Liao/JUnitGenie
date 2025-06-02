package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZFile_sanityCheckUnpackInfo_ByteBuffer_ArchiveStatistics_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testSanityCheckUnpackInfo() {
        // Prepare the ByteBuffer with the required bytes
        ByteBuffer header = ByteBuffer.allocate(10);
        header.put(new byte[]{11, 12, 13}); // First byte 11, second byte 12, third byte 13 (not 10)
        header.flip(); // Prepare the buffer for reading

        // Create an instance of ArchiveStatistics using reflection
        Object stats = createArchiveStatistics();

        // Create an instance of SevenZFile using reflection
        SevenZFile sevenZFile = createSevenZFile();

        try {
            // Access the private method using reflection
            java.lang.reflect.Method method = SevenZFile.class.getDeclaredMethod("sanityCheckUnpackInfo", ByteBuffer.class, Object.class);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, stats);
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getMessage());
        }
    }

    private Object createArchiveStatistics() {
        try {
            // Use reflection to create an instance of ArchiveStatistics
            java.lang.reflect.Constructor<?> constructor = SevenZFile.class.getDeclaredClasses()[0].getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ArchiveStatistics instance", e);
        }
    }

    private SevenZFile createSevenZFile() {
        try {
            // Use reflection to create an instance of SevenZFile
            java.lang.reflect.Constructor<SevenZFile> constructor = SevenZFile.class.getDeclaredConstructor(SeekableByteChannel.class);
            constructor.setAccessible(true);
            return constructor.newInstance(Channels.newChannel(new ByteArrayInputStream(new byte[0])));
        } catch (Exception e) {
            throw new RuntimeException("Failed to create SevenZFile instance", e);
        }
    }

}