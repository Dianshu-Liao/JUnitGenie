package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getTextLength_33_0_Test {

    private FromXmlParser fromXmlParser;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlReader;

    private XmlNameProcessor tagProcessor;

    @BeforeEach
    public void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        tagProcessor = mock(XmlNameProcessor.class);
        // Assuming the constructor requires these parameters
        fromXmlParser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, tagProcessor);
    }

    @Test
    public void testGetTextLength_WithNullText() throws Exception {
        // Reflection to set the private field _currText to null
        setPrivateField(fromXmlParser, "_currText", null);
        int length = fromXmlParser.getTextLength();
        assertEquals(0, length);
    }

    @Test
    public void testGetTextLength_WithEmptyText() throws Exception {
        // Reflection to set the private field _currText to an empty string
        setPrivateField(fromXmlParser, "_currText", "");
        int length = fromXmlParser.getTextLength();
        assertEquals(0, length);
    }

    @Test
    public void testGetTextLength_WithNonEmptyText() throws Exception {
        // Reflection to set the private field _currText to a non-empty string
        setPrivateField(fromXmlParser, "_currText", "Hello, World!");
        int length = fromXmlParser.getTextLength();
        assertEquals(13, length);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
