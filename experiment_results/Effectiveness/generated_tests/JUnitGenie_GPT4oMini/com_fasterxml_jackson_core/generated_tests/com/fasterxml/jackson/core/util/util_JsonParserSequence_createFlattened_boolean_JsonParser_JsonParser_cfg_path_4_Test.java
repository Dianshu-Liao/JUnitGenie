package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class util_JsonParserSequence_createFlattened_boolean_JsonParser_JsonParser_cfg_path_4_Test {

    private static class MockJsonParser extends JsonParser {
        @Override
        public NumberType getNumberType() { return null; }

        @Override
        public java.math.BigInteger getBigIntegerValue() { return null; }

        @Override
        public com.fasterxml.jackson.core.JsonLocation getTokenLocation() { return null; }

        @Override
        public com.fasterxml.jackson.core.JsonStreamContext getParsingContext() { return null; }

        @Override
        public java.math.BigDecimal getDecimalValue() { return null; }

        @Override
        public float getFloatValue() { return 0; }

        @Override
        public com.fasterxml.jackson.core.Version version() { return null; }

        @Override
        public byte[] getBinaryValue(com.fasterxml.jackson.core.Base64Variant base64Variant) { return new byte[0]; }

        @Override
        public void clearCurrentToken() {}

        @Override
        public boolean isClosed() { return false; }

        @Override
        public double getDoubleValue() { return 0; }

        @Override
        public void close() {}

        @Override
        public com.fasterxml.jackson.core.JsonToken nextValue() { return null; }

        @Override
        public int getCurrentTokenId() { return 0; }

        @Override
        public boolean hasCurrentToken() { return false; }

        @Override
        public com.fasterxml.jackson.core.JsonParser skipChildren() { return null; }

        @Override
        public void setCodec(com.fasterxml.jackson.core.ObjectCodec objectCodec) {}

        @Override
        public com.fasterxml.jackson.core.JsonToken nextToken() { return null; }

        @Override
        public String getText() { return null; }

        @Override
        public Number getNumberValue() { return null; }

        @Override
        public com.fasterxml.jackson.core.JsonToken getLastClearedToken() { return null; }

        @Override
        public char[] getTextCharacters() { return new char[0]; }

        @Override
        public void overrideCurrentName(String name) {}

        @Override
        public boolean hasToken(com.fasterxml.jackson.core.JsonToken token) { return false; }

        @Override
        public com.fasterxml.jackson.core.JsonLocation getCurrentLocation() { return null; }

        @Override
        public com.fasterxml.jackson.core.JsonToken getCurrentToken() { return null; }

        @Override
        public int getIntValue() { return 0; }

        @Override
        public com.fasterxml.jackson.core.ObjectCodec getCodec() { return null; }

        @Override
        public String getValueAsString(String defaultValue) { return null; }

        @Override
        public int getTextOffset() { return 0; }

        @Override
        public boolean hasTextCharacters() { return false; }

        @Override
        public long getLongValue() { return 0; }

        @Override
        public int getTextLength() { return 0; }

        @Override
        public boolean hasTokenId(int id) { return false; }

        @Override
        public String getCurrentName() { return null; }
    }

    @Test(timeout = 4000)
    public void testCreateFlattenedWithValidParsers() {
        boolean checkForExistingToken = true;
        JsonParser first = new MockJsonParser();
        JsonParser second = new MockJsonParser();

        try {
            JsonParserSequence result = JsonParserSequence.createFlattened(checkForExistingToken, first, second);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateFlattenedWithFirstParserAsSequence() {
        boolean checkForExistingToken = false;
        JsonParser first = new JsonParserSequence(checkForExistingToken, new JsonParser[] { new MockJsonParser() });
        JsonParser second = new MockJsonParser();

        try {
            JsonParserSequence result = JsonParserSequence.createFlattened(checkForExistingToken, first, second);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateFlattenedWithSecondParserAsSequence() {
        boolean checkForExistingToken = true;
        JsonParser first = new MockJsonParser();
        JsonParser second = new JsonParserSequence(checkForExistingToken, new JsonParser[] { new MockJsonParser() });

        try {
            JsonParserSequence result = JsonParserSequence.createFlattened(checkForExistingToken, first, second);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}