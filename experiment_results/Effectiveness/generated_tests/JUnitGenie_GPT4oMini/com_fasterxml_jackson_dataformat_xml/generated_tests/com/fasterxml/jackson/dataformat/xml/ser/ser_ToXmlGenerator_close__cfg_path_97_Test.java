package com.fasterxml.jackson.dataformat.xml.ser;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.Test;
import org.junit.Before;

public class ser_ToXmlGenerator_close__cfg_path_97_Test {
    
    private ToXmlGenerator generator;
    private XMLStreamWriter xmlWriter;
    private IOContext ioContext;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter.class);
        ioContext = mock(IOContext.class);
        generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        when(ioContext.isResourceManaged()).thenReturn(true);
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
    }





}
