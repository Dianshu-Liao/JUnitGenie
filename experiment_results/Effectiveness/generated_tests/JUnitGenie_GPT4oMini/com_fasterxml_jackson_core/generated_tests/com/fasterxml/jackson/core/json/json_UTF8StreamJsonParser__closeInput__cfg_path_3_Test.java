package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import java.io.InputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class json_UTF8StreamJsonParser__closeInput__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloseInputWhenInputStreamIsNull() {
        try {
            // Arrange
            IOContext ioContext = new IOContext(null, null, false);
            InputStream inputStream = null;
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, 
                ByteQuadsCanonicalizer.createRoot(), null, 0, 0, false);

            // Act
            Method closeInputMethod = UTF8StreamJsonParser.class.getDeclaredMethod("_closeInput");
            closeInputMethod.setAccessible(true);
            closeInputMethod.invoke(parser);

            // Assert
            assertNull(parser._inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseInputWhenResourceIsManaged() {
        try {
            // Arrange
            IOContext ioContext = new IOContext(null, null, true); // _managedResource is true
            InputStream inputStream = new InputStream() {
                @Override
                public int read() throws IOException {
                    return -1; // Simulate end of stream
                }
            };
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, 
                ByteQuadsCanonicalizer.createRoot(), null, 0, 0, true); // Auto close source enabled

            // Act
            Method closeInputMethod = UTF8StreamJsonParser.class.getDeclaredMethod("_closeInput");
            closeInputMethod.setAccessible(true);
            closeInputMethod.invoke(parser);

            // Assert
            assertNull(parser._inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseInputWhenAutoCloseSourceIsEnabled() {
        try {
            // Arrange
            IOContext ioContext = new IOContext(null, null, false); // _managedResource is false
            InputStream inputStream = new InputStream() {
                @Override
                public int read() throws IOException {
                    return -1; // Simulate end of stream
                }
            };
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, 
                ByteQuadsCanonicalizer.createRoot(), null, 0, 0, true); // Auto close source enabled

            // Act
            Method closeInputMethod = UTF8StreamJsonParser.class.getDeclaredMethod("_closeInput");
            closeInputMethod.setAccessible(true);
            closeInputMethod.invoke(parser);

            // Assert
            assertNull(parser._inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}