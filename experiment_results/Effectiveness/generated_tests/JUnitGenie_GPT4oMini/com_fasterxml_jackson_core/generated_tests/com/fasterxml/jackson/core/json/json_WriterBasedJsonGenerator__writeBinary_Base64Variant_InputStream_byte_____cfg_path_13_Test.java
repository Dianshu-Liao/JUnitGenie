package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator__writeBinary_Base64Variant_InputStream_byte_____cfg_path_13_Test {

    private static class TestWriterBasedJsonGenerator extends WriterBasedJsonGenerator {
        public TestWriterBasedJsonGenerator(IOContext ctxt, int features, ObjectCodec codec, StringWriter writer) throws IOException {
            super(ctxt, features, codec, writer);
        }

        // You can access the protected method here using reflection
        public int callWriteBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer) throws Exception {
            java.lang.reflect.Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeBinary", Base64Variant.class, InputStream.class, byte[].class);
            method.setAccessible(true);
            return (int) method.invoke(this, b64variant, data, readBuffer);
        }
    }


}
