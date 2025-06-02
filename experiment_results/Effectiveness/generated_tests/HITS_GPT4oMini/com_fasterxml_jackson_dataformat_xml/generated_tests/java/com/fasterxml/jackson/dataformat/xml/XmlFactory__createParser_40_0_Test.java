package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.util.BufferRecycler;
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

public class XmlFactory__createParser_40_0_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlFactory = new XmlFactory(xmlInputFactory);
        ioContext = new IOContext(new BufferRecycler(), null, false);
    }

    @Test
    public void testCreateParser_ValidXml() throws IOException {
        String xml = "<root><element>value</element></root>";
        StringReader reader = new StringReader(xml);
        FromXmlParser parser = createParser(reader);
        assertNotNull(parser);
        // Further assertions can be added to verify parser state
    }

    @Test
    public void testCreateParser_EmptyXml() throws IOException {
        String xml = "";
        StringReader reader = new StringReader(xml);
        FromXmlParser parser = createParser(reader);
        assertNotNull(parser);
        // Further assertions can be added to verify parser state
    }

    @Test
    public void testCreateParser_InvalidXml() {
        String xml = "<root><element>value</root>";
        StringReader reader = new StringReader(xml);
        assertThrows(JsonParseException.class, () -> {
            createParser(reader);
        });
    }

    @Test
    public void testCreateParser_NullReader() {
        assertThrows(NullPointerException.class, () -> {
            xmlFactory._createParser((Reader) null, ioContext);
        });
    }

    @Test
    public void testCreateParser_NullContext() throws IOException {
        String xml = "<root><element>value</element></root>";
        StringReader reader = new StringReader(xml);
        FromXmlParser parser = createParser(reader, null);
        assertNotNull(parser);
        // Further assertions can be added to verify parser state
    }

    private FromXmlParser createParser(Reader reader) throws IOException {
        return xmlFactory._createParser(reader, ioContext);
    }

    private FromXmlParser createParser(Reader reader, IOContext context) throws IOException {
        return xmlFactory._createParser(reader, context);
    }
}
