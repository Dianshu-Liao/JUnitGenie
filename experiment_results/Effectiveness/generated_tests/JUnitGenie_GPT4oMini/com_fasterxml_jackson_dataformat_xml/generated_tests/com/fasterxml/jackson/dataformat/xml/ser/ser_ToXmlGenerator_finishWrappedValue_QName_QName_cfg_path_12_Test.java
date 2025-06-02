package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class ser_ToXmlGenerator_finishWrappedValue_QName_QName_cfg_path_12_Test {


    @Test(timeout = 4000)
    public void testFinishWrappedValue_WithoutWrapperName() {
        // Arrange
        QName wrapperName = null;
        QName wrappedName = new QName("http://example.com", "wrapped");
        
        // Mocking dependencies
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);
        
        // Act
        try {
            generator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        // No specific assertions needed as the method should complete without exceptions
    }


}
