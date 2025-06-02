package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class ser_ToXmlGenerator_finishWrappedValue_QName_QName_cfg_path_10_Test {


    @Test(timeout = 4000)
    public void testFinishWrappedValue_WithoutPrettyPrinter() {
        // Arrange
        XMLStreamWriter2 mockWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);
        QName wrapperName = new QName("wrapper");
        QName wrappedName = new QName("wrapped");
        generator._xmlPrettyPrinter = null;

        // Act
        try {
            generator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        try {
            verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle exception if necessary
        }
    }


    // Added a mock class for XmlPrettyPrinter to resolve the missing symbol error
    private static class XmlPrettyPrinter {
        public void writeEndElement(XMLStreamWriter2 writer, int entryCount) throws XMLStreamException {
            // Mock implementation
        }
    }


}
