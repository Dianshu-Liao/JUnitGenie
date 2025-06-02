package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveOutputStream_write_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWrite_NoCurrentTarEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        
        // Set the private field haveUnclosedEntry to false using reflection
        try {
            java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("haveUnclosedEntry");
            field.setAccessible(true);
            field.set(tarOutputStream, false);
        } catch (Exception e) {
            fail("Failed to set haveUnclosedEntry field: " + e.getMessage());
        }

        byte[] wBuf = new byte[10];
        int wOffset = 0;
        int numToWrite = 5;

        try {
            tarOutputStream.write(wBuf, wOffset, numToWrite);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Expected IllegalStateException but got IOException: " + e.getMessage());
        }
    }

}