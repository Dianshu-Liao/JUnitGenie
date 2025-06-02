package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import org.junit.Test;
import javax.xml.stream.XMLStreamReader;
import java.lang.reflect.Method;
import static org.mockito.Mockito.*;
import static org.junit.Assert.fail;
import com.fasterxml.jackson.core.JsonLocation;

public class deser_FromXmlParser__handleEOF__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHandleEOF_WhenInRoot_ShouldNotReportInvalidEOF() {
        try {
            // Arrange
            IOContext ioContext = mock(IOContext.class);
            XmlNameProcessor xmlNameProcessor = mock(XmlNameProcessor.class);
            XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
            FromXmlParser parser = new FromXmlParser(ioContext, 0, 0, null, xmlStreamReader, xmlNameProcessor);
            XmlReadContext mockContext = mock(XmlReadContext.class);
            Method setParsingContextMethod = FromXmlParser.class.getDeclaredMethod("setParsingContext", XmlReadContext.class);
            setParsingContextMethod.setAccessible(true);
            setParsingContextMethod.invoke(parser, mockContext);

            when(mockContext.inRoot()).thenReturn(true);

            // Act
            Method handleEOFMethod = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            handleEOFMethod.setAccessible(true);
            handleEOFMethod.invoke(parser);
        } catch (JsonParseException e) {
            fail("JsonParseException should not be thrown when in root context.");
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testHandleEOF_WhenNotInRootAndInArray_ShouldReportInvalidEOF() {
        try {
            // Arrange
            IOContext ioContext = mock(IOContext.class);
            XmlNameProcessor xmlNameProcessor = mock(XmlNameProcessor.class);
            XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
            FromXmlParser parser = new FromXmlParser(ioContext, 0, 0, null, xmlStreamReader, xmlNameProcessor);
            XmlReadContext mockContext = mock(XmlReadContext.class);
            Method setParsingContextMethod = FromXmlParser.class.getDeclaredMethod("setParsingContext", XmlReadContext.class);
            setParsingContextMethod.setAccessible(true);
            setParsingContextMethod.invoke(parser, mockContext);

            when(mockContext.inRoot()).thenReturn(false);
            when(mockContext.inArray()).thenReturn(true);
            when(mockContext.startLocation(any())).thenReturn(mock(JsonLocation.class));

            // Act
            Method handleEOFMethod = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            handleEOFMethod.setAccessible(true);
            handleEOFMethod.invoke(parser);
        } catch (JsonParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testHandleEOF_WhenNotInRootAndNotInArray_ShouldReportInvalidEOF() {
        try {
            // Arrange
            IOContext ioContext = mock(IOContext.class);
            XmlNameProcessor xmlNameProcessor = mock(XmlNameProcessor.class);
            XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
            FromXmlParser parser = new FromXmlParser(ioContext, 0, 0, null, xmlStreamReader, xmlNameProcessor);
            XmlReadContext mockContext = mock(XmlReadContext.class);
            Method setParsingContextMethod = FromXmlParser.class.getDeclaredMethod("setParsingContext", XmlReadContext.class);
            setParsingContextMethod.setAccessible(true);
            setParsingContextMethod.invoke(parser, mockContext);

            when(mockContext.inRoot()).thenReturn(false);
            when(mockContext.inArray()).thenReturn(false);
            when(mockContext.startLocation(any())).thenReturn(mock(JsonLocation.class));

            // Act
            Method handleEOFMethod = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            handleEOFMethod.setAccessible(true);
            handleEOFMethod.invoke(parser);
        } catch (JsonParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }


}