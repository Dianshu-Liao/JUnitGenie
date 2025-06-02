package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

@ExtendWith(MockitoExtension.class)
class ToXmlGenerator_writeBinary_46_0_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 mockXmlWriter;

    private XMLStreamWriter mockOriginalXmlWriter;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    void setUp() throws Exception {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        mockOriginalXmlWriter = mock(XMLStreamWriter.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        IOContext mockContext = mock(IOContext.class);
        when(mockContext.streamWriteConstraints()).thenReturn(null);
        generator = new ToXmlGenerator(mockContext, 0, 0, null, mockOriginalXmlWriter, mockNameProcessor);
    }

    @Test
    void testWriteBinary_NullData() throws IOException, XMLStreamException {
        generator.writeBinary(Base64Variants.getDefaultVariant(), null, 0, 0);
        verify(mockOriginalXmlWriter, times(1)).writeStartElement(anyString(), anyString());
        verify(mockOriginalXmlWriter, times(1)).writeEndElement();
    }

    @Test
    void testWriteBinary_WithoutNextName() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            generator.writeBinary(Base64Variants.getDefaultVariant(), new byte[] { 1, 2, 3 }, 0, 3);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    void testWriteBinary_WithNextNameAndAttribute() throws Exception {
        generator.setNextName(new QName("namespace", "localPart"));
        generator.setNextIsAttribute(true);
        byte[] data = new byte[] { 1, 2, 3 };
        generator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        verify(mockXmlWriter, times(1)).writeBinaryAttribute(any(), anyString(), anyString(), anyString(), any(byte[].class));
    }

    @Test
    void testWriteBinary_WithNextNameAndUnwrapped() throws Exception {
        generator.setNextName(new QName("namespace", "localPart"));
        generator.setNextIsUnwrapped(true);
        byte[] data = new byte[] { 1, 2, 3 };
        generator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        verify(mockXmlWriter, times(1)).writeBinary(any(), any(byte[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteBinary_WithPrettyPrinter() throws Exception {
        XmlPrettyPrinter mockPrettyPrinter = mock(XmlPrettyPrinter.class);
        generator.setPrettyPrinter(mockPrettyPrinter);
        generator.setNextName(new QName("namespace", "localPart"));
        byte[] data = new byte[] { 1, 2, 3 };
        generator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        verify(mockPrettyPrinter, times(1)).writeLeafElement(any(), anyString(), anyString(), any(), any(byte[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteBinary_WithException() throws Exception {
        generator.setNextName(new QName("namespace", "localPart"));
        byte[] data = new byte[] { 1, 2, 3 };
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlWriter).writeBinary(any(), any(byte[].class), anyInt(), anyInt());
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        });
        assertTrue(exception.getMessage().contains("Test Exception"));
    }
}
