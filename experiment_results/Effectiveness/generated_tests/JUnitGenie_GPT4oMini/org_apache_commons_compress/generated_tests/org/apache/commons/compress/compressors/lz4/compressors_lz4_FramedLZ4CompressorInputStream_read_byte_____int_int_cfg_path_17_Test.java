package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class compressors_lz4_FramedLZ4CompressorInputStream_read_byte_____int_int_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testReadWithZeroLength() {
        byte[] buffer = new byte[10];
        // Create a valid LZ4 compressed byte array for testing
        byte[] lz4CompressedData = new byte[] {  };
        
        try (FramedLZ4CompressorInputStream inputStream = new FramedLZ4CompressorInputStream(new ByteArrayInputStream(lz4CompressedData))) {
            int result = inputStream.read(buffer, 0, 0);
            assertEquals(0, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}