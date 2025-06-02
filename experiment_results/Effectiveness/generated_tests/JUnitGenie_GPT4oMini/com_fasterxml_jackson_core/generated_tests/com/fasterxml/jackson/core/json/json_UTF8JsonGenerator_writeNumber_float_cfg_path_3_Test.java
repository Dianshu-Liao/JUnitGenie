package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class json_UTF8JsonGenerator_writeNumber_float_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteNumberFinite() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        UTF8JsonGenerator generator = null;

        try {
            generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);
            float finiteFloat = 123.45f; // A finite float value

            // Act
            generator.writeNumber(finiteFloat);
            // Assert
            // You can add assertions here to verify the output if needed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (generator != null) {
                try {
                    generator.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonFinite() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        UTF8JsonGenerator generator = null;

        try {
            generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);
            float nonFiniteFloat = Float.NaN; // A non-finite float value

            // Act
            generator.writeNumber(nonFiniteFloat);
            // Assert
            // You can add assertions here to verify the output if needed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (generator != null) {
                try {
                    generator.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}