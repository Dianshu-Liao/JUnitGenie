package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class deser_FromXmlParser__getByteArrayBuilder__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetByteArrayBuilder() {
        // Arrange
        FromXmlParser parser = null;
        try {
            // Assuming the constructor requires a valid input source, we need to provide a valid one.
            parser = new FromXmlParser(null, 0, 0, null, null, null); // This line needs valid parameters
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        ByteArrayBuilder byteArrayBuilder = null;
        try {
            Method method = FromXmlParser.class.getDeclaredMethod("_getByteArrayBuilder");
            method.setAccessible(true);
            byteArrayBuilder = (ByteArrayBuilder) method.invoke(parser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNotNull(byteArrayBuilder);
    }

}