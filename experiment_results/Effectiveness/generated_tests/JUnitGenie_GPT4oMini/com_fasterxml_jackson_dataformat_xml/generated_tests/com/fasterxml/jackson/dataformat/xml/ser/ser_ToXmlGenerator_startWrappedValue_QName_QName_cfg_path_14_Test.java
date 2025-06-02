package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class ser_ToXmlGenerator_startWrappedValue_QName_QName_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testStartWrappedValueWithoutPrettyPrinter() {
        // Arrange
        XMLStreamWriter2 mockWriter = mock(XMLStreamWriter2.class);
        // Create a mock for the required context (e.g., a JsonGenerator or similar)
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        generator._xmlPrettyPrinter = null;

        // Act
        try {
            generator.startWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockWriter).writeStartElement(wrapperName.getNamespaceURI(), wrapperName.getLocalPart());
            verify(generator).setNextName(wrappedName);
        } catch (XMLStreamException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}