package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class deser_FromXmlParser_close__cfg_path_48_Test {

    @Test(timeout = 4000)
    public void testClose() {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokenStream = mock(XmlTokenStream.class);
        XMLStreamReader mockXMLStreamReader = mock(XMLStreamReader.class);
        FromXmlParser parser = null;
        try {
            // Mock the behavior of the XMLStreamReader to point to START_ELEMENT
            when(mockXMLStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
            parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXMLStreamReader, mock(XmlNameProcessor.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Set the _closed field to false
        setClosedField(parser, false);
        
        // Mock the behavior of isResourceManaged
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        
        // Act
        try {
            parser.close();
        } catch (IOException e) { // Catching only IOException
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockXmlTokenStream).closeCompletely();
        } catch (XMLStreamException e) { // Catching the XMLStreamException here
            e.printStackTrace();
        }
    }

    private void setClosedField(FromXmlParser parser, boolean value) {
        try {
            java.lang.reflect.Field field = FromXmlParser.class.getDeclaredField("_closed");
            field.setAccessible(true);
            field.set(parser, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}