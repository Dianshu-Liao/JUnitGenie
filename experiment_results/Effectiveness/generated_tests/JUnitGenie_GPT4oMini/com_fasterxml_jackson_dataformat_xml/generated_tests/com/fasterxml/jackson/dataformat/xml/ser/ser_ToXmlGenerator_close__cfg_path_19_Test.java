package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator_close__cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testCloseWithAutoCloseJsonContentEnabled() throws XMLStreamException {
        // Arrange
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        IOContext ioContext = mock(IOContext.class);
        XmlNameProcessor nameProcessor = mock(XmlNameProcessor.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, nameProcessor);
        
        // Mocking the behavior of isClosed and isEnabled methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Act
        try {
            generator.close();
        } catch (JsonGenerationException e) { // Catching JsonGenerationException separately
            e.printStackTrace();
        } catch (IOException e) { // Catching IOException separately
            e.printStackTrace();
        }

        // Assert
        verify(xmlWriter, times(1)).close();
    }

}