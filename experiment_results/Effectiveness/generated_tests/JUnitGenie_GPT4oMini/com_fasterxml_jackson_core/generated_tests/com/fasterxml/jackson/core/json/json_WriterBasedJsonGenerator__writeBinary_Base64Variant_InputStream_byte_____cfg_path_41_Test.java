package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class json_WriterBasedJsonGenerator__writeBinary_Base64Variant_InputStream_byte_____cfg_path_41_Test {


    private int invokeProtectedWriteBinary(WriterBasedJsonGenerator generator, Base64Variant b64variant,
                                           InputStream data, byte[] readBuffer) throws IOException, JsonGenerationException {
        try {
            java.lang.reflect.Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeBinary", Base64Variant.class, InputStream.class, byte[].class);
            method.setAccessible(true);
            return (Integer) method.invoke(generator, b64variant, data, readBuffer);
        } catch (Exception e) {
            throw new IOException("Could not invoke _writeBinary", e);
        }
    }


}
