package com.fasterxml.jackson.dataformat.xml;

import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactory_createParser_32_1_Test {

    private XmlFactory xmlFactory;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
    }

    @Test
    public void testCreateParser_ValidXml() throws Exception {
        String xmlContent = "<root><element>value</element></root>";
        JsonParser parser = invokeCreateParser(xmlContent);
        assertNotNull(parser);
        // Close parser to free resources
        parser.close();
    }

    @Test
    public void testCreateParser_EmptyString() throws Exception {
        String xmlContent = "";
        JsonParser parser = invokeCreateParser(xmlContent);
        assertNotNull(parser);
        // Close parser to free resources
        parser.close();
    }

    @Test
    public void testCreateParser_NullContent() {
        assertThrows(IOException.class, () -> {
            invokeCreateParser(null);
        });
    }

    @Test
    public void testCreateParser_InvalidXml() {
        String xmlContent = "<root><element>value</element>";
        assertThrows(IOException.class, () -> {
            invokeCreateParser(xmlContent);
        });
    }

    @Test
    public void testCreateParser_WithDecorator() throws Exception {
        String xmlContent = "<root><element>value</element></root>";
        xmlFactory.setXmlNameProcessor(XmlNameProcessors.newPassthroughProcessor());
        JsonParser parser = invokeCreateParser(xmlContent);
        assertNotNull(parser);
        // Close parser to free resources
        parser.close();
    }

    private JsonParser invokeCreateParser(String content) throws Exception {
        Method method = XmlFactory.class.getDeclaredMethod("createParser", String.class);
        method.setAccessible(true);
        return (JsonParser) method.invoke(xmlFactory, content);
    }
}
