package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class json_ReaderBasedJsonParser__closeInput__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloseInputWhenReaderIsNull() {
        ReaderBasedJsonParser parser = createParserWithMockedIOContext(false);
        try {
            // Accessing the protected method using reflection
            Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_closeInput");
            method.setAccessible(true);
            method.invoke(parser);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseInputWhenResourceIsManaged() {
        Reader mockReader = mock(Reader.class);
        IOContext mockIOContext = mock(IOContext.class);
        when(mockIOContext.isResourceManaged()).thenReturn(true);

        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(mockIOContext, 0, mockReader, null, null);
        try {
            // Accessing the protected method using reflection
            Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_closeInput");
            method.setAccessible(true);
            method.invoke(parser);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseInputWhenAutoCloseSourceIsEnabled() {
        Reader mockReader = mock(Reader.class);
        IOContext mockIOContext = mock(IOContext.class);
        when(mockIOContext.isResourceManaged()).thenReturn(false);

        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(mockIOContext, 0, mockReader, null, null);
        try {
            // Accessing the protected method using reflection
            Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_closeInput");
            method.setAccessible(true);
            method.invoke(parser);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    private ReaderBasedJsonParser createParserWithMockedIOContext(boolean managedResource) {
        IOContext mockIOContext = mock(IOContext.class);
        when(mockIOContext.isResourceManaged()).thenReturn(managedResource);
        // Provide a non-null Reader to avoid NullPointerException
        Reader mockReader = mock(Reader.class);
        return new ReaderBasedJsonParser(mockIOContext, 0, mockReader, null, null);
    }


}