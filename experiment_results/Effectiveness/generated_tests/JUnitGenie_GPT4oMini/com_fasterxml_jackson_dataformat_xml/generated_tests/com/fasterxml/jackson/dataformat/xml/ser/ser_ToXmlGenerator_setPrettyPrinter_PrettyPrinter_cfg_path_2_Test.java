package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.stream.XMLStreamWriter;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ser_ToXmlGenerator_setPrettyPrinter_PrettyPrinter_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetPrettyPrinterWithNonXmlPrettyPrinter() {
        // Arrange
        IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
        int generatorFeatures = 0; // Replace with actual features if needed
        int outputFeatures = 0; // Replace with actual features if needed
        JsonMapper codec = JsonMapper.builder().build(); // Use JsonMapper as a concrete implementation of ObjectCodec
        XMLStreamWriter xmlStreamWriter = null; // Replace with actual XMLStreamWriter if available

        // Act
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, generatorFeatures, outputFeatures, codec, xmlStreamWriter, null);
        
        PrettyPrinter nonXmlPrettyPrinter = new PrettyPrinter() {
            @Override
            public void writeStartObject(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void writeEndObject(JsonGenerator jsonGenerator, int i) {
                // implementation here
            }

            @Override
            public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void writeArrayValueSeparator(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void writeStartArray(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void beforeObjectEntries(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void beforeArrayValues(JsonGenerator jsonGenerator) {
                // implementation here
            }

            @Override
            public void writeEndArray(JsonGenerator jsonGenerator, int i) {
                // implementation here
            }

            @Override
            public void writeRootValueSeparator(JsonGenerator jsonGenerator) {
                // implementation here
            }
        };

        // Act
        generator.setPrettyPrinter(nonXmlPrettyPrinter);

        // Assert
        assertNull(generator._xmlPrettyPrinter); // Verify that _xmlPrettyPrinter is set to null
    }

}