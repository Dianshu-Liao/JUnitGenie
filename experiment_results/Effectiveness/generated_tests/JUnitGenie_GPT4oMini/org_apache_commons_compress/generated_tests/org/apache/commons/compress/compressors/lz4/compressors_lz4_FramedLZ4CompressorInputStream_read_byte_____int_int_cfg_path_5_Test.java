package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import static org.junit.Assert.assertEquals;

public class compressors_lz4_FramedLZ4CompressorInputStream_read_byte_____int_int_cfg_path_5_Test {

    private byte[] compress(byte[] data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        deflater.end();
        return outputStream.toByteArray();
    }

    private byte[] decompress(byte[] data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        inflater.setInput(data);
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
    public void testReadWhenLenIsGreaterThanZeroAndEndNotReached() throws IOException {
        byte[] inputData = new byte[] {1, 2, 3, 4, 5};
        byte[] compressedData = compress(inputData);
        byte[] buffer = new byte[5];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {
            int bytesRead = compressorInputStream.read(buffer, 0, 5);
            assertEquals(5, bytesRead);
        }
    }

    @Test(timeout = 4000)
    public void testReadWhenLenIsZero() throws IOException {
        byte[] buffer = new byte[5];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] {});
        try (FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {
            int bytesRead = compressorInputStream.read(buffer, 0, 0);
            assertEquals(0, bytesRead);
        }
    }

    @Test(timeout = 4000)
    public void testReadWhenEndReached() throws IOException {
        byte[] buffer = new byte[5];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] {});
        try (FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {
            int bytesRead = compressorInputStream.read(buffer, 0, 5);
            assertEquals(-1, bytesRead);
        }
    }

}