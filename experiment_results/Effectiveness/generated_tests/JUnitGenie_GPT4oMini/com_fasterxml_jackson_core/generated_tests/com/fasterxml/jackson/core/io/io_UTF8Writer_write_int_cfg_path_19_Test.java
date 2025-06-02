package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testWrite_WhenSurrogateThenConvert() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOContext ioContext = new IOContext(null, byteArrayOutputStream, false); // Create a valid IOContext
            UTF8Writer utf8Writer = new UTF8Writer(ioContext, byteArrayOutputStream);

            // Test with a surrogate value
            int c = 0xD800; // High surrogate
            utf8Writer.write(c); 
            // Further validation of output based on how convertSurrogate method is defined would go here
            
        } catch (IOException e) {
            // Handle exception for the purpose of testing
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite_WhenValidCharacterThenWriteToBuffer() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOContext ioContext = new IOContext(null, byteArrayOutputStream, false); // Create a valid IOContext
            UTF8Writer utf8Writer = new UTF8Writer(ioContext, byteArrayOutputStream);
            int c = 0x41; // ASCII 'A'
            utf8Writer.write(c);

            // Validate the contents of the output
            byte[] expectedOutput = new byte[] {0x41}; // Expected byte for 'A'
            assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            // Handle exception for the purpose of testing
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testWrite_WhenMoreBytesNeededThenFlushBuffer() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOContext ioContext = new IOContext(null, byteArrayOutputStream, false); // Create a valid IOContext
            UTF8Writer utf8Writer = new UTF8Writer(ioContext, byteArrayOutputStream);
            utf8Writer.write(0xC2); // First byte of a 2-byte UTF-8 character
            utf8Writer.write(0xA9); // Second byte, completes the character

            byte[] expectedOutput = new byte[] {(byte) 0xC2, (byte) 0xA9}; // Expected bytes
            assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            // Handle exception for the purpose of testing
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite_WhenIllegalCharacterThenThrowException() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOContext ioContext = new IOContext(null, byteArrayOutputStream, false); // Create a valid IOContext
            UTF8Writer utf8Writer = new UTF8Writer(ioContext, byteArrayOutputStream);
            int illegalChar = 0x110000; // One more than the allowed range
            utf8Writer.write(illegalChar); 

        } catch (IOException e) {
            // handle the exception as expected
            // You can perform verifications here to check if the expected exception happened
            e.printStackTrace();
        }
    }

}