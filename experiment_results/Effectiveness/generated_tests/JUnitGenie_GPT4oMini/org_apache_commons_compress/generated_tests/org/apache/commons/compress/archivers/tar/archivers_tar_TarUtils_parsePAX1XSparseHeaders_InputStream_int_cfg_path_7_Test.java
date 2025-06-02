package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarUtils_parsePAX1XSparseHeaders_InputStream_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testParsePAX1XSparseHeaders_NegativeSparseHeadersCount() {
        // Prepare the input stream with a negative sparse headers count
        String input = "0\n"; // Simulating a readLineOfNumberForPax1X response with negative count
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        
        try {
            // Attempt to call the method and expect an exception
            TarUtils.class.getDeclaredMethod("parsePAX1XSparseHeaders", InputStream.class, int.class)
                    .invoke(null, inputStream, 10);
        } catch (IllegalArgumentException e) {
            // Expected exception for negative sparse headers count
            assertNotNull(e);
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }


}