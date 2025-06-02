package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import com.fasterxml.jackson.core.*;

public class XmlFactory_createParser_37_0_Test {

    private XmlFactory xmlFactory;

    private XMLStreamReader mockStreamReader;

    @BeforeEach
    public void setUp() throws XMLStreamException {
        xmlFactory = new XmlFactory();
        mockStreamReader = mock(XMLStreamReader.class);
    }

    @Test
    public void testCreateParser_WhenAtStartElement_ShouldNotInitialize() throws Exception {
        // Arrange
        when(mockStreamReader.getEventType()).thenReturn(XMLStreamConstants.START_ELEMENT);
        // Act
        FromXmlParser parser = xmlFactory.createParser((XMLStreamReader) mockStreamReader);
        // Assert
        assertNotNull(parser);
        // Should not call next() if already at START_ELEMENT
        verify(mockStreamReader, never()).next();
    }

    @Test
    public void testCreateParser_WhenNotAtStartElement_ShouldInitialize() throws Exception {
        // Arrange
        when(mockStreamReader.getEventType()).thenReturn(XMLStreamConstants.CHARACTERS);
        when(mockStreamReader.next()).thenReturn(XMLStreamConstants.START_ELEMENT);
        // Act
        FromXmlParser parser = xmlFactory.createParser((XMLStreamReader) mockStreamReader);
        // Assert
        assertNotNull(parser);
        // Should call next() to find the START_ELEMENT
        verify(mockStreamReader).next();
    }

    @Test
    public void testCreateParser_WhenInitializationThrowsException_ShouldThrowIOException() throws Exception {
        // Arrange
        when(mockStreamReader.getEventType()).thenReturn(XMLStreamConstants.CHARACTERS);
        when(mockStreamReader.next()).thenThrow(new XMLStreamException("Initialization error"));
        // Act & Assert
        assertThrows(IOException.class, () -> {
            xmlFactory.createParser((XMLStreamReader) mockStreamReader);
        });
    }
}
