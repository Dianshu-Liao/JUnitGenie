// Test method
package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class FromXmlParser_getTextCharacters_32_1_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlReader;

    private XmlNameProcessor tagProcessor;

    @BeforeEach
    public void setUp() {
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        tagProcessor = mock(XmlNameProcessor.class);
        // Fixed the buggy line by handling IOException
        try {
            parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, tagProcessor);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    public void testGetTextCharacters_NullText() throws Exception {
        // Mock the private getText method to return null
        setPrivateField(parser, "_currText", null);
        // Call the method under test
        char[] result = parser.getTextCharacters();
        // Verify the result
        assertNull(result);
    }

    @Test
    public void testGetTextCharacters_EmptyText() throws Exception {
        // Mock the private getText method to return an empty string
        setPrivateField(parser, "_currText", "");
        // Call the method under test
        char[] result = parser.getTextCharacters();
        // Verify the result
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testGetTextCharacters_ValidText() throws Exception {
        // Mock the private getText method to return a valid string
        String expectedText = "Hello";
        setPrivateField(parser, "_currText", expectedText);
        // Call the method under test
        char[] result = parser.getTextCharacters();
        // Verify the result
        assertNotNull(result);
        assertArrayEquals(expectedText.toCharArray(), result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
