package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class json_UTF8JsonGenerator__writeCustomStringSegment2_String_int_int_cfg_path_29_Test {

    private void invokeWriteCustomStringSegment2(UTF8JsonGenerator generator, String text, int offset, int end) {
        try {
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeCustomStringSegment2", String.class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(generator, text, offset, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
