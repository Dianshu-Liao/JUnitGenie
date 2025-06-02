package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class Stax2JacksonReaderAdapter_next_1_0_Test {

    private XMLStreamReader mockXmlStreamReader;

    private Stax2JacksonReaderAdapter adapter;

    @BeforeEach
    public void setUp() {
        mockXmlStreamReader = Mockito.mock(XMLStreamReader.class);
        adapter = new Stax2JacksonReaderAdapter(mockXmlStreamReader);
    }

    @Test
    public void testNext_Success() throws XMLStreamException {
        // Assuming the next method should return an integer (e.g., XMLStreamReader.START_ELEMENT)
        when(mockXmlStreamReader.next()).thenReturn(XMLStreamReader.START_ELEMENT);
        int result = adapter.next();
        assertEquals(XMLStreamReader.START_ELEMENT, result);
    }

    @Test
    public void testNext_ThrowsIllegalStateException() throws XMLStreamException {
        // Simulate an ArrayIndexOutOfBoundsException being thrown
        when(mockXmlStreamReader.next()).thenThrow(new ArrayIndexOutOfBoundsException());
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            adapter.next();
        });
        assertTrue(exception.getMessage().contains("Internal processing error by `XMLStreamReader`"));
    }

    @Test
    public void testNext_ThrowsXMLStreamException() throws XMLStreamException {
        // Simulate an XMLStreamException being thrown
        when(mockXmlStreamReader.next()).thenThrow(new XMLStreamException("XML error"));
        XMLStreamException exception = assertThrows(XMLStreamException.class, () -> {
            adapter.next();
        });
        assertEquals("XML error", exception.getMessage());
    }
}
