package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import java.io.DataInput;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import static org.mockito.Mockito.*;

public class json_UTF8DataInputJsonParser__skipUtf8_3__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSkipUtf8_3() {
        // Arrange
        byte[] inputData = new byte[] { (byte) 0x80, (byte) 0x80 }; // Valid UTF-8 bytes
        DataInput dataInput = new DataInputStream(new ByteArrayInputStream(inputData));
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        // Use a real instance instead of mocking ByteQuadsCanonicalizer
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot();

        UTF8DataInputJsonParser parser = new UTF8DataInputJsonParser(ioContext, 0, dataInput, objectCodec, byteQuadsCanonicalizer, 0);

        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipUtf8_3");
            method.setAccessible(true);
            method.invoke(parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipUtf8_3_invalidFirstByte() {
        // Arrange
        byte[] inputData = new byte[] { (byte) 0x00, (byte) 0x80 }; // Invalid first byte
        DataInput dataInput = new DataInputStream(new ByteArrayInputStream(inputData));
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        // Use a real instance instead of mocking ByteQuadsCanonicalizer
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot();

        UTF8DataInputJsonParser parser = new UTF8DataInputJsonParser(ioContext, 0, dataInput, objectCodec, byteQuadsCanonicalizer, 0);

        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipUtf8_3");
            method.setAccessible(true);
            method.invoke(parser);
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception for invalid byte
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testSkipUtf8_3_invalidSecondByte() {
        // Arrange
        byte[] inputData = new byte[] { (byte) 0x80, (byte) 0x00 }; // Valid first byte, invalid second byte
        DataInput dataInput = new DataInputStream(new ByteArrayInputStream(inputData));
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        // Use a real instance instead of mocking ByteQuadsCanonicalizer
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot();

        UTF8DataInputJsonParser parser = new UTF8DataInputJsonParser(ioContext, 0, dataInput, objectCodec, byteQuadsCanonicalizer, 0);

        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipUtf8_3");
            method.setAccessible(true);
            method.invoke(parser);
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception for invalid byte
            } else {
                e.printStackTrace();
            }
        }
    }

}