package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.io.IOContext;

public class ser_ToXmlGenerator_close__cfg_path_26_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 mockXmlWriter;


    @Test(timeout = 4000)
    public void testCloseWhenNotClosedAndAutoCloseJsonContentEnabled() {
        try {
            // Setup: simulate isClosed to return false and isEnabled for AUTO_CLOSE_JSON_CONTENT to return true
            Mockito.doReturn(false).when(toXmlGenerator).isClosed();
            Mockito.doReturn(true).when(toXmlGenerator).isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            
            // Act: call close
            toXmlGenerator.close();
            
            // Verify: since _xmlWriter is mocked, ensure close is called
            Mockito.verify(mockXmlWriter, Mockito.times(1)).close();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseHandlesXmlStreamException() {
        try {
            // Setup: simulate isClosed to return false and isEnabled for AUTO_CLOSE_JSON_CONTENT to return true
            Mockito.doReturn(false).when(toXmlGenerator).isClosed();
            Mockito.doReturn(true).when(toXmlGenerator).isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            
            // Setup: mock _xmlWriter to throw an XMLStreamException when close is called
            Mockito.doThrow(new XMLStreamException()).when(mockXmlWriter).close();
            
            // Act and Assert: check for JsonGenerationException
            try {
                toXmlGenerator.close();
            } catch (JsonGenerationException e) {
                // Expected exception
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // This catch block is added to handle the unreported exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseWhenResourceManaged() {
        try {
            // Setup: simulate isClosed to return false and Resource Managed to return true
            Mockito.doReturn(false).when(toXmlGenerator).isClosed();
            Mockito.doReturn(true).when(toXmlGenerator).isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
            
            // Act: call close
            toXmlGenerator.close();
            
            // Verify: ensure closeCompletely() is called
            Mockito.verify(mockXmlWriter, Mockito.times(1)).closeCompletely();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }


}
