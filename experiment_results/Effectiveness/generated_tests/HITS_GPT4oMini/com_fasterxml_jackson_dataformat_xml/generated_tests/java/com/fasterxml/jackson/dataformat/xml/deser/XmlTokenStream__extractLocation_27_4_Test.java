package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

@ExtendWith(MockitoExtension.class)
public class XmlTokenStream__extractLocation_27_4_Test {

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() {
        XMLStreamReader2 mockReader = mock(XMLStreamReader2.class);
        ContentReference mockContentRef = mock(ContentReference.class);
        XmlNameProcessor mockNameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(mockReader, mockContentRef, 0, mockNameProcessor);
    }

    @Test
    public void testExtractLocation_NullLocation() throws Exception {
        XMLStreamLocation2 location = null;
        JsonLocation result = invokeExtractLocation(location);
        assertNotNull(result);
        assertEquals(-1, result.getCharOffset());
        assertEquals(-1, result.getLineNr());
        assertEquals(-1, result.getColumnNr());
    }

    @Test
    public void testExtractLocation_ValidLocation() throws Exception {
        XMLStreamLocation2 location = Mockito.mock(XMLStreamLocation2.class);
        Mockito.when(location.getCharacterOffset()).thenReturn(100);
        Mockito.when(location.getLineNumber()).thenReturn(5);
        Mockito.when(location.getColumnNumber()).thenReturn(10);
        JsonLocation result = invokeExtractLocation(location);
        assertNotNull(result);
        assertEquals(100, result.getCharOffset());
        assertEquals(5, result.getLineNr());
        assertEquals(10, result.getColumnNr());
    }

    private JsonLocation invokeExtractLocation(XMLStreamLocation2 location) throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("_extractLocation", XMLStreamLocation2.class);
        method.setAccessible(true);
        return (JsonLocation) method.invoke(xmlTokenStream, location);
    }
}
