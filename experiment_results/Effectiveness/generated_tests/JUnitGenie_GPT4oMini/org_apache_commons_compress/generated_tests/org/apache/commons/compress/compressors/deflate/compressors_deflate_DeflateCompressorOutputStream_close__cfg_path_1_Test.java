package org.apache.commons.compress.compressors.deflate;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

public class compressors_deflate_DeflateCompressorOutputStream_close__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testClose() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DeflateCompressorOutputStream deflateCompressorOutputStream = null;
        try {
            deflateCompressorOutputStream = new DeflateCompressorOutputStream(outputStream);
            deflateCompressorOutputStream.close();
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            if (deflateCompressorOutputStream != null) {
                try {
                    deflateCompressorOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}