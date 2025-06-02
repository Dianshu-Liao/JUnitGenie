package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import static org.junit.Assert.*;

public class util_JsonParserSequence_createFlattened_boolean_JsonParser_JsonParser_cfg_path_7_Test {

    private static class MockJsonParser extends JsonParser {
        @Override
        public NumberType getNumberType() { return null; }

        @Override
        public BigInteger getBigIntegerValue() { return null; }

        @Override
        public JsonLocation getTokenLocation() { return null; }

        @Override
        public JsonStreamContext getParsingContext() { return null; }

        @Override
        public BigDecimal getDecimalValue() { return null; }

        @Override
        public float getFloatValue() { return 0; }

        @Override
        public Version version() { return null; }

        @Override
        public byte[] getBinaryValue(Base64Variant base64Variant) { return new byte[0]; }

        @Override
        public void clearCurrentToken() {}

        @Override
        public boolean isClosed() { return false; }

        @Override
        public double getDoubleValue() { return 0; }

        @Override
        public void close() {}

        @Override
        public JsonToken nextValue() { return null; }

        @Override
        public int getCurrentTokenId() { return 0; }

        @Override
        public boolean hasCurrentToken() { return false; }

        @Override
        public JsonParser skipChildren() { return null; }

        @Override
        public void setCodec(ObjectCodec codec) {}

        @Override
        public JsonToken nextToken() { return null; }

        @Override
        public String getText() { return null; }

        @Override
        public Number getNumberValue() { return null; }

        @Override
        public JsonToken getLastClearedToken() { return null; }

        @Override
        public char[] getTextCharacters() { return new char[0]; }

        @Override
        public void overrideCurrentName(String name) {}

        @Override
        public boolean hasToken(JsonToken token) { return false; }

        @Override
        public JsonLocation getCurrentLocation() { return null; }

        @Override
        public JsonToken getCurrentToken() { return null; }

        @Override
        public int getIntValue() { return 0; }

        @Override
        public ObjectCodec getCodec() { return null; }

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
    public void testCreateFlattened() {
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

}