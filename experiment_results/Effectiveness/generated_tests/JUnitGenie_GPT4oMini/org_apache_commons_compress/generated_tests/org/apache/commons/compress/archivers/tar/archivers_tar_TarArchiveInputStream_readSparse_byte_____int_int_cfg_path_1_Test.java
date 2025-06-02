package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class archivers_tar_TarArchiveInputStream_readSparse_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadSparse() {
        // Setup
        byte[] buf = new byte[10];
        int offset = 0;
        int numToRead = 10;

        // Create a list of InputStreams to simulate sparse input streams
        List<InputStream> sparseInputStreams = new ArrayList<>();
        sparseInputStreams.add(new ByteArrayInputStream(new byte[]{1, 2, 3, 4, 5}));
        sparseInputStreams.add(new ByteArrayInputStream(new byte[]{6, 7, 8, 9, 10}));

        // Create an instance of TarArchiveInputStream using reflection
        TarArchiveInputStream tarInputStream = new TarArchiveInputStream(new ByteArrayInputStream(new byte[0]));
        try {
            // Access the private field sparseInputStreams using reflection
            java.lang.reflect.Field sparseInputStreamsField = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
            sparseInputStreamsField.setAccessible(true);
            sparseInputStreamsField.set(tarInputStream, sparseInputStreams);

            // Access the private field currentSparseInputStreamIndex using reflection
            java.lang.reflect.Field currentSparseInputStreamIndexField = TarArchiveInputStream.class.getDeclaredField("currentSparseInputStreamIndex");
            currentSparseInputStreamIndexField.setAccessible(true);
            currentSparseInputStreamIndexField.set(tarInputStream, 0);

            // Execute the method under test
            int bytesRead = (int) TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class)
                    .invoke(tarInputStream, buf, offset, numToRead);

            // Verify the result
            assertEquals(10, bytesRead);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
        // Removed the catch block for IOException as it is not thrown
    }

}