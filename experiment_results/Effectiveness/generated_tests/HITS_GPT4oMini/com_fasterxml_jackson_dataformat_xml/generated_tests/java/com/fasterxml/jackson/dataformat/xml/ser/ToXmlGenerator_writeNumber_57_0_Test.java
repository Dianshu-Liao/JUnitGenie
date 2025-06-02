package com.fasterxml.jackson.dataformat.xml.ser;

import java.math.BigDecimal;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeNumber_57_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter mockXmlWriter;

    @BeforeEach
    public void setUp() {
        mockXmlWriter = mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
    }

    @Test
    public void testWriteNumber_NullInput() throws IOException, XMLStreamException {
        // Arrange
        toXmlGenerator.setNextName(new QName("namespace", "localPart"));
        // Act
        toXmlGenerator.writeNumber((BigDecimal) null);
        // Assert
        verify(mockXmlWriter).writeStartElement("namespace", "localPart");
        verify(mockXmlWriter).writeEndElement();
        verify(mockXmlWriter, never()).writeCharacters(anyString());
    }

    @Test
    public void testWriteNumber_NullInput_WriteNullCalled() throws IOException, XMLStreamException {
        // Arrange
        toXmlGenerator.setNextName(new QName("namespace", "localPart"));
        doNothing().when(mockXmlWriter).writeEmptyElement(anyString(), anyString());
        // Act
        toXmlGenerator.writeNumber((BigDecimal) null);
        // Assert
        verify(mockXmlWriter, times(1)).writeStartElement("namespace", "localPart");
        verify(mockXmlWriter, times(1)).writeEndElement();
    }
}
