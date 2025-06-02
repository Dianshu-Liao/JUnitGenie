package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeRawUTF8String_byte_____int_int_cfg_path_2_Test {
    private UTF8JsonGenerator generator;
    private ByteArrayOutputStream outputStream;
    private byte[] outputBuffer;
    private int outputEnd;


    @Test(timeout = 4000)
    public void testWriteRawUTF8String() {
        byte[] text = "Hello".getBytes();
        int offset = 0;
        int len = text.length;

        try {
            generator.writeRawUTF8String(text, offset, len);
            // Verify the output
            byte[] result = outputStream.toByteArray();
            assertEquals(7, result.length); // 5 bytes for "Hello" + 2 for quotes
            assertEquals('"', result[0]); // Check the opening quote
            assertEquals('"', result[6]); // Check the closing quote
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteRawUTF8StringWithFlush() {
        byte[] text = "World".getBytes();
        int offset = 0;
        int len = text.length;

        try {
            generator.writeRawUTF8String(text, offset, len);
            // Verify the output
            byte[] result = outputStream.toByteArray();
            assertEquals(7, result.length); // 5 bytes for "World" + 2 for quotes
            assertEquals('"', result[0]); // Check the opening quote
            assertEquals('"', result[6]); // Check the closing quote
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
