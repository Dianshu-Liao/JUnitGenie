package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.Archive;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZFile_readPackInfo_ByteBuffer_Archive_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testReadPackInfo() {
        // Setup
        ByteBuffer header = ByteBuffer.allocate(1024); // Example buffer size
        Archive archive = new Archive(); // Assuming a default constructor is available

        // Fill the header with test data
        header.putLong(1L); // packPos
        header.putLong(2L); // numPackStreamsInt
        header.put((byte) NID.kSize); // First NID
        header.putLong(100L); // packSizes[0]
        header.put((byte) NID.kCRC); // Second NID
        header.put((byte) 1); // packCrcsDefined
        header.putInt(123456); // packCrcs[0]
        header.flip(); // Prepare buffer for reading

        // Accessing the private method using reflection
        try {
            // Create a dummy file for testing
            File dummyFile = new File("dummy.7z");
            if (!dummyFile.exists()) {
                dummyFile.createNewFile(); // Create the file if it doesn't exist
            }

            SevenZFile sevenZFile = new SevenZFile(dummyFile); // Dummy file
            java.lang.reflect.Method method = SevenZFile.class.getDeclaredMethod("readPackInfo", ByteBuffer.class, Archive.class);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, archive);

            // Assertions
            assertEquals(1L, archive.packPos);
            assertEquals(1, archive.packSizes.length);
            assertEquals(100L, archive.packSizes[0]);
            assertEquals(1, archive.packCrcsDefined.cardinality());
            assertEquals(123456, archive.packCrcs[0]);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}