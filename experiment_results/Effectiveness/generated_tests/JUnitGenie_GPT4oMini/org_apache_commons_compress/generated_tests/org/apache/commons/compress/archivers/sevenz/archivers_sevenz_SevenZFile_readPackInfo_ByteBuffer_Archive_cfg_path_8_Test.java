package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.Archive;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZFile_readPackInfo_ByteBuffer_Archive_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testReadPackInfo() {
        // Setup
        ByteBuffer header = ByteBuffer.allocate(1024);
        header.putLong(1L); // packPos
        header.putLong(2L); // numPackStreamsInt
        header.put((byte) NID.kSize); // nid
        header.putLong(3L); // packSizes[0]
        header.putLong(4L); // packSizes[1]
        header.put((byte) NID.kCRC); // nid
        header.put((byte) 1); // packCrcsDefined
        header.putInt(5); // packCrcs[0]
        header.flip(); // Prepare buffer for reading

        Archive archive = new Archive(); // Create an instance of Archive

        // Create an instance of SevenZFile using reflection
        SevenZFile sevenZFile = null;
        try {
            sevenZFile = (SevenZFile) SevenZFile.class.getDeclaredConstructor(File.class).newInstance(new File("dummy.7z"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Access the private method readPackInfo using reflection
        try {
            Method method = SevenZFile.class.getDeclaredMethod("readPackInfo", ByteBuffer.class, Archive.class);
            method.setAccessible(true);
            method.invoke(sevenZFile, header, archive);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify the results
        assertEquals(1L, archive.packPos);
        assertEquals(2, archive.packSizes.length);
        assertEquals(3L, archive.packSizes[0]);
        assertEquals(4L, archive.packSizes[1]);
    }

}