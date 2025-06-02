package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class Stax2JacksonReaderAdapter_wrapIfNecessary_0_0_Test {

    @Test
    public void testWrapIfNecessary_WithXMLStreamReader2() {
        // Arrange
        XMLStreamReader2 mockXmlStreamReader2 = Mockito.mock(XMLStreamReader2.class);
        // Act
        XMLStreamReader result = Stax2JacksonReaderAdapter.wrapIfNecessary(mockXmlStreamReader2);
        // Assert
        assertInstanceOf(XMLStreamReader2.class, result);
        assertTrue(result instanceof XMLStreamReader2);
    }

    @Test
    public void testWrapIfNecessary_WithXMLStreamReader() {
        // Arrange
        XMLStreamReader mockXmlStreamReader = Mockito.mock(XMLStreamReader.class);
        // Act
        XMLStreamReader result = Stax2JacksonReaderAdapter.wrapIfNecessary(mockXmlStreamReader);
        // Assert
        assertInstanceOf(Stax2JacksonReaderAdapter.class, result);
    }
}
