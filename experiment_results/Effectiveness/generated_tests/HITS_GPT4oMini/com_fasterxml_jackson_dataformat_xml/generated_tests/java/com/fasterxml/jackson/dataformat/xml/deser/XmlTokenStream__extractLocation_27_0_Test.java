package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import org.codehaus.stax2.XMLStreamLocation2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import java.io.IOException;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamReader2;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

public class XmlTokenStream__extractLocation_27_0_Test {

    private XmlTokenStream xmlTokenStream;

    private ContentReference mockContentReference;

    private XMLStreamReader mockXmlStreamReader;

    private XmlNameProcessor mockXmlNameProcessor;

    @BeforeEach
    public void setUp() {
        mockContentReference = mock(ContentReference.class);
        mockXmlStreamReader = mock(XMLStreamReader.class);
        mockXmlNameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(mockXmlStreamReader, mockContentReference, 0, mockXmlNameProcessor);
    }

    @Test
    public void testExtractLocation_NullLocation() {
        // Arrange
        XMLStreamLocation2 nullLocation = null;
        // Act
        JsonLocation result = invokeExtractLocation(xmlTokenStream, nullLocation);
        // Assert
        assertEquals(-1, result.getCharOffset());
        assertEquals(-1, result.getLineNr());
        assertEquals(mockContentReference, result.getSourceRef());
    }

    private JsonLocation invokeExtractLocation(XmlTokenStream xmlTokenStream, XMLStreamLocation2 location) {
        try {
            java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_extractLocation", XMLStreamLocation2.class);
            method.setAccessible(true);
            return (JsonLocation) method.invoke(xmlTokenStream, location);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
