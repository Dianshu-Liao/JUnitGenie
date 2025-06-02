package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import static org.junit.Assert.assertEquals;

public class compressors_lz4_FramedLZ4CompressorInputStream_read_byte_____int_int_cfg_path_14_Test {

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
    public void testRead() throws IOException {
        byte[] inputData = new byte[]{1, 2, 3, 4, 5}; // Sample input data
        byte[] compressedData = compress(inputData);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream stream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {
            byte[] buffer = new byte[5];
            int off = 0;
            int len = 5;

            int bytesRead = stream.read(buffer, off, len);
            assertEquals(5, bytesRead); // Expecting to read 5 bytes
        }
    }

    @Test(timeout = 4000)
    public void testReadWithEndReached() throws IOException {
        byte[] inputData = new byte[]{1, 2, 3, 4, 5}; // Sample input data
        byte[] compressedData = compress(inputData);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream stream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {
            byte[] buffer = new byte[5];
            int off = 0;
            int len = 5;

            // Simulate endReached condition
            stream.read(buffer, off, len); // Read first time
            stream.read(buffer, off, len); // Read again to reach end
            int bytesRead = stream.read(buffer, off, len); // Should return -1
            assertEquals(-1, bytesRead); // Expecting to read -1 when end is reached
        }
    }

    @Test(timeout = 4000)
    public void testReadWithZeroLength() throws IOException {
        byte[] inputData = new byte[]{1, 2, 3, 4, 5}; // Sample input data
        byte[] compressedData = compress(inputData);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream stream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {
            byte[] buffer = new byte[5];
            int off = 0;
            int len = 0; // Zero length

            int bytesRead = stream.read(buffer, off, len);
            assertEquals(0, bytesRead); // Expecting to read 0 bytes
        }
    }

}