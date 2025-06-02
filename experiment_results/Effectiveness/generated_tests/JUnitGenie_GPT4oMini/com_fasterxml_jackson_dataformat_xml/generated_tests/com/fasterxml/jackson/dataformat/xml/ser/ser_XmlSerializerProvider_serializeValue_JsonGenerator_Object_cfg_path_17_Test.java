package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class ser_XmlSerializerProvider_serializeValue_JsonGenerator_Object_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testSerializeValueWithNull() {
        // Arrange
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        XmlSerializerProvider serializerProvider = new XmlSerializerProvider(rootNameLookup);
        JsonGenerator mockGen = Mockito.mock(JsonGenerator.class);
        
        // Act
        try {
            serializerProvider.serializeValue(mockGen, null);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        try {
            Mockito.verify(mockGen).writeNull();
        } catch (IOException e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSerializeValueWithNonNull() {
        // Arrange
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        XmlSerializerProvider serializerProvider = new XmlSerializerProvider(rootNameLookup);
        JsonGenerator mockGen = Mockito.mock(JsonGenerator.class);
        Object value = new Object(); // Replace with a suitable object for testing

        // Act
        try {
            serializerProvider.serializeValue(mockGen, value);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        try {
            Mockito.verify(mockGen).writeObject(Mockito.eq(value)); // Use Mockito.eq to match the argument
        } catch (IOException e) {
            // Handle exception if necessary
        }
    }

}