package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_bsW_7_0_Test {

    private ByteArrayOutputStream outputStream;

    private BZip2CompressorOutputStream compressor;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        compressor = new BZip2CompressorOutputStream(outputStream);
    }

    // Public method to indirectly test bsW
    public void writeBits(int n, int v) throws IOException {
        // This method will call the private bsW
        // Using reflection to access the private method
        try {
            java.lang.reflect.Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("bsW", int.class, int.class);
            method.setAccessible(true);
            method.invoke(compressor, n, v);
        } catch (Exception e) {
            throw new IOException("Failed to write bits", e);
        }
    }

    @Test
    public void testBsW_SingleByte() throws IOException {
        writeBits(8, 0b10101010);
        writeBits(8, 0b11110000);
        writeBits(8, 0b00001111);
        byte[] expected = new byte[] { (byte) 0b10101010, (byte) 0b11110000, (byte) 0b00001111 };
        byte[] actual = outputStream.toByteArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBsW_MultipleBytes() throws IOException {
        writeBits(8, 0b00000001);
        writeBits(8, 0b00000010);
        writeBits(8, 0b00000011);
        writeBits(8, 0b00000100);
        byte[] expected = new byte[] { 0b00000001, 0b00000010, 0b00000011, 0b00000100 };
        byte[] actual = outputStream.toByteArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBsW_Overflow() throws IOException {
        writeBits(8, 0b11111111);
        writeBits(8, 0b00000001);
        writeBits(8, 0b00000010);
        writeBits(8, 0b00000011);
        writeBits(8, 0b00000100);
        byte[] expected = new byte[] { (byte) 0b11111111, (byte) 0b00000001, (byte) 0b00000010, (byte) 0b00000011, (byte) 0b00000100 };
        byte[] actual = outputStream.toByteArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBsW_InvalidInput() {
        assertThrows(IOException.class, () -> {
            writeBits(0, 0);
        });
    }

    @Test
    public void testBsW_NegativeBits() {
        assertThrows(IOException.class, () -> {
            writeBits(-1, 0b10101010);
        });
    }
}
