package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.JsonGeneratorImpl;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class json_JsonGeneratorImpl__verifyPrettyValueWrite_String_int_cfg_path_5_Test {

    private class TestJsonGenerator extends JsonGeneratorImpl {
        protected TestJsonGenerator(IOContext ctxt, int features, ObjectCodec codec) {
            super(ctxt, features, codec);
        }

        @Override
        public void writeString(String text) {}

        @Override
        public void writeRaw(char c) {}

        @Override
        public void writeNull() {}

        @Override
        public void writeNumber(float v) {}

        @Override
        public void _releaseBuffers() {}

        @Override
        public void writeEndObject() {}

        @Override
        public void flush() {}

        @Override
        public void writeNumber(String text) {}

        @Override
        public void writeUTF8String(byte[] text, int offset, int length) {}

        @Override
        public void _verifyValueWrite(String typeMsg) {}

        @Override
        public void writeBoolean(boolean state) {}

        @Override
        public void writeEndArray() {}

        @Override
        public void writeBinary(com.fasterxml.jackson.core.Base64Variant b64variant, byte[] data, int offset, int len) {}

        @Override
        public void writeNumber(long v) {}

        @Override
        public void writeRaw(String text, int offset, int len) {}

        @Override
        public void writeString(char[] text, int offset, int len) {}

        @Override
        public void writeStartObject() {}

        @Override
        public void writeNumber(java.math.BigInteger value) {}

        @Override
        public void writeRaw(char[] text, int offset, int len) {}

        @Override
        public void writeStartArray() {}

        @Override
        public void writeNumber(int v) {}

        @Override
        public void writeRawUTF8String(byte[] text, int offset, int len) {}

        @Override
        public void writeNumber(double v) {}

        @Override
        public void writeFieldName(String name) {}

        @Override
        public void writeNumber(java.math.BigDecimal value) {}

        @Override
        public void writeRaw(String text) {}
    }


}
