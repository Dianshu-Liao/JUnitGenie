package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamReader;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class Stax2JacksonReaderAdapter_wrapIfNecessary_0_1_Test {

    @Test
    public void testWrapIfNecessary_WithXMLStreamReader2() {
        // Arrange
        XMLStreamReader2 mockReader2 = Mockito.mock(XMLStreamReader2.class);
        // Act
        XMLStreamReader2 result = Stax2JacksonReaderAdapter.wrapIfNecessary(mockReader2);
        // Assert
        assertSame(mockReader2, result, "The result should be the same instance as the input.");
    }

    @Test
    public void testWrapIfNecessary_WithXMLStreamReader() {
        // Arrange
        XMLStreamReader mockReader = Mockito.mock(XMLStreamReader.class);
        // Act
        XMLStreamReader2 result = Stax2JacksonReaderAdapter.wrapIfNecessary(mockReader);
        // Assert
        assertNotNull(result, "The result should not be null.");
        assertEquals(Stax2JacksonReaderAdapter.class, result.getClass(), "The result should be an instance of Stax2JacksonReaderAdapter.");
    }
}
