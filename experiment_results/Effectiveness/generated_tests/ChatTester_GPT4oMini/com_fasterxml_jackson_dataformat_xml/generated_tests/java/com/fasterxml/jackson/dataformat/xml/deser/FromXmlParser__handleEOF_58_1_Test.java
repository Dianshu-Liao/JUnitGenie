// Test method
package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
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

public class FromXmlParser__handleEOF_58_1_Test {

    private FromXmlParser parser;

    private IOContext mockIOContext;

    private XMLStreamReader mockXmlReader;

    private XmlReadContext mockParsingContext;

    @BeforeEach
    public void setUp() throws Exception {
        mockIOContext = mock(IOContext.class);
        mockXmlReader = mock(XMLStreamReader.class);
        mockParsingContext = mock(XmlReadContext.class);
        parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXmlReader, null);
        // Set the parsing context to the mock instance
        // Use reflection to set the protected field _parsingContext
        java.lang.reflect.Field parsingContextField = FromXmlParser.class.getDeclaredField("_parsingContext");
        parsingContextField.setAccessible(true);
        parsingContextField.set(parser, mockParsingContext);
    }

    @Test
    public void testHandleEOF_ThrowsJsonParseException_WhenNotInRoot() {
        when(mockParsingContext.inRoot()).thenReturn(false);
        when(mockParsingContext.inArray()).thenReturn(false);
        when(mockParsingContext.startLocation(mockIOContext.contentReference())).thenReturn(new JsonLocation("", 0, 0, 0));
        Exception exception = assertThrows(JsonParseException.class, () -> {
            // Use reflection to invoke the protected method _handleEOF
            java.lang.reflect.Method handleEOFMethod = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            handleEOFMethod.setAccessible(true);
            handleEOFMethod.invoke(parser);
        });
        String expectedMessage = ": expected close marker for Object (start marker at location)";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testHandleEOF_ThrowsJsonParseException_WhenInArray() {
        when(mockParsingContext.inRoot()).thenReturn(false);
        when(mockParsingContext.inArray()).thenReturn(true);
        when(mockParsingContext.startLocation(mockIOContext.contentReference())).thenReturn(new JsonLocation("", 0, 0, 0));
        Exception exception = assertThrows(JsonParseException.class, () -> {
            // Use reflection to invoke the protected method _handleEOF
            java.lang.reflect.Method handleEOFMethod = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            handleEOFMethod.setAccessible(true);
            handleEOFMethod.invoke(parser);
        });
        String expectedMessage = ": expected close marker for Array (start marker at location)";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testHandleEOF_DoesNotThrow_WhenInRoot() {
        when(mockParsingContext.inRoot()).thenReturn(true);
        assertDoesNotThrow(() -> {
            // Use reflection to invoke the protected method _handleEOF
            java.lang.reflect.Method handleEOFMethod = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            handleEOFMethod.setAccessible(true);
            handleEOFMethod.invoke(parser);
        });
    }
}
