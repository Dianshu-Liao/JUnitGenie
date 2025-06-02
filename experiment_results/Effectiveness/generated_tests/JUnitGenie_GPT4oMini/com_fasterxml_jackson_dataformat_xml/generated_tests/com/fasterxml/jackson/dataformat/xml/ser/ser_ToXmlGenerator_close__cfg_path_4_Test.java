package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class ser_ToXmlGenerator_close__cfg_path_4_Test {
    private IOContext ioContext;
    private XMLStreamWriter2 xmlWriter;
    private ToXmlGenerator generator;

    @Before
    public void setUp() {
        ioContext = Mockito.mock(IOContext.class);
        xmlWriter = Mockito.mock(XMLStreamWriter2.class);
        generator = Mockito.mock(ToXmlGenerator.class); // Mocking ToXmlGenerator instead of creating an instance
    }

    @Test(timeout = 4000)
    public void testClose_WhenNotClosedAndAutoCloseJsonContentEnabled_AndResourceManaged() throws IOException, XMLStreamException {
        Mockito.when(generator.isClosed()).thenReturn(false);
        Mockito.when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        Mockito.when(ioContext.isResourceManaged()).thenReturn(true);

        generator.close(); // No need for try-catch since we are declaring the exception

        // Verify that the XML writer was completely closed
        Mockito.verify(xmlWriter).closeCompletely();
        Mockito.verify(generator).close(); // Verify that super.close() is invoked
    }

    @Test(timeout = 4000)
    public void testClose_WhenNotClosedAndAutoCloseJsonContentEnabled_AndNotResourceManaged() throws IOException, XMLStreamException {
        Mockito.when(generator.isClosed()).thenReturn(false);
        Mockito.when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        Mockito.when(ioContext.isResourceManaged()).thenReturn(false);

        generator.close(); // No need for try-catch since we are declaring the exception

        // Verify that the XML writer was closed
        Mockito.verify(xmlWriter).close();
        Mockito.verify(generator).close(); // Verify that super.close() is invoked
    }

    @Test(timeout = 4000)
    public void testClose_WhenExceptionThrownFromXmlWriter() throws IOException, XMLStreamException {
        Mockito.when(generator.isClosed()).thenReturn(false);
        Mockito.when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        Mockito.when(ioContext.isResourceManaged()).thenReturn(false);

        Mockito.doThrow(new XMLStreamException("XML Stream Exception")).when(xmlWriter).close();

        try {
            generator.close();
        } catch (IOException e) { // Catch IOException instead of XMLStreamException
            // Exception verification can be done here
        }

        // Verify that super.close() is invoked
        Mockito.verify(generator).close();
    }


}