package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class ser_ToXmlGenerator_close__cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException { // Declare exceptions
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(any(JsonGenerator.Feature.class))).thenReturn(true); // Use any() for stubbing
        when(ioContext.isResourceManaged()).thenReturn(true); // Corrected access to ioContext

        // Act
        generator.close(); // No need for try-catch here since we declared exceptions

        // Assert
        verify(xmlWriter).close(); // Corrected to use close() instead of closeCompletely()
    }



}
