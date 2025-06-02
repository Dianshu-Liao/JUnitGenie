package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.JsonLocation;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

class XmlTokenStream__extractLocation_27_1_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 mockXmlReader;

    private XMLStreamLocation2 mockLocation;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        mockXmlReader = mock(XMLStreamReader2.class);
        mockLocation = mock(XMLStreamLocation2.class);
        // Create an instance of XmlTokenStream
        xmlTokenStream = new XmlTokenStream(mockXmlReader, null, 0, null);
    }

    @Test
    void testExtractLocation_NullLocation() throws Exception {
        // Invoke the private method using reflection
        JsonLocation result = invokeExtractLocationMethod(null);
        // Assert the result
        assertNotNull(result);
        assertEquals(-1, result.getCharOffset());
        assertEquals(-1, result.getLineNr());
        assertEquals(-1, result.getColumnNr());
    }

    @Test
    void testExtractLocation_ValidLocation() throws Exception {
        // Prepare mock location
        when(mockLocation.getCharacterOffset()).thenReturn(100);
        when(mockLocation.getLineNumber()).thenReturn(10);
        when(mockLocation.getColumnNumber()).thenReturn(5);
        // Invoke the private method using reflection
        JsonLocation result = invokeExtractLocationMethod(mockLocation);
        // Assert the result
        assertNotNull(result);
        assertEquals(100, result.getCharOffset());
        assertEquals(10, result.getLineNr());
        assertEquals(5, result.getColumnNr());
    }

    private JsonLocation invokeExtractLocationMethod(XMLStreamLocation2 location) throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_extractLocation", XMLStreamLocation2.class);
        method.setAccessible(true);
        return (JsonLocation) method.invoke(xmlTokenStream, location);
    }
}
