package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import javax.xml.namespace.QName;
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
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeFieldName_24_0_Test {

    private ToXmlGenerator toXmlGenerator;

    @Mock
    private XMLStreamWriter xmlStreamWriter;

    @Mock
    private SerializableString serializableString;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlStreamWriter, null);
    }

    @Test
    public void testWriteFieldName_ValidName() throws IOException {
        String fieldName = "testField";
        when(serializableString.getValue()).thenReturn(fieldName);
        toXmlGenerator.writeFieldName(serializableString);
        // Verify that writeFieldName(String) is called with the correct argument
        verify(toXmlGenerator, times(1)).writeFieldName(fieldName);
    }

    @Test
    public void testWriteFieldName_EmptyName() throws IOException {
        String fieldName = "";
        when(serializableString.getValue()).thenReturn(fieldName);
        toXmlGenerator.writeFieldName(serializableString);
        // Verify that writeFieldName(String) is called with the correct argument
        verify(toXmlGenerator, times(1)).writeFieldName(fieldName);
    }

    @Test
    public void testWriteFieldName_NullName() throws IOException {
        when(serializableString.getValue()).thenReturn(null);
        assertThrows(IOException.class, () -> {
            toXmlGenerator.writeFieldName(serializableString);
        });
    }

    @Test
    public void testWriteFieldName_SpecialCharacters() throws IOException {
        String fieldName = "testField&<>";
        when(serializableString.getValue()).thenReturn(fieldName);
        toXmlGenerator.writeFieldName(serializableString);
        // Verify that writeFieldName(String) is called with the correct argument
        verify(toXmlGenerator, times(1)).writeFieldName(fieldName);
    }

    @Test
    public void testWriteFieldName_WhitespaceName() throws IOException {
        String fieldName = "   ";
        when(serializableString.getValue()).thenReturn(fieldName);
        toXmlGenerator.writeFieldName(serializableString);
        // Verify that writeFieldName(String) is called with the correct argument
        verify(toXmlGenerator, times(1)).writeFieldName(fieldName);
    }
}
