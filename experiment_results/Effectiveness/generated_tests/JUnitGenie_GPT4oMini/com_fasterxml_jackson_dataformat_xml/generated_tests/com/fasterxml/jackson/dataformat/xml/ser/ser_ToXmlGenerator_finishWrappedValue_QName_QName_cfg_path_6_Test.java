package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_finishWrappedValue_QName_QName_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testFinishWrappedValue_WithWrapperName_NullPrettyPrinter() {
        // Arrange
        ToXmlGenerator generator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, mock(javax.xml.stream.XMLStreamWriter.class), mock(com.fasterxml.jackson.dataformat.xml.XmlNameProcessor.class));
        QName wrapperName = new QName("wrapper");
        QName wrappedName = new QName("wrapped");
        
        // Act
        try {
            generator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        
        // Assert
        // Here you would typically verify the expected behavior, e.g., checking the state of the generator or the writer.
    }

    @Test(timeout = 4000)
    public void testFinishWrappedValue_WithWrapperName_NonNullPrettyPrinter() {
        // Arrange
        ToXmlGenerator generator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, mock(javax.xml.stream.XMLStreamWriter.class), mock(com.fasterxml.jackson.dataformat.xml.XmlNameProcessor.class));
        QName wrapperName = new QName("wrapper");
        QName wrappedName = new QName("wrapped");
        
        // Mock the _xmlPrettyPrinter
        generator._xmlPrettyPrinter = mock(com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter.class);
        
        // Act
        try {
            generator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        
        // Assert
        // Here you would typically verify the expected behavior, e.g., checking the state of the generator or the writer.
    }



}
