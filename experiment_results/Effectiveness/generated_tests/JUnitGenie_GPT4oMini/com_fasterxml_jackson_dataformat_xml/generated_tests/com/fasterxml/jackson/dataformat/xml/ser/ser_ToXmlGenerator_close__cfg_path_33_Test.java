package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.JsonGenerationException;

public class ser_ToXmlGenerator_close__cfg_path_33_Test {
    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;
    private IOContext ioContext;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter.class);
        ioContext = mock(IOContext.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, mock(XmlNameProcessor.class));
    }



}
