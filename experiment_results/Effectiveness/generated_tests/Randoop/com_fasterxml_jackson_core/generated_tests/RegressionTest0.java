package com.fasterxml.jackson.core;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        JsonLocation jsonLocation1 = null;
        JsonParseException jsonParseException2 = new JsonParseException("hi!", jsonLocation1);
        String str3 = jsonParseException2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "com.fasterxml.jackson.core.JsonParseException: hi!" + "'", str3, "com.fasterxml.jackson.core.JsonParseException: hi!");
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES + "'", feature0.equals(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES));
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        ObjectCodec objectCodec2 = null;
        byte[] byteArray5 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder7 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray5, (-1));
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.UTF8JsonGenerator uTF8JsonGenerator9 = new com.fasterxml.jackson.core.json.UTF8JsonGenerator(iOContext0, 10, objectCodec2, (java.io.OutputStream) byteArrayBuilder7, '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder7);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigInteger bigInteger2 = com.fasterxml.jackson.core.io.BigIntegerParser.parseWithFastParser("", (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 0");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        com.fasterxml.jackson.core.io.NumberOutput numberOutput0 = new com.fasterxml.jackson.core.io.NumberOutput();
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        int int0 = Base64Variant.BASE64_VALUE_INVALID;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        int int0 = com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.HASH_MULT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 33 + "'", int0 == 33);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        int int0 = com.fasterxml.jackson.core.json.JsonWriteContext.STATUS_OK_AS_IS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        int int0 = ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 256 + "'", int0 == 256);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        Version version3 = com.fasterxml.jackson.core.util.VersionUtil.parseVersion("hi!", "", "");
        int int4 = version3.getMajorVersion();
        org.junit.Assert.assertNotNull(version3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS + "'", feature0.equals(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS));
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer byteQuadsCanonicalizer2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser nonBlockingByteBufferJsonParser3 = new com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser(iOContext0, 10, byteQuadsCanonicalizer2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        int int0 = com.fasterxml.jackson.core.util.BufferRecycler.CHAR_NAME_COPY_BUFFER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        int int0 = ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 500 + "'", int0 == 500);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder1 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler0);
        byteArrayBuilder1.appendTwoBytes(0);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool1 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler2 = null;
        // The following exception was thrown during execution in test generation
        try {
            boundedPool1.releasePooled(bufferRecycler2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(boundedPool1);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        int int0 = com.fasterxml.jackson.core.io.CharacterEscapes.ESCAPE_NONE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerRecyclerPool0 = com.fasterxml.jackson.core.util.JsonRecyclerPools.sharedConcurrentDequePool();
        org.junit.Assert.assertNotNull(bufferRecyclerRecyclerPool0);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder1 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler0);
        byteArrayBuilder1.appendThreeBytes((int) (byte) 1);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature0 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        org.junit.Assert.assertTrue("'" + jsonReadFeature0 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature0.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        JsonLocation jsonLocation1 = null;
        JsonParseException jsonParseException2 = new JsonParseException("hi!", jsonLocation1);
        JsonParser jsonParser3 = null;
        JsonParseException jsonParseException4 = jsonParseException2.withParser(jsonParser3);
        Object obj5 = jsonParseException4.getProcessor();
        org.junit.Assert.assertNotNull(jsonParseException4);
        org.junit.Assert.assertNull(obj5);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        JsonParser.NumberType numberType0 = JsonParser.NumberType.FLOAT;
        org.junit.Assert.assertTrue("'" + numberType0 + "' != '" + JsonParser.NumberType.FLOAT + "'", numberType0.equals(JsonParser.NumberType.FLOAT));
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.fasterxml.jackson.core.io.NumberInput.parseDouble("", false);
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: empty String");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        JsonParser.NumberTypeFP numberTypeFP0 = JsonParser.NumberTypeFP.DOUBLE64;
        org.junit.Assert.assertTrue("'" + numberTypeFP0 + "' != '" + JsonParser.NumberTypeFP.DOUBLE64 + "'", numberTypeFP0.equals(JsonParser.NumberTypeFP.DOUBLE64));
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigInteger bigInteger1 = com.fasterxml.jackson.core.io.BigIntegerParser.parseWithFastParser("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: Value \"hi!\" can not be represented as `java.math.BigInteger`, reason: illegal syntax");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        JsonGenerator.Feature feature0 = JsonGenerator.Feature.AUTO_CLOSE_TARGET;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonGenerator.Feature.AUTO_CLOSE_TARGET + "'", feature0.equals(JsonGenerator.Feature.AUTO_CLOSE_TARGET));
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal1 = com.fasterxml.jackson.core.io.BigDecimalParser.parseWithFastParser("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: Value \"hi!\" can not be deserialized as `java.math.BigDecimal`, reason:  illegal syntax");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        char[] charArray6 = new char[] { 'a', '#', '4', '#', '4', '4' };
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal8 = com.fasterxml.jackson.core.io.NumberInput.parseBigDecimal(charArray6, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: Value \"a#4#44\" can not be deserialized as `java.math.BigDecimal`, reason:  illegal syntax");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { 'a', '#', '4', '#', '4', '4' });
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        String str1 = com.fasterxml.jackson.core.io.NumberOutput.toString((float) 33);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "33.0" + "'", str1, "33.0");
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        int int0 = com.fasterxml.jackson.core.util.RecyclerPool.StatefulImplBase.SERIALIZATION_NON_SHARED;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        ErrorReportConfiguration errorReportConfiguration0 = ErrorReportConfiguration.defaults();
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(errorReportConfiguration0);
        org.junit.Assert.assertNotNull(errorReportConfiguration0);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_TRAILING_COMMA;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_TRAILING_COMMA + "'", feature0.equals(JsonParser.Feature.ALLOW_TRAILING_COMMA));
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        Base64Variants base64Variants0 = new Base64Variants();
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        Base64Variant base64Variant0 = null;
        // The following exception was thrown during execution in test generation
        try {
            Base64Variant base64Variant3 = new Base64Variant(base64Variant0, "JSON", (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        char char0 = JsonFactory.DEFAULT_QUOTE_CHAR;
        org.junit.Assert.assertTrue("'" + char0 + "' != '" + '\"' + "'", char0 == '\"');
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        int int0 = com.fasterxml.jackson.core.format.DataFormatDetector.DEFAULT_MAX_INPUT_LOOKAHEAD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 64 + "'", int0 == 64);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        java.io.DataInput dataInput2 = null;
        ObjectCodec objectCodec3 = null;
        com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer byteQuadsCanonicalizer4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.UTF8DataInputJsonParser uTF8DataInputJsonParser6 = new com.fasterxml.jackson.core.json.UTF8DataInputJsonParser(iOContext0, 0, dataInput2, objectCodec3, byteQuadsCanonicalizer4, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        com.fasterxml.jackson.core.io.SerializedString serializedString0 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        java.nio.ByteBuffer byteBuffer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int2 = serializedString0.putUnquotedUTF8(byteBuffer1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString0);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeEndObject();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeNumber((long) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.io.SerializedString serializedString2 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        byte[] byteArray4 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload6 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray4, "");
        int int8 = serializedString2.appendQuotedUTF8(byteArray4, (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeRaw((SerializableString) serializedString2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString2);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal10 = com.fasterxml.jackson.core.io.BigDecimalParser.parse(charArray6, (int) (byte) 100, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 100");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.io.SerializedString serializedString2 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        byte[] byteArray4 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload6 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray4, "");
        int int8 = serializedString2.appendQuotedUTF8(byteArray4, (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeString((SerializableString) serializedString2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString2);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass3 = jsonFactory0.getFormatWriteFeatureType();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNull(wildcardClass3);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        int int0 = JsonGenerator.Feature.collectDefaults();
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2079 + "'", int0 == 2079);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = jsonGeneratorDelegate1.canWriteBinaryNatively();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.io.SerializedString serializedString2 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeString((SerializableString) serializedString2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString2);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder1 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler0);
        byteArrayBuilder1.append((int) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray5 = byteArrayBuilder1.completeAndCoalesce(2079);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigInteger bigInteger3 = com.fasterxml.jackson.core.io.NumberInput.parseBigIntegerWithRadix("hi!", 256, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: Radix out of range");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        java.io.DataInput dataInput0 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int1 = com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.skipUTF8BOM(dataInput0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        StreamWriteFeature streamWriteFeature0 = StreamWriteFeature.USE_FAST_DOUBLE_WRITER;
        boolean boolean2 = streamWriteFeature0.enabledIn((int) (short) 10);
        org.junit.Assert.assertTrue("'" + streamWriteFeature0 + "' != '" + StreamWriteFeature.USE_FAST_DOUBLE_WRITER + "'", streamWriteFeature0.equals(StreamWriteFeature.USE_FAST_DOUBLE_WRITER));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        byte byte0 = com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.UTF8_BOM_1;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) -17 + "'", byte0 == (byte) -17);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        FormatSchema formatSchema6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = filteringGeneratorDelegate5.canUseSchema(formatSchema6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        JsonParseException jsonParseException1 = new JsonParseException("JSON");
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamReadConstraints streamReadConstraints2 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonFactory jsonFactory3 = jsonFactory0.setStreamReadConstraints(streamReadConstraints2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        JsonParser.NumberType numberType0 = JsonParser.NumberType.BIG_INTEGER;
        org.junit.Assert.assertTrue("'" + numberType0 + "' != '" + JsonParser.NumberType.BIG_INTEGER + "'", numberType0.equals(JsonParser.NumberType.BIG_INTEGER));
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        int int0 = com.fasterxml.jackson.core.json.JsonWriteContext.STATUS_OK_AFTER_COLON;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        int int2 = jsonFactory0.getFormatGeneratorFeatures();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        StreamReadFeature streamReadFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonFactoryBuilder jsonFactoryBuilder4 = jsonFactoryBuilder2.disable(streamReadFeature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeObjectFieldStart("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        // The following exception was thrown during execution in test generation
        try {
            float float25 = jsonParserSequence24.getFloatValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature0 = com.fasterxml.jackson.core.json.JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        org.junit.Assert.assertTrue("'" + jsonWriteFeature0 + "' != '" + com.fasterxml.jackson.core.json.JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS + "'", jsonWriteFeature0.equals(com.fasterxml.jackson.core.json.JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS));
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet27 = jsonParserSequence24.getReadCapabilities();
        StreamReadCapability streamReadCapability28 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean29 = streamReadCapabilityJacksonFeatureSet27.isEnabled(streamReadCapability28);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet27);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        Version version3 = com.fasterxml.jackson.core.util.VersionUtil.parseVersion("hi!", "", "");
        int int4 = version3.getPatchLevel();
        org.junit.Assert.assertNotNull(version3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        StreamWriteFeature streamWriteFeature0 = StreamWriteFeature.USE_FAST_DOUBLE_WRITER;
        boolean boolean1 = streamWriteFeature0.enabledByDefault();
        org.junit.Assert.assertTrue("'" + streamWriteFeature0 + "' != '" + StreamWriteFeature.USE_FAST_DOUBLE_WRITER + "'", streamWriteFeature0.equals(StreamWriteFeature.USE_FAST_DOUBLE_WRITER));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        // The following exception was thrown during execution in test generation
        try {
            double double26 = jsonParserSequence24.getDoubleValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        String str1 = com.fasterxml.jackson.core.io.NumberOutput.toString((int) (byte) 100);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "100" + "'", str1, "100");
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.writeEndArray();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonToken jsonToken28 = jsonParserSequence24.getCurrentToken();
        // The following exception was thrown during execution in test generation
        try {
            JsonParser.NumberType numberType29 = jsonParserSequence24.getNumberType();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(jsonToken28);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        StreamReadFeature streamReadFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonFactoryBuilder jsonFactoryBuilder4 = jsonFactoryBuilder2.enable(streamReadFeature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = jsonGeneratorDelegate1.canWriteFormattedNumbers();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonToken jsonToken28 = jsonParserSequence24.getCurrentToken();
        // The following exception was thrown during execution in test generation
        try {
            int int29 = jsonParserSequence24.getIntValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(jsonToken28);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        int int0 = com.fasterxml.jackson.core.util.BufferRecycler.BYTE_BASE64_CODEC_BUFFER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        ObjectCodec objectCodec0 = null;
        JsonFactory jsonFactory1 = new JsonFactory(objectCodec0);
        FormatSchema formatSchema2 = null;
        boolean boolean3 = jsonFactory1.canUseSchema(formatSchema2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        StreamReadCapability streamReadCapability0 = StreamReadCapability.UNTYPED_SCALARS;
        org.junit.Assert.assertTrue("'" + streamReadCapability0 + "' != '" + StreamReadCapability.UNTYPED_SCALARS + "'", streamReadCapability0.equals(StreamReadCapability.UNTYPED_SCALARS));
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean26 = jsonParserSequence24.getBooleanValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not of boolean type? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        long long0 = StreamReadConstraints.DEFAULT_MAX_DOC_LEN;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + (-1L) + "'", long0 == (-1L));
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        JsonGenerator jsonGenerator2 = jsonGeneratorDelegate1.delegate();
        PrettyPrinter prettyPrinter3 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonGenerator jsonGenerator4 = jsonGeneratorDelegate1.setPrettyPrinter(prettyPrinter3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonGenerator2);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        java.util.Collection<JsonFactory> jsonFactoryCollection0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.format.DataFormatDetector dataFormatDetector1 = new com.fasterxml.jackson.core.format.DataFormatDetector(jsonFactoryCollection0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        com.fasterxml.jackson.core.io.ContentReference contentReference8 = null;
        JsonLocation jsonLocation9 = jsonReadContext6.startLocation(contentReference8);
        long long10 = jsonLocation9.getByteOffset();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(jsonLocation9);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + (-1L) + "'", long10 == (-1L));
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        int int27 = jsonParserSequence24.getValueAsInt((-1));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + (-1) + "'", int27 == (-1));
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        ObjectCodec objectCodec2 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler3 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder4 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler3);
        JsonGenerator jsonGenerator5 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate6 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator5);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter7 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion8 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate10 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator5, tokenFilter7, inclusion8, true);
        filteringGeneratorDelegate10.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant13 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler14 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder15 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler14);
        byteArrayBuilder15.append((int) (short) -1);
        byte[] byteArray18 = byteArrayBuilder15.getClearAndRelease();
        filteringGeneratorDelegate10.writeBinary(base64Variant13, byteArray18, 3, (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.UTF8JsonGenerator uTF8JsonGenerator24 = new com.fasterxml.jackson.core.json.UTF8JsonGenerator(iOContext0, (int) (byte) 10, objectCodec2, (java.io.OutputStream) byteArrayBuilder4, byteArray18, (int) (short) 100, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) -1 });
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        com.fasterxml.jackson.core.io.CharTypes charTypes0 = new com.fasterxml.jackson.core.io.CharTypes();
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        // The following exception was thrown during execution in test generation
        try {
            Base64Variant base64Variant1 = Base64Variants.valueOf("100");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No Base64Variant with name '100'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        JsonParser.Feature feature0 = JsonParser.Feature.STRICT_DUPLICATE_DETECTION;
        boolean boolean2 = feature0.enabledIn((int) (byte) 1);
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.STRICT_DUPLICATE_DETECTION + "'", feature0.equals(JsonParser.Feature.STRICT_DUPLICATE_DETECTION));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet26 = jsonParserSequence24.getReadCapabilities();
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigInteger bigInteger27 = jsonParserSequence24.getBigIntegerValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet26);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        JsonGenerator jsonGenerator2 = jsonGeneratorDelegate1.delegate();
        JsonGenerator jsonGenerator4 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate5 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator4);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter6 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion7 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate9 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator4, tokenFilter6, inclusion7, true);
        filteringGeneratorDelegate9.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate9.writeFieldName("33.0");
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writePOJOField("100", (Object) "33.0");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonGenerator2);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        int[] intArray8 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes();
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.writeArray(intArray8, 500, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray8);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal10 = com.fasterxml.jackson.core.io.NumberInput.parseBigDecimal(charArray6, 64, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 64");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet27 = jsonParserSequence24.getReadCapabilities();
        // The following exception was thrown during execution in test generation
        try {
            Object obj28 = jsonParserSequence24.getNumberValueDeferred();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet27);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder1 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler0);
        byteArrayBuilder1.append((int) (short) -1);
        byte[] byteArray4 = byteArrayBuilder1.getClearAndRelease();
        byteArrayBuilder1.close();
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) -1 });
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = com.fasterxml.jackson.core.util.BufferRecyclers.getBufferRecycler();
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray2 = bufferRecycler0.allocByteBuffer((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bufferRecycler0);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        jsonParser7.setCurrentValue((Object) '#');
        JsonParser.NumberTypeFP numberTypeFP11 = jsonParser7.getNumberTypeFP();
        // The following exception was thrown during execution in test generation
        try {
            JsonParser.NumberType numberType12 = jsonParser7.getNumberType();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertTrue("'" + numberTypeFP11 + "' != '" + JsonParser.NumberTypeFP.UNKNOWN + "'", numberTypeFP11.equals(JsonParser.NumberTypeFP.UNKNOWN));
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        char[] charArray8 = null;
        filteringGeneratorDelegate5.writeNumber(charArray8, 2, 2);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonParser jsonParser28 = jsonParserSequence24.skipChildren();
        JsonLocation jsonLocation29 = jsonParserSequence24.getCurrentLocation();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNotNull(jsonParser28);
        org.junit.Assert.assertNotNull(jsonLocation29);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        long long0 = StreamReadConstraints.DEFAULT_MAX_TOKEN_COUNT;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + (-1L) + "'", long0 == (-1L));
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        char[] charArray18 = new char[] { '4' };
        filteringGeneratorDelegate5.writeNumber(charArray18, 33, (int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal24 = com.fasterxml.jackson.core.io.NumberInput.parseBigDecimal(charArray18, (int) (byte) -1, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: -1");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertArrayEquals(charArray18, new char[] { '4' });
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonParser jsonParser9 = jsonParser7.setFeatureMask((int) '4');
        boolean boolean10 = jsonParser9.isExpectedStartObjectToken();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNotNull(jsonParser9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder6 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder8 = jsonFactoryBuilder6.disable(jsonReadFeature7);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature9 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray11 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature4, jsonReadFeature5, jsonReadFeature7, jsonReadFeature9, jsonReadFeature10 };
        JsonFactoryBuilder jsonFactoryBuilder12 = jsonFactoryBuilder0.disable(jsonReadFeature3, jsonReadFeatureArray11);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature13 = com.fasterxml.jackson.core.json.JsonWriteFeature.COMBINE_UNICODE_SURROGATES_IN_UTF8;
        com.fasterxml.jackson.core.json.JsonWriteFeature[] jsonWriteFeatureArray14 = new com.fasterxml.jackson.core.json.JsonWriteFeature[] {};
        JsonFactoryBuilder jsonFactoryBuilder15 = jsonFactoryBuilder0.disable(jsonWriteFeature13, jsonWriteFeatureArray14);
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + jsonReadFeature3 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature3.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature4 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature4.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature5 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature5.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature7 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature7.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder8);
        org.junit.Assert.assertTrue("'" + jsonReadFeature9 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature9.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray11);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray11, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder12);
        org.junit.Assert.assertTrue("'" + jsonWriteFeature13 + "' != '" + com.fasterxml.jackson.core.json.JsonWriteFeature.COMBINE_UNICODE_SURROGATES_IN_UTF8 + "'", jsonWriteFeature13.equals(com.fasterxml.jackson.core.json.JsonWriteFeature.COMBINE_UNICODE_SURROGATES_IN_UTF8));
        org.junit.Assert.assertNotNull(jsonWriteFeatureArray14);
        org.junit.Assert.assertArrayEquals(jsonWriteFeatureArray14, new com.fasterxml.jackson.core.json.JsonWriteFeature[] {});
        org.junit.Assert.assertNotNull(jsonFactoryBuilder15);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeFieldName("33.0");
        FormatSchema formatSchema10 = null;
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.setSchema(formatSchema10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        Object obj25 = jsonParser10.getObjectId();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertNull(obj25);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        byte[] byteArray2 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder4 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray2, (-1));
        // The following exception was thrown during execution in test generation
        try {
            byteArrayBuilder4.appendThreeBytes(10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder4);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        java.io.DataOutput dataOutput0 = null;
        com.fasterxml.jackson.core.io.DataOutputAsStream dataOutputAsStream1 = new com.fasterxml.jackson.core.io.DataOutputAsStream(dataOutput0);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        // The following exception was thrown during execution in test generation
        try {
            long long10 = com.fasterxml.jackson.core.io.NumberInput.parseLong19(charArray6, (int) ' ', true);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 32");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeRaw("33.0");
        // The following exception was thrown during execution in test generation
        try {
            Object obj10 = filteringGeneratorDelegate5.getOutputTarget();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        JsonToken jsonToken25 = JsonToken.VALUE_EMBEDDED_OBJECT;
        com.fasterxml.jackson.core.type.WritableTypeId writableTypeId26 = new com.fasterxml.jackson.core.type.WritableTypeId((Object) true, jsonToken25);
        com.fasterxml.jackson.core.type.WritableTypeId.Inclusion inclusion27 = com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.METADATA_PROPERTY;
        writableTypeId26.include = inclusion27;
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + jsonToken25 + "' != '" + JsonToken.VALUE_EMBEDDED_OBJECT + "'", jsonToken25.equals(JsonToken.VALUE_EMBEDDED_OBJECT));
        org.junit.Assert.assertTrue("'" + inclusion27 + "' != '" + com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.METADATA_PROPERTY + "'", inclusion27.equals(com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.METADATA_PROPERTY));
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        JsonLocation jsonLocation1 = null;
        JsonParseException jsonParseException2 = new JsonParseException("hi!", jsonLocation1);
        JsonParser jsonParser3 = null;
        JsonParseException jsonParseException4 = jsonParseException2.withParser(jsonParser3);
        JsonFactory jsonFactory5 = new JsonFactory();
        boolean boolean6 = jsonFactory5.requiresCustomCodec();
        String str7 = jsonFactory5.getFormatName();
        char[] charArray11 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser12 = jsonFactory5.createParser(charArray11);
        JsonToken jsonToken13 = jsonParser12.getLastClearedToken();
        com.fasterxml.jackson.core.exc.StreamReadException streamReadException14 = jsonParseException2.withParser(jsonParser12);
        org.junit.Assert.assertNotNull(jsonParseException4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "JSON" + "'", str7, "JSON");
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertArrayEquals(charArray11, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser12);
        org.junit.Assert.assertNull(jsonToken13);
        org.junit.Assert.assertNotNull(streamReadException14);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder6 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder8 = jsonFactoryBuilder6.disable(jsonReadFeature7);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature9 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray11 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature4, jsonReadFeature5, jsonReadFeature7, jsonReadFeature9, jsonReadFeature10 };
        JsonFactoryBuilder jsonFactoryBuilder12 = jsonFactoryBuilder0.disable(jsonReadFeature3, jsonReadFeatureArray11);
        com.fasterxml.jackson.core.util.JsonGeneratorDecorator jsonGeneratorDecorator13 = null;
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder0.addDecorator(jsonGeneratorDecorator13);
        StreamWriteFeature streamWriteFeature15 = StreamWriteFeature.IGNORE_UNKNOWN;
        StreamWriteFeature streamWriteFeature16 = StreamWriteFeature.USE_FAST_DOUBLE_WRITER;
        boolean boolean17 = streamWriteFeature16.enabledByDefault();
        StreamWriteFeature streamWriteFeature18 = StreamWriteFeature.USE_FAST_DOUBLE_WRITER;
        boolean boolean20 = streamWriteFeature18.enabledIn((int) (short) 10);
        StreamWriteFeature[] streamWriteFeatureArray21 = new StreamWriteFeature[] { streamWriteFeature16, streamWriteFeature18 };
        JsonFactoryBuilder jsonFactoryBuilder22 = jsonFactoryBuilder0.enable(streamWriteFeature15, streamWriteFeatureArray21);
        JsonGenerator.Feature feature23 = streamWriteFeature15.mappedFeature();
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + jsonReadFeature3 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature3.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature4 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature4.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature5 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature5.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature7 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature7.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder8);
        org.junit.Assert.assertTrue("'" + jsonReadFeature9 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature9.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray11);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray11, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder12);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + streamWriteFeature15 + "' != '" + StreamWriteFeature.IGNORE_UNKNOWN + "'", streamWriteFeature15.equals(StreamWriteFeature.IGNORE_UNKNOWN));
        org.junit.Assert.assertTrue("'" + streamWriteFeature16 + "' != '" + StreamWriteFeature.USE_FAST_DOUBLE_WRITER + "'", streamWriteFeature16.equals(StreamWriteFeature.USE_FAST_DOUBLE_WRITER));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + streamWriteFeature18 + "' != '" + StreamWriteFeature.USE_FAST_DOUBLE_WRITER + "'", streamWriteFeature18.equals(StreamWriteFeature.USE_FAST_DOUBLE_WRITER));
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(streamWriteFeatureArray21);
        org.junit.Assert.assertArrayEquals(streamWriteFeatureArray21, new StreamWriteFeature[] { StreamWriteFeature.USE_FAST_DOUBLE_WRITER, StreamWriteFeature.USE_FAST_DOUBLE_WRITER });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder22);
        org.junit.Assert.assertTrue("'" + feature23 + "' != '" + JsonGenerator.Feature.IGNORE_UNKNOWN + "'", feature23.equals(JsonGenerator.Feature.IGNORE_UNKNOWN));
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        byte[] byteArray17 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate5.writeRawUTF8String(byteArray17, 0, 2);
        int[] intArray25 = new int[] { 500, 'a', 1, (short) 0 };
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.writeArray(intArray25, (int) '#', (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] {});
        org.junit.Assert.assertNotNull(intArray25);
        org.junit.Assert.assertArrayEquals(intArray25, new int[] { 500, 97, 1, 0 });
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonParser jsonParser9 = jsonParser7.setFeatureMask((int) '4');
        int int10 = jsonParser9.getValueAsInt();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNotNull(jsonParser9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Object obj28 = jsonParserSequence24.getObjectId();
        JsonParser jsonParser29 = jsonParserSequence24.delegate();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(obj28);
        org.junit.Assert.assertNotNull(jsonParser29);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamWriteConstraints streamWriteConstraints2 = jsonFactory0.streamWriteConstraints();
        StreamWriteConstraints.Builder builder3 = streamWriteConstraints2.rebuild();
        StreamWriteConstraints.Builder builder5 = builder3.maxNestingDepth((int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints2);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        JsonToken jsonToken0 = JsonToken.VALUE_EMBEDDED_OBJECT;
        boolean boolean1 = jsonToken0.isStructEnd();
        org.junit.Assert.assertTrue("'" + jsonToken0 + "' != '" + JsonToken.VALUE_EMBEDDED_OBJECT + "'", jsonToken0.equals(JsonToken.VALUE_EMBEDDED_OBJECT));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        boolean boolean2 = com.fasterxml.jackson.core.io.NumberInput.inLongRange("100", true);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        boolean boolean1 = com.fasterxml.jackson.core.io.NumberOutput.notFinite((float) (byte) 10);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeFieldName("33.0");
        FormatSchema formatSchema10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = filteringGeneratorDelegate5.canUseSchema(formatSchema10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        com.fasterxml.jackson.core.io.ContentReference contentReference1 = null;
        JsonLocation jsonLocation5 = new JsonLocation(contentReference1, (long) (-1), (int) (byte) 0, (int) (byte) 100);
        JsonParseException jsonParseException6 = new JsonParseException("com.fasterxml.jackson.core.JsonParseException: hi!", jsonLocation5);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        com.fasterxml.jackson.core.io.ContentReference contentReference8 = null;
        JsonLocation jsonLocation9 = jsonReadContext6.startLocation(contentReference8);
        boolean boolean10 = jsonReadContext6.hasCurrentName();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(jsonLocation9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        com.fasterxml.jackson.core.type.WritableTypeId writableTypeId0 = new com.fasterxml.jackson.core.type.WritableTypeId();
        Class<?> wildcardClass1 = writableTypeId0.forValueType;
        org.junit.Assert.assertNull(wildcardClass1);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS + "'", feature0.equals(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS));
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        String str0 = JsonFactory.FORMAT_NAME_JSON;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "JSON" + "'", str0, "JSON");
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        com.fasterxml.jackson.core.io.ContentReference contentReference8 = null;
        JsonLocation jsonLocation9 = jsonReadContext6.startLocation(contentReference8);
        int int10 = jsonLocation9.getLineNr();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(jsonLocation9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        int int0 = com.fasterxml.jackson.core.util.BufferRecycler.CHAR_TEXT_BUFFER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder1 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler0);
        byteArrayBuilder1.append((int) (short) -1);
        byte[] byteArray4 = byteArrayBuilder1.finishCurrentSegment();
        org.junit.Assert.assertNotNull(byteArray4);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        byte byte0 = com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.UTF8_BOM_3;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) -65 + "'", byte0 == (byte) -65);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString7 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString7);
        JsonLocation jsonLocation11 = null;
        JsonParseException jsonParseException12 = new JsonParseException("hi!", jsonLocation11);
        JsonParser jsonParser13 = null;
        JsonParseException jsonParseException14 = jsonParseException12.withParser(jsonParser13);
        JsonLocation jsonLocation16 = null;
        JsonParseException jsonParseException17 = new JsonParseException("hi!", jsonLocation16);
        jsonParseException14.addSuppressed((Throwable) jsonParseException17);
        jsonParseException17.clearLocation();
        JsonGenerator jsonGenerator20 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate21 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator20);
        JsonGenerationException jsonGenerationException22 = new JsonGenerationException("", (Throwable) jsonParseException17, jsonGenerator20);
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.assignCurrentValue((Object) jsonParseException17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString7);
        org.junit.Assert.assertNotNull(jsonParseException14);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        com.fasterxml.jackson.core.util.InternCache internCache0 = com.fasterxml.jackson.core.util.InternCache.instance;
        java.util.function.ToDoubleFunction<java.util.Map.Entry<String, String>> strEntryToDoubleFunction2 = null;
        java.util.function.DoubleBinaryOperator doubleBinaryOperator4 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double5 = internCache0.reduceEntriesToDouble((long) (byte) -17, strEntryToDoubleFunction2, (-1.0d), doubleBinaryOperator4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(internCache0);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeRaw('#');
        // The following exception was thrown during execution in test generation
        try {
            ObjectCodec objectCodec8 = filteringGeneratorDelegate5.getCodec();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamWriteConstraints streamWriteConstraints2 = jsonFactory0.streamWriteConstraints();
        int int3 = jsonFactory0.getFormatParserFeatures();
        JsonParser jsonParser4 = jsonFactory0.createNonBlockingByteBufferParser();
        java.io.DataInput dataInput5 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonParser jsonParser6 = jsonFactory0.createParser(dataInput5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(jsonParser4);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        Base64Variant.PaddingReadBehaviour paddingReadBehaviour0 = Base64Variant.PaddingReadBehaviour.PADDING_ALLOWED;
        org.junit.Assert.assertTrue("'" + paddingReadBehaviour0 + "' != '" + Base64Variant.PaddingReadBehaviour.PADDING_ALLOWED + "'", paddingReadBehaviour0.equals(Base64Variant.PaddingReadBehaviour.PADDING_ALLOWED));
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        com.fasterxml.jackson.core.type.WritableTypeId.Inclusion inclusion0 = com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.PARENT_PROPERTY;
        org.junit.Assert.assertTrue("'" + inclusion0 + "' != '" + com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.PARENT_PROPERTY + "'", inclusion0.equals(com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.PARENT_PROPERTY));
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonParser jsonParser9 = jsonParser7.setFeatureMask((int) '4');
        jsonParser9.setRequestPayloadOnError("com.fasterxml.jackson.core.JsonParseException: hi!");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNotNull(jsonParser9);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        char[] charArray18 = new char[] { '4' };
        filteringGeneratorDelegate5.writeNumber(charArray18, 33, (int) (short) 100);
        String[] strArray27 = new String[] { "JSON", "100", "33.0", "JSON", "JSON" };
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.writeArray(strArray27, (-1), (int) '\"');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertArrayEquals(charArray18, new char[] { '4' });
        org.junit.Assert.assertNotNull(strArray27);
        org.junit.Assert.assertArrayEquals(strArray27, new String[] { "JSON", "100", "33.0", "JSON", "JSON" });
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        boolean boolean1 = com.fasterxml.jackson.core.io.NumberInput.looksLikeValidNumber("JSON");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        byte[] byteArray3 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("hi!");
        // The following exception was thrown during execution in test generation
        try {
            jsonGeneratorDelegate1.writeUTF8String(byteArray3, (int) ' ', 500);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 104, (byte) 105, (byte) 33 });
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        jsonParser7.setCurrentValue((Object) '#');
        JsonParser jsonParser13 = jsonParser7.overrideStdFeatures((int) '4', (int) '4');
        com.fasterxml.jackson.core.json.DupDetector dupDetector14 = com.fasterxml.jackson.core.json.DupDetector.rootDetector(jsonParser7);
        com.fasterxml.jackson.core.json.DupDetector dupDetector15 = dupDetector14.child();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertNotNull(jsonParser13);
        org.junit.Assert.assertNotNull(dupDetector14);
        org.junit.Assert.assertNotNull(dupDetector15);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        int int0 = Base64Variant.BASE64_VALUE_PADDING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-2) + "'", int0 == (-2));
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeRaw("33.0");
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.setCurrentValue((Object) "com.fasterxml.jackson.core.JsonParseException: hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        Version version3 = com.fasterxml.jackson.core.util.VersionUtil.parseVersion("hi!", "?", "100");
        org.junit.Assert.assertNotNull(version3);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        JsonParser.Feature feature0 = JsonParser.Feature.AUTO_CLOSE_SOURCE;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.AUTO_CLOSE_SOURCE + "'", feature0.equals(JsonParser.Feature.AUTO_CLOSE_SOURCE));
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        com.fasterxml.jackson.core.util.MinimalPrettyPrinter minimalPrettyPrinter1 = new com.fasterxml.jackson.core.util.MinimalPrettyPrinter("");
        JsonGenerator jsonGenerator2 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate3 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator2);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter4 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion5 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate7 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator2, tokenFilter4, inclusion5, true);
        filteringGeneratorDelegate7.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant10 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler11 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder12 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler11);
        byteArrayBuilder12.append((int) (short) -1);
        byte[] byteArray15 = byteArrayBuilder12.getClearAndRelease();
        filteringGeneratorDelegate7.writeBinary(base64Variant10, byteArray15, 3, (int) (byte) 0);
        char[] charArray20 = new char[] { '4' };
        filteringGeneratorDelegate7.writeNumber(charArray20, 33, (int) (short) 100);
        minimalPrettyPrinter1.writeObjectEntrySeparator((JsonGenerator) filteringGeneratorDelegate7);
        JsonGenerator jsonGenerator25 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate26 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator25);
        // The following exception was thrown during execution in test generation
        try {
            minimalPrettyPrinter1.writeArrayValueSeparator(jsonGenerator25);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(charArray20);
        org.junit.Assert.assertArrayEquals(charArray20, new char[] { '4' });
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean25 = jsonParserSequence24.getBooleanValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not of boolean type? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool1 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler2 = com.fasterxml.jackson.core.util.BufferRecyclers.getBufferRecycler();
        bufferRecycler2.releaseToPool();
        boundedPool1.releasePooled(bufferRecycler2);
        int int5 = boundedPool1.pooledCount();
        org.junit.Assert.assertNotNull(boundedPool1);
        org.junit.Assert.assertNotNull(bufferRecycler2);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        boolean boolean10 = jsonParser7.getValueAsBoolean(false);
        JsonLocation jsonLocation16 = new JsonLocation((Object) (byte) -1, (long) (byte) 1, (int) '4', 256);
        JsonLocation jsonLocation18 = null;
        JsonParseException jsonParseException19 = new JsonParseException("hi!", jsonLocation18);
        JsonParser jsonParser20 = null;
        JsonParseException jsonParseException21 = jsonParseException19.withParser(jsonParser20);
        JsonLocation jsonLocation23 = null;
        JsonParseException jsonParseException24 = new JsonParseException("hi!", jsonLocation23);
        jsonParseException21.addSuppressed((Throwable) jsonParseException24);
        JsonParseException jsonParseException26 = new JsonParseException(jsonParser7, "", jsonLocation16, (Throwable) jsonParseException24);
        Throwable[] throwableArray27 = jsonParseException24.getSuppressed();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(jsonParseException21);
        org.junit.Assert.assertNotNull(throwableArray27);
        org.junit.Assert.assertArrayEquals(throwableArray27, new Throwable[] {});
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonParser jsonParser28 = jsonParserSequence24.skipChildren();
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigInteger bigInteger29 = jsonParser28.getBigIntegerValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNotNull(jsonParser28);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString7 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString7);
        Base64Variant base64Variant9 = null;
        byte[] byteArray11 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("hi!");
        filteringGeneratorDelegate5.writeBinary(base64Variant9, byteArray11, 100, (int) (byte) -17);
        filteringGeneratorDelegate5.writeEndObject();
        org.junit.Assert.assertNotNull(serializedString7);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 104, (byte) 105, (byte) 33 });
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal2 = com.fasterxml.jackson.core.io.NumberInput.parseBigDecimal("hi!", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: Value \"hi!\" can not be deserialized as `java.math.BigDecimal`, reason:  illegal syntax");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        byte[] byteArray2 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder4 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray2, (-1));
        byte[] byteArray5 = byteArrayBuilder4.getCurrentSegment();
        // The following exception was thrown during execution in test generation
        try {
            byteArrayBuilder4.appendTwoBytes((-2));
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder4);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) -1, (byte) 10 });
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        Base64Variant base64Variant0 = null;
        // The following exception was thrown during execution in test generation
        try {
            Base64Variant base64Variant3 = new Base64Variant(base64Variant0, "", 256);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder6 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder8 = jsonFactoryBuilder6.disable(jsonReadFeature7);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature9 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray11 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature4, jsonReadFeature5, jsonReadFeature7, jsonReadFeature9, jsonReadFeature10 };
        JsonFactoryBuilder jsonFactoryBuilder12 = jsonFactoryBuilder0.disable(jsonReadFeature3, jsonReadFeatureArray11);
        com.fasterxml.jackson.core.util.JsonGeneratorDecorator jsonGeneratorDecorator13 = null;
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder0.addDecorator(jsonGeneratorDecorator13);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature15 = com.fasterxml.jackson.core.json.JsonWriteFeature.QUOTE_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder16 = jsonFactoryBuilder14.disable(jsonWriteFeature15);
        JsonFactoryBuilder jsonFactoryBuilder18 = jsonFactoryBuilder16.rootValueSeparator("?");
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + jsonReadFeature3 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature3.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature4 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature4.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature5 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature5.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature7 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature7.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder8);
        org.junit.Assert.assertTrue("'" + jsonReadFeature9 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature9.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray11);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray11, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder12);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + jsonWriteFeature15 + "' != '" + com.fasterxml.jackson.core.json.JsonWriteFeature.QUOTE_FIELD_NAMES + "'", jsonWriteFeature15.equals(com.fasterxml.jackson.core.json.JsonWriteFeature.QUOTE_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder16);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder18);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        String str1 = com.fasterxml.jackson.core.io.NumberOutput.toString(500);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "500" + "'", str1, "500");
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        int int0 = StreamWriteFeature.collectDefaults();
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeRaw("33.0");
        // The following exception was thrown during execution in test generation
        try {
            int int10 = filteringGeneratorDelegate5.getHighestEscapedChar();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder6 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder8 = jsonFactoryBuilder6.disable(jsonReadFeature7);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature9 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray11 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature4, jsonReadFeature5, jsonReadFeature7, jsonReadFeature9, jsonReadFeature10 };
        JsonFactoryBuilder jsonFactoryBuilder12 = jsonFactoryBuilder0.disable(jsonReadFeature3, jsonReadFeatureArray11);
        JsonFactoryBuilder jsonFactoryBuilder13 = new JsonFactoryBuilder();
        JsonFactory jsonFactory14 = new JsonFactory(jsonFactoryBuilder13);
        StreamReadFeature streamReadFeature15 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean16 = jsonFactory14.isEnabled(streamReadFeature15);
        JsonFactoryBuilder jsonFactoryBuilder17 = jsonFactoryBuilder12.disable(streamReadFeature15);
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + jsonReadFeature3 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature3.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature4 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature4.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature5 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature5.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature7 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature7.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder8);
        org.junit.Assert.assertTrue("'" + jsonReadFeature9 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature9.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray11);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray11, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder12);
        org.junit.Assert.assertTrue("'" + streamReadFeature15 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature15.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder17);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool1 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler2 = com.fasterxml.jackson.core.util.BufferRecyclers.getBufferRecycler();
        bufferRecycler2.releaseToPool();
        boundedPool1.releasePooled(bufferRecycler2);
        com.fasterxml.jackson.core.io.ContentReference contentReference5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.io.IOContext iOContext7 = new com.fasterxml.jackson.core.io.IOContext(bufferRecycler2, contentReference5, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(boundedPool1);
        org.junit.Assert.assertNotNull(bufferRecycler2);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        jsonParser7.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream11 = null;
        int int12 = jsonParser7.releaseBuffered(outputStream11);
        JsonParser.Feature feature13 = JsonParser.Feature.STRICT_DUPLICATE_DETECTION;
        boolean boolean14 = jsonParser7.isEnabled(feature13);
        double double16 = jsonParser7.getValueAsDouble((double) '4');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + feature13 + "' != '" + JsonParser.Feature.STRICT_DUPLICATE_DETECTION + "'", feature13.equals(JsonParser.Feature.STRICT_DUPLICATE_DETECTION));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 52.0d + "'", double16 == 52.0d);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        jsonParser7.setCurrentValue((Object) '#');
        JsonParser jsonParser13 = jsonParser7.overrideStdFeatures((int) '4', (int) '4');
        ObjectCodec objectCodec14 = null;
        jsonParser7.setCodec(objectCodec14);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertNotNull(jsonParser13);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        byte[] byteArray10 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload12 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray10, "");
        jsonParser7.setRequestPayloadOnError(requestPayload12);
        jsonParser7.assignCurrentValue((Object) 256);
        long long16 = jsonParser7.currentTokenCount();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertTrue("'" + long16 + "' != '" + 0L + "'", long16 == 0L);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        byte[] byteArray17 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate5.writeRawUTF8String(byteArray17, 0, 2);
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.writePOJO((Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] {});
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        JsonFactory jsonFactory1 = new JsonFactory(jsonFactoryBuilder0);
        boolean boolean2 = jsonFactory1.canHandleBinaryNatively();
        java.io.File file3 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonParser jsonParser4 = jsonFactory1.createParser(file3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        byte[] byteArray2 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder4 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray2, (-1));
        byte[] byteArray7 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder9 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray7, (-1));
        byte[] byteArray10 = byteArrayBuilder9.getCurrentSegment();
        // The following exception was thrown during execution in test generation
        try {
            byteArrayBuilder4.write(byteArray10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder4);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder9);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) -1, (byte) 10 });
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        JsonGenerator jsonGenerator10 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate11 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator10);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter12 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion13 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate15 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator10, tokenFilter12, inclusion13, true);
        filteringGeneratorDelegate15.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString17 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate15.writeFieldName((SerializableString) serializedString17);
        boolean boolean19 = jsonPointer9.equals((Object) filteringGeneratorDelegate15);
        // The following exception was thrown during execution in test generation
        try {
            Version version20 = filteringGeneratorDelegate15.version();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertNotNull(serializedString17);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        java.io.DataOutput dataOutput2 = null;
        JsonEncoding jsonEncoding3 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator4 = jsonFactory0.createGenerator(dataOutput2, jsonEncoding3);
        StreamWriteFeature streamWriteFeature5 = StreamWriteFeature.IGNORE_UNKNOWN;
        int int6 = streamWriteFeature5.getMask();
        boolean boolean7 = jsonFactory0.isEnabled(streamWriteFeature5);
        boolean boolean8 = jsonFactory0.canParseAsync();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + jsonEncoding3 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding3.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator4);
        org.junit.Assert.assertTrue("'" + streamWriteFeature5 + "' != '" + StreamWriteFeature.IGNORE_UNKNOWN + "'", streamWriteFeature5.equals(StreamWriteFeature.IGNORE_UNKNOWN));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 512 + "'", int6 == 512);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool0 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        boolean boolean1 = lockFreePool0.clear();
        org.junit.Assert.assertNotNull(lockFreePool0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamWriteCapability> streamWriteCapabilityJacksonFeatureSet8 = filteringGeneratorDelegate5.getWriteCapabilities();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        byte[] byteArray8 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        // The following exception was thrown during execution in test generation
        try {
            JsonParser jsonParser11 = jsonFactory0.createJsonParser(byteArray8, 500, (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid 'offset' (500) and/or 'len' (10) arguments for `byte[]` of length 0");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] {});
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        int int0 = com.fasterxml.jackson.core.json.JsonWriteContext.STATUS_EXPECT_NAME;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        byte[] byteArray1 = com.fasterxml.jackson.core.io.CharTypes.copyHexBytes(false);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102 });
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonParser jsonParser28 = jsonParserSequence24.skipChildren();
        // The following exception was thrown during execution in test generation
        try {
            double double29 = jsonParserSequence24.getDoubleValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNotNull(jsonParser28);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", feature0.equals(JsonParser.Feature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        com.fasterxml.jackson.core.util.InternCache internCache0 = com.fasterxml.jackson.core.util.InternCache.instance;
        java.util.concurrent.ConcurrentHashMap.KeySetView<String, String> strSet1 = internCache0.keySet();
        java.util.Collection<String> strCollection2 = internCache0.values();
        org.junit.Assert.assertNotNull(internCache0);
        org.junit.Assert.assertNotNull(strSet1);
        org.junit.Assert.assertNotNull(strCollection2);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        JsonFactory jsonFactory9 = new JsonFactory();
        boolean boolean10 = jsonFactory9.requiresCustomCodec();
        String str11 = jsonFactory9.getFormatName();
        char[] charArray15 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser16 = jsonFactory9.createParser(charArray15);
        JsonParser jsonParser18 = jsonParser16.setFeatureMask((int) '4');
        JsonFactory jsonFactory19 = new JsonFactory();
        boolean boolean20 = jsonFactory19.requiresCustomCodec();
        String str21 = jsonFactory19.getFormatName();
        char[] charArray25 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser26 = jsonFactory19.createParser(charArray25);
        JsonToken jsonToken27 = jsonParser26.getLastClearedToken();
        jsonParser26.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream30 = null;
        int int31 = jsonParser26.releaseBuffered(outputStream30);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence32 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser18, jsonParser26);
        boolean boolean33 = jsonParserSequence32.canParseAsync();
        double double35 = jsonParserSequence32.getValueAsDouble(0.0d);
        JsonToken jsonToken36 = jsonParserSequence32.getCurrentToken();
        JsonParser jsonParser37 = jsonParserSequence32.skipChildren();
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.copyCurrentStructure((JsonParser) jsonParserSequence32);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonGenerationException; message: No current event to copy");
        } catch (JsonGenerationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "JSON" + "'", str11, "JSON");
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertArrayEquals(charArray15, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser16);
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "JSON" + "'", str21, "JSON");
        org.junit.Assert.assertNotNull(charArray25);
        org.junit.Assert.assertArrayEquals(charArray25, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNull(jsonToken27);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + (-1) + "'", int31 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + double35 + "' != '" + 0.0d + "'", double35 == 0.0d);
        org.junit.Assert.assertNull(jsonToken36);
        org.junit.Assert.assertNotNull(jsonParser37);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        JsonEncoding jsonEncoding0 = JsonEncoding.UTF32_BE;
        boolean boolean1 = jsonEncoding0.isBigEndian();
        org.junit.Assert.assertTrue("'" + jsonEncoding0 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding0.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        // The following exception was thrown during execution in test generation
        try {
            Object obj25 = jsonParserSequence24.getNumberValueDeferred();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        JsonToken jsonToken0 = JsonToken.FIELD_NAME;
        char[] charArray1 = jsonToken0.asCharArray();
        org.junit.Assert.assertTrue("'" + jsonToken0 + "' != '" + JsonToken.FIELD_NAME + "'", jsonToken0.equals(JsonToken.FIELD_NAME));
        org.junit.Assert.assertNull(charArray1);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        JsonToken jsonToken0 = JsonToken.VALUE_NULL;
        boolean boolean1 = jsonToken0.isBoolean();
        org.junit.Assert.assertTrue("'" + jsonToken0 + "' != '" + JsonToken.VALUE_NULL + "'", jsonToken0.equals(JsonToken.VALUE_NULL));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString7 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString7);
        filteringGeneratorDelegate5.writeRawValue("hi!");
        String[] strArray15 = new String[] { "500", "?", "100", "100" };
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.writeArray(strArray15, (int) (byte) 10, (int) (byte) -65);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString7);
        org.junit.Assert.assertNotNull(strArray15);
        org.junit.Assert.assertArrayEquals(strArray15, new String[] { "500", "?", "100", "100" });
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        com.fasterxml.jackson.core.json.DupDetector dupDetector0 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext1 = com.fasterxml.jackson.core.json.JsonReadContext.createRootContext(dupDetector0);
        boolean boolean2 = jsonReadContext1.hasCurrentName();
        String str3 = jsonReadContext1.typeDesc();
        org.junit.Assert.assertNotNull(jsonReadContext1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "root" + "'", str3, "root");
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.util.InternCache internCache3 = new com.fasterxml.jackson.core.util.InternCache((int) (short) 10, (float) (byte) -17, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        // The following exception was thrown during execution in test generation
        try {
            int int10 = com.fasterxml.jackson.core.io.NumberOutput.outputLong((long) 1, charArray7, 3);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 3");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool16 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler17 = lockFreePool16.acquirePooled();
        boundedPool13.releasePooled(bufferRecycler17);
        com.fasterxml.jackson.core.util.TextBuffer textBuffer19 = new com.fasterxml.jackson.core.util.TextBuffer(bufferRecycler17);
        String str20 = textBuffer19.toString();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(lockFreePool16);
        org.junit.Assert.assertNotNull(bufferRecycler17);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        JsonGenerator.Feature feature8 = JsonGenerator.Feature.QUOTE_FIELD_NAMES;
        // The following exception was thrown during execution in test generation
        try {
            JsonGenerator jsonGenerator9 = filteringGeneratorDelegate5.disable(feature8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + feature8 + "' != '" + JsonGenerator.Feature.QUOTE_FIELD_NAMES + "'", feature8.equals(JsonGenerator.Feature.QUOTE_FIELD_NAMES));
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        JsonPointer jsonPointer8 = JsonPointer.forPath((JsonStreamContext) jsonReadContext6, true);
        org.junit.Assert.assertNotNull(jsonPointer8);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        FormatSchema formatSchema10 = null;
        boolean boolean11 = jsonFactory0.canUseSchema(formatSchema10);
        java.net.URL uRL12 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonParser jsonParser13 = jsonFactory0.createParser(uRL12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        char[] charArray18 = new char[] { '4' };
        filteringGeneratorDelegate5.writeNumber(charArray18, 33, (int) (short) 100);
        filteringGeneratorDelegate5.writeRaw("JSON", 64, 0);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertArrayEquals(charArray18, new char[] { '4' });
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        JsonToken jsonToken25 = JsonToken.VALUE_EMBEDDED_OBJECT;
        com.fasterxml.jackson.core.type.WritableTypeId writableTypeId26 = new com.fasterxml.jackson.core.type.WritableTypeId((Object) true, jsonToken25);
        boolean boolean27 = jsonToken25.isBoolean();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + jsonToken25 + "' != '" + JsonToken.VALUE_EMBEDDED_OBJECT + "'", jsonToken25.equals(JsonToken.VALUE_EMBEDDED_OBJECT));
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        Version version3 = com.fasterxml.jackson.core.util.VersionUtil.parseVersion("hi!", "", "");
        String str4 = version3.getGroupId();
        int int5 = version3.getMinorVersion();
        org.junit.Assert.assertNotNull(version3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        // The following exception was thrown during execution in test generation
        try {
            short short9 = jsonParser7.getShortValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Object obj28 = jsonParserSequence24.getObjectId();
        // The following exception was thrown during execution in test generation
        try {
            Number number29 = jsonParserSequence24.getNumberValueExact();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(obj28);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = filteringGeneratorDelegate5.canWriteBinaryNatively();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        StreamReadConstraints streamReadConstraints0 = null;
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        String str9 = jsonFactory1.getFormatName();
        Class<? extends FormatFeature> wildcardClass10 = jsonFactory1.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder11 = new JsonFactoryBuilder();
        JsonFactory jsonFactory12 = new JsonFactory(jsonFactoryBuilder11);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool14 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder15 = jsonFactoryBuilder11.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool14);
        JsonFactory jsonFactory16 = jsonFactory1.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool14);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool17 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler18 = lockFreePool17.acquirePooled();
        boundedPool14.releasePooled(bufferRecycler18);
        com.fasterxml.jackson.core.io.ContentReference contentReference20 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.io.IOContext iOContext22 = new com.fasterxml.jackson.core.io.IOContext(streamReadConstraints0, bufferRecycler18, contentReference20, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "JSON" + "'", str9, "JSON");
        org.junit.Assert.assertNull(wildcardClass10);
        org.junit.Assert.assertNotNull(boundedPool14);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder15);
        org.junit.Assert.assertNotNull(jsonFactory16);
        org.junit.Assert.assertNotNull(lockFreePool17);
        org.junit.Assert.assertNotNull(bufferRecycler18);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        com.fasterxml.jackson.core.util.Separators.Spacing spacing0 = com.fasterxml.jackson.core.util.Separators.Spacing.BOTH;
        String str2 = spacing0.apply(' ');
        org.junit.Assert.assertTrue("'" + spacing0 + "' != '" + com.fasterxml.jackson.core.util.Separators.Spacing.BOTH + "'", spacing0.equals(com.fasterxml.jackson.core.util.Separators.Spacing.BOTH));
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "   " + "'", str2, "   ");
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        com.fasterxml.jackson.core.io.SerializedString serializedString0 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        byte[] byteArray2 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload4 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray2, "");
        int int6 = serializedString0.appendQuotedUTF8(byteArray2, (int) (short) 0);
        char[] charArray7 = serializedString0.asQuotedChars();
        org.junit.Assert.assertNotNull(serializedString0);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { ' ' });
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion0 = com.fasterxml.jackson.core.filter.TokenFilter.Inclusion.INCLUDE_NON_NULL;
        org.junit.Assert.assertTrue("'" + inclusion0 + "' != '" + com.fasterxml.jackson.core.filter.TokenFilter.Inclusion.INCLUDE_NON_NULL + "'", inclusion0.equals(com.fasterxml.jackson.core.filter.TokenFilter.Inclusion.INCLUDE_NON_NULL));
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeBoolean(true);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = filteringGeneratorDelegate5.getCharacterEscapes();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool16 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler17 = lockFreePool16.acquirePooled();
        boundedPool13.releasePooled(bufferRecycler17);
        com.fasterxml.jackson.core.util.TextBuffer textBuffer19 = new com.fasterxml.jackson.core.util.TextBuffer(bufferRecycler17);
        textBuffer19.resetWith('4');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(lockFreePool16);
        org.junit.Assert.assertNotNull(bufferRecycler17);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        int int0 = JsonTokenId.ID_STRING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        JsonFactory jsonFactory1 = new JsonFactory(jsonFactoryBuilder0);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool3 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder4 = jsonFactoryBuilder0.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool3);
        JsonFactoryBuilder jsonFactoryBuilder5 = new JsonFactoryBuilder();
        JsonFactory jsonFactory6 = new JsonFactory(jsonFactoryBuilder5);
        StreamReadFeature streamReadFeature7 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean8 = jsonFactory6.isEnabled(streamReadFeature7);
        JsonFactoryBuilder jsonFactoryBuilder9 = jsonFactoryBuilder0.enable(streamReadFeature7);
        org.junit.Assert.assertNotNull(boundedPool3);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder4);
        org.junit.Assert.assertTrue("'" + streamReadFeature7 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature7.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder9);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer byteQuadsCanonicalizer2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.async.NonBlockingJsonParser nonBlockingJsonParser3 = new com.fasterxml.jackson.core.json.async.NonBlockingJsonParser(iOContext0, (int) (byte) 1, byteQuadsCanonicalizer2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool1 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler2 = com.fasterxml.jackson.core.util.BufferRecyclers.getBufferRecycler();
        boundedPool1.releasePooled(bufferRecycler2);
        org.junit.Assert.assertNotNull(boundedPool1);
        org.junit.Assert.assertNotNull(bufferRecycler2);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        int[] intArray0 = com.fasterxml.jackson.core.io.CharTypes.getInputCodeUtf8();
        org.junit.Assert.assertNotNull(intArray0);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        String str1 = com.fasterxml.jackson.core.io.NumberOutput.toString((double) 10L);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "10.0" + "'", str1, "10.0");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        Version version3 = com.fasterxml.jackson.core.util.VersionUtil.parseVersion("hi!", "", "");
        String str4 = version3.getArtifactId();
        org.junit.Assert.assertNotNull(version3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool0 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler1 = lockFreePool0.acquirePooled();
        // The following exception was thrown during execution in test generation
        try {
            char[] charArray4 = bufferRecycler1.allocCharBuffer(6, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 6");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(lockFreePool0);
        org.junit.Assert.assertNotNull(bufferRecycler1);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeBoolean(true);
        filteringGeneratorDelegate5.writeNumberField("com.fasterxml.jackson.core.JsonParseException: hi!", (short) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            StreamWriteConstraints streamWriteConstraints12 = filteringGeneratorDelegate5.streamWriteConstraints();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Version version28 = jsonParserSequence24.version();
        byte[] byteArray31 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder33 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray31, (-1));
        jsonParserSequence24.setRequestPayloadOnError(byteArray31, "500");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNotNull(version28);
        org.junit.Assert.assertNotNull(byteArray31);
        org.junit.Assert.assertArrayEquals(byteArray31, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder33);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        jsonParser7.setCurrentValue((Object) '#');
        JsonParser jsonParser13 = jsonParser7.overrideStdFeatures((int) '4', (int) '4');
        com.fasterxml.jackson.core.json.DupDetector dupDetector14 = com.fasterxml.jackson.core.json.DupDetector.rootDetector(jsonParser7);
        dupDetector14.reset();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertNotNull(jsonParser13);
        org.junit.Assert.assertNotNull(dupDetector14);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        int int0 = com.fasterxml.jackson.core.json.JsonWriteContext.STATUS_OK_AFTER_COMMA;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        com.fasterxml.jackson.core.util.MinimalPrettyPrinter minimalPrettyPrinter1 = new com.fasterxml.jackson.core.util.MinimalPrettyPrinter("");
        JsonGenerator jsonGenerator2 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate3 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator2);
        minimalPrettyPrinter1.beforeObjectEntries((JsonGenerator) jsonGeneratorDelegate3);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        com.fasterxml.jackson.core.util.MinimalPrettyPrinter minimalPrettyPrinter1 = new com.fasterxml.jackson.core.util.MinimalPrettyPrinter("");
        JsonFactory jsonFactory2 = new JsonFactory();
        boolean boolean3 = jsonFactory2.requiresCustomCodec();
        java.io.DataOutput dataOutput4 = null;
        JsonEncoding jsonEncoding5 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator6 = jsonFactory2.createGenerator(dataOutput4, jsonEncoding5);
        minimalPrettyPrinter1.writeArrayValueSeparator(jsonGenerator6);
        PrettyPrinter prettyPrinter8 = jsonGenerator6.getPrettyPrinter();
        // The following exception was thrown during execution in test generation
        try {
            jsonGenerator6.writeArrayFieldStart("com.fasterxml.jackson.core.JsonParseException: hi!");
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonGenerationException; message: Can not write a field name, expecting a value");
        } catch (JsonGenerationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + jsonEncoding5 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding5.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator6);
        org.junit.Assert.assertNull(prettyPrinter8);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonToken jsonToken28 = jsonParserSequence24.getCurrentToken();
        JsonParser jsonParser29 = jsonParserSequence24.skipChildren();
        JsonGenerator jsonGenerator30 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate31 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator30);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter32 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion33 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate35 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator30, tokenFilter32, inclusion33, true);
        filteringGeneratorDelegate35.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate35.writeFieldName("33.0");
        JsonGenerator jsonGenerator40 = filteringGeneratorDelegate35.delegate();
        JsonGenerator jsonGenerator41 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate42 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator41);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter43 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion44 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate46 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator41, tokenFilter43, inclusion44, true);
        filteringGeneratorDelegate46.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString48 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate46.writeFieldName((SerializableString) serializedString48);
        filteringGeneratorDelegate35.writeFieldName((SerializableString) serializedString48);
        boolean boolean51 = jsonParserSequence24.nextFieldName((SerializableString) serializedString48);
        String str52 = serializedString48.getValue();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(jsonToken28);
        org.junit.Assert.assertNotNull(jsonParser29);
        org.junit.Assert.assertNull(jsonGenerator40);
        org.junit.Assert.assertNotNull(serializedString48);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + " " + "'", str52, " ");
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        JsonToken jsonToken0 = JsonToken.END_OBJECT;
        boolean boolean1 = jsonToken0.isBoolean();
        org.junit.Assert.assertTrue("'" + jsonToken0 + "' != '" + JsonToken.END_OBJECT + "'", jsonToken0.equals(JsonToken.END_OBJECT));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler16 = boundedPool13.acquireAndLinkPooled();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(bufferRecycler16);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        java.io.DataInput dataInput2 = null;
        ObjectCodec objectCodec3 = null;
        com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer byteQuadsCanonicalizer4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.UTF8DataInputJsonParser uTF8DataInputJsonParser6 = new com.fasterxml.jackson.core.json.UTF8DataInputJsonParser(iOContext0, (int) '\"', dataInput2, objectCodec3, byteQuadsCanonicalizer4, 3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        char char1 = com.fasterxml.jackson.core.io.CharTypes.hexToChar((int) (byte) 0);
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + '0' + "'", char1 == '0');
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        JsonLocation jsonLocation5 = new JsonLocation((Object) (byte) -1, (long) (byte) 1, (int) '4', 256);
        JsonLocation jsonLocation8 = null;
        JsonParseException jsonParseException9 = new JsonParseException("hi!", jsonLocation8);
        JsonParser jsonParser10 = null;
        JsonParseException jsonParseException11 = jsonParseException9.withParser(jsonParser10);
        JsonLocation jsonLocation13 = null;
        JsonParseException jsonParseException14 = new JsonParseException("hi!", jsonLocation13);
        jsonParseException11.addSuppressed((Throwable) jsonParseException14);
        jsonParseException14.clearLocation();
        JsonGenerator jsonGenerator17 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate18 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator17);
        JsonGenerationException jsonGenerationException19 = new JsonGenerationException("", (Throwable) jsonParseException14, jsonGenerator17);
        JsonParseException jsonParseException20 = new JsonParseException("33.0", jsonLocation5, (Throwable) jsonParseException14);
        int int21 = jsonLocation5.getLineNr();
        org.junit.Assert.assertNotNull(jsonParseException11);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 52 + "'", int21 == 52);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        com.fasterxml.jackson.core.util.InternCache internCache0 = com.fasterxml.jackson.core.util.InternCache.instance;
        JsonParser.NumberType numberType1 = JsonParser.NumberType.LONG;
        String str3 = internCache0.getOrDefault((Object) numberType1, "33.0");
        java.util.concurrent.ConcurrentHashMap.KeySetView<String, String> strSet4 = internCache0.keySet();
        org.junit.Assert.assertNotNull(internCache0);
        org.junit.Assert.assertTrue("'" + numberType1 + "' != '" + JsonParser.NumberType.LONG + "'", numberType1.equals(JsonParser.NumberType.LONG));
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "33.0" + "'", str3, "33.0");
        org.junit.Assert.assertNotNull(strSet4);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        SerializableString serializableString3 = jsonFactoryBuilder0.rootValueSeparator();
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertNotNull(serializableString3);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        int int10 = jsonFactory0.getFormatGeneratorFeatures();
        byte[] byteArray13 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder15 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray13, (-1));
        byteArrayBuilder15.flush();
        JsonGenerator jsonGenerator17 = jsonFactory0.createGenerator((java.io.OutputStream) byteArrayBuilder15);
        // The following exception was thrown during execution in test generation
        try {
            byteArrayBuilder15.write((int) '0');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder15);
        org.junit.Assert.assertNotNull(jsonGenerator17);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal2 = com.fasterxml.jackson.core.io.NumberInput.parseBigDecimal("root", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: Value \"root\" can not be deserialized as `java.math.BigDecimal`, reason:  illegal syntax");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature0 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_YAML_COMMENTS;
        org.junit.Assert.assertTrue("'" + jsonReadFeature0 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_YAML_COMMENTS + "'", jsonReadFeature0.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_YAML_COMMENTS));
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS + "'", feature0.equals(JsonParser.Feature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS));
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        com.fasterxml.jackson.core.util.InternCache internCache0 = com.fasterxml.jackson.core.util.InternCache.instance;
        JsonParser.NumberType numberType1 = JsonParser.NumberType.LONG;
        String str3 = internCache0.getOrDefault((Object) numberType1, "33.0");
        java.util.Collection<String> strCollection4 = internCache0.values();
        org.junit.Assert.assertNotNull(internCache0);
        org.junit.Assert.assertTrue("'" + numberType1 + "' != '" + JsonParser.NumberType.LONG + "'", numberType1.equals(JsonParser.NumberType.LONG));
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "33.0" + "'", str3, "33.0");
        org.junit.Assert.assertNotNull(strCollection4);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        // The following exception was thrown during execution in test generation
        try {
            float float2 = com.fasterxml.jackson.core.io.NumberInput.parseFloat("", false);
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: empty String");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        StreamReadFeature streamReadFeature0 = StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION;
        org.junit.Assert.assertTrue("'" + streamReadFeature0 + "' != '" + StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION + "'", streamReadFeature0.equals(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION));
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString7 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString7);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        byte[] byteArray14 = byteArrayBuilder10.toByteArray();
        filteringGeneratorDelegate5.writeObjectRef((Object) byteArrayBuilder10);
        JsonGenerator.Feature feature16 = JsonGenerator.Feature.WRITE_HEX_UPPER_CASE;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = filteringGeneratorDelegate5.isEnabled(feature16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString7);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] {});
        org.junit.Assert.assertTrue("'" + feature16 + "' != '" + JsonGenerator.Feature.WRITE_HEX_UPPER_CASE + "'", feature16.equals(JsonGenerator.Feature.WRITE_HEX_UPPER_CASE));
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        JsonFactory jsonFactory9 = new JsonFactory();
        boolean boolean10 = jsonFactory9.requiresCustomCodec();
        String str11 = jsonFactory9.getFormatName();
        char[] charArray15 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser16 = jsonFactory9.createParser(charArray15);
        JsonParser jsonParser18 = jsonParser16.setFeatureMask((int) '4');
        JsonFactory jsonFactory19 = new JsonFactory();
        boolean boolean20 = jsonFactory19.requiresCustomCodec();
        String str21 = jsonFactory19.getFormatName();
        char[] charArray25 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser26 = jsonFactory19.createParser(charArray25);
        JsonToken jsonToken27 = jsonParser26.getLastClearedToken();
        jsonParser26.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream30 = null;
        int int31 = jsonParser26.releaseBuffered(outputStream30);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence32 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser18, jsonParser26);
        boolean boolean33 = jsonParserSequence32.canParseAsync();
        double double35 = jsonParserSequence32.getValueAsDouble(0.0d);
        JsonParser jsonParser36 = jsonParserSequence32.skipChildren();
        filteringGeneratorDelegate5.writeObjectRef((Object) jsonParser36);
        JsonGenerator jsonGenerator38 = filteringGeneratorDelegate5.delegate();
        FormatSchema formatSchema39 = null;
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.setSchema(formatSchema39);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "JSON" + "'", str11, "JSON");
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertArrayEquals(charArray15, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser16);
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "JSON" + "'", str21, "JSON");
        org.junit.Assert.assertNotNull(charArray25);
        org.junit.Assert.assertArrayEquals(charArray25, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNull(jsonToken27);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + (-1) + "'", int31 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + double35 + "' != '" + 0.0d + "'", double35 == 0.0d);
        org.junit.Assert.assertNotNull(jsonParser36);
        org.junit.Assert.assertNull(jsonGenerator38);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        int int0 = JsonTokenId.ID_END_OBJECT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        int int0 = com.fasterxml.jackson.core.util.BufferRecyclers.releaseBuffers();
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        com.fasterxml.jackson.core.util.MinimalPrettyPrinter minimalPrettyPrinter0 = new com.fasterxml.jackson.core.util.MinimalPrettyPrinter();
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        com.fasterxml.jackson.core.io.ContentReference contentReference8 = null;
        JsonLocation jsonLocation9 = jsonReadContext6.startLocation(contentReference8);
        int int10 = jsonReadContext6.getCurrentIndex();
        String str11 = jsonReadContext6.getCurrentName();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(jsonLocation9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        // The following exception was thrown during execution in test generation
        try {
            double double1 = com.fasterxml.jackson.core.io.NumberInput.parseDouble(" ");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: empty String");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        com.fasterxml.jackson.core.type.WritableTypeId writableTypeId0 = new com.fasterxml.jackson.core.type.WritableTypeId();
        com.fasterxml.jackson.core.io.ContentReference contentReference1 = null;
        JsonLocation jsonLocation5 = new JsonLocation(contentReference1, (long) (-1), (int) (byte) 0, (int) (byte) 100);
        writableTypeId0.forValue = jsonLocation5;
        Object obj7 = writableTypeId0.forValue;
        org.junit.Assert.assertNotNull(obj7);
        org.junit.Assert.assertEquals(obj7.toString(), "[Source: UNKNOWN; byte offset: #UNKNOWN]");
        org.junit.Assert.assertEquals(String.valueOf(obj7), "[Source: UNKNOWN; byte offset: #UNKNOWN]");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj7), "[Source: UNKNOWN; byte offset: #UNKNOWN]");
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        com.fasterxml.jackson.core.io.ContentReference contentReference0 = null;
        JsonLocation jsonLocation4 = new JsonLocation(contentReference0, (long) (-1), (int) (byte) 0, (int) (byte) 100);
        StringBuilder stringBuilder5 = null;
        // The following exception was thrown during execution in test generation
        try {
            StringBuilder stringBuilder6 = jsonLocation4.appendOffsetDescription(stringBuilder5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        com.fasterxml.jackson.core.sym.Name1 name1_0 = com.fasterxml.jackson.core.sym.Name1.getEmptyName();
        int[] intArray1 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes();
        boolean boolean3 = name1_0.equals(intArray1, (int) (short) -1);
        int[] intArray4 = null;
        boolean boolean6 = name1_0.equals(intArray4, (int) (short) -1);
        org.junit.Assert.assertNotNull(name1_0);
        org.junit.Assert.assertNotNull(intArray1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_MISSING_VALUES;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_MISSING_VALUES + "'", feature0.equals(JsonParser.Feature.ALLOW_MISSING_VALUES));
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        JsonFactory jsonFactory1 = new JsonFactory(jsonFactoryBuilder0);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool3 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder4 = jsonFactoryBuilder0.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool3);
        JsonFactory.Feature feature5 = JsonFactory.Feature.INTERN_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder7 = jsonFactoryBuilder0.configure(feature5, true);
        JsonGenerator jsonGenerator8 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate9 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator8);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter10 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion11 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate13 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator8, tokenFilter10, inclusion11, true);
        filteringGeneratorDelegate13.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate13.writeFieldName("33.0");
        JsonGenerator jsonGenerator18 = filteringGeneratorDelegate13.delegate();
        JsonGenerator jsonGenerator19 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate20 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator19);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter21 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion22 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate24 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator19, tokenFilter21, inclusion22, true);
        filteringGeneratorDelegate24.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString26 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate24.writeFieldName((SerializableString) serializedString26);
        filteringGeneratorDelegate13.writeFieldName((SerializableString) serializedString26);
        JsonFactoryBuilder jsonFactoryBuilder29 = jsonFactoryBuilder7.rootValueSeparator((SerializableString) serializedString26);
        org.junit.Assert.assertNotNull(boundedPool3);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder4);
        org.junit.Assert.assertTrue("'" + feature5 + "' != '" + JsonFactory.Feature.INTERN_FIELD_NAMES + "'", feature5.equals(JsonFactory.Feature.INTERN_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder7);
        org.junit.Assert.assertNull(jsonGenerator18);
        org.junit.Assert.assertNotNull(serializedString26);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder29);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        JsonGenerator jsonGenerator10 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate11 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator10);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter12 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion13 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate15 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator10, tokenFilter12, inclusion13, true);
        filteringGeneratorDelegate15.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString17 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate15.writeFieldName((SerializableString) serializedString17);
        boolean boolean19 = jsonPointer9.equals((Object) filteringGeneratorDelegate15);
        boolean boolean21 = jsonPointer9.matchesProperty("?");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertNotNull(serializedString17);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        int int0 = StreamWriteConstraints.DEFAULT_MAX_DEPTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1000 + "'", int0 == 1000);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        JsonEncoding jsonEncoding0 = JsonEncoding.UTF8;
        org.junit.Assert.assertTrue("'" + jsonEncoding0 + "' != '" + JsonEncoding.UTF8 + "'", jsonEncoding0.equals(JsonEncoding.UTF8));
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        boolean boolean28 = jsonParserSequence24.getValueAsBoolean();
        int int29 = jsonParserSequence24.getTextOffset();
        // The following exception was thrown during execution in test generation
        try {
            byte byte30 = jsonParserSequence24.getByteValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        com.fasterxml.jackson.core.io.ContentReference contentReference10 = null;
        JsonLocation jsonLocation11 = jsonReadContext6.startLocation(contentReference10);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertNotNull(jsonLocation11);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        StreamWriteConstraints streamWriteConstraints0 = StreamWriteConstraints.defaults();
        org.junit.Assert.assertNotNull(streamWriteConstraints0);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        JsonParser jsonParser25 = jsonParserSequence24.skipChildren();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertNotNull(jsonParser25);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString7 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString7);
        filteringGeneratorDelegate5.writeRawValue("   ", (int) (short) 0, 0);
        filteringGeneratorDelegate5.writeEndArray();
        org.junit.Assert.assertNotNull(serializedString7);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        com.fasterxml.jackson.core.io.ContentReference contentReference4 = com.fasterxml.jackson.core.io.ContentReference.construct(false, (Object) (short) -1, 7, (int) (short) 0);
        org.junit.Assert.assertNotNull(contentReference4);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        boolean boolean10 = jsonParser7.getValueAsBoolean(false);
        JsonLocation jsonLocation16 = new JsonLocation((Object) (byte) -1, (long) (byte) 1, (int) '4', 256);
        JsonLocation jsonLocation18 = null;
        JsonParseException jsonParseException19 = new JsonParseException("hi!", jsonLocation18);
        JsonParser jsonParser20 = null;
        JsonParseException jsonParseException21 = jsonParseException19.withParser(jsonParser20);
        JsonLocation jsonLocation23 = null;
        JsonParseException jsonParseException24 = new JsonParseException("hi!", jsonLocation23);
        jsonParseException21.addSuppressed((Throwable) jsonParseException24);
        JsonParseException jsonParseException26 = new JsonParseException(jsonParser7, "", jsonLocation16, (Throwable) jsonParseException24);
        int int27 = jsonLocation16.getColumnNr();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(jsonParseException21);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 256 + "'", int27 == 256);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        com.fasterxml.jackson.core.io.SerializedString serializedString26 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        jsonParserSequence24.setCurrentValue((Object) serializedString26);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(serializedString26);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeRaw("33.0");
        Base64Variant base64Variant10 = null;
        java.io.InputStream inputStream11 = null;
        int int13 = filteringGeneratorDelegate5.writeBinary(base64Variant10, inputStream11, (int) (byte) -17);
        char[] charArray15 = new char[] { ' ' };
        filteringGeneratorDelegate5.writeRaw(charArray15, (int) (byte) 100, 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertArrayEquals(charArray15, new char[] { ' ' });
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        int int2 = com.fasterxml.jackson.core.io.NumberInput.parseAsInt("", 64);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 64 + "'", int2 == 64);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeFieldName("33.0");
        JsonGenerator jsonGenerator10 = filteringGeneratorDelegate5.delegate();
        filteringGeneratorDelegate5.writeFieldId((long) 1);
        JsonpCharacterEscapes jsonpCharacterEscapes13 = JsonpCharacterEscapes.instance();
        // The following exception was thrown during execution in test generation
        try {
            JsonGenerator jsonGenerator14 = filteringGeneratorDelegate5.setCharacterEscapes((com.fasterxml.jackson.core.io.CharacterEscapes) jsonpCharacterEscapes13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonGenerator10);
        org.junit.Assert.assertNotNull(jsonpCharacterEscapes13);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        com.fasterxml.jackson.core.util.Separators.Spacing spacing2 = com.fasterxml.jackson.core.util.Separators.Spacing.BOTH;
        com.fasterxml.jackson.core.util.Separators.Spacing spacing4 = com.fasterxml.jackson.core.util.Separators.Spacing.BOTH;
        com.fasterxml.jackson.core.util.Separators.Spacing spacing6 = com.fasterxml.jackson.core.util.Separators.Spacing.BOTH;
        com.fasterxml.jackson.core.util.Separators separators7 = new com.fasterxml.jackson.core.util.Separators(" ", '0', spacing2, ' ', spacing4, 'a', spacing6);
        org.junit.Assert.assertTrue("'" + spacing2 + "' != '" + com.fasterxml.jackson.core.util.Separators.Spacing.BOTH + "'", spacing2.equals(com.fasterxml.jackson.core.util.Separators.Spacing.BOTH));
        org.junit.Assert.assertTrue("'" + spacing4 + "' != '" + com.fasterxml.jackson.core.util.Separators.Spacing.BOTH + "'", spacing4.equals(com.fasterxml.jackson.core.util.Separators.Spacing.BOTH));
        org.junit.Assert.assertTrue("'" + spacing6 + "' != '" + com.fasterxml.jackson.core.util.Separators.Spacing.BOTH + "'", spacing6.equals(com.fasterxml.jackson.core.util.Separators.Spacing.BOTH));
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        com.fasterxml.jackson.core.util.InternCache internCache0 = com.fasterxml.jackson.core.util.InternCache.instance;
        long long1 = internCache0.mappingCount();
        int int2 = internCache0.size();
        org.junit.Assert.assertNotNull(internCache0);
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 0L + "'", long1 == 0L);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        FormatSchema formatSchema27 = jsonParserSequence24.getSchema();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNull(formatSchema27);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Object obj28 = jsonParserSequence24.getObjectId();
        int int29 = jsonParserSequence24.getTextLength();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(obj28);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        int int10 = jsonFactory0.getFormatGeneratorFeatures();
        Class<? extends FormatFeature> wildcardClass11 = jsonFactory0.getFormatWriteFeatureType();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNull(wildcardClass11);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        com.fasterxml.jackson.core.util.Separators.Spacing spacing0 = com.fasterxml.jackson.core.util.Separators.Spacing.AFTER;
        org.junit.Assert.assertTrue("'" + spacing0 + "' != '" + com.fasterxml.jackson.core.util.Separators.Spacing.AFTER + "'", spacing0.equals(com.fasterxml.jackson.core.util.Separators.Spacing.AFTER));
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamWriteConstraints streamWriteConstraints2 = jsonFactory0.streamWriteConstraints();
        String str3 = jsonFactory0.getFormatName();
        byte[] byteArray5 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("hi!");
        // The following exception was thrown during execution in test generation
        try {
            JsonParser jsonParser8 = jsonFactory0.createParser(byteArray5, (int) (byte) 10, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid 'offset' (10) and/or 'len' (0) arguments for `byte[]` of length 3");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 104, (byte) 105, (byte) 33 });
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString7 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString7);
        filteringGeneratorDelegate5.writeRawValue("hi!");
        // The following exception was thrown during execution in test generation
        try {
            int int11 = filteringGeneratorDelegate5.getHighestEscapedChar();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(serializedString7);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        JsonLocation jsonLocation5 = new JsonLocation((Object) (byte) -1, (long) (byte) 1, (int) '4', 256);
        JsonLocation jsonLocation8 = null;
        JsonParseException jsonParseException9 = new JsonParseException("hi!", jsonLocation8);
        JsonParser jsonParser10 = null;
        JsonParseException jsonParseException11 = jsonParseException9.withParser(jsonParser10);
        JsonLocation jsonLocation13 = null;
        JsonParseException jsonParseException14 = new JsonParseException("hi!", jsonLocation13);
        jsonParseException11.addSuppressed((Throwable) jsonParseException14);
        jsonParseException14.clearLocation();
        JsonGenerator jsonGenerator17 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate18 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator17);
        JsonGenerationException jsonGenerationException19 = new JsonGenerationException("", (Throwable) jsonParseException14, jsonGenerator17);
        JsonParseException jsonParseException20 = new JsonParseException("33.0", jsonLocation5, (Throwable) jsonParseException14);
        String str21 = jsonParseException20.toString();
        Object obj22 = jsonParseException20.getProcessor();
        org.junit.Assert.assertNotNull(jsonParseException11);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "com.fasterxml.jackson.core.JsonParseException: 33.0\n at [Source: (Byte); line: 52, column: 256]" + "'", str21, "com.fasterxml.jackson.core.JsonParseException: 33.0\n at [Source: (Byte); line: 52, column: 256]");
        org.junit.Assert.assertNull(obj22);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        // The following exception was thrown during execution in test generation
        try {
            ObjectCodec objectCodec8 = filteringGeneratorDelegate5.getCodec();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        byte[] byteArray10 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder12 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray10, (-1));
        byte[] byteArray13 = byteArrayBuilder12.getCurrentSegment();
        // The following exception was thrown during execution in test generation
        try {
            JsonParser jsonParser16 = jsonFactory0.createParser(byteArray13, 10, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid 'offset' (10) and/or 'len' (-1) arguments for `byte[]` of length 2");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder12);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1, (byte) 10 });
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer charsToNameCanonicalizer0 = com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.createRoot();
        int int2 = charsToNameCanonicalizer0.calcHash("");
        int int4 = charsToNameCanonicalizer0.calcHash("   ");
        org.junit.Assert.assertNotNull(charsToNameCanonicalizer0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 35936 + "'", int4 == 35936);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        com.fasterxml.jackson.core.util.DefaultPrettyPrinter defaultPrettyPrinter1 = new com.fasterxml.jackson.core.util.DefaultPrettyPrinter("?");
        com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter indenter2 = null;
        com.fasterxml.jackson.core.util.DefaultPrettyPrinter defaultPrettyPrinter3 = defaultPrettyPrinter1.withObjectIndenter(indenter2);
        com.fasterxml.jackson.core.util.DefaultPrettyPrinter defaultPrettyPrinter4 = defaultPrettyPrinter3.withSpacesInObjectEntries();
        org.junit.Assert.assertNotNull(defaultPrettyPrinter3);
        org.junit.Assert.assertNotNull(defaultPrettyPrinter4);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool1 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler2 = com.fasterxml.jackson.core.util.BufferRecyclers.getBufferRecycler();
        bufferRecycler2.releaseToPool();
        boundedPool1.releasePooled(bufferRecycler2);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool6 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler7 = com.fasterxml.jackson.core.util.BufferRecyclers.getBufferRecycler();
        bufferRecycler7.releaseToPool();
        boundedPool6.releasePooled(bufferRecycler7);
        boundedPool1.releasePooled(bufferRecycler7);
        JsonGenerator jsonGenerator12 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate13 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator12);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter14 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion15 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate17 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator12, tokenFilter14, inclusion15, true);
        filteringGeneratorDelegate17.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString19 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate17.writeFieldName((SerializableString) serializedString19);
        byte[] byteArray22 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        int int24 = serializedString19.appendQuotedUTF8(byteArray22, 256);
        // The following exception was thrown during execution in test generation
        try {
            bufferRecycler7.releaseByteBuffer((-2), byteArray22);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: index -2");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(boundedPool1);
        org.junit.Assert.assertNotNull(bufferRecycler2);
        org.junit.Assert.assertNotNull(boundedPool6);
        org.junit.Assert.assertNotNull(bufferRecycler7);
        org.junit.Assert.assertNotNull(serializedString19);
        org.junit.Assert.assertNotNull(byteArray22);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        String str0 = com.fasterxml.jackson.core.util.BufferRecyclers.SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers" + "'", str0, "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers");
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        byte[] byteArray17 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate5.writeRawUTF8String(byteArray17, 0, 2);
        com.fasterxml.jackson.core.io.SerializedString serializedString21 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        byte[] byteArray23 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload25 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray23, "");
        int int27 = serializedString21.appendQuotedUTF8(byteArray23, (int) (short) 0);
        byte[] byteArray28 = serializedString21.asUnquotedUTF8();
        filteringGeneratorDelegate5.writeRawUTF8String(byteArray28, (int) ' ', (int) (short) 100);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] {});
        org.junit.Assert.assertNotNull(serializedString21);
        org.junit.Assert.assertNotNull(byteArray23);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 1 + "'", int27 == 1);
        org.junit.Assert.assertNotNull(byteArray28);
        org.junit.Assert.assertArrayEquals(byteArray28, new byte[] { (byte) 32 });
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonToken jsonToken28 = jsonParserSequence24.getCurrentToken();
        JsonParser jsonParser29 = jsonParserSequence24.skipChildren();
        // The following exception was thrown during execution in test generation
        try {
            double double30 = jsonParserSequence24.getDoubleValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(jsonToken28);
        org.junit.Assert.assertNotNull(jsonParser29);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        boolean boolean27 = jsonParserSequence24.requiresCustomCodec();
        // The following exception was thrown during execution in test generation
        try {
            Number number28 = jsonParserSequence24.getNumberValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Version version28 = jsonParserSequence24.version();
        java.io.Writer writer29 = null;
        int int30 = jsonParserSequence24.getText(writer29);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNotNull(version28);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        char char3 = jsonFactoryBuilder0.quoteChar();
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + char3 + "' != '" + '\"' + "'", char3 == '\"');
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        int int2 = com.fasterxml.jackson.core.io.NumberInput.parseAsInt("10.0", 3);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 10 + "'", int2 == 10);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        byte[] byteArray17 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate5.writeRawUTF8String(byteArray17, 0, 2);
        char[] charArray26 = new char[] { 'a', '0', '0', '4', '4' };
        filteringGeneratorDelegate5.writeRaw(charArray26, 0, (int) '4');
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] {});
        org.junit.Assert.assertNotNull(charArray26);
        org.junit.Assert.assertArrayEquals(charArray26, new char[] { 'a', '0', '0', '4', '4' });
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        com.fasterxml.jackson.core.util.Separators separators0 = com.fasterxml.jackson.core.util.Separators.createDefaultInstance();
        com.fasterxml.jackson.core.util.Separators separators2 = separators0.withObjectEmptySeparator("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.Separators separators4 = separators2.withArrayEmptySeparator("500");
        com.fasterxml.jackson.core.util.Separators.Spacing spacing5 = separators2.getObjectFieldValueSpacing();
        org.junit.Assert.assertNotNull(separators0);
        org.junit.Assert.assertNotNull(separators2);
        org.junit.Assert.assertNotNull(separators4);
        org.junit.Assert.assertTrue("'" + spacing5 + "' != '" + com.fasterxml.jackson.core.util.Separators.Spacing.BOTH + "'", spacing5.equals(com.fasterxml.jackson.core.util.Separators.Spacing.BOTH));
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        boolean boolean27 = jsonParserSequence24.requiresCustomCodec();
        long long29 = jsonParserSequence24.getValueAsLong((long) 33);
        int int30 = jsonParserSequence24.getFormatFeatures();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + long29 + "' != '" + 33L + "'", long29 == 33L);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        JsonFactory jsonFactory1 = new JsonFactory(jsonFactoryBuilder0);
        StreamReadFeature streamReadFeature2 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean3 = jsonFactory1.isEnabled(streamReadFeature2);
        boolean boolean4 = streamReadFeature2.enabledByDefault();
        org.junit.Assert.assertTrue("'" + streamReadFeature2 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature2.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        boolean boolean27 = jsonParserSequence24.requiresCustomCodec();
        long long29 = jsonParserSequence24.getValueAsLong((long) 33);
        Object obj30 = jsonParserSequence24.getTypeId();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + long29 + "' != '" + 33L + "'", long29 == 33L);
        org.junit.Assert.assertNull(obj30);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeBoolean(true);
        filteringGeneratorDelegate5.writeNumberField("com.fasterxml.jackson.core.JsonParseException: hi!", (short) (byte) 1);
        JsonGenerator jsonGenerator12 = filteringGeneratorDelegate5.getDelegate();
        org.junit.Assert.assertNull(jsonGenerator12);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Object obj28 = jsonParserSequence24.getTypeId();
        boolean boolean29 = jsonParserSequence24.hasTextCharacters();
        Base64Variant base64Variant30 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray31 = jsonParserSequence24.getBinaryValue(base64Variant30);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(obj28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool16 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler17 = lockFreePool16.acquirePooled();
        boundedPool13.releasePooled(bufferRecycler17);
        com.fasterxml.jackson.core.util.TextBuffer textBuffer19 = new com.fasterxml.jackson.core.util.TextBuffer(bufferRecycler17);
        char[] charArray20 = textBuffer19.contentsAsArray();
        int int21 = textBuffer19.size();
        // The following exception was thrown during execution in test generation
        try {
            textBuffer19.append("500", (-2), 0);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: -2");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(lockFreePool16);
        org.junit.Assert.assertNotNull(bufferRecycler17);
        org.junit.Assert.assertNotNull(charArray20);
        org.junit.Assert.assertArrayEquals(charArray20, new char[] {});
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonGenerator jsonGenerator9 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate10 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator9);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter11 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion12 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate14 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator9, tokenFilter11, inclusion12, true);
        filteringGeneratorDelegate14.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        JsonFactory jsonFactory18 = new JsonFactory();
        boolean boolean19 = jsonFactory18.requiresCustomCodec();
        String str20 = jsonFactory18.getFormatName();
        char[] charArray24 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser25 = jsonFactory18.createParser(charArray24);
        JsonParser jsonParser27 = jsonParser25.setFeatureMask((int) '4');
        JsonFactory jsonFactory28 = new JsonFactory();
        boolean boolean29 = jsonFactory28.requiresCustomCodec();
        String str30 = jsonFactory28.getFormatName();
        char[] charArray34 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser35 = jsonFactory28.createParser(charArray34);
        JsonToken jsonToken36 = jsonParser35.getLastClearedToken();
        jsonParser35.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream39 = null;
        int int40 = jsonParser35.releaseBuffered(outputStream39);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence41 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser27, jsonParser35);
        boolean boolean42 = jsonParserSequence41.canParseAsync();
        double double44 = jsonParserSequence41.getValueAsDouble(0.0d);
        JsonParser jsonParser45 = jsonParserSequence41.skipChildren();
        filteringGeneratorDelegate14.writeObjectRef((Object) jsonParser45);
        JsonGenerator jsonGenerator47 = filteringGeneratorDelegate14.delegate();
        jsonReadContext6.setCurrentValue((Object) jsonGenerator47);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "JSON" + "'", str20, "JSON");
        org.junit.Assert.assertNotNull(charArray24);
        org.junit.Assert.assertArrayEquals(charArray24, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser25);
        org.junit.Assert.assertNotNull(jsonParser27);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "JSON" + "'", str30, "JSON");
        org.junit.Assert.assertNotNull(charArray34);
        org.junit.Assert.assertArrayEquals(charArray34, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser35);
        org.junit.Assert.assertNull(jsonToken36);
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + (-1) + "'", int40 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence41);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + double44 + "' != '" + 0.0d + "'", double44 == 0.0d);
        org.junit.Assert.assertNotNull(jsonParser45);
        org.junit.Assert.assertNull(jsonGenerator47);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        java.math.BigDecimal bigDecimal2 = com.fasterxml.jackson.core.io.NumberInput.parseBigDecimal("33.0", false);
        org.junit.Assert.assertNotNull(bigDecimal2);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        com.fasterxml.jackson.core.util.BufferRecyclers bufferRecyclers0 = new com.fasterxml.jackson.core.util.BufferRecyclers();
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.hasPathSegment();
        boolean boolean8 = jsonReadContext6.inObject();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer charsToNameCanonicalizer0 = com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.createRoot();
        int int1 = charsToNameCanonicalizer0.size();
        org.junit.Assert.assertNotNull(charsToNameCanonicalizer0);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Object obj28 = jsonParserSequence24.getObjectId();
        long long30 = jsonParserSequence24.getValueAsLong(1L);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(obj28);
        org.junit.Assert.assertTrue("'" + long30 + "' != '" + 1L + "'", long30 == 1L);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        com.fasterxml.jackson.core.util.JsonRecyclerPools jsonRecyclerPools0 = new com.fasterxml.jackson.core.util.JsonRecyclerPools();
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder6 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder8 = jsonFactoryBuilder6.disable(jsonReadFeature7);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature9 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray11 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature4, jsonReadFeature5, jsonReadFeature7, jsonReadFeature9, jsonReadFeature10 };
        JsonFactoryBuilder jsonFactoryBuilder12 = jsonFactoryBuilder0.disable(jsonReadFeature3, jsonReadFeatureArray11);
        boolean boolean13 = jsonReadFeature3.enabledByDefault();
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + jsonReadFeature3 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature3.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature4 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature4.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature5 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature5.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature7 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature7.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder8);
        org.junit.Assert.assertTrue("'" + jsonReadFeature9 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature9.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray11);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray11, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test289");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        com.fasterxml.jackson.core.util.InternCache internCache3 = com.fasterxml.jackson.core.util.InternCache.instance;
        JsonParser.NumberType numberType4 = JsonParser.NumberType.LONG;
        String str6 = internCache3.getOrDefault((Object) numberType4, "33.0");
        String str9 = internCache3.replace("100", "hi!");
        JsonGenerator.Feature feature10 = JsonGenerator.Feature.QUOTE_FIELD_NAMES;
        String str11 = internCache3.get((Object) feature10);
        JsonFactory jsonFactory12 = jsonFactory0.enable(feature10);
        StreamWriteConstraints streamWriteConstraints13 = jsonFactory0.streamWriteConstraints();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(internCache3);
        org.junit.Assert.assertTrue("'" + numberType4 + "' != '" + JsonParser.NumberType.LONG + "'", numberType4.equals(JsonParser.NumberType.LONG));
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "33.0" + "'", str6, "33.0");
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + JsonGenerator.Feature.QUOTE_FIELD_NAMES + "'", feature10.equals(JsonGenerator.Feature.QUOTE_FIELD_NAMES));
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNotNull(jsonFactory12);
        org.junit.Assert.assertNotNull(streamWriteConstraints13);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test290");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet27 = jsonParserSequence24.getReadCapabilities();
        // The following exception was thrown during execution in test generation
        try {
            int int28 = jsonParserSequence24.getIntValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet27);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test291");
        byte[] byteArray2 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder4 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray2, (-1));
        byteArrayBuilder4.flush();
        byteArrayBuilder4.close();
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder4);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test292");
        com.fasterxml.jackson.core.format.MatchStrength matchStrength0 = com.fasterxml.jackson.core.format.MatchStrength.SOLID_MATCH;
        org.junit.Assert.assertTrue("'" + matchStrength0 + "' != '" + com.fasterxml.jackson.core.format.MatchStrength.SOLID_MATCH + "'", matchStrength0.equals(com.fasterxml.jackson.core.format.MatchStrength.SOLID_MATCH));
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test293");
        com.fasterxml.jackson.core.io.ContentReference contentReference0 = com.fasterxml.jackson.core.io.ContentReference.unknown();
        org.junit.Assert.assertNotNull(contentReference0);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test294");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        jsonParser7.setCurrentValue((Object) '#');
        JsonParser jsonParser13 = jsonParser7.overrideStdFeatures((int) '4', (int) '4');
        int int15 = jsonParser13.getValueAsInt(33);
        FormatSchema formatSchema16 = jsonParser13.getSchema();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertNotNull(jsonParser13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 33 + "'", int15 == 33);
        org.junit.Assert.assertNull(formatSchema16);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test295");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        JsonPointer jsonPointer11 = JsonPointer.forPath((JsonStreamContext) jsonReadContext6, true);
        boolean boolean12 = jsonPointer11.matches();
        String str13 = jsonPointer11.toString();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertNotNull(jsonPointer11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "" + "'", str13, "");
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test296");
        com.fasterxml.jackson.core.util.DefaultPrettyPrinter defaultPrettyPrinter1 = new com.fasterxml.jackson.core.util.DefaultPrettyPrinter("?");
        JsonGenerator jsonGenerator2 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate3 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator2);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter4 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion5 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate7 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator2, tokenFilter4, inclusion5, true);
        filteringGeneratorDelegate7.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate7.writeFieldName("33.0");
        JsonGenerator jsonGenerator12 = filteringGeneratorDelegate7.delegate();
        JsonFactory jsonFactory14 = new JsonFactory();
        boolean boolean15 = jsonFactory14.requiresCustomCodec();
        String str16 = jsonFactory14.getFormatName();
        char[] charArray20 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser21 = jsonFactory14.createParser(charArray20);
        JsonParser jsonParser23 = jsonParser21.setFeatureMask((int) '4');
        JsonFactory jsonFactory24 = new JsonFactory();
        boolean boolean25 = jsonFactory24.requiresCustomCodec();
        String str26 = jsonFactory24.getFormatName();
        char[] charArray30 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser31 = jsonFactory24.createParser(charArray30);
        JsonToken jsonToken32 = jsonParser31.getLastClearedToken();
        jsonParser31.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream35 = null;
        int int36 = jsonParser31.releaseBuffered(outputStream35);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence37 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser23, jsonParser31);
        boolean boolean38 = jsonParserSequence37.canParseAsync();
        double double40 = jsonParserSequence37.getValueAsDouble(0.0d);
        Version version41 = jsonParserSequence37.version();
        filteringGeneratorDelegate7.writeStartObject((Object) version41);
        defaultPrettyPrinter1.beforeObjectEntries((JsonGenerator) filteringGeneratorDelegate7);
        org.junit.Assert.assertNull(jsonGenerator12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "JSON" + "'", str16, "JSON");
        org.junit.Assert.assertNotNull(charArray20);
        org.junit.Assert.assertArrayEquals(charArray20, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser21);
        org.junit.Assert.assertNotNull(jsonParser23);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "JSON" + "'", str26, "JSON");
        org.junit.Assert.assertNotNull(charArray30);
        org.junit.Assert.assertArrayEquals(charArray30, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser31);
        org.junit.Assert.assertNull(jsonToken32);
        org.junit.Assert.assertTrue("'" + int36 + "' != '" + (-1) + "'", int36 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + double40 + "' != '" + 0.0d + "'", double40 == 0.0d);
        org.junit.Assert.assertNotNull(version41);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test297");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonpCharacterEscapes jsonpCharacterEscapes16 = JsonpCharacterEscapes.instance();
        JsonFactory jsonFactory17 = jsonFactory0.setCharacterEscapes((com.fasterxml.jackson.core.io.CharacterEscapes) jsonpCharacterEscapes16);
        boolean boolean18 = jsonFactory0.requiresPropertyOrdering();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(jsonpCharacterEscapes16);
        org.junit.Assert.assertNotNull(jsonFactory17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test298");
        int[] intArray0 = com.fasterxml.jackson.core.io.CharTypes.getInputCodeUtf8JsNames();
        org.junit.Assert.assertNotNull(intArray0);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test299");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeFieldName("33.0");
        JsonGenerator jsonGenerator10 = filteringGeneratorDelegate5.delegate();
        JsonGenerator jsonGenerator11 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate12 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator11);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter13 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion14 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate16 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator11, tokenFilter13, inclusion14, true);
        filteringGeneratorDelegate16.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString18 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate16.writeFieldName((SerializableString) serializedString18);
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString18);
        byte[] byteArray21 = serializedString18.asUnquotedUTF8();
        org.junit.Assert.assertNull(jsonGenerator10);
        org.junit.Assert.assertNotNull(serializedString18);
        org.junit.Assert.assertNotNull(byteArray21);
        org.junit.Assert.assertArrayEquals(byteArray21, new byte[] { (byte) 32 });
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test300");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        jsonReadContext6.setCurrentValue((Object) '#');
        int int10 = jsonReadContext6.getNestingDepth();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test301");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonpCharacterEscapes jsonpCharacterEscapes16 = JsonpCharacterEscapes.instance();
        JsonFactory jsonFactory17 = jsonFactory0.setCharacterEscapes((com.fasterxml.jackson.core.io.CharacterEscapes) jsonpCharacterEscapes16);
        int[] intArray18 = jsonpCharacterEscapes16.getEscapeCodesForAscii();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(jsonpCharacterEscapes16);
        org.junit.Assert.assertNotNull(jsonFactory17);
        org.junit.Assert.assertNotNull(intArray18);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test302");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet27 = jsonParserSequence24.getReadCapabilities();
        StreamReadCapability streamReadCapability28 = StreamReadCapability.DUPLICATE_PROPERTIES;
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet29 = streamReadCapabilityJacksonFeatureSet27.with(streamReadCapability28);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet27);
        org.junit.Assert.assertTrue("'" + streamReadCapability28 + "' != '" + StreamReadCapability.DUPLICATE_PROPERTIES + "'", streamReadCapability28.equals(StreamReadCapability.DUPLICATE_PROPERTIES));
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet29);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test303");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        boolean boolean27 = jsonParserSequence24.requiresCustomCodec();
        int int29 = jsonParserSequence24.nextIntValue((int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            byte byte30 = jsonParserSequence24.getByteValue();
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (VALUE_STRING) not numeric, can not use numeric value accessors? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 2]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 10 + "'", int29 == 10);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test304");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        java.io.DataOutput dataOutput2 = null;
        JsonEncoding jsonEncoding3 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator4 = jsonFactory0.createGenerator(dataOutput2, jsonEncoding3);
        StreamWriteFeature streamWriteFeature5 = StreamWriteFeature.IGNORE_UNKNOWN;
        int int6 = streamWriteFeature5.getMask();
        boolean boolean7 = jsonFactory0.isEnabled(streamWriteFeature5);
        java.io.DataOutput dataOutput8 = null;
        JsonFactory jsonFactory9 = new JsonFactory();
        boolean boolean10 = jsonFactory9.requiresCustomCodec();
        java.io.DataOutput dataOutput11 = null;
        JsonEncoding jsonEncoding12 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator13 = jsonFactory9.createGenerator(dataOutput11, jsonEncoding12);
        JsonGenerator jsonGenerator14 = jsonFactory0.createGenerator(dataOutput8, jsonEncoding12);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + jsonEncoding3 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding3.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator4);
        org.junit.Assert.assertTrue("'" + streamWriteFeature5 + "' != '" + StreamWriteFeature.IGNORE_UNKNOWN + "'", streamWriteFeature5.equals(StreamWriteFeature.IGNORE_UNKNOWN));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 512 + "'", int6 == 512);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + jsonEncoding12 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding12.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator13);
        org.junit.Assert.assertNotNull(jsonGenerator14);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test305");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        java.io.Reader reader3 = null;
        JsonParser jsonParser4 = jsonFactory0.createParser(reader3);
        java.io.DataOutput dataOutput5 = null;
        JsonEncoding jsonEncoding6 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator7 = jsonFactory0.createGenerator(dataOutput5, jsonEncoding6);
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator8 = null;
        JsonFactory jsonFactory9 = jsonFactory0.setOutputDecorator(outputDecorator8);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(jsonParser4);
        org.junit.Assert.assertTrue("'" + jsonEncoding6 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding6.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator7);
        org.junit.Assert.assertNotNull(jsonFactory9);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test306");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        int int10 = jsonFactory0.getFormatGeneratorFeatures();
        com.fasterxml.jackson.core.io.SerializedString serializedString11 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        byte[] byteArray13 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload15 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray13, "");
        int int17 = serializedString11.appendQuotedUTF8(byteArray13, (int) (short) 0);
        byte[] byteArray18 = serializedString11.asUnquotedUTF8();
        JsonParser jsonParser19 = jsonFactory0.createParser(byteArray18);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(serializedString11);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 1 + "'", int17 == 1);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 32 });
        org.junit.Assert.assertNotNull(jsonParser19);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test307");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        FormatSchema formatSchema3 = null;
        boolean boolean4 = jsonFactory0.canUseSchema(formatSchema3);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test308");
        JsonLocation jsonLocation1 = null;
        JsonParseException jsonParseException2 = new JsonParseException("hi!", jsonLocation1);
        JsonParser jsonParser3 = null;
        JsonParseException jsonParseException4 = jsonParseException2.withParser(jsonParser3);
        JsonLocation jsonLocation6 = null;
        JsonParseException jsonParseException7 = new JsonParseException("hi!", jsonLocation6);
        jsonParseException4.addSuppressed((Throwable) jsonParseException7);
        jsonParseException7.clearLocation();
        jsonParseException7.clearLocation();
        JsonGenerator jsonGenerator11 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate12 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator11);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter13 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion14 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate16 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator11, tokenFilter13, inclusion14, true);
        filteringGeneratorDelegate16.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate16.writeRaw("33.0");
        Base64Variant base64Variant21 = null;
        java.io.InputStream inputStream22 = null;
        int int24 = filteringGeneratorDelegate16.writeBinary(base64Variant21, inputStream22, (int) (byte) -17);
        java.io.Reader reader25 = null;
        filteringGeneratorDelegate16.writeString(reader25, (int) '4');
        JsonGenerationException jsonGenerationException28 = new JsonGenerationException((Throwable) jsonParseException7, (JsonGenerator) filteringGeneratorDelegate16);
        String str29 = jsonGenerationException28.getOriginalMessage();
        org.junit.Assert.assertNotNull(jsonParseException4);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
        org.junit.Assert.assertNull(str29);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test309");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        JsonToken jsonToken25 = JsonToken.VALUE_EMBEDDED_OBJECT;
        com.fasterxml.jackson.core.type.WritableTypeId writableTypeId26 = new com.fasterxml.jackson.core.type.WritableTypeId((Object) true, jsonToken25);
        Object obj27 = writableTypeId26.forValue;
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + jsonToken25 + "' != '" + JsonToken.VALUE_EMBEDDED_OBJECT + "'", jsonToken25.equals(JsonToken.VALUE_EMBEDDED_OBJECT));
        org.junit.Assert.assertEquals("'" + obj27 + "' != '" + true + "'", obj27, true);
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test310");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamWriteConstraints streamWriteConstraints2 = jsonFactory0.streamWriteConstraints();
        int int3 = jsonFactory0.getFormatParserFeatures();
        java.io.Writer writer4 = null;
        JsonGenerator jsonGenerator5 = jsonFactory0.createGenerator(writer4);
        boolean boolean6 = jsonFactory0.canUseCharArrays();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(jsonGenerator5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test311");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet26 = jsonParserSequence24.getReadCapabilities();
        StreamReadCapability streamReadCapability27 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean28 = streamReadCapabilityJacksonFeatureSet26.isEnabled(streamReadCapability27);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet26);
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test312");
        ObjectCodec objectCodec0 = null;
        JsonFactory jsonFactory1 = new JsonFactory(objectCodec0);
        String str2 = jsonFactory1.getFormatName();
        JsonFactoryBuilder jsonFactoryBuilder3 = new JsonFactoryBuilder();
        JsonFactory jsonFactory4 = new JsonFactory(jsonFactoryBuilder3);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool6 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder7 = jsonFactoryBuilder3.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool6);
        JsonFactory.Feature feature8 = JsonFactory.Feature.INTERN_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder10 = jsonFactoryBuilder3.configure(feature8, true);
        boolean boolean11 = jsonFactory1.isEnabled(feature8);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(boundedPool6);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder7);
        org.junit.Assert.assertTrue("'" + feature8 + "' != '" + JsonFactory.Feature.INTERN_FIELD_NAMES + "'", feature8.equals(JsonFactory.Feature.INTERN_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test313");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        String str10 = jsonReadContext6.typeDesc();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "?" + "'", str10, "?");
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test314");
        JsonLocation jsonLocation2 = null;
        JsonParseException jsonParseException3 = new JsonParseException("hi!", jsonLocation2);
        JsonParser jsonParser4 = null;
        JsonParseException jsonParseException5 = jsonParseException3.withParser(jsonParser4);
        JsonLocation jsonLocation7 = null;
        JsonParseException jsonParseException8 = new JsonParseException("hi!", jsonLocation7);
        jsonParseException5.addSuppressed((Throwable) jsonParseException8);
        jsonParseException8.clearLocation();
        JsonGenerator jsonGenerator11 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate12 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator11);
        JsonGenerationException jsonGenerationException13 = new JsonGenerationException("", (Throwable) jsonParseException8, jsonGenerator11);
        String str14 = jsonGenerationException13.toString();
        org.junit.Assert.assertNotNull(jsonParseException5);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "com.fasterxml.jackson.core.JsonGenerationException: " + "'", str14, "com.fasterxml.jackson.core.JsonGenerationException: ");
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test315");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory.Feature feature15 = JsonFactory.Feature.INTERN_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder16 = jsonFactoryBuilder10.disable(feature15);
        JsonFactory jsonFactory17 = jsonFactory0.enable(feature15);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + feature15 + "' != '" + JsonFactory.Feature.INTERN_FIELD_NAMES + "'", feature15.equals(JsonFactory.Feature.INTERN_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder16);
        org.junit.Assert.assertNotNull(jsonFactory17);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test316");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonParser.Feature feature8 = JsonParser.Feature.ALLOW_YAML_COMMENTS;
        boolean boolean9 = jsonFactory0.isEnabled(feature8);
        byte[] byteArray11 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.RequestPayload requestPayload13 = new com.fasterxml.jackson.core.util.RequestPayload(byteArray11, "");
        JsonParser jsonParser14 = jsonFactory0.createParser(byteArray11);
        ObjectCodec objectCodec15 = jsonParser14.getCodec();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertTrue("'" + feature8 + "' != '" + JsonParser.Feature.ALLOW_YAML_COMMENTS + "'", feature8.equals(JsonParser.Feature.ALLOW_YAML_COMMENTS));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertNotNull(jsonParser14);
        org.junit.Assert.assertNull(objectCodec15);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test317");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeRaw("33.0");
        filteringGeneratorDelegate5.writeNumber((long) 33);
        filteringGeneratorDelegate5.writeStartArray((Object) 0.0d, (int) ' ');
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test318");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool16 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler17 = lockFreePool16.acquirePooled();
        boundedPool13.releasePooled(bufferRecycler17);
        com.fasterxml.jackson.core.util.TextBuffer textBuffer19 = new com.fasterxml.jackson.core.util.TextBuffer(bufferRecycler17);
        char[] charArray20 = textBuffer19.contentsAsArray();
        int int21 = textBuffer19.size();
        char[] charArray22 = textBuffer19.getCurrentSegment();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(lockFreePool16);
        org.junit.Assert.assertNotNull(bufferRecycler17);
        org.junit.Assert.assertNotNull(charArray20);
        org.junit.Assert.assertArrayEquals(charArray20, new char[] {});
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(charArray22);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test319");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        Version version28 = jsonParserSequence24.version();
        String str29 = jsonParserSequence24.getText();
        long long31 = jsonParserSequence24.getValueAsLong((long) (byte) -65);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNotNull(version28);
        org.junit.Assert.assertNull(str29);
        org.junit.Assert.assertTrue("'" + long31 + "' != '" + (-65L) + "'", long31 == (-65L));
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test320");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        JsonPointer jsonPointer11 = jsonPointer9.matchProperty("33.0");
        // The following exception was thrown during execution in test generation
        try {
            JsonPointer jsonPointer13 = jsonPointer11.matchElement(2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertNull(jsonPointer11);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test321");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        StreamReadFeature streamReadFeature3 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean4 = streamReadFeature3.enabledByDefault();
        JsonFactoryBuilder jsonFactoryBuilder5 = new JsonFactoryBuilder();
        JsonFactory jsonFactory6 = new JsonFactory(jsonFactoryBuilder5);
        StreamReadFeature streamReadFeature7 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean8 = jsonFactory6.isEnabled(streamReadFeature7);
        JsonFactoryBuilder jsonFactoryBuilder9 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder11 = jsonFactoryBuilder9.disable(jsonReadFeature10);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature12 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature13 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature14 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder15 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature16 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder17 = jsonFactoryBuilder15.disable(jsonReadFeature16);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature18 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature19 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray20 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature13, jsonReadFeature14, jsonReadFeature16, jsonReadFeature18, jsonReadFeature19 };
        JsonFactoryBuilder jsonFactoryBuilder21 = jsonFactoryBuilder9.disable(jsonReadFeature12, jsonReadFeatureArray20);
        JsonFactoryBuilder jsonFactoryBuilder22 = new JsonFactoryBuilder();
        JsonFactory jsonFactory23 = new JsonFactory(jsonFactoryBuilder22);
        StreamReadFeature streamReadFeature24 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean25 = jsonFactory23.isEnabled(streamReadFeature24);
        JsonFactoryBuilder jsonFactoryBuilder26 = jsonFactoryBuilder21.disable(streamReadFeature24);
        JsonFactoryBuilder jsonFactoryBuilder27 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature28 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder29 = jsonFactoryBuilder27.disable(jsonReadFeature28);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature30 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature31 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature32 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder33 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature34 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder35 = jsonFactoryBuilder33.disable(jsonReadFeature34);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature36 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature37 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray38 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature31, jsonReadFeature32, jsonReadFeature34, jsonReadFeature36, jsonReadFeature37 };
        JsonFactoryBuilder jsonFactoryBuilder39 = jsonFactoryBuilder27.disable(jsonReadFeature30, jsonReadFeatureArray38);
        JsonFactoryBuilder jsonFactoryBuilder40 = new JsonFactoryBuilder();
        JsonFactory jsonFactory41 = new JsonFactory(jsonFactoryBuilder40);
        StreamReadFeature streamReadFeature42 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean43 = jsonFactory41.isEnabled(streamReadFeature42);
        JsonFactoryBuilder jsonFactoryBuilder44 = jsonFactoryBuilder39.disable(streamReadFeature42);
        JsonFactoryBuilder jsonFactoryBuilder45 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature46 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder47 = jsonFactoryBuilder45.disable(jsonReadFeature46);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature48 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature49 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature50 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder51 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature52 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder53 = jsonFactoryBuilder51.disable(jsonReadFeature52);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature54 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature55 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray56 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature49, jsonReadFeature50, jsonReadFeature52, jsonReadFeature54, jsonReadFeature55 };
        JsonFactoryBuilder jsonFactoryBuilder57 = jsonFactoryBuilder45.disable(jsonReadFeature48, jsonReadFeatureArray56);
        JsonFactoryBuilder jsonFactoryBuilder58 = new JsonFactoryBuilder();
        JsonFactory jsonFactory59 = new JsonFactory(jsonFactoryBuilder58);
        StreamReadFeature streamReadFeature60 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean61 = jsonFactory59.isEnabled(streamReadFeature60);
        JsonFactoryBuilder jsonFactoryBuilder62 = jsonFactoryBuilder57.disable(streamReadFeature60);
        JsonFactoryBuilder jsonFactoryBuilder63 = new JsonFactoryBuilder();
        JsonFactory jsonFactory64 = new JsonFactory(jsonFactoryBuilder63);
        StreamReadFeature streamReadFeature65 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean66 = jsonFactory64.isEnabled(streamReadFeature65);
        StreamReadFeature streamReadFeature67 = StreamReadFeature.IGNORE_UNDEFINED;
        StreamReadFeature[] streamReadFeatureArray68 = new StreamReadFeature[] { streamReadFeature7, streamReadFeature24, streamReadFeature42, streamReadFeature60, streamReadFeature65, streamReadFeature67 };
        JsonFactoryBuilder jsonFactoryBuilder69 = jsonFactoryBuilder2.enable(streamReadFeature3, streamReadFeatureArray68);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature70 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS;
        int int71 = jsonReadFeature70.getMask();
        JsonFactoryBuilder jsonFactoryBuilder72 = jsonFactoryBuilder2.disable(jsonReadFeature70);
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + streamReadFeature3 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature3.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + streamReadFeature7 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature7.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder11);
        org.junit.Assert.assertTrue("'" + jsonReadFeature12 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature12.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature13 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature13.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature14 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature14.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature16 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature16.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + jsonReadFeature18 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature18.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature19 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature19.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray20);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray20, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder21);
        org.junit.Assert.assertTrue("'" + streamReadFeature24 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature24.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder26);
        org.junit.Assert.assertTrue("'" + jsonReadFeature28 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature28.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder29);
        org.junit.Assert.assertTrue("'" + jsonReadFeature30 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature30.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature31 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature31.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature32 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature32.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature34 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature34.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder35);
        org.junit.Assert.assertTrue("'" + jsonReadFeature36 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature36.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature37 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature37.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray38);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray38, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder39);
        org.junit.Assert.assertTrue("'" + streamReadFeature42 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature42.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder44);
        org.junit.Assert.assertTrue("'" + jsonReadFeature46 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature46.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder47);
        org.junit.Assert.assertTrue("'" + jsonReadFeature48 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature48.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature49 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature49.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature50 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature50.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature52 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature52.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder53);
        org.junit.Assert.assertTrue("'" + jsonReadFeature54 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature54.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature55 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature55.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray56);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray56, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder57);
        org.junit.Assert.assertTrue("'" + streamReadFeature60 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature60.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder62);
        org.junit.Assert.assertTrue("'" + streamReadFeature65 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature65.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertTrue("'" + streamReadFeature67 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature67.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertNotNull(streamReadFeatureArray68);
        org.junit.Assert.assertArrayEquals(streamReadFeatureArray68, new StreamReadFeature[] { StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder69);
        org.junit.Assert.assertTrue("'" + jsonReadFeature70 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS + "'", jsonReadFeature70.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + int71 + "' != '" + 128 + "'", int71 == 128);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder72);
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test322");
        com.fasterxml.jackson.core.util.InternCache internCache0 = com.fasterxml.jackson.core.util.InternCache.instance;
        java.util.Enumeration<String> strEnumeration1 = internCache0.elements();
        org.junit.Assert.assertNotNull(internCache0);
        org.junit.Assert.assertNotNull(strEnumeration1);
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test323");
        JsonLocation jsonLocation1 = null;
        JsonParseException jsonParseException2 = new JsonParseException("hi!", jsonLocation1);
        JsonParser jsonParser3 = null;
        JsonParseException jsonParseException4 = jsonParseException2.withParser(jsonParser3);
        JsonLocation jsonLocation6 = null;
        JsonParseException jsonParseException7 = new JsonParseException("hi!", jsonLocation6);
        jsonParseException4.addSuppressed((Throwable) jsonParseException7);
        jsonParseException7.clearLocation();
        jsonParseException7.clearLocation();
        JsonGenerator jsonGenerator11 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate12 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator11);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter13 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion14 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate16 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator11, tokenFilter13, inclusion14, true);
        filteringGeneratorDelegate16.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate16.writeRaw("33.0");
        Base64Variant base64Variant21 = null;
        java.io.InputStream inputStream22 = null;
        int int24 = filteringGeneratorDelegate16.writeBinary(base64Variant21, inputStream22, (int) (byte) -17);
        java.io.Reader reader25 = null;
        filteringGeneratorDelegate16.writeString(reader25, (int) '4');
        JsonGenerationException jsonGenerationException28 = new JsonGenerationException((Throwable) jsonParseException7, (JsonGenerator) filteringGeneratorDelegate16);
        JsonGenerator jsonGenerator29 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate30 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator29);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter31 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion32 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate34 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator29, tokenFilter31, inclusion32, true);
        filteringGeneratorDelegate34.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate34.writeFieldName("33.0");
        JsonGenerationException jsonGenerationException39 = jsonGenerationException28.withGenerator((JsonGenerator) filteringGeneratorDelegate34);
        filteringGeneratorDelegate34.writeNumber("root");
        org.junit.Assert.assertNotNull(jsonParseException4);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
        org.junit.Assert.assertNotNull(jsonGenerationException39);
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test324");
        JsonGenerator.Feature feature0 = JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS + "'", feature0.equals(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS));
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test325");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonToken jsonToken28 = jsonParserSequence24.getCurrentToken();
        JsonParser jsonParser29 = jsonParserSequence24.skipChildren();
        JsonGenerator jsonGenerator30 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate31 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator30);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter32 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion33 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate35 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator30, tokenFilter32, inclusion33, true);
        filteringGeneratorDelegate35.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate35.writeFieldName("33.0");
        JsonGenerator jsonGenerator40 = filteringGeneratorDelegate35.delegate();
        JsonGenerator jsonGenerator41 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate42 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator41);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter43 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion44 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate46 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator41, tokenFilter43, inclusion44, true);
        filteringGeneratorDelegate46.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString48 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate46.writeFieldName((SerializableString) serializedString48);
        filteringGeneratorDelegate35.writeFieldName((SerializableString) serializedString48);
        boolean boolean51 = jsonParserSequence24.nextFieldName((SerializableString) serializedString48);
        FormatSchema formatSchema52 = jsonParserSequence24.getSchema();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(jsonToken28);
        org.junit.Assert.assertNotNull(jsonParser29);
        org.junit.Assert.assertNull(jsonGenerator40);
        org.junit.Assert.assertNotNull(serializedString48);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertNull(formatSchema52);
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test326");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeBoolean(true);
        filteringGeneratorDelegate5.writeNumberField("com.fasterxml.jackson.core.JsonParseException: hi!", (short) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            int int12 = filteringGeneratorDelegate5.getFeatureMask();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test327");
        String str2 = com.fasterxml.jackson.core.io.NumberOutput.toString((double) '\"', true);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "34.0" + "'", str2, "34.0");
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test328");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        byte[] byteArray3 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("hi!");
        JsonParser jsonParser4 = jsonFactory0.createJsonParser(byteArray3);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 104, (byte) 105, (byte) 33 });
        org.junit.Assert.assertNotNull(jsonParser4);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test329");
        int int0 = com.fasterxml.jackson.core.util.RecyclerPool.BoundedPoolBase.DEFAULT_CAPACITY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 100 + "'", int0 == 100);
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test330");
        com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter nopIndenter0 = com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter.instance;
        org.junit.Assert.assertNotNull(nopIndenter0);
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test331");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        Version version8 = jsonFactory0.version();
        boolean boolean9 = jsonFactory0.canParseAsync();
        com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerRecyclerPool10 = jsonFactory0._getRecyclerPool();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNotNull(version8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(bufferRecyclerRecyclerPool10);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test332");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        double double27 = jsonParserSequence24.getValueAsDouble(0.0d);
        JsonToken jsonToken28 = jsonParserSequence24.getCurrentToken();
        JsonParser jsonParser29 = jsonParserSequence24.skipChildren();
        int int30 = jsonParser29.getTextLength();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + double27 + "' != '" + 0.0d + "'", double27 == 0.0d);
        org.junit.Assert.assertNull(jsonToken28);
        org.junit.Assert.assertNotNull(jsonParser29);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test333");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        JsonParser jsonParser26 = jsonParserSequence24.delegate();
        com.fasterxml.jackson.core.util.JacksonFeatureSet<StreamReadCapability> streamReadCapabilityJacksonFeatureSet27 = jsonParserSequence24.getReadCapabilities();
        JsonParser jsonParser28 = jsonParserSequence24.delegate();
        jsonParserSequence24.finishToken();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNotNull(streamReadCapabilityJacksonFeatureSet27);
        org.junit.Assert.assertNotNull(jsonParser28);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test334");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        StreamReadFeature streamReadFeature3 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean4 = streamReadFeature3.enabledByDefault();
        JsonFactoryBuilder jsonFactoryBuilder5 = new JsonFactoryBuilder();
        JsonFactory jsonFactory6 = new JsonFactory(jsonFactoryBuilder5);
        StreamReadFeature streamReadFeature7 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean8 = jsonFactory6.isEnabled(streamReadFeature7);
        JsonFactoryBuilder jsonFactoryBuilder9 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder11 = jsonFactoryBuilder9.disable(jsonReadFeature10);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature12 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature13 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature14 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder15 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature16 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder17 = jsonFactoryBuilder15.disable(jsonReadFeature16);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature18 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature19 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray20 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature13, jsonReadFeature14, jsonReadFeature16, jsonReadFeature18, jsonReadFeature19 };
        JsonFactoryBuilder jsonFactoryBuilder21 = jsonFactoryBuilder9.disable(jsonReadFeature12, jsonReadFeatureArray20);
        JsonFactoryBuilder jsonFactoryBuilder22 = new JsonFactoryBuilder();
        JsonFactory jsonFactory23 = new JsonFactory(jsonFactoryBuilder22);
        StreamReadFeature streamReadFeature24 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean25 = jsonFactory23.isEnabled(streamReadFeature24);
        JsonFactoryBuilder jsonFactoryBuilder26 = jsonFactoryBuilder21.disable(streamReadFeature24);
        JsonFactoryBuilder jsonFactoryBuilder27 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature28 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder29 = jsonFactoryBuilder27.disable(jsonReadFeature28);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature30 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature31 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature32 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder33 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature34 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder35 = jsonFactoryBuilder33.disable(jsonReadFeature34);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature36 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature37 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray38 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature31, jsonReadFeature32, jsonReadFeature34, jsonReadFeature36, jsonReadFeature37 };
        JsonFactoryBuilder jsonFactoryBuilder39 = jsonFactoryBuilder27.disable(jsonReadFeature30, jsonReadFeatureArray38);
        JsonFactoryBuilder jsonFactoryBuilder40 = new JsonFactoryBuilder();
        JsonFactory jsonFactory41 = new JsonFactory(jsonFactoryBuilder40);
        StreamReadFeature streamReadFeature42 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean43 = jsonFactory41.isEnabled(streamReadFeature42);
        JsonFactoryBuilder jsonFactoryBuilder44 = jsonFactoryBuilder39.disable(streamReadFeature42);
        JsonFactoryBuilder jsonFactoryBuilder45 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature46 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder47 = jsonFactoryBuilder45.disable(jsonReadFeature46);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature48 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature49 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature50 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder51 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature52 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder53 = jsonFactoryBuilder51.disable(jsonReadFeature52);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature54 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature55 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray56 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature49, jsonReadFeature50, jsonReadFeature52, jsonReadFeature54, jsonReadFeature55 };
        JsonFactoryBuilder jsonFactoryBuilder57 = jsonFactoryBuilder45.disable(jsonReadFeature48, jsonReadFeatureArray56);
        JsonFactoryBuilder jsonFactoryBuilder58 = new JsonFactoryBuilder();
        JsonFactory jsonFactory59 = new JsonFactory(jsonFactoryBuilder58);
        StreamReadFeature streamReadFeature60 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean61 = jsonFactory59.isEnabled(streamReadFeature60);
        JsonFactoryBuilder jsonFactoryBuilder62 = jsonFactoryBuilder57.disable(streamReadFeature60);
        JsonFactoryBuilder jsonFactoryBuilder63 = new JsonFactoryBuilder();
        JsonFactory jsonFactory64 = new JsonFactory(jsonFactoryBuilder63);
        StreamReadFeature streamReadFeature65 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean66 = jsonFactory64.isEnabled(streamReadFeature65);
        StreamReadFeature streamReadFeature67 = StreamReadFeature.IGNORE_UNDEFINED;
        StreamReadFeature[] streamReadFeatureArray68 = new StreamReadFeature[] { streamReadFeature7, streamReadFeature24, streamReadFeature42, streamReadFeature60, streamReadFeature65, streamReadFeature67 };
        JsonFactoryBuilder jsonFactoryBuilder69 = jsonFactoryBuilder2.enable(streamReadFeature3, streamReadFeatureArray68);
        JsonFactoryBuilder jsonFactoryBuilder70 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature71 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder72 = jsonFactoryBuilder70.disable(jsonReadFeature71);
        JsonFactoryBuilder jsonFactoryBuilder73 = jsonFactoryBuilder69.enable(jsonReadFeature71);
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + streamReadFeature3 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature3.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + streamReadFeature7 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature7.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder11);
        org.junit.Assert.assertTrue("'" + jsonReadFeature12 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature12.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature13 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature13.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature14 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature14.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature16 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature16.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + jsonReadFeature18 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature18.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature19 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature19.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray20);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray20, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder21);
        org.junit.Assert.assertTrue("'" + streamReadFeature24 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature24.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder26);
        org.junit.Assert.assertTrue("'" + jsonReadFeature28 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature28.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder29);
        org.junit.Assert.assertTrue("'" + jsonReadFeature30 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature30.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature31 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature31.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature32 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature32.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature34 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature34.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder35);
        org.junit.Assert.assertTrue("'" + jsonReadFeature36 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature36.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature37 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature37.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray38);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray38, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder39);
        org.junit.Assert.assertTrue("'" + streamReadFeature42 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature42.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder44);
        org.junit.Assert.assertTrue("'" + jsonReadFeature46 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature46.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder47);
        org.junit.Assert.assertTrue("'" + jsonReadFeature48 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature48.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature49 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature49.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature50 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature50.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature52 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature52.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder53);
        org.junit.Assert.assertTrue("'" + jsonReadFeature54 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature54.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature55 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature55.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray56);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray56, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder57);
        org.junit.Assert.assertTrue("'" + streamReadFeature60 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature60.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder62);
        org.junit.Assert.assertTrue("'" + streamReadFeature65 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature65.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertTrue("'" + streamReadFeature67 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature67.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertNotNull(streamReadFeatureArray68);
        org.junit.Assert.assertArrayEquals(streamReadFeatureArray68, new StreamReadFeature[] { StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder69);
        org.junit.Assert.assertTrue("'" + jsonReadFeature71 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature71.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder72);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder73);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test335");
        int int0 = com.fasterxml.jackson.core.base.GeneratorBase.SURR1_FIRST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 55296 + "'", int0 == 55296);
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test336");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder6 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder8 = jsonFactoryBuilder6.disable(jsonReadFeature7);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature9 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray11 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature4, jsonReadFeature5, jsonReadFeature7, jsonReadFeature9, jsonReadFeature10 };
        JsonFactoryBuilder jsonFactoryBuilder12 = jsonFactoryBuilder0.disable(jsonReadFeature3, jsonReadFeatureArray11);
        com.fasterxml.jackson.core.util.JsonGeneratorDecorator jsonGeneratorDecorator13 = null;
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder0.addDecorator(jsonGeneratorDecorator13);
        com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerRecyclerPool15 = jsonFactoryBuilder0.recyclerPool();
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + jsonReadFeature3 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature3.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature4 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature4.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature5 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature5.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature7 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature7.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder8);
        org.junit.Assert.assertTrue("'" + jsonReadFeature9 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature9.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray11);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray11, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder12);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(bufferRecyclerRecyclerPool15);
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test337");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        java.io.Reader reader3 = null;
        JsonParser jsonParser4 = jsonFactory0.createParser(reader3);
        java.io.DataOutput dataOutput5 = null;
        JsonEncoding jsonEncoding6 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator7 = jsonFactory0.createGenerator(dataOutput5, jsonEncoding6);
        java.io.Reader reader8 = null;
        // The following exception was thrown during execution in test generation
        try {
            jsonGenerator7.writeString(reader8, 2);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonGenerationException; message: null reader");
        } catch (JsonGenerationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(jsonParser4);
        org.junit.Assert.assertTrue("'" + jsonEncoding6 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding6.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator7);
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test338");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        java.io.Reader reader3 = null;
        JsonParser jsonParser4 = jsonFactory0.createParser(reader3);
        java.io.DataOutput dataOutput5 = null;
        JsonEncoding jsonEncoding6 = JsonEncoding.UTF32_BE;
        JsonGenerator jsonGenerator7 = jsonFactory0.createGenerator(dataOutput5, jsonEncoding6);
        jsonGenerator7.close();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(jsonParser4);
        org.junit.Assert.assertTrue("'" + jsonEncoding6 + "' != '" + JsonEncoding.UTF32_BE + "'", jsonEncoding6.equals(JsonEncoding.UTF32_BE));
        org.junit.Assert.assertNotNull(jsonGenerator7);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test339");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        java.io.InputStream inputStream1 = null;
        byte[] byteArray3 = com.fasterxml.jackson.core.util.BufferRecyclers.encodeAsUTF8("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.io.MergedStream mergedStream6 = new com.fasterxml.jackson.core.io.MergedStream(iOContext0, inputStream1, byteArray3, 0, (int) (short) 0);
        org.junit.Assert.assertNotNull(byteArray3);
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test340");
        // The following exception was thrown during execution in test generation
        try {
            float float1 = com.fasterxml.jackson.core.io.NumberInput.parseFloat("com.fasterxml.jackson.core.JsonParseException: 33.0\n at [Source: (Byte); line: 52, column: 256]");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"com.fasterxml.jackson.core.JsonParseException: 33.0? at [Source: (Byte); line: 52, column: 256]\"");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test341");
        JsonGenerationException jsonGenerationException1 = new JsonGenerationException("com.fasterxml.jackson.core.JsonParseException: hi!");
        JsonGenerator jsonGenerator2 = jsonGenerationException1.getProcessor();
        org.junit.Assert.assertNull(jsonGenerator2);
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test342");
        com.fasterxml.jackson.core.util.Separators separators0 = com.fasterxml.jackson.core.util.Separators.createDefaultInstance();
        com.fasterxml.jackson.core.util.Separators separators2 = separators0.withObjectEmptySeparator("com.fasterxml.jackson.core.JsonParseException: hi!");
        com.fasterxml.jackson.core.util.Separators separators4 = separators0.withRootSeparator("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers");
        org.junit.Assert.assertNotNull(separators0);
        org.junit.Assert.assertNotNull(separators2);
        org.junit.Assert.assertNotNull(separators4);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test343");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature1 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder2 = jsonFactoryBuilder0.disable(jsonReadFeature1);
        StreamReadFeature streamReadFeature3 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean4 = streamReadFeature3.enabledByDefault();
        JsonFactoryBuilder jsonFactoryBuilder5 = new JsonFactoryBuilder();
        JsonFactory jsonFactory6 = new JsonFactory(jsonFactoryBuilder5);
        StreamReadFeature streamReadFeature7 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean8 = jsonFactory6.isEnabled(streamReadFeature7);
        JsonFactoryBuilder jsonFactoryBuilder9 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature10 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder11 = jsonFactoryBuilder9.disable(jsonReadFeature10);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature12 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature13 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature14 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder15 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature16 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder17 = jsonFactoryBuilder15.disable(jsonReadFeature16);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature18 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature19 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray20 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature13, jsonReadFeature14, jsonReadFeature16, jsonReadFeature18, jsonReadFeature19 };
        JsonFactoryBuilder jsonFactoryBuilder21 = jsonFactoryBuilder9.disable(jsonReadFeature12, jsonReadFeatureArray20);
        JsonFactoryBuilder jsonFactoryBuilder22 = new JsonFactoryBuilder();
        JsonFactory jsonFactory23 = new JsonFactory(jsonFactoryBuilder22);
        StreamReadFeature streamReadFeature24 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean25 = jsonFactory23.isEnabled(streamReadFeature24);
        JsonFactoryBuilder jsonFactoryBuilder26 = jsonFactoryBuilder21.disable(streamReadFeature24);
        JsonFactoryBuilder jsonFactoryBuilder27 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature28 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder29 = jsonFactoryBuilder27.disable(jsonReadFeature28);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature30 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature31 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature32 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder33 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature34 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder35 = jsonFactoryBuilder33.disable(jsonReadFeature34);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature36 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature37 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray38 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature31, jsonReadFeature32, jsonReadFeature34, jsonReadFeature36, jsonReadFeature37 };
        JsonFactoryBuilder jsonFactoryBuilder39 = jsonFactoryBuilder27.disable(jsonReadFeature30, jsonReadFeatureArray38);
        JsonFactoryBuilder jsonFactoryBuilder40 = new JsonFactoryBuilder();
        JsonFactory jsonFactory41 = new JsonFactory(jsonFactoryBuilder40);
        StreamReadFeature streamReadFeature42 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean43 = jsonFactory41.isEnabled(streamReadFeature42);
        JsonFactoryBuilder jsonFactoryBuilder44 = jsonFactoryBuilder39.disable(streamReadFeature42);
        JsonFactoryBuilder jsonFactoryBuilder45 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature46 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder47 = jsonFactoryBuilder45.disable(jsonReadFeature46);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature48 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature49 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature50 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        JsonFactoryBuilder jsonFactoryBuilder51 = new JsonFactoryBuilder();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature52 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        JsonFactoryBuilder jsonFactoryBuilder53 = jsonFactoryBuilder51.disable(jsonReadFeature52);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature54 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature55 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray56 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature49, jsonReadFeature50, jsonReadFeature52, jsonReadFeature54, jsonReadFeature55 };
        JsonFactoryBuilder jsonFactoryBuilder57 = jsonFactoryBuilder45.disable(jsonReadFeature48, jsonReadFeatureArray56);
        JsonFactoryBuilder jsonFactoryBuilder58 = new JsonFactoryBuilder();
        JsonFactory jsonFactory59 = new JsonFactory(jsonFactoryBuilder58);
        StreamReadFeature streamReadFeature60 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean61 = jsonFactory59.isEnabled(streamReadFeature60);
        JsonFactoryBuilder jsonFactoryBuilder62 = jsonFactoryBuilder57.disable(streamReadFeature60);
        JsonFactoryBuilder jsonFactoryBuilder63 = new JsonFactoryBuilder();
        JsonFactory jsonFactory64 = new JsonFactory(jsonFactoryBuilder63);
        StreamReadFeature streamReadFeature65 = StreamReadFeature.IGNORE_UNDEFINED;
        boolean boolean66 = jsonFactory64.isEnabled(streamReadFeature65);
        StreamReadFeature streamReadFeature67 = StreamReadFeature.IGNORE_UNDEFINED;
        StreamReadFeature[] streamReadFeatureArray68 = new StreamReadFeature[] { streamReadFeature7, streamReadFeature24, streamReadFeature42, streamReadFeature60, streamReadFeature65, streamReadFeature67 };
        JsonFactoryBuilder jsonFactoryBuilder69 = jsonFactoryBuilder2.enable(streamReadFeature3, streamReadFeatureArray68);
        com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerRecyclerPool70 = jsonFactoryBuilder2.recyclerPool();
        org.junit.Assert.assertTrue("'" + jsonReadFeature1 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature1.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + streamReadFeature3 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature3.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + streamReadFeature7 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature7.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + jsonReadFeature10 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature10.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder11);
        org.junit.Assert.assertTrue("'" + jsonReadFeature12 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature12.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature13 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature13.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature14 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature14.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature16 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature16.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + jsonReadFeature18 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature18.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature19 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature19.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray20);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray20, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder21);
        org.junit.Assert.assertTrue("'" + streamReadFeature24 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature24.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder26);
        org.junit.Assert.assertTrue("'" + jsonReadFeature28 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature28.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder29);
        org.junit.Assert.assertTrue("'" + jsonReadFeature30 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature30.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature31 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature31.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature32 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature32.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature34 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature34.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder35);
        org.junit.Assert.assertTrue("'" + jsonReadFeature36 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature36.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature37 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature37.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray38);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray38, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder39);
        org.junit.Assert.assertTrue("'" + streamReadFeature42 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature42.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder44);
        org.junit.Assert.assertTrue("'" + jsonReadFeature46 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature46.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder47);
        org.junit.Assert.assertTrue("'" + jsonReadFeature48 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature48.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature49 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature49.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature50 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature50.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertTrue("'" + jsonReadFeature52 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature52.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertNotNull(jsonFactoryBuilder53);
        org.junit.Assert.assertTrue("'" + jsonReadFeature54 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS + "'", jsonReadFeature54.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS));
        org.junit.Assert.assertTrue("'" + jsonReadFeature55 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES + "'", jsonReadFeature55.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES));
        org.junit.Assert.assertNotNull(jsonReadFeatureArray56);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray56, new com.fasterxml.jackson.core.json.JsonReadFeature[] { com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS, com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder57);
        org.junit.Assert.assertTrue("'" + streamReadFeature60 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature60.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder62);
        org.junit.Assert.assertTrue("'" + streamReadFeature65 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature65.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertTrue("'" + streamReadFeature67 + "' != '" + StreamReadFeature.IGNORE_UNDEFINED + "'", streamReadFeature67.equals(StreamReadFeature.IGNORE_UNDEFINED));
        org.junit.Assert.assertNotNull(streamReadFeatureArray68);
        org.junit.Assert.assertArrayEquals(streamReadFeatureArray68, new StreamReadFeature[] { StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED, StreamReadFeature.IGNORE_UNDEFINED });
        org.junit.Assert.assertNotNull(jsonFactoryBuilder69);
        org.junit.Assert.assertNotNull(bufferRecyclerRecyclerPool70);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test344");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        boolean boolean10 = jsonPointer9.mayMatchElement();
        boolean boolean11 = jsonPointer9.matches();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test345");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeRaw('#');
        // The following exception was thrown during execution in test generation
        try {
            PrettyPrinter prettyPrinter8 = filteringGeneratorDelegate5.getPrettyPrinter();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test346");
        JsonParser.Feature feature0 = JsonParser.Feature.ALLOW_YAML_COMMENTS;
        boolean boolean1 = feature0.enabledByDefault();
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonParser.Feature.ALLOW_YAML_COMMENTS + "'", feature0.equals(JsonParser.Feature.ALLOW_YAML_COMMENTS));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test347");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeNumber(0.0f);
        filteringGeneratorDelegate5.writeBoolean(false);
        JsonToken jsonToken12 = JsonToken.VALUE_EMBEDDED_OBJECT;
        filteringGeneratorDelegate5.writeStartArray((Object) jsonToken12);
        filteringGeneratorDelegate5.writeRawValue("", (int) '\"', (int) (short) -1);
        org.junit.Assert.assertTrue("'" + jsonToken12 + "' != '" + JsonToken.VALUE_EMBEDDED_OBJECT + "'", jsonToken12.equals(JsonToken.VALUE_EMBEDDED_OBJECT));
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test348");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        com.fasterxml.jackson.core.util.InternCache internCache3 = com.fasterxml.jackson.core.util.InternCache.instance;
        JsonParser.NumberType numberType4 = JsonParser.NumberType.LONG;
        String str6 = internCache3.getOrDefault((Object) numberType4, "33.0");
        String str9 = internCache3.replace("100", "hi!");
        JsonGenerator.Feature feature10 = JsonGenerator.Feature.QUOTE_FIELD_NAMES;
        String str11 = internCache3.get((Object) feature10);
        JsonFactory jsonFactory12 = jsonFactory0.enable(feature10);
        StreamWriteConstraints streamWriteConstraints13 = jsonFactory0.streamWriteConstraints();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(internCache3);
        org.junit.Assert.assertTrue("'" + numberType4 + "' != '" + JsonParser.NumberType.LONG + "'", numberType4.equals(JsonParser.NumberType.LONG));
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "33.0" + "'", str6, "33.0");
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + JsonGenerator.Feature.QUOTE_FIELD_NAMES + "'", feature10.equals(JsonGenerator.Feature.QUOTE_FIELD_NAMES));
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNotNull(jsonFactory12);
        org.junit.Assert.assertNotNull(streamWriteConstraints13);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test349");
        JsonFactoryBuilder jsonFactoryBuilder0 = new JsonFactoryBuilder();
        JsonFactory jsonFactory1 = new JsonFactory(jsonFactoryBuilder0);
        int int2 = jsonFactoryBuilder0.streamWriteFeatures();
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes3 = jsonFactoryBuilder0.characterEscapes();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2079 + "'", int2 == 2079);
        org.junit.Assert.assertNull(characterEscapes3);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test350");
        int int0 = com.fasterxml.jackson.core.base.GeneratorBase.SURR2_LAST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 57343 + "'", int0 == 57343);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test351");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inArray();
        boolean boolean8 = jsonReadContext6.expectComma();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test352");
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool0 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler1 = lockFreePool0.acquirePooled();
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = bufferRecycler1.allocByteBuffer((int) '\"');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 34");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(lockFreePool0);
        org.junit.Assert.assertNotNull(bufferRecycler1);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test353");
        JsonFactory.Feature feature0 = JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING + "'", feature0.equals(JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING));
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test354");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        long long26 = jsonParser10.nextLongValue((long) (short) -1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + long26 + "' != '" + (-1L) + "'", long26 == (-1L));
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test355");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate5.writeFieldName("33.0");
        JsonGenerator jsonGenerator10 = filteringGeneratorDelegate5.delegate();
        JsonGenerator jsonGenerator11 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate12 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator11);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter13 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion14 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate16 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator11, tokenFilter13, inclusion14, true);
        filteringGeneratorDelegate16.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString18 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate16.writeFieldName((SerializableString) serializedString18);
        filteringGeneratorDelegate5.writeFieldName((SerializableString) serializedString18);
        JsonGenerator jsonGenerator21 = filteringGeneratorDelegate5.delegate();
        // The following exception was thrown during execution in test generation
        try {
            filteringGeneratorDelegate5.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonGenerator10);
        org.junit.Assert.assertNotNull(serializedString18);
        org.junit.Assert.assertNull(jsonGenerator21);
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test356");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        Object obj26 = jsonParserSequence24.getCurrentValue();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(obj26);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test357");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeNull();
        filteringGeneratorDelegate5.writeFieldId((-65L));
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test358");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeBoolean(true);
        filteringGeneratorDelegate5.writeNumberField("com.fasterxml.jackson.core.JsonParseException: hi!", (short) (byte) 1);
        filteringGeneratorDelegate5.writeNullField("");
        Base64Variant base64Variant14 = null;
        JsonGenerator jsonGenerator15 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate16 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator15);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter17 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion18 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate20 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator15, tokenFilter17, inclusion18, true);
        filteringGeneratorDelegate20.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        filteringGeneratorDelegate20.writeNumber(0.0f);
        filteringGeneratorDelegate20.writeNumber(10.0f);
        Base64Variant base64Variant27 = null;
        JsonGenerator jsonGenerator28 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate29 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator28);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter30 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion31 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate33 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator28, tokenFilter30, inclusion31, true);
        filteringGeneratorDelegate33.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant36 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler37 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder38 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler37);
        byteArrayBuilder38.append((int) (short) -1);
        byte[] byteArray41 = byteArrayBuilder38.getClearAndRelease();
        filteringGeneratorDelegate33.writeBinary(base64Variant36, byteArray41, 3, (int) (byte) 0);
        byte[] byteArray45 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate33.writeRawUTF8String(byteArray45, 0, 2);
        filteringGeneratorDelegate20.writeBinary(base64Variant27, byteArray45, (int) (byte) 10, 500);
        filteringGeneratorDelegate5.writeBinary(base64Variant14, byteArray45, (int) 'a', (int) '\"');
        org.junit.Assert.assertNotNull(byteArray41);
        org.junit.Assert.assertArrayEquals(byteArray41, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray45);
        org.junit.Assert.assertArrayEquals(byteArray45, new byte[] {});
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test359");
        com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerRecyclerPool0 = com.fasterxml.jackson.core.util.JsonRecyclerPools.nonRecyclingPool();
        org.junit.Assert.assertNotNull(bufferRecyclerRecyclerPool0);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test360");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool boundedPool13 = com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool.construct((int) (byte) 100);
        JsonFactoryBuilder jsonFactoryBuilder14 = jsonFactoryBuilder10.recyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        JsonFactory jsonFactory15 = jsonFactory0.setRecyclerPool((com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler>) boundedPool13);
        com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool lockFreePool16 = com.fasterxml.jackson.core.util.JsonRecyclerPools.LockFreePool.construct();
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler17 = lockFreePool16.acquirePooled();
        boundedPool13.releasePooled(bufferRecycler17);
        com.fasterxml.jackson.core.util.TextBuffer textBuffer19 = new com.fasterxml.jackson.core.util.TextBuffer(bufferRecycler17);
        // The following exception was thrown during execution in test generation
        try {
            textBuffer19.resetWithCopy("JSON", 2, 55296);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 55298");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertNotNull(boundedPool13);
        org.junit.Assert.assertNotNull(jsonFactoryBuilder14);
        org.junit.Assert.assertNotNull(jsonFactory15);
        org.junit.Assert.assertNotNull(lockFreePool16);
        org.junit.Assert.assertNotNull(bufferRecycler17);
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test361");
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext0 = null;
        com.fasterxml.jackson.core.json.DupDetector dupDetector2 = null;
        com.fasterxml.jackson.core.json.JsonReadContext jsonReadContext6 = new com.fasterxml.jackson.core.json.JsonReadContext(jsonReadContext0, (int) (byte) 0, dupDetector2, (int) '4', 0, (int) (byte) 1);
        boolean boolean7 = jsonReadContext6.inRoot();
        String str8 = jsonReadContext6.typeDesc();
        JsonPointer jsonPointer9 = jsonReadContext6.pathAsPointer();
        JsonGenerator jsonGenerator10 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate11 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator10);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter12 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion13 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate15 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator10, tokenFilter12, inclusion13, true);
        filteringGeneratorDelegate15.writeStartArray();
        com.fasterxml.jackson.core.io.SerializedString serializedString17 = PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        filteringGeneratorDelegate15.writeFieldName((SerializableString) serializedString17);
        boolean boolean19 = jsonPointer9.equals((Object) filteringGeneratorDelegate15);
        JsonPointer jsonPointer21 = jsonPointer9.appendProperty(" ");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "?" + "'", str8, "?");
        org.junit.Assert.assertNotNull(jsonPointer9);
        org.junit.Assert.assertNotNull(serializedString17);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(jsonPointer21);
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test362");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.util.RecyclerPool.LockFreePoolBase<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerLockFreePoolBase0 = com.fasterxml.jackson.core.util.VersionUtil.throwInternalReturnAny();
            org.junit.Assert.fail("Expected exception of type java.lang.RuntimeException; message: Internal error: this code path should never get executed");
        } catch (RuntimeException e) {
            // Expected exception.
        }
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test363");
        com.fasterxml.jackson.core.util.DefaultIndenter defaultIndenter0 = new com.fasterxml.jackson.core.util.DefaultIndenter();
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test364");
        java.math.BigInteger bigInteger3 = com.fasterxml.jackson.core.io.NumberInput.parseBigIntegerWithRadix("500", (int) ' ', true);
        org.junit.Assert.assertNotNull(bigInteger3);
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test365");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamWriteConstraints streamWriteConstraints2 = jsonFactory0.streamWriteConstraints();
        StreamWriteConstraints.Builder builder3 = streamWriteConstraints2.rebuild();
        StreamWriteConstraints.Builder builder5 = builder3.maxNestingDepth((int) ' ');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints2);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test366");
        com.fasterxml.jackson.core.json.JsonWriteContext jsonWriteContext0 = com.fasterxml.jackson.core.json.JsonWriteContext.createRootContext();
        com.fasterxml.jackson.core.json.JsonWriteContext jsonWriteContext1 = jsonWriteContext0.getParent();
        org.junit.Assert.assertNotNull(jsonWriteContext0);
        org.junit.Assert.assertNull(jsonWriteContext1);
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test367");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        JsonToken jsonToken8 = jsonParser7.getLastClearedToken();
        JsonFactory jsonFactory10 = new JsonFactory();
        boolean boolean11 = jsonFactory10.requiresCustomCodec();
        String str12 = jsonFactory10.getFormatName();
        char[] charArray16 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser17 = jsonFactory10.createParser(charArray16);
        JsonParser jsonParser19 = jsonParser17.setFeatureMask((int) '4');
        JsonFactory jsonFactory20 = new JsonFactory();
        boolean boolean21 = jsonFactory20.requiresCustomCodec();
        String str22 = jsonFactory20.getFormatName();
        char[] charArray26 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser27 = jsonFactory20.createParser(charArray26);
        JsonToken jsonToken28 = jsonParser27.getLastClearedToken();
        jsonParser27.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream31 = null;
        int int32 = jsonParser27.releaseBuffered(outputStream31);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence33 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser19, jsonParser27);
        boolean boolean34 = jsonParserSequence33.canParseAsync();
        double double36 = jsonParserSequence33.getValueAsDouble(0.0d);
        boolean boolean37 = jsonParserSequence33.getValueAsBoolean();
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence38 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(jsonParser7, (JsonParser) jsonParserSequence33);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertNull(jsonToken8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "JSON" + "'", str12, "JSON");
        org.junit.Assert.assertNotNull(charArray16);
        org.junit.Assert.assertArrayEquals(charArray16, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser17);
        org.junit.Assert.assertNotNull(jsonParser19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "JSON" + "'", str22, "JSON");
        org.junit.Assert.assertNotNull(charArray26);
        org.junit.Assert.assertArrayEquals(charArray26, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser27);
        org.junit.Assert.assertNull(jsonToken28);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + (-1) + "'", int32 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + double36 + "' != '" + 0.0d + "'", double36 == 0.0d);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(jsonParserSequence38);
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test368");
        StreamReadConstraints.Builder builder0 = StreamReadConstraints.builder();
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test369");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        java.io.Reader reader2 = null;
        ObjectCodec objectCodec3 = null;
        com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer charsToNameCanonicalizer4 = com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.createRoot();
        com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer charsToNameCanonicalizer6 = charsToNameCanonicalizer4.makeChild(33);
        int int8 = charsToNameCanonicalizer6.calcHash("?");
        char[] charArray11 = new char[] { '\"', ' ' };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.json.ReaderBasedJsonParser readerBasedJsonParser15 = new com.fasterxml.jackson.core.json.ReaderBasedJsonParser(iOContext0, (-2), reader2, objectCodec3, charsToNameCanonicalizer6, charArray11, 100, (int) '#', true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charsToNameCanonicalizer4);
        org.junit.Assert.assertNotNull(charsToNameCanonicalizer6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 63 + "'", int8 == 63);
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertArrayEquals(charArray11, new char[] { '\"', ' ' });
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test370");
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature0 = com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_JAVA_COMMENTS;
        org.junit.Assert.assertTrue("'" + jsonReadFeature0 + "' != '" + com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_JAVA_COMMENTS + "'", jsonReadFeature0.equals(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_JAVA_COMMENTS));
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test371");
        StringBuilder stringBuilder0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.io.CharTypes.appendQuoted(stringBuilder0, "com.fasterxml.jackson.core.JsonParseException: 33.0\n at [Source: (Byte); line: 52, column: 256]");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test372");
        int int0 = JsonStreamContext.TYPE_ARRAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test373");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant8 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler9 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder10 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler9);
        byteArrayBuilder10.append((int) (short) -1);
        byte[] byteArray13 = byteArrayBuilder10.getClearAndRelease();
        filteringGeneratorDelegate5.writeBinary(base64Variant8, byteArray13, 3, (int) (byte) 0);
        byte[] byteArray17 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate5.writeRawUTF8String(byteArray17, 0, 2);
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate22 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate((JsonGenerator) filteringGeneratorDelegate5, false);
        Base64Variant base64Variant23 = null;
        JsonGenerator jsonGenerator24 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate25 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator24);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter26 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion27 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate29 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator24, tokenFilter26, inclusion27, true);
        filteringGeneratorDelegate29.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        Base64Variant base64Variant32 = null;
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler33 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder34 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler33);
        byteArrayBuilder34.append((int) (short) -1);
        byte[] byteArray37 = byteArrayBuilder34.getClearAndRelease();
        filteringGeneratorDelegate29.writeBinary(base64Variant32, byteArray37, 3, (int) (byte) 0);
        byte[] byteArray41 = com.fasterxml.jackson.core.util.ByteArrayBuilder.NO_BYTES;
        filteringGeneratorDelegate29.writeRawUTF8String(byteArray41, 0, 2);
        jsonGeneratorDelegate22.writeBinary(base64Variant23, byteArray41, 7, 7);
        jsonGeneratorDelegate22.writeStartArray(2);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray37);
        org.junit.Assert.assertArrayEquals(byteArray37, new byte[] { (byte) -1 });
        org.junit.Assert.assertNotNull(byteArray41);
        org.junit.Assert.assertArrayEquals(byteArray41, new byte[] {});
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test374");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeFieldName("com.fasterxml.jackson.core.JsonParseException: hi!");
        JsonFactory jsonFactory9 = new JsonFactory();
        boolean boolean10 = jsonFactory9.requiresCustomCodec();
        String str11 = jsonFactory9.getFormatName();
        char[] charArray15 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser16 = jsonFactory9.createParser(charArray15);
        JsonParser jsonParser18 = jsonParser16.setFeatureMask((int) '4');
        JsonFactory jsonFactory19 = new JsonFactory();
        boolean boolean20 = jsonFactory19.requiresCustomCodec();
        String str21 = jsonFactory19.getFormatName();
        char[] charArray25 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser26 = jsonFactory19.createParser(charArray25);
        JsonToken jsonToken27 = jsonParser26.getLastClearedToken();
        jsonParser26.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream30 = null;
        int int31 = jsonParser26.releaseBuffered(outputStream30);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence32 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser18, jsonParser26);
        boolean boolean33 = jsonParserSequence32.canParseAsync();
        double double35 = jsonParserSequence32.getValueAsDouble(0.0d);
        JsonParser jsonParser36 = jsonParserSequence32.skipChildren();
        filteringGeneratorDelegate5.writeObjectRef((Object) jsonParser36);
        int int38 = filteringGeneratorDelegate5.getFormatFeatures();
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "JSON" + "'", str11, "JSON");
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertArrayEquals(charArray15, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser16);
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "JSON" + "'", str21, "JSON");
        org.junit.Assert.assertNotNull(charArray25);
        org.junit.Assert.assertArrayEquals(charArray25, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser26);
        org.junit.Assert.assertNull(jsonToken27);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + (-1) + "'", int31 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + double35 + "' != '" + 0.0d + "'", double35 == 0.0d);
        org.junit.Assert.assertNotNull(jsonParser36);
        org.junit.Assert.assertTrue("'" + int38 + "' != '" + 0 + "'", int38 == 0);
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test375");
        com.fasterxml.jackson.core.util.BufferRecycler bufferRecycler0 = null;
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder1 = new com.fasterxml.jackson.core.util.ByteArrayBuilder(bufferRecycler0);
        byteArrayBuilder1.append((int) (short) -1);
        byteArrayBuilder1.appendFourBytes((int) ' ');
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test376");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        StreamWriteConstraints streamWriteConstraints2 = jsonFactory0.streamWriteConstraints();
        streamWriteConstraints2.validateNestingDepth(0);
        StreamWriteConstraints.overrideDefaultStreamWriteConstraints(streamWriteConstraints2);
        int int6 = streamWriteConstraints2.getMaxNestingDepth();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints2);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1000 + "'", int6 == 1000);
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test377");
        JsonGenerator.Feature feature0 = JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN + "'", feature0.equals(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN));
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test378");
        JsonFactory jsonFactory0 = new JsonFactory();
        boolean boolean1 = jsonFactory0.requiresCustomCodec();
        String str2 = jsonFactory0.getFormatName();
        char[] charArray6 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser7 = jsonFactory0.createParser(charArray6);
        String str8 = jsonFactory0.getFormatName();
        Class<? extends FormatFeature> wildcardClass9 = jsonFactory0.getFormatReadFeatureType();
        int int10 = jsonFactory0.getFormatGeneratorFeatures();
        byte[] byteArray13 = new byte[] { (byte) -1, (byte) 10 };
        com.fasterxml.jackson.core.util.ByteArrayBuilder byteArrayBuilder15 = com.fasterxml.jackson.core.util.ByteArrayBuilder.fromInitial(byteArray13, (-1));
        byteArrayBuilder15.flush();
        JsonGenerator jsonGenerator17 = jsonFactory0.createGenerator((java.io.OutputStream) byteArrayBuilder15);
        boolean boolean18 = jsonGenerator17.canWriteObjectId();
        StreamWriteConstraints streamWriteConstraints19 = jsonGenerator17.streamWriteConstraints();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "JSON" + "'", str2, "JSON");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "JSON" + "'", str8, "JSON");
        org.junit.Assert.assertNull(wildcardClass9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -1, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArrayBuilder15);
        org.junit.Assert.assertNotNull(jsonGenerator17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(streamWriteConstraints19);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test379");
        JsonGenerator.Feature feature0 = JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8 + "'", feature0.equals(JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8));
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test380");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        boolean boolean25 = jsonParserSequence24.canParseAsync();
        Base64Variant base64Variant26 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray27 = jsonParserSequence24.getBinaryValue(base64Variant26);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Current token (null) not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary? at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]");
        } catch (JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test381");
        JsonFactory jsonFactory1 = new JsonFactory();
        boolean boolean2 = jsonFactory1.requiresCustomCodec();
        String str3 = jsonFactory1.getFormatName();
        char[] charArray7 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser8 = jsonFactory1.createParser(charArray7);
        JsonParser jsonParser10 = jsonParser8.setFeatureMask((int) '4');
        JsonFactory jsonFactory11 = new JsonFactory();
        boolean boolean12 = jsonFactory11.requiresCustomCodec();
        String str13 = jsonFactory11.getFormatName();
        char[] charArray17 = new char[] { '\"', 'a', ' ' };
        JsonParser jsonParser18 = jsonFactory11.createParser(charArray17);
        JsonToken jsonToken19 = jsonParser18.getLastClearedToken();
        jsonParser18.setCurrentValue((Object) '#');
        java.io.OutputStream outputStream22 = null;
        int int23 = jsonParser18.releaseBuffered(outputStream22);
        com.fasterxml.jackson.core.util.JsonParserSequence jsonParserSequence24 = com.fasterxml.jackson.core.util.JsonParserSequence.createFlattened(true, jsonParser10, jsonParser18);
        JsonToken jsonToken25 = JsonToken.VALUE_EMBEDDED_OBJECT;
        com.fasterxml.jackson.core.type.WritableTypeId writableTypeId26 = new com.fasterxml.jackson.core.type.WritableTypeId((Object) true, jsonToken25);
        writableTypeId26.asProperty = "";
        com.fasterxml.jackson.core.type.WritableTypeId.Inclusion inclusion29 = com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.PAYLOAD_PROPERTY;
        writableTypeId26.include = inclusion29;
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "JSON" + "'", str3, "JSON");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser8);
        org.junit.Assert.assertNotNull(jsonParser10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "JSON" + "'", str13, "JSON");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertArrayEquals(charArray17, new char[] { '\"', 'a', ' ' });
        org.junit.Assert.assertNotNull(jsonParser18);
        org.junit.Assert.assertNull(jsonToken19);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertNotNull(jsonParserSequence24);
        org.junit.Assert.assertTrue("'" + jsonToken25 + "' != '" + JsonToken.VALUE_EMBEDDED_OBJECT + "'", jsonToken25.equals(JsonToken.VALUE_EMBEDDED_OBJECT));
        org.junit.Assert.assertTrue("'" + inclusion29 + "' != '" + com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.PAYLOAD_PROPERTY + "'", inclusion29.equals(com.fasterxml.jackson.core.type.WritableTypeId.Inclusion.PAYLOAD_PROPERTY));
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test382");
        com.fasterxml.jackson.core.util.RecyclerPool<com.fasterxml.jackson.core.util.BufferRecycler> bufferRecyclerRecyclerPool0 = com.fasterxml.jackson.core.util.JsonRecyclerPools.threadLocalPool();
        org.junit.Assert.assertNotNull(bufferRecyclerRecyclerPool0);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test383");
        JsonGenerator jsonGenerator0 = null;
        com.fasterxml.jackson.core.util.JsonGeneratorDelegate jsonGeneratorDelegate1 = new com.fasterxml.jackson.core.util.JsonGeneratorDelegate(jsonGenerator0);
        com.fasterxml.jackson.core.filter.TokenFilter tokenFilter2 = null;
        com.fasterxml.jackson.core.filter.TokenFilter.Inclusion inclusion3 = null;
        com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate filteringGeneratorDelegate5 = new com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate(jsonGenerator0, tokenFilter2, inclusion3, true);
        filteringGeneratorDelegate5.writeStartArray();
        filteringGeneratorDelegate5.writeNull();
        filteringGeneratorDelegate5.writeFieldId((long) 33);
        JsonFactoryBuilder jsonFactoryBuilder10 = new JsonFactoryBuilder();
        JsonFactory jsonFactory11 = new JsonFactory(jsonFactoryBuilder10);
        filteringGeneratorDelegate5.writeObjectRef((Object) jsonFactoryBuilder10);
        // The following exception was thrown during execution in test generation
        try {
            Object obj13 = filteringGeneratorDelegate5.getCurrentValue();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test384");
        int int0 = JsonFactory.Feature.collectDefaults();
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 31 + "'", int0 == 31);
    }
}

