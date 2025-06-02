package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import com.fasterxml.jackson.core.*;

public class XmlFactory__createParser_40_0_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
    }

    @Test
    public void testCreateParser_WithValidReader_ShouldReturnFromXmlParser() throws Exception {
        // Arrange
        String xmlInput = "<root></root>";
        Reader reader = new StringReader(xmlInput);
        IOContext context = mock(IOContext.class);
        // Mocking XMLInputFactory and its methods
        XMLInputFactory xmlInputFactory = mock(XMLInputFactory.class);
        XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
        when(xmlInputFactory.createXMLStreamReader(reader)).thenReturn(xmlStreamReader);
        when(xmlStreamReader.next()).thenReturn(XMLStreamConstants.START_ELEMENT);
        // Set the mock XMLInputFactory to the XmlFactory
        setField(xmlFactory, "_xmlInputFactory", xmlInputFactory);
        // Act
        FromXmlParser parser = invokeCreateParser(xmlFactory, reader, context);
        // Assert
        assertNotNull(parser);
        // Use the getter method to retrieve the XML text element name
        assertEquals(xmlFactory.getXMLTextElementName(), getField(parser, "_cfgNameForTextElement"));
    }

    @Test
    public void testCreateParser_WithXMLStreamException_ShouldThrowJsonParseException() throws Exception {
        // Arrange
        String xmlInput = "<root></root>";
        Reader reader = new StringReader(xmlInput);
        IOContext context = mock(IOContext.class);
        // Mocking XMLInputFactory and its methods
        XMLInputFactory xmlInputFactory = mock(XMLInputFactory.class);
        when(xmlInputFactory.createXMLStreamReader(reader)).thenThrow(new XMLStreamException("Error"));
        // Set the mock XMLInputFactory to the XmlFactory
        setField(xmlFactory, "_xmlInputFactory", xmlInputFactory);
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            invokeCreateParser(xmlFactory, reader, context);
        });
    }

    private FromXmlParser invokeCreateParser(XmlFactory xmlFactory, Reader reader, IOContext context) throws Exception {
        return (FromXmlParser) invokePrivateMethod(xmlFactory, "_createParser", new Class[] { Reader.class, IOContext.class }, reader, context);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private Object invokePrivateMethod(Object target, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        java.lang.reflect.Method method = target.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(target, args);
    }

    private Object getField(Object target, String fieldName) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }
}
