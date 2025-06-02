package com.fasterxml.jackson.databind;

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
        com.fasterxml.jackson.databind.type.LogicalType logicalType0 = com.fasterxml.jackson.databind.type.LogicalType.Textual;
        org.junit.Assert.assertTrue("'" + logicalType0 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Textual + "'", logicalType0.equals(com.fasterxml.jackson.databind.type.LogicalType.Textual));
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        Enum<com.fasterxml.jackson.databind.util.NamingStrategyImpls> namingStrategyImplsEnum0 = null;
        // The following exception was thrown during execution in test generation
        try {
            Class<? extends Enum<?>> wildcardClass1 = com.fasterxml.jackson.databind.util.ClassUtil.findEnumType(namingStrategyImplsEnum0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        com.fasterxml.jackson.databind.util.NamingStrategyImpls namingStrategyImpls0 = com.fasterxml.jackson.databind.util.NamingStrategyImpls.SNAKE_CASE;
        String str2 = namingStrategyImpls0.translate("");
        org.junit.Assert.assertNotNull(namingStrategyImpls0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        com.fasterxml.jackson.databind.type.LogicalType logicalType0 = com.fasterxml.jackson.databind.type.LogicalType.DateTime;
        org.junit.Assert.assertTrue("'" + logicalType0 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.DateTime + "'", logicalType0.equals(com.fasterxml.jackson.databind.type.LogicalType.DateTime));
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        int int0 = java.text.DateFormat.MILLISECOND_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        com.fasterxml.jackson.core.JsonPointer jsonPointer2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode3 = booleanNode0.withArray(jsonPointer2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        DeserializationContext deserializationContext0 = null;
        JsonMappingException jsonMappingException2 = JsonMappingException.from(deserializationContext0, "");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.ClassUtil.throwAsIAE((Throwable) jsonMappingException2, "");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonMappingException2);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        com.fasterxml.jackson.databind.cfg.CoercionConfig coercionConfig0 = new com.fasterxml.jackson.databind.cfg.CoercionConfig();
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean3 = booleanNode0.hasNonNull((int) (byte) 1);
        com.fasterxml.jackson.core.JsonParser.NumberType numberType4 = booleanNode0.numberType();
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(numberType4);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        DeserializationContext deserializationContext0 = null;
        JsonMappingException jsonMappingException2 = JsonMappingException.from(deserializationContext0, "");
        String str3 = jsonMappingException2.toString();
        org.junit.Assert.assertNotNull(jsonMappingException2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "com.fasterxml.jackson.databind.JsonMappingException: " + "'", str3, "com.fasterxml.jackson.databind.JsonMappingException: ");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        com.fasterxml.jackson.databind.util.ClassUtil classUtil0 = new com.fasterxml.jackson.databind.util.ClassUtil();
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator0 = null;
        java.io.Closeable closeable1 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        DeserializationContext deserializationContext4 = null;
        JsonMappingException jsonMappingException6 = JsonMappingException.from(deserializationContext4, "");
        JsonMappingException jsonMappingException7 = JsonMappingException.from(jsonGenerator2, "", (Throwable) jsonMappingException6);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.ClassUtil.closeOnFailAndThrowAsIOE(jsonGenerator0, closeable1, (Exception) jsonMappingException7);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.databind.JsonMappingException; message: ");
        } catch (JsonMappingException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonMappingException6);
        org.junit.Assert.assertNotNull(jsonMappingException7);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isEmpty();
        JsonMappingException.Reference reference4 = new JsonMappingException.Reference((Object) boolean2, (int) (short) 1);
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion inclusion0 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL;
        org.junit.Assert.assertTrue("'" + inclusion0 + "' != '" + com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL + "'", inclusion0.equals(com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL));
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer1 = com.fasterxml.jackson.databind.util.TokenBuffer.asCopyOfValue(jsonParser0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        Class<Float> floatClass0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.NumberDeserializers.FloatDeserializer floatDeserializer2 = new com.fasterxml.jackson.databind.deser.std.NumberDeserializers.FloatDeserializer(floatClass0, (Float) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes jsonFormatTypes0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.BOOLEAN;
        org.junit.Assert.assertTrue("'" + jsonFormatTypes0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.BOOLEAN + "'", jsonFormatTypes0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.BOOLEAN));
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        com.fasterxml.jackson.databind.cfg.CoercionInputShape coercionInputShape0 = com.fasterxml.jackson.databind.cfg.CoercionInputShape.Boolean;
        org.junit.Assert.assertTrue("'" + coercionInputShape0 + "' != '" + com.fasterxml.jackson.databind.cfg.CoercionInputShape.Boolean + "'", coercionInputShape0.equals(com.fasterxml.jackson.databind.cfg.CoercionInputShape.Boolean));
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        java.text.DateFormat dateFormat0 = java.text.DateFormat.getInstance();
        org.junit.Assert.assertNotNull(dateFormat0);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition beanPropertyDefinition0 = null;
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.jsontype.TypeDeserializer typeDeserializer2 = null;
        com.fasterxml.jackson.databind.util.Annotations annotations3 = null;
        com.fasterxml.jackson.databind.introspect.AnnotatedMethod annotatedMethod4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.impl.SetterlessProperty setterlessProperty5 = new com.fasterxml.jackson.databind.deser.impl.SetterlessProperty(beanPropertyDefinition0, javaType1, typeDeserializer2, annotations3, annotatedMethod4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        String[] strArray3 = new String[] { "hi!", "", "hi!" };
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter simpleBeanPropertyFilter4 = com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept(strArray3);
        com.fasterxml.jackson.databind.ser.BeanPropertyWriter beanPropertyWriter5 = null;
        com.fasterxml.jackson.databind.node.ObjectNode objectNode6 = null;
        SerializerProvider serializerProvider7 = null;
        // The following exception was thrown during execution in test generation
        try {
            simpleBeanPropertyFilter4.depositSchemaProperty(beanPropertyWriter5, objectNode6, serializerProvider7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new String[] { "hi!", "", "hi!" });
        org.junit.Assert.assertNotNull(simpleBeanPropertyFilter4);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        int int0 = java.text.DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        java.io.Closeable closeable0 = null;
        com.fasterxml.jackson.core.JsonLocation jsonLocation2 = null;
        JsonMappingException jsonMappingException3 = new JsonMappingException(closeable0, "", jsonLocation2);
        Throwable throwable4 = com.fasterxml.jackson.databind.util.ClassUtil.throwIfError((Throwable) jsonMappingException3);
        org.junit.Assert.assertNotNull(throwable4);
        org.junit.Assert.assertEquals(throwable4.getLocalizedMessage(), "");
        org.junit.Assert.assertEquals(throwable4.getMessage(), "");
        org.junit.Assert.assertEquals(throwable4.toString(), "com.fasterxml.jackson.databind.JsonMappingException: ");
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor singleArgConstructor0 = com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor.DELEGATING;
        org.junit.Assert.assertTrue("'" + singleArgConstructor0 + "' != '" + com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor.DELEGATING + "'", singleArgConstructor0.equals(com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor.DELEGATING));
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        String str1 = com.fasterxml.jackson.databind.util.ClassUtil.apostrophed("");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "''" + "'", str1, "''");
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        JavaType javaType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int1 = com.fasterxml.jackson.databind.util.TypeKey.untypedHash(javaType0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        com.fasterxml.jackson.databind.deser.BeanDeserializer beanDeserializer0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer throwableDeserializer1 = new com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer(beanDeserializer0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer unwrappingBeanSerializer0 = null;
        com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter objectIdWriter1 = null;
        java.util.stream.Stream<Comparable<String>> strComparableStream2 = com.fasterxml.jackson.databind.util.ClassUtil.emptyStream();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer unwrappingBeanSerializer3 = new com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer(unwrappingBeanSerializer0, objectIdWriter1, (Object) strComparableStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strComparableStream2);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer0 = null;
        String[] strArray2 = new String[] { "com.fasterxml.jackson.databind.JsonMappingException: " };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        String[] strArray6 = new String[] { "" };
        java.util.LinkedHashSet<String> strSet7 = new java.util.LinkedHashSet<String>();
        boolean boolean8 = java.util.Collections.addAll((java.util.Collection<String>) strSet7, strArray6);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer9 = new com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer(builderBasedDeserializer0, (java.util.Set<String>) strSet3, (java.util.Set<String>) strSet7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "com.fasterxml.jackson.databind.JsonMappingException: " });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer2 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType0, "hi!");
        com.fasterxml.jackson.core.JsonParser jsonParser3 = null;
        DeserializationContext deserializationContext4 = null;
        com.fasterxml.jackson.databind.jsontype.TypeDeserializer typeDeserializer5 = null;
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode7 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean8 = doubleNode7.isNaN();
        // The following exception was thrown during execution in test generation
        try {
            Object obj9 = unsupportedTypeDeserializer2.deserializeWithType(jsonParser3, deserializationContext4, typeDeserializer5, (Object) doubleNode7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleNode7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        DeserializationFeature deserializationFeature0 = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS;
        org.junit.Assert.assertTrue("'" + deserializationFeature0 + "' != '" + DeserializationFeature.USE_BIG_INTEGER_FOR_INTS + "'", deserializationFeature0.equals(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS));
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        com.fasterxml.jackson.databind.util.NamingStrategyImpls namingStrategyImpls0 = com.fasterxml.jackson.databind.util.NamingStrategyImpls.UPPER_SNAKE_CASE;
        org.junit.Assert.assertNotNull(namingStrategyImpls0);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        DeserializationFeature deserializationFeature0 = DeserializationFeature.EAGER_DESERIALIZER_FETCH;
        org.junit.Assert.assertTrue("'" + deserializationFeature0 + "' != '" + DeserializationFeature.EAGER_DESERIALIZER_FETCH + "'", deserializationFeature0.equals(DeserializationFeature.EAGER_DESERIALIZER_FETCH));
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        DeserializationConfig deserializationConfig0 = null;
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer2 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        java.util.Collection<Object> objCollection3 = atomicBooleanDeserializer2.getKnownPropertyNames();
        // The following exception was thrown during execution in test generation
        try {
            KeyDeserializer keyDeserializer4 = com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers.constructDelegatingKeyDeserializer(deserializationConfig0, javaType1, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(objCollection3);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature0 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES;
        int int1 = jsonNodeFeature0.getMask();
        boolean boolean2 = jsonNodeFeature0.enabledByDefault();
        org.junit.Assert.assertTrue("'" + jsonNodeFeature0 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES + "'", jsonNodeFeature0.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2 + "'", int1 == 2);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        boolean boolean4 = doubleNode1.asBoolean(true);
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer indexedListSerializer0 = null;
        BeanProperty beanProperty1 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        JsonSerializer<Object> objJsonSerializer3 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer indexedListSerializer5 = new com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer(indexedListSerializer0, beanProperty1, typeSerializer2, objJsonSerializer3, (Boolean) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(objJsonSerializer3);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        java.lang.reflect.Member member0 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean1 = com.fasterxml.jackson.databind.util.ClassUtil.isConcrete(member0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        SerializationFeature serializationFeature0 = SerializationFeature.WRAP_ROOT_VALUE;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRAP_ROOT_VALUE + "'", serializationFeature0.equals(SerializationFeature.WRAP_ROOT_VALUE));
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        com.fasterxml.jackson.core.Version version0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.module.SimpleModule simpleModule1 = new com.fasterxml.jackson.databind.module.SimpleModule(version0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        ObjectMapper.DefaultTyping defaultTyping0 = ObjectMapper.DefaultTyping.NON_FINAL;
        org.junit.Assert.assertTrue("'" + defaultTyping0 + "' != '" + ObjectMapper.DefaultTyping.NON_FINAL + "'", defaultTyping0.equals(ObjectMapper.DefaultTyping.NON_FINAL));
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        com.fasterxml.jackson.databind.cfg.DefaultCacheProvider.Builder builder0 = com.fasterxml.jackson.databind.cfg.DefaultCacheProvider.builder();
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        com.fasterxml.jackson.databind.introspect.AnnotatedMethod annotatedMethod0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str2 = com.fasterxml.jackson.databind.util.BeanUtil.okNameForGetter(annotatedMethod0, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        DeserializationFeature deserializationFeature0 = DeserializationFeature.FAIL_ON_INVALID_SUBTYPE;
        org.junit.Assert.assertTrue("'" + deserializationFeature0 + "' != '" + DeserializationFeature.FAIL_ON_INVALID_SUBTYPE + "'", deserializationFeature0.equals(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE));
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        com.fasterxml.jackson.databind.node.JsonNodeType jsonNodeType0 = com.fasterxml.jackson.databind.node.JsonNodeType.STRING;
        org.junit.Assert.assertTrue("'" + jsonNodeType0 + "' != '" + com.fasterxml.jackson.databind.node.JsonNodeType.STRING + "'", jsonNodeType0.equals(com.fasterxml.jackson.databind.node.JsonNodeType.STRING));
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        Class<?> wildcardClass0 = null;
        Class[] classArray2 = new Class[1];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray3 = (Class<?>[]) classArray2;
        wildcardClassArray3[0] = wildcardClass0;
        com.fasterxml.jackson.databind.util.ViewMatcher viewMatcher6 = com.fasterxml.jackson.databind.util.ViewMatcher.construct(wildcardClassArray3);
        org.junit.Assert.assertNotNull(classArray2);
        org.junit.Assert.assertArrayEquals(classArray2, new Class[] { null });
        org.junit.Assert.assertNotNull(wildcardClassArray3);
        org.junit.Assert.assertArrayEquals(wildcardClassArray3, new Class[] { null });
        org.junit.Assert.assertNotNull(viewMatcher6);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        ObjectWriter.Prefetch prefetch0 = ObjectWriter.Prefetch.empty;
        org.junit.Assert.assertNotNull(prefetch0);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature0 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES;
        int int1 = jsonNodeFeature0.getMask();
        int int2 = jsonNodeFeature0.getMask();
        org.junit.Assert.assertTrue("'" + jsonNodeFeature0 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES + "'", jsonNodeFeature0.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2 + "'", int1 == 2);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 2 + "'", int2 == 2);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        com.fasterxml.jackson.databind.ext.NioPathDeserializer nioPathDeserializer0 = new com.fasterxml.jackson.databind.ext.NioPathDeserializer();
        DeserializationContext deserializationContext1 = null;
        Object obj2 = nioPathDeserializer0.getEmptyValue(deserializationContext1);
        org.junit.Assert.assertNull(obj2);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        JsonNode.OverwriteMode overwriteMode4 = JsonNode.OverwriteMode.SCALARS;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode6 = booleanNode0.withArray("hi!", overwriteMode4, true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid input: JSON Pointer expression must start with '/': \"hi!\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + overwriteMode4 + "' != '" + JsonNode.OverwriteMode.SCALARS + "'", overwriteMode4.equals(JsonNode.OverwriteMode.SCALARS));
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes jsonFormatTypes0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.OBJECT;
        org.junit.Assert.assertTrue("'" + jsonFormatTypes0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.OBJECT + "'", jsonFormatTypes0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.OBJECT));
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        com.fasterxml.jackson.databind.ser.std.BeanSerializerBase beanSerializerBase0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer beanAsArraySerializer1 = new com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer(beanSerializerBase0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        BeanProperty.Std std0 = null;
        JavaType javaType1 = null;
        // The following exception was thrown during execution in test generation
        try {
            BeanProperty.Std std2 = new BeanProperty.Std(std0, javaType1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        com.fasterxml.jackson.databind.cfg.CoercionAction coercionAction0 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull;
        org.junit.Assert.assertTrue("'" + coercionAction0 + "' != '" + com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull + "'", coercionAction0.equals(com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull));
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        JsonSerializer<Object> objJsonSerializer0 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        boolean boolean1 = objJsonSerializer0.isUnwrappingSerializer();
        org.junit.Assert.assertNotNull(objJsonSerializer0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        java.io.Closeable closeable2 = null;
        com.fasterxml.jackson.core.JsonLocation jsonLocation4 = null;
        JsonMappingException jsonMappingException5 = new JsonMappingException(closeable2, "", jsonLocation4);
        // The following exception was thrown during execution in test generation
        try {
            floatArraySerializer0.wrapAndThrow(serializerProvider1, (Throwable) jsonMappingException5, (Object) (byte) -1, "com.fasterxml.jackson.databind.JsonMappingException: ");
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.databind.JsonMappingException; message: ");
        } catch (JsonMappingException e) {
            // Expected exception.
        }
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        com.fasterxml.jackson.core.JsonFactory jsonFactory0 = null;
        ObjectMapper objectMapper1 = null;
        // The following exception was thrown during execution in test generation
        try {
            MappingJsonFactory mappingJsonFactory2 = new MappingJsonFactory(jsonFactory0, objectMapper1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        String[] strArray5 = new String[] { "" };
        java.util.ArrayList<String> strList6 = new java.util.ArrayList<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strList6, strArray5);
        java.util.List<String> strList8 = booleanNode0.findValuesAsText("", (java.util.List<String>) strList6);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser9 = booleanNode0.traverse();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.base.ParserMinimalBase.<init>(Lcom/fasterxml/jackson/core/StreamReadConstraints;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strList8);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        int int0 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.Std.STD_CURRENCY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer calendarDeserializer0 = new com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator1 = calendarDeserializer0.getValueInstantiator();
        org.junit.Assert.assertNull(valueInstantiator1);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        int int0 = com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.TYPE_URL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 14 + "'", int0 == 14);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer asExternalTypeDeserializer0 = null;
        BeanProperty beanProperty1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer asExternalTypeDeserializer2 = new com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer(asExternalTypeDeserializer0, beanProperty1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        java.util.Iterator<String> strItor3 = doubleNode1.fieldNames();
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode5 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean6 = booleanNode5.isBinary();
        boolean boolean7 = booleanNode5.isTextual();
        String[] strArray10 = new String[] { "" };
        java.util.ArrayList<String> strList11 = new java.util.ArrayList<String>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<String>) strList11, strArray10);
        java.util.List<String> strList13 = booleanNode5.findValuesAsText("", (java.util.List<String>) strList11);
        java.util.List<String> strList14 = doubleNode1.findValuesAsText("hi!", (java.util.List<String>) strList11);
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strItor3);
        org.junit.Assert.assertNotNull(booleanNode5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(strList13);
        org.junit.Assert.assertNotNull(strList14);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = new com.fasterxml.jackson.databind.node.LongNode((long) 10);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        com.fasterxml.jackson.databind.deser.std.JdkDeserializers jdkDeserializers0 = new com.fasterxml.jackson.databind.deser.std.JdkDeserializers();
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.type.TypeBindings typeBindings1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.type.ArrayType arrayType2 = com.fasterxml.jackson.databind.type.ArrayType.construct(javaType0, typeBindings1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        java.util.Iterator<String> strItor3 = doubleNode1.fieldNames();
        String str4 = com.fasterxml.jackson.databind.util.ClassUtil.nullOrToString((Object) strItor3);
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strItor3);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        int int0 = com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.TYPE_LOCALE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 9 + "'", int0 == 9);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        com.fasterxml.jackson.databind.util.Named named0 = null;
        String str1 = com.fasterxml.jackson.databind.util.ClassUtil.nameOf(named0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "[null]" + "'", str1, "[null]");
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        java.util.Map<String, JsonNode> strMap1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = new com.fasterxml.jackson.databind.node.ObjectNode(jsonNodeFactory0, strMap1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Must not pass `null` for 'children' argument");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        String str1 = com.fasterxml.jackson.databind.util.ClassUtil.getClassDescription((Object) 10.0d);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "`java.lang.Double`" + "'", str1, "`java.lang.Double`");
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        boolean boolean0 = com.fasterxml.jackson.databind.util.NativeImageUtil.isInNativeImage();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat jsonValueFormat0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.DATE_TIME;
        org.junit.Assert.assertTrue("'" + jsonValueFormat0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.DATE_TIME + "'", jsonValueFormat0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.DATE_TIME));
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes jsonFormatTypes0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.NULL;
        org.junit.Assert.assertTrue("'" + jsonFormatTypes0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.NULL + "'", jsonFormatTypes0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.NULL));
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        com.fasterxml.jackson.databind.node.JsonNodeType jsonNodeType0 = com.fasterxml.jackson.databind.node.JsonNodeType.ARRAY;
        org.junit.Assert.assertTrue("'" + jsonNodeType0 + "' != '" + com.fasterxml.jackson.databind.node.JsonNodeType.ARRAY + "'", jsonNodeType0.equals(com.fasterxml.jackson.databind.node.JsonNodeType.ARRAY));
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        PropertyMetadata propertyMetadata0 = PropertyMetadata.STD_REQUIRED;
        org.junit.Assert.assertNotNull(propertyMetadata0);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        SerializationFeature serializationFeature0 = SerializationFeature.FAIL_ON_EMPTY_BEANS;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.FAIL_ON_EMPTY_BEANS + "'", serializationFeature0.equals(SerializationFeature.FAIL_ON_EMPTY_BEANS));
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        JavaType javaType0 = null;
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer3 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType1, "hi!");
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern4 = unsupportedTypeDeserializer3.getEmptyAccessPattern();
        JavaType javaType5 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver6 = null;
        JavaType javaType9 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer asArrayTypeDeserializer10 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer(javaType5, typeIdResolver6, "", false, javaType9);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer objectArrayDeserializer11 = new com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer(javaType0, (JsonDeserializer<Object>) unsupportedTypeDeserializer3, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asArrayTypeDeserializer10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + accessPattern4 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.DYNAMIC + "'", accessPattern4.equals(com.fasterxml.jackson.databind.util.AccessPattern.DYNAMIC));
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        SerializationFeature serializationFeature0 = SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED + "'", serializationFeature0.equals(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED));
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        JavaType javaType0 = null;
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer4 = null;
        BeanProperty beanProperty5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer mapEntrySerializer6 = new com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer(javaType0, javaType1, javaType2, true, typeSerializer4, beanProperty5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        String[] strArray6 = new String[] { "[null]", "''", "hi!", "''", "''" };
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        SerializerProvider serializerProvider8 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer9 = null;
        // The following exception was thrown during execution in test generation
        try {
            stringArraySerializer0.serializeWithType(strArray6, jsonGenerator7, serializerProvider8, typeSerializer9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new String[] { "[null]", "''", "hi!", "''", "''" });
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        SerializationFeature serializationFeature0 = SerializationFeature.WRITE_DATES_WITH_CONTEXT_TIME_ZONE;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRITE_DATES_WITH_CONTEXT_TIME_ZONE + "'", serializationFeature0.equals(SerializationFeature.WRITE_DATES_WITH_CONTEXT_TIME_ZONE));
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        java.util.Iterator<String> strItor3 = doubleNode1.fieldNames();
        // The following exception was thrown during execution in test generation
        try {
            JsonNode jsonNode5 = doubleNode1.at("`java.lang.Double`");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid input: JSON Pointer expression must start with '/': \"`java.lang.Double`\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strItor3);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        JavaType javaType0 = null;
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer4 = null;
        BeanProperty beanProperty5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer mapEntrySerializer6 = new com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer(javaType0, javaType1, javaType2, false, typeSerializer4, beanProperty5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        MapperFeature mapperFeature0 = MapperFeature.ALLOW_VOID_VALUED_PROPERTIES;
        boolean boolean1 = mapperFeature0.enabledByDefault();
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.ALLOW_VOID_VALUED_PROPERTIES + "'", mapperFeature0.equals(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        JavaType javaType2 = null;
        com.fasterxml.jackson.databind.exc.InvalidDefinitionException invalidDefinitionException3 = com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(jsonParser0, "`java.lang.Double`", javaType2);
        org.junit.Assert.assertNotNull(invalidDefinitionException3);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver mixInResolver0 = null;
        com.fasterxml.jackson.databind.introspect.SimpleMixInResolver simpleMixInResolver1 = new com.fasterxml.jackson.databind.introspect.SimpleMixInResolver(mixInResolver0);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature0 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.READ_NULL_PROPERTIES;
        org.junit.Assert.assertTrue("'" + jsonNodeFeature0 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.READ_NULL_PROPERTIES + "'", jsonNodeFeature0.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.READ_NULL_PROPERTIES));
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        SerializationConfig serializationConfig0 = null;
        com.fasterxml.jackson.databind.introspect.AnnotatedClass annotatedClass1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.EnumValues enumValues2 = com.fasterxml.jackson.databind.util.EnumValues.construct(serializationConfig0, annotatedClass1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        com.fasterxml.jackson.databind.deser.DeserializerFactory deserializerFactory0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl impl1 = new com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl(deserializerFactory0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        long long3 = doubleNode1.longValue();
        int int5 = doubleNode1.asInt((int) (short) 100);
        boolean boolean6 = doubleNode1.isShort();
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 1L + "'", long3 == 1L);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion inclusion0 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.DEFAULT_INCLUSION;
        org.junit.Assert.assertTrue("'" + inclusion0 + "' != '" + com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.DEFAULT_INCLUSION + "'", inclusion0.equals(com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.DEFAULT_INCLUSION));
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        EnumNamingStrategies.LowerCaseStrategy lowerCaseStrategy0 = EnumNamingStrategies.LowerCaseStrategy.INSTANCE;
        org.junit.Assert.assertNotNull(lowerCaseStrategy0);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray1 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList2 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, settableBeanPropertyArray1);
        java.util.Map<String, java.util.List<PropertyName>> strMap4 = null;
        java.util.Locale locale5 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap6 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, strMap4, locale5);
        JsonMappingException.Reference reference7 = new JsonMappingException.Reference((Object) true);
        org.junit.Assert.assertNotNull(settableBeanPropertyArray1);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray1, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature0 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES;
        int int1 = jsonNodeFeature0.featureIndex();
        org.junit.Assert.assertTrue("'" + jsonNodeFeature0 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES + "'", jsonNodeFeature0.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 1 + "'", int1 == 1);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        MapperFeature mapperFeature0 = MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES + "'", mapperFeature0.equals(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        DeserializationContext deserializationContext4 = null;
        JsonMappingException jsonMappingException6 = JsonMappingException.from(deserializationContext4, "");
        JsonMappingException jsonMappingException7 = JsonMappingException.from(jsonGenerator2, "", (Throwable) jsonMappingException6);
        String[] strArray12 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet13 = new java.util.LinkedHashSet<String>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<String>) strSet13, strArray12);
        String[] strArray16 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet17 = new java.util.LinkedHashSet<String>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<String>) strSet17, strArray16);
        JavaType javaType19 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer21 = null;
        JsonSerializer<Object> objJsonSerializer22 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer23 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer25 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet13, (java.util.Set<String>) strSet17, javaType19, false, typeSerializer21, objJsonSerializer22, objJsonSerializer23, (Object) 14);
        // The following exception was thrown during execution in test generation
        try {
            floatArraySerializer0.wrapAndThrow(serializerProvider1, (Throwable) jsonMappingException6, (Object) objJsonSerializer23, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.databind.JsonMappingException; message: ");
        } catch (JsonMappingException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonMappingException6);
        org.junit.Assert.assertNotNull(jsonMappingException7);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertArrayEquals(strArray12, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer22);
        org.junit.Assert.assertNotNull(objJsonSerializer23);
        org.junit.Assert.assertNotNull(mapSerializer25);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        com.fasterxml.jackson.databind.introspect.AnnotatedMember annotatedMember0 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer1 = null;
        String[] strArray6 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet7 = new java.util.LinkedHashSet<String>();
        boolean boolean8 = java.util.Collections.addAll((java.util.Collection<String>) strSet7, strArray6);
        String[] strArray10 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet11 = new java.util.LinkedHashSet<String>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<String>) strSet11, strArray10);
        JavaType javaType13 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer15 = null;
        JsonSerializer<Object> objJsonSerializer16 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer17 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer19 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet7, (java.util.Set<String>) strSet11, javaType13, false, typeSerializer15, objJsonSerializer16, objJsonSerializer17, (Object) 14);
        String[] strArray24 = new String[] { "[null]", "''", "''", "[null]" };
        java.util.LinkedHashSet<String> strSet25 = new java.util.LinkedHashSet<String>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<String>) strSet25, strArray24);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.std.JsonValueSerializer jsonValueSerializer27 = new com.fasterxml.jackson.databind.ser.std.JsonValueSerializer(annotatedMember0, typeSerializer1, objJsonSerializer16, (java.util.Set<String>) strSet25);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
        org.junit.Assert.assertNotNull(objJsonSerializer17);
        org.junit.Assert.assertNotNull(mapSerializer19);
        org.junit.Assert.assertNotNull(strArray24);
        org.junit.Assert.assertArrayEquals(strArray24, new String[] { "[null]", "''", "''", "[null]" });
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        int int0 = com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.TYPE_CALENDAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        com.fasterxml.jackson.databind.introspect.AnnotatedMember annotatedMember0 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer1 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer2 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider3 = null;
        BeanProperty beanProperty4 = null;
        JsonSerializer<?> wildcardJsonSerializer5 = floatArraySerializer2.createContextual(serializerProvider3, beanProperty4);
        String[] strArray10 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet11 = new java.util.LinkedHashSet<String>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<String>) strSet11, strArray10);
        String[] strArray14 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet15 = new java.util.LinkedHashSet<String>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<String>) strSet15, strArray14);
        JavaType javaType17 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer19 = null;
        JsonSerializer<Object> objJsonSerializer20 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer21 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer23 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet11, (java.util.Set<String>) strSet15, javaType17, false, typeSerializer19, objJsonSerializer20, objJsonSerializer21, (Object) 14);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.std.JsonValueSerializer jsonValueSerializer24 = new com.fasterxml.jackson.databind.ser.std.JsonValueSerializer(annotatedMember0, typeSerializer1, (JsonSerializer<Object>) wildcardJsonSerializer5, (java.util.Set<String>) strSet11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardJsonSerializer5);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(strArray14);
        org.junit.Assert.assertArrayEquals(strArray14, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer20);
        org.junit.Assert.assertNotNull(objJsonSerializer21);
        org.junit.Assert.assertNotNull(mapSerializer23);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor.Base base0 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor.Base();
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        com.fasterxml.jackson.databind.exc.MismatchedInputException mismatchedInputException2 = com.fasterxml.jackson.databind.exc.MismatchedInputException.from(jsonParser0, "`java.lang.Double`");
        Throwable throwable3 = com.fasterxml.jackson.databind.util.ClassUtil.throwIfError((Throwable) mismatchedInputException2);
        org.junit.Assert.assertNotNull(mismatchedInputException2);
        org.junit.Assert.assertNotNull(throwable3);
        org.junit.Assert.assertEquals(throwable3.getLocalizedMessage(), "`java.lang.Double`");
        org.junit.Assert.assertEquals(throwable3.getMessage(), "`java.lang.Double`");
        org.junit.Assert.assertEquals(throwable3.toString(), "com.fasterxml.jackson.databind.exc.MismatchedInputException: `java.lang.Double`");
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        PropertyNamingStrategy propertyNamingStrategy0 = PropertyNamingStrategy.SNAKE_CASE;
        org.junit.Assert.assertNotNull(propertyNamingStrategy0);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        SerializerProvider serializerProvider3 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer4 = null;
        // The following exception was thrown during execution in test generation
        try {
            arrayNode1.serializeWithType(jsonGenerator2, serializerProvider3, typeSerializer4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        // The following exception was thrown during execution in test generation
        try {
            JsonNode jsonNode2 = arrayNode1.missingNode();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        String[] strArray3 = new String[] { "hi!", "", "hi!" };
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter simpleBeanPropertyFilter4 = com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept(strArray3);
        com.fasterxml.jackson.databind.ser.BeanPropertyWriter beanPropertyWriter5 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor jsonObjectFormatVisitor6 = null;
        SerializerProvider serializerProvider7 = null;
        // The following exception was thrown during execution in test generation
        try {
            simpleBeanPropertyFilter4.depositSchemaProperty(beanPropertyWriter5, jsonObjectFormatVisitor6, serializerProvider7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new String[] { "hi!", "", "hi!" });
        org.junit.Assert.assertNotNull(simpleBeanPropertyFilter4);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        DeserializationConfig deserializationConfig0 = null;
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer2 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern3 = atomicBooleanDeserializer2.getEmptyAccessPattern();
        // The following exception was thrown during execution in test generation
        try {
            KeyDeserializer keyDeserializer4 = com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers.constructDelegatingKeyDeserializer(deserializationConfig0, javaType1, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + accessPattern3 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT + "'", accessPattern3.equals(com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT));
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        BeanDescription beanDescription0 = null;
        DeserializationContext deserializationContext1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder beanDeserializerBuilder2 = new com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder(beanDescription0, deserializationContext1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        com.fasterxml.jackson.databind.type.LogicalType logicalType0 = com.fasterxml.jackson.databind.type.LogicalType.POJO;
        org.junit.Assert.assertTrue("'" + logicalType0 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.POJO + "'", logicalType0.equals(com.fasterxml.jackson.databind.type.LogicalType.POJO));
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        int int0 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.Std.STD_URL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.text.DateFormat dateFormat2 = java.text.DateFormat.getDateInstance(9, locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal date style 9");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        com.fasterxml.jackson.databind.util.NamingStrategyImpls namingStrategyImpls0 = com.fasterxml.jackson.databind.util.NamingStrategyImpls.LOWER_CAMEL_CASE;
        org.junit.Assert.assertNotNull(namingStrategyImpls0);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        com.fasterxml.jackson.databind.introspect.AnnotatedMember annotatedMember0 = null;
        JsonSerializer<Object> objJsonSerializer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.std.JsonValueSerializer jsonValueSerializer2 = new com.fasterxml.jackson.databind.ser.std.JsonValueSerializer(annotatedMember0, objJsonSerializer1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray1 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList2 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, settableBeanPropertyArray1);
        java.util.Map<String, java.util.List<PropertyName>> strMap4 = null;
        java.util.Locale locale5 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap6 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, strMap4, locale5);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.SettableBeanProperty settableBeanProperty8 = beanPropertyMap6.find("com.fasterxml.jackson.databind.JsonMappingException: ");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(settableBeanPropertyArray1);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray1, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        SerializationFeature serializationFeature0 = SerializationFeature.WRITE_NULL_MAP_VALUES;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRITE_NULL_MAP_VALUES + "'", serializationFeature0.equals(SerializationFeature.WRITE_NULL_MAP_VALUES));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        com.fasterxml.jackson.databind.introspect.AnnotatedMember annotatedMember0 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer1 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider2 = null;
        BeanProperty beanProperty3 = null;
        JsonSerializer<?> wildcardJsonSerializer4 = floatArraySerializer1.createContextual(serializerProvider2, beanProperty3);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.std.JsonValueSerializer jsonValueSerializer5 = new com.fasterxml.jackson.databind.ser.std.JsonValueSerializer(annotatedMember0, (JsonSerializer<Object>) wildcardJsonSerializer4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardJsonSerializer4);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        PropertyNamingStrategies.UpperSnakeCaseStrategy upperSnakeCaseStrategy0 = PropertyNamingStrategies.UpperSnakeCaseStrategy.INSTANCE;
        org.junit.Assert.assertNotNull(upperSnakeCaseStrategy0);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        int int0 = java.text.DateFormat.DATE_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        java.util.stream.Stream<EnumNamingStrategies.LowerCaseStrategy> lowerCaseStrategyStream0 = com.fasterxml.jackson.databind.util.ClassUtil.emptyStream();
        org.junit.Assert.assertNotNull(lowerCaseStrategyStream0);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        int int0 = java.text.DateFormat.HOUR_OF_DAY1_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams0 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode1 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator2 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams0, mode1);
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode3 = potentialCreator2.creatorMode();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = potentialCreator2.hasExplicitNames();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + mode3 + "' != '" + com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT + "'", mode3.equals(com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT));
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver1 = null;
        JavaType javaType4 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as5 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer6 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType0, typeIdResolver1, "`java.lang.Double`", true, javaType4, as5);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver7 = asPropertyTypeDeserializer6.getTypeIdResolver();
        org.junit.Assert.assertNull(typeIdResolver7);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        com.fasterxml.jackson.databind.util.NamingStrategyImpls namingStrategyImpls0 = com.fasterxml.jackson.databind.util.NamingStrategyImpls.LOWER_DOT_CASE;
        org.junit.Assert.assertNotNull(namingStrategyImpls0);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder beanDeserializerBuilder0 = null;
        BeanDescription beanDescription1 = null;
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray3 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList4 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean5 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList4, settableBeanPropertyArray3);
        java.util.Map<String, java.util.List<PropertyName>> strMap6 = null;
        java.util.Locale locale7 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap8 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList4, strMap6, locale7);
        java.util.Map<String, com.fasterxml.jackson.databind.deser.SettableBeanProperty> strMap9 = null;
        String[] strArray14 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet15 = new java.util.LinkedHashSet<String>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<String>) strSet15, strArray14);
        String[] strArray18 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet19 = new java.util.LinkedHashSet<String>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<String>) strSet19, strArray18);
        JavaType javaType21 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer23 = null;
        JsonSerializer<Object> objJsonSerializer24 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer25 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer27 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet15, (java.util.Set<String>) strSet19, javaType21, false, typeSerializer23, objJsonSerializer24, objJsonSerializer25, (Object) 14);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer30 = new com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer(beanDeserializerBuilder0, beanDescription1, beanPropertyMap8, strMap9, (java.util.Set<String>) strSet15, true, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(settableBeanPropertyArray3);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray3, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(strArray14);
        org.junit.Assert.assertArrayEquals(strArray14, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(strArray18);
        org.junit.Assert.assertArrayEquals(strArray18, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer24);
        org.junit.Assert.assertNotNull(objJsonSerializer25);
        org.junit.Assert.assertNotNull(mapSerializer27);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        EnumNamingStrategy enumNamingStrategy0 = EnumNamingStrategies.UPPER_CAMEL_CASE;
        org.junit.Assert.assertNotNull(enumNamingStrategy0);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        int int0 = java.text.DateFormat.LONG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.NumericNode numericNode3 = arrayNode1.numberNode((double) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator0 = null;
        DeserializationContext deserializationContext2 = null;
        JsonMappingException jsonMappingException4 = JsonMappingException.from(deserializationContext2, "");
        JsonMappingException jsonMappingException5 = JsonMappingException.from(jsonGenerator0, "", (Throwable) jsonMappingException4);
        RuntimeJsonMappingException runtimeJsonMappingException6 = new RuntimeJsonMappingException(jsonMappingException4);
        Throwable[] throwableArray7 = runtimeJsonMappingException6.getSuppressed();
        org.junit.Assert.assertNotNull(jsonMappingException4);
        org.junit.Assert.assertNotNull(jsonMappingException5);
        org.junit.Assert.assertNotNull(throwableArray7);
        org.junit.Assert.assertArrayEquals(throwableArray7, new Throwable[] {});
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        com.fasterxml.jackson.databind.type.LogicalType logicalType0 = com.fasterxml.jackson.databind.type.LogicalType.Integer;
        org.junit.Assert.assertTrue("'" + logicalType0 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Integer + "'", logicalType0.equals(com.fasterxml.jackson.databind.type.LogicalType.Integer));
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        java.text.ParsePosition parsePosition1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = com.fasterxml.jackson.databind.util.ISO8601Utils.parse("`java.lang.Double`", parsePosition1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        com.fasterxml.jackson.databind.ext.SqlBlobSerializer sqlBlobSerializer0 = new com.fasterxml.jackson.databind.ext.SqlBlobSerializer();
        SerializerProvider serializerProvider1 = null;
        java.lang.reflect.Type type2 = null;
        JsonNode jsonNode3 = sqlBlobSerializer0.getSchema(serializerProvider1, type2);
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper jsonFormatVisitorWrapper4 = null;
        JavaType javaType5 = null;
        // The following exception was thrown during execution in test generation
        try {
            sqlBlobSerializer0.acceptJsonFormatVisitor(jsonFormatVisitorWrapper4, javaType5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonNode3);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        com.fasterxml.jackson.databind.util.NamingStrategyImpls namingStrategyImpls0 = com.fasterxml.jackson.databind.util.NamingStrategyImpls.KEBAB_CASE;
        org.junit.Assert.assertNotNull(namingStrategyImpls0);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer1 = stringArraySerializer0.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer3 = stringArraySerializer0.withValueTypeSerializer(typeSerializer2);
        BeanProperty beanProperty4 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = stringArraySerializer0._withResolved(beanProperty4, (Boolean) false);
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer7 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer8 = stringArraySerializer7.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer9 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer10 = stringArraySerializer7.withValueTypeSerializer(typeSerializer9);
        BeanProperty beanProperty11 = null;
        JsonSerializer<?> wildcardJsonSerializer13 = stringArraySerializer7._withResolved(beanProperty11, (Boolean) false);
        // The following exception was thrown during execution in test generation
        try {
            JsonSerializer<String[]> strArrayJsonSerializer14 = stringArraySerializer0.replaceDelegatee((JsonSerializer<Object>) wildcardJsonSerializer13);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: null");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNull(wildcardJsonSerializer1);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(stringArraySerializer7);
        org.junit.Assert.assertNull(wildcardJsonSerializer8);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer10);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer13);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        java.util.Iterator<String> strItor3 = doubleNode1.fieldNames();
        int int4 = doubleNode1.intValue();
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strItor3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer calendarDeserializer0 = new com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer();
        JavaType javaType1 = calendarDeserializer0.getValueType();
        java.util.Calendar calendar2 = calendarDeserializer0.getNullValue();
        org.junit.Assert.assertNull(javaType1);
        org.junit.Assert.assertNull(calendar2);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        String[] strArray4 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet5 = new java.util.LinkedHashSet<String>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<String>) strSet5, strArray4);
        String[] strArray8 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        JavaType javaType11 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer13 = null;
        JsonSerializer<Object> objJsonSerializer14 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer17 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet5, (java.util.Set<String>) strSet9, javaType11, false, typeSerializer13, objJsonSerializer14, objJsonSerializer15, (Object) 14);
        String[] strArray22 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet23 = new java.util.LinkedHashSet<String>();
        boolean boolean24 = java.util.Collections.addAll((java.util.Collection<String>) strSet23, strArray22);
        String[] strArray26 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet27 = new java.util.LinkedHashSet<String>();
        boolean boolean28 = java.util.Collections.addAll((java.util.Collection<String>) strSet27, strArray26);
        JavaType javaType29 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer31 = null;
        JsonSerializer<Object> objJsonSerializer32 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer33 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer35 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet23, (java.util.Set<String>) strSet27, javaType29, false, typeSerializer31, objJsonSerializer32, objJsonSerializer33, (Object) 14);
        String[] strArray40 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet41 = new java.util.LinkedHashSet<String>();
        boolean boolean42 = java.util.Collections.addAll((java.util.Collection<String>) strSet41, strArray40);
        String[] strArray44 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet45 = new java.util.LinkedHashSet<String>();
        boolean boolean46 = java.util.Collections.addAll((java.util.Collection<String>) strSet45, strArray44);
        JavaType javaType47 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer49 = null;
        JsonSerializer<Object> objJsonSerializer50 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer51 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer53 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet41, (java.util.Set<String>) strSet45, javaType47, false, typeSerializer49, objJsonSerializer50, objJsonSerializer51, (Object) 14);
        com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker checker54 = com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker.construct((java.util.Set<String>) strSet23, (java.util.Set<String>) strSet41);
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode55 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean56 = booleanNode55.isBinary();
        boolean boolean57 = booleanNode55.isTextual();
        String[] strArray60 = new String[] { "" };
        java.util.ArrayList<String> strList61 = new java.util.ArrayList<String>();
        boolean boolean62 = java.util.Collections.addAll((java.util.Collection<String>) strList61, strArray60);
        java.util.List<String> strList63 = booleanNode55.findValuesAsText("", (java.util.List<String>) strList61);
        boolean boolean64 = com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.shouldIgnore((Object) objJsonSerializer14, (java.util.Collection<String>) strSet23, (java.util.Collection<String>) strList63);
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertArrayEquals(strArray4, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer14);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(mapSerializer17);
        org.junit.Assert.assertNotNull(strArray22);
        org.junit.Assert.assertArrayEquals(strArray22, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(strArray26);
        org.junit.Assert.assertArrayEquals(strArray26, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer32);
        org.junit.Assert.assertNotNull(objJsonSerializer33);
        org.junit.Assert.assertNotNull(mapSerializer35);
        org.junit.Assert.assertNotNull(strArray40);
        org.junit.Assert.assertArrayEquals(strArray40, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertNotNull(strArray44);
        org.junit.Assert.assertArrayEquals(strArray44, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + true + "'", boolean46 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer50);
        org.junit.Assert.assertNotNull(objJsonSerializer51);
        org.junit.Assert.assertNotNull(mapSerializer53);
        org.junit.Assert.assertNotNull(checker54);
        org.junit.Assert.assertNotNull(booleanNode55);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNotNull(strArray60);
        org.junit.Assert.assertArrayEquals(strArray60, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + true + "'", boolean62 == true);
        org.junit.Assert.assertNotNull(strList63);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + true + "'", boolean64 == true);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) 0 };
        com.fasterxml.jackson.databind.node.BinaryNode binaryNode5 = com.fasterxml.jackson.databind.node.BinaryNode.valueOf(byteArray2, 100, (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.BinaryNode binaryNode8 = com.fasterxml.jackson.databind.node.BinaryNode.valueOf(byteArray2, 0, (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 0, (byte) 0 });
        org.junit.Assert.assertNotNull(binaryNode5);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes jsonFormatTypes0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.ARRAY;
        org.junit.Assert.assertTrue("'" + jsonFormatTypes0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.ARRAY + "'", jsonFormatTypes0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes.ARRAY));
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer0 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass1 = tokenBufferSerializer0.handledType();
        com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer2 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        SerializerProvider serializerProvider4 = null;
        // The following exception was thrown during execution in test generation
        try {
            tokenBufferSerializer0.serialize(tokenBuffer2, jsonGenerator3, serializerProvider4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass1);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        java.util.Map<String, Object> strMap0 = null;
        InjectableValues.Std std1 = new InjectableValues.Std(strMap0);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        SerializationFeature serializationFeature0 = SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS + "'", serializationFeature0.equals(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS));
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        com.fasterxml.jackson.databind.cfg.CoercionInputShape coercionInputShape0 = com.fasterxml.jackson.databind.cfg.CoercionInputShape.Binary;
        org.junit.Assert.assertTrue("'" + coercionInputShape0 + "' != '" + com.fasterxml.jackson.databind.cfg.CoercionInputShape.Binary + "'", coercionInputShape0.equals(com.fasterxml.jackson.databind.cfg.CoercionInputShape.Binary));
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        String str1 = com.fasterxml.jackson.databind.util.ClassUtil.nonNullString("1.0");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "1.0" + "'", str1, "1.0");
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        com.fasterxml.jackson.databind.ser.std.InetAddressSerializer inetAddressSerializer0 = new com.fasterxml.jackson.databind.ser.std.InetAddressSerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer1 = null;
        JsonSerializer<java.net.InetAddress> inetAddressJsonSerializer2 = inetAddressSerializer0.unwrappingSerializer(nameTransformer1);
        org.junit.Assert.assertNotNull(inetAddressJsonSerializer2);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        com.fasterxml.jackson.databind.node.IntNode intNode1 = new com.fasterxml.jackson.databind.node.IntNode((int) '4');
        boolean boolean2 = intNode1.isIntegralNumber();
        boolean boolean4 = intNode1.asBoolean(false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        EnumNamingStrategy enumNamingStrategy0 = EnumNamingStrategies.UPPER_SNAKE_CASE;
        org.junit.Assert.assertNotNull(enumNamingStrategy0);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer tokenBufferDeserializer0 = new com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer();
        com.fasterxml.jackson.core.JsonParser jsonParser1 = null;
        DeserializationContext deserializationContext2 = null;
        com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer4 = tokenBufferDeserializer0.deserialize(jsonParser1, deserializationContext2, tokenBuffer3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer1 = stringArraySerializer0.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer3 = stringArraySerializer0.withValueTypeSerializer(typeSerializer2);
        BeanProperty beanProperty4 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = stringArraySerializer0._withResolved(beanProperty4, (Boolean) false);
        JsonSerializer<?> wildcardJsonSerializer7 = stringArraySerializer0.getContentSerializer();
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNull(wildcardJsonSerializer1);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNull(wildcardJsonSerializer7);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        SerializationFeature serializationFeature0 = SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRITE_DATES_AS_TIMESTAMPS + "'", serializationFeature0.equals(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS));
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base0 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        SerializerProvider serializerProvider1 = null;
        base0.setProvider(serializerProvider1);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        PropertyMetadata propertyMetadata4 = PropertyMetadata.construct(true, "`java.lang.Double`", (Integer) 0, "");
        boolean boolean5 = propertyMetadata4.isRequired();
        org.junit.Assert.assertNotNull(propertyMetadata4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty4 = null;
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer5 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (byte) 1, objectIdReader3, settableAnyProperty4);
        boolean boolean6 = propertyValueBuffer5.isComplete();
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        MapperFeature mapperFeature0 = MapperFeature.AUTO_DETECT_IS_GETTERS;
        boolean boolean1 = mapperFeature0.enabledByDefault();
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.AUTO_DETECT_IS_GETTERS + "'", mapperFeature0.equals(MapperFeature.AUTO_DETECT_IS_GETTERS));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        com.fasterxml.jackson.databind.ser.std.BooleanSerializer booleanSerializer1 = new com.fasterxml.jackson.databind.ser.std.BooleanSerializer(true);
        SerializerProvider serializerProvider2 = null;
        com.fasterxml.jackson.core.JsonParser jsonParser3 = null;
        com.fasterxml.jackson.databind.exc.MismatchedInputException mismatchedInputException5 = com.fasterxml.jackson.databind.exc.MismatchedInputException.from(jsonParser3, "`java.lang.Double`");
        RuntimeJsonMappingException runtimeJsonMappingException6 = new RuntimeJsonMappingException((JsonMappingException) mismatchedInputException5);
        com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor singleArgConstructor7 = com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor.PROPERTIES;
        // The following exception was thrown during execution in test generation
        try {
            booleanSerializer1.wrapAndThrow(serializerProvider2, (Throwable) mismatchedInputException5, (Object) singleArgConstructor7, 1);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.databind.exc.MismatchedInputException; message: `java.lang.Double`");
        } catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mismatchedInputException5);
        org.junit.Assert.assertTrue("'" + singleArgConstructor7 + "' != '" + com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor.PROPERTIES + "'", singleArgConstructor7.equals(com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor.PROPERTIES));
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        JavaType javaType1 = null;
        DeserializationContext deserializationContext2 = null;
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator3 = null;
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray4 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator propertyBasedCreator6 = com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator.construct(deserializationContext2, valueInstantiator3, settableBeanPropertyArray4, false);
        com.fasterxml.jackson.databind.introspect.AnnotatedMethod annotatedMethod7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer beanAsArrayBuilderDeserializer8 = new com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer(beanDeserializerBase0, javaType1, settableBeanPropertyArray4, annotatedMethod7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(settableBeanPropertyArray4);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray4, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertNotNull(propertyBasedCreator6);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        BeanDescription beanDescription2 = null;
        com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition beanPropertyDefinition3 = null;
        com.fasterxml.jackson.databind.exc.InvalidDefinitionException invalidDefinitionException4 = com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(jsonParser0, "", beanDescription2, beanPropertyDefinition3);
        org.junit.Assert.assertNotNull(invalidDefinitionException4);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        String[] strArray5 = new String[] { "" };
        java.util.ArrayList<String> strList6 = new java.util.ArrayList<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strList6, strArray5);
        java.util.List<String> strList8 = booleanNode0.findValuesAsText("", (java.util.List<String>) strList6);
        boolean boolean9 = booleanNode0.isNumber();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.IntNode intNode10 = booleanNode0.deepCopy();
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: Cannot cast com.fasterxml.jackson.databind.node.BooleanNode to com.fasterxml.jackson.databind.node.IntNode");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strList8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        long long3 = doubleNode1.longValue();
        int int5 = doubleNode1.asInt((int) (short) 100);
        java.util.Optional<JsonNode> jsonNodeOptional7 = doubleNode1.optional((-1));
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 1L + "'", long3 == 1L);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(jsonNodeOptional7);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0.createContextual(serializerProvider1, beanProperty2);
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer0.createContextual(serializerProvider4, beanProperty5);
        SerializerProvider serializerProvider7 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator8 = null;
        DeserializationContext deserializationContext10 = null;
        JsonMappingException jsonMappingException12 = JsonMappingException.from(deserializationContext10, "");
        JsonMappingException jsonMappingException13 = JsonMappingException.from(jsonGenerator8, "", (Throwable) jsonMappingException12);
        RuntimeJsonMappingException runtimeJsonMappingException14 = new RuntimeJsonMappingException(jsonMappingException12);
        Object obj15 = null;
        // The following exception was thrown during execution in test generation
        try {
            floatArraySerializer0.wrapAndThrow(serializerProvider7, (Throwable) jsonMappingException12, obj15, "com.fasterxml.jackson.databind.JsonMappingException: ");
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.databind.JsonMappingException; message: ");
        } catch (JsonMappingException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(jsonMappingException12);
        org.junit.Assert.assertNotNull(jsonMappingException13);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        int int0 = com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.TYPE_INT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        int int0 = com.fasterxml.jackson.databind.util.ClassUtil.getJDKMajorVersion();
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.defaultInstance();
        org.junit.Assert.assertNotNull(typeFactory0);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        com.fasterxml.jackson.databind.node.NullNode nullNode0 = com.fasterxml.jackson.databind.node.NullNode.instance;
        // The following exception was thrown during execution in test generation
        try {
            JsonNode jsonNode2 = nullNode0.at("''");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid input: JSON Pointer expression must start with '/': \"''\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(nullNode0);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0.createContextual(serializerProvider1, beanProperty2);
        JsonSerializer<?> wildcardJsonSerializer4 = floatArraySerializer0.getContentSerializer();
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
        org.junit.Assert.assertNull(wildcardJsonSerializer4);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        Class<Integer> intClass0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer integerDeserializer2 = new com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer(intClass0, (Integer) 9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        com.fasterxml.jackson.core.JsonPointer jsonPointer3 = null;
        JsonNode.OverwriteMode overwriteMode4 = JsonNode.OverwriteMode.NULLS;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ObjectNode objectNode6 = booleanNode0.withObject(jsonPointer3, overwriteMode4, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + overwriteMode4 + "' != '" + JsonNode.OverwriteMode.NULLS + "'", overwriteMode4.equals(JsonNode.OverwriteMode.NULLS));
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        MapperFeature mapperFeature0 = MapperFeature.INVERSE_READ_WRITE_ACCESS;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.INVERSE_READ_WRITE_ACCESS + "'", mapperFeature0.equals(MapperFeature.INVERSE_READ_WRITE_ACCESS));
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass3);
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType5 = typeFactory0.constructSpecializedType(javaType1, tokenBufferClass3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        com.fasterxml.jackson.databind.util.ISO8601Utils iSO8601Utils0 = new com.fasterxml.jackson.databind.util.ISO8601Utils();
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        MapperFeature mapperFeature0 = MapperFeature.SORT_CREATOR_PROPERTIES_FIRST;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.SORT_CREATOR_PROPERTIES_FIRST + "'", mapperFeature0.equals(MapperFeature.SORT_CREATOR_PROPERTIES_FIRST));
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        PropertyNamingStrategy.SnakeCaseStrategy snakeCaseStrategy0 = new PropertyNamingStrategy.SnakeCaseStrategy();
        String str2 = snakeCaseStrategy0.translate("1.0");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1.0" + "'", str2, "1.0");
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        boolean boolean0 = com.fasterxml.jackson.databind.util.NativeImageUtil.isInNativeImageAndIsAtRuntime();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat0 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat2 = stdDateFormat0.withColonInTimeZone(false);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer3 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        String[] strArray8 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        String[] strArray12 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet13 = new java.util.LinkedHashSet<String>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<String>) strSet13, strArray12);
        JavaType javaType15 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer17 = null;
        JsonSerializer<Object> objJsonSerializer18 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer19 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer21 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet9, (java.util.Set<String>) strSet13, javaType15, false, typeSerializer17, objJsonSerializer18, objJsonSerializer19, (Object) 14);
        JsonSerializer<?> wildcardJsonSerializer22 = tokenBufferSerializer3.withIgnoredProperties((java.util.Set<String>) strSet9);
        boolean boolean23 = wildcardJsonSerializer22.isUnwrappingSerializer();
        // The following exception was thrown during execution in test generation
        try {
            String str24 = stdDateFormat2.format((Object) wildcardJsonSerializer22);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot format given Object as a Date");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stdDateFormat0);
        org.junit.Assert.assertNotNull(stdDateFormat2);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertArrayEquals(strArray12, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer18);
        org.junit.Assert.assertNotNull(objJsonSerializer19);
        org.junit.Assert.assertNotNull(mapSerializer21);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        com.fasterxml.jackson.databind.deser.std.UUIDDeserializer uUIDDeserializer0 = new com.fasterxml.jackson.databind.deser.std.UUIDDeserializer();
        com.fasterxml.jackson.core.JsonParser jsonParser1 = null;
        DeserializationContext deserializationContext2 = null;
        JavaType javaType3 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver4 = null;
        JavaType javaType7 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as8 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer9 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType3, typeIdResolver4, "`java.lang.Double`", true, javaType7, as8);
        java.util.UUID uUID10 = null;
        // The following exception was thrown during execution in test generation
        try {
            Object obj11 = uUIDDeserializer0.deserializeWithType(jsonParser1, deserializationContext2, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer9, uUID10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        PropertyNamingStrategy propertyNamingStrategy0 = PropertyNamingStrategy.LOWER_DOT_CASE;
        org.junit.Assert.assertNotNull(propertyNamingStrategy0);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode5 = arrayNode1.arrayNode();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        com.fasterxml.jackson.databind.util.RawValue rawValue2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode3 = arrayNode1.addRawValue(rawValue2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        ObjectMapper.DefaultTyping defaultTyping0 = ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS;
        org.junit.Assert.assertTrue("'" + defaultTyping0 + "' != '" + ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS + "'", defaultTyping0.equals(ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS));
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers stdKeyDeserializers0 = new com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers();
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        long long2 = doubleNode1.longValue();
        boolean boolean3 = doubleNode1.canConvertToInt();
        String str4 = doubleNode1.asText();
        com.fasterxml.jackson.core.JsonToken jsonToken5 = doubleNode1.asToken();
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 1L + "'", long2 == 1L);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1.0" + "'", str4, "1.0");
        org.junit.Assert.assertTrue("'" + jsonToken5 + "' != '" + com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT + "'", jsonToken5.equals(com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT));
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        com.fasterxml.jackson.databind.introspect.AnnotationMap annotationMap0 = null;
        com.fasterxml.jackson.databind.introspect.AnnotationMap annotationMap1 = null;
        com.fasterxml.jackson.databind.introspect.AnnotationMap annotationMap2 = com.fasterxml.jackson.databind.introspect.AnnotationMap.merge(annotationMap0, annotationMap1);
        org.junit.Assert.assertNull(annotationMap2);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode5 = arrayNode1.arrayNode((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty4 = null;
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer5 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (byte) 1, objectIdReader3, settableAnyProperty4);
        com.fasterxml.jackson.databind.deser.SettableBeanProperty settableBeanProperty6 = null;
        // The following exception was thrown during execution in test generation
        try {
            Object obj7 = propertyValueBuffer5.getParameter(settableBeanProperty6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        com.fasterxml.jackson.core.Version version0 = com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION;
        org.junit.Assert.assertNotNull(version0);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        com.fasterxml.jackson.annotation.JsonFormat.Value value0 = BeanProperty.EMPTY_FORMAT;
        org.junit.Assert.assertNotNull(value0);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        java.util.TimeZone timeZone0 = com.fasterxml.jackson.databind.util.StdDateFormat.getDefaultTimeZone();
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.text.DateFormat dateFormat2 = com.fasterxml.jackson.databind.util.StdDateFormat.getISO8601Format(timeZone0, locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone0);
        org.junit.Assert.assertEquals(timeZone0.getDisplayName(), "Coordinated Universal Time");
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        boolean boolean1 = floatArraySerializer0.usesObjectId();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ObjectNode objectNode6 = arrayNode1.insertObject(8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        com.fasterxml.jackson.databind.ext.SqlBlobSerializer sqlBlobSerializer0 = new com.fasterxml.jackson.databind.ext.SqlBlobSerializer();
        java.util.Iterator<com.fasterxml.jackson.databind.ser.PropertyWriter> propertyWriterItor1 = sqlBlobSerializer0.properties();
        String[] strArray6 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet7 = new java.util.LinkedHashSet<String>();
        boolean boolean8 = java.util.Collections.addAll((java.util.Collection<String>) strSet7, strArray6);
        String[] strArray10 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet11 = new java.util.LinkedHashSet<String>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<String>) strSet11, strArray10);
        JavaType javaType13 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer15 = null;
        JsonSerializer<Object> objJsonSerializer16 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer17 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer19 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet7, (java.util.Set<String>) strSet11, javaType13, false, typeSerializer15, objJsonSerializer16, objJsonSerializer17, (Object) 14);
        java.util.Iterator<com.fasterxml.jackson.databind.ser.PropertyWriter> propertyWriterItor20 = objJsonSerializer16.properties();
        // The following exception was thrown during execution in test generation
        try {
            JsonSerializer<java.sql.Blob> blobJsonSerializer21 = sqlBlobSerializer0.replaceDelegatee(objJsonSerializer16);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: null");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(propertyWriterItor1);
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
        org.junit.Assert.assertNotNull(objJsonSerializer17);
        org.junit.Assert.assertNotNull(mapSerializer19);
        org.junit.Assert.assertNotNull(propertyWriterItor20);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray1 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList2 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, settableBeanPropertyArray1);
        java.util.Map<String, java.util.List<PropertyName>> strMap4 = null;
        java.util.Locale locale5 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap6 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, strMap4, locale5);
        com.fasterxml.jackson.core.JsonParser jsonParser7 = null;
        DeserializationContext deserializationContext8 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer9 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider10 = null;
        BeanProperty beanProperty11 = null;
        JsonSerializer<?> wildcardJsonSerializer12 = floatArraySerializer9.createContextual(serializerProvider10, beanProperty11);
        SerializerProvider serializerProvider13 = null;
        BeanProperty beanProperty14 = null;
        JsonSerializer<?> wildcardJsonSerializer15 = floatArraySerializer9.createContextual(serializerProvider13, beanProperty14);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = beanPropertyMap6.findDeserializeAndSet(jsonParser7, deserializationContext8, (Object) floatArraySerializer9, "[null]");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(settableBeanPropertyArray1);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray1, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer12);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer15);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        SerializationFeature serializationFeature0 = SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRITE_EMPTY_JSON_ARRAYS + "'", serializationFeature0.equals(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS));
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ValueNode valueNode3 = arrayNode1.numberNode((Byte) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        JsonSerializer<?> wildcardJsonSerializer0 = com.fasterxml.jackson.databind.ext.CoreXMLSerializers.QNameSerializer.instance;
        PropertyNamingStrategy.SnakeCaseStrategy snakeCaseStrategy1 = new PropertyNamingStrategy.SnakeCaseStrategy();
        JsonSerializer<?> wildcardJsonSerializer2 = wildcardJsonSerializer0.withFilterId((Object) snakeCaseStrategy1);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer0);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer2);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode5 = arrayNode1.findParent("hi!");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode8 = arrayNode1.insert(9, (double) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNull(objectNode5);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            JsonNode jsonNode6 = arrayNode4.required(3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No value at index #3 [0, 0) of `ArrayNode`");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode6 = arrayNode1.insert((int) '4', (Double) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer2 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType0, "hi!");
        DeserializationContext deserializationContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType4 = unsupportedTypeDeserializer2.getValueType(deserializationContext3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        com.fasterxml.jackson.databind.deser.std.UUIDDeserializer uUIDDeserializer0 = new com.fasterxml.jackson.databind.deser.std.UUIDDeserializer();
        JsonDeserializer<?> wildcardJsonDeserializer1 = uUIDDeserializer0.getDelegatee();
        org.junit.Assert.assertNull(wildcardJsonDeserializer1);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        PropertyNamingStrategies.UpperSnakeCaseStrategy upperSnakeCaseStrategy0 = new PropertyNamingStrategies.UpperSnakeCaseStrategy();
        String str2 = upperSnakeCaseStrategy0.translate("[null]");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "[NULL]" + "'", str2, "[NULL]");
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern1 = atomicBooleanDeserializer0.getEmptyAccessPattern();
        com.fasterxml.jackson.databind.type.LogicalType logicalType2 = atomicBooleanDeserializer0.logicalType();
        org.junit.Assert.assertTrue("'" + accessPattern1 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT + "'", accessPattern1.equals(com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT));
        org.junit.Assert.assertTrue("'" + logicalType2 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Boolean + "'", logicalType2.equals(com.fasterxml.jackson.databind.type.LogicalType.Boolean));
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams0 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode1 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator2 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams0, mode1);
        // The following exception was thrown during execution in test generation
        try {
            PropertyName propertyName4 = potentialCreator2.explicitName((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        java.util.Iterator<JsonNode> jsonNodeItor4 = arrayNode1.elements();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode7 = arrayNode1.set(4, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(jsonNodeItor4);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer0 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass1 = tokenBufferSerializer0.handledType();
        boolean boolean2 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass1);
        com.fasterxml.jackson.databind.type.ClassKey classKey3 = new com.fasterxml.jackson.databind.type.ClassKey(tokenBufferClass1);
        org.junit.Assert.assertNotNull(tokenBufferClass1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        String[] strArray3 = new String[] { "hi!", "", "hi!" };
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter simpleBeanPropertyFilter4 = com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept(strArray3);
        Object obj5 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        SerializerProvider serializerProvider7 = null;
        com.fasterxml.jackson.databind.ser.PropertyWriter propertyWriter8 = null;
        // The following exception was thrown during execution in test generation
        try {
            simpleBeanPropertyFilter4.serializeAsField(obj5, jsonGenerator6, serializerProvider7, propertyWriter8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new String[] { "hi!", "", "hi!" });
        org.junit.Assert.assertNotNull(simpleBeanPropertyFilter4);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.NumericNode numericNode6 = arrayNode1.numberNode((long) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        com.fasterxml.jackson.databind.ser.std.CalendarSerializer calendarSerializer0 = new com.fasterxml.jackson.databind.ser.std.CalendarSerializer();
        java.util.Calendar calendar1 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        SerializerProvider serializerProvider3 = null;
        // The following exception was thrown during execution in test generation
        try {
            calendarSerializer0.serialize(calendar1, jsonGenerator2, serializerProvider3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Null SerializerProvider passed for java.util.Calendar");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        java.util.TimeZone timeZone0 = com.fasterxml.jackson.databind.util.StdDateFormat.getDefaultTimeZone();
        java.util.Locale locale1 = null;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat2 = new com.fasterxml.jackson.databind.util.StdDateFormat(timeZone0, locale1);
        org.junit.Assert.assertNotNull(timeZone0);
        org.junit.Assert.assertEquals(timeZone0.getDisplayName(), "Coordinated Universal Time");
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        MapperFeature mapperFeature0 = MapperFeature.SORT_PROPERTIES_ALPHABETICALLY;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.SORT_PROPERTIES_ALPHABETICALLY + "'", mapperFeature0.equals(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY));
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0.createContextual(serializerProvider1, beanProperty2);
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer0.createContextual(serializerProvider4, beanProperty5);
        String[] strArray11 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet12 = new java.util.LinkedHashSet<String>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<String>) strSet12, strArray11);
        String[] strArray15 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet16 = new java.util.LinkedHashSet<String>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<String>) strSet16, strArray15);
        JavaType javaType18 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer20 = null;
        JsonSerializer<Object> objJsonSerializer21 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer22 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer24 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet12, (java.util.Set<String>) strSet16, javaType18, false, typeSerializer20, objJsonSerializer21, objJsonSerializer22, (Object) 14);
        JsonSerializer<?> wildcardJsonSerializer25 = wildcardJsonSerializer6.withIgnoredProperties((java.util.Set<String>) strSet12);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(strArray15);
        org.junit.Assert.assertArrayEquals(strArray15, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer21);
        org.junit.Assert.assertNotNull(objJsonSerializer22);
        org.junit.Assert.assertNotNull(mapSerializer24);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer25);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        long long0 = MapperFeature.collectLongDefaults();
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 118117658363L + "'", long0 == 118117658363L);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty3 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory2);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass5);
        JavaType javaType8 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember9 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty3, tokenBufferClass5, "[null]", javaType8);
        com.fasterxml.jackson.databind.deser.std.FromStringDeserializer<?> wildcardFromStringDeserializer10 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.findDeserializer(tokenBufferClass5);
        com.fasterxml.jackson.databind.ser.std.ToStringSerializer toStringSerializer11 = new com.fasterxml.jackson.databind.ser.std.ToStringSerializer(tokenBufferClass5);
        // The following exception was thrown during execution in test generation
        try {
            Object obj12 = com.fasterxml.jackson.databind.jsontype.TypeDeserializer.deserializeIfNatural(jsonParser0, deserializationContext1, tokenBufferClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonParser.currentToken()Lcom/fasterxml/jackson/core/JsonToken;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(wildcardFromStringDeserializer10);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        Class<?>[] wildcardClassArray0 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.types();
        org.junit.Assert.assertNotNull(wildcardClassArray0);
        org.junit.Assert.assertArrayEquals(wildcardClassArray0, new Class[] { java.io.File.class, java.net.URL.class, java.net.URI.class, Class.class, JavaType.class, java.util.Currency.class, java.util.regex.Pattern.class, java.util.Locale.class, java.nio.charset.Charset.class, java.util.TimeZone.class, java.net.InetAddress.class, java.net.InetSocketAddress.class, StringBuilder.class, StringBuffer.class });
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator0 = null;
        JsonMappingException jsonMappingException2 = JsonMappingException.from(jsonGenerator0, "[null]");
        org.junit.Assert.assertNotNull(jsonMappingException2);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        com.fasterxml.jackson.databind.deser.std.UUIDDeserializer uUIDDeserializer0 = new com.fasterxml.jackson.databind.deser.std.UUIDDeserializer();
        DeserializationContext deserializationContext1 = null;
        java.util.UUID uUID2 = uUIDDeserializer0.getNullValue(deserializationContext1);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = uUIDDeserializer0.getObjectIdReader();
        org.junit.Assert.assertNull(uUID2);
        org.junit.Assert.assertNull(objectIdReader3);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode7 = arrayNode1.insert(6, "`java.lang.Double`");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern1 = atomicBooleanDeserializer0.getNullAccessPattern();
        com.fasterxml.jackson.core.JsonParser jsonParser2 = null;
        DeserializationContext deserializationContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean4 = atomicBooleanDeserializer0.deserialize(jsonParser2, deserializationContext3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonParser.currentToken()Lcom/fasterxml/jackson/core/JsonToken;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + accessPattern1 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern1.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer tokenBufferDeserializer0 = new com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer();
        DeserializationContext deserializationContext1 = null;
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType2 = tokenBufferDeserializer0.getValueType(deserializationContext1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode7 = arrayNode4.insert(4, (float) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        com.fasterxml.jackson.databind.util.IgnorePropertiesUtil ignorePropertiesUtil0 = new com.fasterxml.jackson.databind.util.IgnorePropertiesUtil();
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        DeserializationFeature deserializationFeature0 = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        org.junit.Assert.assertTrue("'" + deserializationFeature0 + "' != '" + DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS + "'", deserializationFeature0.equals(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS));
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        int int0 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.Std.STD_INET_ADDRESS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        PropertyName propertyName1 = new PropertyName("[NULL]");
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base0 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor jsonObjectFormatVisitor2 = base0.expectObjectFormat(javaType1);
        org.junit.Assert.assertNull(jsonObjectFormatVisitor2);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        com.fasterxml.jackson.databind.ext.NioPathDeserializer nioPathDeserializer0 = new com.fasterxml.jackson.databind.ext.NioPathDeserializer();
        java.util.Collection<Object> objCollection1 = nioPathDeserializer0.getKnownPropertyNames();
        DeserializationContext deserializationContext2 = null;
        java.nio.file.Path path3 = nioPathDeserializer0.getNullValue(deserializationContext2);
        org.junit.Assert.assertNull(objCollection1);
        org.junit.Assert.assertNull(path3);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer documentDeserializer0 = new com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer();
        JavaType javaType1 = documentDeserializer0.getValueType();
        DeserializationContext deserializationContext2 = null;
        Object obj3 = documentDeserializer0.getEmptyValue(deserializationContext2);
        org.junit.Assert.assertNull(javaType1);
        org.junit.Assert.assertNull(obj3);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = new com.fasterxml.jackson.databind.node.ObjectNode(jsonNodeFactory1);
        com.fasterxml.jackson.databind.util.RawValue rawValue3 = null;
        com.fasterxml.jackson.databind.node.ValueNode valueNode4 = objectNode2.rawValueNode(rawValue3);
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode4);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.ClassUtil.Ctor[] ctorArray1 = com.fasterxml.jackson.databind.util.ClassUtil.getConstructors(tokenBufferClass0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        PropertyNamingStrategies.KebabCaseStrategy kebabCaseStrategy0 = PropertyNamingStrategies.KebabCaseStrategy.INSTANCE;
        org.junit.Assert.assertNotNull(kebabCaseStrategy0);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        java.util.Map<com.fasterxml.jackson.databind.introspect.MemberKey, com.fasterxml.jackson.databind.introspect.AnnotatedMethod> memberKeyMap0 = null;
        com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap annotatedMethodMap1 = new com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap(memberKeyMap0);
        java.util.Iterator<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> annotatedMethodItor2 = annotatedMethodMap1.iterator();
        java.util.Iterator<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> annotatedMethodItor3 = annotatedMethodMap1.iterator();
        org.junit.Assert.assertNotNull(annotatedMethodItor2);
        org.junit.Assert.assertNotNull(annotatedMethodItor3);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        com.fasterxml.jackson.databind.ser.std.BooleanSerializer booleanSerializer1 = new com.fasterxml.jackson.databind.ser.std.BooleanSerializer(true);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        DeserializationContext deserializationContext4 = null;
        JsonMappingException jsonMappingException6 = JsonMappingException.from(deserializationContext4, "");
        JsonMappingException jsonMappingException7 = JsonMappingException.from(jsonGenerator2, "", (Throwable) jsonMappingException6);
        RuntimeJsonMappingException runtimeJsonMappingException8 = new RuntimeJsonMappingException(jsonMappingException6);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator9 = null;
        SerializerProvider serializerProvider10 = null;
        // The following exception was thrown during execution in test generation
        try {
            booleanSerializer1.serialize((Object) runtimeJsonMappingException8, jsonGenerator9, serializerProvider10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonMappingException6);
        org.junit.Assert.assertNotNull(jsonMappingException7);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer numberDeserializer0 = new com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer();
        DeserializationContext deserializationContext1 = null;
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType2 = numberDeserializer0.getValueType(deserializationContext1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        DeserializationContext deserializationContext0 = null;
        JavaType javaType1 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonDeserializer<?> wildcardJsonDeserializer2 = com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers.findForCollection(deserializationContext0, javaType1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        DeserializationContext deserializationContext4 = null;
        BeanProperty beanProperty5 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory6 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty7 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory6);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass9 = tokenBufferSerializer8.handledType();
        boolean boolean10 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember13 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty7, tokenBufferClass9, "[null]", javaType12);
        JavaType javaType14 = null;
        KeyDeserializer keyDeserializer15 = null;
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer18 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType16, "hi!");
        boolean boolean19 = unsupportedTypeDeserializer18.isCachable();
        JavaType javaType20 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver21 = null;
        JavaType javaType24 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as25 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer26 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType20, typeIdResolver21, "`java.lang.Double`", true, javaType24, as25);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty27 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext4, beanProperty5, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember13, javaType14, keyDeserializer15, (JsonDeserializer<Object>) unsupportedTypeDeserializer18, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer26);
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer28 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (short) 1, objectIdReader3, settableAnyProperty27);
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer29 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer30 = stringArraySerializer29.getContentSerializer();
        String[] strArray35 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet36 = new java.util.LinkedHashSet<String>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<String>) strSet36, strArray35);
        String[] strArray39 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet40 = new java.util.LinkedHashSet<String>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<String>) strSet40, strArray39);
        JavaType javaType42 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer44 = null;
        JsonSerializer<Object> objJsonSerializer45 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer46 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer48 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet36, (java.util.Set<String>) strSet40, javaType42, false, typeSerializer44, objJsonSerializer45, objJsonSerializer46, (Object) 14);
        String[] strArray53 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet54 = new java.util.LinkedHashSet<String>();
        boolean boolean55 = java.util.Collections.addAll((java.util.Collection<String>) strSet54, strArray53);
        String[] strArray57 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet58 = new java.util.LinkedHashSet<String>();
        boolean boolean59 = java.util.Collections.addAll((java.util.Collection<String>) strSet58, strArray57);
        JavaType javaType60 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer62 = null;
        JsonSerializer<Object> objJsonSerializer63 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer64 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer66 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet54, (java.util.Set<String>) strSet58, javaType60, false, typeSerializer62, objJsonSerializer63, objJsonSerializer64, (Object) 14);
        com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker checker67 = com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker.construct((java.util.Set<String>) strSet36, (java.util.Set<String>) strSet54);
        JsonSerializer<?> wildcardJsonSerializer68 = stringArraySerializer29.withIgnoredProperties((java.util.Set<String>) strSet36);
        EnumNamingStrategy enumNamingStrategy69 = EnumNamingStrategies.KEBAB_CASE;
        com.fasterxml.jackson.core.JsonParser jsonParser70 = null;
        com.fasterxml.jackson.databind.exc.MismatchedInputException mismatchedInputException72 = com.fasterxml.jackson.databind.exc.MismatchedInputException.from(jsonParser70, "`java.lang.Double`");
        RuntimeJsonMappingException runtimeJsonMappingException73 = new RuntimeJsonMappingException((JsonMappingException) mismatchedInputException72);
        // The following exception was thrown during execution in test generation
        try {
            settableAnyProperty27.set((Object) stringArraySerializer29, (Object) enumNamingStrategy69, (Object) mismatchedInputException72);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember cannot be cast to com.fasterxml.jackson.databind.introspect.AnnotatedMethod");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty27);
        org.junit.Assert.assertNotNull(stringArraySerializer29);
        org.junit.Assert.assertNull(wildcardJsonSerializer30);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertNotNull(strArray39);
        org.junit.Assert.assertArrayEquals(strArray39, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer45);
        org.junit.Assert.assertNotNull(objJsonSerializer46);
        org.junit.Assert.assertNotNull(mapSerializer48);
        org.junit.Assert.assertNotNull(strArray53);
        org.junit.Assert.assertArrayEquals(strArray53, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + true + "'", boolean55 == true);
        org.junit.Assert.assertNotNull(strArray57);
        org.junit.Assert.assertArrayEquals(strArray57, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + true + "'", boolean59 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer63);
        org.junit.Assert.assertNotNull(objJsonSerializer64);
        org.junit.Assert.assertNotNull(mapSerializer66);
        org.junit.Assert.assertNotNull(checker67);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer68);
        org.junit.Assert.assertNotNull(enumNamingStrategy69);
        org.junit.Assert.assertNotNull(mismatchedInputException72);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        PropertyName propertyName2 = PropertyName.construct("[NULL]", "''");
        org.junit.Assert.assertNotNull(propertyName2);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        // The following exception was thrown during execution in test generation
        try {
            JavaType[] javaTypeArray4 = typeFactory0.findTypeParameters(javaType1, tokenBufferClass3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        boolean boolean2 = longNode1.isNaN();
        // The following exception was thrown during execution in test generation
        try {
            JsonNode jsonNode4 = longNode1.required(8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Node of type `LongNode` has no indexed values");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        java.math.BigDecimal bigDecimal2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ValueNode valueNode3 = arrayNode1.numberNode(bigDecimal2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        JavaType javaType0 = null;
        JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean> atomicBooleanJsonDeserializer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer enumSetDeserializer2 = new com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer(javaType0, atomicBooleanJsonDeserializer1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        com.fasterxml.jackson.core.JsonParser.NumberType numberType2 = longNode1.numberType();
        java.util.Optional<JsonNode> jsonNodeOptional4 = longNode1.optional("`java.lang.Double`");
        org.junit.Assert.assertNotNull(longNode1);
        org.junit.Assert.assertTrue("'" + numberType2 + "' != '" + com.fasterxml.jackson.core.JsonParser.NumberType.LONG + "'", numberType2.equals(com.fasterxml.jackson.core.JsonParser.NumberType.LONG));
        org.junit.Assert.assertNotNull(jsonNodeOptional4);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        String[] strArray4 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet5 = new java.util.LinkedHashSet<String>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<String>) strSet5, strArray4);
        String[] strArray8 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        JavaType javaType11 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer13 = null;
        JsonSerializer<Object> objJsonSerializer14 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer17 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet5, (java.util.Set<String>) strSet9, javaType11, false, typeSerializer13, objJsonSerializer14, objJsonSerializer15, (Object) 14);
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode18 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        SerializerProvider serializerProvider19 = null;
        boolean boolean20 = booleanNode18.isEmpty(serializerProvider19);
        boolean boolean21 = booleanNode18.canConvertToExactIntegral();
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer22 = mapSerializer17.withFilterId((Object) boolean21);
        JsonSerializer<?> wildcardJsonSerializer23 = mapSerializer22.getKeySerializer();
        SerializerProvider serializerProvider24 = null;
        BeanProperty beanProperty25 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonSerializer<?> wildcardJsonSerializer26 = mapSerializer22.createContextual(serializerProvider24, beanProperty25);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertArrayEquals(strArray4, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer14);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(mapSerializer17);
        org.junit.Assert.assertNotNull(booleanNode18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(mapSerializer22);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer23);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        PropertyNamingStrategy propertyNamingStrategy0 = PropertyNamingStrategies.LOWER_DOT_CASE;
        org.junit.Assert.assertNotNull(propertyNamingStrategy0);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty0 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference1 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass3);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring6 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty0, unresolvedForwardReference1, tokenBufferClass3, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonLocation jsonLocation7 = propertyReferring6.getLocation();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        JavaType javaType0 = null;
        KeyDeserializer keyDeserializer1 = null;
        com.fasterxml.jackson.databind.module.SimpleDeserializers simpleDeserializers2 = new com.fasterxml.jackson.databind.module.SimpleDeserializers();
        com.fasterxml.jackson.databind.type.ReferenceType referenceType3 = null;
        DeserializationConfig deserializationConfig4 = null;
        BeanDescription beanDescription5 = null;
        DeserializationContext deserializationContext6 = null;
        BeanProperty beanProperty7 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory8 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty9 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory8);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer10 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass11 = tokenBufferSerializer10.handledType();
        boolean boolean12 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass11);
        JavaType javaType14 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember15 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty9, tokenBufferClass11, "[null]", javaType14);
        JavaType javaType16 = null;
        KeyDeserializer keyDeserializer17 = null;
        JavaType javaType18 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer20 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType18, "hi!");
        boolean boolean21 = unsupportedTypeDeserializer20.isCachable();
        JavaType javaType22 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver23 = null;
        JavaType javaType26 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as27 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer28 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType22, typeIdResolver23, "`java.lang.Double`", true, javaType26, as27);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty29 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext6, beanProperty7, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember15, javaType16, keyDeserializer17, (JsonDeserializer<Object>) unsupportedTypeDeserializer20, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer28);
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer30 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        JsonDeserializer<?> wildcardJsonDeserializer31 = simpleDeserializers2.findReferenceDeserializer(referenceType3, deserializationConfig4, beanDescription5, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer28, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer30);
        JavaType javaType32 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver33 = null;
        JavaType javaType36 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer asArrayTypeDeserializer37 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer(javaType32, typeIdResolver33, "", false, javaType36);
        boolean boolean38 = asArrayTypeDeserializer37.hasDefaultImpl();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer enumMapDeserializer39 = new com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer(javaType0, keyDeserializer1, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer30, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asArrayTypeDeserializer37);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty29);
        org.junit.Assert.assertNull(wildcardJsonDeserializer31);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        long long3 = doubleNode1.longValue();
        int int5 = doubleNode1.asInt((int) (short) 100);
        com.fasterxml.jackson.databind.ext.SqlBlobSerializer sqlBlobSerializer6 = new com.fasterxml.jackson.databind.ext.SqlBlobSerializer();
        java.util.Iterator<com.fasterxml.jackson.databind.ser.PropertyWriter> propertyWriterItor7 = sqlBlobSerializer6.properties();
        boolean boolean8 = doubleNode1.equals((Object) sqlBlobSerializer6);
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 1L + "'", long3 == 1L);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(propertyWriterItor7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        com.fasterxml.jackson.databind.node.IntNode intNode1 = new com.fasterxml.jackson.databind.node.IntNode((int) '4');
        boolean boolean2 = intNode1.isIntegralNumber();
        Number number3 = intNode1.numberValue();
        String str5 = intNode1.asText("hi!");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertEquals("'" + number3 + "' != '" + 52 + "'", number3, 52);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "52" + "'", str5, "52");
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        com.fasterxml.jackson.databind.util.EnumValues enumValues0 = null;
        com.fasterxml.jackson.databind.util.EnumValues enumValues2 = null;
        com.fasterxml.jackson.databind.util.EnumValues enumValues3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.std.EnumSerializer enumSerializer4 = new com.fasterxml.jackson.databind.ser.std.EnumSerializer(enumValues0, (Boolean) false, enumValues2, enumValues3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        EnumNamingStrategies.LowerDotCaseStrategy lowerDotCaseStrategy0 = EnumNamingStrategies.LowerDotCaseStrategy.INSTANCE;
        org.junit.Assert.assertNotNull(lowerDotCaseStrategy0);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean1 = atomicBooleanDeserializer0.getNullValue();
        org.junit.Assert.assertNull(atomicBoolean1);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig deserializerFactoryConfig0 = new com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig();
        com.fasterxml.jackson.databind.module.SimpleDeserializers simpleDeserializers1 = new com.fasterxml.jackson.databind.module.SimpleDeserializers();
        com.fasterxml.jackson.databind.type.ReferenceType referenceType2 = null;
        DeserializationConfig deserializationConfig3 = null;
        BeanDescription beanDescription4 = null;
        DeserializationContext deserializationContext5 = null;
        BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory7 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty8 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory7);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer9 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass10 = tokenBufferSerializer9.handledType();
        boolean boolean11 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass10);
        JavaType javaType13 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember14 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty8, tokenBufferClass10, "[null]", javaType13);
        JavaType javaType15 = null;
        KeyDeserializer keyDeserializer16 = null;
        JavaType javaType17 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer19 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType17, "hi!");
        boolean boolean20 = unsupportedTypeDeserializer19.isCachable();
        JavaType javaType21 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver22 = null;
        JavaType javaType25 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as26 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer27 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType21, typeIdResolver22, "`java.lang.Double`", true, javaType25, as26);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty28 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext5, beanProperty6, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember14, javaType15, keyDeserializer16, (JsonDeserializer<Object>) unsupportedTypeDeserializer19, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer27);
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer29 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        JsonDeserializer<?> wildcardJsonDeserializer30 = simpleDeserializers1.findReferenceDeserializer(referenceType2, deserializationConfig3, beanDescription4, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer27, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer29);
        com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig deserializerFactoryConfig31 = deserializerFactoryConfig0.withAdditionalDeserializers((com.fasterxml.jackson.databind.deser.Deserializers) simpleDeserializers1);
        org.junit.Assert.assertNotNull(tokenBufferClass10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty28);
        org.junit.Assert.assertNull(wildcardJsonDeserializer30);
        org.junit.Assert.assertNotNull(deserializerFactoryConfig31);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer0 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        String[] strArray5 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet6 = new java.util.LinkedHashSet<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strSet6, strArray5);
        String[] strArray9 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet10 = new java.util.LinkedHashSet<String>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<String>) strSet10, strArray9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer14 = null;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer16 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer18 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet6, (java.util.Set<String>) strSet10, javaType12, false, typeSerializer14, objJsonSerializer15, objJsonSerializer16, (Object) 14);
        JsonSerializer<?> wildcardJsonSerializer19 = tokenBufferSerializer0.withIgnoredProperties((java.util.Set<String>) strSet6);
        com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer20 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator21 = null;
        SerializerProvider serializerProvider22 = null;
        // The following exception was thrown during execution in test generation
        try {
            tokenBufferSerializer0.serialize(tokenBuffer20, jsonGenerator21, serializerProvider22);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
        org.junit.Assert.assertNotNull(mapSerializer18);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer19);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        EnumNamingStrategy enumNamingStrategy0 = EnumNamingStrategies.LOWER_CAMEL_CASE;
        org.junit.Assert.assertNotNull(enumNamingStrategy0);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        MapperFeature mapperFeature0 = MapperFeature.AUTO_DETECT_GETTERS;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.AUTO_DETECT_GETTERS + "'", mapperFeature0.equals(MapperFeature.AUTO_DETECT_GETTERS));
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        String[] strArray8 = new String[] { "`java.lang.Double`", "1.0", "[null]", "`java.lang.Double`", "''", "`java.lang.Double`", "com.fasterxml.jackson.databind.JsonMappingException: " };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter serializeExceptFilter11 = new com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter((java.util.Set<String>) strSet9);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BeanDeserializer beanDeserializer12 = new com.fasterxml.jackson.databind.deser.BeanDeserializer(beanDeserializerBase0, (java.util.Set<String>) strSet9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "`java.lang.Double`", "1.0", "[null]", "`java.lang.Double`", "''", "`java.lang.Double`", "com.fasterxml.jackson.databind.JsonMappingException: " });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        com.fasterxml.jackson.databind.node.LongNode longNode4 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        java.math.BigInteger bigInteger5 = longNode4.bigIntegerValue();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode6 = arrayNode1.set((int) (short) 10, bigInteger5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longNode4);
        org.junit.Assert.assertNotNull(bigInteger5);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.deser.impl.NullsFailProvider nullsFailProvider1 = com.fasterxml.jackson.databind.deser.impl.NullsFailProvider.constructForRootValue(javaType0);
        boolean boolean2 = com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider.isSkipper((com.fasterxml.jackson.databind.deser.NullValueProvider) nullsFailProvider1);
        org.junit.Assert.assertNotNull(nullsFailProvider1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        MapperFeature mapperFeature0 = MapperFeature.USE_GETTERS_AS_SETTERS;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.USE_GETTERS_AS_SETTERS + "'", mapperFeature0.equals(MapperFeature.USE_GETTERS_AS_SETTERS));
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat jsonValueFormat0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.IPV6;
        org.junit.Assert.assertTrue("'" + jsonValueFormat0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.IPV6 + "'", jsonValueFormat0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.IPV6));
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = new com.fasterxml.jackson.databind.node.ObjectNode(jsonNodeFactory1);
        com.fasterxml.jackson.databind.node.LongNode longNode4 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        java.math.BigInteger bigInteger5 = longNode4.bigIntegerValue();
        com.fasterxml.jackson.databind.node.ValueNode valueNode6 = objectNode2.numberNode(bigInteger5);
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(longNode4);
        org.junit.Assert.assertNotNull(bigInteger5);
        org.junit.Assert.assertNotNull(valueNode6);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer numberDeserializer0 = new com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern1 = numberDeserializer0.getNullAccessPattern();
        org.junit.Assert.assertTrue("'" + accessPattern1 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern1.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        DeserializationContext deserializationContext4 = null;
        BeanProperty beanProperty5 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory6 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty7 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory6);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass9 = tokenBufferSerializer8.handledType();
        boolean boolean10 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember13 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty7, tokenBufferClass9, "[null]", javaType12);
        JavaType javaType14 = null;
        KeyDeserializer keyDeserializer15 = null;
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer18 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType16, "hi!");
        boolean boolean19 = unsupportedTypeDeserializer18.isCachable();
        JavaType javaType20 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver21 = null;
        JavaType javaType24 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as25 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer26 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType20, typeIdResolver21, "`java.lang.Double`", true, javaType24, as25);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty27 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext4, beanProperty5, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember13, javaType14, keyDeserializer15, (JsonDeserializer<Object>) unsupportedTypeDeserializer18, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer26);
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer28 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (short) 1, objectIdReader3, settableAnyProperty27);
        String str29 = com.fasterxml.jackson.databind.util.ClassUtil.classNameOf((Object) jsonParser0);
        org.junit.Assert.assertNotNull(tokenBufferClass9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty27);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "[null]" + "'", str29, "[null]");
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        java.lang.annotation.Annotation annotation8 = null;
        com.fasterxml.jackson.databind.introspect.AnnotationMap annotationMap9 = com.fasterxml.jackson.databind.introspect.AnnotationMap.of(tokenBufferClass3, annotation8);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(annotationMap9);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        PropertyName propertyName0 = PropertyName.NO_NAME;
        PropertyName propertyName2 = propertyName0.withNamespace("[null]");
        com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer xMLGregorianCalendarSerializer3 = new com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer();
        JsonSerializer<?> wildcardJsonSerializer4 = xMLGregorianCalendarSerializer3.getDelegatee();
        boolean boolean5 = propertyName2.equals((Object) xMLGregorianCalendarSerializer3);
        org.junit.Assert.assertNotNull(propertyName0);
        org.junit.Assert.assertNotNull(propertyName2);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat0 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat2 = stdDateFormat0.withColonInTimeZone(false);
        java.text.NumberFormat numberFormat3 = null;
        stdDateFormat2.setNumberFormat(numberFormat3);
        java.util.Date date5 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str6 = stdDateFormat2.format(date5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stdDateFormat0);
        org.junit.Assert.assertNotNull(stdDateFormat2);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        String[] strArray3 = new String[] { "hi!", "", "hi!" };
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter simpleBeanPropertyFilter4 = com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept(strArray3);
        java.util.stream.Stream<Comparable<String>> strComparableStream5 = com.fasterxml.jackson.databind.util.ClassUtil.emptyStream();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        SerializerProvider serializerProvider7 = null;
        com.fasterxml.jackson.databind.ser.BeanPropertyWriter beanPropertyWriter8 = null;
        // The following exception was thrown during execution in test generation
        try {
            simpleBeanPropertyFilter4.serializeAsField((Object) strComparableStream5, jsonGenerator6, serializerProvider7, beanPropertyWriter8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new String[] { "hi!", "", "hi!" });
        org.junit.Assert.assertNotNull(simpleBeanPropertyFilter4);
        org.junit.Assert.assertNotNull(strComparableStream5);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer numberDeserializer0 = new com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer();
        com.fasterxml.jackson.databind.type.LogicalType logicalType1 = numberDeserializer0.logicalType();
        org.junit.Assert.assertTrue("'" + logicalType1 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Integer + "'", logicalType1.equals(com.fasterxml.jackson.databind.type.LogicalType.Integer));
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        com.fasterxml.jackson.databind.ser.BeanSerializerFactory beanSerializerFactory0 = com.fasterxml.jackson.databind.ser.BeanSerializerFactory.instance;
        com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig serializerFactoryConfig1 = null;
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory2 = beanSerializerFactory0.withConfig(serializerFactoryConfig1);
        org.junit.Assert.assertNotNull(beanSerializerFactory0);
        org.junit.Assert.assertNotNull(serializerFactory2);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        SerializationFeature serializationFeature0 = SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS;
        org.junit.Assert.assertTrue("'" + serializationFeature0 + "' != '" + SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS + "'", serializationFeature0.equals(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS));
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        ObjectMapper.DefaultTyping defaultTyping0 = ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT;
        org.junit.Assert.assertTrue("'" + defaultTyping0 + "' != '" + ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT + "'", defaultTyping0.equals(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT));
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        java.nio.ByteBuffer byteBuffer0 = null;
        com.fasterxml.jackson.databind.util.ByteBufferBackedOutputStream byteBufferBackedOutputStream1 = new com.fasterxml.jackson.databind.util.ByteBufferBackedOutputStream(byteBuffer0);
        byteBufferBackedOutputStream1.close();
        byte[] byteArray4 = new byte[] { (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            byteBufferBackedOutputStream1.write(byteArray4, (int) 'a', (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 1 });
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        java.util.Iterator<String> strItor3 = doubleNode1.fieldNames();
        // The following exception was thrown during execution in test generation
        try {
            JsonNode jsonNode5 = doubleNode1.required((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Node of type `DoubleNode` has no indexed values");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strItor3);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = new com.fasterxml.jackson.databind.node.ObjectNode(jsonNodeFactory1);
        com.fasterxml.jackson.databind.node.ValueNode valueNode4 = objectNode2.numberNode((Short) (short) 1);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode7 = objectNode2.put("52", false);
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode4);
        org.junit.Assert.assertNotNull(objectNode7);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder beanDeserializerBuilder0 = null;
        BeanDescription beanDescription1 = null;
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray3 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList4 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean5 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList4, settableBeanPropertyArray3);
        java.util.Map<String, java.util.List<PropertyName>> strMap6 = null;
        java.util.Locale locale7 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap8 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList4, strMap6, locale7);
        java.util.Map<String, java.util.List<PropertyName>> strMap10 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap11 = com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap.construct((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList4, false, strMap10);
        java.util.Map<String, com.fasterxml.jackson.databind.deser.SettableBeanProperty> strMap12 = null;
        String[] strArray17 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet18 = new java.util.LinkedHashSet<String>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<String>) strSet18, strArray17);
        String[] strArray21 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet22 = new java.util.LinkedHashSet<String>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<String>) strSet22, strArray21);
        JavaType javaType24 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer26 = null;
        JsonSerializer<Object> objJsonSerializer27 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer28 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer30 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet18, (java.util.Set<String>) strSet22, javaType24, false, typeSerializer26, objJsonSerializer27, objJsonSerializer28, (Object) 14);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer33 = new com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer(beanDeserializerBuilder0, beanDescription1, beanPropertyMap11, strMap12, (java.util.Set<String>) strSet18, true, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(settableBeanPropertyArray3);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray3, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(beanPropertyMap11);
        org.junit.Assert.assertNotNull(strArray17);
        org.junit.Assert.assertArrayEquals(strArray17, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(strArray21);
        org.junit.Assert.assertArrayEquals(strArray21, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer27);
        org.junit.Assert.assertNotNull(objJsonSerializer28);
        org.junit.Assert.assertNotNull(mapSerializer30);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        java.lang.reflect.Field[] fieldArray8 = com.fasterxml.jackson.databind.util.ClassUtil.getDeclaredFields(tokenBufferClass3);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(fieldArray8);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.text.DateFormat dateFormat2 = java.text.DateFormat.getDateInstance(52, locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal date style 52");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer doubleSerializer8 = new com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer(tokenBufferClass3);
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode9 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean10 = booleanNode9.isBinary();
        boolean boolean12 = booleanNode9.hasNonNull((int) (byte) 1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator13 = null;
        SerializerProvider serializerProvider14 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer15 = null;
        // The following exception was thrown during execution in test generation
        try {
            doubleSerializer8.serializeWithType((Object) booleanNode9, jsonGenerator13, serializerProvider14, typeSerializer15);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: com.fasterxml.jackson.databind.node.BooleanNode cannot be cast to java.lang.Double");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(booleanNode9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern1 = atomicBooleanDeserializer0.getNullAccessPattern();
        DeserializationContext deserializationContext2 = null;
        Object obj3 = atomicBooleanDeserializer0.getAbsentValue(deserializationContext2);
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern4 = atomicBooleanDeserializer0.getNullAccessPattern();
        org.junit.Assert.assertTrue("'" + accessPattern1 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern1.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
        org.junit.Assert.assertNull(obj3);
        org.junit.Assert.assertTrue("'" + accessPattern4 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern4.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        JavaType javaType3 = typeFactory0.moreSpecificType(javaType1, javaType2);
        com.fasterxml.jackson.databind.cfg.CoercionConfigs coercionConfigs4 = new com.fasterxml.jackson.databind.cfg.CoercionConfigs();
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty5 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference6 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer7 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass8 = tokenBufferSerializer7.handledType();
        boolean boolean9 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass8);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring11 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty5, unresolvedForwardReference6, tokenBufferClass8, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.cfg.MutableCoercionConfig mutableCoercionConfig12 = coercionConfigs4.findOrCreateCoercion(tokenBufferClass8);
        JavaType javaType13 = null;
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType14 = typeFactory0.constructReferenceType(tokenBufferClass8, javaType13);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot create TypeBindings for class com.fasterxml.jackson.databind.util.TokenBuffer with 1 type parameter: class expects 0");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNull(javaType3);
        org.junit.Assert.assertNotNull(tokenBufferClass8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(mutableCoercionConfig12);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        Class<Integer> intClass0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer integerDeserializer2 = new com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer(intClass0, (Integer) 4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        com.fasterxml.jackson.databind.introspect.AnnotatedConstructor annotatedConstructor0 = null;
        com.fasterxml.jackson.databind.introspect.AnnotatedConstructor[] annotatedConstructorArray1 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.introspect.AnnotatedConstructor> annotatedConstructorList2 = new java.util.ArrayList<com.fasterxml.jackson.databind.introspect.AnnotatedConstructor>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.introspect.AnnotatedConstructor>) annotatedConstructorList2, annotatedConstructorArray1);
        com.fasterxml.jackson.databind.introspect.AnnotatedMethod[] annotatedMethodArray4 = new com.fasterxml.jackson.databind.introspect.AnnotatedMethod[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> annotatedMethodList5 = new java.util.ArrayList<com.fasterxml.jackson.databind.introspect.AnnotatedMethod>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.introspect.AnnotatedMethod>) annotatedMethodList5, annotatedMethodArray4);
        com.fasterxml.jackson.databind.introspect.AnnotatedClass.Creators creators7 = new com.fasterxml.jackson.databind.introspect.AnnotatedClass.Creators(annotatedConstructor0, (java.util.List<com.fasterxml.jackson.databind.introspect.AnnotatedConstructor>) annotatedConstructorList2, (java.util.List<com.fasterxml.jackson.databind.introspect.AnnotatedMethod>) annotatedMethodList5);
        org.junit.Assert.assertNotNull(annotatedConstructorArray1);
        org.junit.Assert.assertArrayEquals(annotatedConstructorArray1, new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(annotatedMethodArray4);
        org.junit.Assert.assertArrayEquals(annotatedMethodArray4, new com.fasterxml.jackson.databind.introspect.AnnotatedMethod[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        DeserializationContext deserializationContext0 = null;
        BeanProperty beanProperty1 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty3 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory2);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass5);
        JavaType javaType8 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember9 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty3, tokenBufferClass5, "[null]", javaType8);
        JavaType javaType10 = null;
        KeyDeserializer keyDeserializer11 = null;
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer14 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType12, "hi!");
        boolean boolean15 = unsupportedTypeDeserializer14.isCachable();
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver17 = null;
        JavaType javaType20 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as21 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer22 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType16, typeIdResolver17, "`java.lang.Double`", true, javaType20, as21);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty23 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext0, beanProperty1, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember9, javaType10, keyDeserializer11, (JsonDeserializer<Object>) unsupportedTypeDeserializer14, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer22);
        java.lang.reflect.AnnotatedElement annotatedElement24 = virtualAnnotatedMember9.getAnnotated();
        java.lang.reflect.Member member25 = virtualAnnotatedMember9.getMember();
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty23);
        org.junit.Assert.assertNull(annotatedElement24);
        org.junit.Assert.assertNull(member25);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        java.lang.reflect.Member member0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.ClassUtil.checkAndFixAccess(member0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        com.fasterxml.jackson.databind.ser.std.StdKeySerializer stdKeySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdKeySerializer();
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty4 = null;
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer5 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (byte) 1, objectIdReader3, settableAnyProperty4);
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat7 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        propertyValueBuffer5.bufferMapProperty((Object) "hi!", (Object) stdDateFormat7);
        DeserializationContext deserializationContext9 = null;
        BeanProperty beanProperty10 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory11 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty12 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory11);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer13 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass14 = tokenBufferSerializer13.handledType();
        boolean boolean15 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass14);
        JavaType javaType17 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember18 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty12, tokenBufferClass14, "[null]", javaType17);
        JavaType javaType19 = null;
        KeyDeserializer keyDeserializer20 = null;
        JavaType javaType21 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer23 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType21, "hi!");
        boolean boolean24 = unsupportedTypeDeserializer23.isCachable();
        JavaType javaType25 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver26 = null;
        JavaType javaType29 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as30 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer31 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType25, typeIdResolver26, "`java.lang.Double`", true, javaType29, as30);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty32 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext9, beanProperty10, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember18, javaType19, keyDeserializer20, (JsonDeserializer<Object>) unsupportedTypeDeserializer23, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer31);
        propertyValueBuffer5.bufferAnyParameterProperty(settableAnyProperty32, "hi!", (Object) (short) 100);
        org.junit.Assert.assertNotNull(stdDateFormat7);
        org.junit.Assert.assertNotNull(tokenBufferClass14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty32);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat0 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat2 = stdDateFormat0.withColonInTimeZone(false);
        java.util.Date date3 = null;
        StringBuffer stringBuffer4 = null;
        java.text.FieldPosition fieldPosition5 = null;
        // The following exception was thrown during execution in test generation
        try {
            StringBuffer stringBuffer6 = stdDateFormat0.format(date3, stringBuffer4, fieldPosition5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stdDateFormat0);
        org.junit.Assert.assertNotNull(stdDateFormat2);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer documentDeserializer0 = new com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer();
        DeserializationContext deserializationContext1 = null;
        Object obj2 = documentDeserializer0.getAbsentValue(deserializationContext1);
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator3 = documentDeserializer0.getValueInstantiator();
        com.fasterxml.jackson.core.JsonParser jsonParser4 = null;
        DeserializationContext deserializationContext5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.w3c.dom.Document document6 = documentDeserializer0.deserialize(jsonParser4, deserializationContext5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(obj2);
        org.junit.Assert.assertNull(valueInstantiator3);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        com.fasterxml.jackson.databind.ext.Java7Handlers java7Handlers0 = com.fasterxml.jackson.databind.ext.Java7Handlers.instance();
        org.junit.Assert.assertNotNull(java7Handlers0);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        com.fasterxml.jackson.databind.ext.NioPathDeserializer nioPathDeserializer0 = new com.fasterxml.jackson.databind.ext.NioPathDeserializer();
        DeserializationContext deserializationContext1 = null;
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType2 = nioPathDeserializer0.getValueType(deserializationContext1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        ObjectReader objectReader0 = null;
        ObjectReader[] objectReaderArray1 = new ObjectReader[] { objectReader0 };
        com.fasterxml.jackson.databind.deser.DataFormatReaders dataFormatReaders2 = new com.fasterxml.jackson.databind.deser.DataFormatReaders(objectReaderArray1);
        ObjectReader objectReader3 = null;
        ObjectReader[] objectReaderArray4 = new ObjectReader[] { objectReader3 };
        com.fasterxml.jackson.databind.deser.DataFormatReaders dataFormatReaders5 = new com.fasterxml.jackson.databind.deser.DataFormatReaders(objectReaderArray4);
        com.fasterxml.jackson.databind.deser.DataFormatReaders dataFormatReaders6 = dataFormatReaders2.with(objectReaderArray4);
        // The following exception was thrown during execution in test generation
        try {
            String str7 = dataFormatReaders6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(objectReaderArray1);
        org.junit.Assert.assertArrayEquals(objectReaderArray1, new ObjectReader[] { null });
        org.junit.Assert.assertNotNull(objectReaderArray4);
        org.junit.Assert.assertArrayEquals(objectReaderArray4, new ObjectReader[] { null });
        org.junit.Assert.assertNotNull(dataFormatReaders6);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test289");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ValueNode valueNode3 = jsonNodeFactory1.numberNode((Short) (short) 0);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = jsonNodeFactory1.arrayNode();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode7 = arrayNode4.set(100, (Short) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Illegal index 100, array size 0");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test290");
        int int0 = java.text.DateFormat.WEEK_OF_MONTH_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 13 + "'", int0 == 13);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test291");
        com.fasterxml.jackson.databind.node.IntNode intNode1 = new com.fasterxml.jackson.databind.node.IntNode((int) '4');
        boolean boolean2 = intNode1.canConvertToInt();
        long long3 = intNode1.longValue();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 52L + "'", long3 == 52L);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test292");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ValueNode valueNode3 = jsonNodeFactory1.numberNode((Short) (short) 0);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = jsonNodeFactory1.arrayNode();
        com.fasterxml.jackson.databind.node.ValueNode valueNode6 = jsonNodeFactory1.numberNode((Short) (short) 10);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode7 = jsonNodeFactory1.objectNode();
        String str8 = objectNode7.asText();
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode10 = objectNode7.booleanNode(true);
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
        org.junit.Assert.assertNotNull(valueNode6);
        org.junit.Assert.assertNotNull(objectNode7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertNotNull(booleanNode10);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test293");
        int int0 = java.text.DateFormat.SHORT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test294");
        com.fasterxml.jackson.databind.node.IntNode intNode1 = new com.fasterxml.jackson.databind.node.IntNode((int) '4');
        boolean boolean2 = intNode1.isIntegralNumber();
        float float3 = intNode1.floatValue();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 52.0f + "'", float3 == 52.0f);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test295");
        JsonSerializer<Object> objJsonSerializer0 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        DeserializationContext deserializationContext3 = null;
        JsonMappingException jsonMappingException5 = JsonMappingException.from(deserializationContext3, "");
        JsonMappingException jsonMappingException6 = JsonMappingException.from(jsonGenerator1, "", (Throwable) jsonMappingException5);
        boolean boolean7 = objJsonSerializer0.isEmpty((Object) jsonMappingException6);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base9 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        JavaType javaType10 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor jsonIntegerFormatVisitor11 = base9.expectIntegerFormat(javaType10);
        JavaType javaType12 = null;
        tokenBufferSerializer8.acceptJsonFormatVisitor((com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper) base9, javaType12);
        JavaType javaType14 = null;
        objJsonSerializer0.acceptJsonFormatVisitor((com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper) base9, javaType14);
        org.junit.Assert.assertNotNull(objJsonSerializer0);
        org.junit.Assert.assertNotNull(jsonMappingException5);
        org.junit.Assert.assertNotNull(jsonMappingException6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(jsonIntegerFormatVisitor11);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test296");
        com.fasterxml.jackson.databind.ser.std.NumberSerializers.FloatSerializer floatSerializer0 = new com.fasterxml.jackson.databind.ser.std.NumberSerializers.FloatSerializer();
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test297");
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer0 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        String[] strArray5 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet6 = new java.util.LinkedHashSet<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strSet6, strArray5);
        String[] strArray9 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet10 = new java.util.LinkedHashSet<String>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<String>) strSet10, strArray9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer14 = null;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer16 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer18 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet6, (java.util.Set<String>) strSet10, javaType12, false, typeSerializer14, objJsonSerializer15, objJsonSerializer16, (Object) 14);
        JsonSerializer<?> wildcardJsonSerializer19 = tokenBufferSerializer0.withIgnoredProperties((java.util.Set<String>) strSet6);
        JavaType javaType20 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver22 = null;
        BeanProperty beanProperty23 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer24 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver22, beanProperty23);
        com.fasterxml.jackson.databind.ser.std.BooleanSerializer booleanSerializer26 = new com.fasterxml.jackson.databind.ser.std.BooleanSerializer(true);
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory28 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty29 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory28);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer30 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass31 = tokenBufferSerializer30.handledType();
        boolean boolean32 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass31);
        JavaType javaType34 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember35 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty29, tokenBufferClass31, "[null]", javaType34);
        com.fasterxml.jackson.databind.deser.std.FromStringDeserializer<?> wildcardFromStringDeserializer36 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.findDeserializer(tokenBufferClass31);
        com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default default37 = new com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default(0, tokenBufferClass31);
        com.fasterxml.jackson.databind.node.IntNode intNode39 = new com.fasterxml.jackson.databind.node.IntNode((int) '4');
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer40 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet6, javaType20, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer24, (JsonSerializer<Object>) booleanSerializer26, (JsonSerializer<Object>) default37, (Object) intNode39);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
        org.junit.Assert.assertNotNull(mapSerializer18);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer19);
        org.junit.Assert.assertNotNull(tokenBufferClass31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNull(wildcardFromStringDeserializer36);
        org.junit.Assert.assertNotNull(mapSerializer40);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test298");
        com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder doubleBuilder0 = new com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder();
        com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder doubleBuilder1 = new com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder();
        double[] doubleArray2 = doubleBuilder1.resetAndStart();
        int int3 = doubleBuilder1.bufferedSize();
        double[] doubleArray5 = doubleBuilder1._constructArray((int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            double[] doubleArray7 = doubleBuilder0.completeAndClearBuffer(doubleArray5, 11);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleArray2);
        org.junit.Assert.assertArrayEquals(doubleArray2, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertArrayEquals(doubleArray5, new double[] {}, 1.0E-15);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test299");
        com.fasterxml.jackson.databind.ser.std.ToStringSerializer toStringSerializer0 = com.fasterxml.jackson.databind.ser.std.ToStringSerializer.instance;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base1 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        JavaType javaType2 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor jsonIntegerFormatVisitor3 = base1.expectIntegerFormat(javaType2);
        JavaType javaType4 = null;
        toStringSerializer0.acceptJsonFormatVisitor((com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper) base1, javaType4);
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory6 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty7 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory6);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass9 = tokenBufferSerializer8.handledType();
        boolean boolean10 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember13 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty7, tokenBufferClass9, "[null]", javaType12);
        com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer doubleSerializer14 = new com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer(tokenBufferClass9);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator15 = null;
        SerializerProvider serializerProvider16 = null;
        // The following exception was thrown during execution in test generation
        try {
            toStringSerializer0.serialize((Object) tokenBufferClass9, jsonGenerator15, serializerProvider16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringSerializer0);
        org.junit.Assert.assertNull(jsonIntegerFormatVisitor3);
        org.junit.Assert.assertNotNull(tokenBufferClass9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test300");
        com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer calendarDeserializer0 = new com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer();
        JavaType javaType1 = calendarDeserializer0.getValueType();
        DeserializationConfig deserializationConfig2 = null;
        Boolean boolean3 = calendarDeserializer0.supportsUpdate(deserializationConfig2);
        org.junit.Assert.assertNull(javaType1);
        org.junit.Assert.assertEquals("'" + boolean3 + "' != '" + false + "'", boolean3, false);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test301");
        PropertyMetadata propertyMetadata4 = PropertyMetadata.construct(true, "`java.lang.Double`", (Integer) 0, "");
        PropertyMetadata propertyMetadata6 = propertyMetadata4.withIndex((Integer) 11);
        org.junit.Assert.assertNotNull(propertyMetadata4);
        org.junit.Assert.assertNotNull(propertyMetadata6);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test302");
        DeserializationContext deserializationContext0 = null;
        JsonMappingException jsonMappingException2 = JsonMappingException.from(deserializationContext0, "");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature3 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES;
        jsonMappingException2.prependPath((Object) jsonNodeFeature3, 0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        String[] strArray11 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet12 = new java.util.LinkedHashSet<String>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<String>) strSet12, strArray11);
        String[] strArray15 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet16 = new java.util.LinkedHashSet<String>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<String>) strSet16, strArray15);
        JavaType javaType18 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer20 = null;
        JsonSerializer<Object> objJsonSerializer21 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer22 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer24 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet12, (java.util.Set<String>) strSet16, javaType18, false, typeSerializer20, objJsonSerializer21, objJsonSerializer22, (Object) 14);
        JsonSerializer<?> wildcardJsonSerializer25 = tokenBufferSerializer6.withIgnoredProperties((java.util.Set<String>) strSet12);
        jsonMappingException2.prependPath((Object) tokenBufferSerializer6, 0);
        com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer28 = null;
        boolean boolean29 = tokenBufferSerializer6.isEmpty(tokenBuffer28);
        org.junit.Assert.assertNotNull(jsonMappingException2);
        org.junit.Assert.assertTrue("'" + jsonNodeFeature3 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES + "'", jsonNodeFeature3.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES));
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(strArray15);
        org.junit.Assert.assertArrayEquals(strArray15, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer21);
        org.junit.Assert.assertNotNull(objJsonSerializer22);
        org.junit.Assert.assertNotNull(mapSerializer24);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer25);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test303");
        MapperFeature mapperFeature0 = MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE;
        org.junit.Assert.assertTrue("'" + mapperFeature0 + "' != '" + MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE + "'", mapperFeature0.equals(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE));
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test304");
        com.fasterxml.jackson.databind.ser.std.DateSerializer dateSerializer0 = com.fasterxml.jackson.databind.ser.std.DateSerializer.instance;
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        // The following exception was thrown during execution in test generation
        try {
            JsonSerializer<?> wildcardJsonSerializer3 = dateSerializer0.createContextual(serializerProvider1, beanProperty2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateSerializer0);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test305");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "com.fasterxml.jackson.databind.JsonMappingException: ", javaType6);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test306");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = arrayNode1.removeAll();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode6 = arrayNode4.setNull((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test307");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        java.util.Iterator<String> strItor3 = doubleNode1.fieldNames();
        boolean boolean4 = doubleNode1.canConvertToInt();
        boolean boolean5 = doubleNode1.canConvertToInt();
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strItor3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test308");
        JsonNode jsonNode0 = com.fasterxml.jackson.databind.jsonschema.JsonSchema.getDefaultSchemaNode();
        org.junit.Assert.assertNotNull(jsonNode0);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test309");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        DeserializationContext deserializationContext4 = null;
        BeanProperty beanProperty5 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory6 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty7 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory6);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass9 = tokenBufferSerializer8.handledType();
        boolean boolean10 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember13 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty7, tokenBufferClass9, "[null]", javaType12);
        JavaType javaType14 = null;
        KeyDeserializer keyDeserializer15 = null;
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer18 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType16, "hi!");
        boolean boolean19 = unsupportedTypeDeserializer18.isCachable();
        JavaType javaType20 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver21 = null;
        JavaType javaType24 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as25 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer26 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType20, typeIdResolver21, "`java.lang.Double`", true, javaType24, as25);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty27 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext4, beanProperty5, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember13, javaType14, keyDeserializer15, (JsonDeserializer<Object>) unsupportedTypeDeserializer18, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer26);
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer28 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (short) 1, objectIdReader3, settableAnyProperty27);
        com.fasterxml.jackson.core.JsonParser jsonParser29 = null;
        DeserializationContext deserializationContext30 = null;
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode31 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        SerializerProvider serializerProvider32 = null;
        boolean boolean33 = booleanNode31.isEmpty(serializerProvider32);
        boolean boolean34 = booleanNode31.booleanValue();
        int int36 = booleanNode31.asInt((int) (byte) 100);
        long long38 = booleanNode31.asLong(0L);
        // The following exception was thrown during execution in test generation
        try {
            settableAnyProperty27.deserializeAndSet(jsonParser29, deserializationContext30, (Object) 0L, "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty27);
        org.junit.Assert.assertNotNull(booleanNode31);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int36 + "' != '" + 1 + "'", int36 == 1);
        org.junit.Assert.assertTrue("'" + long38 + "' != '" + 1L + "'", long38 == 1L);
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test310");
        String[] strArray7 = new String[] { "`java.lang.Double`", "1.0", "[null]", "`java.lang.Double`", "''", "`java.lang.Double`", "com.fasterxml.jackson.databind.JsonMappingException: " };
        java.util.LinkedHashSet<String> strSet8 = new java.util.LinkedHashSet<String>();
        boolean boolean9 = java.util.Collections.addAll((java.util.Collection<String>) strSet8, strArray7);
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter serializeExceptFilter10 = new com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter((java.util.Set<String>) strSet8);
        AnnotationIntrospector.ReferenceProperty referenceProperty12 = AnnotationIntrospector.ReferenceProperty.back("com.fasterxml.jackson.databind.JsonMappingException: ");
        AnnotationIntrospector.ReferenceProperty.Type type13 = referenceProperty12.getType();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator14 = null;
        SerializerProvider serializerProvider15 = null;
        com.fasterxml.jackson.databind.ser.PropertyWriter propertyWriter16 = null;
        // The following exception was thrown during execution in test generation
        try {
            serializeExceptFilter10.serializeAsElement((Object) referenceProperty12, jsonGenerator14, serializerProvider15, propertyWriter16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray7);
        org.junit.Assert.assertArrayEquals(strArray7, new String[] { "`java.lang.Double`", "1.0", "[null]", "`java.lang.Double`", "''", "`java.lang.Double`", "com.fasterxml.jackson.databind.JsonMappingException: " });
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(referenceProperty12);
        org.junit.Assert.assertTrue("'" + type13 + "' != '" + AnnotationIntrospector.ReferenceProperty.Type.BACK_REFERENCE + "'", type13.equals(AnnotationIntrospector.ReferenceProperty.Type.BACK_REFERENCE));
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test311");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer doubleSerializer8 = new com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer(tokenBufferClass3);
        SerializerProvider serializerProvider9 = null;
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer10 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer11 = stringArraySerializer10.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer12 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer13 = stringArraySerializer10.withValueTypeSerializer(typeSerializer12);
        BeanProperty beanProperty14 = null;
        JsonSerializer<?> wildcardJsonSerializer16 = stringArraySerializer10._withResolved(beanProperty14, (Boolean) false);
        Class<String[]> strArrayClass17 = stringArraySerializer10.handledType();
        JsonNode jsonNode18 = doubleSerializer8.getSchema(serializerProvider9, (java.lang.reflect.Type) strArrayClass17);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(stringArraySerializer10);
        org.junit.Assert.assertNull(wildcardJsonSerializer11);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer13);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer16);
        org.junit.Assert.assertNotNull(strArrayClass17);
        org.junit.Assert.assertNotNull(jsonNode18);
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test312");
        BeanProperty beanProperty0 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty1 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference2 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer3 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass4 = tokenBufferSerializer3.handledType();
        boolean boolean5 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass4);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring7 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty1, unresolvedForwardReference2, tokenBufferClass4, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType8 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass4);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.impl.NullsFailProvider nullsFailProvider9 = com.fasterxml.jackson.databind.deser.impl.NullsFailProvider.constructForProperty(beanProperty0, (JavaType) simpleType8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(simpleType8);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test313");
        com.fasterxml.jackson.databind.ser.std.SerializableSerializer serializableSerializer0 = com.fasterxml.jackson.databind.ser.std.SerializableSerializer.instance;
        org.junit.Assert.assertNotNull(serializableSerializer0);
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test314");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        String[] strArray5 = new String[] { "" };
        java.util.ArrayList<String> strList6 = new java.util.ArrayList<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strList6, strArray5);
        java.util.List<String> strList8 = booleanNode0.findValuesAsText("", (java.util.List<String>) strList6);
        String str9 = booleanNode0.textValue();
        com.fasterxml.jackson.core.JsonParser.NumberType numberType10 = booleanNode0.numberType();
        com.fasterxml.jackson.core.JsonToken jsonToken11 = booleanNode0.asToken();
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strList8);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(numberType10);
        org.junit.Assert.assertTrue("'" + jsonToken11 + "' != '" + com.fasterxml.jackson.core.JsonToken.VALUE_TRUE + "'", jsonToken11.equals(com.fasterxml.jackson.core.JsonToken.VALUE_TRUE));
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test315");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode5 = arrayNode1.findParent("hi!");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ObjectNode objectNode6 = arrayNode1.objectNode();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNull(objectNode5);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test316");
        com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer documentDeserializer0 = new com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer();
        DeserializationContext deserializationContext1 = null;
        Object obj2 = documentDeserializer0.getAbsentValue(deserializationContext1);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.SettableBeanProperty settableBeanProperty4 = documentDeserializer0.findBackReference("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot handle managed/back reference '': type: value deserializer of type com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer does not support them");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(obj2);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test317");
        com.fasterxml.jackson.databind.deser.std.UUIDDeserializer uUIDDeserializer0 = new com.fasterxml.jackson.databind.deser.std.UUIDDeserializer();
        DeserializationContext deserializationContext1 = null;
        java.util.UUID uUID2 = uUIDDeserializer0.getNullValue(deserializationContext1);
        java.util.UUID uUID3 = uUIDDeserializer0.getNullValue();
        org.junit.Assert.assertNull(uUID2);
        org.junit.Assert.assertNull(uUID3);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test318");
        Object obj0 = com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer.MARKER_FOR_EMPTY;
        org.junit.Assert.assertTrue("'" + obj0 + "' != '" + com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY + "'", obj0.equals(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY));
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test319");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        SerializerProvider serializerProvider1 = null;
        boolean boolean2 = booleanNode0.isEmpty(serializerProvider1);
        boolean boolean3 = booleanNode0.canConvertToExactIntegral();
        com.fasterxml.jackson.core.JsonParser.NumberType numberType4 = booleanNode0.numberType();
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(numberType4);
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test320");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer1 = stringArraySerializer0.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer3 = stringArraySerializer0.withValueTypeSerializer(typeSerializer2);
        BeanProperty beanProperty4 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = stringArraySerializer0._withResolved(beanProperty4, (Boolean) false);
        Class<String[]> strArrayClass7 = stringArraySerializer0.handledType();
        boolean boolean8 = stringArraySerializer0.isUnwrappingSerializer();
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNull(wildcardJsonSerializer1);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(strArrayClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test321");
        DeserializationContext deserializationContext0 = null;
        BeanProperty beanProperty1 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty3 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory2);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass5);
        JavaType javaType8 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember9 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty3, tokenBufferClass5, "[null]", javaType8);
        JavaType javaType10 = null;
        KeyDeserializer keyDeserializer11 = null;
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer14 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType12, "hi!");
        boolean boolean15 = unsupportedTypeDeserializer14.isCachable();
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver17 = null;
        JavaType javaType20 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as21 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer22 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType16, typeIdResolver17, "`java.lang.Double`", true, javaType20, as21);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty23 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext0, beanProperty1, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember9, javaType10, keyDeserializer11, (JsonDeserializer<Object>) unsupportedTypeDeserializer14, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer22);
        int int24 = settableAnyProperty23.getParameterIndex();
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty23);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test322");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        com.fasterxml.jackson.databind.deser.std.FromStringDeserializer<?> wildcardFromStringDeserializer8 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.findDeserializer(tokenBufferClass3);
        com.fasterxml.jackson.databind.ser.std.ToStringSerializer toStringSerializer9 = new com.fasterxml.jackson.databind.ser.std.ToStringSerializer(tokenBufferClass3);
        String str11 = com.fasterxml.jackson.databind.util.ClassUtil.isLocalType(tokenBufferClass3, true);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(wildcardFromStringDeserializer8);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test323");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.getTrue();
        org.junit.Assert.assertNotNull(booleanNode0);
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test324");
        com.fasterxml.jackson.databind.node.NullNode nullNode0 = com.fasterxml.jackson.databind.node.NullNode.instance;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        SerializerProvider serializerProvider2 = null;
        // The following exception was thrown during execution in test generation
        try {
            nullNode0.serialize(jsonGenerator1, serializerProvider2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(nullNode0);
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test325");
        com.fasterxml.jackson.databind.cfg.ConstructorDetector constructorDetector0 = com.fasterxml.jackson.databind.cfg.ConstructorDetector.EXPLICIT_ONLY;
        org.junit.Assert.assertNotNull(constructorDetector0);
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test326");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty2 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference3 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass5);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring8 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty2, unresolvedForwardReference3, tokenBufferClass5, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType9 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass5);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer11 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider12 = null;
        BeanProperty beanProperty13 = null;
        JsonSerializer<?> wildcardJsonSerializer14 = floatArraySerializer11.createContextual(serializerProvider12, beanProperty13);
        SerializerProvider serializerProvider15 = null;
        BeanProperty beanProperty16 = null;
        JsonSerializer<?> wildcardJsonSerializer17 = floatArraySerializer11.createContextual(serializerProvider15, beanProperty16);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver18 = null;
        BeanProperty beanProperty19 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer20 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver18, beanProperty19);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer21 = floatArraySerializer11._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer20);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer22 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType9, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer20);
        // The following exception was thrown during execution in test generation
        try {
            Object obj23 = com.fasterxml.jackson.databind.jsontype.TypeDeserializer.deserializeIfNatural(jsonParser0, deserializationContext1, (JavaType) simpleType9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonParser.currentToken()Lcom/fasterxml/jackson/core/JsonToken;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(simpleType9);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer14);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer17);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer21);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test327");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        BeanProperty beanProperty1 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0._withResolved(beanProperty1, (Boolean) true);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test328");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNull();
        com.fasterxml.jackson.core.JsonToken jsonToken3 = doubleNode1.asToken();
        double double5 = doubleNode1.asDouble((double) 100);
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + jsonToken3 + "' != '" + com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT + "'", jsonToken3.equals(com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT));
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 1.0d + "'", double5 == 1.0d);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test329");
        // The following exception was thrown during execution in test generation
        try {
            Object obj1 = com.fasterxml.jackson.databind.util.ArrayBuilders.getArrayComparator((Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Argument is not an array");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test330");
        com.fasterxml.jackson.databind.cfg.ContextAttributes contextAttributes0 = com.fasterxml.jackson.databind.cfg.ContextAttributes.Impl.getEmpty();
        JsonSerializer<Object> objJsonSerializer1 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        DeserializationContext deserializationContext4 = null;
        JsonMappingException jsonMappingException6 = JsonMappingException.from(deserializationContext4, "");
        JsonMappingException jsonMappingException7 = JsonMappingException.from(jsonGenerator2, "", (Throwable) jsonMappingException6);
        boolean boolean8 = objJsonSerializer1.isEmpty((Object) jsonMappingException7);
        com.fasterxml.jackson.databind.cfg.ContextAttributes contextAttributes10 = contextAttributes0.withPerCallAttribute((Object) jsonMappingException7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver11 = null;
        BeanProperty beanProperty12 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer13 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver11, beanProperty12);
        PropertyMetadata propertyMetadata18 = PropertyMetadata.construct(true, "`java.lang.Double`", (Integer) 0, "");
        PropertyMetadata propertyMetadata20 = propertyMetadata18.withRequired((Boolean) true);
        com.fasterxml.jackson.databind.cfg.ContextAttributes contextAttributes21 = contextAttributes10.withSharedAttribute((Object) asArrayTypeSerializer13, (Object) true);
        org.junit.Assert.assertNotNull(contextAttributes0);
        org.junit.Assert.assertNotNull(objJsonSerializer1);
        org.junit.Assert.assertNotNull(jsonMappingException6);
        org.junit.Assert.assertNotNull(jsonMappingException7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(contextAttributes10);
        org.junit.Assert.assertNotNull(propertyMetadata18);
        org.junit.Assert.assertNotNull(propertyMetadata20);
        org.junit.Assert.assertNotNull(contextAttributes21);
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test331");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        JsonDeserializer<?> wildcardJsonDeserializer9 = com.fasterxml.jackson.databind.deser.std.NumberDeserializers.find(tokenBufferClass3, "com.fasterxml.jackson.databind.JsonMappingException: ");
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(wildcardJsonDeserializer9);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test332");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern1 = atomicBooleanDeserializer0.getEmptyAccessPattern();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern2 = atomicBooleanDeserializer0.getNullAccessPattern();
        org.junit.Assert.assertTrue("'" + accessPattern1 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT + "'", accessPattern1.equals(com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT));
        org.junit.Assert.assertTrue("'" + accessPattern2 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern2.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test333");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer1 = stringArraySerializer0.getContentSerializer();
        String[] strArray6 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet7 = new java.util.LinkedHashSet<String>();
        boolean boolean8 = java.util.Collections.addAll((java.util.Collection<String>) strSet7, strArray6);
        String[] strArray10 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet11 = new java.util.LinkedHashSet<String>();
        boolean boolean12 = java.util.Collections.addAll((java.util.Collection<String>) strSet11, strArray10);
        JavaType javaType13 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer15 = null;
        JsonSerializer<Object> objJsonSerializer16 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer17 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer19 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet7, (java.util.Set<String>) strSet11, javaType13, false, typeSerializer15, objJsonSerializer16, objJsonSerializer17, (Object) 14);
        String[] strArray24 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet25 = new java.util.LinkedHashSet<String>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<String>) strSet25, strArray24);
        String[] strArray28 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet29 = new java.util.LinkedHashSet<String>();
        boolean boolean30 = java.util.Collections.addAll((java.util.Collection<String>) strSet29, strArray28);
        JavaType javaType31 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer33 = null;
        JsonSerializer<Object> objJsonSerializer34 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer35 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer37 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet25, (java.util.Set<String>) strSet29, javaType31, false, typeSerializer33, objJsonSerializer34, objJsonSerializer35, (Object) 14);
        com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker checker38 = com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.Checker.construct((java.util.Set<String>) strSet7, (java.util.Set<String>) strSet25);
        JsonSerializer<?> wildcardJsonSerializer39 = stringArraySerializer0.withIgnoredProperties((java.util.Set<String>) strSet7);
        SerializerProvider serializerProvider40 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory41 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty42 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory41);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer43 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass44 = tokenBufferSerializer43.handledType();
        boolean boolean45 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass44);
        JavaType javaType47 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember48 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty42, tokenBufferClass44, "[null]", javaType47);
        com.fasterxml.jackson.databind.deser.std.FromStringDeserializer<?> wildcardFromStringDeserializer49 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.findDeserializer(tokenBufferClass44);
        JsonNode jsonNode51 = stringArraySerializer0.getSchema(serializerProvider40, (java.lang.reflect.Type) tokenBufferClass44, false);
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNull(wildcardJsonSerializer1);
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
        org.junit.Assert.assertNotNull(objJsonSerializer17);
        org.junit.Assert.assertNotNull(mapSerializer19);
        org.junit.Assert.assertNotNull(strArray24);
        org.junit.Assert.assertArrayEquals(strArray24, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertNotNull(strArray28);
        org.junit.Assert.assertArrayEquals(strArray28, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer34);
        org.junit.Assert.assertNotNull(objJsonSerializer35);
        org.junit.Assert.assertNotNull(mapSerializer37);
        org.junit.Assert.assertNotNull(checker38);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer39);
        org.junit.Assert.assertNotNull(tokenBufferClass44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNull(wildcardFromStringDeserializer49);
        org.junit.Assert.assertNotNull(jsonNode51);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test334");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base1 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        JavaType javaType2 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor jsonIntegerFormatVisitor3 = base1.expectIntegerFormat(javaType2);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty4 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference5 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass7);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring10 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty4, unresolvedForwardReference5, tokenBufferClass7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType11 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass7);
        floatArraySerializer0.acceptJsonFormatVisitor((com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper) base1, (JavaType) simpleType11);
        Object obj13 = simpleType11.getContentValueHandler();
        org.junit.Assert.assertNull(jsonIntegerFormatVisitor3);
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(simpleType11);
        org.junit.Assert.assertNull(obj13);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test335");
        com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap annotatedMethodMap0 = new com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap();
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test336");
        com.fasterxml.jackson.databind.ser.BeanSerializerFactory beanSerializerFactory0 = com.fasterxml.jackson.databind.ser.BeanSerializerFactory.instance;
        com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig serializerFactoryConfig1 = new com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig();
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory2 = beanSerializerFactory0.withConfig(serializerFactoryConfig1);
        com.fasterxml.jackson.databind.ser.Serializers serializers3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory4 = serializerFactory2.withAdditionalSerializers(serializers3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot pass null Serializers");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(beanSerializerFactory0);
        org.junit.Assert.assertNotNull(serializerFactory2);
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test337");
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat jsonValueFormat0 = com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.PHONE;
        org.junit.Assert.assertTrue("'" + jsonValueFormat0 + "' != '" + com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.PHONE + "'", jsonValueFormat0.equals(com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.PHONE));
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test338");
        DeserializationContext deserializationContext0 = null;
        PropertyName propertyName1 = PropertyName.NO_NAME;
        PropertyName propertyName3 = propertyName1.withNamespace("[null]");
        JavaType javaType4 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException5 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext0, propertyName1, javaType4);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty6 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference7 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass9 = tokenBufferSerializer8.handledType();
        boolean boolean10 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass9);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring12 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty6, unresolvedForwardReference7, tokenBufferClass9, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType13 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass9);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer15 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider16 = null;
        BeanProperty beanProperty17 = null;
        JsonSerializer<?> wildcardJsonSerializer18 = floatArraySerializer15.createContextual(serializerProvider16, beanProperty17);
        SerializerProvider serializerProvider19 = null;
        BeanProperty beanProperty20 = null;
        JsonSerializer<?> wildcardJsonSerializer21 = floatArraySerializer15.createContextual(serializerProvider19, beanProperty20);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver22 = null;
        BeanProperty beanProperty23 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer24 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver22, beanProperty23);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer25 = floatArraySerializer15._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer24);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer26 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType13, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer24);
        DeserializationContext deserializationContext27 = null;
        BeanProperty beanProperty28 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory29 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty30 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory29);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer31 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass32 = tokenBufferSerializer31.handledType();
        boolean boolean33 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass32);
        JavaType javaType35 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember36 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty30, tokenBufferClass32, "[null]", javaType35);
        JavaType javaType37 = null;
        KeyDeserializer keyDeserializer38 = null;
        JavaType javaType39 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer41 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType39, "hi!");
        boolean boolean42 = unsupportedTypeDeserializer41.isCachable();
        JavaType javaType43 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver44 = null;
        JavaType javaType47 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as48 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer49 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType43, typeIdResolver44, "`java.lang.Double`", true, javaType47, as48);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty50 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext27, beanProperty28, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember36, javaType37, keyDeserializer38, (JsonDeserializer<Object>) unsupportedTypeDeserializer41, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer49);
        java.lang.reflect.AnnotatedElement annotatedElement51 = virtualAnnotatedMember36.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams52 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode53 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator54 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams52, mode53);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector55 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName1, (JavaType) simpleType13, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember36, (Object) annotatedWithParams52);
        int int56 = simpleType13.containedTypeCount();
        org.junit.Assert.assertNotNull(propertyName1);
        org.junit.Assert.assertNotNull(propertyName3);
        org.junit.Assert.assertNotNull(invalidNullException5);
        org.junit.Assert.assertNotNull(tokenBufferClass9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(simpleType13);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer18);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer21);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer25);
        org.junit.Assert.assertNotNull(tokenBufferClass32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty50);
        org.junit.Assert.assertNull(annotatedElement51);
        org.junit.Assert.assertTrue("'" + int56 + "' != '" + 0 + "'", int56 == 0);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test339");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode5 = arrayNode1.findParent("hi!");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ValueNode valueNode7 = arrayNode1.textNode("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNull(objectNode5);
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test340");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode5 = arrayNode1.findParent("hi!");
        java.math.BigDecimal bigDecimal6 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ArrayNode arrayNode7 = arrayNode1.add(bigDecimal6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNull(objectNode5);
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test341");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator0 = null;
        DeserializationContext deserializationContext2 = null;
        JsonMappingException jsonMappingException4 = JsonMappingException.from(deserializationContext2, "");
        JsonMappingException jsonMappingException5 = JsonMappingException.from(jsonGenerator0, "", (Throwable) jsonMappingException4);
        java.util.List<JsonMappingException.Reference> referenceList6 = jsonMappingException4.getPath();
        org.junit.Assert.assertNotNull(jsonMappingException4);
        org.junit.Assert.assertNotNull(jsonMappingException5);
        org.junit.Assert.assertNotNull(referenceList6);
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test342");
        com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer bigDecimalDeserializer0 = com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer.instance;
        com.fasterxml.jackson.core.JsonParser jsonParser1 = null;
        DeserializationContext deserializationContext2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigDecimal bigDecimal3 = bigDecimalDeserializer0.deserialize(jsonParser1, deserializationContext2);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonParser.currentTokenId()I");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bigDecimalDeserializer0);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test343");
        DeserializationConfig deserializationConfig0 = null;
        com.fasterxml.jackson.databind.introspect.AnnotatedClass annotatedClass1 = null;
        DeserializationContext deserializationContext2 = null;
        BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory4 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty5 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory4);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass7);
        JavaType javaType10 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember11 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty5, tokenBufferClass7, "[null]", javaType10);
        JavaType javaType12 = null;
        KeyDeserializer keyDeserializer13 = null;
        JavaType javaType14 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer16 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType14, "hi!");
        boolean boolean17 = unsupportedTypeDeserializer16.isCachable();
        JavaType javaType18 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver19 = null;
        JavaType javaType22 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as23 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer24 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType18, typeIdResolver19, "`java.lang.Double`", true, javaType22, as23);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty25 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext2, beanProperty3, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember11, javaType12, keyDeserializer13, (JsonDeserializer<Object>) unsupportedTypeDeserializer16, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer24);
        java.lang.reflect.AnnotatedElement annotatedElement26 = virtualAnnotatedMember11.getAnnotated();
        String str27 = virtualAnnotatedMember11.getFullName();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.EnumResolver enumResolver28 = com.fasterxml.jackson.databind.util.EnumResolver.constructUsingMethod(deserializationConfig0, annotatedClass1, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty25);
        org.junit.Assert.assertNull(annotatedElement26);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "com.fasterxml.jackson.databind.util.TokenBuffer#[null]" + "'", str27, "com.fasterxml.jackson.databind.util.TokenBuffer#[null]");
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test344");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        DeserializationContext deserializationContext8 = null;
        PropertyName propertyName9 = PropertyName.NO_NAME;
        PropertyName propertyName11 = propertyName9.withNamespace("[null]");
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException13 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext8, propertyName9, javaType12);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty14 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference15 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer16 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass17 = tokenBufferSerializer16.handledType();
        boolean boolean18 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass17);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring20 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty14, unresolvedForwardReference15, tokenBufferClass17, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType21 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass17);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer23 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider24 = null;
        BeanProperty beanProperty25 = null;
        JsonSerializer<?> wildcardJsonSerializer26 = floatArraySerializer23.createContextual(serializerProvider24, beanProperty25);
        SerializerProvider serializerProvider27 = null;
        BeanProperty beanProperty28 = null;
        JsonSerializer<?> wildcardJsonSerializer29 = floatArraySerializer23.createContextual(serializerProvider27, beanProperty28);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver30 = null;
        BeanProperty beanProperty31 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer32 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver30, beanProperty31);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer33 = floatArraySerializer23._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer32);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer34 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType21, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer32);
        DeserializationContext deserializationContext35 = null;
        BeanProperty beanProperty36 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory37 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty38 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory37);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer39 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass40 = tokenBufferSerializer39.handledType();
        boolean boolean41 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass40);
        JavaType javaType43 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember44 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty38, tokenBufferClass40, "[null]", javaType43);
        JavaType javaType45 = null;
        KeyDeserializer keyDeserializer46 = null;
        JavaType javaType47 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer49 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType47, "hi!");
        boolean boolean50 = unsupportedTypeDeserializer49.isCachable();
        JavaType javaType51 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver52 = null;
        JavaType javaType55 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as56 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer57 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType51, typeIdResolver52, "`java.lang.Double`", true, javaType55, as56);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty58 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext35, beanProperty36, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember44, javaType45, keyDeserializer46, (JsonDeserializer<Object>) unsupportedTypeDeserializer49, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer57);
        java.lang.reflect.AnnotatedElement annotatedElement59 = virtualAnnotatedMember44.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams60 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode61 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator62 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams60, mode61);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector63 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName9, (JavaType) simpleType21, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember44, (Object) annotatedWithParams60);
        JavaType javaType65 = simpleType21.containedTypeOrUnknown(9);
        // The following exception was thrown during execution in test generation
        try {
            JavaType javaType66 = empty1.resolveType((java.lang.reflect.Type) simpleType21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(propertyName9);
        org.junit.Assert.assertNotNull(propertyName11);
        org.junit.Assert.assertNotNull(invalidNullException13);
        org.junit.Assert.assertNotNull(tokenBufferClass17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(simpleType21);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer26);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer29);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer33);
        org.junit.Assert.assertNotNull(tokenBufferClass40);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty58);
        org.junit.Assert.assertNull(annotatedElement59);
        org.junit.Assert.assertNotNull(javaType65);
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test345");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        java.math.BigInteger bigInteger2 = longNode1.bigIntegerValue();
        com.fasterxml.jackson.databind.node.BigIntegerNode bigIntegerNode3 = new com.fasterxml.jackson.databind.node.BigIntegerNode(bigInteger2);
        org.junit.Assert.assertNotNull(longNode1);
        org.junit.Assert.assertNotNull(bigInteger2);
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test346");
        DeserializationContext deserializationContext0 = null;
        BeanProperty beanProperty1 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty3 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory2);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass5);
        JavaType javaType8 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember9 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty3, tokenBufferClass5, "[null]", javaType8);
        JavaType javaType10 = null;
        KeyDeserializer keyDeserializer11 = null;
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer14 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType12, "hi!");
        boolean boolean15 = unsupportedTypeDeserializer14.isCachable();
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver17 = null;
        JavaType javaType20 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as21 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer22 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType16, typeIdResolver17, "`java.lang.Double`", true, javaType20, as21);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty23 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext0, beanProperty1, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember9, javaType10, keyDeserializer11, (JsonDeserializer<Object>) unsupportedTypeDeserializer14, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer22);
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer24 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer25 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer26 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer24, nameTransformer25);
        JsonDeserializer<Object> objJsonDeserializer27 = unsupportedTypeDeserializer14.unwrappingDeserializer(nameTransformer25);
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty23);
        org.junit.Assert.assertNotNull(nameTransformer26);
        org.junit.Assert.assertNotNull(objJsonDeserializer27);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test347");
        com.fasterxml.jackson.databind.deser.std.UUIDDeserializer uUIDDeserializer0 = new com.fasterxml.jackson.databind.deser.std.UUIDDeserializer();
        Object obj1 = uUIDDeserializer0.getEmptyValue();
        org.junit.Assert.assertNull(obj1);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test348");
        com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer tokenBufferDeserializer0 = new com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer();
        com.fasterxml.jackson.databind.util.TokenBuffer tokenBuffer1 = tokenBufferDeserializer0.getNullValue();
        Class<?> wildcardClass2 = tokenBufferDeserializer0.handledType();
        org.junit.Assert.assertNull(tokenBuffer1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test349");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = new com.fasterxml.jackson.databind.node.ObjectNode(jsonNodeFactory1);
        com.fasterxml.jackson.databind.node.NumericNode numericNode4 = objectNode2.numberNode((double) 9);
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(numericNode4);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test350");
        com.fasterxml.jackson.databind.util.LRUMap<com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer<java.util.concurrent.atomic.AtomicBoolean>, com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter> atomicBooleanStdScalarDeserializerLRUMap2 = new com.fasterxml.jackson.databind.util.LRUMap<com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer<java.util.concurrent.atomic.AtomicBoolean>, com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter>((int) (byte) 10, (int) (byte) 100);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test351");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0.createContextual(serializerProvider1, beanProperty2);
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer0.createContextual(serializerProvider4, beanProperty5);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver7 = null;
        BeanProperty beanProperty8 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer9 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver7, beanProperty8);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer10 = floatArraySerializer0._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer9);
        SerializerProvider serializerProvider11 = null;
        DeserializationContext deserializationContext12 = null;
        PropertyName propertyName13 = PropertyName.NO_NAME;
        PropertyName propertyName15 = propertyName13.withNamespace("[null]");
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException17 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext12, propertyName13, javaType16);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty18 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference19 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer20 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass21 = tokenBufferSerializer20.handledType();
        boolean boolean22 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass21);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring24 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty18, unresolvedForwardReference19, tokenBufferClass21, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType25 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass21);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer27 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider28 = null;
        BeanProperty beanProperty29 = null;
        JsonSerializer<?> wildcardJsonSerializer30 = floatArraySerializer27.createContextual(serializerProvider28, beanProperty29);
        SerializerProvider serializerProvider31 = null;
        BeanProperty beanProperty32 = null;
        JsonSerializer<?> wildcardJsonSerializer33 = floatArraySerializer27.createContextual(serializerProvider31, beanProperty32);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver34 = null;
        BeanProperty beanProperty35 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer36 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver34, beanProperty35);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer37 = floatArraySerializer27._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer36);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer38 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType25, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer36);
        DeserializationContext deserializationContext39 = null;
        BeanProperty beanProperty40 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory41 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty42 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory41);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer43 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass44 = tokenBufferSerializer43.handledType();
        boolean boolean45 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass44);
        JavaType javaType47 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember48 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty42, tokenBufferClass44, "[null]", javaType47);
        JavaType javaType49 = null;
        KeyDeserializer keyDeserializer50 = null;
        JavaType javaType51 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer53 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType51, "hi!");
        boolean boolean54 = unsupportedTypeDeserializer53.isCachable();
        JavaType javaType55 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver56 = null;
        JavaType javaType59 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as60 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer61 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType55, typeIdResolver56, "`java.lang.Double`", true, javaType59, as60);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty62 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext39, beanProperty40, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember48, javaType49, keyDeserializer50, (JsonDeserializer<Object>) unsupportedTypeDeserializer53, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer61);
        java.lang.reflect.AnnotatedElement annotatedElement63 = virtualAnnotatedMember48.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams64 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode65 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator66 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams64, mode65);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector67 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName13, (JavaType) simpleType25, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember48, (Object) annotatedWithParams64);
        // The following exception was thrown during execution in test generation
        try {
            JsonSerializer<?> wildcardJsonSerializer68 = floatArraySerializer0.createContextual(serializerProvider11, (BeanProperty) valueInjector67);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer10);
        org.junit.Assert.assertNotNull(propertyName13);
        org.junit.Assert.assertNotNull(propertyName15);
        org.junit.Assert.assertNotNull(invalidNullException17);
        org.junit.Assert.assertNotNull(tokenBufferClass21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(simpleType25);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer30);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer33);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer37);
        org.junit.Assert.assertNotNull(tokenBufferClass44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty62);
        org.junit.Assert.assertNull(annotatedElement63);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test352");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ValueNode valueNode3 = arrayNode1.numberNode((Integer) 4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test353");
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray1 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList2 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, settableBeanPropertyArray1);
        java.util.Map<String, java.util.List<PropertyName>> strMap4 = null;
        java.util.Locale locale5 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap6 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, strMap4, locale5);
        JavaType javaType7 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer9 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer10 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider11 = null;
        BeanProperty beanProperty12 = null;
        JsonSerializer<?> wildcardJsonSerializer13 = floatArraySerializer10.createContextual(serializerProvider11, beanProperty12);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer14 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer(javaType7, false, typeSerializer9, (JsonSerializer<Object>) wildcardJsonSerializer13);
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer15 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer16 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer17 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer15, nameTransformer16);
        JsonSerializer<Object[]> objArrayJsonSerializer18 = objectArraySerializer14.unwrappingSerializer(nameTransformer17);
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap19 = beanPropertyMap6.renameAll(nameTransformer17);
        org.junit.Assert.assertNotNull(settableBeanPropertyArray1);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray1, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer13);
        org.junit.Assert.assertNotNull(nameTransformer17);
        org.junit.Assert.assertNotNull(objArrayJsonSerializer18);
        org.junit.Assert.assertNotNull(beanPropertyMap19);
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test354");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = new com.fasterxml.jackson.databind.node.ObjectNode(jsonNodeFactory1);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode5 = objectNode2.put("", (short) (byte) 10);
        JsonNode jsonNode7 = objectNode5.get("''");
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(objectNode5);
        org.junit.Assert.assertNull(jsonNode7);
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test355");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base1 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        JavaType javaType2 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor jsonIntegerFormatVisitor3 = base1.expectIntegerFormat(javaType2);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty4 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference5 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass7);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring10 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty4, unresolvedForwardReference5, tokenBufferClass7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType11 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass7);
        floatArraySerializer0.acceptJsonFormatVisitor((com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper) base1, (JavaType) simpleType11);
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator13 = null;
        KeyDeserializer keyDeserializer14 = null;
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer15 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.type.LogicalType logicalType16 = atomicBooleanDeserializer15.logicalType();
        java.util.Collection<Object> objCollection17 = atomicBooleanDeserializer15.getKnownPropertyNames();
        Object obj18 = atomicBooleanDeserializer15.getEmptyValue();
        com.fasterxml.jackson.databind.module.SimpleDeserializers simpleDeserializers19 = new com.fasterxml.jackson.databind.module.SimpleDeserializers();
        com.fasterxml.jackson.databind.type.ReferenceType referenceType20 = null;
        DeserializationConfig deserializationConfig21 = null;
        BeanDescription beanDescription22 = null;
        DeserializationContext deserializationContext23 = null;
        BeanProperty beanProperty24 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory25 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty26 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory25);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer27 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass28 = tokenBufferSerializer27.handledType();
        boolean boolean29 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass28);
        JavaType javaType31 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember32 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty26, tokenBufferClass28, "[null]", javaType31);
        JavaType javaType33 = null;
        KeyDeserializer keyDeserializer34 = null;
        JavaType javaType35 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer37 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType35, "hi!");
        boolean boolean38 = unsupportedTypeDeserializer37.isCachable();
        JavaType javaType39 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver40 = null;
        JavaType javaType43 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as44 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer45 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType39, typeIdResolver40, "`java.lang.Double`", true, javaType43, as44);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty46 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext23, beanProperty24, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember32, javaType33, keyDeserializer34, (JsonDeserializer<Object>) unsupportedTypeDeserializer37, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer45);
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer47 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        JsonDeserializer<?> wildcardJsonDeserializer48 = simpleDeserializers19.findReferenceDeserializer(referenceType20, deserializationConfig21, beanDescription22, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer45, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer47);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver49 = asPropertyTypeDeserializer45.getTypeIdResolver();
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer50 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern51 = atomicBooleanDeserializer50.getNullAccessPattern();
        DeserializationContext deserializationContext52 = null;
        Object obj53 = atomicBooleanDeserializer50.getAbsentValue(deserializationContext52);
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern54 = atomicBooleanDeserializer50.getEmptyAccessPattern();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer enumMapDeserializer55 = new com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer((JavaType) simpleType11, valueInstantiator13, keyDeserializer14, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer15, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer45, (com.fasterxml.jackson.databind.deser.NullValueProvider) atomicBooleanDeserializer50);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(jsonIntegerFormatVisitor3);
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(simpleType11);
        org.junit.Assert.assertTrue("'" + logicalType16 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Boolean + "'", logicalType16.equals(com.fasterxml.jackson.databind.type.LogicalType.Boolean));
        org.junit.Assert.assertNull(objCollection17);
        org.junit.Assert.assertNull(obj18);
        org.junit.Assert.assertNotNull(tokenBufferClass28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty46);
        org.junit.Assert.assertNull(wildcardJsonDeserializer48);
        org.junit.Assert.assertNull(typeIdResolver49);
        org.junit.Assert.assertTrue("'" + accessPattern51 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern51.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
        org.junit.Assert.assertNull(obj53);
        org.junit.Assert.assertTrue("'" + accessPattern54 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT + "'", accessPattern54.equals(com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT));
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test356");
        int int0 = java.text.DateFormat.DAY_OF_YEAR_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 10 + "'", int0 == 10);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test357");
        com.fasterxml.jackson.databind.ser.std.DateSerializer dateSerializer0 = com.fasterxml.jackson.databind.ser.std.DateSerializer.instance;
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer3 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer4 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider5 = null;
        BeanProperty beanProperty6 = null;
        JsonSerializer<?> wildcardJsonSerializer7 = floatArraySerializer4.createContextual(serializerProvider5, beanProperty6);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer8 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer(javaType1, false, typeSerializer3, (JsonSerializer<Object>) wildcardJsonSerializer7);
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer9 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer10 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer11 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer9, nameTransformer10);
        JsonSerializer<Object[]> objArrayJsonSerializer12 = objectArraySerializer8.unwrappingSerializer(nameTransformer11);
        JsonSerializer<java.util.Date> dateJsonSerializer13 = dateSerializer0.unwrappingSerializer(nameTransformer11);
        org.junit.Assert.assertNotNull(dateSerializer0);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
        org.junit.Assert.assertNotNull(nameTransformer11);
        org.junit.Assert.assertNotNull(objArrayJsonSerializer12);
        org.junit.Assert.assertNotNull(dateJsonSerializer13);
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test358");
        com.fasterxml.jackson.databind.ser.std.InetAddressSerializer inetAddressSerializer0 = new com.fasterxml.jackson.databind.ser.std.InetAddressSerializer();
        boolean boolean1 = inetAddressSerializer0.usesObjectId();
        JsonSerializer<?> wildcardJsonSerializer2 = com.fasterxml.jackson.databind.ext.CoreXMLSerializers.QNameSerializer.instance;
        // The following exception was thrown during execution in test generation
        try {
            JsonSerializer<java.net.InetAddress> inetAddressJsonSerializer3 = inetAddressSerializer0.replaceDelegatee((JsonSerializer<Object>) wildcardJsonSerializer2);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: null");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer2);
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test359");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode1 = com.fasterxml.jackson.databind.node.BooleanNode.valueOf(false);
        org.junit.Assert.assertNotNull(booleanNode1);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test360");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        boolean boolean2 = longNode1.isNaN();
        boolean boolean3 = longNode1.isLong();
        org.junit.Assert.assertNotNull(longNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test361");
        com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer documentDeserializer0 = new com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer();
        DeserializationContext deserializationContext1 = null;
        Object obj2 = documentDeserializer0.getAbsentValue(deserializationContext1);
        DeserializationContext deserializationContext3 = null;
        Object obj4 = documentDeserializer0.getAbsentValue(deserializationContext3);
        org.junit.Assert.assertNull(obj2);
        org.junit.Assert.assertNull(obj4);
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test362");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer1 = stringArraySerializer0.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer3 = stringArraySerializer0.withValueTypeSerializer(typeSerializer2);
        BeanProperty beanProperty4 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = stringArraySerializer0._withResolved(beanProperty4, (Boolean) false);
        String[] strArray10 = new String[] { "hi!", "", "hi!" };
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter simpleBeanPropertyFilter11 = com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept(strArray10);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator12 = null;
        SerializerProvider serializerProvider13 = null;
        // The following exception was thrown during execution in test generation
        try {
            stringArraySerializer0.serialize(strArray10, jsonGenerator12, serializerProvider13);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonGenerator.writeStartArray(Ljava/lang/Object;I)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNull(wildcardJsonSerializer1);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "hi!", "", "hi!" });
        org.junit.Assert.assertNotNull(simpleBeanPropertyFilter11);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test363");
        com.fasterxml.jackson.databind.ext.NioPathDeserializer nioPathDeserializer0 = new com.fasterxml.jackson.databind.ext.NioPathDeserializer();
        java.util.Collection<Object> objCollection1 = nioPathDeserializer0.getKnownPropertyNames();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern2 = nioPathDeserializer0.getNullAccessPattern();
        DeserializationContext deserializationContext3 = null;
        Object obj4 = nioPathDeserializer0.getEmptyValue(deserializationContext3);
        org.junit.Assert.assertNull(objCollection1);
        org.junit.Assert.assertTrue("'" + accessPattern2 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern2.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
        org.junit.Assert.assertNull(obj4);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test364");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        String[] strArray5 = new String[] { "" };
        java.util.ArrayList<String> strList6 = new java.util.ArrayList<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strList6, strArray5);
        java.util.List<String> strList8 = booleanNode0.findValuesAsText("", (java.util.List<String>) strList6);
        int int10 = booleanNode0.asInt((int) (byte) -1);
        java.util.Iterator<JsonNode> jsonNodeItor11 = booleanNode0.elements();
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strList8);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
        org.junit.Assert.assertNotNull(jsonNodeItor11);
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test365");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        // The following exception was thrown during execution in test generation
        try {
            Class<?> wildcardClass8 = com.fasterxml.jackson.databind.util.ClassUtil.wrapperType(tokenBufferClass3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Class com.fasterxml.jackson.databind.util.TokenBuffer is not a primitive type");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test366");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray2 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList3 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList3, settableBeanPropertyArray2);
        java.util.Map<String, java.util.List<PropertyName>> strMap5 = null;
        java.util.Locale locale6 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap7 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList3, strMap5, locale6);
        java.util.Map<String, java.util.List<PropertyName>> strMap9 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap10 = com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap.construct((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList3, false, strMap9);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BeanDeserializer beanDeserializer11 = new com.fasterxml.jackson.databind.deser.BeanDeserializer(beanDeserializerBase0, beanPropertyMap10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(settableBeanPropertyArray2);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray2, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(beanPropertyMap10);
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test367");
        com.fasterxml.jackson.databind.module.SimpleDeserializers simpleDeserializers0 = new com.fasterxml.jackson.databind.module.SimpleDeserializers();
        com.fasterxml.jackson.databind.type.CollectionLikeType collectionLikeType1 = null;
        DeserializationConfig deserializationConfig2 = null;
        BeanDescription beanDescription3 = null;
        com.fasterxml.jackson.databind.module.SimpleDeserializers simpleDeserializers4 = new com.fasterxml.jackson.databind.module.SimpleDeserializers();
        com.fasterxml.jackson.databind.type.ReferenceType referenceType5 = null;
        DeserializationConfig deserializationConfig6 = null;
        BeanDescription beanDescription7 = null;
        DeserializationContext deserializationContext8 = null;
        BeanProperty beanProperty9 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory10 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty11 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory10);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer12 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass13 = tokenBufferSerializer12.handledType();
        boolean boolean14 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass13);
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember17 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty11, tokenBufferClass13, "[null]", javaType16);
        JavaType javaType18 = null;
        KeyDeserializer keyDeserializer19 = null;
        JavaType javaType20 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer22 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType20, "hi!");
        boolean boolean23 = unsupportedTypeDeserializer22.isCachable();
        JavaType javaType24 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver25 = null;
        JavaType javaType28 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as29 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer30 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType24, typeIdResolver25, "`java.lang.Double`", true, javaType28, as29);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty31 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext8, beanProperty9, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember17, javaType18, keyDeserializer19, (JsonDeserializer<Object>) unsupportedTypeDeserializer22, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer30);
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer32 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        JsonDeserializer<?> wildcardJsonDeserializer33 = simpleDeserializers4.findReferenceDeserializer(referenceType5, deserializationConfig6, beanDescription7, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer30, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer32);
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer34 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern35 = atomicBooleanDeserializer34.getNullAccessPattern();
        DeserializationContext deserializationContext36 = null;
        Object obj37 = atomicBooleanDeserializer34.getAbsentValue(deserializationContext36);
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern38 = atomicBooleanDeserializer34.getEmptyAccessPattern();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer39 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer40 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer41 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer39, nameTransformer40);
        JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean> atomicBooleanJsonDeserializer42 = atomicBooleanDeserializer34.unwrappingDeserializer(nameTransformer39);
        JsonDeserializer<?> wildcardJsonDeserializer43 = simpleDeserializers0.findCollectionLikeDeserializer(collectionLikeType1, deserializationConfig2, beanDescription3, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer30, (JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer34);
        DeserializationConfig deserializationConfig44 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory45 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty46 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory45);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer47 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass48 = tokenBufferSerializer47.handledType();
        boolean boolean49 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass48);
        JavaType javaType51 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember52 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty46, tokenBufferClass48, "[null]", javaType51);
        boolean boolean53 = simpleDeserializers0.hasDeserializerFor(deserializationConfig44, tokenBufferClass48);
        com.fasterxml.jackson.databind.deser.std.FromStringDeserializer<?> wildcardFromStringDeserializer54 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.findDeserializer(tokenBufferClass48);
        org.junit.Assert.assertNotNull(tokenBufferClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty31);
        org.junit.Assert.assertNull(wildcardJsonDeserializer33);
        org.junit.Assert.assertTrue("'" + accessPattern35 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL + "'", accessPattern35.equals(com.fasterxml.jackson.databind.util.AccessPattern.ALWAYS_NULL));
        org.junit.Assert.assertNull(obj37);
        org.junit.Assert.assertTrue("'" + accessPattern38 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT + "'", accessPattern38.equals(com.fasterxml.jackson.databind.util.AccessPattern.CONSTANT));
        org.junit.Assert.assertNotNull(nameTransformer41);
        org.junit.Assert.assertNotNull(atomicBooleanJsonDeserializer42);
        org.junit.Assert.assertNull(wildcardJsonDeserializer43);
        org.junit.Assert.assertNotNull(tokenBufferClass48);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertNull(wildcardFromStringDeserializer54);
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test368");
        com.fasterxml.jackson.databind.ext.SqlBlobSerializer sqlBlobSerializer0 = new com.fasterxml.jackson.databind.ext.SqlBlobSerializer();
        SerializerProvider serializerProvider1 = null;
        java.lang.reflect.Type type2 = null;
        JsonNode jsonNode3 = sqlBlobSerializer0.getSchema(serializerProvider1, type2);
        SerializerProvider serializerProvider4 = null;
        java.lang.reflect.Type type5 = null;
        JsonNode jsonNode7 = sqlBlobSerializer0.getSchema(serializerProvider4, type5, true);
        java.sql.Blob blob8 = null;
        boolean boolean9 = sqlBlobSerializer0.isEmpty(blob8);
        MapperFeature mapperFeature10 = MapperFeature.ALLOW_VOID_VALUED_PROPERTIES;
        JsonSerializer<?> wildcardJsonSerializer11 = sqlBlobSerializer0.withFilterId((Object) mapperFeature10);
        org.junit.Assert.assertNotNull(jsonNode3);
        org.junit.Assert.assertNotNull(jsonNode7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + mapperFeature10 + "' != '" + MapperFeature.ALLOW_VOID_VALUED_PROPERTIES + "'", mapperFeature10.equals(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES));
        org.junit.Assert.assertNotNull(wildcardJsonSerializer11);
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test369");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        JavaType javaType1 = null;
        com.fasterxml.jackson.databind.exc.MismatchedInputException mismatchedInputException3 = com.fasterxml.jackson.databind.exc.MismatchedInputException.from(jsonParser0, javaType1, "com.fasterxml.jackson.databind.JsonMappingException: ");
        Class<?> wildcardClass4 = mismatchedInputException3.getTargetType();
        org.junit.Assert.assertNotNull(mismatchedInputException3);
        org.junit.Assert.assertNull(wildcardClass4);
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test370");
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat0 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat2 = stdDateFormat0.withColonInTimeZone(false);
        java.text.NumberFormat numberFormat3 = null;
        stdDateFormat2.setNumberFormat(numberFormat3);
        stdDateFormat2.setLenient(true);
        java.util.TimeZone timeZone7 = com.fasterxml.jackson.databind.util.StdDateFormat.getDefaultTimeZone();
        stdDateFormat2.setTimeZone(timeZone7);
        org.junit.Assert.assertNotNull(stdDateFormat0);
        org.junit.Assert.assertNotNull(stdDateFormat2);
        org.junit.Assert.assertNotNull(timeZone7);
        org.junit.Assert.assertEquals(timeZone7.getDisplayName(), "Coordinated Universal Time");
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test371");
        DeserializationContext deserializationContext0 = null;
        JsonMappingException jsonMappingException2 = JsonMappingException.from(deserializationContext0, "");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature3 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES;
        jsonMappingException2.prependPath((Object) jsonNodeFeature3, 0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        String[] strArray11 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet12 = new java.util.LinkedHashSet<String>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<String>) strSet12, strArray11);
        String[] strArray15 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet16 = new java.util.LinkedHashSet<String>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<String>) strSet16, strArray15);
        JavaType javaType18 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer20 = null;
        JsonSerializer<Object> objJsonSerializer21 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer22 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer24 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet12, (java.util.Set<String>) strSet16, javaType18, false, typeSerializer20, objJsonSerializer21, objJsonSerializer22, (Object) 14);
        JsonSerializer<?> wildcardJsonSerializer25 = tokenBufferSerializer6.withIgnoredProperties((java.util.Set<String>) strSet12);
        jsonMappingException2.prependPath((Object) tokenBufferSerializer6, 0);
        java.util.Iterator<com.fasterxml.jackson.databind.ser.PropertyWriter> propertyWriterItor28 = tokenBufferSerializer6.properties();
        org.junit.Assert.assertNotNull(jsonMappingException2);
        org.junit.Assert.assertTrue("'" + jsonNodeFeature3 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES + "'", jsonNodeFeature3.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES));
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(strArray15);
        org.junit.Assert.assertArrayEquals(strArray15, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer21);
        org.junit.Assert.assertNotNull(objJsonSerializer22);
        org.junit.Assert.assertNotNull(mapSerializer24);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer25);
        org.junit.Assert.assertNotNull(propertyWriterItor28);
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test372");
        com.fasterxml.jackson.databind.node.IntNode intNode1 = new com.fasterxml.jackson.databind.node.IntNode((int) '4');
        boolean boolean2 = intNode1.isIntegralNumber();
        double double4 = intNode1.asDouble((double) (byte) 100);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 52.0d + "'", double4 == 52.0d);
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test373");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer3 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer3.createContextual(serializerProvider4, beanProperty5);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer7 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer(javaType0, false, typeSerializer2, (JsonSerializer<Object>) wildcardJsonSerializer6);
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer8 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer9 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer10 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer8, nameTransformer9);
        JsonSerializer<Object[]> objArrayJsonSerializer11 = objectArraySerializer7.unwrappingSerializer(nameTransformer10);
        DeserializationContext deserializationContext12 = null;
        PropertyName propertyName13 = PropertyName.NO_NAME;
        PropertyName propertyName15 = propertyName13.withNamespace("[null]");
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException17 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext12, propertyName13, javaType16);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty18 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference19 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer20 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass21 = tokenBufferSerializer20.handledType();
        boolean boolean22 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass21);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring24 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty18, unresolvedForwardReference19, tokenBufferClass21, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType25 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass21);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer27 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider28 = null;
        BeanProperty beanProperty29 = null;
        JsonSerializer<?> wildcardJsonSerializer30 = floatArraySerializer27.createContextual(serializerProvider28, beanProperty29);
        SerializerProvider serializerProvider31 = null;
        BeanProperty beanProperty32 = null;
        JsonSerializer<?> wildcardJsonSerializer33 = floatArraySerializer27.createContextual(serializerProvider31, beanProperty32);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver34 = null;
        BeanProperty beanProperty35 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer36 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver34, beanProperty35);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer37 = floatArraySerializer27._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer36);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer38 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType25, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer36);
        DeserializationContext deserializationContext39 = null;
        BeanProperty beanProperty40 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory41 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty42 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory41);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer43 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass44 = tokenBufferSerializer43.handledType();
        boolean boolean45 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass44);
        JavaType javaType47 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember48 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty42, tokenBufferClass44, "[null]", javaType47);
        JavaType javaType49 = null;
        KeyDeserializer keyDeserializer50 = null;
        JavaType javaType51 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer53 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType51, "hi!");
        boolean boolean54 = unsupportedTypeDeserializer53.isCachable();
        JavaType javaType55 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver56 = null;
        JavaType javaType59 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as60 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer61 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType55, typeIdResolver56, "`java.lang.Double`", true, javaType59, as60);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty62 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext39, beanProperty40, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember48, javaType49, keyDeserializer50, (JsonDeserializer<Object>) unsupportedTypeDeserializer53, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer61);
        java.lang.reflect.AnnotatedElement annotatedElement63 = virtualAnnotatedMember48.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams64 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode65 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator66 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams64, mode65);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector67 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName13, (JavaType) simpleType25, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember48, (Object) annotatedWithParams64);
        JsonSerializer<?> wildcardJsonSerializer69 = objectArraySerializer7._withResolved((BeanProperty) valueInjector67, (Boolean) true);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(nameTransformer10);
        org.junit.Assert.assertNotNull(objArrayJsonSerializer11);
        org.junit.Assert.assertNotNull(propertyName13);
        org.junit.Assert.assertNotNull(propertyName15);
        org.junit.Assert.assertNotNull(invalidNullException17);
        org.junit.Assert.assertNotNull(tokenBufferClass21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(simpleType25);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer30);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer33);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer37);
        org.junit.Assert.assertNotNull(tokenBufferClass44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty62);
        org.junit.Assert.assertNull(annotatedElement63);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer69);
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test374");
        DeserializationContext deserializationContext0 = null;
        BeanProperty beanProperty1 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty3 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory2);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass5);
        JavaType javaType8 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember9 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty3, tokenBufferClass5, "[null]", javaType8);
        JavaType javaType10 = null;
        KeyDeserializer keyDeserializer11 = null;
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer14 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType12, "hi!");
        boolean boolean15 = unsupportedTypeDeserializer14.isCachable();
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver17 = null;
        JavaType javaType20 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as21 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer22 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType16, typeIdResolver17, "`java.lang.Double`", true, javaType20, as21);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty23 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext0, beanProperty1, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember9, javaType10, keyDeserializer11, (JsonDeserializer<Object>) unsupportedTypeDeserializer14, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer22);
        DeserializationConfig deserializationConfig24 = null;
        Boolean boolean25 = unsupportedTypeDeserializer14.supportsUpdate(deserializationConfig24);
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty23);
        org.junit.Assert.assertNull(boolean25);
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test375");
        BeanDescription beanDescription0 = null;
        com.fasterxml.jackson.databind.ser.BeanSerializerBuilder beanSerializerBuilder1 = new com.fasterxml.jackson.databind.ser.BeanSerializerBuilder(beanDescription0);
        com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] beanPropertyWriterArray2 = new com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.ser.BeanPropertyWriter> beanPropertyWriterList3 = new java.util.ArrayList<com.fasterxml.jackson.databind.ser.BeanPropertyWriter>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.ser.BeanPropertyWriter>) beanPropertyWriterList3, beanPropertyWriterArray2);
        beanSerializerBuilder1.setProperties((java.util.List<com.fasterxml.jackson.databind.ser.BeanPropertyWriter>) beanPropertyWriterList3);
        org.junit.Assert.assertNotNull(beanPropertyWriterArray2);
        org.junit.Assert.assertArrayEquals(beanPropertyWriterArray2, new com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test376");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        JavaType javaType3 = typeFactory0.moreSpecificType(javaType1, javaType2);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty4 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference5 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass7);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring10 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty4, unresolvedForwardReference5, tokenBufferClass7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType11 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass7);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer12 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass13 = tokenBufferSerializer12.handledType();
        boolean boolean14 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass13);
        JavaType javaType15 = typeFactory0.findFirstTypeParameter((JavaType) simpleType11, tokenBufferClass13);
        boolean boolean16 = javaType15.hasHandlers();
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNull(javaType3);
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(simpleType11);
        org.junit.Assert.assertNotNull(tokenBufferClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(javaType15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test377");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        com.fasterxml.jackson.core.JsonParser.NumberType numberType2 = longNode1.numberType();
        double double3 = longNode1.doubleValue();
        org.junit.Assert.assertNotNull(longNode1);
        org.junit.Assert.assertTrue("'" + numberType2 + "' != '" + com.fasterxml.jackson.core.JsonParser.NumberType.LONG + "'", numberType2.equals(com.fasterxml.jackson.core.JsonParser.NumberType.LONG));
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 11.0d + "'", double3 == 11.0d);
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test378");
        String[] strArray4 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet5 = new java.util.LinkedHashSet<String>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<String>) strSet5, strArray4);
        String[] strArray8 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        JavaType javaType11 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer13 = null;
        JsonSerializer<Object> objJsonSerializer14 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer17 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet5, (java.util.Set<String>) strSet9, javaType11, false, typeSerializer13, objJsonSerializer14, objJsonSerializer15, (Object) 14);
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode18 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        SerializerProvider serializerProvider19 = null;
        boolean boolean20 = booleanNode18.isEmpty(serializerProvider19);
        boolean boolean21 = booleanNode18.canConvertToExactIntegral();
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer22 = mapSerializer17.withFilterId((Object) boolean21);
        JsonSerializer<?> wildcardJsonSerializer23 = mapSerializer22.getKeySerializer();
        SerializerProvider serializerProvider24 = null;
        com.fasterxml.jackson.databind.introspect.ObjectIdInfo objectIdInfo25 = com.fasterxml.jackson.databind.introspect.ObjectIdInfo.empty();
        Class<?> wildcardClass26 = objectIdInfo25.getScope();
        JsonNode jsonNode27 = mapSerializer22.getSchema(serializerProvider24, (java.lang.reflect.Type) wildcardClass26);
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertArrayEquals(strArray4, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer14);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(mapSerializer17);
        org.junit.Assert.assertNotNull(booleanNode18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(mapSerializer22);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer23);
        org.junit.Assert.assertNotNull(objectIdInfo25);
        org.junit.Assert.assertNotNull(wildcardClass26);
        org.junit.Assert.assertNotNull(jsonNode27);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test379");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNull();
        JsonNode jsonNode4 = doubleNode1.findPath("com.fasterxml.jackson.databind.util.TokenBuffer#[null]");
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(jsonNode4);
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test380");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder beanDeserializerBuilder0 = null;
        BeanDescription beanDescription1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty2 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference3 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass5);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring8 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty2, unresolvedForwardReference3, tokenBufferClass5, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType9 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass5);
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray11 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList12 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList12, settableBeanPropertyArray11);
        java.util.Map<String, java.util.List<PropertyName>> strMap14 = null;
        java.util.Locale locale15 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap16 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList12, strMap14, locale15);
        java.util.Map<String, java.util.List<PropertyName>> strMap18 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap19 = com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap.construct((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList12, false, strMap18);
        java.util.Map<String, com.fasterxml.jackson.databind.deser.SettableBeanProperty> strMap20 = null;
        java.util.Set<String> strSet21 = null;
        String[] strArray30 = new String[] { "`java.lang.Double`", "1.0", "[null]", "`java.lang.Double`", "''", "`java.lang.Double`", "com.fasterxml.jackson.databind.JsonMappingException: " };
        java.util.LinkedHashSet<String> strSet31 = new java.util.LinkedHashSet<String>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<String>) strSet31, strArray30);
        com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter serializeExceptFilter33 = new com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter((java.util.Set<String>) strSet31);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer35 = new com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer(beanDeserializerBuilder0, beanDescription1, (JavaType) simpleType9, beanPropertyMap19, strMap20, strSet21, false, (java.util.Set<String>) strSet31, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(simpleType9);
        org.junit.Assert.assertNotNull(settableBeanPropertyArray11);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray11, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(beanPropertyMap19);
        org.junit.Assert.assertNotNull(strArray30);
        org.junit.Assert.assertArrayEquals(strArray30, new String[] { "`java.lang.Double`", "1.0", "[null]", "`java.lang.Double`", "''", "`java.lang.Double`", "com.fasterxml.jackson.databind.JsonMappingException: " });
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test381");
        ObjectReader objectReader0 = null;
        ObjectReader[] objectReaderArray1 = new ObjectReader[] { objectReader0 };
        com.fasterxml.jackson.databind.deser.DataFormatReaders dataFormatReaders2 = new com.fasterxml.jackson.databind.deser.DataFormatReaders(objectReaderArray1);
        DeserializationConfig deserializationConfig3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.DataFormatReaders dataFormatReaders4 = dataFormatReaders2.with(deserializationConfig3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(objectReaderArray1);
        org.junit.Assert.assertArrayEquals(objectReaderArray1, new ObjectReader[] { null });
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test382");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        JavaType javaType3 = typeFactory0.moreSpecificType(javaType1, javaType2);
        com.fasterxml.jackson.databind.type.TypeModifier typeModifier4 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory5 = typeFactory0.withModifier(typeModifier4);
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNull(javaType3);
        org.junit.Assert.assertNotNull(typeFactory5);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test383");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ValueNode valueNode3 = jsonNodeFactory1.numberNode((Short) (short) 0);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = jsonNodeFactory1.arrayNode();
        com.fasterxml.jackson.databind.node.ValueNode valueNode6 = arrayNode4.numberNode((Integer) 3);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode8 = arrayNode4.add(2);
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
        org.junit.Assert.assertNotNull(valueNode6);
        org.junit.Assert.assertNotNull(arrayNode8);
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test384");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ValueNode valueNode3 = jsonNodeFactory1.numberNode((Short) (short) 0);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = jsonNodeFactory1.arrayNode();
        com.fasterxml.jackson.databind.node.ValueNode valueNode6 = jsonNodeFactory1.numberNode((Short) (short) 10);
        com.fasterxml.jackson.databind.node.ObjectNode objectNode7 = jsonNodeFactory1.objectNode();
        String str8 = objectNode7.asText();
        com.fasterxml.jackson.databind.node.ObjectNode objectNode11 = objectNode7.put("[NULL]", (Double) 0.0d);
        java.util.Set<java.util.Map.Entry<String, JsonNode>> strEntrySet12 = objectNode7.properties();
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
        org.junit.Assert.assertNotNull(valueNode6);
        org.junit.Assert.assertNotNull(objectNode7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertNotNull(objectNode11);
        org.junit.Assert.assertNotNull(strEntrySet12);
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test385");
        String[] strArray4 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet5 = new java.util.LinkedHashSet<String>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<String>) strSet5, strArray4);
        String[] strArray8 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        JavaType javaType11 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer13 = null;
        JsonSerializer<Object> objJsonSerializer14 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer17 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet5, (java.util.Set<String>) strSet9, javaType11, false, typeSerializer13, objJsonSerializer14, objJsonSerializer15, (Object) 14);
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode18 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        SerializerProvider serializerProvider19 = null;
        boolean boolean20 = booleanNode18.isEmpty(serializerProvider19);
        boolean boolean21 = booleanNode18.canConvertToExactIntegral();
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer22 = mapSerializer17.withFilterId((Object) boolean21);
        JavaType javaType23 = mapSerializer22.getContentType();
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertArrayEquals(strArray4, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer14);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(mapSerializer17);
        org.junit.Assert.assertNotNull(booleanNode18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(mapSerializer22);
        org.junit.Assert.assertNotNull(javaType23);
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test386");
        com.fasterxml.jackson.core.PrettyPrinter prettyPrinter0 = null;
        com.fasterxml.jackson.core.FormatSchema formatSchema1 = null;
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes2 = null;
        com.fasterxml.jackson.core.SerializableString serializableString3 = null;
        ObjectWriter.GeneratorSettings generatorSettings4 = new ObjectWriter.GeneratorSettings(prettyPrinter0, formatSchema1, characterEscapes2, serializableString3);
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test387");
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer0 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass1 = tokenBufferSerializer0.handledType();
        boolean boolean2 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass1);
        boolean boolean3 = com.fasterxml.jackson.databind.deser.std.DateDeserializers.hasDeserializerFor(tokenBufferClass1);
        org.junit.Assert.assertNotNull(tokenBufferClass1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test388");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer2 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType0, "hi!");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer3 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.type.LogicalType logicalType4 = atomicBooleanDeserializer3.logicalType();
        Object obj5 = atomicBooleanDeserializer3.getEmptyValue();
        // The following exception was thrown during execution in test generation
        try {
            JsonDeserializer<?> wildcardJsonDeserializer6 = unsupportedTypeDeserializer2.replaceDelegatee((JsonDeserializer<java.util.concurrent.atomic.AtomicBoolean>) atomicBooleanDeserializer3);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: null");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + logicalType4 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Boolean + "'", logicalType4.equals(com.fasterxml.jackson.databind.type.LogicalType.Boolean));
        org.junit.Assert.assertNull(obj5);
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test389");
        PropertyName propertyName0 = PropertyName.NO_NAME;
        PropertyName propertyName2 = propertyName0.withNamespace("[null]");
        PropertyName propertyName3 = propertyName0.internSimpleName();
        org.junit.Assert.assertNotNull(propertyName0);
        org.junit.Assert.assertNotNull(propertyName2);
        org.junit.Assert.assertNotNull(propertyName3);
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test390");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        Class<?> wildcardClass1 = atomicBooleanDeserializer0.getValueClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test391");
        DeserializationContext deserializationContext0 = null;
        PropertyName propertyName1 = PropertyName.NO_NAME;
        PropertyName propertyName3 = propertyName1.withNamespace("[null]");
        JavaType javaType4 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException5 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext0, propertyName1, javaType4);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty6 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference7 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer8 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass9 = tokenBufferSerializer8.handledType();
        boolean boolean10 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass9);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring12 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty6, unresolvedForwardReference7, tokenBufferClass9, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType13 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass9);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer15 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider16 = null;
        BeanProperty beanProperty17 = null;
        JsonSerializer<?> wildcardJsonSerializer18 = floatArraySerializer15.createContextual(serializerProvider16, beanProperty17);
        SerializerProvider serializerProvider19 = null;
        BeanProperty beanProperty20 = null;
        JsonSerializer<?> wildcardJsonSerializer21 = floatArraySerializer15.createContextual(serializerProvider19, beanProperty20);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver22 = null;
        BeanProperty beanProperty23 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer24 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver22, beanProperty23);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer25 = floatArraySerializer15._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer24);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer26 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType13, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer24);
        DeserializationContext deserializationContext27 = null;
        BeanProperty beanProperty28 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory29 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty30 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory29);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer31 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass32 = tokenBufferSerializer31.handledType();
        boolean boolean33 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass32);
        JavaType javaType35 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember36 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty30, tokenBufferClass32, "[null]", javaType35);
        JavaType javaType37 = null;
        KeyDeserializer keyDeserializer38 = null;
        JavaType javaType39 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer41 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType39, "hi!");
        boolean boolean42 = unsupportedTypeDeserializer41.isCachable();
        JavaType javaType43 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver44 = null;
        JavaType javaType47 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as48 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer49 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType43, typeIdResolver44, "`java.lang.Double`", true, javaType47, as48);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty50 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext27, beanProperty28, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember36, javaType37, keyDeserializer38, (JsonDeserializer<Object>) unsupportedTypeDeserializer41, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer49);
        java.lang.reflect.AnnotatedElement annotatedElement51 = virtualAnnotatedMember36.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams52 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode53 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator54 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams52, mode53);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector55 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName1, (JavaType) simpleType13, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember36, (Object) annotatedWithParams52);
        JavaType javaType57 = simpleType13.containedTypeOrUnknown(9);
        boolean boolean58 = simpleType13.isCollectionLikeType();
        org.junit.Assert.assertNotNull(propertyName1);
        org.junit.Assert.assertNotNull(propertyName3);
        org.junit.Assert.assertNotNull(invalidNullException5);
        org.junit.Assert.assertNotNull(tokenBufferClass9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(simpleType13);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer18);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer21);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer25);
        org.junit.Assert.assertNotNull(tokenBufferClass32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty50);
        org.junit.Assert.assertNull(annotatedElement51);
        org.junit.Assert.assertNotNull(javaType57);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test392");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.type.LogicalType logicalType1 = atomicBooleanDeserializer0.logicalType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator2 = atomicBooleanDeserializer0.getValueInstantiator();
        DeserializationContext deserializationContext3 = null;
        Object obj4 = atomicBooleanDeserializer0.getAbsentValue(deserializationContext3);
        DeserializationContext deserializationContext5 = null;
        Object obj6 = atomicBooleanDeserializer0.getEmptyValue(deserializationContext5);
        org.junit.Assert.assertTrue("'" + logicalType1 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Boolean + "'", logicalType1.equals(com.fasterxml.jackson.databind.type.LogicalType.Boolean));
        org.junit.Assert.assertNull(valueInstantiator2);
        org.junit.Assert.assertNull(obj4);
        org.junit.Assert.assertNotNull(obj6);
        org.junit.Assert.assertEquals(obj6.toString(), "false");
        org.junit.Assert.assertEquals(String.valueOf(obj6), "false");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj6), "false");
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test393");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        JavaType javaType3 = typeFactory0.moreSpecificType(javaType1, javaType2);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty4 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference5 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass7);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring10 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty4, unresolvedForwardReference5, tokenBufferClass7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType11 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass7);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer12 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass13 = tokenBufferSerializer12.handledType();
        boolean boolean14 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass13);
        JavaType javaType15 = typeFactory0.findFirstTypeParameter((JavaType) simpleType11, tokenBufferClass13);
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory16 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType17 = null;
        JavaType javaType18 = null;
        JavaType javaType19 = typeFactory16.moreSpecificType(javaType17, javaType18);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty20 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference21 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer22 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass23 = tokenBufferSerializer22.handledType();
        boolean boolean24 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass23);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring26 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty20, unresolvedForwardReference21, tokenBufferClass23, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType27 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass23);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer28 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass29 = tokenBufferSerializer28.handledType();
        boolean boolean30 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass29);
        JavaType javaType31 = typeFactory16.findFirstTypeParameter((JavaType) simpleType27, tokenBufferClass29);
        boolean boolean32 = simpleType11.isTypeOrSuperTypeOf(tokenBufferClass29);
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNull(javaType3);
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(simpleType11);
        org.junit.Assert.assertNotNull(tokenBufferClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(javaType15);
        org.junit.Assert.assertNotNull(typeFactory16);
        org.junit.Assert.assertNull(javaType19);
        org.junit.Assert.assertNotNull(tokenBufferClass23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(simpleType27);
        org.junit.Assert.assertNotNull(tokenBufferClass29);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNotNull(javaType31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test394");
        com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator laissezFaireSubTypeValidator0 = new com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator();
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test395");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0.createContextual(serializerProvider1, beanProperty2);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer4 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider5 = null;
        BeanProperty beanProperty6 = null;
        JsonSerializer<?> wildcardJsonSerializer7 = floatArraySerializer4.createContextual(serializerProvider5, beanProperty6);
        SerializerProvider serializerProvider8 = null;
        BeanProperty beanProperty9 = null;
        JsonSerializer<?> wildcardJsonSerializer10 = floatArraySerializer4.createContextual(serializerProvider8, beanProperty9);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver11 = null;
        BeanProperty beanProperty12 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer13 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver11, beanProperty12);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer14 = floatArraySerializer4._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer13);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer15 = floatArraySerializer0.withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer13);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer10);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer14);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer15);
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test396");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        JsonNode jsonNode3 = arrayNode1.get((int) (short) 100);
        java.util.Comparator<JsonNode> jsonNodeComparator4 = null;
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode5 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        SerializerProvider serializerProvider6 = null;
        boolean boolean7 = booleanNode5.isEmpty(serializerProvider6);
        boolean boolean8 = booleanNode5.asBoolean();
        boolean boolean9 = arrayNode1.equals(jsonNodeComparator4, (JsonNode) booleanNode5);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode10 = arrayNode1.removeAll();
        org.junit.Assert.assertNull(jsonNode3);
        org.junit.Assert.assertNotNull(booleanNode5);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(arrayNode10);
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test397");
        com.fasterxml.jackson.databind.ext.SqlBlobSerializer sqlBlobSerializer0 = new com.fasterxml.jackson.databind.ext.SqlBlobSerializer();
        SerializerProvider serializerProvider1 = null;
        java.lang.reflect.Type type2 = null;
        JsonNode jsonNode3 = sqlBlobSerializer0.getSchema(serializerProvider1, type2);
        boolean boolean4 = jsonNode3.isPojo();
        org.junit.Assert.assertNotNull(jsonNode3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test398");
        com.fasterxml.jackson.databind.node.LongNode longNode1 = com.fasterxml.jackson.databind.node.LongNode.valueOf((long) 11);
        java.math.BigInteger bigInteger2 = longNode1.bigIntegerValue();
        boolean boolean3 = longNode1.isFloat();
        org.junit.Assert.assertNotNull(longNode1);
        org.junit.Assert.assertNotNull(bigInteger2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test399");
        com.fasterxml.jackson.databind.cfg.ConstructorDetector constructorDetector0 = com.fasterxml.jackson.databind.cfg.ConstructorDetector.USE_DELEGATING;
        org.junit.Assert.assertNotNull(constructorDetector0);
    }

    @Test
    public void test400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test400");
        com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer0 = null;
        String[] strArray5 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet6 = new java.util.LinkedHashSet<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strSet6, strArray5);
        String[] strArray9 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet10 = new java.util.LinkedHashSet<String>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<String>) strSet10, strArray9);
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer14 = null;
        JsonSerializer<Object> objJsonSerializer15 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer16 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer18 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet6, (java.util.Set<String>) strSet10, javaType12, false, typeSerializer14, objJsonSerializer15, objJsonSerializer16, (Object) 14);
        com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>> strSetLinkedNode19 = null;
        com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>> strSetLinkedNode20 = new com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>>((java.util.AbstractSet<String>) strSet10, strSetLinkedNode19);
        String[] strArray25 = new String[] { "''", "''", "''", "" };
        java.util.LinkedHashSet<String> strSet26 = new java.util.LinkedHashSet<String>();
        boolean boolean27 = java.util.Collections.addAll((java.util.Collection<String>) strSet26, strArray25);
        String[] strArray29 = new String[] { "hi!" };
        java.util.LinkedHashSet<String> strSet30 = new java.util.LinkedHashSet<String>();
        boolean boolean31 = java.util.Collections.addAll((java.util.Collection<String>) strSet30, strArray29);
        JavaType javaType32 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer34 = null;
        JsonSerializer<Object> objJsonSerializer35 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        JsonSerializer<Object> objJsonSerializer36 = SerializerProvider.DEFAULT_NULL_KEY_SERIALIZER;
        com.fasterxml.jackson.databind.ser.std.MapSerializer mapSerializer38 = com.fasterxml.jackson.databind.ser.std.MapSerializer.construct((java.util.Set<String>) strSet26, (java.util.Set<String>) strSet30, javaType32, false, typeSerializer34, objJsonSerializer35, objJsonSerializer36, (Object) 14);
        com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>> strSetLinkedNode39 = null;
        com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>> strSetLinkedNode40 = new com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>>((java.util.AbstractSet<String>) strSet30, strSetLinkedNode39);
        com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>> strSetLinkedNode41 = new com.fasterxml.jackson.databind.util.LinkedNode<java.util.AbstractSet<String>>((java.util.AbstractSet<String>) strSet10, strSetLinkedNode39);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer builderBasedDeserializer42 = new com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer(builderBasedDeserializer0, (java.util.Set<String>) strSet10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
        org.junit.Assert.assertNotNull(mapSerializer18);
        org.junit.Assert.assertNotNull(strArray25);
        org.junit.Assert.assertArrayEquals(strArray25, new String[] { "''", "''", "''", "" });
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertNotNull(strArray29);
        org.junit.Assert.assertArrayEquals(strArray29, new String[] { "hi!" });
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(objJsonSerializer35);
        org.junit.Assert.assertNotNull(objJsonSerializer36);
        org.junit.Assert.assertNotNull(mapSerializer38);
    }

    @Test
    public void test401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test401");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty1 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory0);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass3);
        JavaType javaType6 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember7 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty1, tokenBufferClass3, "[null]", javaType6);
        com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer doubleSerializer8 = new com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer(tokenBufferClass3);
        String str10 = com.fasterxml.jackson.databind.util.ClassUtil.isLocalType(tokenBufferClass3, false);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test402");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.withExactBigDecimals(false);
        com.fasterxml.jackson.databind.node.ValueNode valueNode3 = jsonNodeFactory1.numberNode((Short) (short) 0);
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode4 = jsonNodeFactory1.arrayNode();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.ObjectNode objectNode6 = arrayNode4.withObject("com.fasterxml.jackson.databind.JsonMappingException: ");
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: `withObject(String)` not implemented by `com.fasterxml.jackson.databind.node.ArrayNode`");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonNodeFactory1);
        org.junit.Assert.assertNotNull(valueNode3);
        org.junit.Assert.assertNotNull(arrayNode4);
    }

    @Test
    public void test403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test403");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        JavaType javaType3 = typeFactory0.moreSpecificType(javaType1, javaType2);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty4 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference5 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass7);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring10 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty4, unresolvedForwardReference5, tokenBufferClass7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType11 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass7);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer12 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass13 = tokenBufferSerializer12.handledType();
        boolean boolean14 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass13);
        JavaType javaType15 = typeFactory0.findFirstTypeParameter((JavaType) simpleType11, tokenBufferClass13);
        boolean boolean16 = simpleType11.hasHandlers();
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNull(javaType3);
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(simpleType11);
        org.junit.Assert.assertNotNull(tokenBufferClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(javaType15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test404");
        com.fasterxml.jackson.databind.ext.SqlBlobSerializer sqlBlobSerializer0 = new com.fasterxml.jackson.databind.ext.SqlBlobSerializer();
        SerializerProvider serializerProvider1 = null;
        java.lang.reflect.Type type2 = null;
        JsonNode jsonNode3 = sqlBlobSerializer0.getSchema(serializerProvider1, type2);
        SerializerProvider serializerProvider4 = null;
        java.lang.reflect.Type type5 = null;
        JsonNode jsonNode7 = sqlBlobSerializer0.getSchema(serializerProvider4, type5, true);
        SerializerProvider serializerProvider8 = null;
        DeserializationContext deserializationContext9 = null;
        PropertyName propertyName10 = PropertyName.NO_NAME;
        PropertyName propertyName12 = propertyName10.withNamespace("[null]");
        JavaType javaType13 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException14 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext9, propertyName10, javaType13);
        DeserializationContext deserializationContext15 = null;
        PropertyName propertyName16 = PropertyName.NO_NAME;
        PropertyName propertyName18 = propertyName16.withNamespace("[null]");
        JavaType javaType19 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException20 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext15, propertyName16, javaType19);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty21 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference22 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer23 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass24 = tokenBufferSerializer23.handledType();
        boolean boolean25 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass24);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring27 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty21, unresolvedForwardReference22, tokenBufferClass24, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType28 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass24);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer30 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider31 = null;
        BeanProperty beanProperty32 = null;
        JsonSerializer<?> wildcardJsonSerializer33 = floatArraySerializer30.createContextual(serializerProvider31, beanProperty32);
        SerializerProvider serializerProvider34 = null;
        BeanProperty beanProperty35 = null;
        JsonSerializer<?> wildcardJsonSerializer36 = floatArraySerializer30.createContextual(serializerProvider34, beanProperty35);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver37 = null;
        BeanProperty beanProperty38 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer39 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver37, beanProperty38);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer40 = floatArraySerializer30._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer39);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer41 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType28, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer39);
        DeserializationContext deserializationContext42 = null;
        BeanProperty beanProperty43 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory44 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty45 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory44);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer46 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass47 = tokenBufferSerializer46.handledType();
        boolean boolean48 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass47);
        JavaType javaType50 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember51 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty45, tokenBufferClass47, "[null]", javaType50);
        JavaType javaType52 = null;
        KeyDeserializer keyDeserializer53 = null;
        JavaType javaType54 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer56 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType54, "hi!");
        boolean boolean57 = unsupportedTypeDeserializer56.isCachable();
        JavaType javaType58 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver59 = null;
        JavaType javaType62 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as63 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer64 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType58, typeIdResolver59, "`java.lang.Double`", true, javaType62, as63);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty65 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext42, beanProperty43, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember51, javaType52, keyDeserializer53, (JsonDeserializer<Object>) unsupportedTypeDeserializer56, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer64);
        java.lang.reflect.AnnotatedElement annotatedElement66 = virtualAnnotatedMember51.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams67 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode68 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator69 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams67, mode68);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector70 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName16, (JavaType) simpleType28, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember51, (Object) annotatedWithParams67);
        JavaType javaType72 = simpleType28.containedTypeOrUnknown(9);
        // The following exception was thrown during execution in test generation
        try {
            sqlBlobSerializer0.wrapAndThrow(serializerProvider8, (Throwable) invalidNullException14, (Object) 9, 2);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.databind.exc.InvalidNullException; message: Invalid `null` value encountered for property \"\"");
        } catch (com.fasterxml.jackson.databind.exc.InvalidNullException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonNode3);
        org.junit.Assert.assertNotNull(jsonNode7);
        org.junit.Assert.assertNotNull(propertyName10);
        org.junit.Assert.assertNotNull(propertyName12);
        org.junit.Assert.assertNotNull(invalidNullException14);
        org.junit.Assert.assertNotNull(propertyName16);
        org.junit.Assert.assertNotNull(propertyName18);
        org.junit.Assert.assertNotNull(invalidNullException20);
        org.junit.Assert.assertNotNull(tokenBufferClass24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(simpleType28);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer33);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer36);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer40);
        org.junit.Assert.assertNotNull(tokenBufferClass47);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty65);
        org.junit.Assert.assertNull(annotatedElement66);
        org.junit.Assert.assertNotNull(javaType72);
    }

    @Test
    public void test405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test405");
        com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder doubleBuilder0 = new com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder();
        double[] doubleArray1 = doubleBuilder0.resetAndStart();
        com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder doubleBuilder2 = new com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder();
        double[] doubleArray3 = doubleBuilder2.resetAndStart();
        double[] doubleArray5 = doubleBuilder0.appendCompletedChunk(doubleArray3, 6);
        double[] doubleArray6 = doubleBuilder0.resetAndStart();
        int int7 = doubleBuilder0.bufferedSize();
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertArrayEquals(doubleArray1, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray3);
        org.junit.Assert.assertArrayEquals(doubleArray3, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertArrayEquals(doubleArray5, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray6);
        org.junit.Assert.assertArrayEquals(doubleArray6, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test406");
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver0 = new com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver();
    }

    @Test
    public void test407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test407");
        com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer inetSocketAddressSerializer0 = new com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer1 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer2 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer3 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer1, nameTransformer2);
        JsonSerializer<java.net.InetSocketAddress> inetSocketAddressJsonSerializer4 = inetSocketAddressSerializer0.unwrappingSerializer(nameTransformer1);
        org.junit.Assert.assertNotNull(nameTransformer3);
        org.junit.Assert.assertNotNull(inetSocketAddressJsonSerializer4);
    }

    @Test
    public void test408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test408");
        com.fasterxml.jackson.databind.ser.std.CalendarSerializer calendarSerializer0 = new com.fasterxml.jackson.databind.ser.std.CalendarSerializer();
        boolean boolean1 = calendarSerializer0.isUnwrappingSerializer();
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat3 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat5 = stdDateFormat3.withColonInTimeZone(false);
        java.util.Calendar calendar6 = null;
        stdDateFormat5.setCalendar(calendar6);
        java.util.TimeZone timeZone8 = stdDateFormat5.getTimeZone();
        com.fasterxml.jackson.databind.ser.std.CalendarSerializer calendarSerializer9 = calendarSerializer0.withFormat((Boolean) false, (java.text.DateFormat) stdDateFormat5);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(stdDateFormat3);
        org.junit.Assert.assertNotNull(stdDateFormat5);
        org.junit.Assert.assertNull(timeZone8);
        org.junit.Assert.assertNotNull(calendarSerializer9);
    }

    @Test
    public void test409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test409");
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat0 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat2 = stdDateFormat0.withColonInTimeZone(false);
        java.util.Calendar calendar3 = null;
        stdDateFormat2.setCalendar(calendar3);
        java.util.TimeZone timeZone5 = stdDateFormat2.getTimeZone();
        java.util.Calendar calendar6 = null;
        stdDateFormat2.setCalendar(calendar6);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date9 = stdDateFormat2.parse("com.fasterxml.jackson.databind.util.TokenBuffer#[null]");
            org.junit.Assert.fail("Expected exception of type java.text.ParseException; message: Cannot parse date \"com.fasterxml.jackson.databind.util.TokenBuffer#[null]\": not compatible with any of standard forms (\"yyyy-MM-dd'T'HH:mm:ss.SSSX\", \"yyyy-MM-dd'T'HH:mm:ss.SSS\", \"EEE, dd MMM yyyy HH:mm:ss zzz\", \"yyyy-MM-dd\")");
        } catch (java.text.ParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stdDateFormat0);
        org.junit.Assert.assertNotNull(stdDateFormat2);
        org.junit.Assert.assertNull(timeZone5);
    }

    @Test
    public void test410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test410");
        PropertyName propertyName0 = PropertyName.NO_NAME;
        String str1 = propertyName0.toString();
        String str2 = com.fasterxml.jackson.databind.util.ClassUtil.name(propertyName0);
        org.junit.Assert.assertNotNull(propertyName0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "" + "'", str1, "");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "''" + "'", str2, "''");
    }

    @Test
    public void test411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test411");
        com.fasterxml.jackson.databind.util.LookupCache<JavaType, JsonDeserializer<Object>> javaTypeLookupCache0 = null;
        com.fasterxml.jackson.databind.deser.DeserializerCache deserializerCache1 = new com.fasterxml.jackson.databind.deser.DeserializerCache(javaTypeLookupCache0);
    }

    @Test
    public void test412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test412");
        DeserializationContext deserializationContext0 = null;
        JsonMappingException jsonMappingException2 = JsonMappingException.from(deserializationContext0, "");
        com.fasterxml.jackson.databind.cfg.JsonNodeFeature jsonNodeFeature3 = com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES;
        jsonMappingException2.prependPath((Object) jsonNodeFeature3, 0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.ClassUtil.throwAsIAE((Throwable) jsonMappingException2, "");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonMappingException2);
        org.junit.Assert.assertTrue("'" + jsonNodeFeature3 + "' != '" + com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES + "'", jsonNodeFeature3.equals(com.fasterxml.jackson.databind.cfg.JsonNodeFeature.WRITE_NULL_PROPERTIES));
    }

    @Test
    public void test413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test413");
        DeserializationContext deserializationContext0 = null;
        BeanProperty beanProperty1 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory2 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty3 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory2);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer4 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass5 = tokenBufferSerializer4.handledType();
        boolean boolean6 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass5);
        JavaType javaType8 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember9 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty3, tokenBufferClass5, "[null]", javaType8);
        JavaType javaType10 = null;
        KeyDeserializer keyDeserializer11 = null;
        JavaType javaType12 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer14 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType12, "hi!");
        boolean boolean15 = unsupportedTypeDeserializer14.isCachable();
        JavaType javaType16 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver17 = null;
        JavaType javaType20 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as21 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer22 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType16, typeIdResolver17, "`java.lang.Double`", true, javaType20, as21);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty23 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext0, beanProperty1, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember9, javaType10, keyDeserializer11, (JsonDeserializer<Object>) unsupportedTypeDeserializer14, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer22);
        PropertyMetadata.MergeInfo mergeInfo24 = PropertyMetadata.MergeInfo.createForTypeOverride((com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember9);
        org.junit.Assert.assertNotNull(tokenBufferClass5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty23);
        org.junit.Assert.assertNotNull(mergeInfo24);
    }

    @Test
    public void test414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test414");
        com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer xMLGregorianCalendarSerializer0 = new com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer();
        JsonSerializer<?> wildcardJsonSerializer1 = xMLGregorianCalendarSerializer0.getDelegatee();
        SerializerProvider serializerProvider2 = null;
        java.lang.reflect.Type type3 = null;
        JsonNode jsonNode5 = xMLGregorianCalendarSerializer0.getSchema(serializerProvider2, type3, true);
        Class<javax.xml.datatype.XMLGregorianCalendar> xMLGregorianCalendarClass6 = xMLGregorianCalendarSerializer0.handledType();
        String[] strArray17 = new String[] { "[NULL]", "''", "hi!", "com.fasterxml.jackson.databind.util.TokenBuffer#[null]", "`java.lang.Double`", "[null]", "", "1.0", "1.0", "52" };
        java.util.LinkedHashSet<String> strSet18 = new java.util.LinkedHashSet<String>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<String>) strSet18, strArray17);
        JsonSerializer<?> wildcardJsonSerializer20 = xMLGregorianCalendarSerializer0.withIgnoredProperties((java.util.Set<String>) strSet18);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer1);
        org.junit.Assert.assertNotNull(jsonNode5);
        org.junit.Assert.assertNotNull(xMLGregorianCalendarClass6);
        org.junit.Assert.assertNotNull(strArray17);
        org.junit.Assert.assertArrayEquals(strArray17, new String[] { "[NULL]", "''", "hi!", "com.fasterxml.jackson.databind.util.TokenBuffer#[null]", "`java.lang.Double`", "[null]", "", "1.0", "1.0", "52" });
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer20);
    }

    @Test
    public void test415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test415");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer3 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer3.createContextual(serializerProvider4, beanProperty5);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer7 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer(javaType0, false, typeSerializer2, (JsonSerializer<Object>) wildcardJsonSerializer6);
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer8 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer9 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer10 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer8, nameTransformer9);
        JsonSerializer<Object[]> objArrayJsonSerializer11 = objectArraySerializer7.unwrappingSerializer(nameTransformer10);
        BeanProperty beanProperty12 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer13 = null;
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer14 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        JsonSerializer<?> wildcardJsonSerializer15 = stringArraySerializer14.getContentSerializer();
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer16 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer17 = stringArraySerializer14.withValueTypeSerializer(typeSerializer16);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer19 = objectArraySerializer7.withResolved(beanProperty12, typeSerializer13, (JsonSerializer<Object>) wildcardContainerSerializer17, (Boolean) true);
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer20 = null;
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer21 = objectArraySerializer7._withValueTypeSerializer(typeSerializer20);
        Class<Object[]> objArrayClass22 = objectArraySerializer7.handledType();
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(nameTransformer10);
        org.junit.Assert.assertNotNull(objArrayJsonSerializer11);
        org.junit.Assert.assertNotNull(stringArraySerializer14);
        org.junit.Assert.assertNull(wildcardJsonSerializer15);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer17);
        org.junit.Assert.assertNotNull(objectArraySerializer19);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer21);
        org.junit.Assert.assertNotNull(objArrayClass22);
    }

    @Test
    public void test416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test416");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer2 = null;
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer3 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer3.createContextual(serializerProvider4, beanProperty5);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer7 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer(javaType0, false, typeSerializer2, (JsonSerializer<Object>) wildcardJsonSerializer6);
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer8 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer9 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer10 = com.fasterxml.jackson.databind.util.NameTransformer.chainedTransformer(nameTransformer8, nameTransformer9);
        JsonSerializer<Object[]> objArrayJsonSerializer11 = objectArraySerializer7.unwrappingSerializer(nameTransformer10);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver12 = null;
        BeanProperty beanProperty13 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer14 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver12, beanProperty13);
        com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer objectArraySerializer15 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer(objectArraySerializer7, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer14);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(nameTransformer10);
        org.junit.Assert.assertNotNull(objArrayJsonSerializer11);
    }

    @Test
    public void test417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test417");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty4 = null;
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer5 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (byte) 1, objectIdReader3, settableAnyProperty4);
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat7 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        propertyValueBuffer5.bufferMapProperty((Object) "hi!", (Object) stdDateFormat7);
        java.text.ParsePosition parsePosition10 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date11 = stdDateFormat7.parse("com.fasterxml.jackson.databind.JsonMappingException: ", parsePosition10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stdDateFormat7);
    }

    @Test
    public void test418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test418");
        com.fasterxml.jackson.databind.deser.std.DateDeserializers.TimestampDeserializer timestampDeserializer0 = new com.fasterxml.jackson.databind.deser.std.DateDeserializers.TimestampDeserializer();
    }

    @Test
    public void test419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test419");
        DeserializationConfig deserializationConfig0 = null;
        com.fasterxml.jackson.databind.introspect.AnnotatedClass annotatedClass1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.EnumResolver enumResolver2 = com.fasterxml.jackson.databind.util.EnumResolver.constructUsingIndex(deserializationConfig0, annotatedClass1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test420");
        com.fasterxml.jackson.databind.deser.SettableBeanProperty[] settableBeanPropertyArray1 = new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {};
        java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyList2 = new java.util.ArrayList<com.fasterxml.jackson.databind.deser.SettableBeanProperty>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, settableBeanPropertyArray1);
        java.util.Map<String, java.util.List<PropertyName>> strMap4 = null;
        java.util.Locale locale5 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap6 = new com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap(true, (java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, strMap4, locale5);
        java.util.Map<String, java.util.List<PropertyName>> strMap8 = null;
        com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap beanPropertyMap9 = com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap.construct((java.util.Collection<com.fasterxml.jackson.databind.deser.SettableBeanProperty>) settableBeanPropertyList2, false, strMap8);
        java.util.Iterator<com.fasterxml.jackson.databind.deser.SettableBeanProperty> settableBeanPropertyItor10 = beanPropertyMap9.iterator();
        org.junit.Assert.assertNotNull(settableBeanPropertyArray1);
        org.junit.Assert.assertArrayEquals(settableBeanPropertyArray1, new com.fasterxml.jackson.databind.deser.SettableBeanProperty[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(beanPropertyMap9);
        org.junit.Assert.assertNotNull(settableBeanPropertyItor10);
    }

    @Test
    public void test421() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test421");
        byte[] byteArray3 = new byte[] { (byte) 0, (byte) 100, (byte) -1 };
        com.fasterxml.jackson.databind.node.BinaryNode binaryNode4 = com.fasterxml.jackson.databind.node.BinaryNode.valueOf(byteArray3);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 0, (byte) 100, (byte) -1 });
        org.junit.Assert.assertNotNull(binaryNode4);
    }

    @Test
    public void test422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test422");
        com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer atomicBooleanDeserializer0 = new com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer();
        com.fasterxml.jackson.databind.type.LogicalType logicalType1 = atomicBooleanDeserializer0.logicalType();
        Object obj2 = atomicBooleanDeserializer0.getEmptyValue();
        java.util.Collection<Object> objCollection3 = atomicBooleanDeserializer0.getKnownPropertyNames();
        DeserializationConfig deserializationConfig4 = null;
        Boolean boolean5 = atomicBooleanDeserializer0.supportsUpdate(deserializationConfig4);
        org.junit.Assert.assertTrue("'" + logicalType1 + "' != '" + com.fasterxml.jackson.databind.type.LogicalType.Boolean + "'", logicalType1.equals(com.fasterxml.jackson.databind.type.LogicalType.Boolean));
        org.junit.Assert.assertNull(obj2);
        org.junit.Assert.assertNull(objCollection3);
        org.junit.Assert.assertEquals("'" + boolean5 + "' != '" + false + "'", boolean5, false);
    }

    @Test
    public void test423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test423");
        com.fasterxml.jackson.databind.node.JsonNodeFactory jsonNodeFactory0 = null;
        com.fasterxml.jackson.databind.node.ArrayNode arrayNode1 = new com.fasterxml.jackson.databind.node.ArrayNode(jsonNodeFactory0);
        byte[] byteArray2 = new byte[] {};
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.node.BinaryNode binaryNode5 = arrayNode1.binaryNode(byteArray2, 1, 5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
    }

    @Test
    public void test424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test424");
        com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer calendarDeserializer0 = new com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer();
        DeserializationContext deserializationContext1 = null;
        java.util.Calendar calendar2 = calendarDeserializer0.getNullValue(deserializationContext1);
        DeserializationConfig deserializationConfig3 = null;
        Boolean boolean4 = calendarDeserializer0.supportsUpdate(deserializationConfig3);
        DeserializationContext deserializationContext5 = null;
        Object obj6 = calendarDeserializer0.getEmptyValue(deserializationContext5);
        org.junit.Assert.assertNull(calendar2);
        org.junit.Assert.assertEquals("'" + boolean4 + "' != '" + false + "'", boolean4, false);
        org.junit.Assert.assertNotNull(obj6);
        org.junit.Assert.assertEquals(obj6.toString(), "java.util.GregorianCalendar[time=0,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Australia/Sydney\",offset=36000000,dstSavings=3600000,useDaylight=true,transitions=142,lastRule=java.util.SimpleTimeZone[id=Australia/Sydney,offset=36000000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=9,startDay=1,startDayOfWeek=1,startTime=7200000,startTimeMode=1,endMode=3,endMonth=3,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=1]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=1,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=36000000,DST_OFFSET=0]");
        org.junit.Assert.assertEquals(String.valueOf(obj6), "java.util.GregorianCalendar[time=0,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Australia/Sydney\",offset=36000000,dstSavings=3600000,useDaylight=true,transitions=142,lastRule=java.util.SimpleTimeZone[id=Australia/Sydney,offset=36000000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=9,startDay=1,startDayOfWeek=1,startTime=7200000,startTimeMode=1,endMode=3,endMonth=3,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=1]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=1,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=36000000,DST_OFFSET=0]");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj6), "java.util.GregorianCalendar[time=0,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Australia/Sydney\",offset=36000000,dstSavings=3600000,useDaylight=true,transitions=142,lastRule=java.util.SimpleTimeZone[id=Australia/Sydney,offset=36000000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=9,startDay=1,startDayOfWeek=1,startTime=7200000,startTimeMode=1,endMode=3,endMonth=3,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=1]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=1,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=36000000,DST_OFFSET=0]");
    }

    @Test
    public void test425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test425");
        com.fasterxml.jackson.databind.cfg.ConstructorDetector constructorDetector0 = com.fasterxml.jackson.databind.cfg.ConstructorDetector.DEFAULT;
        boolean boolean1 = constructorDetector0.allowJDKTypeConstructors();
        org.junit.Assert.assertNotNull(constructorDetector0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test426");
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory0 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType1 = null;
        JavaType javaType2 = null;
        JavaType javaType3 = typeFactory0.moreSpecificType(javaType1, javaType2);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty4 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference5 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer6 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass7 = tokenBufferSerializer6.handledType();
        boolean boolean8 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass7);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring10 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty4, unresolvedForwardReference5, tokenBufferClass7, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType11 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass7);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer12 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass13 = tokenBufferSerializer12.handledType();
        boolean boolean14 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass13);
        JavaType javaType15 = typeFactory0.findFirstTypeParameter((JavaType) simpleType11, tokenBufferClass13);
        com.fasterxml.jackson.databind.type.TypeBindings typeBindings16 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory17 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType18 = null;
        JavaType javaType19 = null;
        JavaType javaType20 = typeFactory17.moreSpecificType(javaType18, javaType19);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty21 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference22 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer23 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass24 = tokenBufferSerializer23.handledType();
        boolean boolean25 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass24);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring27 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty21, unresolvedForwardReference22, tokenBufferClass24, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType28 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass24);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer29 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass30 = tokenBufferSerializer29.handledType();
        boolean boolean31 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass30);
        JavaType javaType32 = typeFactory17.findFirstTypeParameter((JavaType) simpleType28, tokenBufferClass30);
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory33 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType34 = null;
        JavaType javaType35 = null;
        JavaType javaType36 = typeFactory33.moreSpecificType(javaType34, javaType35);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty37 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference38 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer39 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass40 = tokenBufferSerializer39.handledType();
        boolean boolean41 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass40);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring43 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty37, unresolvedForwardReference38, tokenBufferClass40, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType44 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass40);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer45 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass46 = tokenBufferSerializer45.handledType();
        boolean boolean47 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass46);
        JavaType javaType48 = typeFactory33.findFirstTypeParameter((JavaType) simpleType44, tokenBufferClass46);
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory49 = com.fasterxml.jackson.databind.type.TypeFactory.createDefaultInstance();
        JavaType javaType50 = null;
        JavaType javaType51 = null;
        JavaType javaType52 = typeFactory49.moreSpecificType(javaType50, javaType51);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty53 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference54 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer55 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass56 = tokenBufferSerializer55.handledType();
        boolean boolean57 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass56);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring59 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty53, unresolvedForwardReference54, tokenBufferClass56, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType60 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass56);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer61 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass62 = tokenBufferSerializer61.handledType();
        boolean boolean63 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass62);
        JavaType javaType64 = typeFactory49.findFirstTypeParameter((JavaType) simpleType60, tokenBufferClass62);
        boolean boolean65 = simpleType44.isTypeOrSuperTypeOf(tokenBufferClass62);
        JavaType[] javaTypeArray66 = new JavaType[] { simpleType44 };
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer67 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base base68 = new com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base();
        JavaType javaType69 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor jsonIntegerFormatVisitor70 = base68.expectIntegerFormat(javaType69);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty71 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference72 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer73 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass74 = tokenBufferSerializer73.handledType();
        boolean boolean75 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass74);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring77 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty71, unresolvedForwardReference72, tokenBufferClass74, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType78 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass74);
        floatArraySerializer67.acceptJsonFormatVisitor((com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper) base68, (JavaType) simpleType78);
        com.fasterxml.jackson.databind.type.ReferenceType referenceType80 = com.fasterxml.jackson.databind.type.ReferenceType.construct(tokenBufferClass13, typeBindings16, javaType32, javaTypeArray66, (JavaType) simpleType78);
        org.junit.Assert.assertNotNull(typeFactory0);
        org.junit.Assert.assertNull(javaType3);
        org.junit.Assert.assertNotNull(tokenBufferClass7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(simpleType11);
        org.junit.Assert.assertNotNull(tokenBufferClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(javaType15);
        org.junit.Assert.assertNotNull(typeFactory17);
        org.junit.Assert.assertNull(javaType20);
        org.junit.Assert.assertNotNull(tokenBufferClass24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(simpleType28);
        org.junit.Assert.assertNotNull(tokenBufferClass30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(javaType32);
        org.junit.Assert.assertNotNull(typeFactory33);
        org.junit.Assert.assertNull(javaType36);
        org.junit.Assert.assertNotNull(tokenBufferClass40);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNotNull(simpleType44);
        org.junit.Assert.assertNotNull(tokenBufferClass46);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertNotNull(javaType48);
        org.junit.Assert.assertNotNull(typeFactory49);
        org.junit.Assert.assertNull(javaType52);
        org.junit.Assert.assertNotNull(tokenBufferClass56);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNotNull(simpleType60);
        org.junit.Assert.assertNotNull(tokenBufferClass62);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertNotNull(javaType64);
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + true + "'", boolean65 == true);
        org.junit.Assert.assertNotNull(javaTypeArray66);
        org.junit.Assert.assertNull(jsonIntegerFormatVisitor70);
        org.junit.Assert.assertNotNull(tokenBufferClass74);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertNotNull(simpleType78);
        org.junit.Assert.assertNotNull(referenceType80);
    }

    @Test
    public void test427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test427");
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams0 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode1 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator2 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams0, mode1);
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode3 = potentialCreator2.creatorMode();
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode4 = potentialCreator2.creatorMode();
        org.junit.Assert.assertTrue("'" + mode3 + "' != '" + com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT + "'", mode3.equals(com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT));
        org.junit.Assert.assertTrue("'" + mode4 + "' != '" + com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT + "'", mode4.equals(com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT));
    }

    @Test
    public void test428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test428");
        com.fasterxml.jackson.databind.ser.impl.StringArraySerializer stringArraySerializer0 = com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.instance;
        com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder doubleBuilder1 = new com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder();
        double[] doubleArray2 = doubleBuilder1.resetAndStart();
        int int3 = doubleBuilder1.bufferedSize();
        double[] doubleArray5 = doubleBuilder1._constructArray((int) (byte) 0);
        JsonSerializer<?> wildcardJsonSerializer6 = stringArraySerializer0.withFilterId((Object) (byte) 0);
        org.junit.Assert.assertNotNull(stringArraySerializer0);
        org.junit.Assert.assertNotNull(doubleArray2);
        org.junit.Assert.assertArrayEquals(doubleArray2, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertArrayEquals(doubleArray5, new double[] {}, 1.0E-15);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
    }

    @Test
    public void test429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test429");
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams0 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode1 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator2 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams0, mode1);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter annotatedParameter4 = potentialCreator2.param((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test430");
        com.fasterxml.jackson.core.JsonParser jsonParser0 = null;
        DeserializationContext deserializationContext1 = null;
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReader objectIdReader3 = null;
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty4 = null;
        com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer propertyValueBuffer5 = new com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer(jsonParser0, deserializationContext1, (int) (byte) 1, objectIdReader3, settableAnyProperty4);
        com.fasterxml.jackson.databind.util.StdDateFormat stdDateFormat7 = com.fasterxml.jackson.databind.util.StdDateFormat.instance;
        propertyValueBuffer5.bufferMapProperty((Object) "hi!", (Object) stdDateFormat7);
        java.text.NumberFormat numberFormat9 = null;
        stdDateFormat7.setNumberFormat(numberFormat9);
        org.junit.Assert.assertNotNull(stdDateFormat7);
    }

    @Test
    public void test431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test431");
        com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder doubleBuilder0 = new com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder();
        double[] doubleArray1 = doubleBuilder0.resetAndStart();
        int int2 = doubleBuilder0.bufferedSize();
        double[] doubleArray4 = doubleBuilder0._constructArray((int) (byte) 0);
        int int5 = doubleBuilder0.bufferedSize();
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertArrayEquals(doubleArray1, new double[] { 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertArrayEquals(doubleArray4, new double[] {}, 1.0E-15);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test432");
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer0 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider1 = null;
        BeanProperty beanProperty2 = null;
        JsonSerializer<?> wildcardJsonSerializer3 = floatArraySerializer0.createContextual(serializerProvider1, beanProperty2);
        SerializerProvider serializerProvider4 = null;
        BeanProperty beanProperty5 = null;
        JsonSerializer<?> wildcardJsonSerializer6 = floatArraySerializer0.createContextual(serializerProvider4, beanProperty5);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver7 = null;
        BeanProperty beanProperty8 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer9 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver7, beanProperty8);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer10 = floatArraySerializer0._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer9);
        JsonSerializer<?> wildcardJsonSerializer11 = floatArraySerializer0.getDelegatee();
        org.junit.Assert.assertNotNull(wildcardJsonSerializer3);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer6);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer10);
        org.junit.Assert.assertNull(wildcardJsonSerializer11);
    }

    @Test
    public void test433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test433");
        JavaType javaType0 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer2 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType0, "hi!");
        com.fasterxml.jackson.databind.util.AccessPattern accessPattern3 = unsupportedTypeDeserializer2.getEmptyAccessPattern();
        com.fasterxml.jackson.core.JsonParser jsonParser4 = null;
        DeserializationContext deserializationContext5 = null;
        // The following exception was thrown during execution in test generation
        try {
            Object obj6 = unsupportedTypeDeserializer2.deserialize(jsonParser4, deserializationContext5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonParser.currentToken()Lcom/fasterxml/jackson/core/JsonToken;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + accessPattern3 + "' != '" + com.fasterxml.jackson.databind.util.AccessPattern.DYNAMIC + "'", accessPattern3.equals(com.fasterxml.jackson.databind.util.AccessPattern.DYNAMIC));
    }

    @Test
    public void test434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test434");
        com.fasterxml.jackson.databind.node.DoubleNode doubleNode1 = com.fasterxml.jackson.databind.node.DoubleNode.valueOf((double) 1);
        boolean boolean2 = doubleNode1.isNaN();
        long long3 = doubleNode1.longValue();
        boolean boolean5 = doubleNode1.hasNonNull("com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.core.JsonParser.NumberType numberType6 = doubleNode1.numberType();
        org.junit.Assert.assertNotNull(doubleNode1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 1L + "'", long3 == 1L);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + numberType6 + "' != '" + com.fasterxml.jackson.core.JsonParser.NumberType.DOUBLE + "'", numberType6.equals(com.fasterxml.jackson.core.JsonParser.NumberType.DOUBLE));
    }

    @Test
    public void test435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test435");
        com.fasterxml.jackson.databind.node.BooleanNode booleanNode0 = com.fasterxml.jackson.databind.node.BooleanNode.TRUE;
        boolean boolean1 = booleanNode0.isBinary();
        boolean boolean2 = booleanNode0.isTextual();
        String[] strArray5 = new String[] { "" };
        java.util.ArrayList<String> strList6 = new java.util.ArrayList<String>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<String>) strList6, strArray5);
        java.util.List<String> strList8 = booleanNode0.findValuesAsText("", (java.util.List<String>) strList6);
        String str9 = booleanNode0.textValue();
        boolean boolean10 = booleanNode0.isObject();
        org.junit.Assert.assertNotNull(booleanNode0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new String[] { "" });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(strList8);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test436");
        com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value value2 = new com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value("`java.lang.Double`", "1.0");
    }

    @Test
    public void test437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test437");
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty0 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference1 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer2 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass3 = tokenBufferSerializer2.handledType();
        boolean boolean4 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass3);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring6 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty0, unresolvedForwardReference1, tokenBufferClass3, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType7 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass3);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer9 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider10 = null;
        BeanProperty beanProperty11 = null;
        JsonSerializer<?> wildcardJsonSerializer12 = floatArraySerializer9.createContextual(serializerProvider10, beanProperty11);
        SerializerProvider serializerProvider13 = null;
        BeanProperty beanProperty14 = null;
        JsonSerializer<?> wildcardJsonSerializer15 = floatArraySerializer9.createContextual(serializerProvider13, beanProperty14);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver16 = null;
        BeanProperty beanProperty17 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer18 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver16, beanProperty17);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer19 = floatArraySerializer9._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer18);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer20 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType7, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer18);
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory22 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty23 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory22);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer24 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass25 = tokenBufferSerializer24.handledType();
        boolean boolean26 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass25);
        JavaType javaType28 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember29 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty23, tokenBufferClass25, "[null]", javaType28);
        com.fasterxml.jackson.databind.deser.std.FromStringDeserializer<?> wildcardFromStringDeserializer30 = com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.findDeserializer(tokenBufferClass25);
        com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default default31 = new com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default(0, tokenBufferClass25);
        com.fasterxml.jackson.databind.type.TypeBindings typeBindings32 = null;
        DeserializationContext deserializationContext33 = null;
        PropertyName propertyName34 = PropertyName.NO_NAME;
        PropertyName propertyName36 = propertyName34.withNamespace("[null]");
        JavaType javaType37 = null;
        com.fasterxml.jackson.databind.exc.InvalidNullException invalidNullException38 = com.fasterxml.jackson.databind.exc.InvalidNullException.from(deserializationContext33, propertyName34, javaType37);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty objectIdReferenceProperty39 = null;
        com.fasterxml.jackson.databind.deser.UnresolvedForwardReference unresolvedForwardReference40 = null;
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer41 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass42 = tokenBufferSerializer41.handledType();
        boolean boolean43 = com.fasterxml.jackson.databind.util.BeanUtil.isJodaTimeClass(tokenBufferClass42);
        com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring propertyReferring45 = new com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring(objectIdReferenceProperty39, unresolvedForwardReference40, tokenBufferClass42, (Object) "com.fasterxml.jackson.databind.JsonMappingException: ");
        com.fasterxml.jackson.databind.type.SimpleType simpleType46 = com.fasterxml.jackson.databind.type.SimpleType.construct(tokenBufferClass42);
        com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer floatArraySerializer48 = new com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer();
        SerializerProvider serializerProvider49 = null;
        BeanProperty beanProperty50 = null;
        JsonSerializer<?> wildcardJsonSerializer51 = floatArraySerializer48.createContextual(serializerProvider49, beanProperty50);
        SerializerProvider serializerProvider52 = null;
        BeanProperty beanProperty53 = null;
        JsonSerializer<?> wildcardJsonSerializer54 = floatArraySerializer48.createContextual(serializerProvider52, beanProperty53);
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver55 = null;
        BeanProperty beanProperty56 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer asArrayTypeSerializer57 = new com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer(typeIdResolver55, beanProperty56);
        com.fasterxml.jackson.databind.ser.ContainerSerializer<?> wildcardContainerSerializer58 = floatArraySerializer48._withValueTypeSerializer((com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer57);
        com.fasterxml.jackson.databind.ser.std.IterableSerializer iterableSerializer59 = new com.fasterxml.jackson.databind.ser.std.IterableSerializer((JavaType) simpleType46, false, (com.fasterxml.jackson.databind.jsontype.TypeSerializer) asArrayTypeSerializer57);
        DeserializationContext deserializationContext60 = null;
        BeanProperty beanProperty61 = null;
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory62 = null;
        com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty empty63 = new com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty(typeFactory62);
        com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer tokenBufferSerializer64 = new com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer();
        Class<com.fasterxml.jackson.databind.util.TokenBuffer> tokenBufferClass65 = tokenBufferSerializer64.handledType();
        boolean boolean66 = com.fasterxml.jackson.databind.util.ClassUtil.isNonStaticInnerClass(tokenBufferClass65);
        JavaType javaType68 = null;
        com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember virtualAnnotatedMember69 = new com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember((com.fasterxml.jackson.databind.introspect.TypeResolutionContext) empty63, tokenBufferClass65, "[null]", javaType68);
        JavaType javaType70 = null;
        KeyDeserializer keyDeserializer71 = null;
        JavaType javaType72 = null;
        com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer unsupportedTypeDeserializer74 = new com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer(javaType72, "hi!");
        boolean boolean75 = unsupportedTypeDeserializer74.isCachable();
        JavaType javaType76 = null;
        com.fasterxml.jackson.databind.jsontype.TypeIdResolver typeIdResolver77 = null;
        JavaType javaType80 = null;
        com.fasterxml.jackson.annotation.JsonTypeInfo.As as81 = null;
        com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer asPropertyTypeDeserializer82 = new com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer(javaType76, typeIdResolver77, "`java.lang.Double`", true, javaType80, as81);
        com.fasterxml.jackson.databind.deser.SettableAnyProperty settableAnyProperty83 = com.fasterxml.jackson.databind.deser.SettableAnyProperty.constructForMethod(deserializationContext60, beanProperty61, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember69, javaType70, keyDeserializer71, (JsonDeserializer<Object>) unsupportedTypeDeserializer74, (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) asPropertyTypeDeserializer82);
        java.lang.reflect.AnnotatedElement annotatedElement84 = virtualAnnotatedMember69.getAnnotated();
        com.fasterxml.jackson.databind.introspect.AnnotatedWithParams annotatedWithParams85 = null;
        com.fasterxml.jackson.annotation.JsonCreator.Mode mode86 = null;
        com.fasterxml.jackson.databind.introspect.PotentialCreator potentialCreator87 = new com.fasterxml.jackson.databind.introspect.PotentialCreator(annotatedWithParams85, mode86);
        com.fasterxml.jackson.databind.deser.impl.ValueInjector valueInjector88 = new com.fasterxml.jackson.databind.deser.impl.ValueInjector(propertyName34, (JavaType) simpleType46, (com.fasterxml.jackson.databind.introspect.AnnotatedMember) virtualAnnotatedMember69, (Object) annotatedWithParams85);
        JavaType javaType90 = simpleType46.containedTypeOrUnknown(9);
        JavaType[] javaTypeArray91 = null;
        JavaType javaType92 = simpleType7.refine(tokenBufferClass25, typeBindings32, javaType90, javaTypeArray91);
        org.junit.Assert.assertNotNull(tokenBufferClass3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(simpleType7);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer12);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer15);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer19);
        org.junit.Assert.assertNotNull(tokenBufferClass25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNull(wildcardFromStringDeserializer30);
        org.junit.Assert.assertNotNull(propertyName34);
        org.junit.Assert.assertNotNull(propertyName36);
        org.junit.Assert.assertNotNull(invalidNullException38);
        org.junit.Assert.assertNotNull(tokenBufferClass42);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(simpleType46);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer51);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer54);
        org.junit.Assert.assertNotNull(wildcardContainerSerializer58);
        org.junit.Assert.assertNotNull(tokenBufferClass65);
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertNotNull(settableAnyProperty83);
        org.junit.Assert.assertNull(annotatedElement84);
        org.junit.Assert.assertNotNull(javaType90);
        org.junit.Assert.assertNull(javaType92);
    }
}

