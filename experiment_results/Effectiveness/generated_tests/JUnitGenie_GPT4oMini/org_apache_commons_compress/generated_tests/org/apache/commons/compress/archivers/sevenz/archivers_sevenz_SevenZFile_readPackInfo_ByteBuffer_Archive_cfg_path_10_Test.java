package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.Archive;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZFile_readPackInfo_ByteBuffer_Archive_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testReadPackInfo() {
        // Prepare the input ByteBuffer header
        ByteBuffer header = ByteBuffer.allocate(1024);
        // Assuming the first 8 bytes represent a valid long for packPos and numPackStreamsInt
        header.putLong(123456789L); // packPos
        header.putLong(2L); // numPackStreamsInt
        header.put((byte) NID.kSize); // First NID
        header.putLong(1000L); // Size for first stream
        header.putLong(2000L); // Size for second stream
        header.put((byte) NID.kCRC); // Second NID
        header.put((byte) 1); // CRC defined for first stream
        header.put((byte) 1); // CRC defined for second stream
        header.putInt(123456); // CRC value for first stream
        header.putInt(654321); // CRC value for second stream
        header.flip(); // Prepare the buffer for reading

        // Create an instance of Archive
        Archive archive = new Archive();

        // Create an instance of SevenZFile using reflection to access the private method
        try {
            // Create a temporary file to avoid EOFException
            File tempFile = File.createTempFile("dummy", ".7z");
            tempFile.deleteOnExit(); // Ensure the file is deleted after the test

            // Initialize the SevenZFile with the temporary file
            SevenZFile sevenZFile = new SevenZFile(tempFile);

            // Access the private method 'readPackInfo' using reflection
            java.lang.reflect.Method method = SevenZFile.class.getDeclaredMethod("readPackInfo", ByteBuffer.class, Archive.class);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, archive);

            // Assertions to verify the expected outcomes
            assertEquals(123456789L, archive.packPos);
            assertEquals(2, archive.packSizes.length);
            assertEquals(1000L, archive.packSizes[0]);
            assertEquals(2000L, archive.packSizes[1]);
            assertEquals(2, archive.packCrcs.length);
            assertEquals(123456 & 0xffffFFFFL, archive.packCrcs[0]);
            assertEquals(654321 & 0xffffFFFFL, archive.packCrcs[1]);
        } catch (IOException e) {
            // Handle IOException if thrown by the SevenZFile constructor
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions (such as reflection-related exceptions)
            e.printStackTrace();
        }
    }


}