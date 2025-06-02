package com.fasterxml.jackson.dataformat.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.lang.reflect.Method;
// Added import for Field
import java.lang.reflect.Field;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import com.fasterxml.jackson.core.*;

class XmlFactory__createParser_40_2_Test {

    private XmlFactory xmlFactory;

    private XMLInputFactory mockXmlInputFactory;

    private Reader mockReader;

    private IOContext mockIoContext;

    @BeforeEach
    void setUp() {
        mockXmlInputFactory = mock(XMLInputFactory.class);
        xmlFactory = new XmlFactory(mockXmlInputFactory);
        mockReader = mock(Reader.class);
        mockIoContext = mock(IOContext.class);
    }

    @Test
    void testCreateParser_Success() throws Exception {
        // Mock the behavior of XMLStreamReader
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlInputFactory.createXMLStreamReader(mockReader)).thenReturn(mockXmlStreamReader);
        // Mock the initialization of the XMLStreamReader
        XMLStreamReader initializedReader = mock(XMLStreamReader.class);
        when(invokePrivateMethod(xmlFactory, "_initializeXmlReader", mockXmlStreamReader)).thenReturn(initializedReader);
        // Create the parser
        FromXmlParser parser = xmlFactory._createParser(mockReader, mockIoContext);
        // Verify that the parser is created correctly
        assertNotNull(parser);
        // Fixed line: Get _ioContext using reflection
        Field ioContextField = FromXmlParser.class.getDeclaredField("_ioContext");
        ioContextField.setAccessible(true);
        assertEquals(mockIoContext, ioContextField.get(parser));
    }

    @Test
    void testCreateParser_XmlStreamException() throws Exception {
        // Simulate an XMLStreamException being thrown
        when(mockXmlInputFactory.createXMLStreamReader(mockReader)).thenThrow(new XMLStreamException("Error"));
        // Expect an IOException to be thrown when creating the parser
        assertThrows(IOException.class, () -> {
            xmlFactory._createParser(mockReader, mockIoContext);
        });
    }

    @Test
    void testCreateParser_WithTextElementName() throws Exception {
        // Mock the behavior of XMLStreamReader
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlInputFactory.createXMLStreamReader(mockReader)).thenReturn(mockXmlStreamReader);
        // Mock the initialization of the XMLStreamReader
        XMLStreamReader initializedReader = mock(XMLStreamReader.class);
        when(invokePrivateMethod(xmlFactory, "_initializeXmlReader", mockXmlStreamReader)).thenReturn(initializedReader);
        // Set a configuration name for the text element
        String textElementName = "textElement";
        xmlFactory.setXMLTextElementName(textElementName);
        // Create the parser
        FromXmlParser parser = xmlFactory._createParser(mockReader, mockIoContext);
        // Fixed line: Get XMLTextElementName using reflection
        Method getXMLTextElementNameMethod = FromXmlParser.class.getDeclaredMethod("getXMLTextElementName");
        getXMLTextElementNameMethod.setAccessible(true);
        assertEquals(textElementName, getXMLTextElementNameMethod.invoke(parser));
    }

    private Object invokePrivateMethod(Object instance, String methodName, Object... args) throws Exception {
        Method method = instance.getClass().getDeclaredMethod(methodName, getParameterTypes(args));
        method.setAccessible(true);
        return method.invoke(instance, args);
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return Arrays.stream(args).map(arg -> arg.getClass()).toArray(Class[]::new);
    }
}
