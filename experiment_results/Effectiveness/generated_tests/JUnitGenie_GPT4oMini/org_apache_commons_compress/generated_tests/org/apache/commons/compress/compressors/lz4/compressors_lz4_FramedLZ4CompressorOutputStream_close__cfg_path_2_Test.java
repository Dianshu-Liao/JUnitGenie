package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class compressors_lz4_FramedLZ4CompressorOutputStream_close__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testClose() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FramedLZ4CompressorOutputStream compressorOutputStream = null;
        
        try {
            compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream);
            compressorOutputStream.close();
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            // Ensure compressorOutputStream is closed in case initialization succeeded
            if (compressorOutputStream != null) {
                try {
                    compressorOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}