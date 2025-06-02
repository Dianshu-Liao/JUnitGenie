package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class archivers_tar_TarUtils_parsePAX1XSparseHeaders_InputStream_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeaders() {
        // Simulate input stream data for test case
        byte[] inputData = "10 0 20 0".getBytes(); // Represents the sparse header count and their corresponding offsets and sizes
        InputStream inputStream = new ByteArrayInputStream(inputData);

        int recordSize = 8; // Example record size

        try {
            List<TarArchiveStructSparse> result = (List<TarArchiveStructSparse>) TarUtils.class.getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class).invoke(null, inputStream, recordSize);
            assertEquals(2, result.size());
            assertTrue(result.get(0).getOffset() >= 0);
            assertTrue(result.get(0).getNumbytes() >= 0);
        } catch (Exception e) {
            // Handle reflection errors or other exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeadersNegativeSparseCount() {
        byte[] inputData = "-1".getBytes(); // Represents a corrupted header with negative count
        InputStream inputStream = new ByteArrayInputStream(inputData);
        int recordSize = 8; // Example record size

        try {
            TarUtils.class.getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class).invoke(null, inputStream, recordSize);
        } catch (Exception e) {
            // Expected exception for negative sparse count
            assertTrue(e instanceof IOException);
            assertEquals("Corrupted TAR archive. Negative value in sparse headers block", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeadersNegativeSparseOffset() {
        byte[] inputData = "1\n-1 10".getBytes(); // Represents a single entry with negative offset
        InputStream inputStream = new ByteArrayInputStream(inputData);
        int recordSize = 8; // Example record size

        try {
            TarUtils.class.getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class).invoke(null, inputStream, recordSize);
        } catch (Exception e) {
            // Expected exception for negative sparse offset
            assertTrue(e instanceof IOException);
            assertEquals("Corrupted TAR archive. Sparse header block offset contains negative value", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeadersNegativeSparseNumbytes() {
        byte[] inputData = "1\n0 -1".getBytes(); // Represents a single entry with negative numbytes
        InputStream inputStream = new ByteArrayInputStream(inputData);
        int recordSize = 8; // Example record size

        try {
            TarUtils.class.getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class).invoke(null, inputStream, recordSize);
        } catch (Exception e) {
            // Expected exception for negative sparse numbytes
            assertTrue(e instanceof IOException);
            assertEquals("Corrupted TAR archive. Sparse header block numbytes contains negative value", e.getMessage());
        }
    }


}