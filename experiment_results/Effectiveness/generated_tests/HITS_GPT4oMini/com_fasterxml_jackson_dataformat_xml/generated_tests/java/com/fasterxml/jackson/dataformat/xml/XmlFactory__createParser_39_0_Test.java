package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactory__createParser_39_0_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = new IOContext(null, null, null, false);
    }

    @Test
    public void testCreateParser_ValidInputStream() throws Exception {
        String xml = "<root></root>";
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        FromXmlParser parser = xmlFactory._createParser(inputStream, ioContext);
        assertNotNull(parser, "Parser should not be null for valid XML input.");
    }

    @Test
    public void testCreateParser_InvalidXMLStreamException() {
        // Simulating an invalid InputStream that will throw IOException
        InputStream inputStream = new InputStream() {

            @Override
            public int read() throws IOException {
                throw new IOException("Simulated IOException");
            }
        };
        assertThrows(JsonParseException.class, () -> {
            xmlFactory._createParser(inputStream, ioContext);
        }, "Expected JsonParseException to be thrown for invalid InputStream.");
    }
}
