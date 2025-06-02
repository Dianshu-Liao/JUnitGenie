package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class compressors_lz4_FramedLZ4CompressorOutputStream_close__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCloseWithFinish() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FramedLZ4CompressorOutputStream outputStream = null;

        try {
            outputStream = new FramedLZ4CompressorOutputStream(byteArrayOutputStream);
            outputStream.close();
        } catch (IOException e) {
            // Handle the exception, since close() can throw IOException
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}