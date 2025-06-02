package org.apache.commons.compress.compressors.gzip;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.lang.reflect.Method;
import java.util.zip.CRC32;
import static org.junit.Assert.assertEquals;

public class compressors_gzip_GzipCompressorOutputStream_writeC_String_Charset_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteC() {
        try {
            // Arrange
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            GzipCompressorOutputStream gzipOutputStream = new GzipCompressorOutputStream(outputStream);
            String value = "test";
            Charset charset = Charset.forName("UTF-8");

            // Access the private method using reflection
            Method writeCMethod = GzipCompressorOutputStream.class.getDeclaredMethod("writeC", String.class, Charset.class);
            writeCMethod.setAccessible(true);

            // Act
            writeCMethod.invoke(gzipOutputStream, value, charset);

            // Assert
            byte[] expectedOutput = "test".getBytes(charset);
            byte[] actualOutput = outputStream.toByteArray();
            assertEquals(expectedOutput.length + 1, actualOutput.length); // +1 for the null byte
            assertEquals(expectedOutput[0], actualOutput[0]);
            assertEquals(expectedOutput[1], actualOutput[1]);
            assertEquals(expectedOutput[2], actualOutput[2]);
            assertEquals(expectedOutput[3], actualOutput[3]);
            assertEquals(0, actualOutput[4]); // Check for the null byte

            // Check CRC value
            CRC32 crc = (CRC32) GzipCompressorOutputStream.class.getDeclaredField("crc").get(gzipOutputStream);
            long expectedCrcValue = 0; // Calculate expected CRC value for "test"
            for (byte b : expectedOutput) {
                expectedCrcValue += b;
            }
            expectedCrcValue += 0; // Include the null byte
            assertEquals(expectedCrcValue, crc.getValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}