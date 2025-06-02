package org.apache.commons.compress.compressors.gzip;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class compressors_gzip_GzipCompressorOutputStream_writeC_String_Charset_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteCWithNullValue() {
        try {
            // Arrange
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            GzipCompressorOutputStream gzipOutputStream = new GzipCompressorOutputStream(outputStream);
            Method writeCMethod = GzipCompressorOutputStream.class.getDeclaredMethod("writeC", String.class, Charset.class);
            writeCMethod.setAccessible(true);

            // Act
            writeCMethod.invoke(gzipOutputStream, null, Charset.defaultCharset());

            // Assert
            assertEquals(0, outputStream.size()); // Expecting no output when value is null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}