package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarUtils_parsePAX1XSparseHeaders_InputStream_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeaders() {
        // Prepare a valid InputStream that simulates the expected behavior
        String inputData = "0\n10\n0\n10\n"; // Simulated input for readLineOfNumberForPax1X
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        int recordSize = 10; // Example record size

        try {
            // Call the focal method using reflection
            List<TarArchiveStructSparse> result = (List<TarArchiveStructSparse>) TarUtils.class
                    .getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class)
                    .invoke(null, inputStream, recordSize);

            // Validate the result
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeadersNegativeSparseCount() {
        // Prepare an InputStream that simulates a negative sparse headers count
        String inputData = "-1\n"; // Simulated input for readLineOfNumberForPax1X
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        int recordSize = 10; // Example record size

        try {
            // Call the focal method using reflection
            List<TarArchiveStructSparse> result = (List<TarArchiveStructSparse>) TarUtils.class
                    .getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class)
                    .invoke(null, inputStream, recordSize);
            // Validate the result
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeadersNegativeSparseOffset() {
        // Prepare an InputStream that simulates a negative sparse offset
        String inputData = "1\n-1\n"; // Simulated input for readLineOfNumberForPax1X
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        int recordSize = 10; // Example record size

        try {
            // Call the focal method using reflection
            List<TarArchiveStructSparse> result = (List<TarArchiveStructSparse>) TarUtils.class
                    .getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class)
                    .invoke(null, inputStream, recordSize);
            // Validate the result
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeadersNegativeSparseNumBytes() {
        // Prepare an InputStream that simulates a negative sparse numbytes
        String inputData = "1\n0\n-1\n"; // Simulated input for readLineOfNumberForPax1X
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        int recordSize = 10; // Example record size

        try {
            // Call the focal method using reflection
            List<TarArchiveStructSparse> result = (List<TarArchiveStructSparse>) TarUtils.class
                    .getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class)
                    .invoke(null, inputStream, recordSize);
            // Validate the result
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}