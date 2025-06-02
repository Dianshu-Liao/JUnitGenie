package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarFile_isEOFRecord_ByteBuffer_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsEOFRecordWithZeroArray() {
        try {
            // Create an instance of TarFile using one of its constructors
            TarFile tarFile = new TarFile(new byte[0]); // Using the constructor with byte array

            // Prepare the ByteBuffer with a zeroed byte array
            byte[] zeroArray = new byte[512]; // Length should match the expected size for EOF record
            ByteBuffer headerBuf = ByteBuffer.wrap(zeroArray);

            // Access the private method using reflection
            Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(tarFile, headerBuf);
            assertFalse(result); // Expecting false since the array is zeroed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEOFRecordWithNullBuffer() {
        try {
            TarFile tarFile = new TarFile(new byte[0]); // Using the constructor with byte array

            // Access the private method using reflection
            Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
            method.setAccessible(true);

            // Invoke the method with null and assert the result
            boolean result = (boolean) method.invoke(tarFile, (ByteBuffer) null);
            assertFalse(result); // Expecting false since headerBuf is null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}