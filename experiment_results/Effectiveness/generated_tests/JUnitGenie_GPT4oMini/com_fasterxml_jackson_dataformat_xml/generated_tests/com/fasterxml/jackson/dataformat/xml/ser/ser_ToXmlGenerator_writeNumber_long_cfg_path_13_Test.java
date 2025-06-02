package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_long_cfg_path_13_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;


    @Test(timeout = 4000)
    public void testWriteNumber() {
        long numberToWrite = 12345L;

        try {
            toXmlGenerator.writeNumber(numberToWrite);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithXMLStreamException() throws XMLStreamException {
        long numberToWrite = 12345L;

        // Mock the behavior to throw XMLStreamException
        doThrow(new XMLStreamException("XML error")).when(xmlWriter).writeLong(anyLong());

        try {
            toXmlGenerator.writeNumber(numberToWrite);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

}
