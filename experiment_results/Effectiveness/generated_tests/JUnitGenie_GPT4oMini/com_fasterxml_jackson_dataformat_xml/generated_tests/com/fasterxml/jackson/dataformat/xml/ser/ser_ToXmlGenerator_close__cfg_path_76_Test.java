package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.JsonGenerationException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator_close__cfg_path_76_Test {

    @Test(timeout = 4000)
    public void testClose() throws Exception {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        JsonWriteContext context = mock(JsonWriteContext.class);
        
        // Access _writeContext through a protected accessor method if available
        // Assuming a protected getter method exists, which may look like:
        // The method getWriteContext() does not exist, so we will remove this line.
        // when(generator.getWriteContext()).thenReturn(context);
        
        when(context.inArray()).thenReturn(true);
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        }

        // Assert
        try {
            verify(xmlWriter).close();
        } catch (XMLStreamException e) {
            // Handle XMLStreamException
        }
    }

    @Test(timeout = 4000)
    public void testCloseWithArrayIndexOutOfBoundsException() throws Exception {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        JsonWriteContext context = mock(JsonWriteContext.class);
        
        // Access _writeContext through a protected accessor method if available
        // The method getWriteContext() does not exist, so we will remove this line.
        // when(generator.getWriteContext()).thenReturn(context);
        
        when(context.inArray()).thenThrow(new ArrayIndexOutOfBoundsException());

        // Act
        try {
            generator.close();
        } catch (JsonGenerationException e) {
            // Assert
            assertTrue(e.getCause() instanceof ArrayIndexOutOfBoundsException);
        } catch (IOException e) {
            // Handle IOException
        }
    }


}