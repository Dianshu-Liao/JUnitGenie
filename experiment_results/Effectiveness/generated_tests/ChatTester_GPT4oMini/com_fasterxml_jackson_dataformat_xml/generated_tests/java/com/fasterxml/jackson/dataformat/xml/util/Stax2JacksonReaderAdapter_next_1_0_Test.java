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

    private XMLStreamReader mockXMLStreamReader;

    private Stax2JacksonReaderAdapter adapter;

    @BeforeEach
    public void setUp() {
        mockXMLStreamReader = mock(XMLStreamReader.class);
        adapter = new Stax2JacksonReaderAdapter(mockXMLStreamReader);
    }

    @Test
    public void testNextSuccessful() throws Exception {
        // Arrange
        when(mockXMLStreamReader.next()).thenReturn(1);
        // Act
        int result = adapter.next();
        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testNextThrowsIllegalStateException() throws Exception {
        // Arrange
        when(mockXMLStreamReader.next()).thenThrow(new ArrayIndexOutOfBoundsException("Index out of bounds"));
        // Act & Assert
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            adapter.next();
        });
        assertTrue(thrown.getMessage().contains("Internal processing error by `XMLStreamReader`"));
        assertTrue(thrown.getMessage().contains("consider using Woodstox instead"));
    }
}
