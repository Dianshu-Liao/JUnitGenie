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

public class archivers_tar_TarArchiveInputStream_readSparse_byte_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadSparseWithNonEmptySparseInputStreams() {
        // Arrange
        List<InputStream> sparseInputStreams = new ArrayList<>();
        sparseInputStreams.add(new ByteArrayInputStream(new byte[]{1, 2, 3}));
        sparseInputStreams.add(new ByteArrayInputStream(new byte[]{4, 5}));

        TarArchiveInputStream tarInputStream = new TarArchiveInputStream(new ByteArrayInputStream(new byte[0]));
        // Use reflection to set the private field sparseInputStreams
        try {
            java.lang.reflect.Field sparseInputStreamsField = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
            sparseInputStreamsField.setAccessible(true);
            sparseInputStreamsField.set(tarInputStream, sparseInputStreams);

            java.lang.reflect.Field currentSparseInputStreamIndexField = TarArchiveInputStream.class.getDeclaredField("currentSparseInputStreamIndex");
            currentSparseInputStreamIndexField.setAccessible(true);
            currentSparseInputStreamIndexField.set(tarInputStream, 0);

            // Prepare buffer
            byte[] buf = new byte[5];
            int offset = 0;
            int numToRead = 5;

            // Act
            Method readSparseMethod = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            readSparseMethod.setAccessible(true);
            int bytesRead = (int) readSparseMethod.invoke(tarInputStream, buf, offset, numToRead);

            // Assert
            assertEquals(5, bytesRead);
            assertEquals(1, buf[0]);
            assertEquals(2, buf[1]);
            assertEquals(3, buf[2]);
            assertEquals(4, buf[3]);
            assertEquals(5, buf[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadSparseWithEmptySparseInputStreams() {
        // Arrange
        TarArchiveInputStream tarInputStream = new TarArchiveInputStream(new ByteArrayInputStream(new byte[0]));
        // Use reflection to set the private field sparseInputStreams to an empty list
        try {
            java.lang.reflect.Field sparseInputStreamsField = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
            sparseInputStreamsField.setAccessible(true);
            sparseInputStreamsField.set(tarInputStream, new ArrayList<InputStream>());

            // Prepare buffer
            byte[] buf = new byte[5];
            int offset = 0;
            int numToRead = 5;

            // Act
            Method readSparseMethod = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
            readSparseMethod.setAccessible(true);
            int bytesRead = (int) readSparseMethod.invoke(tarInputStream, buf, offset, numToRead);

            // Assert
            assertEquals(0, bytesRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}