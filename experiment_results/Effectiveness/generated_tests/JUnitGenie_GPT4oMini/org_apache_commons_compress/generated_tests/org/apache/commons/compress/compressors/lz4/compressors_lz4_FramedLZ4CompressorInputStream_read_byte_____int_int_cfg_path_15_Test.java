package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import static org.junit.Assert.assertEquals;

public class compressors_lz4_FramedLZ4CompressorInputStream_read_byte_____int_int_cfg_path_15_Test {

    private byte[] compress(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        deflater.end();
        return outputStream.toByteArray();
    }

    private byte[] decompress(byte[] data) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (Exception e) {
            throw new IOException("Failed to decompress data", e);
        } finally {
            inflater.end();
        }
        return outputStream.toByteArray();
    }

    @Test(timeout = 4000)
    public void testReadWithValidParameters() throws IOException {
        byte[] inputData = compress(new byte[]{1, 2, 3, 4, 5});
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData);
        FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream);
        
        byte[] buffer = new byte[5];
        int bytesRead = compressorInputStream.read(buffer, 0, 5);
        
        assertEquals(5, bytesRead);
        byte[] decompressedData = decompress(buffer);
        assertEquals(5, decompressedData.length);
    }

    @Test(timeout = 4000)
    public void testReadWithZeroLength() throws IOException {
        byte[] buffer = new byte[5];
        FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(new ByteArrayInputStream(new byte[0]));
        
        int bytesRead = compressorInputStream.read(buffer, 0, 0);
        
        assertEquals(0, bytesRead);
    }

    @Test(timeout = 4000)
    public void testReadWhenEndReached() throws IOException {
        byte[] inputData = compress(new byte[]{1, 2, 3, 4, 5});
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData);
        FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream);
        
        byte[] buffer = new byte[5];
        compressorInputStream.read(buffer, 0, 5); // Read all data first
        int bytesRead = compressorInputStream.read(buffer, 0, 5);
        
        assertEquals(-1, bytesRead);
    }

}