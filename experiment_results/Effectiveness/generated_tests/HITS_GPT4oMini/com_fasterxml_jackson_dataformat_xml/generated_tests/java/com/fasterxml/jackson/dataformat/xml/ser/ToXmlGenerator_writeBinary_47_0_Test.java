package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeBinary_47_0_Test {

    @Mock
    private XMLStreamWriter xmlWriter;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private XmlNameProcessor nameProcessor;

    private ToXmlGenerator generator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        generator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlWriter, nameProcessor);
        generator.setNextName(new QName("example", "data"));
    }

    @Test
    public void testWriteBinary() throws Exception {
        // Arrange
        byte[] binaryData = "test".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(binaryData);
        // Act
        int lengthWritten = generator.writeBinary(Base64Variants.getDefaultVariant(), inputStream, binaryData.length);
        // Assert
        verify(xmlWriter, times(1)).writeStartElement("example", "data");
        verify(xmlWriter, times(1)).writeEndElement();
        assertEquals(binaryData.length, lengthWritten);
    }

    @Test
    public void testWriteBinaryNullInputStream() throws Exception {
        // Act
        int lengthWritten = generator.writeBinary(Base64Variants.getDefaultVariant(), null, 0);
        // Assert
        verify(xmlWriter, times(1)).writeStartElement("example", "data");
        verify(xmlWriter, times(1)).writeEndElement();
        assertEquals(0, lengthWritten);
    }
}
