package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_27_Test {
    private UTF8Writer utf8Writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a proper IOContext instead of passing null
        IOContext ioContext = new IOContext(new BufferRecycler(), null, false);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteAsciValue() {
        try {
            utf8Writer.write('A'); // ASCII character
            utf8Writer.write(0); // another value
            utf8Writer.write(127); // another ASCII character

            // Test expected output
            assertArrayEquals(new byte[]{'A', 0, 127}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite2ByteValue() {
        try {
            utf8Writer.write(1280); // 2-byte character (0x500)
            utf8Writer.write(2048); // another 2-byte character (0x800)

            // Test expected output
            assertArrayEquals(new byte[]{(byte) 0xc4, (byte) 0x80, (byte) 0xe0, (byte) 0xa0}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite3ByteValue() {
        try {
            utf8Writer.write(30000); // 3-byte character (0x7530)
            utf8Writer.write(65535); // the edge value for 3 bytes

            // Test expected output
            assertArrayEquals(new byte[]{(byte) 0xe7, (byte) 0xa4, (byte) 0xb1, (byte) 0xff, (byte) 0xfe, (byte) 0xff}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite4ByteValue() {
        try {
            utf8Writer.write(1114112); // 4-byte character (0x110000)
            utf8Writer.write(524288); // another 4-byte character (0x80000)

            // Test expected output
            assertArrayEquals(new byte[]{(byte) 0xf0, (byte) 0x90, (byte) 0x80, (byte) 0x80, (byte) 0xf0, (byte) 0xa0, (byte) 0x80, (byte) 0x00}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}