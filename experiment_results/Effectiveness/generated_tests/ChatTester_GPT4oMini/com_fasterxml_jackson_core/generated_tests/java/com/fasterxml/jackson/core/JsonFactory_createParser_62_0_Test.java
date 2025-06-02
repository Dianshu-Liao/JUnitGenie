// Test method
package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import com.fasterxml.jackson.core.JsonParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_62_0_Test {

    private JsonFactory jsonFactory;

    private DataInput mockDataInput;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        mockDataInput = mock(DataInput.class);
    }

    @Test
    public void testCreateParser() throws Exception {
        // Prepare the context and expected behavior
        IOContext mockIOContext = mock(IOContext.class);
        Method createContextMethod = JsonFactory.class.getDeclaredMethod("_createContext", Object.class, boolean.class);
        createContextMethod.setAccessible(true);
        when(createContextMethod.invoke(jsonFactory, any(), eq(false))).thenReturn(mockIOContext);
        DataInput decoratedInput = mock(DataInput.class);
        Method decorateMethod = JsonFactory.class.getDeclaredMethod("_decorate", DataInput.class, IOContext.class);
        decorateMethod.setAccessible(true);
        when(decorateMethod.invoke(jsonFactory, mockDataInput, mockIOContext)).thenReturn(decoratedInput);
        JsonParser mockJsonParser = mock(JsonParser.class);
        Method createParserMethod = JsonFactory.class.getDeclaredMethod("_createParser", DataInput.class, IOContext.class);
        createParserMethod.setAccessible(true);
        when(createParserMethod.invoke(jsonFactory, decoratedInput, mockIOContext)).thenReturn(mockJsonParser);
        // Invoke the focal method using reflection
        JsonParser result = (JsonParser) jsonFactory.getClass().getDeclaredMethod("createParser", DataInput.class).invoke(jsonFactory, mockDataInput);
        // Verify the interactions and result
        assertNotNull(result);
        verify(jsonFactory, times(1))._createContext(any(), eq(false));
        verify(jsonFactory, times(1))._decorate(mockDataInput, mockIOContext);
        verify(jsonFactory, times(1))._createParser(decoratedInput, mockIOContext);
    }

    @Test
    public void testCreateParserThrowsIOException() throws Exception {
        // Prepare the exception scenario
        Method createContextMethod = JsonFactory.class.getDeclaredMethod("_createContext", Object.class, boolean.class);
        createContextMethod.setAccessible(true);
        when(createContextMethod.invoke(jsonFactory, any(), eq(false))).thenThrow(new IOException("Mocked IOException"));
        // Assert that the exception is thrown
        assertThrows(IOException.class, () -> {
            jsonFactory.getClass().getDeclaredMethod("createParser", DataInput.class).invoke(jsonFactory, mockDataInput);
        });
    }
}
