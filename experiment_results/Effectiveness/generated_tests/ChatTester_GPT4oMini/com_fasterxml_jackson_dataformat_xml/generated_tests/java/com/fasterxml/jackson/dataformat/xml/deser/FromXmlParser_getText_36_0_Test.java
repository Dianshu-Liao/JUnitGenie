package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import java.io.StringWriter;
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
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getText_36_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlReader;

    private XmlNameProcessor tagProcessor;

    @BeforeEach
    public void setUp() throws IOException {
        ioContext = Mockito.mock(IOContext.class);
        objectCodec = Mockito.mock(ObjectCodec.class);
        xmlReader = Mockito.mock(XMLStreamReader.class);
        tagProcessor = Mockito.mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, tagProcessor);
    }

    @Test
    public void testGetText_WriterNotNull() throws IOException {
        StringWriter writer = new StringWriter();
        // Using reflection to set the current text to a known value
        setField(parser, "_currText", "Hello, World!");
        int length = parser.getText(writer);
        assertEquals("Hello, World!", writer.toString());
        assertEquals(13, length);
    }

    @Test
    public void testGetText_NullText() throws IOException {
        StringWriter writer = new StringWriter();
        // Using reflection to set the current text to null
        setField(parser, "_currText", null);
        int length = parser.getText(writer);
        assertEquals("", writer.toString());
        assertEquals(0, length);
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
