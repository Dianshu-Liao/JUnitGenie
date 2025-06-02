package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser__skipColonFast_int_cfg_path_50_Test {

    @Test(timeout = 4000)
    public void testSkipColonFast() throws Exception {
        // Arrange
        byte[] inputBuffer = new byte[] {58, 32, 65}; // Example input buffer with a colon followed by space and 'A'
        IOContext ioContext = new IOContext(null, null, false); // Create an appropriate IOContext
        int features = 0; // Set appropriate features if needed
        InputStream inputStream = new ByteArrayInputStream(inputBuffer); // Create an InputStream from the byte array
        ObjectCodec objectCodec = null; // Mock or create an appropriate ObjectCodec
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot(); // Create an appropriate ByteQuadsCanonicalizer

        UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, features, inputStream, objectCodec, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, false);

        // Access the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
            method.setAccessible(true);

            // Act
            int result = (int) method.invoke(parser, 0); // Invoke with the starting pointer

            // Assert
            assertEquals(65, result); // Expecting 'A' (ASCII 65) to be returned
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}