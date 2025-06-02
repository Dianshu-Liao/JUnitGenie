package com.fasterxml.jackson.core.base;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import java.io.IOException;
import java.math.BigInteger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;

public class base_ParserBase_getNumberValue__cfg_path_1_Test {

    private static class ParserBaseImpl extends ParserBase {
        protected ParserBaseImpl(IOContext ctxt, int features) {
            super(ctxt, features);
        }

        @Override
        public char[] getTextCharacters() { return new char[0]; }

        @Override
        public String getText() { return ""; }

        @Override
        public JsonToken nextToken() { return JsonToken.VALUE_NUMBER_INT; }

        @Override
        public int getTextOffset() { return 0; }

        @Override
        public void setCodec(com.fasterxml.jackson.core.ObjectCodec codec) {}

        @Override
        public int getTextLength() { return 0; }

        @Override
        public com.fasterxml.jackson.core.ObjectCodec getCodec() { return null; }

        @Override
        public void _closeInput() {}
    }



}
