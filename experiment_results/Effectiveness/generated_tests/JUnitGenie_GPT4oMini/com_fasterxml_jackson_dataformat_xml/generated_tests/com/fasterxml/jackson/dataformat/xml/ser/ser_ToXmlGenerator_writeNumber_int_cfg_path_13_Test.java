package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_int_cfg_path_13_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Set up the necessary fields to cover the CFGPath
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        toXmlGenerator._nextIsAttribute = false; // This will ensure checkNextIsUnwrapped() returns false
    }

    @Test(timeout = 4000)
    public void testWriteNumber() {
        int numberToWrite = 42;

        try {
            toXmlGenerator.writeNumber(numberToWrite);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithXMLStreamException() {
        int numberToWrite = 42;

        // Simulate XMLStreamException
        try {
            doThrow(new XMLStreamException("XML error")).when(xmlWriter).writeInt(anyInt());
            toXmlGenerator.writeNumber(numberToWrite); // Call writeNumber here to trigger the exception
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException
            e.printStackTrace();
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

}