package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;
import com.fasterxml.jackson.core.io.IOContext;

public class ser_ToXmlGenerator_close__cfg_path_65_Test {

    @Test(timeout = 4000)
    public void testClose_withAutoCloseJsonContentEnabled() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter mockXmlWriter = mock(XMLStreamWriter.class);
        IOContext mockIoContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIoContext, 0, 0, null, mockXmlWriter, null) {
            @Override
            public boolean isClosed() {
                return false; // Mocking the method directly
            }
        };

        // Mocking the behavior of the generator
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle the exception
        }

        // Assert
        verify(mockXmlWriter).close();
    }

    @Test(timeout = 4000)
    public void testClose_withJsonGenerationException() throws IOException {
        // Arrange
        XMLStreamWriter mockXmlWriter = mock(XMLStreamWriter.class);
        IOContext mockIoContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIoContext, 0, 0, null, mockXmlWriter, null) {
            @Override
            public boolean isClosed() {
                return false; // Mocking the method directly
            }
        };

        // Mocking the behavior of the generator
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Simulating an ArrayIndexOutOfBoundsException
        doThrow(new ArrayIndexOutOfBoundsException()).when(generator).writeEndArray();

        // Act & Assert
        try {
            generator.close();
        } catch (JsonGenerationException e) {
            assertNotNull(e); // Correctly asserting the exception
        } catch (IOException e) {
            // Handle the exception
        }
    }

}