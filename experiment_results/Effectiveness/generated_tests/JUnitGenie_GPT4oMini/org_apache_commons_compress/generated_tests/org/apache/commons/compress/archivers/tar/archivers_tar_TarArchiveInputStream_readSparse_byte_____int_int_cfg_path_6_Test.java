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

public class archivers_tar_TarArchiveInputStream_readSparse_byte_____int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadSparseWithNoSparseInputStreams() {
        try {
            // Prepare the input stream and the TarArchiveInputStream instance
            byte[] buf = new byte[10];
            InputStream in = new ByteArrayInputStream(new byte[]{1, 2, 3, 4, 5});
            TarArchiveInputStream tarInputStream = new TarArchiveInputStream(in);

            // Access the private field sparseInputStreams using reflection
            java.lang.reflect.Field sparseInputStreamsField = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
            sparseInputStreamsField.setAccessible(true);
            sparseInputStreamsField.set(tarInputStream, null); // Set to null to simulate no sparse input streams

            // Call the private method readSparse using reflection
            Method readSparseMethod = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            readSparseMethod.setAccessible(true);

            // Invoke the method and assert the result
            int bytesRead = (int) readSparseMethod.invoke(tarInputStream, buf, 0, 10);
            assertEquals(5, bytesRead); // Expecting to read 5 bytes from the original input stream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}