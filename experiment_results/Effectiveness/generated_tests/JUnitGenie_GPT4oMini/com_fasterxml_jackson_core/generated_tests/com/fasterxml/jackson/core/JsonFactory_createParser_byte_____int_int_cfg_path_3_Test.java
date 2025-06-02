package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import static org.junit.Assert.assertNotNull;

public class JsonFactory_createParser_byte_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidParameters() {
        JsonFactory factory = new JsonFactory();
        byte[] data = {1, 2, 3, 4, 5};
        int offset = 0;
        int length = data.length;

        try {
            JsonParser parser = factory.createParser(data, offset, length);
            assertNotNull(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Removed the catch block for JsonParseException as it is already caught by IOException
    }

    @Test(timeout = 4000)
    public void testCreateParserWithInputDecorator() {
        JsonFactory factory = new JsonFactory();
        factory.setInputDecorator(new InputDecorator() {
            @Override
            public InputStream decorate(IOContext ctxt, byte[] data, int offset, int len) {
                // Mock InputStream implementation
                return new InputStream() {
                    private int index = offset;

                    @Override
                    public int read() {
                        return index < offset + len ? data[index++] : -1;
                    }
                };
            }

            @Override
            public Reader decorate(IOContext ctxt, Reader reader) {
                // Implement the required method from InputDecorator
                return reader;
            }

            @Override
            public InputStream decorate(IOContext ctxt, InputStream inputStream) {
                // Implement the required method from InputDecorator
                return inputStream;
            }
        });

        byte[] data = {1, 2, 3, 4, 5};
        int offset = 0;
        int length = data.length;

        try {
            JsonParser parser = factory.createParser(data, offset, length);
            assertNotNull(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Removed the catch block for JsonParseException as it is already caught by IOException
    }


}