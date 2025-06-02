package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.junit.Test;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import static org.junit.Assert.assertTrue;

public class archivers_tar_TarFile_isEOFRecord_ByteBuffer_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsEOFRecordWithNullBuffer() {
        try {
            TarFile tarFile = new TarFile(new byte[0]); // Using one of the constructors
            Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
            method.setAccessible(true); // Make the private method accessible

            ByteBuffer headerBuf = null; // Test with null
            boolean result = (boolean) method.invoke(tarFile, headerBuf);
            assertTrue(result); // Expecting true since headerBuf is null
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}