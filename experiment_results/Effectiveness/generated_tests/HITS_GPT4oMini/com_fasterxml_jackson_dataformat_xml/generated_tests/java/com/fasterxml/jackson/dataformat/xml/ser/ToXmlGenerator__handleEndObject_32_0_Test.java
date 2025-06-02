package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator__handleEndObject_32_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlStreamWriter;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() throws XMLStreamException {
        MockitoAnnotations.openMocks(this);
        xmlStreamWriter = mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlStreamWriter, null);
        toXmlGenerator._elementNameStack = new LinkedList<>();
    }

    @Test
    public void testHandleEndObject_ThrowsException_WhenElementNameStackIsEmpty() {
        // Arrange
        // The stack is already empty, no additional setup required
        // Act & Assert
        JsonGenerationException exception = assertThrows(JsonGenerationException.class, () -> toXmlGenerator._handleEndObject());
        // Verify
        assertEquals("Can not write END_ELEMENT without open START_ELEMENT", exception.getMessage());
    }

    @Test
    public void testHandleEndObject_Success_WhenElementNameStackIsNotEmpty() throws IOException, XMLStreamException {
        // Arrange
        // Add an element to the stack
        toXmlGenerator._elementNameStack.push(new QName("testElement"));
        // Act
        toXmlGenerator._handleEndObject();
        // Assert
        // Verify that writeEndElement was called
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }
}
