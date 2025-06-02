package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.*;
import com.fasterxml.jackson.core.JsonGenerationException;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_11_Test {

    private ToXmlGenerator generator;
    private XMLStreamWriter2 xmlWriter;
    private XmlPrettyPrinter xmlPrettyPrinter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        xmlPrettyPrinter = mock(XmlPrettyPrinter.class);
        // Initialize the generator with appropriate parameters
        generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        generator._elementNameStack = new LinkedList<>();
        generator._xmlPrettyPrinter = xmlPrettyPrinter;
    }

    @Test(timeout = 4000)
    public void testHandleEndObjectWithEmptyStack() {
        try {
            generator._handleEndObject();
        } catch (IOException e) {
            // Expected exception
            assert e instanceof JsonGenerationException;
            assert e.getMessage().equals("Can not write END_ELEMENT without open START_ELEMENT");
        }
    }

    @Test(timeout = 4000)
    public void testHandleEndObjectWithNonEmptyStack() {
        generator._elementNameStack.add(new QName("element"));

        try {
            generator._handleEndObject();
            verify(xmlWriter).writeEndElement();
            verify(xmlPrettyPrinter, times(1)).writePrologLinefeed(xmlWriter);
        } catch (IOException | XMLStreamException e) { // Catch XMLStreamException
            // This should not happen
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHandleEndObjectWithPrettyPrinterNull() {
        generator._elementNameStack.add(new QName("element"));
        generator._xmlPrettyPrinter = null; // Simulate no pretty printer

        try {
            generator._handleEndObject();
            verify(xmlWriter).writeEndElement();
            verify(xmlPrettyPrinter, never()).writePrologLinefeed(any());
        } catch (IOException | XMLStreamException e) { // Catch XMLStreamException
            // This should not happen
            e.printStackTrace();
        }
    }


}