package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamReader;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class Stax2JacksonReaderAdapter_wrapIfNecessary_0_2_Test {

    @Test
    public void testWrapIfNecessary_WithXMLStreamReader2() {
        // Arrange
        XMLStreamReader2 mockXmlStreamReader2 = mock(XMLStreamReader2.class);
        // Act
        XMLStreamReader2 result = Stax2JacksonReaderAdapter.wrapIfNecessary(mockXmlStreamReader2);
        // Assert
        assertEquals(mockXmlStreamReader2, result);
    }

    @Test
    public void testWrapIfNecessary_WithNonXMLStreamReader2() throws Exception {
        // Arrange
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        // Use reflection to access the private constructor of Stax2JacksonReaderAdapter
        Constructor<Stax2JacksonReaderAdapter> constructor = Stax2JacksonReaderAdapter.class.getDeclaredConstructor(XMLStreamReader.class);
        constructor.setAccessible(true);
        // Act
        Stax2JacksonReaderAdapter result = (Stax2JacksonReaderAdapter) Stax2JacksonReaderAdapter.wrapIfNecessary(mockXmlStreamReader);
        // Assert
        assertTrue(result instanceof Stax2JacksonReaderAdapter);
    }
}
