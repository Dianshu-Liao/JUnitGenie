package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonStreamContext;
import org.junit.Test;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class ser_ToXmlGenerator_close__cfg_path_95_Test {

    @Test(timeout = 4000)
    public void testClose() throws Exception {
        // Arrange
        XMLStreamWriter mockXmlWriter = mock(XMLStreamWriter.class);
        IOContext mockIOContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIOContext, 0, 0, null, mockXmlWriter, null);
        
        // Mocking the behavior of isClosed and isEnabled methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Mocking the behavior of _writeContext
        JsonStreamContext mockContext = mock(JsonStreamContext.class);
        // Using reflection to set the protected field _writeContext
        try {
            java.lang.reflect.Field field = ToXmlGenerator.class.getDeclaredField("_writeContext");
            field.setAccessible(true);
            field.set(generator, mockContext);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        when(mockContext.inArray()).thenReturn(true);
        
        // Act
        try {
            generator.close();
        } catch (JsonGenerationException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }

        // Assert
        try {
            // Verify that writeEndArray was called
            verify(generator, times(1)).writeEndArray();
            // Verify that the XML writer was closed
            verify(mockXmlWriter, times(1)).close();
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException
            e.printStackTrace();
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

}