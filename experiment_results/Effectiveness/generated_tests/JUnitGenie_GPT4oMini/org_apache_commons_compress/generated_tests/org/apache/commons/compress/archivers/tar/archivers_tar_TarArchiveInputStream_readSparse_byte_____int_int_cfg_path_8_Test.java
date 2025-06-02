package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class archivers_tar_TarArchiveInputStream_readSparse_byte_____int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testReadSparseWithNoSparseInputStreams() {
        // Arrange
        byte[] buf = new byte[10];
        int offset = 0;
        int numToRead = 10;
        InputStream in = new ByteArrayInputStream(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        TarArchiveInputStream tarInputStream = new TarArchiveInputStream(in);

        // Act
        int bytesRead = invokeReadSparse(tarInputStream, buf, offset, numToRead);

        // Assert
        assertEquals(10, bytesRead);
    }

    private int invokeReadSparse(TarArchiveInputStream tarInputStream, byte[] buf, int offset, int numToRead) {
        try {
            Method method = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(tarInputStream, buf, offset, numToRead);
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Indicate failure
        }
    }

}