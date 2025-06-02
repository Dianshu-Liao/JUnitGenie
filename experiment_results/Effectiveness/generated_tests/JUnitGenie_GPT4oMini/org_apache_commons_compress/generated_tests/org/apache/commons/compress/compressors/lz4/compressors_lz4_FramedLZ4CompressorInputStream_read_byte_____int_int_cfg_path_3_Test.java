package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class compressors_lz4_FramedLZ4CompressorInputStream_read_byte_____int_int_cfg_path_3_Test {

    private byte[] compressData(byte[] data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream)) {
            compressorOutputStream.write(data);
        }
        return outputStream.toByteArray();
    }

    @Test(timeout = 4000)
    public void testRead() throws IOException {
        byte[] inputData = new byte[10]; // Sample input data
        byte[] compressedData = compressData(inputData);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {

            byte[] buffer = new byte[10];
            int off = 0;
            int len = 10;

            // Call the read method
            int result = compressorInputStream.read(buffer, off, len);

            // Validate the result
            assertEquals(10, result); // Expecting 10 since we have 10 bytes of data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadEndReached() throws IOException {
        byte[] inputData = new byte[10]; // Sample input data
        byte[] compressedData = compressData(inputData);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {

            byte[] buffer = new byte[10];
            int off = 0;
            int len = 10;

            // Call the read method
            int result = compressorInputStream.read(buffer, off, len);

            // Validate the result
            assertEquals(10, result); // Expecting 10 since we have 10 bytes of data

            // Read again to check end of stream
            result = compressorInputStream.read(buffer, off, len);
            assertEquals(-1, result); // Expecting -1 since endReached is true

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithValidParameters() throws IOException {
        byte[] inputData = new byte[10]; // Sample input data
        byte[] compressedData = compressData(inputData);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        try (FramedLZ4CompressorInputStream compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream)) {

            byte[] buffer = new byte[10];
            int off = 0;
            int len = 10;

            // Call the read method
            int result = compressorInputStream.read(buffer, off, len);

            // Validate the result
            assertEquals(10, result); // Expecting 10 since we have 10 bytes of data

            // Validate the content read
            assertEquals(Arrays.toString(inputData), Arrays.toString(buffer)); // Check if the data read matches the input data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}