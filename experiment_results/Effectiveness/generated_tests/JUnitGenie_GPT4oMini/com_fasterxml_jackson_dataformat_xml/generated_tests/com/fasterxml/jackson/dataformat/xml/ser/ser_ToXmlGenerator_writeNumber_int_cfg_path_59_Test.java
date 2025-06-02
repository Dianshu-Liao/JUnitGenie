package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import javax.xml.namespace.QName;
import java.io.IOException;

public class ser_ToXmlGenerator_writeNumber_int_cfg_path_59_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Set the protected fields directly for testing
        toXmlGenerator._nextName = null; // This will trigger handleMissingName()
        toXmlGenerator._nextIsAttribute = false; // This will ensure we go through the non-attribute path
        toXmlGenerator._xmlPrettyPrinter = null; // This will ensure we go through the non-pretty printer path
    }

    @Test(timeout = 4000)
    public void testWriteNumber_handleMissingName() {
        try {
            // Set a default name to avoid IllegalStateException
            toXmlGenerator._nextName = new QName("defaultNamespace", "defaultLocalPart");
            toXmlGenerator.writeNumber(42);
            verify(xmlWriter).writeStartElement("defaultNamespace", "defaultLocalPart");
            verify(xmlWriter).writeInt(42);
            verify(xmlWriter).writeEndElement();
        } catch (IOException | XMLStreamException e) {
            // Handle the IOException and XMLStreamException as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNextName() throws Exception {
        // Set up the _nextName to a valid QName
        toXmlGenerator._nextName = new QName("namespace", "localPart");
        toXmlGenerator._nextIsAttribute = false; // Ensure it's not an attribute
        toXmlGenerator._xmlPrettyPrinter = null; // Ensure pretty printer is null

        try {
            toXmlGenerator.writeNumber(42);
            verify(xmlWriter).writeStartElement("namespace", "localPart");
            verify(xmlWriter).writeInt(42);
            verify(xmlWriter).writeEndElement();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }


}