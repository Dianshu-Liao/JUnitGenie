package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.InputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.mockito.Mockito.*;

public class json_UTF8StreamJsonParser__closeInput__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCloseInput() {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        InputStream inputStream = mock(InputStream.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        
        // Create an instance of UTF8StreamJsonParser
        UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, objectCodec, null, null, 0, 0, true);
        
        // Set up the mocks
        when(ioContext.isResourceManaged()).thenReturn(true);
        when(parser.isEnabled(UTF8StreamJsonParser.Feature.AUTO_CLOSE_SOURCE)).thenReturn(true);
        
        // Act
        try {
            Method closeInputMethod = UTF8StreamJsonParser.class.getDeclaredMethod("_closeInput");
            closeInputMethod.setAccessible(true);
            closeInputMethod.invoke(parser);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            verify(inputStream).close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}